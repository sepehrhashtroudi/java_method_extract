public BSPTree()
public BSPTree(final Object attribute)
public BSPTree(final SubHyperplane<S> cut, final BSPTree<S> plus, final BSPTree<S> minus, final Object attribute)
public boolean insertCut(final Hyperplane<S> hyperplane)
public BSPTree<S> copySelf()
public SubHyperplane<S> getCut()
public BSPTree<S> getPlus()
public BSPTree<S> getMinus()
public BSPTree<S> getParent()
public void setAttribute(final Object attribute)
public Object getAttribute()
public void visit(final BSPTreeVisitor<S> visitor)
private SubHyperplane<S> fitToCell(final SubHyperplane<S> sub)
public BSPTree<S> getCell(final Vector<S> point)
private void condense()
public BSPTree<S> merge(final BSPTree<S> tree, final LeafMerger<S> leafMerger)
private BSPTree<S> merge(final BSPTree<S> tree, final LeafMerger<S> leafMerger, final BSPTree<S> parentTree, final boolean isPlusChild)
 BSPTree<S> merge(BSPTree<S> leaf, BSPTree<S> tree, BSPTree<S> parentTree, boolean isPlusChild, boolean leafFromInstance)
public BSPTree<S> split(final SubHyperplane<S> sub)
public void insertInTree(final BSPTree<S> parentTree, final boolean isPlusChild)
private void chopOffMinus(final Hyperplane<S> hyperplane)
private void chopOffPlus(final Hyperplane<S> hyperplane)
SubHyperplane<S> cut
BSPTree<S> plus
BSPTree<S> minus
BSPTree<S> parent
Object attribute
