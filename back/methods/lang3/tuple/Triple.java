public static <L, M, R> Triple<L, M, R> of(final L left, final M middle, final R right) { [EOL]     return new ImmutableTriple<L, M, R>(left, middle, right); [EOL] }
public abstract L getLeft();
public abstract M getMiddle();
public abstract R getRight();
@Override [EOL] public int compareTo(final Triple<L, M, R> other) { [EOL]     return new CompareToBuilder().append(getLeft(), other.getLeft()).append(getMiddle(), other.getMiddle()).append(getRight(), other.getRight()).toComparison(); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (obj instanceof Triple<?, ?, ?>) { [EOL]         final Triple<?, ?, ?> other = (Triple<?, ?, ?>) obj; [EOL]         return ObjectUtils.equals(getLeft(), other.getLeft()) && ObjectUtils.equals(getMiddle(), other.getMiddle()) && ObjectUtils.equals(getRight(), other.getRight()); [EOL]     } [EOL]     return false; [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return (getLeft() == null ? 0 : getLeft().hashCode()) ^ (getMiddle() == null ? 0 : getMiddle().hashCode()) ^ (getRight() == null ? 0 : getRight().hashCode()); [EOL] }
@Override [EOL] public String toString() { [EOL]     return new StringBuilder().append('(').append(getLeft()).append(',').append(getMiddle()).append(',').append(getRight()).append(')').toString(); [EOL] }
public String toString(final String format) { [EOL]     return String.format(format, getLeft(), getMiddle(), getRight()); [EOL] }
