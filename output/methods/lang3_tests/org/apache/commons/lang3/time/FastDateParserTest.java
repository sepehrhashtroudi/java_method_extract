DateParser getInstance(final String format) { [EOL]     return getInstance(format, TimeZone.getDefault(), Locale.getDefault()); [EOL] } <line_num>: 61,63
private DateParser getDateInstance(final int dateStyle, final Locale locale) { [EOL]     return getInstance(FormatCache.getPatternForStyle(Integer.valueOf(dateStyle), null, locale), TimeZone.getDefault(), Locale.getDefault()); [EOL] } <line_num>: 65,67
private DateParser getInstance(final String format, final Locale locale) { [EOL]     return getInstance(format, TimeZone.getDefault(), locale); [EOL] } <line_num>: 69,71
private DateParser getInstance(final String format, final TimeZone timeZone) { [EOL]     return getInstance(format, timeZone, Locale.getDefault()); [EOL] } <line_num>: 73,75
protected DateParser getInstance(final String format, final TimeZone timeZone, final Locale locale) { [EOL]     return new FastDateParser(format, timeZone, locale); [EOL] } <line_num>: 80,82
@Test [EOL] public void test_Equality_Hash() { [EOL]     final DateParser[] parsers = { getInstance(yMdHmsSZ, NEW_YORK, Locale.US), getInstance(DMY_DOT, NEW_YORK, Locale.US), getInstance(YMD_SLASH, NEW_YORK, Locale.US), getInstance(MDY_DASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, SWEDEN) }; [EOL]     final Map<DateParser, Integer> map = new HashMap<DateParser, Integer>(); [EOL]     int i = 0; [EOL]     for (final DateParser parser : parsers) { [EOL]         map.put(parser, Integer.valueOf(i++)); [EOL]     } [EOL]     i = 0; [EOL]     for (final DateParser parser : parsers) { [EOL]         assertEquals(i++, map.get(parser).intValue()); [EOL]     } [EOL] } <line_num>: 84,106
@Test [EOL] public void testParseZone() { [EOL] } <line_num>: 108,109
@Test [EOL] public void testParseLongShort() throws ParseException { [EOL]     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); [EOL]     cal.clear(); [EOL]     cal.set(2003, 1, 10, 15, 33, 20); [EOL]     cal.set(Calendar.MILLISECOND, 989); [EOL]     cal.setTimeZone(NEW_YORK); [EOL]     DateParser fdf = getInstance("yyyy GGGG MMMM dddd aaaa EEEE HHHH mmmm ssss SSSS ZZZZ", NEW_YORK, Locale.US); [EOL]     assertEquals(cal.getTime(), fdf.parse("2003 AD February 0010 PM Monday 0015 0033 0020 0989 GMT-05:00")); [EOL]     cal.set(Calendar.ERA, GregorianCalendar.BC); [EOL]     final Date parse = fdf.parse("2003 BC February 0010 PM Saturday 0015 0033 0020 0989 GMT-05:00"); [EOL]     assertEquals(cal.getTime(), parse); [EOL]     fdf = getInstance("y G M d a E H m s S Z", NEW_YORK, Locale.US); [EOL]     assertEquals(cal.getTime(), fdf.parse("03 BC 2 10 PM Sat 15 33 20 989 -0500")); [EOL]     cal.set(Calendar.ERA, GregorianCalendar.AD); [EOL]     assertEquals(cal.getTime(), fdf.parse("03 AD 2 10 PM Saturday 15 33 20 989 -0500")); [EOL] } <line_num>: 135,156
@Test [EOL] public void testAmPm() throws ParseException { [EOL]     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); [EOL]     cal.clear(); [EOL]     final DateParser h = getInstance("yyyy-MM-dd hh a mm:ss", NEW_YORK, Locale.US); [EOL]     final DateParser K = getInstance("yyyy-MM-dd KK a mm:ss", NEW_YORK, Locale.US); [EOL]     final DateParser k = getInstance("yyyy-MM-dd kk:mm:ss", NEW_YORK, Locale.US); [EOL]     final DateParser H = getInstance("yyyy-MM-dd HH:mm:ss", NEW_YORK, Locale.US); [EOL]     cal.set(2010, 7, 1, 0, 33, 20); [EOL]     assertEquals(cal.getTime(), h.parse("2010-08-01 12 AM 33:20")); [EOL]     assertEquals(cal.getTime(), K.parse("2010-08-01 0 AM 33:20")); [EOL]     assertEquals(cal.getTime(), k.parse("2010-08-01 00:33:20")); [EOL]     assertEquals(cal.getTime(), H.parse("2010-08-01 00:33:20")); [EOL]     cal.set(2010, 7, 1, 3, 33, 20); [EOL]     assertEquals(cal.getTime(), h.parse("2010-08-01 3 AM 33:20")); [EOL]     assertEquals(cal.getTime(), K.parse("2010-08-01 3 AM 33:20")); [EOL]     assertEquals(cal.getTime(), k.parse("2010-08-01 03:33:20")); [EOL]     assertEquals(cal.getTime(), H.parse("2010-08-01 03:33:20")); [EOL]     cal.set(2010, 7, 1, 15, 33, 20); [EOL]     assertEquals(cal.getTime(), h.parse("2010-08-01 3 PM 33:20")); [EOL]     assertEquals(cal.getTime(), K.parse("2010-08-01 3 PM 33:20")); [EOL]     assertEquals(cal.getTime(), k.parse("2010-08-01 15:33:20")); [EOL]     assertEquals(cal.getTime(), H.parse("2010-08-01 15:33:20")); [EOL]     cal.set(2010, 7, 1, 12, 33, 20); [EOL]     assertEquals(cal.getTime(), h.parse("2010-08-01 12 PM 33:20")); [EOL]     assertEquals(cal.getTime(), K.parse("2010-08-01 0 PM 33:20")); [EOL]     assertEquals(cal.getTime(), k.parse("2010-08-01 12:33:20")); [EOL]     assertEquals(cal.getTime(), H.parse("2010-08-01 12:33:20")); [EOL] } <line_num>: 158,191
@Test [EOL] public void testParses() throws Exception { [EOL]     for (final Locale locale : Locale.getAvailableLocales()) { [EOL]         for (final TimeZone tz : new TimeZone[] { NEW_YORK, GMT }) { [EOL]             final Calendar cal = Calendar.getInstance(tz); [EOL]             for (final int year : new int[] { 2003, 1940, 1868, 1867, 0, -1940 }) { [EOL]                 if (year < 1868 && locale.equals(FastDateParser.JAPANESE_IMPERIAL)) { [EOL]                     continue; [EOL]                 } [EOL]                 cal.clear(); [EOL]                 if (year < 0) { [EOL]                     cal.set(-year, 1, 10); [EOL]                     cal.set(Calendar.ERA, GregorianCalendar.BC); [EOL]                 } else { [EOL]                     cal.set(year, 1, 10); [EOL]                 } [EOL]                 final Date in = cal.getTime(); [EOL]                 for (final String format : new String[] { LONG_FORMAT, SHORT_FORMAT }) { [EOL]                     final SimpleDateFormat sdf = new SimpleDateFormat(format, locale); [EOL]                     if (format.equals(SHORT_FORMAT)) { [EOL]                         if (year < 1930) { [EOL]                             sdf.set2DigitYearStart(cal.getTime()); [EOL]                         } [EOL]                     } [EOL]                     final String fmt = sdf.format(in); [EOL]                     try { [EOL]                         final Date out = sdf.parse(fmt); [EOL]                         assertEquals(locale.toString() + " " + year + " " + format + " " + tz.getID(), in, out); [EOL]                     } catch (final ParseException pe) { [EOL]                         System.out.println(fmt + " " + locale.toString() + " " + year + " " + format + " " + tz.getID()); [EOL]                         throw pe; [EOL]                     } [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 193,232
@Test [EOL] public void testLocales_Long_AD() throws Exception { [EOL]     testLocales(LONG_FORMAT, false); [EOL] } <line_num>: 234,237
@Test [EOL] public void testLocales_Long_BC() throws Exception { [EOL]     testLocales(LONG_FORMAT, true); [EOL] } <line_num>: 239,242
@Test [EOL] public void testLocales_Short_AD() throws Exception { [EOL]     testLocales(SHORT_FORMAT, false); [EOL] } <line_num>: 244,247
@Test [EOL] public void testLocales_Short_BC() throws Exception { [EOL]     testLocales(SHORT_FORMAT, true); [EOL] } <line_num>: 249,252
@Test [EOL] public void testLocales_LongNoEra_AD() throws Exception { [EOL]     testLocales(LONG_FORMAT_NOERA, false); [EOL] } <line_num>: 254,257
@Test [EOL] public void testLocales_LongNoEra_BC() throws Exception { [EOL]     testLocales(LONG_FORMAT_NOERA, true); [EOL] } <line_num>: 259,262
@Test [EOL] public void testLocales_ShortNoEra_AD() throws Exception { [EOL]     testLocales(SHORT_FORMAT_NOERA, false); [EOL] } <line_num>: 264,267
@Test [EOL] public void testLocales_ShortNoEra_BC() throws Exception { [EOL]     testLocales(SHORT_FORMAT_NOERA, true); [EOL] } <line_num>: 269,272
private void testLocales(final String format, final boolean eraBC) throws Exception { [EOL]     final Calendar cal = Calendar.getInstance(GMT); [EOL]     cal.clear(); [EOL]     cal.set(2003, 1, 10); [EOL]     if (eraBC) { [EOL]         cal.set(Calendar.ERA, GregorianCalendar.BC); [EOL]     } [EOL]     for (final Locale locale : Locale.getAvailableLocales()) { [EOL]         if (eraBC && locale.equals(FastDateParser.JAPANESE_IMPERIAL)) { [EOL]             continue; [EOL]         } [EOL]         final SimpleDateFormat sdf = new SimpleDateFormat(format, locale); [EOL]         final DateParser fdf = getInstance(format, locale); [EOL]         try { [EOL]             checkParse(locale, cal, sdf, fdf); [EOL]         } catch (final ParseException ex) { [EOL]             Assert.fail("Locale " + locale + " failed with " + format + " era " + (eraBC ? "BC" : "AD") + "\n" + trimMessage(ex.toString())); [EOL]         } [EOL]     } [EOL] } <line_num>: 274,296
private String trimMessage(final String msg) { [EOL]     if (msg.length() < 100) { [EOL]         return msg; [EOL]     } [EOL]     final int gmt = msg.indexOf("(GMT"); [EOL]     if (gmt > 0) { [EOL]         return msg.substring(0, gmt + 4) + "...)"; [EOL]     } [EOL]     return msg.substring(0, 100) + "..."; [EOL] } <line_num>: 298,307
private void checkParse(final Locale locale, final Calendar cal, final SimpleDateFormat sdf, final DateParser fdf) throws ParseException { [EOL]     final String formattedDate = sdf.format(cal.getTime()); [EOL]     final Date expectedTime = sdf.parse(formattedDate); [EOL]     final Date actualTime = fdf.parse(formattedDate); [EOL]     assertEquals(locale.toString() + " " + formattedDate + "\n", expectedTime, actualTime); [EOL] } <line_num>: 309,315
@Test [EOL] public void testParseNumerics() throws ParseException { [EOL]     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); [EOL]     cal.clear(); [EOL]     cal.set(2003, 1, 10, 15, 33, 20); [EOL]     cal.set(Calendar.MILLISECOND, 989); [EOL]     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); [EOL]     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); [EOL] } <line_num>: 317,326
@Test [EOL] public void testQuotes() throws ParseException { [EOL]     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); [EOL]     cal.clear(); [EOL]     cal.set(2003, 1, 10, 15, 33, 20); [EOL]     cal.set(Calendar.MILLISECOND, 989); [EOL]     final DateParser fdf = getInstance("''yyyyMMdd'A''B'HHmmssSSS''", NEW_YORK, Locale.US); [EOL]     assertEquals(cal.getTime(), fdf.parse("'20030210A'B153320989'")); [EOL] } <line_num>: 328,337
@Test [EOL] public void testSpecialCharacters() throws Exception { [EOL]     testSdfAndFdp("q", "", true); [EOL]     testSdfAndFdp("Q", "", true); [EOL]     testSdfAndFdp("$", "$", false); [EOL]     testSdfAndFdp("?.d", "?.12", false); [EOL]     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); [EOL]     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); [EOL]     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); [EOL] } <line_num>: 339,348
@Test [EOL] public void testLANG_832() throws Exception { [EOL]     testSdfAndFdp("'d'd", "d3", false); [EOL]     testSdfAndFdp("'d'd'", "d3", true); [EOL] } <line_num>: 350,354
@Test [EOL] public void testLANG_831() throws Exception { [EOL]     testSdfAndFdp("M E", "3  Tue", true); [EOL] } <line_num>: 356,359
private void testSdfAndFdp(final String format, final String date, final boolean shouldFail) throws Exception { [EOL]     final boolean debug = false; [EOL]     Date dfdp = null; [EOL]     Date dsdf = null; [EOL]     Throwable f = null; [EOL]     Throwable s = null; [EOL]     try { [EOL]         final SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US); [EOL]         sdf.setTimeZone(NEW_YORK); [EOL]         dsdf = sdf.parse(date); [EOL]         if (shouldFail) { [EOL]             Assert.fail("Expected SDF failure, but got " + dsdf + " for [" + format + "," + date + "]"); [EOL]         } [EOL]     } catch (final Exception e) { [EOL]         s = e; [EOL]         if (!shouldFail) { [EOL]             throw e; [EOL]         } [EOL]         if (debug) { [EOL]             System.out.println("sdf:" + format + "/" + date + "=>" + e); [EOL]         } [EOL]     } [EOL]     try { [EOL]         final DateParser fdp = getInstance(format, NEW_YORK, Locale.US); [EOL]         dfdp = fdp.parse(date); [EOL]         if (shouldFail) { [EOL]             Assert.fail("Expected FDF failure, but got " + dfdp + " for [" + format + "," + date + "] using " + ((FastDateParser) fdp).getParsePattern()); [EOL]         } [EOL]     } catch (final Exception e) { [EOL]         f = e; [EOL]         if (!shouldFail) { [EOL]             throw e; [EOL]         } [EOL]         if (debug) { [EOL]             System.out.println("fdf:" + format + "/" + date + "=>" + e); [EOL]         } [EOL]     } [EOL]     assertTrue("Should both or neither throw Exceptions", (f == null) == (s == null)); [EOL]     assertEquals("Parsed dates should be equal", dsdf, dfdp); [EOL]     if (debug) { [EOL]         System.out.println(format + "," + date + " => " + dsdf); [EOL]     } [EOL] } <line_num>: 361,407
@Test [EOL] public void testDayOf() throws ParseException { [EOL]     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); [EOL]     cal.clear(); [EOL]     cal.set(2003, 1, 10); [EOL]     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); [EOL]     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); [EOL] } <line_num>: 409,417
@Test [EOL] public void testShortDateStyleWithLocales() throws ParseException { [EOL]     DateParser fdf = getDateInstance(FastDateFormat.SHORT, Locale.US); [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     cal.clear(); [EOL]     cal.set(2004, 1, 3); [EOL]     assertEquals(cal.getTime(), fdf.parse("2/3/04")); [EOL]     fdf = getDateInstance(FastDateFormat.SHORT, SWEDEN); [EOL]     assertEquals(cal.getTime(), fdf.parse("2004-02-03")); [EOL] } <line_num>: 423,434
@Test [EOL] public void testLowYearPadding() throws ParseException { [EOL]     final DateParser parser = getInstance(YMD_SLASH); [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     cal.clear(); [EOL]     cal.set(1, 0, 1); [EOL]     assertEquals(cal.getTime(), parser.parse("0001/01/01")); [EOL]     cal.set(10, 0, 1); [EOL]     assertEquals(cal.getTime(), parser.parse("0010/01/01")); [EOL]     cal.set(100, 0, 1); [EOL]     assertEquals(cal.getTime(), parser.parse("0100/01/01")); [EOL]     cal.set(999, 0, 1); [EOL]     assertEquals(cal.getTime(), parser.parse("0999/01/01")); [EOL] } <line_num>: 440,454
@Test [EOL] public void testMilleniumBug() throws ParseException { [EOL]     final DateParser parser = getInstance(DMY_DOT); [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     cal.clear(); [EOL]     cal.set(1000, 0, 1); [EOL]     assertEquals(cal.getTime(), parser.parse("01.01.1000")); [EOL] } <line_num>: 459,467
@Test [EOL] public void testLang303() throws ParseException { [EOL]     DateParser parser = getInstance(YMD_SLASH); [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     cal.set(2004, 11, 31); [EOL]     final Date date = parser.parse("2004/11/31"); [EOL]     parser = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) parser)); [EOL]     assertEquals(date, parser.parse("2004/11/31")); [EOL] } <line_num>: 469,479
@Test [EOL] public void testLang538() throws ParseException { [EOL]     final DateParser parser = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", GMT); [EOL]     final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8")); [EOL]     cal.clear(); [EOL]     cal.set(2009, 9, 16, 8, 42, 16); [EOL]     assertEquals(cal.getTime(), parser.parse("2009-10-16T16:42:16.000Z")); [EOL] } <line_num>: 481,490
@Test [EOL] public void testEquals() { [EOL]     final DateParser parser1 = getInstance(YMD_SLASH); [EOL]     final DateParser parser2 = getInstance(YMD_SLASH); [EOL]     assertEquals(parser1, parser2); [EOL]     assertEquals(parser1.hashCode(), parser2.hashCode()); [EOL]     assertFalse(parser1.equals(new Object())); [EOL] } <line_num>: 492,501
@Test [EOL] public void testToStringContainsName() { [EOL]     final DateParser parser = getInstance(YMD_SLASH); [EOL]     assertTrue(parser.toString().startsWith("FastDate")); [EOL] } <line_num>: 503,507
@Test [EOL] public void testPatternMatches() { [EOL]     final DateParser parser = getInstance(yMdHmsSZ); [EOL]     assertEquals(yMdHmsSZ, parser.getPattern()); [EOL] } <line_num>: 509,513
@Test [EOL] public void testLocaleMatches() { [EOL]     final DateParser parser = getInstance(yMdHmsSZ, SWEDEN); [EOL]     assertEquals(SWEDEN, parser.getLocale()); [EOL] } <line_num>: 515,519
@Test [EOL] public void testTimeZoneMatches() { [EOL]     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); [EOL]     assertEquals(REYKJAVIK, parser.getTimeZone()); [EOL] } <line_num>: 521,525