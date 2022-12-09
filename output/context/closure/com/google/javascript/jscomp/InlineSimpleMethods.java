 InlineSimpleMethods(AbstractCompiler compiler)
 void visit(NodeTraversal t, Node callNode, Node parent, String callName)
 Callback getActingCallback()
private static boolean isPropertyTree(Node expectedGetprop)
private static void replaceThis(Node expectedGetprop, Node replacement)
private static Node returnedExpression(Node fn)
private static boolean isEmptyMethod(Node fn)
private static Node getMethodBlock(Node fn)
private boolean allDefinitionsEquivalent(Collection<Node> definitions)
private void inlinePropertyReturn(Node parent, Node call, Node returnedValue)
private void inlineConstReturn(Node parent, Node call, Node returnedValue)
private void inlineEmptyMethod(NodeTraversal t, Node parent, Node call)
private boolean argsMayHaveSideEffects(Node call)
public void addSignature(String functionName, Node functionNode, String sourceFile)
public void removeSignature(String functionName)
public void reset()
 SignatureStore getSignatureStore()
Logger logger=Optional[Logger.getLogger(InlineSimpleMethods.class.getName())]
MethodCompilerPass.SignatureStore DUMMY_SIGNATURE_STORE=Optional[new MethodCompilerPass.SignatureStore() {

    @Override
    public void addSignature(String functionName, Node functionNode, String sourceFile) {
    }

    @Override
    public void removeSignature(String functionName) {
    }

    @Override
    public void reset() {
    }
}]