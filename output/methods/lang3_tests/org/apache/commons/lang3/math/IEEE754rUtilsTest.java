@Test [EOL] public void testLang381() { [EOL]     assertEquals(1.2, IEEE754rUtils.min(1.2, 2.5, Double.NaN), 0.01); [EOL]     assertEquals(2.5, IEEE754rUtils.max(1.2, 2.5, Double.NaN), 0.01); [EOL]     assertTrue(Double.isNaN(IEEE754rUtils.max(Double.NaN, Double.NaN, Double.NaN))); [EOL]     assertEquals(1.2f, IEEE754rUtils.min(1.2f, 2.5f, Float.NaN), 0.01); [EOL]     assertEquals(2.5f, IEEE754rUtils.max(1.2f, 2.5f, Float.NaN), 0.01); [EOL]     assertTrue(Float.isNaN(IEEE754rUtils.max(Float.NaN, Float.NaN, Float.NaN))); [EOL]     final double[] a = new double[] { 1.2, Double.NaN, 3.7, 27.0, 42.0, Double.NaN }; [EOL]     assertEquals(42.0, IEEE754rUtils.max(a), 0.01); [EOL]     assertEquals(1.2, IEEE754rUtils.min(a), 0.01); [EOL]     final double[] b = new double[] { Double.NaN, 1.2, Double.NaN, 3.7, 27.0, 42.0, Double.NaN }; [EOL]     assertEquals(42.0, IEEE754rUtils.max(b), 0.01); [EOL]     assertEquals(1.2, IEEE754rUtils.min(b), 0.01); [EOL]     final float[] aF = new float[] { 1.2f, Float.NaN, 3.7f, 27.0f, 42.0f, Float.NaN }; [EOL]     assertEquals(1.2f, IEEE754rUtils.min(aF), 0.01); [EOL]     assertEquals(42.0f, IEEE754rUtils.max(aF), 0.01); [EOL]     final float[] bF = new float[] { Float.NaN, 1.2f, Float.NaN, 3.7f, 27.0f, 42.0f, Float.NaN }; [EOL]     assertEquals(1.2f, IEEE754rUtils.min(bF), 0.01); [EOL]     assertEquals(42.0f, IEEE754rUtils.max(bF), 0.01); [EOL] } <line_num>: 32,56
@Test [EOL] public void testEnforceExceptions() { [EOL]     try { [EOL]         IEEE754rUtils.min((float[]) null); [EOL]         fail("IllegalArgumentException expected for null input"); [EOL]     } catch (final IllegalArgumentException iae) { [EOL]     } [EOL]     try { [EOL]         IEEE754rUtils.min(new float[0]); [EOL]         fail("IllegalArgumentException expected for empty input"); [EOL]     } catch (final IllegalArgumentException iae) { [EOL]     } [EOL]     try { [EOL]         IEEE754rUtils.max((float[]) null); [EOL]         fail("IllegalArgumentException expected for null input"); [EOL]     } catch (final IllegalArgumentException iae) { [EOL]     } [EOL]     try { [EOL]         IEEE754rUtils.max(new float[0]); [EOL]         fail("IllegalArgumentException expected for empty input"); [EOL]     } catch (final IllegalArgumentException iae) { [EOL]     } [EOL]     try { [EOL]         IEEE754rUtils.min((double[]) null); [EOL]         fail("IllegalArgumentException expected for null input"); [EOL]     } catch (final IllegalArgumentException iae) { [EOL]     } [EOL]     try { [EOL]         IEEE754rUtils.min(new double[0]); [EOL]         fail("IllegalArgumentException expected for empty input"); [EOL]     } catch (final IllegalArgumentException iae) { [EOL]     } [EOL]     try { [EOL]         IEEE754rUtils.max((double[]) null); [EOL]         fail("IllegalArgumentException expected for null input"); [EOL]     } catch (final IllegalArgumentException iae) { [EOL]     } [EOL]     try { [EOL]         IEEE754rUtils.max(new double[0]); [EOL]         fail("IllegalArgumentException expected for empty input"); [EOL]     } catch (final IllegalArgumentException iae) { [EOL]     } [EOL] } <line_num>: 58,100
@Test [EOL] public void testConstructorExists() { [EOL]     new IEEE754rUtils(); [EOL] } <line_num>: 102,105