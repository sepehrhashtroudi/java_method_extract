public static <L, M, R> ImmutableTriple<L, M, R> of(final L left, final M middle, final R right) { [EOL]     return new ImmutableTriple<L, M, R>(left, middle, right); [EOL] }
@Override [EOL] public L getLeft() { [EOL]     return left; [EOL] }
@Override [EOL] public M getMiddle() { [EOL]     return middle; [EOL] }
@Override [EOL] public R getRight() { [EOL]     return right; [EOL] }
