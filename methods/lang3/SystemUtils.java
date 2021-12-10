public static File getJavaHome() {	    return new File(System.getProperty(JAVA_HOME_KEY));	}
public static File getJavaIoTmpDir() {	    return new File(System.getProperty(JAVA_IO_TMPDIR_KEY));	}
private static boolean getJavaVersionMatches(final String versionPrefix) {	    return isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, versionPrefix);	}
private static boolean getOSMatches(final String osNamePrefix, final String osVersionPrefix) {	    return isOSMatch(OS_NAME, OS_VERSION, osNamePrefix, osVersionPrefix);	}
private static boolean getOSMatchesName(final String osNamePrefix) {	    return isOSNameMatch(OS_NAME, osNamePrefix);	}
private static String getSystemProperty(final String property) {	    try {	        return System.getProperty(property);	    } catch (final SecurityException ex) {	        System.err.println("Caught a SecurityException reading the system property '" + property + "'; the SystemUtils property value will default to null.");	        return null;	    }	}
public static File getUserDir() {	    return new File(System.getProperty(USER_DIR_KEY));	}
public static File getUserHome() {	    return new File(System.getProperty(USER_HOME_KEY));	}
public static boolean isJavaAwtHeadless() {	    return JAVA_AWT_HEADLESS != null ? JAVA_AWT_HEADLESS.equals(Boolean.TRUE.toString()) : false;	}
public static boolean isJavaVersionAtLeast(final JavaVersion requiredVersion) {	    return JAVA_SPECIFICATION_VERSION_AS_ENUM.atLeast(requiredVersion);	}
static boolean isJavaVersionMatch(final String version, final String versionPrefix) {	    if (version == null) {	        return false;	    }	    return version.startsWith(versionPrefix);	}
static boolean isOSMatch(final String osName, final String osVersion, final String osNamePrefix, final String osVersionPrefix) {	    if (osName == null || osVersion == null) {	        return false;	    }	    return osName.startsWith(osNamePrefix) && osVersion.startsWith(osVersionPrefix);	}
static boolean isOSNameMatch(final String osName, final String osNamePrefix) {	    if (osName == null) {	        return false;	    }	    return osName.startsWith(osNamePrefix);	}
