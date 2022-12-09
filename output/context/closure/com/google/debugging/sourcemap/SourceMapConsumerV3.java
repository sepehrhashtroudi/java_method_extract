public SourceMapConsumerV3()
 MappingBuilder(String lineMap)
 StringCharIterator(String content)
 UnmappedEntry(int column)
 UnnamedEntry(int column, int srcFile, int srcLine, int srcColumn)
 NamedEntry(int column, int srcFile, int srcLine, int srcColumn, int name)
public String getSourceMap(String url)
public void parse(String contents) throws SourceMapParseException
public void parse(String contents, SourceMapSupplier sectionSupplier) throws SourceMapParseException
public void parse(JSONObject sourceMapRoot) throws SourceMapParseException
public void parse(JSONObject sourceMapRoot, SourceMapSupplier sectionSupplier) throws SourceMapParseException
private void parseMetaMap(JSONObject sourceMapRoot, SourceMapSupplier sectionSupplier) throws SourceMapParseException
public OriginalMapping getMappingForLine(int lineNumber, int column)
public Collection<String> getOriginalSources()
public Collection<OriginalMapping> getReverseMapping(String originalFile, int line, int column)
private String[] getJavaStringArray(JSONArray array) throws JSONException
 void build()
private void validateEntry(Entry entry)
private Entry decodeEntry(int[] vals, int entryValues)
private boolean tryConsumeToken(char token)
private boolean entryComplete()
private int nextValue()
private int search(ArrayList<Entry> entries, int target, int start, int end)
private int compareEntry(ArrayList<Entry> entries, int entry, int target)
private OriginalMapping getPreviousMapping(int lineNumber)
private OriginalMapping getOriginalMappingForEntry(Entry entry)
private void createReverseMapping()
public char next()
 char peek()
public boolean hasNext()
 int getGeneratedColumn()
 int getSourceFileId()
 int getSourceLine()
 int getSourceColumn()
 int getNameId()
public int getGeneratedColumn()
public int getSourceFileId()
public int getSourceLine()
public int getSourceColumn()
public int getNameId()
public int getSourceFileId()
public int getSourceLine()
public int getSourceColumn()
public int getNameId()
public int getNameId()
 void visit(String sourceName, String symbolName, FilePosition sourceStartPosition, FilePosition startPosition, FilePosition endPosition)
public void visitMappings(EntryVisitor visitor)
int UNMAPPED=Optional[-1]
String[] sources
String[] names
int lineCount
ArrayList<ArrayList<Entry>> lines=Optional[null]
Map<String, Map<Integer, Collection<OriginalMapping>>> reverseSourceMapping