public static String random(final int count) { [EOL]     return random(count, false, false); [EOL] }
public static String randomAscii(final int count) { [EOL]     return random(count, 32, 127, false, false); [EOL] }
public static String randomAlphabetic(final int count) { [EOL]     return random(count, true, false); [EOL] }
public static String randomAlphanumeric(final int count) { [EOL]     return random(count, true, true); [EOL] }
public static String randomNumeric(final int count) { [EOL]     return random(count, false, true); [EOL] }
public static String random(final int count, final boolean letters, final boolean numbers) { [EOL]     return random(count, 0, 0, letters, numbers); [EOL] }
public static String random(final int count, final int start, final int end, final boolean letters, final boolean numbers) { [EOL]     return random(count, start, end, letters, numbers, null, RANDOM); [EOL] }
public static String random(final int count, final int start, final int end, final boolean letters, final boolean numbers, final char... chars) { [EOL]     return random(count, start, end, letters, numbers, chars, RANDOM); [EOL] }
public static String random(int count, int start, int end, final boolean letters, final boolean numbers, final char[] chars, final Random random) { [EOL]     if (count == 0) { [EOL]         return ""; [EOL]     } else if (count < 0) { [EOL]         throw new IllegalArgumentException("Requested random string length " + count + " is less than 0."); [EOL]     } [EOL]     if (chars != null && chars.length == 0) { [EOL]         throw new IllegalArgumentException("The chars array must not be empty"); [EOL]     } [EOL]     if (start == 0 && end == 0) { [EOL]         if (chars != null) { [EOL]             end = chars.length; [EOL]         } else { [EOL]             if (!letters && !numbers) { [EOL]                 end = Integer.MAX_VALUE; [EOL]             } else { [EOL]                 end = 'z' + 1; [EOL]                 start = ' '; [EOL]             } [EOL]         } [EOL]     } else { [EOL]         if (end <= start) { [EOL]             throw new IllegalArgumentException("Parameter end (" + end + ") must be greater than start (" + start + ")"); [EOL]         } [EOL]     } [EOL]     final char[] buffer = new char[count]; [EOL]     final int gap = end - start; [EOL]     while (count-- != 0) { [EOL]         char ch; [EOL]         if (chars == null) { [EOL]             ch = (char) (random.nextInt(gap) + start); [EOL]         } else { [EOL]             ch = chars[random.nextInt(gap) + start]; [EOL]         } [EOL]         if (letters && Character.isLetter(ch) || numbers && Character.isDigit(ch) || !letters && !numbers) { [EOL]             if (ch >= 56320 && ch <= 57343) { [EOL]                 if (count == 0) { [EOL]                     count++; [EOL]                 } else { [EOL]                     buffer[count] = ch; [EOL]                     count--; [EOL]                     buffer[count] = (char) (55296 + random.nextInt(128)); [EOL]                 } [EOL]             } else if (ch >= 55296 && ch <= 56191) { [EOL]                 if (count == 0) { [EOL]                     count++; [EOL]                 } else { [EOL]                     buffer[count] = (char) (56320 + random.nextInt(128)); [EOL]                     count--; [EOL]                     buffer[count] = ch; [EOL]                 } [EOL]             } else if (ch >= 56192 && ch <= 56319) { [EOL]                 count++; [EOL]             } else { [EOL]                 buffer[count] = ch; [EOL]             } [EOL]         } else { [EOL]             count++; [EOL]         } [EOL]     } [EOL]     return new String(buffer); [EOL] }
public static String random(final int count, final String chars) { [EOL]     if (chars == null) { [EOL]         return random(count, 0, 0, false, false, null, RANDOM); [EOL]     } [EOL]     return random(count, chars.toCharArray()); [EOL] }
public static String random(final int count, final char... chars) { [EOL]     if (chars == null) { [EOL]         return random(count, 0, 0, false, false, null, RANDOM); [EOL]     } [EOL]     return random(count, 0, chars.length, false, false, chars, RANDOM); [EOL] }
