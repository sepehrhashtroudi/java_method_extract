public void testUtf8FileRoundtripExplicitUnicodeExtra() throws IOException { [EOL]     testFileRoundtrip(UTF_8, true, true); [EOL] } <line_num>: 42,45
public void testUtf8FileRoundtripNoEFSExplicitUnicodeExtra() throws IOException { [EOL]     testFileRoundtrip(UTF_8, false, true); [EOL] } <line_num>: 47,50
public void testCP437FileRoundtripExplicitUnicodeExtra() throws IOException { [EOL]     testFileRoundtrip(CP437, false, true); [EOL] } <line_num>: 52,55
public void testASCIIFileRoundtripExplicitUnicodeExtra() throws IOException { [EOL]     testFileRoundtrip(US_ASCII, false, true); [EOL] } <line_num>: 57,60
public void testUtf8FileRoundtripImplicitUnicodeExtra() throws IOException { [EOL]     testFileRoundtrip(UTF_8, true, false); [EOL] } <line_num>: 62,65
public void testUtf8FileRoundtripNoEFSImplicitUnicodeExtra() throws IOException { [EOL]     testFileRoundtrip(UTF_8, false, false); [EOL] } <line_num>: 67,70
public void testCP437FileRoundtripImplicitUnicodeExtra() throws IOException { [EOL]     testFileRoundtrip(CP437, false, false); [EOL] } <line_num>: 72,75
public void testASCIIFileRoundtripImplicitUnicodeExtra() throws IOException { [EOL]     testFileRoundtrip(US_ASCII, false, false); [EOL] } <line_num>: 77,80
public void testRead7ZipArchive() throws IOException, URISyntaxException { [EOL]     URL zip = getClass().getResource("/utf8-7zip-test.zip"); [EOL]     File archive = new File(new URI(zip.toString())); [EOL]     ZipFile zf = null; [EOL]     try { [EOL]         zf = new ZipFile(archive, CP437, false); [EOL]         assertNotNull(zf.getEntry(ASCII_TXT)); [EOL]         assertNotNull(zf.getEntry(EURO_FOR_DOLLAR_TXT)); [EOL]         assertNotNull(zf.getEntry(OIL_BARREL_TXT)); [EOL]     } finally { [EOL]         ZipFile.closeQuietly(zf); [EOL]     } [EOL] } <line_num>: 88,100
public void testReadWinZipArchive() throws IOException, URISyntaxException { [EOL]     URL zip = getClass().getResource("/utf8-winzip-test.zip"); [EOL]     File archive = new File(new URI(zip.toString())); [EOL]     ZipFile zf = null; [EOL]     try { [EOL]         zf = new ZipFile(archive, null, true); [EOL]         assertNotNull(zf.getEntry(ASCII_TXT)); [EOL]         assertNotNull(zf.getEntry(EURO_FOR_DOLLAR_TXT)); [EOL]         assertNotNull(zf.getEntry(OIL_BARREL_TXT)); [EOL]     } finally { [EOL]         ZipFile.closeQuietly(zf); [EOL]     } [EOL] } <line_num>: 106,118
public void testZipFileReadsUnicodeFields() throws IOException { [EOL]     File file = File.createTempFile("unicode-test", ".zip"); [EOL]     ZipFile zf = null; [EOL]     try { [EOL]         createTestFile(file, US_ASCII, false, true); [EOL]         zf = new ZipFile(file, US_ASCII, true); [EOL]         assertNotNull(zf.getEntry(ASCII_TXT)); [EOL]         assertNotNull(zf.getEntry(EURO_FOR_DOLLAR_TXT)); [EOL]         assertNotNull(zf.getEntry(OIL_BARREL_TXT)); [EOL]     } finally { [EOL]         ZipFile.closeQuietly(zf); [EOL]         if (file.exists()) { [EOL]             file.delete(); [EOL]         } [EOL]     } [EOL] } <line_num>: 120,135
private static void testFileRoundtrip(String encoding, boolean withEFS, boolean withExplicitUnicodeExtra) throws IOException { [EOL]     File file = File.createTempFile(encoding + "-test", ".zip"); [EOL]     try { [EOL]         createTestFile(file, encoding, withEFS, withExplicitUnicodeExtra); [EOL]         testFile(file, encoding); [EOL]     } finally { [EOL]         if (file.exists()) { [EOL]             file.delete(); [EOL]         } [EOL]     } [EOL] } <line_num>: 137,150
private static void createTestFile(File file, String encoding, boolean withEFS, boolean withExplicitUnicodeExtra) throws UnsupportedEncodingException, IOException { [EOL]     ZipEncoding zipEncoding = ZipEncodingHelper.getZipEncoding(encoding); [EOL]     ZipArchiveOutputStream zos = null; [EOL]     try { [EOL]         zos = new ZipArchiveOutputStream(file); [EOL]         zos.setEncoding(encoding); [EOL]         zos.setUseLanguageEncodingFlag(withEFS); [EOL]         zos.setCreateUnicodeExtraFields(withExplicitUnicodeExtra ? ZipArchiveOutputStream.UnicodeExtraFieldPolicy.NEVER : ZipArchiveOutputStream.UnicodeExtraFieldPolicy.ALWAYS); [EOL]         ZipArchiveEntry ze = new ZipArchiveEntry(OIL_BARREL_TXT); [EOL]         if (withExplicitUnicodeExtra && !zipEncoding.canEncode(ze.getName())) { [EOL]             ByteBuffer en = zipEncoding.encode(ze.getName()); [EOL]             ze.addExtraField(new UnicodePathExtraField(ze.getName(), en.array(), en.arrayOffset(), en.limit())); [EOL]         } [EOL]         zos.putNextEntry(ze); [EOL]         zos.write("Hello, world!".getBytes("US-ASCII")); [EOL]         zos.closeEntry(); [EOL]         ze = new ZipArchiveEntry(EURO_FOR_DOLLAR_TXT); [EOL]         if (withExplicitUnicodeExtra && !zipEncoding.canEncode(ze.getName())) { [EOL]             ByteBuffer en = zipEncoding.encode(ze.getName()); [EOL]             ze.addExtraField(new UnicodePathExtraField(ze.getName(), en.array(), en.arrayOffset(), en.limit())); [EOL]         } [EOL]         zos.putNextEntry(ze); [EOL]         zos.write("Give me your money!".getBytes("US-ASCII")); [EOL]         zos.closeEntry(); [EOL]         ze = new ZipArchiveEntry(ASCII_TXT); [EOL]         if (withExplicitUnicodeExtra && !zipEncoding.canEncode(ze.getName())) { [EOL]             ByteBuffer en = zipEncoding.encode(ze.getName()); [EOL]             ze.addExtraField(new UnicodePathExtraField(ze.getName(), en.array(), en.arrayOffset(), en.limit())); [EOL]         } [EOL]         zos.putNextEntry(ze); [EOL]         zos.write("ascii".getBytes("US-ASCII")); [EOL]         zos.closeEntry(); [EOL]     } finally { [EOL]         if (zos != null) { [EOL]             try { [EOL]                 zos.close(); [EOL]             } catch (IOException e) { [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 152,225
private static void testFile(File file, String encoding) throws IOException { [EOL]     ZipFile zf = null; [EOL]     try { [EOL]         zf = new ZipFile(file, encoding, false); [EOL]         Enumeration e = zf.getEntries(); [EOL]         while (e.hasMoreElements()) { [EOL]             ZipArchiveEntry ze = (ZipArchiveEntry) e.nextElement(); [EOL]             if (ze.getName().endsWith("sser.txt")) { [EOL]                 assertUnicodeName(ze, OIL_BARREL_TXT, encoding); [EOL]             } else if (ze.getName().endsWith("_for_Dollar.txt")) { [EOL]                 assertUnicodeName(ze, EURO_FOR_DOLLAR_TXT, encoding); [EOL]             } else if (!ze.getName().equals(ASCII_TXT)) { [EOL]                 throw new AssertionError("Urecognized ZIP entry with name [" + ze.getName() + "] found."); [EOL]             } [EOL]         } [EOL]     } finally { [EOL]         ZipFile.closeQuietly(zf); [EOL]     } [EOL] } <line_num>: 227,250
private static UnicodePathExtraField findUniCodePath(ZipArchiveEntry ze) { [EOL]     return (UnicodePathExtraField) ze.getExtraField(UnicodePathExtraField.UPATH_ID); [EOL] } <line_num>: 252,255
private static void assertUnicodeName(ZipArchiveEntry ze, String expectedName, String encoding) throws IOException { [EOL]     if (!expectedName.equals(ze.getName())) { [EOL]         UnicodePathExtraField ucpf = findUniCodePath(ze); [EOL]         assertNotNull(ucpf); [EOL]         ZipEncoding enc = ZipEncodingHelper.getZipEncoding(encoding); [EOL]         ByteBuffer ne = enc.encode(ze.getName()); [EOL]         CRC32 crc = new CRC32(); [EOL]         crc.update(ne.array(), ne.arrayOffset(), ne.limit()); [EOL]         assertEquals(crc.getValue(), ucpf.getNameCRC32()); [EOL]         assertEquals(expectedName, new String(ucpf.getUnicodeName(), UTF_8)); [EOL]     } [EOL] } <line_num>: 257,275
public void testUtf8Interoperability() throws IOException { [EOL]     File file1 = super.getFile("utf8-7zip-test.zip"); [EOL]     File file2 = super.getFile("utf8-winzip-test.zip"); [EOL]     testFile(file1, CP437); [EOL]     testFile(file2, CP437); [EOL] } <line_num>: 277,284
