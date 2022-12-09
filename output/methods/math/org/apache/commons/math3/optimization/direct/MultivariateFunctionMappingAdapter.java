public MultivariateFunctionMappingAdapter(final MultivariateFunction bounded, final double[] lower, final double[] upper) { [EOL]     MathUtils.checkNotNull(lower); [EOL]     MathUtils.checkNotNull(upper); [EOL]     if (lower.length != upper.length) { [EOL]         throw new DimensionMismatchException(lower.length, upper.length); [EOL]     } [EOL]     for (int i = 0; i < lower.length; ++i) { [EOL]         if (!(upper[i] >= lower[i])) { [EOL]             throw new NumberIsTooSmallException(upper[i], lower[i], true); [EOL]         } [EOL]     } [EOL]     this.bounded = bounded; [EOL]     this.mappers = new Mapper[lower.length]; [EOL]     for (int i = 0; i < mappers.length; ++i) { [EOL]         if (Double.isInfinite(lower[i])) { [EOL]             if (Double.isInfinite(upper[i])) { [EOL]                 mappers[i] = new NoBoundsMapper(); [EOL]             } else { [EOL]                 mappers[i] = new UpperBoundMapper(upper[i]); [EOL]             } [EOL]         } else { [EOL]             if (Double.isInfinite(upper[i])) { [EOL]                 mappers[i] = new LowerBoundMapper(lower[i]); [EOL]             } else { [EOL]                 mappers[i] = new LowerUpperBoundMapper(lower[i], upper[i]); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 99,137
public NoBoundsMapper() { [EOL] } <line_num>: 207,208
public LowerBoundMapper(final double lower) { [EOL]     this.lower = lower; [EOL] } <line_num>: 231,233
public UpperBoundMapper(final double upper) { [EOL]     this.upper = upper; [EOL] } <line_num>: 256,258
public LowerUpperBoundMapper(final double lower, final double upper) { [EOL]     boundingFunction = new Sigmoid(lower, upper); [EOL]     unboundingFunction = new Logit(lower, upper); [EOL] } <line_num>: 285,288
public double[] unboundedToBounded(double[] point) { [EOL]     final double[] mapped = new double[mappers.length]; [EOL]     for (int i = 0; i < mappers.length; ++i) { [EOL]         mapped[i] = mappers[i].unboundedToBounded(point[i]); [EOL]     } [EOL]     return mapped; [EOL] } <line_num>: 143,153
public double[] boundedToUnbounded(double[] point) { [EOL]     final double[] mapped = new double[mappers.length]; [EOL]     for (int i = 0; i < mappers.length; ++i) { [EOL]         mapped[i] = mappers[i].boundedToUnbounded(point[i]); [EOL]     } [EOL]     return mapped; [EOL] } <line_num>: 159,169
public double value(double[] point) { [EOL]     return bounded.value(unboundedToBounded(point)); [EOL] } <line_num>: 181,183
double unboundedToBounded(double y); <line_num>: 192,192
double boundedToUnbounded(double x); <line_num>: 198,198
public double unboundedToBounded(final double y) { [EOL]     return y; [EOL] } <line_num>: 211,213
public double boundedToUnbounded(final double x) { [EOL]     return x; [EOL] } <line_num>: 216,218
public double unboundedToBounded(final double y) { [EOL]     return lower + FastMath.exp(y); [EOL] } <line_num>: 236,238
public double boundedToUnbounded(final double x) { [EOL]     return FastMath.log(x - lower); [EOL] } <line_num>: 241,243
public double unboundedToBounded(final double y) { [EOL]     return upper - FastMath.exp(-y); [EOL] } <line_num>: 261,263
public double boundedToUnbounded(final double x) { [EOL]     return -FastMath.log(upper - x); [EOL] } <line_num>: 266,268
public double unboundedToBounded(final double y) { [EOL]     return boundingFunction.value(y); [EOL] } <line_num>: 291,293
public double boundedToUnbounded(final double x) { [EOL]     return unboundingFunction.value(x); [EOL] } <line_num>: 296,298
