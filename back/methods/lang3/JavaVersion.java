public boolean atLeast(final JavaVersion requiredVersion) { [EOL]     return this.value >= requiredVersion.value; [EOL] }
static JavaVersion getJavaVersion(final String nom) { [EOL]     return get(nom); [EOL] }
static JavaVersion get(final String nom) { [EOL]     if ("0.9".equals(nom)) { [EOL]         return JAVA_0_9; [EOL]     } else if ("1.1".equals(nom)) { [EOL]         return JAVA_1_1; [EOL]     } else if ("1.2".equals(nom)) { [EOL]         return JAVA_1_2; [EOL]     } else if ("1.3".equals(nom)) { [EOL]         return JAVA_1_3; [EOL]     } else if ("1.4".equals(nom)) { [EOL]         return JAVA_1_4; [EOL]     } else if ("1.5".equals(nom)) { [EOL]         return JAVA_1_5; [EOL]     } else if ("1.6".equals(nom)) { [EOL]         return JAVA_1_6; [EOL]     } else if ("1.7".equals(nom)) { [EOL]         return JAVA_1_7; [EOL]     } else if ("1.8".equals(nom)) { [EOL]         return JAVA_1_8; [EOL]     } else { [EOL]         return null; [EOL]     } [EOL] }
@Override [EOL] public String toString() { [EOL]     return name; [EOL] }