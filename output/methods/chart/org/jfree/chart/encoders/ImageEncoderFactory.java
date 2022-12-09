private static void init() { [EOL]     encoders = new Hashtable(); [EOL]     encoders.put("jpeg", "org.jfree.chart.encoders.SunJPEGEncoderAdapter"); [EOL]     try { [EOL]         Class.forName("javax.imageio.ImageIO"); [EOL]         Class.forName("org.jfree.chart.encoders.SunPNGEncoderAdapter"); [EOL]         encoders.put("png", "org.jfree.chart.encoders.SunPNGEncoderAdapter"); [EOL]         encoders.put("jpeg", "org.jfree.chart.encoders.SunJPEGEncoderAdapter"); [EOL]     } catch (ClassNotFoundException e) { [EOL]         encoders.put("png", "org.jfree.chart.encoders.KeypointPNGEncoderAdapter"); [EOL]     } [EOL] } <line_num>: 64,81
public static void setImageEncoder(String format, String imageEncoderClassName) { [EOL]     encoders.put(format, imageEncoderClassName); [EOL] } <line_num>: 89,92
public static ImageEncoder newInstance(String format) { [EOL]     ImageEncoder imageEncoder = null; [EOL]     String className = (String) encoders.get(format); [EOL]     if (className == null) { [EOL]         throw new IllegalArgumentException("Unsupported image format - " + format); [EOL]     } [EOL]     try { [EOL]         Class imageEncoderClass = Class.forName(className); [EOL]         imageEncoder = (ImageEncoder) imageEncoderClass.newInstance(); [EOL]     } catch (Exception e) { [EOL]         throw new IllegalArgumentException(e.toString()); [EOL]     } [EOL]     return imageEncoder; [EOL] } <line_num>: 101,116
public static ImageEncoder newInstance(String format, float quality) { [EOL]     ImageEncoder imageEncoder = newInstance(format); [EOL]     imageEncoder.setQuality(quality); [EOL]     return imageEncoder; [EOL] } <line_num>: 126,130
public static ImageEncoder newInstance(String format, boolean encodingAlpha) { [EOL]     ImageEncoder imageEncoder = newInstance(format); [EOL]     imageEncoder.setEncodingAlpha(encodingAlpha); [EOL]     return imageEncoder; [EOL] } <line_num>: 140,145
public static ImageEncoder newInstance(String format, float quality, boolean encodingAlpha) { [EOL]     ImageEncoder imageEncoder = newInstance(format); [EOL]     imageEncoder.setQuality(quality); [EOL]     imageEncoder.setEncodingAlpha(encodingAlpha); [EOL]     return imageEncoder; [EOL] } <line_num>: 156,162
