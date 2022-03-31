public static <L, R> MutablePair<L, R> of(final L left, final R right) { [EOL]     return new MutablePair<L, R>(left, right); [EOL] }
@Override [EOL] public L getLeft() { [EOL]     return left; [EOL] }
public void setLeft(final L left) { [EOL]     this.left = left; [EOL] }
@Override [EOL] public R getRight() { [EOL]     return right; [EOL] }
public void setRight(final R right) { [EOL]     this.right = right; [EOL] }
@Override [EOL] public R setValue(final R value) { [EOL]     final R result = getRight(); [EOL]     setRight(value); [EOL]     return result; [EOL] }
