public void setUp()
protected void testSame(CompilerOptions options, String original)
protected void testSame(CompilerOptions options, String[] original)
protected void test(CompilerOptions options, String original, String compiled)
protected void test(CompilerOptions options, String[] original, String[] compiled)
protected void test(CompilerOptions options, String original, DiagnosticType warning)
protected void test(CompilerOptions options, String original, String compiled, DiagnosticType warning)
protected void test(CompilerOptions options, String[] original, DiagnosticType warning)
protected void test(CompilerOptions options, String[] original, String[] compiled, DiagnosticType warning)
protected void test(CompilerOptions options, String[] original, String[] compiled, DiagnosticType[] warnings)
protected void checkUnexpectedErrorsOrWarnings(Compiler compiler, int expected)
protected Compiler compile(CompilerOptions options, String original)
protected Compiler compile(CompilerOptions options, String[] original)
protected Node parse(String[] original, CompilerOptions options, boolean normalize)
 abstract CompilerOptions createCompilerOptions()
