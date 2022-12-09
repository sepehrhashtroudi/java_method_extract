 ProcessCommonJSModules(AbstractCompiler compiler, String filenamePrefix)
 ProcessCommonJSModules(AbstractCompiler compiler, String filenamePrefix, boolean reportDependencies)
 SuffixVarsCallback(String suffix)
public void process(Node externs, Node root)
 String guessCJSModuleName(String filename)
 JSModule getModule()
public static String toModuleName(String filename)
public static String toModuleName(String requiredFilename, String currentFilename)
private String normalizeSourceName(String filename)
public void visit(NodeTraversal t, Node n, Node parent)
private void visitRequireCall(NodeTraversal t, Node require, Node parent)
private void visitScript(NodeTraversal t, Node script)
private void emitOptionalModuleExportsOverride(Node script, String moduleName)
private void visitModuleExports(Node prop)
private Node getCurrentScriptNode(Node n)
public void visit(NodeTraversal t, Node n, Node parent)
String MODULE_SLASH=Optional["/"]
String DEFAULT_FILENAME_PREFIX=Optional["." + MODULE_SLASH]
String MODULE_NAME_SEPARATOR=Optional["\\$"]
String MODULE_NAME_PREFIX=Optional["module$"]
AbstractCompiler compiler
String filenamePrefix
boolean reportDependencies
JSModule module
