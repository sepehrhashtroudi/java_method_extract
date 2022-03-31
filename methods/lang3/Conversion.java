public static int hexDigitToInt(final char hexDigit) { [EOL]     final int digit = Character.digit(hexDigit, 16); [EOL]     if (digit < 0) { [EOL]         throw new IllegalArgumentException("Cannot interpret '" + hexDigit + "' as a hexadecimal digit"); [EOL]     } [EOL]     return digit; [EOL] }
public static int hexDigitMsb0ToInt(final char hexDigit) { [EOL]     switch(hexDigit) { [EOL]         case '0': [EOL]             return 0x0; [EOL]         case '1': [EOL]             return 0x8; [EOL]         case '2': [EOL]             return 0x4; [EOL]         case '3': [EOL]             return 0xC; [EOL]         case '4': [EOL]             return 0x2; [EOL]         case '5': [EOL]             return 0xA; [EOL]         case '6': [EOL]             return 0x6; [EOL]         case '7': [EOL]             return 0xE; [EOL]         case '8': [EOL]             return 0x1; [EOL]         case '9': [EOL]             return 0x9; [EOL]         case 'a': [EOL]         case 'A': [EOL]             return 0x5; [EOL]         case 'b': [EOL]         case 'B': [EOL]             return 0xD; [EOL]         case 'c': [EOL]         case 'C': [EOL]             return 0x3; [EOL]         case 'd': [EOL]         case 'D': [EOL]             return 0xB; [EOL]         case 'e': [EOL]         case 'E': [EOL]             return 0x7; [EOL]         case 'f': [EOL]         case 'F': [EOL]             return 0xF; [EOL]         default: [EOL]             throw new IllegalArgumentException("Cannot interpret '" + hexDigit + "' as a hexadecimal digit"); [EOL]     } [EOL] }
public static boolean[] hexDigitToBinary(final char hexDigit) { [EOL]     switch(hexDigit) { [EOL]         case '0': [EOL]             return new boolean[] { false, false, false, false }; [EOL]         case '1': [EOL]             return new boolean[] { true, false, false, false }; [EOL]         case '2': [EOL]             return new boolean[] { false, true, false, false }; [EOL]         case '3': [EOL]             return new boolean[] { true, true, false, false }; [EOL]         case '4': [EOL]             return new boolean[] { false, false, true, false }; [EOL]         case '5': [EOL]             return new boolean[] { true, false, true, false }; [EOL]         case '6': [EOL]             return new boolean[] { false, true, true, false }; [EOL]         case '7': [EOL]             return new boolean[] { true, true, true, false }; [EOL]         case '8': [EOL]             return new boolean[] { false, false, false, true }; [EOL]         case '9': [EOL]             return new boolean[] { true, false, false, true }; [EOL]         case 'a': [EOL]         case 'A': [EOL]             return new boolean[] { false, true, false, true }; [EOL]         case 'b': [EOL]         case 'B': [EOL]             return new boolean[] { true, true, false, true }; [EOL]         case 'c': [EOL]         case 'C': [EOL]             return new boolean[] { false, false, true, true }; [EOL]         case 'd': [EOL]         case 'D': [EOL]             return new boolean[] { true, false, true, true }; [EOL]         case 'e': [EOL]         case 'E': [EOL]             return new boolean[] { false, true, true, true }; [EOL]         case 'f': [EOL]         case 'F': [EOL]             return new boolean[] { true, true, true, true }; [EOL]         default: [EOL]             throw new IllegalArgumentException("Cannot interpret '" + hexDigit + "' as a hexadecimal digit"); [EOL]     } [EOL] }
public static boolean[] hexDigitMsb0ToBinary(final char hexDigit) { [EOL]     switch(hexDigit) { [EOL]         case '0': [EOL]             return new boolean[] { false, false, false, false }; [EOL]         case '1': [EOL]             return new boolean[] { false, false, false, true }; [EOL]         case '2': [EOL]             return new boolean[] { false, false, true, false }; [EOL]         case '3': [EOL]             return new boolean[] { false, false, true, true }; [EOL]         case '4': [EOL]             return new boolean[] { false, true, false, false }; [EOL]         case '5': [EOL]             return new boolean[] { false, true, false, true }; [EOL]         case '6': [EOL]             return new boolean[] { false, true, true, false }; [EOL]         case '7': [EOL]             return new boolean[] { false, true, true, true }; [EOL]         case '8': [EOL]             return new boolean[] { true, false, false, false }; [EOL]         case '9': [EOL]             return new boolean[] { true, false, false, true }; [EOL]         case 'a': [EOL]         case 'A': [EOL]             return new boolean[] { true, false, true, false }; [EOL]         case 'b': [EOL]         case 'B': [EOL]             return new boolean[] { true, false, true, true }; [EOL]         case 'c': [EOL]         case 'C': [EOL]             return new boolean[] { true, true, false, false }; [EOL]         case 'd': [EOL]         case 'D': [EOL]             return new boolean[] { true, true, false, true }; [EOL]         case 'e': [EOL]         case 'E': [EOL]             return new boolean[] { true, true, true, false }; [EOL]         case 'f': [EOL]         case 'F': [EOL]             return new boolean[] { true, true, true, true }; [EOL]         default: [EOL]             throw new IllegalArgumentException("Cannot interpret '" + hexDigit + "' as a hexadecimal digit"); [EOL]     } [EOL] }
public static char binaryToHexDigit(final boolean[] src) { [EOL]     return binaryToHexDigit(src, 0); [EOL] }
public static char binaryToHexDigit(final boolean[] src, final int srcPos) { [EOL]     if (src.length == 0) { [EOL]         throw new IllegalArgumentException("Cannot convert an empty array."); [EOL]     } [EOL]     if (src.length > srcPos + 3 && src[srcPos + 3]) { [EOL]         if (src.length > srcPos + 2 && src[srcPos + 2]) { [EOL]             if (src.length > srcPos + 1 && src[srcPos + 1]) { [EOL]                 if (src[srcPos]) { [EOL]                     return 'f'; [EOL]                 } else { [EOL]                     return 'e'; [EOL]                 } [EOL]             } else { [EOL]                 if (src[srcPos]) { [EOL]                     return 'd'; [EOL]                 } else { [EOL]                     return 'c'; [EOL]                 } [EOL]             } [EOL]         } else { [EOL]             if (src.length > srcPos + 1 && src[srcPos + 1]) { [EOL]                 if (src[srcPos]) { [EOL]                     return 'b'; [EOL]                 } else { [EOL]                     return 'a'; [EOL]                 } [EOL]             } else { [EOL]                 if (src[srcPos]) { [EOL]                     return '9'; [EOL]                 } else { [EOL]                     return '8'; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } else { [EOL]         if (src.length > srcPos + 2 && src[srcPos + 2]) { [EOL]             if (src.length > srcPos + 1 && src[srcPos + 1]) { [EOL]                 if (src[srcPos]) { [EOL]                     return '7'; [EOL]                 } else { [EOL]                     return '6'; [EOL]                 } [EOL]             } else { [EOL]                 if (src[srcPos]) { [EOL]                     return '5'; [EOL]                 } else { [EOL]                     return '4'; [EOL]                 } [EOL]             } [EOL]         } else { [EOL]             if (src.length > srcPos + 1 && src[srcPos + 1]) { [EOL]                 if (src[srcPos]) { [EOL]                     return '3'; [EOL]                 } else { [EOL]                     return '2'; [EOL]                 } [EOL]             } else { [EOL]                 if (src[srcPos]) { [EOL]                     return '1'; [EOL]                 } else { [EOL]                     return '0'; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL] }
public static char binaryToHexDigitMsb0_4bits(final boolean[] src) { [EOL]     return binaryToHexDigitMsb0_4bits(src, 0); [EOL] }
public static char binaryToHexDigitMsb0_4bits(final boolean[] src, final int srcPos) { [EOL]     if (src.length > 8) { [EOL]         throw new IllegalArgumentException("src.length>8: src.length=" + src.length); [EOL]     } [EOL]     if (src.length - srcPos < 4) { [EOL]         throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + src.length + ", srcPos=" + srcPos); [EOL]     } [EOL]     if (src[srcPos + 3]) { [EOL]         if (src[srcPos + 2]) { [EOL]             if (src[srcPos + 1]) { [EOL]                 if (src[srcPos]) { [EOL]                     return 'f'; [EOL]                 } else { [EOL]                     return '7'; [EOL]                 } [EOL]             } else { [EOL]                 if (src[srcPos]) { [EOL]                     return 'b'; [EOL]                 } else { [EOL]                     return '3'; [EOL]                 } [EOL]             } [EOL]         } else { [EOL]             if (src[srcPos + 1]) { [EOL]                 if (src[srcPos]) { [EOL]                     return 'd'; [EOL]                 } else { [EOL]                     return '5'; [EOL]                 } [EOL]             } else { [EOL]                 if (src[srcPos]) { [EOL]                     return '9'; [EOL]                 } else { [EOL]                     return '1'; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } else { [EOL]         if (src[srcPos + 2]) { [EOL]             if (src[srcPos + 1]) { [EOL]                 if (src[srcPos]) { [EOL]                     return 'e'; [EOL]                 } else { [EOL]                     return '6'; [EOL]                 } [EOL]             } else { [EOL]                 if (src[srcPos]) { [EOL]                     return 'a'; [EOL]                 } else { [EOL]                     return '2'; [EOL]                 } [EOL]             } [EOL]         } else { [EOL]             if (src[srcPos + 1]) { [EOL]                 if (src[srcPos]) { [EOL]                     return 'c'; [EOL]                 } else { [EOL]                     return '4'; [EOL]                 } [EOL]             } else { [EOL]                 if (src[srcPos]) { [EOL]                     return '8'; [EOL]                 } else { [EOL]                     return '0'; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL] }
public static char binaryBeMsb0ToHexDigit(final boolean[] src) { [EOL]     return binaryBeMsb0ToHexDigit(src, 0); [EOL] }
public static char binaryBeMsb0ToHexDigit(boolean[] src, int srcPos) { [EOL]     if (src.length == 0) { [EOL]         throw new IllegalArgumentException("Cannot convert an empty array."); [EOL]     } [EOL]     final int beSrcPos = src.length - 1 - srcPos; [EOL]     final int srcLen = Math.min(4, beSrcPos + 1); [EOL]     final boolean[] paddedSrc = new boolean[4]; [EOL]     System.arraycopy(src, beSrcPos + 1 - srcLen, paddedSrc, 4 - srcLen, srcLen); [EOL]     src = paddedSrc; [EOL]     srcPos = 0; [EOL]     if (src[srcPos]) { [EOL]         if (src.length > srcPos + 1 && src[srcPos + 1]) { [EOL]             if (src.length > srcPos + 2 && src[srcPos + 2]) { [EOL]                 if (src.length > srcPos + 3 && src[srcPos + 3]) { [EOL]                     return 'f'; [EOL]                 } else { [EOL]                     return 'e'; [EOL]                 } [EOL]             } else { [EOL]                 if (src.length > srcPos + 3 && src[srcPos + 3]) { [EOL]                     return 'd'; [EOL]                 } else { [EOL]                     return 'c'; [EOL]                 } [EOL]             } [EOL]         } else { [EOL]             if (src.length > srcPos + 2 && src[srcPos + 2]) { [EOL]                 if (src.length > srcPos + 3 && src[srcPos + 3]) { [EOL]                     return 'b'; [EOL]                 } else { [EOL]                     return 'a'; [EOL]                 } [EOL]             } else { [EOL]                 if (src.length > srcPos + 3 && src[srcPos + 3]) { [EOL]                     return '9'; [EOL]                 } else { [EOL]                     return '8'; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } else { [EOL]         if (src.length > srcPos + 1 && src[srcPos + 1]) { [EOL]             if (src.length > srcPos + 2 && src[srcPos + 2]) { [EOL]                 if (src.length > srcPos + 3 && src[srcPos + 3]) { [EOL]                     return '7'; [EOL]                 } else { [EOL]                     return '6'; [EOL]                 } [EOL]             } else { [EOL]                 if (src.length > srcPos + 3 && src[srcPos + 3]) { [EOL]                     return '5'; [EOL]                 } else { [EOL]                     return '4'; [EOL]                 } [EOL]             } [EOL]         } else { [EOL]             if (src.length > srcPos + 2 && src[srcPos + 2]) { [EOL]                 if (src.length > srcPos + 3 && src[srcPos + 3]) { [EOL]                     return '3'; [EOL]                 } else { [EOL]                     return '2'; [EOL]                 } [EOL]             } else { [EOL]                 if (src.length > srcPos + 3 && src[srcPos + 3]) { [EOL]                     return '1'; [EOL]                 } else { [EOL]                     return '0'; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL] }
public static char intToHexDigit(final int nibble) { [EOL]     final char c = Character.forDigit(nibble, 16); [EOL]     if (c == Character.MIN_VALUE) { [EOL]         throw new IllegalArgumentException("nibble value not between 0 and 15: " + nibble); [EOL]     } [EOL]     return c; [EOL] }
public static char intToHexDigitMsb0(final int nibble) { [EOL]     switch(nibble) { [EOL]         case 0x0: [EOL]             return '0'; [EOL]         case 0x1: [EOL]             return '8'; [EOL]         case 0x2: [EOL]             return '4'; [EOL]         case 0x3: [EOL]             return 'c'; [EOL]         case 0x4: [EOL]             return '2'; [EOL]         case 0x5: [EOL]             return 'a'; [EOL]         case 0x6: [EOL]             return '6'; [EOL]         case 0x7: [EOL]             return 'e'; [EOL]         case 0x8: [EOL]             return '1'; [EOL]         case 0x9: [EOL]             return '9'; [EOL]         case 0xA: [EOL]             return '5'; [EOL]         case 0xB: [EOL]             return 'd'; [EOL]         case 0xC: [EOL]             return '3'; [EOL]         case 0xD: [EOL]             return 'b'; [EOL]         case 0xE: [EOL]             return '7'; [EOL]         case 0xF: [EOL]             return 'f'; [EOL]         default: [EOL]             throw new IllegalArgumentException("nibble value not between 0 and 15: " + nibble); [EOL]     } [EOL] }
public static long intArrayToLong(final int[] src, final int srcPos, final long dstInit, final int dstPos, final int nInts) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nInts) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nInts - 1) * 32 + dstPos >= 64) { [EOL]         throw new IllegalArgumentException("(nInts-1)*32+dstPos is greather or equal to than 64"); [EOL]     } [EOL]     long out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nInts; i++) { [EOL]         shift = i * 32 + dstPos; [EOL]         final long bits = ((0xffffffffL & src[i + srcPos]) << shift); [EOL]         final long mask = 0xffffffffL << shift; [EOL]         out = (out & ~mask) | bits; [EOL]     } [EOL]     return out; [EOL] }
public static long shortArrayToLong(final short[] src, final int srcPos, final long dstInit, final int dstPos, final int nShorts) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nShorts) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nShorts - 1) * 16 + dstPos >= 64) { [EOL]         throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 64"); [EOL]     } [EOL]     long out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nShorts; i++) { [EOL]         shift = i * 16 + dstPos; [EOL]         final long bits = (0xffffL & src[i + srcPos]) << shift; [EOL]         final long mask = 0xffffL << shift; [EOL]         out = (out & ~mask) | bits; [EOL]     } [EOL]     return out; [EOL] }
public static int shortArrayToInt(final short[] src, final int srcPos, final int dstInit, final int dstPos, final int nShorts) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nShorts) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nShorts - 1) * 16 + dstPos >= 32) { [EOL]         throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 32"); [EOL]     } [EOL]     int out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nShorts; i++) { [EOL]         shift = i * 16 + dstPos; [EOL]         final int bits = (0xffff & src[i + srcPos]) << shift; [EOL]         final int mask = 0xffff << shift; [EOL]         out = (out & ~mask) | bits; [EOL]     } [EOL]     return out; [EOL] }
public static long byteArrayToLong(final byte[] src, final int srcPos, final long dstInit, final int dstPos, final int nBytes) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nBytes) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nBytes - 1) * 8 + dstPos >= 64) { [EOL]         throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 64"); [EOL]     } [EOL]     long out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBytes; i++) { [EOL]         shift = i * 8 + dstPos; [EOL]         final long bits = (0xffL & src[i + srcPos]) << shift; [EOL]         final long mask = 0xffL << shift; [EOL]         out = (out & ~mask) | bits; [EOL]     } [EOL]     return out; [EOL] }
public static int byteArrayToInt(final byte[] src, final int srcPos, final int dstInit, final int dstPos, final int nBytes) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nBytes) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nBytes - 1) * 8 + dstPos >= 32) { [EOL]         throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 32"); [EOL]     } [EOL]     int out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBytes; i++) { [EOL]         shift = i * 8 + dstPos; [EOL]         final int bits = (0xff & src[i + srcPos]) << shift; [EOL]         final int mask = 0xff << shift; [EOL]         out = (out & ~mask) | bits; [EOL]     } [EOL]     return out; [EOL] }
public static short byteArrayToShort(final byte[] src, final int srcPos, final short dstInit, final int dstPos, final int nBytes) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nBytes) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nBytes - 1) * 8 + dstPos >= 16) { [EOL]         throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 16"); [EOL]     } [EOL]     short out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBytes; i++) { [EOL]         shift = i * 8 + dstPos; [EOL]         final int bits = (0xff & src[i + srcPos]) << shift; [EOL]         final int mask = 0xff << shift; [EOL]         out = (short) ((out & ~mask) | bits); [EOL]     } [EOL]     return out; [EOL] }
public static long hexToLong(final String src, final int srcPos, final long dstInit, final int dstPos, final int nHex) { [EOL]     if (0 == nHex) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nHex - 1) * 4 + dstPos >= 64) { [EOL]         throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 64"); [EOL]     } [EOL]     long out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nHex; i++) { [EOL]         shift = i * 4 + dstPos; [EOL]         final long bits = (0xfL & hexDigitToInt(src.charAt(i + srcPos))) << shift; [EOL]         final long mask = 0xfL << shift; [EOL]         out = (out & ~mask) | bits; [EOL]     } [EOL]     return out; [EOL] }
public static int hexToInt(final String src, final int srcPos, final int dstInit, final int dstPos, final int nHex) { [EOL]     if (0 == nHex) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nHex - 1) * 4 + dstPos >= 32) { [EOL]         throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 32"); [EOL]     } [EOL]     int out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nHex; i++) { [EOL]         shift = i * 4 + dstPos; [EOL]         final int bits = (0xf & hexDigitToInt(src.charAt(i + srcPos))) << shift; [EOL]         final int mask = 0xf << shift; [EOL]         out = (out & ~mask) | bits; [EOL]     } [EOL]     return out; [EOL] }
public static short hexToShort(final String src, final int srcPos, final short dstInit, final int dstPos, final int nHex) { [EOL]     if (0 == nHex) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nHex - 1) * 4 + dstPos >= 16) { [EOL]         throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 16"); [EOL]     } [EOL]     short out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nHex; i++) { [EOL]         shift = i * 4 + dstPos; [EOL]         final int bits = (0xf & hexDigitToInt(src.charAt(i + srcPos))) << shift; [EOL]         final int mask = 0xf << shift; [EOL]         out = (short) ((out & ~mask) | bits); [EOL]     } [EOL]     return out; [EOL] }
public static byte hexToByte(final String src, final int srcPos, final byte dstInit, final int dstPos, final int nHex) { [EOL]     if (0 == nHex) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nHex - 1) * 4 + dstPos >= 8) { [EOL]         throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 8"); [EOL]     } [EOL]     byte out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nHex; i++) { [EOL]         shift = i * 4 + dstPos; [EOL]         final int bits = (0xf & hexDigitToInt(src.charAt(i + srcPos))) << shift; [EOL]         final int mask = 0xf << shift; [EOL]         out = (byte) ((out & ~mask) | bits); [EOL]     } [EOL]     return out; [EOL] }
public static long binaryToLong(final boolean[] src, final int srcPos, final long dstInit, final int dstPos, final int nBools) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nBools) { [EOL]         return dstInit; [EOL]     } [EOL]     if (nBools - 1 + dstPos >= 64) { [EOL]         throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 64"); [EOL]     } [EOL]     long out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBools; i++) { [EOL]         shift = i * 1 + dstPos; [EOL]         final long bits = (src[i + srcPos] ? 1L : 0) << shift; [EOL]         final long mask = 0x1L << shift; [EOL]         out = (out & ~mask) | bits; [EOL]     } [EOL]     return out; [EOL] }
public static int binaryToInt(final boolean[] src, final int srcPos, final int dstInit, final int dstPos, final int nBools) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nBools) { [EOL]         return dstInit; [EOL]     } [EOL]     if (nBools - 1 + dstPos >= 32) { [EOL]         throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 32"); [EOL]     } [EOL]     int out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBools; i++) { [EOL]         shift = i * 1 + dstPos; [EOL]         final int bits = (src[i + srcPos] ? 1 : 0) << shift; [EOL]         final int mask = 0x1 << shift; [EOL]         out = (out & ~mask) | bits; [EOL]     } [EOL]     return out; [EOL] }
public static short binaryToShort(final boolean[] src, final int srcPos, final short dstInit, final int dstPos, final int nBools) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nBools) { [EOL]         return dstInit; [EOL]     } [EOL]     if (nBools - 1 + dstPos >= 16) { [EOL]         throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 16"); [EOL]     } [EOL]     short out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBools; i++) { [EOL]         shift = i * 1 + dstPos; [EOL]         final int bits = (src[i + srcPos] ? 1 : 0) << shift; [EOL]         final int mask = 0x1 << shift; [EOL]         out = (short) ((out & ~mask) | bits); [EOL]     } [EOL]     return out; [EOL] }
public static byte binaryToByte(final boolean[] src, final int srcPos, final byte dstInit, final int dstPos, final int nBools) { [EOL]     if ((src.length == 0 && srcPos == 0) || 0 == nBools) { [EOL]         return dstInit; [EOL]     } [EOL]     if (nBools - 1 + dstPos >= 8) { [EOL]         throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 8"); [EOL]     } [EOL]     byte out = dstInit; [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBools; i++) { [EOL]         shift = i * 1 + dstPos; [EOL]         final int bits = (src[i + srcPos] ? 1 : 0) << shift; [EOL]         final int mask = 0x1 << shift; [EOL]         out = (byte) ((out & ~mask) | bits); [EOL]     } [EOL]     return out; [EOL] }
public static int[] longToIntArray(final long src, final int srcPos, final int[] dst, final int dstPos, final int nInts) { [EOL]     if (0 == nInts) { [EOL]         return dst; [EOL]     } [EOL]     if ((nInts - 1) * 32 + srcPos >= 64) { [EOL]         throw new IllegalArgumentException("(nInts-1)*32+srcPos is greather or equal to than 64"); [EOL]     } [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nInts; i++) { [EOL]         shift = i * 32 + srcPos; [EOL]         dst[dstPos + i] = (int) (0xffffffff & (src >> shift)); [EOL]     } [EOL]     return dst; [EOL] }
public static short[] longToShortArray(final long src, final int srcPos, final short[] dst, final int dstPos, final int nShorts) { [EOL]     if (0 == nShorts) { [EOL]         return dst; [EOL]     } [EOL]     if ((nShorts - 1) * 16 + srcPos >= 64) { [EOL]         throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 64"); [EOL]     } [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nShorts; i++) { [EOL]         shift = i * 16 + srcPos; [EOL]         dst[dstPos + i] = (short) (0xffff & (src >> shift)); [EOL]     } [EOL]     return dst; [EOL] }
public static short[] intToShortArray(final int src, final int srcPos, final short[] dst, final int dstPos, final int nShorts) { [EOL]     if (0 == nShorts) { [EOL]         return dst; [EOL]     } [EOL]     if ((nShorts - 1) * 16 + srcPos >= 32) { [EOL]         throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 32"); [EOL]     } [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nShorts; i++) { [EOL]         shift = i * 16 + srcPos; [EOL]         dst[dstPos + i] = (short) (0xffff & (src >> shift)); [EOL]     } [EOL]     return dst; [EOL] }
public static byte[] longToByteArray(final long src, final int srcPos, final byte[] dst, final int dstPos, final int nBytes) { [EOL]     if (0 == nBytes) { [EOL]         return dst; [EOL]     } [EOL]     if ((nBytes - 1) * 8 + srcPos >= 64) { [EOL]         throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 64"); [EOL]     } [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBytes; i++) { [EOL]         shift = i * 8 + srcPos; [EOL]         dst[dstPos + i] = (byte) (0xff & (src >> shift)); [EOL]     } [EOL]     return dst; [EOL] }
public static byte[] intToByteArray(final int src, final int srcPos, final byte[] dst, final int dstPos, final int nBytes) { [EOL]     if (0 == nBytes) { [EOL]         return dst; [EOL]     } [EOL]     if ((nBytes - 1) * 8 + srcPos >= 32) { [EOL]         throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 32"); [EOL]     } [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBytes; i++) { [EOL]         shift = i * 8 + srcPos; [EOL]         dst[dstPos + i] = (byte) (0xff & (src >> shift)); [EOL]     } [EOL]     return dst; [EOL] }
public static byte[] shortToByteArray(final short src, final int srcPos, final byte[] dst, final int dstPos, final int nBytes) { [EOL]     if (0 == nBytes) { [EOL]         return dst; [EOL]     } [EOL]     if ((nBytes - 1) * 8 + srcPos >= 16) { [EOL]         throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 16"); [EOL]     } [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBytes; i++) { [EOL]         shift = i * 8 + srcPos; [EOL]         dst[dstPos + i] = (byte) (0xff & (src >> shift)); [EOL]     } [EOL]     return dst; [EOL] }
public static String longToHex(final long src, final int srcPos, final String dstInit, final int dstPos, final int nHexs) { [EOL]     if (0 == nHexs) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nHexs - 1) * 4 + srcPos >= 64) { [EOL]         throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 64"); [EOL]     } [EOL]     final StringBuilder sb = new StringBuilder(dstInit); [EOL]     int shift = 0; [EOL]     int append = sb.length(); [EOL]     for (int i = 0; i < nHexs; i++) { [EOL]         shift = i * 4 + srcPos; [EOL]         final int bits = (int) (0xF & (src >> shift)); [EOL]         if (dstPos + i == append) { [EOL]             ++append; [EOL]             sb.append(intToHexDigit(bits)); [EOL]         } else { [EOL]             sb.setCharAt(dstPos + i, intToHexDigit(bits)); [EOL]         } [EOL]     } [EOL]     return sb.toString(); [EOL] }
public static String intToHex(final int src, final int srcPos, final String dstInit, final int dstPos, final int nHexs) { [EOL]     if (0 == nHexs) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nHexs - 1) * 4 + srcPos >= 32) { [EOL]         throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 32"); [EOL]     } [EOL]     final StringBuilder sb = new StringBuilder(dstInit); [EOL]     int shift = 0; [EOL]     int append = sb.length(); [EOL]     for (int i = 0; i < nHexs; i++) { [EOL]         shift = i * 4 + srcPos; [EOL]         final int bits = 0xF & (src >> shift); [EOL]         if (dstPos + i == append) { [EOL]             ++append; [EOL]             sb.append(intToHexDigit(bits)); [EOL]         } else { [EOL]             sb.setCharAt(dstPos + i, intToHexDigit(bits)); [EOL]         } [EOL]     } [EOL]     return sb.toString(); [EOL] }
public static String shortToHex(final short src, final int srcPos, final String dstInit, final int dstPos, final int nHexs) { [EOL]     if (0 == nHexs) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nHexs - 1) * 4 + srcPos >= 16) { [EOL]         throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 16"); [EOL]     } [EOL]     final StringBuilder sb = new StringBuilder(dstInit); [EOL]     int shift = 0; [EOL]     int append = sb.length(); [EOL]     for (int i = 0; i < nHexs; i++) { [EOL]         shift = i * 4 + srcPos; [EOL]         final int bits = 0xF & (src >> shift); [EOL]         if (dstPos + i == append) { [EOL]             ++append; [EOL]             sb.append(intToHexDigit(bits)); [EOL]         } else { [EOL]             sb.setCharAt(dstPos + i, intToHexDigit(bits)); [EOL]         } [EOL]     } [EOL]     return sb.toString(); [EOL] }
public static String byteToHex(final byte src, final int srcPos, final String dstInit, final int dstPos, final int nHexs) { [EOL]     if (0 == nHexs) { [EOL]         return dstInit; [EOL]     } [EOL]     if ((nHexs - 1) * 4 + srcPos >= 8) { [EOL]         throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 8"); [EOL]     } [EOL]     final StringBuilder sb = new StringBuilder(dstInit); [EOL]     int shift = 0; [EOL]     int append = sb.length(); [EOL]     for (int i = 0; i < nHexs; i++) { [EOL]         shift = i * 4 + srcPos; [EOL]         final int bits = 0xF & (src >> shift); [EOL]         if (dstPos + i == append) { [EOL]             ++append; [EOL]             sb.append(intToHexDigit(bits)); [EOL]         } else { [EOL]             sb.setCharAt(dstPos + i, intToHexDigit(bits)); [EOL]         } [EOL]     } [EOL]     return sb.toString(); [EOL] }
public static boolean[] longToBinary(final long src, final int srcPos, final boolean[] dst, final int dstPos, final int nBools) { [EOL]     if (0 == nBools) { [EOL]         return dst; [EOL]     } [EOL]     if (nBools - 1 + srcPos >= 64) { [EOL]         throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 64"); [EOL]     } [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBools; i++) { [EOL]         shift = i * 1 + srcPos; [EOL]         dst[dstPos + i] = ((0x1 & (src >> shift)) != 0); [EOL]     } [EOL]     return dst; [EOL] }
public static boolean[] intToBinary(final int src, final int srcPos, final boolean[] dst, final int dstPos, final int nBools) { [EOL]     if (0 == nBools) { [EOL]         return dst; [EOL]     } [EOL]     if (nBools - 1 + srcPos >= 32) { [EOL]         throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 32"); [EOL]     } [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBools; i++) { [EOL]         shift = i * 1 + srcPos; [EOL]         dst[dstPos + i] = ((0x1 & (src >> shift)) != 0); [EOL]     } [EOL]     return dst; [EOL] }
public static boolean[] shortToBinary(final short src, final int srcPos, final boolean[] dst, final int dstPos, final int nBools) { [EOL]     if (0 == nBools) { [EOL]         return dst; [EOL]     } [EOL]     if (nBools - 1 + srcPos >= 16) { [EOL]         throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 16"); [EOL]     } [EOL]     int shift = 0; [EOL]     assert ((nBools - 1) * 1 < 16 - srcPos); [EOL]     for (int i = 0; i < nBools; i++) { [EOL]         shift = i * 1 + srcPos; [EOL]         dst[dstPos + i] = ((0x1 & (src >> shift)) != 0); [EOL]     } [EOL]     return dst; [EOL] }
public static boolean[] byteToBinary(final byte src, final int srcPos, final boolean[] dst, final int dstPos, final int nBools) { [EOL]     if (0 == nBools) { [EOL]         return dst; [EOL]     } [EOL]     if (nBools - 1 + srcPos >= 8) { [EOL]         throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 8"); [EOL]     } [EOL]     int shift = 0; [EOL]     for (int i = 0; i < nBools; i++) { [EOL]         shift = i * 1 + srcPos; [EOL]         dst[dstPos + i] = ((0x1 & (src >> shift)) != 0); [EOL]     } [EOL]     return dst; [EOL] }
public static byte[] uuidToByteArray(final UUID src, final byte[] dst, final int dstPos, final int nBytes) { [EOL]     if (0 == nBytes) { [EOL]         return dst; [EOL]     } [EOL]     if (nBytes > 16) { [EOL]         throw new IllegalArgumentException("nBytes is greather than 16"); [EOL]     } [EOL]     longToByteArray(src.getMostSignificantBits(), 0, dst, dstPos, nBytes > 8 ? 8 : nBytes); [EOL]     if (nBytes >= 8) { [EOL]         longToByteArray(src.getLeastSignificantBits(), 0, dst, dstPos + 8, nBytes - 8); [EOL]     } [EOL]     return dst; [EOL] }
public static UUID byteArrayToUuid(final byte[] src, final int srcPos) { [EOL]     if (src.length - srcPos < 16) { [EOL]         throw new IllegalArgumentException("Need at least 16 bytes for UUID"); [EOL]     } [EOL]     return new UUID(byteArrayToLong(src, srcPos, 0, 0, 8), byteArrayToLong(src, srcPos + 8, 0, 0, 8)); [EOL] }
