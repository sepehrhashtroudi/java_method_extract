public static <L, M, R> ImmutableTriple<L, M, R> of(final L left, final M middle, final R right) {	    return new ImmutableTriple<L, M, R>(left, middle, right);	}
@Override	public L getLeft() {	    return left;	}
@Override	public M getMiddle() {	    return middle;	}
@Override	public R getRight() {	    return right;	}
