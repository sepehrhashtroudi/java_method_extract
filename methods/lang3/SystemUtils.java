public static File getJavaHome() { [EOL]     return new File(System.getProperty(JAVA_HOME_KEY)); [EOL] }
public static File getJavaIoTmpDir() { [EOL]     return new File(System.getProperty(JAVA_IO_TMPDIR_KEY)); [EOL] }
private static boolean getJavaVersionMatches(final String versionPrefix) { [EOL]     return isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, versionPrefix); [EOL] }
private static boolean getOSMatches(final String osNamePrefix, final String osVersionPrefix) { [EOL]     return isOSMatch(OS_NAME, OS_VERSION, osNamePrefix, osVersionPrefix); [EOL] }
private static boolean getOSMatchesName(final String osNamePrefix) { [EOL]     return isOSNameMatch(OS_NAME, osNamePrefix); [EOL] }
private static String getSystemProperty(final String property) { [EOL]     try { [EOL]         return System.getProperty(property); [EOL]     } catch (final SecurityException ex) { [EOL]         System.err.println("Caught a SecurityException reading the system property '" + property + "'; the SystemUtils property value will default to null."); [EOL]         return null; [EOL]     } [EOL] }
public static File getUserDir() { [EOL]     return new File(System.getProperty(USER_DIR_KEY)); [EOL] }
public static File getUserHome() { [EOL]     return new File(System.getProperty(USER_HOME_KEY)); [EOL] }
public static boolean isJavaAwtHeadless() { [EOL]     return JAVA_AWT_HEADLESS != null ? JAVA_AWT_HEADLESS.equals(Boolean.TRUE.toString()) : false; [EOL] }
public static boolean isJavaVersionAtLeast(final JavaVersion requiredVersion) { [EOL]     return JAVA_SPECIFICATION_VERSION_AS_ENUM.atLeast(requiredVersion); [EOL] }
static boolean isJavaVersionMatch(final String version, final String versionPrefix) { [EOL]     if (version == null) { [EOL]         return false; [EOL]     } [EOL]     return version.startsWith(versionPrefix); [EOL] }
static boolean isOSMatch(final String osName, final String osVersion, final String osNamePrefix, final String osVersionPrefix) { [EOL]     if (osName == null || osVersion == null) { [EOL]         return false; [EOL]     } [EOL]     return osName.startsWith(osNamePrefix) && osVersion.startsWith(osVersionPrefix); [EOL] }
static boolean isOSNameMatch(final String osName, final String osNamePrefix) { [EOL]     if (osName == null) { [EOL]         return false; [EOL]     } [EOL]     return osName.startsWith(osNamePrefix); [EOL] }
