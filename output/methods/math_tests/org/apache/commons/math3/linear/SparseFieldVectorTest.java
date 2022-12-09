@Test [EOL] public void testMapFunctions() throws FractionConversionException { [EOL]     SparseFieldVector<Fraction> v1 = new SparseFieldVector<Fraction>(field, vec1); [EOL]     FieldVector<Fraction> v_mapAdd = v1.mapAdd(new Fraction(2)); [EOL]     Fraction[] result_mapAdd = { new Fraction(3), new Fraction(4), new Fraction(5) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapAdd, v_mapAdd.getData()); [EOL]     FieldVector<Fraction> v_mapAddToSelf = v1.copy(); [EOL]     v_mapAddToSelf.mapAddToSelf(new Fraction(2)); [EOL]     Fraction[] result_mapAddToSelf = { new Fraction(3), new Fraction(4), new Fraction(5) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapAddToSelf, v_mapAddToSelf.getData()); [EOL]     FieldVector<Fraction> v_mapSubtract = v1.mapSubtract(new Fraction(2)); [EOL]     Fraction[] result_mapSubtract = { new Fraction(-1), new Fraction(0), new Fraction(1) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapSubtract, v_mapSubtract.getData()); [EOL]     FieldVector<Fraction> v_mapSubtractToSelf = v1.copy(); [EOL]     v_mapSubtractToSelf.mapSubtractToSelf(new Fraction(2)); [EOL]     Fraction[] result_mapSubtractToSelf = { new Fraction(-1), new Fraction(0), new Fraction(1) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapSubtractToSelf, v_mapSubtractToSelf.getData()); [EOL]     FieldVector<Fraction> v_mapMultiply = v1.mapMultiply(new Fraction(2)); [EOL]     Fraction[] result_mapMultiply = { new Fraction(2), new Fraction(4), new Fraction(6) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapMultiply, v_mapMultiply.getData()); [EOL]     FieldVector<Fraction> v_mapMultiplyToSelf = v1.copy(); [EOL]     v_mapMultiplyToSelf.mapMultiplyToSelf(new Fraction(2)); [EOL]     Fraction[] result_mapMultiplyToSelf = { new Fraction(2), new Fraction(4), new Fraction(6) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapMultiplyToSelf, v_mapMultiplyToSelf.getData()); [EOL]     FieldVector<Fraction> v_mapDivide = v1.mapDivide(new Fraction(2)); [EOL]     Fraction[] result_mapDivide = { new Fraction(.5d), new Fraction(1), new Fraction(1.5d) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapDivide, v_mapDivide.getData()); [EOL]     FieldVector<Fraction> v_mapDivideToSelf = v1.copy(); [EOL]     v_mapDivideToSelf.mapDivideToSelf(new Fraction(2)); [EOL]     Fraction[] result_mapDivideToSelf = { new Fraction(.5d), new Fraction(1), new Fraction(1.5d) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapDivideToSelf, v_mapDivideToSelf.getData()); [EOL]     FieldVector<Fraction> v_mapInv = v1.mapInv(); [EOL]     Fraction[] result_mapInv = { new Fraction(1), new Fraction(0.5d), new Fraction(3.333333333333333e-01d) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapInv, v_mapInv.getData()); [EOL]     FieldVector<Fraction> v_mapInvToSelf = v1.copy(); [EOL]     v_mapInvToSelf.mapInvToSelf(); [EOL]     Fraction[] result_mapInvToSelf = { new Fraction(1), new Fraction(0.5d), new Fraction(3.333333333333333e-01d) }; [EOL]     Assert.assertArrayEquals("compare vectors", result_mapInvToSelf, v_mapInvToSelf.getData()); [EOL] } <line_num>: 51,111
@Test [EOL] public void testBasicFunctions() throws FractionConversionException { [EOL]     SparseFieldVector<Fraction> v1 = new SparseFieldVector<Fraction>(field, vec1); [EOL]     SparseFieldVector<Fraction> v2 = new SparseFieldVector<Fraction>(field, vec2); [EOL]     FieldVector<Fraction> v2_t = new ArrayFieldVectorTest.FieldVectorTestImpl<Fraction>(vec2); [EOL]     FieldVector<Fraction> v_add = v1.add(v2); [EOL]     Fraction[] result_add = { new Fraction(5), new Fraction(7), new Fraction(9) }; [EOL]     Assert.assertArrayEquals("compare vect", v_add.getData(), result_add); [EOL]     FieldVector<Fraction> vt2 = new ArrayFieldVectorTest.FieldVectorTestImpl<Fraction>(vec2); [EOL]     FieldVector<Fraction> v_add_i = v1.add(vt2); [EOL]     Fraction[] result_add_i = { new Fraction(5), new Fraction(7), new Fraction(9) }; [EOL]     Assert.assertArrayEquals("compare vect", v_add_i.getData(), result_add_i); [EOL]     SparseFieldVector<Fraction> v_subtract = v1.subtract(v2); [EOL]     Fraction[] result_subtract = { new Fraction(-3), new Fraction(-3), new Fraction(-3) }; [EOL]     assertClose("compare vect", v_subtract.getData(), result_subtract, normTolerance); [EOL]     FieldVector<Fraction> v_subtract_i = v1.subtract(vt2); [EOL]     Fraction[] result_subtract_i = { new Fraction(-3), new Fraction(-3), new Fraction(-3) }; [EOL]     assertClose("compare vect", v_subtract_i.getData(), result_subtract_i, normTolerance); [EOL]     FieldVector<Fraction> v_ebeMultiply = v1.ebeMultiply(v2); [EOL]     Fraction[] result_ebeMultiply = { new Fraction(4), new Fraction(10), new Fraction(18) }; [EOL]     assertClose("compare vect", v_ebeMultiply.getData(), result_ebeMultiply, normTolerance); [EOL]     FieldVector<Fraction> v_ebeMultiply_2 = v1.ebeMultiply(v2_t); [EOL]     Fraction[] result_ebeMultiply_2 = { new Fraction(4), new Fraction(10), new Fraction(18) }; [EOL]     assertClose("compare vect", v_ebeMultiply_2.getData(), result_ebeMultiply_2, normTolerance); [EOL]     FieldVector<Fraction> v_ebeDivide = v1.ebeDivide(v2); [EOL]     Fraction[] result_ebeDivide = { new Fraction(0.25d), new Fraction(0.4d), new Fraction(0.5d) }; [EOL]     assertClose("compare vect", v_ebeDivide.getData(), result_ebeDivide, normTolerance); [EOL]     FieldVector<Fraction> v_ebeDivide_2 = v1.ebeDivide(v2_t); [EOL]     Fraction[] result_ebeDivide_2 = { new Fraction(0.25d), new Fraction(0.4d), new Fraction(0.5d) }; [EOL]     assertClose("compare vect", v_ebeDivide_2.getData(), result_ebeDivide_2, normTolerance); [EOL]     Fraction dot = v1.dotProduct(v2); [EOL]     Assert.assertEquals("compare val ", new Fraction(32), dot); [EOL]     Fraction dot_2 = v1.dotProduct(v2_t); [EOL]     Assert.assertEquals("compare val ", new Fraction(32), dot_2); [EOL]     FieldMatrix<Fraction> m_outerProduct = v1.outerProduct(v2); [EOL]     Assert.assertEquals("compare val ", new Fraction(4), m_outerProduct.getEntry(0, 0)); [EOL]     FieldMatrix<Fraction> m_outerProduct_2 = v1.outerProduct(v2_t); [EOL]     Assert.assertEquals("compare val ", new Fraction(4), m_outerProduct_2.getEntry(0, 0)); [EOL] } <line_num>: 113,171
@Test [EOL] public void testOuterProduct() { [EOL]     final SparseFieldVector<Fraction> u = new SparseFieldVector<Fraction>(FractionField.getInstance(), new Fraction[] { new Fraction(1), new Fraction(2), new Fraction(-3) }); [EOL]     final SparseFieldVector<Fraction> v = new SparseFieldVector<Fraction>(FractionField.getInstance(), new Fraction[] { new Fraction(4), new Fraction(-2) }); [EOL]     final FieldMatrix<Fraction> uv = u.outerProduct(v); [EOL]     final double tol = Math.ulp(1d); [EOL]     Assert.assertEquals(new Fraction(4).doubleValue(), uv.getEntry(0, 0).doubleValue(), tol); [EOL]     Assert.assertEquals(new Fraction(-2).doubleValue(), uv.getEntry(0, 1).doubleValue(), tol); [EOL]     Assert.assertEquals(new Fraction(8).doubleValue(), uv.getEntry(1, 0).doubleValue(), tol); [EOL]     Assert.assertEquals(new Fraction(-4).doubleValue(), uv.getEntry(1, 1).doubleValue(), tol); [EOL]     Assert.assertEquals(new Fraction(-12).doubleValue(), uv.getEntry(2, 0).doubleValue(), tol); [EOL]     Assert.assertEquals(new Fraction(6).doubleValue(), uv.getEntry(2, 1).doubleValue(), tol); [EOL] } <line_num>: 173,194
@Test [EOL] public void testMisc() { [EOL]     SparseFieldVector<Fraction> v1 = new SparseFieldVector<Fraction>(field, vec1); [EOL]     String out1 = v1.toString(); [EOL]     Assert.assertTrue("some output ", out1.length() != 0); [EOL]     try { [EOL]         v1.checkVectorDimensions(2); [EOL]         Assert.fail("MathIllegalArgumentException expected"); [EOL]     } catch (MathIllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 196,210
@Test [EOL] public void testPredicates() { [EOL]     SparseFieldVector<Fraction> v = new SparseFieldVector<Fraction>(field, new Fraction[] { new Fraction(0), new Fraction(1), new Fraction(2) }); [EOL]     v.setEntry(0, field.getZero()); [EOL]     Assert.assertEquals(v, new SparseFieldVector<Fraction>(field, new Fraction[] { new Fraction(0), new Fraction(1), new Fraction(2) })); [EOL]     Assert.assertNotSame(v, new SparseFieldVector<Fraction>(field, new Fraction[] { new Fraction(0), new Fraction(1), new Fraction(2), new Fraction(3) })); [EOL] } <line_num>: 212,221
protected void assertEquals(String msg, Fraction[] m, Fraction[] n) { [EOL]     if (m.length != n.length) { [EOL]         Assert.fail("vectors have different lengths"); [EOL]     } [EOL]     for (int i = 0; i < m.length; i++) { [EOL]         Assert.assertEquals(msg + " " + i + " elements differ", m[i], n[i]); [EOL]     } [EOL] } <line_num>: 224,231
protected void assertClose(String msg, Fraction[] m, Fraction[] n, double tolerance) { [EOL]     if (m.length != n.length) { [EOL]         Assert.fail("vectors have different lengths"); [EOL]     } [EOL]     for (int i = 0; i < m.length; i++) { [EOL]         Assert.assertEquals(msg + " " + i + " elements differ", m[i].doubleValue(), n[i].doubleValue(), tolerance); [EOL]     } [EOL] } <line_num>: 234,241
