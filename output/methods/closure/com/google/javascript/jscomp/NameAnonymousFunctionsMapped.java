NameAnonymousFunctionsMapped(AbstractCompiler compiler, VariableMap previousMap) { [EOL]     this.compiler = compiler; [EOL]     Set<String> reserved = previousMap != null ? previousMap.getNewNameToOriginalNameMap().keySet() : Collections.<String>emptySet(); [EOL]     this.nameGenerator = new NameGenerator(reserved, PREFIX_STRING, null); [EOL]     this.previousMap = previousMap; [EOL]     this.renameMap = Maps.newHashMap(); [EOL] } <line_num>: 59,69
@Override [EOL] public void process(Node externs, Node root) { [EOL]     AnonymousFunctionNamingCallback namingCallback = new AnonymousFunctionNamingCallback(new MappedFunctionNamer()); [EOL]     NodeTraversal.traverse(compiler, root, namingCallback); [EOL]     logger.fine("Named " + namedCount + " anon functions using " + bytesUsed + " bytes"); [EOL]     if (namedCount > 0) { [EOL]         compiler.reportCodeChange(); [EOL]     } [EOL] } <line_num>: 71,81
@Override [EOL] public final String getName(Node node) { [EOL]     switch(node.getType()) { [EOL]         case Token.NAME: [EOL]         case Token.STRING: [EOL]         case Token.STRING_KEY: [EOL]             return node.getString(); [EOL]         default: [EOL]             return new CodePrinter.Builder(node).build(); [EOL]     } [EOL] } <line_num>: 93,103
@Override [EOL] public final void setFunctionName(String name, Node fnNode) { [EOL]     Node fnNameNode = fnNode.getFirstChild(); [EOL]     String newName = getAlternateName(name); [EOL]     fnNameNode.setString(newName); [EOL]     namedCount++; [EOL]     bytesUsed += newName.length(); [EOL] } <line_num>: 105,112
String getAlternateName(String name) { [EOL]     String newName = renameMap.get(name); [EOL]     if (newName == null) { [EOL]         if (previousMap != null) { [EOL]             newName = previousMap.lookupNewName(name); [EOL]         } [EOL]         if (newName == null) { [EOL]             newName = nameGenerator.generateNextName(); [EOL]         } [EOL]         renameMap.put(name, newName); [EOL]     } [EOL]     return newName; [EOL] } <line_num>: 114,128
@Override [EOL] public final String getCombinedName(String lhs, String rhs) { [EOL]     return lhs + DELIMITER + rhs; [EOL] } <line_num>: 130,133
VariableMap getFunctionMap() { [EOL]     return new VariableMap(ImmutableMap.copyOf(renameMap)); [EOL] } <line_num>: 141,143