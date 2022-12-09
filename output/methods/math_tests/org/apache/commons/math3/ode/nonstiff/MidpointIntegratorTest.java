@Test(expected = DimensionMismatchException.class) [EOL] public void testDimensionCheck() throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException { [EOL]     TestProblem1 pb = new TestProblem1(); [EOL]     new MidpointIntegrator(0.01).integrate(pb, 0.0, new double[pb.getDimension() + 10], 1.0, new double[pb.getDimension() + 10]); [EOL]     Assert.fail("an exception should have been thrown"); [EOL] } <line_num>: 41,50
@Test [EOL] public void testDecreasingSteps() throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException { [EOL]     TestProblemAbstract[] problems = TestProblemFactory.getProblems(); [EOL]     for (int k = 0; k < problems.length; ++k) { [EOL]         double previousValueError = Double.NaN; [EOL]         double previousTimeError = Double.NaN; [EOL]         for (int i = 4; i < 10; ++i) { [EOL]             TestProblemAbstract pb = problems[k].copy(); [EOL]             double step = (pb.getFinalTime() - pb.getInitialTime()) * FastMath.pow(2.0, -i); [EOL]             FirstOrderIntegrator integ = new MidpointIntegrator(step); [EOL]             TestProblemHandler handler = new TestProblemHandler(pb, integ); [EOL]             integ.addStepHandler(handler); [EOL]             EventHandler[] functions = pb.getEventsHandlers(); [EOL]             for (int l = 0; l < functions.length; ++l) { [EOL]                 integ.addEventHandler(functions[l], Double.POSITIVE_INFINITY, 1.0e-6 * step, 1000); [EOL]             } [EOL]             double stopTime = integ.integrate(pb, pb.getInitialTime(), pb.getInitialState(), pb.getFinalTime(), new double[pb.getDimension()]); [EOL]             if (functions.length == 0) { [EOL]                 Assert.assertEquals(pb.getFinalTime(), stopTime, 1.0e-10); [EOL]             } [EOL]             double valueError = handler.getMaximalValueError(); [EOL]             if (i > 4) { [EOL]                 Assert.assertTrue(valueError < FastMath.abs(previousValueError)); [EOL]             } [EOL]             previousValueError = valueError; [EOL]             double timeError = handler.getMaximalTimeError(); [EOL]             if (i > 4) { [EOL]                 Assert.assertTrue(timeError <= FastMath.abs(previousTimeError)); [EOL]             } [EOL]             previousTimeError = timeError; [EOL]         } [EOL]     } [EOL] } <line_num>: 52,97
@Test [EOL] public void testSmallStep() throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException { [EOL]     TestProblem1 pb = new TestProblem1(); [EOL]     double step = (pb.getFinalTime() - pb.getInitialTime()) * 0.001; [EOL]     FirstOrderIntegrator integ = new MidpointIntegrator(step); [EOL]     TestProblemHandler handler = new TestProblemHandler(pb, integ); [EOL]     integ.addStepHandler(handler); [EOL]     integ.integrate(pb, pb.getInitialTime(), pb.getInitialState(), pb.getFinalTime(), new double[pb.getDimension()]); [EOL]     Assert.assertTrue(handler.getLastError() < 2.0e-7); [EOL]     Assert.assertTrue(handler.getMaximalValueError() < 1.0e-6); [EOL]     Assert.assertEquals(0, handler.getMaximalTimeError(), 1.0e-12); [EOL]     Assert.assertEquals("midpoint", integ.getName()); [EOL] } <line_num>: 99,119
@Test [EOL] public void testBigStep() throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException { [EOL]     TestProblem1 pb = new TestProblem1(); [EOL]     double step = (pb.getFinalTime() - pb.getInitialTime()) * 0.2; [EOL]     FirstOrderIntegrator integ = new MidpointIntegrator(step); [EOL]     TestProblemHandler handler = new TestProblemHandler(pb, integ); [EOL]     integ.addStepHandler(handler); [EOL]     integ.integrate(pb, pb.getInitialTime(), pb.getInitialState(), pb.getFinalTime(), new double[pb.getDimension()]); [EOL]     Assert.assertTrue(handler.getLastError() > 0.01); [EOL]     Assert.assertTrue(handler.getMaximalValueError() > 0.05); [EOL]     Assert.assertEquals(0, handler.getMaximalTimeError(), 1.0e-12); [EOL] } <line_num>: 121,140
@Test [EOL] public void testBackward() throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException { [EOL]     TestProblem5 pb = new TestProblem5(); [EOL]     double step = FastMath.abs(pb.getFinalTime() - pb.getInitialTime()) * 0.001; [EOL]     FirstOrderIntegrator integ = new MidpointIntegrator(step); [EOL]     TestProblemHandler handler = new TestProblemHandler(pb, integ); [EOL]     integ.addStepHandler(handler); [EOL]     integ.integrate(pb, pb.getInitialTime(), pb.getInitialState(), pb.getFinalTime(), new double[pb.getDimension()]); [EOL]     Assert.assertTrue(handler.getLastError() < 6.0e-4); [EOL]     Assert.assertTrue(handler.getMaximalValueError() < 6.0e-4); [EOL]     Assert.assertEquals(0, handler.getMaximalTimeError(), 1.0e-12); [EOL]     Assert.assertEquals("midpoint", integ.getName()); [EOL] } <line_num>: 142,160
public void handleStep(StepInterpolator interpolator, boolean isLast) { [EOL]     if (!isLast) { [EOL]         Assert.assertEquals(step, interpolator.getCurrentTime() - interpolator.getPreviousTime(), 1.0e-12); [EOL]     } [EOL] } <line_num>: 169,175
public void init(double t0, double[] y0, double t) { [EOL] } <line_num>: 176,177
public void computeDerivatives(double t, double[] y, double[] dot) { [EOL]     dot[0] = 1.0; [EOL] } <line_num>: 180,182
public int getDimension() { [EOL]     return 1; [EOL] } <line_num>: 183,185
@Test [EOL] public void testStepSize() throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException { [EOL]     final double step = 1.23456; [EOL]     FirstOrderIntegrator integ = new MidpointIntegrator(step); [EOL]     integ.addStepHandler(new StepHandler() { [EOL]  [EOL]         public void handleStep(StepInterpolator interpolator, boolean isLast) { [EOL]             if (!isLast) { [EOL]                 Assert.assertEquals(step, interpolator.getCurrentTime() - interpolator.getPreviousTime(), 1.0e-12); [EOL]             } [EOL]         } [EOL]  [EOL]         public void init(double t0, double[] y0, double t) { [EOL]         } [EOL]     }); [EOL]     integ.integrate(new FirstOrderDifferentialEquations() { [EOL]  [EOL]         public void computeDerivatives(double t, double[] y, double[] dot) { [EOL]             dot[0] = 1.0; [EOL]         } [EOL]  [EOL]         public int getDimension() { [EOL]             return 1; [EOL]         } [EOL]     }, 0.0, new double[] { 0.0 }, 5.0, new double[1]); [EOL] } <line_num>: 162,187
