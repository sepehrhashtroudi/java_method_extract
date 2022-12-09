public FieldLUDecomposition(FieldMatrix<T> matrix) { [EOL]     if (!matrix.isSquare()) { [EOL]         throw new NonSquareMatrixException(matrix.getRowDimension(), matrix.getColumnDimension()); [EOL]     } [EOL]     final int m = matrix.getColumnDimension(); [EOL]     field = matrix.getField(); [EOL]     lu = matrix.getData(); [EOL]     pivot = new int[m]; [EOL]     cachedL = null; [EOL]     cachedU = null; [EOL]     cachedP = null; [EOL]     for (int row = 0; row < m; row++) { [EOL]         pivot[row] = row; [EOL]     } [EOL]     even = true; [EOL]     singular = false; [EOL]     for (int col = 0; col < m; col++) { [EOL]         T sum = field.getZero(); [EOL]         for (int row = 0; row < col; row++) { [EOL]             final T[] luRow = lu[row]; [EOL]             sum = luRow[col]; [EOL]             for (int i = 0; i < row; i++) { [EOL]                 sum = sum.subtract(luRow[i].multiply(lu[i][col])); [EOL]             } [EOL]             luRow[col] = sum; [EOL]         } [EOL]         int nonZero = col; [EOL]         for (int row = col; row < m; row++) { [EOL]             final T[] luRow = lu[row]; [EOL]             sum = luRow[col]; [EOL]             for (int i = 0; i < col; i++) { [EOL]                 sum = sum.subtract(luRow[i].multiply(lu[i][col])); [EOL]             } [EOL]             luRow[col] = sum; [EOL]             if (lu[nonZero][col].equals(field.getZero())) { [EOL]                 ++nonZero; [EOL]             } [EOL]         } [EOL]         if (nonZero >= m) { [EOL]             singular = true; [EOL]             return; [EOL]         } [EOL]         if (nonZero != col) { [EOL]             T tmp = field.getZero(); [EOL]             for (int i = 0; i < m; i++) { [EOL]                 tmp = lu[nonZero][i]; [EOL]                 lu[nonZero][i] = lu[col][i]; [EOL]                 lu[col][i] = tmp; [EOL]             } [EOL]             int temp = pivot[nonZero]; [EOL]             pivot[nonZero] = pivot[col]; [EOL]             pivot[col] = temp; [EOL]             even = !even; [EOL]         } [EOL]         final T luDiag = lu[col][col]; [EOL]         for (int row = col + 1; row < m; row++) { [EOL]             final T[] luRow = lu[row]; [EOL]             luRow[col] = luRow[col].divide(luDiag); [EOL]         } [EOL]     } [EOL] } <line_num>: 85,165
private Solver(final Field<T> field, final T[][] lu, final int[] pivot, final boolean singular) { [EOL]     this.field = field; [EOL]     this.lu = lu; [EOL]     this.pivot = pivot; [EOL]     this.singular = singular; [EOL] } <line_num>: 282,288
public FieldMatrix<T> getL() { [EOL]     if ((cachedL == null) && !singular) { [EOL]         final int m = pivot.length; [EOL]         cachedL = new Array2DRowFieldMatrix<T>(field, m, m); [EOL]         for (int i = 0; i < m; ++i) { [EOL]             final T[] luI = lu[i]; [EOL]             for (int j = 0; j < i; ++j) { [EOL]                 cachedL.setEntry(i, j, luI[j]); [EOL]             } [EOL]             cachedL.setEntry(i, i, field.getOne()); [EOL]         } [EOL]     } [EOL]     return cachedL; [EOL] } <line_num>: 172,185
public FieldMatrix<T> getU() { [EOL]     if ((cachedU == null) && !singular) { [EOL]         final int m = pivot.length; [EOL]         cachedU = new Array2DRowFieldMatrix<T>(field, m, m); [EOL]         for (int i = 0; i < m; ++i) { [EOL]             final T[] luI = lu[i]; [EOL]             for (int j = i; j < m; ++j) { [EOL]                 cachedU.setEntry(i, j, luI[j]); [EOL]             } [EOL]         } [EOL]     } [EOL]     return cachedU; [EOL] } <line_num>: 192,204
public FieldMatrix<T> getP() { [EOL]     if ((cachedP == null) && !singular) { [EOL]         final int m = pivot.length; [EOL]         cachedP = new Array2DRowFieldMatrix<T>(field, m, m); [EOL]         for (int i = 0; i < m; ++i) { [EOL]             cachedP.setEntry(i, pivot[i], field.getOne()); [EOL]         } [EOL]     } [EOL]     return cachedP; [EOL] } <line_num>: 215,224
public int[] getPivot() { [EOL]     return pivot.clone(); [EOL] } <line_num>: 231,233
public T getDeterminant() { [EOL]     if (singular) { [EOL]         return field.getZero(); [EOL]     } else { [EOL]         final int m = pivot.length; [EOL]         T determinant = even ? field.getOne() : field.getZero().subtract(field.getOne()); [EOL]         for (int i = 0; i < m; i++) { [EOL]             determinant = determinant.multiply(lu[i][i]); [EOL]         } [EOL]         return determinant; [EOL]     } [EOL] } <line_num>: 239,250
public FieldDecompositionSolver<T> getSolver() { [EOL]     return new Solver<T>(field, lu, pivot, singular); [EOL] } <line_num>: 256,258
public boolean isNonSingular() { [EOL]     return !singular; [EOL] } <line_num>: 291,293
public FieldVector<T> solve(FieldVector<T> b) { [EOL]     try { [EOL]         return solve((ArrayFieldVector<T>) b); [EOL]     } catch (ClassCastException cce) { [EOL]         final int m = pivot.length; [EOL]         if (b.getDimension() != m) { [EOL]             throw new DimensionMismatchException(b.getDimension(), m); [EOL]         } [EOL]         if (singular) { [EOL]             throw new SingularMatrixException(); [EOL]         } [EOL]         final T[] bp = MathArrays.buildArray(field, m); [EOL]         for (int row = 0; row < m; row++) { [EOL]             bp[row] = b.getEntry(pivot[row]); [EOL]         } [EOL]         for (int col = 0; col < m; col++) { [EOL]             final T bpCol = bp[col]; [EOL]             for (int i = col + 1; i < m; i++) { [EOL]                 bp[i] = bp[i].subtract(bpCol.multiply(lu[i][col])); [EOL]             } [EOL]         } [EOL]         for (int col = m - 1; col >= 0; col--) { [EOL]             bp[col] = bp[col].divide(lu[col][col]); [EOL]             final T bpCol = bp[col]; [EOL]             for (int i = 0; i < col; i++) { [EOL]                 bp[i] = bp[i].subtract(bpCol.multiply(lu[i][col])); [EOL]             } [EOL]         } [EOL]         return new ArrayFieldVector<T>(field, bp, false); [EOL]     } [EOL] } <line_num>: 296,335
public ArrayFieldVector<T> solve(ArrayFieldVector<T> b) { [EOL]     final int m = pivot.length; [EOL]     final int length = b.getDimension(); [EOL]     if (length != m) { [EOL]         throw new DimensionMismatchException(length, m); [EOL]     } [EOL]     if (singular) { [EOL]         throw new SingularMatrixException(); [EOL]     } [EOL]     final T[] bp = MathArrays.buildArray(field, m); [EOL]     for (int row = 0; row < m; row++) { [EOL]         bp[row] = b.getEntry(pivot[row]); [EOL]     } [EOL]     for (int col = 0; col < m; col++) { [EOL]         final T bpCol = bp[col]; [EOL]         for (int i = col + 1; i < m; i++) { [EOL]             bp[i] = bp[i].subtract(bpCol.multiply(lu[i][col])); [EOL]         } [EOL]     } [EOL]     for (int col = m - 1; col >= 0; col--) { [EOL]         bp[col] = bp[col].divide(lu[col][col]); [EOL]         final T bpCol = bp[col]; [EOL]         for (int i = 0; i < col; i++) { [EOL]             bp[i] = bp[i].subtract(bpCol.multiply(lu[i][col])); [EOL]         } [EOL]     } [EOL]     return new ArrayFieldVector<T>(bp, false); [EOL] } <line_num>: 344,378
public FieldMatrix<T> solve(FieldMatrix<T> b) { [EOL]     final int m = pivot.length; [EOL]     if (b.getRowDimension() != m) { [EOL]         throw new DimensionMismatchException(b.getRowDimension(), m); [EOL]     } [EOL]     if (singular) { [EOL]         throw new SingularMatrixException(); [EOL]     } [EOL]     final int nColB = b.getColumnDimension(); [EOL]     final T[][] bp = MathArrays.buildArray(field, m, nColB); [EOL]     for (int row = 0; row < m; row++) { [EOL]         final T[] bpRow = bp[row]; [EOL]         final int pRow = pivot[row]; [EOL]         for (int col = 0; col < nColB; col++) { [EOL]             bpRow[col] = b.getEntry(pRow, col); [EOL]         } [EOL]     } [EOL]     for (int col = 0; col < m; col++) { [EOL]         final T[] bpCol = bp[col]; [EOL]         for (int i = col + 1; i < m; i++) { [EOL]             final T[] bpI = bp[i]; [EOL]             final T luICol = lu[i][col]; [EOL]             for (int j = 0; j < nColB; j++) { [EOL]                 bpI[j] = bpI[j].subtract(bpCol[j].multiply(luICol)); [EOL]             } [EOL]         } [EOL]     } [EOL]     for (int col = m - 1; col >= 0; col--) { [EOL]         final T[] bpCol = bp[col]; [EOL]         final T luDiag = lu[col][col]; [EOL]         for (int j = 0; j < nColB; j++) { [EOL]             bpCol[j] = bpCol[j].divide(luDiag); [EOL]         } [EOL]         for (int i = 0; i < col; i++) { [EOL]             final T[] bpI = bp[i]; [EOL]             final T luICol = lu[i][col]; [EOL]             for (int j = 0; j < nColB; j++) { [EOL]                 bpI[j] = bpI[j].subtract(bpCol[j].multiply(luICol)); [EOL]             } [EOL]         } [EOL]     } [EOL]     return new Array2DRowFieldMatrix<T>(field, bp, false); [EOL] } <line_num>: 381,432
public FieldMatrix<T> getInverse() { [EOL]     final int m = pivot.length; [EOL]     final T one = field.getOne(); [EOL]     FieldMatrix<T> identity = new Array2DRowFieldMatrix<T>(field, m, m); [EOL]     for (int i = 0; i < m; ++i) { [EOL]         identity.setEntry(i, i, one); [EOL]     } [EOL]     return solve(identity); [EOL] } <line_num>: 435,443
