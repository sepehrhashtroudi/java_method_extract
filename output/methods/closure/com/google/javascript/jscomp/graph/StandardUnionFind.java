public StandardUnionFind() { [EOL] } <line_num>: 56,57
public StandardUnionFind(UnionFind<E> other) { [EOL]     for (E elem : other.elements()) { [EOL]         union(elem, other.find(elem)); [EOL]     } [EOL] } <line_num>: 66,70
Node(E element) { [EOL]     this.parent = this; [EOL]     this.element = element; [EOL] } <line_num>: 222,225
@Override [EOL] public void add(E e) { [EOL]     union(e, e); [EOL] } <line_num>: 72,75
@Override [EOL] public E union(E a, E b) { [EOL]     Node<E> nodeA = findRootOrCreateNode(a); [EOL]     Node<E> nodeB = findRootOrCreateNode(b); [EOL]     if (nodeA == nodeB) { [EOL]         return nodeA.element; [EOL]     } [EOL]     if (nodeA.rank > nodeB.rank) { [EOL]         nodeB.parent = nodeA; [EOL]         nodeA.size += nodeB.size; [EOL]         return nodeA.element; [EOL]     } [EOL]     nodeA.parent = nodeB; [EOL]     if (nodeA.rank == nodeB.rank) { [EOL]         nodeB.rank++; [EOL]     } [EOL]     nodeB.size += nodeA.size; [EOL]     return nodeB.element; [EOL] } <line_num>: 77,96
@Override [EOL] public E find(E e) { [EOL]     checkArgument(elmap.containsKey(e), "Element does not exist: %s", e); [EOL]     return findRoot(elmap.get(e)).element; [EOL] } <line_num>: 98,102
@Override [EOL] public boolean areEquivalent(E a, E b) { [EOL]     E aRep = find(a); [EOL]     E bRep = find(b); [EOL]     return aRep == bRep; [EOL] } <line_num>: 104,109
@Override [EOL] public Set<E> elements() { [EOL]     return Collections.unmodifiableSet(elmap.keySet()); [EOL] } <line_num>: 111,114
@Override [EOL] public Collection<Set<E>> allEquivalenceClasses() { [EOL]     Map<Node<E>, ImmutableSet.Builder<E>> groupsTmp = Maps.newHashMap(); [EOL]     for (Node<E> elem : elmap.values()) { [EOL]         Node<E> root = findRoot(elem); [EOL]         ImmutableSet.Builder<E> builder = groupsTmp.get(root); [EOL]         if (builder == null) { [EOL]             builder = ImmutableSet.builder(); [EOL]             groupsTmp.put(root, builder); [EOL]         } [EOL]         builder.add(elem.element); [EOL]     } [EOL]     ImmutableList.Builder<Set<E>> result = ImmutableList.builder(); [EOL]     for (ImmutableSet.Builder<E> group : groupsTmp.values()) { [EOL]         result.add(group.build()); [EOL]     } [EOL]     return result.build(); [EOL] } <line_num>: 116,133
private Node<E> findRootOrCreateNode(E e) { [EOL]     Node<E> node = elmap.get(e); [EOL]     if (node != null) { [EOL]         return findRoot(node); [EOL]     } [EOL]     node = new Node<E>(e); [EOL]     elmap.put(e, node); [EOL]     return node; [EOL] } <line_num>: 141,149
private Node<E> findRoot(Node<E> node) { [EOL]     if (node.parent != node) { [EOL]         node.parent = findRoot(node.parent); [EOL]     } [EOL]     return node.parent; [EOL] } <line_num>: 158,163
@Override [EOL] public boolean apply(@Nullable Object b) { [EOL]     if (Objects.equal(value, b)) { [EOL]         return true; [EOL]     } [EOL]     Node<E> nodeForB = elmap.get(b); [EOL]     if (nodeForB == null) { [EOL]         return false; [EOL]     } [EOL]     nodeForValue = findRoot(nodeForValue); [EOL]     return findRoot(nodeForB) == nodeForValue; [EOL] } <line_num>: 174,185
@Override [EOL] public boolean contains(Object o) { [EOL]     return isSameRoot.apply(o); [EOL] } <line_num>: 190,192
@Override [EOL] public Iterator<E> iterator() { [EOL]     return filter(elmap.keySet().iterator(), isSameRoot); [EOL] } <line_num>: 194,197
@Override [EOL] public int size() { [EOL]     return findRoot(elmap.get(value)).size; [EOL] } <line_num>: 199,201
@Override [EOL] public Set<E> findAll(final E value) { [EOL]     checkArgument(elmap.containsKey(value), "Element does not exist: " + value); [EOL]     final Predicate<Object> isSameRoot = new Predicate<Object>() { [EOL]  [EOL]         Node<E> nodeForValue = elmap.get(value); [EOL]  [EOL]         @Override [EOL]         public boolean apply(@Nullable Object b) { [EOL]             if (Objects.equal(value, b)) { [EOL]                 return true; [EOL]             } [EOL]             Node<E> nodeForB = elmap.get(b); [EOL]             if (nodeForB == null) { [EOL]                 return false; [EOL]             } [EOL]             nodeForValue = findRoot(nodeForValue); [EOL]             return findRoot(nodeForB) == nodeForValue; [EOL]         } [EOL]     }; [EOL]     return new AbstractSet<E>() { [EOL]  [EOL]         @Override [EOL]         public boolean contains(Object o) { [EOL]             return isSameRoot.apply(o); [EOL]         } [EOL]  [EOL]         @Override [EOL]         public Iterator<E> iterator() { [EOL]             return filter(elmap.keySet().iterator(), isSameRoot); [EOL]         } [EOL]  [EOL]         @Override [EOL]         public int size() { [EOL]             return findRoot(elmap.get(value)).size; [EOL]         } [EOL]     }; [EOL] } <line_num>: 165,203
