public static <L, M, R> MutableTriple<L, M, R> of(final L left, final M middle, final R right) {	    return new MutableTriple<L, M, R>(left, middle, right);	}
@Override	public L getLeft() {	    return left;	}
public void setLeft(final L left) {	    this.left = left;	}
@Override	public M getMiddle() {	    return middle;	}
public void setMiddle(final M middle) {	    this.middle = middle;	}
@Override	public R getRight() {	    return right;	}
public void setRight(final R right) {	    this.right = right;	}
