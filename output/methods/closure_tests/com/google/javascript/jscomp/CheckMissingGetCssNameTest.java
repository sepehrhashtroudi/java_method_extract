@Override [EOL] protected CompilerPass getProcessor(final Compiler compiler) { [EOL]     return new CombinedCompilerPass(compiler, new CheckMissingGetCssName(compiler, CheckLevel.ERROR, "goog-[a-z-]*")); [EOL] } <line_num>: 23,28
public void testMissingGetCssName() { [EOL]     testMissing("var s = 'goog-inline-block'"); [EOL]     testMissing("var s = 'CSS_FOO goog-menu'"); [EOL]     testMissing("alert('goog-inline-block ' + goog.getClassName('CSS_FOO'))"); [EOL]     testMissing("html = '<div class=\"goog-special-thing\">Hello</div>'"); [EOL] } <line_num>: 30,35
public void testRecognizeGetCssName() { [EOL]     testNotMissing("var s = goog.getCssName('goog-inline-block')"); [EOL] } <line_num>: 37,39
public void testIgnoreGetUniqueIdArguments() { [EOL]     testNotMissing("var s = goog.events.getUniqueId('goog-some-event')"); [EOL]     testNotMissing("var s = joe.random.getUniqueId('joe-is-a-goob')"); [EOL] } <line_num>: 41,44
public void testIgnoreAssignmentsToIdConstant() { [EOL]     testNotMissing("SOME_ID = 'goog-some-id'"); [EOL]     testNotMissing("SOME_PRIVATE_ID_ = 'goog-some-id'"); [EOL]     testNotMissing("var SOME_ID_ = 'goog-some-id'"); [EOL] } <line_num>: 46,50
public void testNotMissingGetCssName() { [EOL]     testNotMissing("s = 'not-a-css-name'"); [EOL]     testNotMissing("s = 'notagoog-css-name'"); [EOL] } <line_num>: 52,55
public void testDontCrashIfTheresNoQualifiedName() { [EOL]     testMissing("things[2].DONT_CARE_ABOUT_THIS_KIND_OF_ID = " + "'goog-inline-block'"); [EOL]     testMissing("objects[3].doSomething('goog-inline-block')"); [EOL] } <line_num>: 57,61
private void testMissing(String js) { [EOL]     test(js, js, CheckMissingGetCssName.MISSING_GETCSSNAME); [EOL] } <line_num>: 63,65
private void testNotMissing(String js) { [EOL]     test(js, js); [EOL] } <line_num>: 67,69