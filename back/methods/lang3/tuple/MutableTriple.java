public static <L, M, R> MutableTriple<L, M, R> of(final L left, final M middle, final R right) { [EOL]     return new MutableTriple<L, M, R>(left, middle, right); [EOL] }
@Override [EOL] public L getLeft() { [EOL]     return left; [EOL] }
public void setLeft(final L left) { [EOL]     this.left = left; [EOL] }
@Override [EOL] public M getMiddle() { [EOL]     return middle; [EOL] }
public void setMiddle(final M middle) { [EOL]     this.middle = middle; [EOL] }
@Override [EOL] public R getRight() { [EOL]     return right; [EOL] }
public void setRight(final R right) { [EOL]     this.right = right; [EOL] }
