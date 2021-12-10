public static <L, R> ImmutablePair<L, R> of(final L left, final R right) {	    return new ImmutablePair<L, R>(left, right);	}
@Override	public L getLeft() {	    return left;	}
@Override	public R getRight() {	    return right;	}
@Override	public R setValue(final R value) {	    throw new UnsupportedOperationException();	}
