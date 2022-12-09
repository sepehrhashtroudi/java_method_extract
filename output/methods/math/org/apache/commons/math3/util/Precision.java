private Precision() { [EOL] } <line_num>: 83,83
public static int compareTo(double x, double y, double eps) { [EOL]     if (equals(x, y, eps)) { [EOL]         return 0; [EOL]     } else if (x < y) { [EOL]         return -1; [EOL]     } [EOL]     return 1; [EOL] } <line_num>: 95,102
public static int compareTo(final double x, final double y, final int maxUlps) { [EOL]     if (equals(x, y, maxUlps)) { [EOL]         return 0; [EOL]     } else if (x < y) { [EOL]         return -1; [EOL]     } [EOL]     return 1; [EOL] } <line_num>: 121,128
public static boolean equals(float x, float y) { [EOL]     return equals(x, y, 1); [EOL] } <line_num>: 138,140
public static boolean equalsIncludingNaN(float x, float y) { [EOL]     return (Float.isNaN(x) && Float.isNaN(y)) || equals(x, y, 1); [EOL] } <line_num>: 151,153
public static boolean equals(float x, float y, float eps) { [EOL]     return equals(x, y, 1) || FastMath.abs(y - x) <= eps; [EOL] } <line_num>: 165,167
public static boolean equalsIncludingNaN(float x, float y, float eps) { [EOL]     return equalsIncludingNaN(x, y) || (FastMath.abs(y - x) <= eps); [EOL] } <line_num>: 180,182
public static boolean equals(float x, float y, int maxUlps) { [EOL]     int xInt = Float.floatToIntBits(x); [EOL]     int yInt = Float.floatToIntBits(y); [EOL]     if (xInt < 0) { [EOL]         xInt = SGN_MASK_FLOAT - xInt; [EOL]     } [EOL]     if (yInt < 0) { [EOL]         yInt = SGN_MASK_FLOAT - yInt; [EOL]     } [EOL]     final boolean isEqual = FastMath.abs(xInt - yInt) <= maxUlps; [EOL]     return isEqual && !Float.isNaN(x) && !Float.isNaN(y); [EOL] } <line_num>: 202,217
public static boolean equalsIncludingNaN(float x, float y, int maxUlps) { [EOL]     return (Float.isNaN(x) && Float.isNaN(y)) || equals(x, y, maxUlps); [EOL] } <line_num>: 231,233
public static boolean equals(double x, double y) { [EOL]     return equals(x, y, 1); [EOL] } <line_num>: 243,245
public static boolean equalsIncludingNaN(double x, double y) { [EOL]     return (Double.isNaN(x) && Double.isNaN(y)) || equals(x, y, 1); [EOL] } <line_num>: 256,258
public static boolean equals(double x, double y, double eps) { [EOL]     return equals(x, y, 1) || FastMath.abs(y - x) <= eps; [EOL] } <line_num>: 271,273
public static boolean equalsWithRelativeTolerance(double x, double y, double eps) { [EOL]     if (equals(x, y, 1)) { [EOL]         return true; [EOL]     } [EOL]     final double absoluteMax = FastMath.max(FastMath.abs(x), FastMath.abs(y)); [EOL]     final double relativeDifference = FastMath.abs((x - y) / absoluteMax); [EOL]     return relativeDifference <= eps; [EOL] } <line_num>: 287,296
public static boolean equalsIncludingNaN(double x, double y, double eps) { [EOL]     return equalsIncludingNaN(x, y) || (FastMath.abs(y - x) <= eps); [EOL] } <line_num>: 309,311
public static boolean equals(double x, double y, int maxUlps) { [EOL]     long xInt = Double.doubleToLongBits(x); [EOL]     long yInt = Double.doubleToLongBits(y); [EOL]     if (xInt < 0) { [EOL]         xInt = SGN_MASK - xInt; [EOL]     } [EOL]     if (yInt < 0) { [EOL]         yInt = SGN_MASK - yInt; [EOL]     } [EOL]     final boolean isEqual = FastMath.abs(xInt - yInt) <= maxUlps; [EOL]     return isEqual && !Double.isNaN(x) && !Double.isNaN(y); [EOL] } <line_num>: 330,345
public static boolean equalsIncludingNaN(double x, double y, int maxUlps) { [EOL]     return (Double.isNaN(x) && Double.isNaN(y)) || equals(x, y, maxUlps); [EOL] } <line_num>: 359,361
public static double round(double x, int scale) { [EOL]     return round(x, scale, BigDecimal.ROUND_HALF_UP); [EOL] } <line_num>: 372,374
public static double round(double x, int scale, int roundingMethod) { [EOL]     try { [EOL]         return (new BigDecimal(Double.toString(x)).setScale(scale, roundingMethod)).doubleValue(); [EOL]     } catch (NumberFormatException ex) { [EOL]         if (Double.isInfinite(x)) { [EOL]             return x; [EOL]         } else { [EOL]             return Double.NaN; [EOL]         } [EOL]     } [EOL] } <line_num>: 393,406
public static float round(float x, int scale) { [EOL]     return round(x, scale, BigDecimal.ROUND_HALF_UP); [EOL] } <line_num>: 417,419
public static float round(float x, int scale, int roundingMethod) throws MathArithmeticException, MathIllegalArgumentException { [EOL]     final float sign = FastMath.copySign(1f, x); [EOL]     final float factor = (float) FastMath.pow(10.0f, scale) * sign; [EOL]     return (float) roundUnscaled(x * factor, sign, roundingMethod) / factor; [EOL] } <line_num>: 434,439
private static double roundUnscaled(double unscaled, double sign, int roundingMethod) throws MathArithmeticException, MathIllegalArgumentException { [EOL]     switch(roundingMethod) { [EOL]         case BigDecimal.ROUND_CEILING: [EOL]             if (sign == -1) { [EOL]                 unscaled = FastMath.floor(FastMath.nextAfter(unscaled, Double.NEGATIVE_INFINITY)); [EOL]             } else { [EOL]                 unscaled = FastMath.ceil(FastMath.nextAfter(unscaled, Double.POSITIVE_INFINITY)); [EOL]             } [EOL]             break; [EOL]         case BigDecimal.ROUND_DOWN: [EOL]             unscaled = FastMath.floor(FastMath.nextAfter(unscaled, Double.NEGATIVE_INFINITY)); [EOL]             break; [EOL]         case BigDecimal.ROUND_FLOOR: [EOL]             if (sign == -1) { [EOL]                 unscaled = FastMath.ceil(FastMath.nextAfter(unscaled, Double.POSITIVE_INFINITY)); [EOL]             } else { [EOL]                 unscaled = FastMath.floor(FastMath.nextAfter(unscaled, Double.NEGATIVE_INFINITY)); [EOL]             } [EOL]             break; [EOL]         case BigDecimal.ROUND_HALF_DOWN: [EOL]             { [EOL]                 unscaled = FastMath.nextAfter(unscaled, Double.NEGATIVE_INFINITY); [EOL]                 double fraction = unscaled - FastMath.floor(unscaled); [EOL]                 if (fraction > 0.5) { [EOL]                     unscaled = FastMath.ceil(unscaled); [EOL]                 } else { [EOL]                     unscaled = FastMath.floor(unscaled); [EOL]                 } [EOL]                 break; [EOL]             } [EOL]         case BigDecimal.ROUND_HALF_EVEN: [EOL]             { [EOL]                 double fraction = unscaled - FastMath.floor(unscaled); [EOL]                 if (fraction > 0.5) { [EOL]                     unscaled = FastMath.ceil(unscaled); [EOL]                 } else if (fraction < 0.5) { [EOL]                     unscaled = FastMath.floor(unscaled); [EOL]                 } else { [EOL]                     if (FastMath.floor(unscaled) / 2.0 == FastMath.floor(Math.floor(unscaled) / 2.0)) { [EOL]                         unscaled = FastMath.floor(unscaled); [EOL]                     } else { [EOL]                         unscaled = FastMath.ceil(unscaled); [EOL]                     } [EOL]                 } [EOL]                 break; [EOL]             } [EOL]         case BigDecimal.ROUND_HALF_UP: [EOL]             { [EOL]                 unscaled = FastMath.nextAfter(unscaled, Double.POSITIVE_INFINITY); [EOL]                 double fraction = unscaled - FastMath.floor(unscaled); [EOL]                 if (fraction >= 0.5) { [EOL]                     unscaled = FastMath.ceil(unscaled); [EOL]                 } else { [EOL]                     unscaled = FastMath.floor(unscaled); [EOL]                 } [EOL]                 break; [EOL]             } [EOL]         case BigDecimal.ROUND_UNNECESSARY: [EOL]             if (unscaled != FastMath.floor(unscaled)) { [EOL]                 throw new MathArithmeticException(); [EOL]             } [EOL]             break; [EOL]         case BigDecimal.ROUND_UP: [EOL]             unscaled = FastMath.ceil(FastMath.nextAfter(unscaled, Double.POSITIVE_INFINITY)); [EOL]             break; [EOL]         default: [EOL]             throw new MathIllegalArgumentException(LocalizedFormats.INVALID_ROUNDING_METHOD, roundingMethod, "ROUND_CEILING", BigDecimal.ROUND_CEILING, "ROUND_DOWN", BigDecimal.ROUND_DOWN, "ROUND_FLOOR", BigDecimal.ROUND_FLOOR, "ROUND_HALF_DOWN", BigDecimal.ROUND_HALF_DOWN, "ROUND_HALF_EVEN", BigDecimal.ROUND_HALF_EVEN, "ROUND_HALF_UP", BigDecimal.ROUND_HALF_UP, "ROUND_UNNECESSARY", BigDecimal.ROUND_UNNECESSARY, "ROUND_UP", BigDecimal.ROUND_UP); [EOL]     } [EOL]     return unscaled; [EOL] } <line_num>: 454,534
public static double representableDelta(double x, double originalDelta) { [EOL]     return x + originalDelta - x; [EOL] } <line_num>: 551,554
