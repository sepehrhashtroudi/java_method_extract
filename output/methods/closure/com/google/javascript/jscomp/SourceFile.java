public SourceFile(String fileName) { [EOL]     if (fileName == null || fileName.isEmpty()) { [EOL]         throw new IllegalArgumentException("a source must have a name"); [EOL]     } [EOL]     this.fileName = fileName; [EOL] } <line_num>: 81,86
public Builder() { [EOL] } <line_num>: 368,368
Preloaded(String fileName, String originalPath, String code) { [EOL]     super(fileName); [EOL]     super.setOriginalPath(originalPath); [EOL]     super.setCode(code); [EOL] } <line_num>: 421,425
Generated(String fileName, String originalPath, Generator generator) { [EOL]     super(fileName); [EOL]     super.setOriginalPath(originalPath); [EOL]     this.generator = generator; [EOL] } <line_num>: 437,441
OnDisk(File file, String originalPath, Charset c) { [EOL]     super(file.getPath()); [EOL]     this.file = file; [EOL]     super.setOriginalPath(originalPath); [EOL]     if (c != null) { [EOL]         this.setCharset(c); [EOL]     } [EOL] } <line_num>: 476,483
public String getCode(); <line_num>: 50,50
@Override [EOL] public int getLineOffset(int lineno) { [EOL]     findLineOffsets(); [EOL]     if (lineno < 1 || lineno > lineOffsets.length) { [EOL]         throw new IllegalArgumentException("Expected line number between 1 and " + lineOffsets.length + "\nActual: " + lineno); [EOL]     } [EOL]     return lineOffsets[lineno - 1]; [EOL] } <line_num>: 88,97
int getNumLines() { [EOL]     findLineOffsets(); [EOL]     return lineOffsets.length; [EOL] } <line_num>: 100,103
private void findLineOffsets() { [EOL]     if (lineOffsets != null) { [EOL]         return; [EOL]     } [EOL]     try { [EOL]         String[] sourceLines = getCode().split("\n"); [EOL]         lineOffsets = new int[sourceLines.length]; [EOL]         for (int ii = 1; ii < sourceLines.length; ++ii) { [EOL]             lineOffsets[ii] = lineOffsets[ii - 1] + sourceLines[ii - 1].length() + 1; [EOL]         } [EOL]     } catch (IOException e) { [EOL]         lineOffsets = new int[1]; [EOL]         lineOffsets[0] = 0; [EOL]     } [EOL] } <line_num>: 106,121
public String getCode() throws IOException { [EOL]     return code; [EOL] } <line_num>: 131,133
public Reader getCodeReader() throws IOException { [EOL]     return new StringReader(getCode()); [EOL] } <line_num>: 138,140
@VisibleForTesting [EOL] String getCodeNoCache() { [EOL]     return code; [EOL] } <line_num>: 142,145
private void setCode(String sourceCode) { [EOL]     code = sourceCode; [EOL] } <line_num>: 147,149
public String getOriginalPath() { [EOL]     return originalPath != null ? originalPath : fileName; [EOL] } <line_num>: 151,153
public void setOriginalPath(String originalPath) { [EOL]     this.originalPath = originalPath; [EOL] } <line_num>: 155,157
public void clearCachedSource() { [EOL] } <line_num>: 163,166
boolean hasSourceInMemory() { [EOL]     return code != null; [EOL] } <line_num>: 168,170
@Override [EOL] public String getName() { [EOL]     return fileName; [EOL] } <line_num>: 173,176
@Override [EOL] public boolean isExtern() { [EOL]     return isExternFile; [EOL] } <line_num>: 179,182
void setIsExtern(boolean newVal) { [EOL]     isExternFile = newVal; [EOL] } <line_num>: 185,187
@Override [EOL] public int getLineOfOffset(int offset) { [EOL]     findLineOffsets(); [EOL]     int search = Arrays.binarySearch(lineOffsets, offset); [EOL]     if (search >= 0) { [EOL]         return search + 1; [EOL]     } else { [EOL]         int insertionPoint = -1 * (search + 1); [EOL]         return Math.min(insertionPoint - 1, lineOffsets.length - 1) + 1; [EOL]     } [EOL] } <line_num>: 189,199
@Override [EOL] public int getColumnOfOffset(int offset) { [EOL]     int line = getLineOfOffset(offset); [EOL]     return offset - lineOffsets[line - 1]; [EOL] } <line_num>: 201,205
public String getLine(int lineNumber) { [EOL]     findLineOffsets(); [EOL]     if (lineNumber > lineOffsets.length) { [EOL]         return null; [EOL]     } [EOL]     if (lineNumber < 1) { [EOL]         lineNumber = 1; [EOL]     } [EOL]     int pos = lineOffsets[lineNumber - 1]; [EOL]     String js = ""; [EOL]     try { [EOL]         js = getCode(); [EOL]     } catch (IOException e) { [EOL]         return null; [EOL]     } [EOL]     if (js.indexOf('\n', pos) == -1) { [EOL]         if (pos >= js.length()) { [EOL]             return null; [EOL]         } else { [EOL]             return js.substring(pos, js.length()); [EOL]         } [EOL]     } else { [EOL]         return js.substring(pos, js.indexOf('\n', pos)); [EOL]     } [EOL] } <line_num>: 215,248
public Region getRegion(int lineNumber) { [EOL]     String js = ""; [EOL]     try { [EOL]         js = getCode(); [EOL]     } catch (IOException e) { [EOL]         return null; [EOL]     } [EOL]     int pos = 0; [EOL]     int startLine = Math.max(1, lineNumber - (SOURCE_EXCERPT_REGION_LENGTH + 1) / 2 + 1); [EOL]     for (int n = 1; n < startLine; n++) { [EOL]         int nextpos = js.indexOf('\n', pos); [EOL]         if (nextpos == -1) { [EOL]             break; [EOL]         } [EOL]         pos = nextpos + 1; [EOL]     } [EOL]     int end = pos; [EOL]     int endLine = startLine; [EOL]     for (int n = 0; n < SOURCE_EXCERPT_REGION_LENGTH; n++, endLine++) { [EOL]         end = js.indexOf('\n', end); [EOL]         if (end == -1) { [EOL]             break; [EOL]         } [EOL]         end++; [EOL]     } [EOL]     if (lineNumber >= endLine) { [EOL]         return null; [EOL]     } [EOL]     if (end == -1) { [EOL]         int last = js.length() - 1; [EOL]         if (js.charAt(last) == '\n') { [EOL]             return new SimpleRegion(startLine, endLine, js.substring(pos, last)); [EOL]         } else { [EOL]             return new SimpleRegion(startLine, endLine, js.substring(pos)); [EOL]         } [EOL]     } else { [EOL]         return new SimpleRegion(startLine, endLine, js.substring(pos, end)); [EOL]     } [EOL] } <line_num>: 259,299
@Override [EOL] public String toString() { [EOL]     return fileName; [EOL] } <line_num>: 301,304
public static SourceFile fromFile(String fileName, Charset c) { [EOL]     return builder().withCharset(c).buildFromFile(fileName); [EOL] } <line_num>: 306,308
public static SourceFile fromFile(String fileName) { [EOL]     return builder().buildFromFile(fileName); [EOL] } <line_num>: 310,312
public static SourceFile fromFile(File file, Charset c) { [EOL]     return builder().withCharset(c).buildFromFile(file); [EOL] } <line_num>: 314,316
public static SourceFile fromFile(File file) { [EOL]     return builder().buildFromFile(file); [EOL] } <line_num>: 318,320
public static SourceFile fromCode(String fileName, String code) { [EOL]     return builder().buildFromCode(fileName, code); [EOL] } <line_num>: 322,324
public static SourceFile fromCode(String fileName, String originalPath, String code) { [EOL]     return builder().withOriginalPath(originalPath).buildFromCode(fileName, code); [EOL] } <line_num>: 326,330
public static SourceFile fromInputStream(String fileName, InputStream s) throws IOException { [EOL]     return builder().buildFromInputStream(fileName, s); [EOL] } <line_num>: 332,335
public static SourceFile fromInputStream(String fileName, String originalPath, InputStream s) throws IOException { [EOL]     return builder().withOriginalPath(originalPath).buildFromInputStream(fileName, s); [EOL] } <line_num>: 337,341
public static SourceFile fromReader(String fileName, Reader r) throws IOException { [EOL]     return builder().buildFromReader(fileName, r); [EOL] } <line_num>: 343,346
public static SourceFile fromGenerator(String fileName, Generator generator) { [EOL]     return builder().buildFromGenerator(fileName, generator); [EOL] } <line_num>: 348,351
public static Builder builder() { [EOL]     return new Builder(); [EOL] } <line_num>: 354,356
public Builder withCharset(Charset charset) { [EOL]     this.charset = charset; [EOL]     return this; [EOL] } <line_num>: 371,374
public Builder withOriginalPath(String originalPath) { [EOL]     this.originalPath = originalPath; [EOL]     return this; [EOL] } <line_num>: 377,380
public SourceFile buildFromFile(String fileName) { [EOL]     return buildFromFile(new File(fileName)); [EOL] } <line_num>: 382,384
public SourceFile buildFromFile(File file) { [EOL]     return new OnDisk(file, originalPath, charset); [EOL] } <line_num>: 386,388
public SourceFile buildFromCode(String fileName, String code) { [EOL]     return new Preloaded(fileName, originalPath, code); [EOL] } <line_num>: 390,392
public SourceFile buildFromInputStream(String fileName, InputStream s) throws IOException { [EOL]     return buildFromCode(fileName, CharStreams.toString(new InputStreamReader(s, charset))); [EOL] } <line_num>: 394,398
public SourceFile buildFromReader(String fileName, Reader r) throws IOException { [EOL]     return buildFromCode(fileName, CharStreams.toString(r)); [EOL] } <line_num>: 400,403
public SourceFile buildFromGenerator(String fileName, Generator generator) { [EOL]     return new Generated(fileName, originalPath, generator); [EOL] } <line_num>: 405,408
@Override [EOL] public synchronized String getCode() throws IOException { [EOL]     String cachedCode = super.getCode(); [EOL]     if (cachedCode == null) { [EOL]         cachedCode = generator.getCode(); [EOL]         super.setCode(cachedCode); [EOL]     } [EOL]     return cachedCode; [EOL] } <line_num>: 443,452
@Override [EOL] public void clearCachedSource() { [EOL]     super.setCode(null); [EOL] } <line_num>: 456,459
@Override [EOL] public synchronized String getCode() throws IOException { [EOL]     String cachedCode = super.getCode(); [EOL]     if (cachedCode == null) { [EOL]         cachedCode = Files.toString(file, this.getCharset()); [EOL]         super.setCode(cachedCode); [EOL]     } [EOL]     return cachedCode; [EOL] } <line_num>: 485,494
@Override [EOL] public Reader getCodeReader() throws IOException { [EOL]     if (hasSourceInMemory()) { [EOL]         return super.getCodeReader(); [EOL]     } else { [EOL]         return new FileReader(file); [EOL]     } [EOL] } <line_num>: 499,507
@Override [EOL] public void clearCachedSource() { [EOL]     super.setCode(null); [EOL] } <line_num>: 511,514
public void setCharset(Charset c) { [EOL]     inputCharset = c.name(); [EOL] } <line_num>: 522,524
public Charset getCharset() { [EOL]     return Charset.forName(inputCharset); [EOL] } <line_num>: 532,534
