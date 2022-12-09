public Min() { [EOL]     n = 0; [EOL]     value = Double.NaN; [EOL] } <line_num>: 57,60
public Min(Min original) throws NullArgumentException { [EOL]     copy(original, this); [EOL] } <line_num>: 69,71
@Override [EOL] public void increment(final double d) { [EOL]     if (d < value || Double.isNaN(value)) { [EOL]         value = d; [EOL]     } [EOL]     n++; [EOL] } <line_num>: 76,82
@Override [EOL] public void clear() { [EOL]     value = Double.NaN; [EOL]     n = 0; [EOL] } <line_num>: 87,91
@Override [EOL] public double getResult() { [EOL]     return value; [EOL] } <line_num>: 96,99
public long getN() { [EOL]     return n; [EOL] } <line_num>: 104,106
@Override [EOL] public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException { [EOL]     double min = Double.NaN; [EOL]     if (test(values, begin, length)) { [EOL]         min = values[begin]; [EOL]         for (int i = begin; i < begin + length; i++) { [EOL]             if (!Double.isNaN(values[i])) { [EOL]                 min = (min < values[i]) ? min : values[i]; [EOL]             } [EOL]         } [EOL]     } [EOL]     return min; [EOL] } <line_num>: 130,143
@Override [EOL] public Min copy() { [EOL]     Min result = new Min(); [EOL]     copy(this, result); [EOL]     return result; [EOL] } <line_num>: 148,154
public static void copy(Min source, Min dest) throws NullArgumentException { [EOL]     MathUtils.checkNotNull(source); [EOL]     MathUtils.checkNotNull(dest); [EOL]     dest.setData(source.getDataRef()); [EOL]     dest.n = source.n; [EOL]     dest.value = source.value; [EOL] } <line_num>: 164,171
