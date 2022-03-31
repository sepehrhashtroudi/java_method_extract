SystemUtils
public static File getJavaHome()
public static File getJavaIoTmpDir()
private static boolean getJavaVersionMatches(final String versionPrefix)
private static boolean getOSMatches(final String osNamePrefix, final String osVersionPrefix)
private static boolean getOSMatchesName(final String osNamePrefix)
private static String getSystemProperty(final String property)
public static File getUserDir()
public static File getUserHome()
public static boolean isJavaAwtHeadless()
public static boolean isJavaVersionAtLeast(final JavaVersion requiredVersion)
 static boolean isJavaVersionMatch(final String version, final String versionPrefix)
 static boolean isOSMatch(final String osName, final String osVersion, final String osNamePrefix, final String osVersionPrefix)
 static boolean isOSNameMatch(final String osName, final String osNamePrefix)
String OS_NAME_WINDOWS_PREFIX=Optional["Windows"]
String USER_HOME_KEY=Optional["user.home"]
String USER_DIR_KEY=Optional["user.dir"]
String JAVA_IO_TMPDIR_KEY=Optional["java.io.tmpdir"]
String JAVA_HOME_KEY=Optional["java.home"]
String AWT_TOOLKIT=Optional[getSystemProperty("awt.toolkit")]
String FILE_ENCODING=Optional[getSystemProperty("file.encoding")]
String FILE_SEPARATOR=Optional[getSystemProperty("file.separator")]
String JAVA_AWT_FONTS=Optional[getSystemProperty("java.awt.fonts")]
String JAVA_AWT_GRAPHICSENV=Optional[getSystemProperty("java.awt.graphicsenv")]
String JAVA_AWT_HEADLESS=Optional[getSystemProperty("java.awt.headless")]
String JAVA_AWT_PRINTERJOB=Optional[getSystemProperty("java.awt.printerjob")]
String JAVA_CLASS_PATH=Optional[getSystemProperty("java.class.path")]
String JAVA_CLASS_VERSION=Optional[getSystemProperty("java.class.version")]
String JAVA_COMPILER=Optional[getSystemProperty("java.compiler")]
String JAVA_ENDORSED_DIRS=Optional[getSystemProperty("java.endorsed.dirs")]
String JAVA_EXT_DIRS=Optional[getSystemProperty("java.ext.dirs")]
String JAVA_HOME=Optional[getSystemProperty(JAVA_HOME_KEY)]
String JAVA_IO_TMPDIR=Optional[getSystemProperty(JAVA_IO_TMPDIR_KEY)]
String JAVA_LIBRARY_PATH=Optional[getSystemProperty("java.library.path")]
String JAVA_RUNTIME_NAME=Optional[getSystemProperty("java.runtime.name")]
String JAVA_RUNTIME_VERSION=Optional[getSystemProperty("java.runtime.version")]
String JAVA_SPECIFICATION_NAME=Optional[getSystemProperty("java.specification.name")]
String JAVA_SPECIFICATION_VENDOR=Optional[getSystemProperty("java.specification.vendor")]
String JAVA_SPECIFICATION_VERSION=Optional[getSystemProperty("java.specification.version")]
JavaVersion JAVA_SPECIFICATION_VERSION_AS_ENUM=Optional[JavaVersion.get(JAVA_SPECIFICATION_VERSION)]
String JAVA_UTIL_PREFS_PREFERENCES_FACTORY=Optional[getSystemProperty("java.util.prefs.PreferencesFactory")]
String JAVA_VENDOR=Optional[getSystemProperty("java.vendor")]
String JAVA_VENDOR_URL=Optional[getSystemProperty("java.vendor.url")]
String JAVA_VERSION=Optional[getSystemProperty("java.version")]
String JAVA_VM_INFO=Optional[getSystemProperty("java.vm.info")]
String JAVA_VM_NAME=Optional[getSystemProperty("java.vm.name")]
String JAVA_VM_SPECIFICATION_NAME=Optional[getSystemProperty("java.vm.specification.name")]
String JAVA_VM_SPECIFICATION_VENDOR=Optional[getSystemProperty("java.vm.specification.vendor")]
String JAVA_VM_SPECIFICATION_VERSION=Optional[getSystemProperty("java.vm.specification.version")]
String JAVA_VM_VENDOR=Optional[getSystemProperty("java.vm.vendor")]
String JAVA_VM_VERSION=Optional[getSystemProperty("java.vm.version")]
String LINE_SEPARATOR=Optional[getSystemProperty("line.separator")]
String OS_ARCH=Optional[getSystemProperty("os.arch")]
String OS_NAME=Optional[getSystemProperty("os.name")]
String OS_VERSION=Optional[getSystemProperty("os.version")]
String PATH_SEPARATOR=Optional[getSystemProperty("path.separator")]
String USER_COUNTRY=Optional[getSystemProperty("user.country") == null ? getSystemProperty("user.region") : getSystemProperty("user.country")]
String USER_DIR=Optional[getSystemProperty(USER_DIR_KEY)]
String USER_HOME=Optional[getSystemProperty(USER_HOME_KEY)]
String USER_LANGUAGE=Optional[getSystemProperty("user.language")]
String USER_NAME=Optional[getSystemProperty("user.name")]
String USER_TIMEZONE=Optional[getSystemProperty("user.timezone")]
boolean IS_JAVA_1_1=Optional[getJavaVersionMatches("1.1")]
boolean IS_JAVA_1_2=Optional[getJavaVersionMatches("1.2")]
boolean IS_JAVA_1_3=Optional[getJavaVersionMatches("1.3")]
boolean IS_JAVA_1_4=Optional[getJavaVersionMatches("1.4")]
boolean IS_JAVA_1_5=Optional[getJavaVersionMatches("1.5")]
boolean IS_JAVA_1_6=Optional[getJavaVersionMatches("1.6")]
boolean IS_JAVA_1_7=Optional[getJavaVersionMatches("1.7")]
boolean IS_OS_AIX=Optional[getOSMatchesName("AIX")]
boolean IS_OS_HP_UX=Optional[getOSMatchesName("HP-UX")]
boolean IS_OS_IRIX=Optional[getOSMatchesName("Irix")]
boolean IS_OS_LINUX=Optional[getOSMatchesName("Linux") || getOSMatchesName("LINUX")]
boolean IS_OS_MAC=Optional[getOSMatchesName("Mac")]
boolean IS_OS_MAC_OSX=Optional[getOSMatchesName("Mac OS X")]
boolean IS_OS_FREE_BSD=Optional[getOSMatchesName("FreeBSD")]
boolean IS_OS_OPEN_BSD=Optional[getOSMatchesName("OpenBSD")]
boolean IS_OS_NET_BSD=Optional[getOSMatchesName("NetBSD")]
boolean IS_OS_OS2=Optional[getOSMatchesName("OS/2")]
boolean IS_OS_SOLARIS=Optional[getOSMatchesName("Solaris")]
boolean IS_OS_SUN_OS=Optional[getOSMatchesName("SunOS")]
boolean IS_OS_UNIX=Optional[IS_OS_AIX || IS_OS_HP_UX || IS_OS_IRIX || IS_OS_LINUX || IS_OS_MAC_OSX || IS_OS_SOLARIS || IS_OS_SUN_OS || IS_OS_FREE_BSD || IS_OS_OPEN_BSD || IS_OS_NET_BSD]
boolean IS_OS_WINDOWS=Optional[getOSMatchesName(OS_NAME_WINDOWS_PREFIX)]
boolean IS_OS_WINDOWS_2000=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX, "5.0")]
boolean IS_OS_WINDOWS_2003=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX, "5.2")]
boolean IS_OS_WINDOWS_2008=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX + " Server 2008", "6.1")]
boolean IS_OS_WINDOWS_95=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX + " 9", "4.0")]
boolean IS_OS_WINDOWS_98=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX + " 9", "4.1")]
boolean IS_OS_WINDOWS_ME=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX, "4.9")]
boolean IS_OS_WINDOWS_NT=Optional[getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " NT")]
boolean IS_OS_WINDOWS_XP=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX, "5.1")]
boolean IS_OS_WINDOWS_VISTA=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX, "6.0")]
boolean IS_OS_WINDOWS_7=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX, "6.1")]
boolean IS_OS_WINDOWS_8=Optional[getOSMatches(OS_NAME_WINDOWS_PREFIX, "6.2")]
