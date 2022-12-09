ParseState(String contents) { [EOL]     this.contents = contents; [EOL] } <line_num>: 55,57
FileName(String directory, String name) { [EOL]     this.dir = directory; [EOL]     this.name = name; [EOL] } <line_num>: 208,211
LineFragment(int startIndex, byte[] offsets) { [EOL]     this.startIndex = startIndex; [EOL]     this.offsets = offsets; [EOL] } <line_num>: 438,441
private SourceFile(String dir, String fileName, int startLine, int startMapId, byte[] lineOffsets, short[] columns, String[] identifiers) { [EOL]     this.fileName = Preconditions.checkNotNull(fileName); [EOL]     this.dir = Preconditions.checkNotNull(dir); [EOL]     this.startLine = startLine; [EOL]     this.startMapId = startMapId; [EOL]     this.lineOffsets = Preconditions.checkNotNull(lineOffsets); [EOL]     this.columns = Preconditions.checkNotNull(columns); [EOL]     this.identifiers = Preconditions.checkNotNull(identifiers); [EOL]     Preconditions.checkArgument(lineOffsets.length == columns.length && columns.length == identifiers.length); [EOL] } <line_num>: 481,493
private SourceFile(int startMapId) { [EOL]     this.startMapId = startMapId; [EOL]     this.fileName = null; [EOL]     this.dir = null; [EOL]     this.startLine = 0; [EOL]     this.lineOffsets = null; [EOL]     this.columns = null; [EOL]     this.identifiers = null; [EOL] } <line_num>: 495,505
String readLineOrNull() { [EOL]     if (currentPosition >= contents.length()) { [EOL]         return null; [EOL]     } [EOL]     int index = contents.indexOf('\n', currentPosition); [EOL]     if (index < 0) { [EOL]         index = contents.length(); [EOL]     } [EOL]     String line = contents.substring(currentPosition, index); [EOL]     currentPosition = index + 1; [EOL]     return line; [EOL] } <line_num>: 60,71
String readLine() throws SourceMapParseException { [EOL]     String line = readLineOrNull(); [EOL]     if (line == null) { [EOL]         fail("EOF"); [EOL]     } [EOL]     return line; [EOL] } <line_num>: 74,80
void expectLine(String expect) throws SourceMapParseException { [EOL]     String line = readLine(); [EOL]     if (!expect.equals(line)) { [EOL]         fail("Expected " + expect + " got " + line); [EOL]     } [EOL] } <line_num>: 86,91
void fail(String message) throws SourceMapParseException { [EOL]     throw new SourceMapParseException(message); [EOL] } <line_num>: 96,98
@Override [EOL] public void parse(String contents) throws SourceMapParseException { [EOL]     ParseState parser = new ParseState(contents); [EOL]     try { [EOL]         parseInternal(parser); [EOL]     } catch (JSONException ex) { [EOL]         parser.fail("JSON parse exception: " + ex); [EOL]     } [EOL] } <line_num>: 120,128
private int parseCharacterMap(ParseState parser, int lineCount, ImmutableList.Builder<ImmutableList<LineFragment>> characterMapBuilder) throws SourceMapParseException, JSONException { [EOL]     int maxID = -1; [EOL]     for (int i = 0; i < lineCount; ++i) { [EOL]         String currentLine = parser.readLine(); [EOL]         if (currentLine.isEmpty()) { [EOL]             continue; [EOL]         } [EOL]         ImmutableList.Builder<LineFragment> fragmentList = ImmutableList.builder(); [EOL]         LineFragment myLineFragment = null; [EOL]         JSONArray charArray = new JSONArray(currentLine); [EOL]         int numOffsets = charArray.length(); [EOL]         int lastID = -1; [EOL]         int startID = Integer.MIN_VALUE; [EOL]         List<Byte> currentOffsets = Lists.newArrayList(); [EOL]         for (int j = 0; j < charArray.length(); ++j) { [EOL]             int mappingID = lastID; [EOL]             if (!charArray.isNull(j)) { [EOL]                 mappingID = charArray.optInt(j); [EOL]                 if (mappingID > maxID) { [EOL]                     maxID = mappingID; [EOL]                 } [EOL]             } [EOL]             if (startID == Integer.MIN_VALUE) { [EOL]                 startID = mappingID; [EOL]             } else { [EOL]                 if (mappingID - lastID > Byte.MAX_VALUE || mappingID - lastID < Byte.MIN_VALUE) { [EOL]                     myLineFragment = new LineFragment(startID, Bytes.toArray(currentOffsets)); [EOL]                     currentOffsets.clear(); [EOL]                     fragmentList.add(myLineFragment); [EOL]                     startID = mappingID; [EOL]                 } else { [EOL]                     currentOffsets.add((byte) (mappingID - lastID)); [EOL]                 } [EOL]             } [EOL]             lastID = mappingID; [EOL]         } [EOL]         if (startID != Integer.MIN_VALUE) { [EOL]             myLineFragment = new LineFragment(startID, Bytes.toArray(currentOffsets)); [EOL]             fragmentList.add(myLineFragment); [EOL]         } [EOL]         characterMapBuilder.add(fragmentList.build()); [EOL]     } [EOL]     return maxID; [EOL] } <line_num>: 137,202
private FileName splitFileName(Interner<String> interner, String input) { [EOL]     int hashIndex = input.lastIndexOf('/'); [EOL]     String dir = interner.intern(input.substring(0, hashIndex + 1)); [EOL]     String fileName = interner.intern(input.substring(hashIndex + 1)); [EOL]     return new FileName(dir, fileName); [EOL] } <line_num>: 221,227
private void parseFileMappings(ParseState parser, int maxID) throws SourceMapParseException, JSONException { [EOL]     Interner<String> interner = Interners.newStrongInterner(); [EOL]     ImmutableList.Builder<SourceFile> mappingsBuilder = ImmutableList.builder(); [EOL]     ArrayList<Byte> lineOffsets = Lists.newArrayList(); [EOL]     ArrayList<Short> columns = Lists.newArrayList(); [EOL]     ArrayList<String> identifiers = Lists.newArrayList(); [EOL]     String currentFile = null; [EOL]     int lastLine = -1; [EOL]     int startLine = -1; [EOL]     int startMapId = -1; [EOL]     for (int mappingId = 0; mappingId <= maxID; ++mappingId) { [EOL]         String currentLine = parser.readLine(); [EOL]         JSONArray mapArray = new JSONArray(currentLine); [EOL]         if (mapArray.length() < 3) { [EOL]             parser.fail("Invalid mapping array"); [EOL]         } [EOL]         String myFile = mapArray.getString(0); [EOL]         int line = mapArray.getInt(1); [EOL]         if (!myFile.equals(currentFile) || (line - lastLine) > Byte.MAX_VALUE || (line - lastLine) < Byte.MIN_VALUE) { [EOL]             if (currentFile != null) { [EOL]                 FileName dirFile = splitFileName(interner, currentFile); [EOL]                 SourceFile.Builder builder = SourceFile.newBuilder().setDir(dirFile.dir).setFileName(dirFile.name).setStartLine(startLine).setStartMapId(startMapId).setLineOffsets(lineOffsets).setColumns(columns).setIdentifiers(identifiers); [EOL]                 mappingsBuilder.add(builder.build()); [EOL]             } [EOL]             currentFile = myFile; [EOL]             startLine = line; [EOL]             lastLine = line; [EOL]             startMapId = mappingId; [EOL]             columns.clear(); [EOL]             lineOffsets.clear(); [EOL]             identifiers.clear(); [EOL]         } [EOL]         lineOffsets.add((byte) (line - lastLine)); [EOL]         columns.add((short) mapArray.getInt(2)); [EOL]         identifiers.add(interner.intern(mapArray.optString(3, ""))); [EOL]         lastLine = line; [EOL]     } [EOL]     if (currentFile != null) { [EOL]         FileName dirFile = splitFileName(interner, currentFile); [EOL]         SourceFile.Builder builder = SourceFile.newBuilder().setDir(dirFile.dir).setFileName(dirFile.name).setStartLine(startLine).setStartMapId(startMapId).setLineOffsets(lineOffsets).setColumns(columns).setIdentifiers(identifiers); [EOL]         mappingsBuilder.add(builder.build()); [EOL]     } [EOL]     mappings = mappingsBuilder.build(); [EOL] } <line_num>: 236,309
private void parseInternal(ParseState parser) throws SourceMapParseException, JSONException { [EOL]     String headerCount = parser.readLine(); [EOL]     Preconditions.checkArgument(headerCount.startsWith(LINEMAP_HEADER), "Expected %s", LINEMAP_HEADER); [EOL]     JSONObject countObject = new JSONObject(headerCount.substring(LINEMAP_HEADER.length())); [EOL]     if (!countObject.has("count")) { [EOL]         parser.fail("Missing 'count'"); [EOL]     } [EOL]     int lineCount = countObject.getInt("count"); [EOL]     if (lineCount <= 0) { [EOL]         parser.fail("Count must be >= 1"); [EOL]     } [EOL]     ImmutableList.Builder<ImmutableList<LineFragment>> characterMapBuilder = ImmutableList.builder(); [EOL]     int maxId = parseCharacterMap(parser, lineCount, characterMapBuilder); [EOL]     characterMap = characterMapBuilder.build(); [EOL]     parser.expectLine(FILEINFO_HEADER); [EOL]     for (int i = 0; i < lineCount; i++) { [EOL]         parser.readLine(); [EOL]     } [EOL]     parser.expectLine(DEFINITION_HEADER); [EOL]     parseFileMappings(parser, maxId); [EOL] } <line_num>: 311,345
@Override [EOL] public OriginalMapping getMappingForLine(int lineNumber, int columnIndex) { [EOL]     Preconditions.checkNotNull(characterMap, "parse() must be called first"); [EOL]     if (lineNumber < 1 || lineNumber > characterMap.size() || columnIndex < 1) { [EOL]         return null; [EOL]     } [EOL]     List<LineFragment> lineFragments = characterMap.get(lineNumber - 1); [EOL]     if (lineFragments == null || lineFragments.isEmpty()) { [EOL]         return null; [EOL]     } [EOL]     int columnOffset = 0; [EOL]     LineFragment lastFragment = lineFragments.get(lineFragments.size() - 1); [EOL]     int mapId = lastFragment.valueAtColumn(lastFragment.length()); [EOL]     for (LineFragment lineFragment : lineFragments) { [EOL]         int columnPosition = columnIndex - columnOffset; [EOL]         if (columnPosition <= lineFragment.length()) { [EOL]             mapId = lineFragment.valueAtColumn(columnPosition); [EOL]             break; [EOL]         } [EOL]         columnOffset += lineFragment.length(); [EOL]     } [EOL]     if (mapId < 0) { [EOL]         return null; [EOL]     } [EOL]     return getMappingFromId(mapId); [EOL] } <line_num>: 347,379
private SourceFile binarySearch(int mapId) { [EOL]     int lower = 0; [EOL]     int upper = mappings.size() - 1; [EOL]     while (lower <= upper) { [EOL]         int middle = lower + (upper - lower) / 2; [EOL]         SourceFile middleCompare = mappings.get(middle); [EOL]         if (mapId < middleCompare.getStartMapId()) { [EOL]             upper = middle - 1; [EOL]         } else if (mapId < (middleCompare.getStartMapId() + middleCompare.getLength())) { [EOL]             return middleCompare; [EOL]         } else { [EOL]             lower = middle + 1; [EOL]         } [EOL]     } [EOL]     return null; [EOL] } <line_num>: 387,405
private OriginalMapping getMappingFromId(int mapID) { [EOL]     SourceFile match = binarySearch(mapID); [EOL]     if (match == null) { [EOL]         return null; [EOL]     } [EOL]     int pos = mapID - match.getStartMapId(); [EOL]     return match.getOriginalMapping(pos); [EOL] } <line_num>: 413,420
int length() { [EOL]     return offsets.length + 1; [EOL] } <line_num>: 447,449
int valueAtColumn(int column) { [EOL]     Preconditions.checkArgument(column > 0); [EOL]     int pos = startIndex; [EOL]     for (int i = 0; i < column - 1; i++) { [EOL]         pos += offsets[i]; [EOL]     } [EOL]     return pos; [EOL] } <line_num>: 457,464
int getLength() { [EOL]     return lineOffsets.length; [EOL] } <line_num>: 510,512
int getStartMapId() { [EOL]     return startMapId; [EOL] } <line_num>: 517,519
OriginalMapping getOriginalMapping(int offset) { [EOL]     int lineNumber = this.startLine; [EOL]     for (int i = 0; i <= offset; i++) { [EOL]         lineNumber += lineOffsets[i]; [EOL]     } [EOL]     OriginalMapping.Builder builder = OriginalMapping.newBuilder().setOriginalFile(dir + fileName).setLineNumber(lineNumber).setColumnPosition(columns[offset]).setIdentifier(identifiers[offset]); [EOL]     return builder.build(); [EOL] } <line_num>: 527,539
Builder setDir(String dir) { [EOL]     this.dir = dir; [EOL]     return this; [EOL] } <line_num>: 553,556
Builder setFileName(String fileName) { [EOL]     this.fileName = fileName; [EOL]     return this; [EOL] } <line_num>: 558,561
Builder setStartMapId(int startMapId) { [EOL]     this.startMapId = startMapId; [EOL]     return this; [EOL] } <line_num>: 563,566
Builder setStartLine(int startLine) { [EOL]     this.startLine = startLine; [EOL]     return this; [EOL] } <line_num>: 568,571
Builder setLineOffsets(List<Byte> lineOffsets) { [EOL]     this.lineOffsets = Bytes.toArray(lineOffsets); [EOL]     return this; [EOL] } <line_num>: 573,576
Builder setColumns(List<Short> columns) { [EOL]     this.columns = Shorts.toArray(columns); [EOL]     return this; [EOL] } <line_num>: 578,581
Builder setIdentifiers(List<String> identifiers) { [EOL]     this.identifiers = identifiers.toArray(new String[0]); [EOL]     return this; [EOL] } <line_num>: 583,586
SourceFile build() { [EOL]     return new SourceFile(dir, fileName, startLine, startMapId, lineOffsets, columns, identifiers); [EOL] } <line_num>: 591,594
static Builder newBuilder() { [EOL]     return new Builder(); [EOL] } <line_num>: 597,599