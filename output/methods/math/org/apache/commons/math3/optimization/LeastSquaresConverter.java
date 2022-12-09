public LeastSquaresConverter(final MultivariateVectorFunction function, final double[] observations) { [EOL]     this.function = function; [EOL]     this.observations = observations.clone(); [EOL]     this.weights = null; [EOL]     this.scale = null; [EOL] } <line_num>: 76,82
public LeastSquaresConverter(final MultivariateVectorFunction function, final double[] observations, final double[] weights) { [EOL]     if (observations.length != weights.length) { [EOL]         throw new DimensionMismatchException(observations.length, weights.length); [EOL]     } [EOL]     this.function = function; [EOL]     this.observations = observations.clone(); [EOL]     this.weights = weights.clone(); [EOL]     this.scale = null; [EOL] } <line_num>: 112,121
public LeastSquaresConverter(final MultivariateVectorFunction function, final double[] observations, final RealMatrix scale) { [EOL]     if (observations.length != scale.getColumnDimension()) { [EOL]         throw new DimensionMismatchException(observations.length, scale.getColumnDimension()); [EOL]     } [EOL]     this.function = function; [EOL]     this.observations = observations.clone(); [EOL]     this.weights = null; [EOL]     this.scale = scale.copy(); [EOL] } <line_num>: 142,151
public double value(final double[] point) { [EOL]     final double[] residuals = function.value(point); [EOL]     if (residuals.length != observations.length) { [EOL]         throw new DimensionMismatchException(residuals.length, observations.length); [EOL]     } [EOL]     for (int i = 0; i < residuals.length; ++i) { [EOL]         residuals[i] -= observations[i]; [EOL]     } [EOL]     double sumSquares = 0; [EOL]     if (weights != null) { [EOL]         for (int i = 0; i < residuals.length; ++i) { [EOL]             final double ri = residuals[i]; [EOL]             sumSquares += weights[i] * ri * ri; [EOL]         } [EOL]     } else if (scale != null) { [EOL]         for (final double yi : scale.operate(residuals)) { [EOL]             sumSquares += yi * yi; [EOL]         } [EOL]     } else { [EOL]         for (final double ri : residuals) { [EOL]             sumSquares += ri * ri; [EOL]         } [EOL]     } [EOL]     return sumSquares; [EOL] } <line_num>: 154,182
