public static byte[] encode(BufferedImage image, String format) throws IOException { [EOL]     ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(format); [EOL]     return imageEncoder.encode(image); [EOL] } <line_num>: 63,67
public static byte[] encode(BufferedImage image, String format, boolean encodeAlpha) throws IOException { [EOL]     ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(format, encodeAlpha); [EOL]     return imageEncoder.encode(image); [EOL] } <line_num>: 79,84
public static byte[] encode(BufferedImage image, String format, float quality) throws IOException { [EOL]     ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(format, quality); [EOL]     return imageEncoder.encode(image); [EOL] } <line_num>: 96,101
public static byte[] encode(BufferedImage image, String format, float quality, boolean encodeAlpha) throws IOException { [EOL]     ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(format, quality, encodeAlpha); [EOL]     return imageEncoder.encode(image); [EOL] } <line_num>: 115,121
public static void writeBufferedImage(BufferedImage image, String format, OutputStream outputStream) throws IOException { [EOL]     ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(format); [EOL]     imageEncoder.encode(image, outputStream); [EOL] } <line_num>: 131,135
public static void writeBufferedImage(BufferedImage image, String format, OutputStream outputStream, float quality) throws IOException { [EOL]     ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(format, quality); [EOL]     imageEncoder.encode(image, outputStream); [EOL] } <line_num>: 147,152
public static void writeBufferedImage(BufferedImage image, String format, OutputStream outputStream, boolean encodeAlpha) throws IOException { [EOL]     ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(format, encodeAlpha); [EOL]     imageEncoder.encode(image, outputStream); [EOL] } <line_num>: 164,169
public static void writeBufferedImage(BufferedImage image, String format, OutputStream outputStream, float quality, boolean encodeAlpha) throws IOException { [EOL]     ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(format, quality, encodeAlpha); [EOL]     imageEncoder.encode(image, outputStream); [EOL] } <line_num>: 183,189