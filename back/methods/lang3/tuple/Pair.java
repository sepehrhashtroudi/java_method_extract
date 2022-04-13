public static <L, R> Pair<L, R> of(final L left, final R right) { [EOL]     return new ImmutablePair<L, R>(left, right); [EOL] }
public abstract L getLeft();
public abstract R getRight();
@Override [EOL] public final L getKey() { [EOL]     return getLeft(); [EOL] }
@Override [EOL] public R getValue() { [EOL]     return getRight(); [EOL] }
@Override [EOL] public int compareTo(final Pair<L, R> other) { [EOL]     return new CompareToBuilder().append(getLeft(), other.getLeft()).append(getRight(), other.getRight()).toComparison(); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (obj instanceof Map.Entry<?, ?>) { [EOL]         final Map.Entry<?, ?> other = (Map.Entry<?, ?>) obj; [EOL]         return ObjectUtils.equals(getKey(), other.getKey()) && ObjectUtils.equals(getValue(), other.getValue()); [EOL]     } [EOL]     return false; [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() == null ? 0 : getValue().hashCode()); [EOL] }
@Override [EOL] public String toString() { [EOL]     return new StringBuilder().append('(').append(getLeft()).append(',').append(getRight()).append(')').toString(); [EOL] }
public String toString(final String format) { [EOL]     return String.format(format, getLeft(), getRight()); [EOL] }
