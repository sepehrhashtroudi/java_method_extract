public static <L, R> ImmutablePair<L, R> of(final L left, final R right) { [EOL]     return new ImmutablePair<L, R>(left, right); [EOL] }
@Override [EOL] public L getLeft() { [EOL]     return left; [EOL] }
@Override [EOL] public R getRight() { [EOL]     return right; [EOL] }
@Override [EOL] public R setValue(final R value) { [EOL]     throw new UnsupportedOperationException(); [EOL] }
