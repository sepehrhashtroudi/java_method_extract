@Test [EOL] public void testMessage() { [EOL]     final int max = 12345; [EOL]     final TooManyEvaluationsException e = new TooManyEvaluationsException(max); [EOL]     final String msg = e.getLocalizedMessage(); [EOL]     Assert.assertTrue(msg, msg.matches(".*?" + MessageFormat.format("{0}", max) + ".*")); [EOL] } <line_num>: 30,39