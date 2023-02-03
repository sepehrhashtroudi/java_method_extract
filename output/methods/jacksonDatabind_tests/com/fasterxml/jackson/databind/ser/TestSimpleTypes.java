public void testBoolean() throws Exception { [EOL]     assertEquals("true", serializeAsString(MAPPER, Boolean.TRUE)); [EOL]     assertEquals("false", serializeAsString(MAPPER, Boolean.FALSE)); [EOL] } <line_num>: 21,25
public void testBooleanArray() throws Exception { [EOL]     assertEquals("[true,false]", serializeAsString(MAPPER, new boolean[] { true, false })); [EOL]     assertEquals("[true,false]", serializeAsString(MAPPER, new Boolean[] { Boolean.TRUE, Boolean.FALSE })); [EOL] } <line_num>: 27,31
public void testByteArray() throws Exception { [EOL]     byte[] data = { 1, 17, -3, 127, -128 }; [EOL]     Byte[] data2 = new Byte[data.length]; [EOL]     for (int i = 0; i < data.length; ++i) { [EOL]         data2[i] = data[i]; [EOL]     } [EOL]     String str1 = serializeAsString(MAPPER, data); [EOL]     String str2 = serializeAsString(MAPPER, data2); [EOL]     assertArrayEquals(data, MAPPER.readValue(str1, byte[].class)); [EOL]     assertArrayEquals(data2, MAPPER.readValue(str2, Byte[].class)); [EOL] } <line_num>: 33,45
public void testBase64Variants() throws Exception { [EOL]     final byte[] INPUT = "abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890X".getBytes("UTF-8"); [EOL]     assertEquals(quote("YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXoxMjM0NTY3ODkwYWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXoxMjM0NTY3ODkwWA=="), MAPPER.writeValueAsString(INPUT)); [EOL]     assertEquals(quote("YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXoxMjM0NTY3ODkwYWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXoxMjM0NTY3ODkwWA=="), MAPPER.writer(Base64Variants.MIME_NO_LINEFEEDS).writeValueAsString(INPUT)); [EOL]     assertEquals(quote("YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXoxMjM0NTY3ODkwYWJjZGVmZ2hpamtsbW5vcHFyc3R1\\ndnd4eXoxMjM0NTY3ODkwWA=="), MAPPER.writer(Base64Variants.MIME).writeValueAsString(INPUT)); [EOL]     assertEquals(quote("YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXoxMjM0NTY3ODkwYWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXoxMjM0NTY3ODkwWA"), MAPPER.writer(Base64Variants.MODIFIED_FOR_URL).writeValueAsString(INPUT)); [EOL]     assertEquals(quote("YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXoxMjM0NTY3ODkwYWJjZGVmZ2hpamts\\nbW5vcHFyc3R1dnd4eXoxMjM0NTY3ODkwWA=="), MAPPER.writer(Base64Variants.PEM).writeValueAsString(INPUT)); [EOL] } <line_num>: 48,65
public void testShortArray() throws Exception { [EOL]     assertEquals("[0,1]", serializeAsString(MAPPER, new short[] { 0, 1 })); [EOL]     assertEquals("[2,3]", serializeAsString(MAPPER, new Short[] { 2, 3 })); [EOL] } <line_num>: 67,71
public void testIntArray() throws Exception { [EOL]     assertEquals("[0,-3]", serializeAsString(MAPPER, new int[] { 0, -3 })); [EOL]     assertEquals("[13,9]", serializeAsString(MAPPER, new Integer[] { 13, 9 })); [EOL] } <line_num>: 73,77
public void testFloat() throws Exception { [EOL]     double[] values = new double[] { 0.0, 1.0, 0.1, -37.01, 999.99, 0.3, 33.3, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }; [EOL]     for (double d : values) { [EOL]         float f = (float) d; [EOL]         String expected = String.valueOf(f); [EOL]         if (Float.isNaN(f) || Float.isInfinite(f)) { [EOL]             expected = "\"" + expected + "\""; [EOL]         } [EOL]         assertEquals(expected, serializeAsString(MAPPER, Float.valueOf(f))); [EOL]     } [EOL] } <line_num>: 84,97
public void testDouble() throws Exception { [EOL]     double[] values = new double[] { 0.0, 1.0, 0.1, -37.01, 999.99, 0.3, 33.3, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }; [EOL]     for (double d : values) { [EOL]         String expected = String.valueOf(d); [EOL]         if (Double.isNaN(d) || Double.isInfinite(d)) { [EOL]             expected = "\"" + d + "\""; [EOL]         } [EOL]         assertEquals(expected, MAPPER.writeValueAsString(Double.valueOf(d))); [EOL]     } [EOL] } <line_num>: 99,111
public void testBigInteger() throws Exception { [EOL]     BigInteger[] values = new BigInteger[] { BigInteger.ONE, BigInteger.TEN, BigInteger.ZERO, BigInteger.valueOf(1234567890L), new BigInteger("123456789012345678901234568"), new BigInteger("-1250000124326904597090347547457") }; [EOL]     for (BigInteger value : values) { [EOL]         String expected = value.toString(); [EOL]         assertEquals(expected, MAPPER.writeValueAsString(value)); [EOL]     } [EOL] } <line_num>: 113,126
public void testClass() throws Exception { [EOL]     String result = MAPPER.writeValueAsString(java.util.List.class); [EOL]     assertEquals("\"java.util.List\"", result); [EOL] } <line_num>: 128,132
