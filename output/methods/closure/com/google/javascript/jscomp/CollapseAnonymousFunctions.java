public CollapseAnonymousFunctions(AbstractCompiler compiler) { [EOL]     Preconditions.checkArgument(compiler.getLifeCycleStage().isNormalized()); [EOL]     this.compiler = compiler; [EOL] } <line_num>: 41,44
@Override [EOL] public void process(Node externs, Node root) { [EOL]     NodeTraversal.traverse(compiler, root, new Callback()); [EOL] } <line_num>: 46,49
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     if (!n.isVar()) { [EOL]         return; [EOL]     } [EOL]     Node grandparent = parent.getParent(); [EOL]     if (!(parent.isScript() || grandparent != null && grandparent.isFunction() && parent.isBlock())) { [EOL]         return; [EOL]     } [EOL]     Preconditions.checkState(n.hasOneChild()); [EOL]     Node name = n.getFirstChild(); [EOL]     Node value = name.getFirstChild(); [EOL]     if (value != null && value.isFunction() && !isRecursiveFunction(value)) { [EOL]         Node fnName = value.getFirstChild(); [EOL]         fnName.setString(name.getString()); [EOL]         NodeUtil.copyNameAnnotations(name, fnName); [EOL]         name.removeChild(value); [EOL]         parent.replaceChild(n, value); [EOL]         if (!t.inGlobalScope() && NodeUtil.isHoistedFunctionDeclaration(value)) { [EOL]             parent.addChildToFront(value.detachFromParent()); [EOL]         } [EOL]         compiler.reportCodeChange(); [EOL]     } [EOL] } <line_num>: 52,94
private boolean isRecursiveFunction(Node function) { [EOL]     Node name = function.getFirstChild(); [EOL]     if (name.getString().isEmpty()) { [EOL]         return false; [EOL]     } [EOL]     Node args = name.getNext(); [EOL]     Node body = args.getNext(); [EOL]     return containsName(body, name.getString()); [EOL] } <line_num>: 96,104
private boolean containsName(Node n, String name) { [EOL]     if (n.isName() && n.getString().equals(name)) { [EOL]         return true; [EOL]     } [EOL]     for (Node child : n.children()) { [EOL]         if (containsName(child, name)) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 106,117
