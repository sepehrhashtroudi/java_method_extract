/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 12:47:03 GMT 2022
 */

package org.apache.commons.lang3.math;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.lang3.math.Fraction;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Fraction_ESTest extends Fraction_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE;
      Fraction fraction1 = Fraction.ONE_FIFTH;
      int int0 = fraction1.compareTo(fraction0);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-938.4003844737051));
      fraction0.hashCode();
      fraction0.hashCode();
      assertEquals(5722, fraction0.getDenominator());
      assertEquals((-938.4004F), fraction0.floatValue(), 0.01F);
      assertEquals((-5369527), fraction0.getNumerator());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_FIFTHS;
      Fraction fraction1 = Fraction.THREE_QUARTERS;
      Fraction fraction2 = fraction0.subtract(fraction1);
      Fraction fraction3 = fraction2.invert();
      boolean boolean0 = fraction0.equals(fraction3);
      assertEquals((-20), fraction3.getNumerator());
      assertFalse(boolean0);
      assertEquals((-0.35), fraction2.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_FIFTH;
      Fraction fraction1 = Fraction.getFraction((-1766.6));
      Fraction fraction2 = fraction0.TWO_FIFTHS.divideBy(fraction1);
      assertEquals((-2.2642364E-4F), fraction2.floatValue(), 0.01F);
      assertEquals((-2), fraction2.getNumerator());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction("/AbQ`2e,R}(iAEA{hL");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         //
         // For input string: \"\"
         //
         verifyException("java.lang.NumberFormatException", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction(" 3?ti|,gArr7SzFEA");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         //
         // For input string: \" 3?ti|,gArr7SzFEA\"
         //
         verifyException("java.lang.NumberFormatException", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(2.147483647E9);
      // Undeclared exception!
      try { 
        fraction0.add(fraction0);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // overflow: add
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-343.091735238));
      Fraction fraction1 = fraction0.TWO_FIFTHS.subtract(fraction0);
      assertEquals(343.4917352327152, fraction1.doubleValue(), 0.01);
      assertEquals((-2793796), fraction0.getNumerator());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE;
      Fraction fraction1 = Fraction.getFraction(6346.553582771);
      Fraction fraction2 = fraction0.subtract(fraction1);
      assertEquals((-6345.553582752061), fraction2.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-3950.07061040265));
      Fraction fraction1 = fraction0.reduce();
      assertEquals((-3950.0706104103233), fraction1.doubleValue(), 0.01);
      assertEquals(6897, fraction0.getDenominator());
      assertSame(fraction1, fraction0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Fraction fraction0 = Fraction.getReducedFraction(0, 47);
      Fraction fraction1 = fraction0.ZERO.pow(1);
      assertSame(fraction1, fraction0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Fraction fraction0 = Fraction.THREE_FIFTHS;
      Fraction fraction1 = fraction0.THREE_FIFTHS.negate();
      Fraction fraction2 = fraction1.pow((-1));
      assertEquals(3, fraction2.getDenominator());
      assertEquals((-3), fraction1.getNumerator());
      assertEquals((-1.6666666666666667), fraction2.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE;
      Fraction fraction1 = fraction0.negate();
      fraction1.negate();
      assertEquals((-1.0), fraction1.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE;
      Fraction fraction1 = fraction0.multiplyBy(fraction0);
      assertEquals(1L, fraction1.longValue());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_FIFTHS;
      Fraction fraction1 = Fraction.FOUR_FIFTHS;
      Fraction fraction2 = fraction0.ONE_HALF.add(fraction1);
      Fraction fraction3 = Fraction.getFraction((-88), (-88));
      Fraction fraction4 = fraction3.negate();
      Fraction fraction5 = fraction2.multiplyBy(fraction4);
      assertEquals((-1.3), fraction5.doubleValue(), 0.01);
      assertFalse(fraction5.equals((Object)fraction2));
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_QUARTER;
      long long0 = fraction0.longValue();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_QUARTERS;
      Fraction fraction1 = fraction0.TWO_THIRDS.add(fraction0);
      Fraction fraction2 = fraction1.negate();
      long long0 = fraction2.longValue();
      assertEquals(12, fraction1.getDenominator());
      assertEquals((-1L), long0);
      assertEquals((-1.1666666F), fraction2.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE;
      int int0 = fraction0.intValue();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-1958.0));
      int int0 = fraction0.intValue();
      assertEquals((-1958), int0);
      assertEquals(1, fraction0.getDenominator());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE;
      int int0 = fraction0.getProperWhole();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_FIFTHS;
      Fraction fraction1 = Fraction.THREE_QUARTERS;
      Fraction fraction2 = fraction0.subtract(fraction1);
      Fraction fraction3 = fraction2.invert();
      int int0 = fraction3.getProperWhole();
      assertEquals((-2), int0);
      assertEquals(20, fraction2.getDenominator());
      assertEquals((-2.857143F), fraction3.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_HALF;
      int int0 = fraction0.getProperNumerator();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE;
      int int0 = fraction0.getNumerator();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Fraction fraction0 = Fraction.ZERO;
      Fraction fraction1 = fraction0.FOUR_FIFTHS.negate();
      int int0 = fraction1.getNumerator();
      assertEquals((-4), int0);
      assertEquals((-0.8), fraction1.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction("0/1");
      assertEquals(0.0F, fraction0.floatValue(), 0.01F);
      assertEquals(1, fraction0.getDenominator());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction("-1");
      assertEquals((-1.0F), fraction0.floatValue(), 0.01F);
      assertEquals((-1), fraction0.getNumerator());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(0, 0, 5449);
      assertEquals(0.0F, fraction0.floatValue(), 0.01F);
      assertEquals(5449, fraction0.getDenominator());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(1, 1, 1);
      assertEquals(2.0F, fraction0.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_QUARTERS;
      Fraction fraction1 = fraction0.negate();
      float float0 = fraction1.floatValue();
      assertEquals((-0.5F), float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Fraction fraction0 = Fraction.ZERO;
      double double0 = fraction0.doubleValue();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_QUARTERS;
      Fraction fraction1 = fraction0.negate();
      double double0 = fraction1.doubleValue();
      assertEquals((-0.5), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_FIFTH;
      Fraction fraction1 = Fraction.getFraction((-938.4003844737051));
      Fraction fraction2 = fraction1.divideBy(fraction0);
      assertEquals(5722, fraction2.getDenominator());
      assertEquals((-4692.002F), fraction2.floatValue(), 0.01F);
      assertEquals((short) (-938), fraction1.shortValue());
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_QUARTER;
      Fraction fraction1 = fraction0.ONE.negate();
      Fraction fraction2 = Fraction.getFraction(1, 1);
      Fraction fraction3 = fraction1.add(fraction2);
      float float0 = fraction3.floatValue();
      assertEquals(1, fraction3.getDenominator());
      assertEquals(1.0F, fraction2.floatValue(), 0.01F);
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE;
      Fraction fraction1 = Fraction.getFraction((-384.8282687636917));
      Fraction fraction2 = fraction0.ONE.add(fraction1);
      assertEquals((-383.82828F), fraction2.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Fraction fraction0 = Fraction.ZERO;
      Fraction fraction1 = fraction0.ZERO.abs();
      assertSame(fraction1, fraction0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-1236), 2);
      Fraction fraction1 = Fraction.getFraction(2, 1896);
      Fraction fraction2 = fraction0.subtract(fraction1);
      Fraction fraction3 = fraction2.divideBy(fraction1);
      Fraction fraction4 = fraction3.abs();
      assertEquals(948, fraction2.getDenominator());
      assertEquals(1896, fraction1.getDenominator());
      assertEquals(585865, fraction4.getNumerator());
      assertEquals((-585865.0), fraction3.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_FIFTHS;
      // Undeclared exception!
      try { 
        fraction0.TWO_FIFTHS.subtract((Fraction) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The fraction must not be null
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-3950.07061040265));
      // Undeclared exception!
      try { 
        fraction0.multiplyBy(fraction0);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // overflow: mul
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Fraction fraction0 = Fraction.FOUR_FIFTHS;
      // Undeclared exception!
      try { 
        fraction0.compareTo((Fraction) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      Fraction fraction0 = Fraction.getReducedFraction(1, 1);
      Fraction fraction1 = Fraction.ONE;
      boolean boolean0 = fraction0.equals(fraction1);
      assertTrue(boolean0);
      assertEquals(1, fraction1.getDenominator());
      assertEquals(1, fraction1.getNumerator());
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      Fraction fraction0 = Fraction.getReducedFraction(1, 1);
      Fraction fraction1 = fraction0.TWO_QUARTERS.multiplyBy(fraction0);
      boolean boolean0 = fraction0.equals(fraction1);
      assertEquals(2, fraction1.getDenominator());
      assertEquals(0.5F, fraction1.floatValue(), 0.01F);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(1236, 1236, 1236);
      boolean boolean0 = fraction0.equals(fraction0);
      assertTrue(boolean0);
      assertEquals(1237.0, fraction0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      Fraction fraction0 = Fraction.ZERO;
      Fraction fraction1 = fraction0.multiplyBy(fraction0);
      assertEquals(0, fraction1.getNumerator());
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Fraction fraction0 = Fraction.FOUR_FIFTHS;
      // Undeclared exception!
      try { 
        fraction0.ONE_QUARTER.pow(1223);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // overflow: mulPos
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_QUARTER;
      // Undeclared exception!
      try { 
        fraction0.ONE_HALF.pow(1416);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // overflow: mulPos
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_HALF;
      Fraction fraction1 = fraction0.pow(1);
      assertSame(fraction1, fraction0);
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE;
      int int0 = fraction0.getProperNumerator();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      Fraction fraction0 = Fraction.ZERO;
      int int0 = fraction0.getNumerator();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      Fraction fraction0 = Fraction.FOUR_FIFTHS;
      int int0 = fraction0.getProperWhole();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-3535.9));
      int int0 = fraction0.getDenominator();
      assertEquals((-3535.9F), fraction0.floatValue(), 0.01F);
      assertEquals(10, int0);
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-1.0));
      String string0 = fraction0.toProperString();
      assertNotNull(string0);
      assertEquals("-1", string0);
      assertEquals(1, fraction0.getDenominator());
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-1), (-1));
      String string0 = fraction0.toProperString();
      assertNotNull(string0);
      assertEquals("1", string0);
      assertEquals(1, fraction0.getNumerator());
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_QUARTERS;
      Fraction fraction1 = fraction0.TWO_THIRDS.add(fraction0);
      fraction1.toProperString();
      Fraction fraction2 = fraction0.THREE_FIFTHS.divideBy(fraction0);
      fraction0.TWO_THIRDS.multiplyBy(fraction1);
      int int0 = 1;
      Fraction.getFraction("1 4/15");
      Fraction.getFraction((-2333.05197763358));
      fraction0.floatValue();
      fraction0.doubleValue();
      fraction2.ZERO.hashCode();
      Fraction fraction3 = fraction2.TWO_THIRDS.multiplyBy(fraction0);
      fraction3.ONE_QUARTER.invert();
      fraction2.ZERO.toProperString();
      Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
      int int1 = (-1162);
      // Undeclared exception!
      try { 
        Fraction.getReducedFraction(Integer.MIN_VALUE, (-1162));
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // overflow: can't negate
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_FIFTHS;
      fraction0.TWO_QUARTERS.toProperString();
      assertEquals(2, fraction0.getNumerator());
      assertEquals(5, fraction0.getDenominator());
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-3535.9));
      Fraction fraction1 = Fraction.ONE;
      int int0 = fraction0.compareTo(fraction1);
      assertEquals((-3535.9), fraction0.doubleValue(), 0.01);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_HALF;
      Fraction fraction1 = Fraction.TWO_QUARTERS;
      int int0 = fraction0.compareTo(fraction1);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(1927.04087);
      Fraction fraction1 = Fraction.getFraction(1927.04087);
      fraction0.compareTo(fraction1);
      assertEquals(1927.0408700050582, fraction1.doubleValue(), 0.01);
      assertEquals(404, fraction0.getProperNumerator());
  }

  @Test(timeout = 4000)
  public void test57()  throws Throwable  {
      Fraction fraction0 = Fraction.THREE_FIFTHS;
      Fraction fraction1 = Fraction.ONE_FIFTH;
      Fraction fraction2 = fraction0.subtract(fraction1);
      Fraction fraction3 = fraction2.add(fraction0);
      int int0 = fraction3.compareTo(fraction1);
      assertEquals(1, fraction3.getNumerator());
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test58()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_HALF;
      int int0 = fraction0.compareTo(fraction0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test59()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_FIFTHS;
      Fraction fraction1 = Fraction.THREE_QUARTERS;
      boolean boolean0 = fraction0.equals(fraction1);
      assertFalse(boolean0);
      assertEquals(3, fraction1.getNumerator());
  }

  @Test(timeout = 4000)
  public void test60()  throws Throwable  {
      Fraction fraction0 = Fraction.THREE_FIFTHS;
      Object object0 = new Object();
      boolean boolean0 = fraction0.equals(object0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test61()  throws Throwable  {
      Fraction fraction0 = Fraction.ZERO;
      // Undeclared exception!
      try { 
        fraction0.ONE_FIFTH.divideBy(fraction0);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // The fraction to divide by must not be zero
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test62()  throws Throwable  {
      Fraction fraction0 = Fraction.FOUR_FIFTHS;
      // Undeclared exception!
      try { 
        fraction0.TWO_QUARTERS.divideBy((Fraction) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The fraction must not be null
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test63()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-3535.9));
      Fraction fraction1 = fraction0.subtract(fraction0);
      Fraction fraction2 = fraction0.multiplyBy(fraction1);
      assertEquals(1, fraction1.getDenominator());
      assertEquals((-3535.9F), fraction0.floatValue(), 0.01F);
      assertEquals(10, fraction0.getDenominator());
      assertEquals(0, fraction2.getProperNumerator());
  }

  @Test(timeout = 4000)
  public void test64()  throws Throwable  {
      Fraction fraction0 = Fraction.THREE_QUARTERS;
      Fraction fraction1 = fraction0.ZERO.divideBy(fraction0);
      assertEquals(0.0F, fraction1.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test65()  throws Throwable  {
      Fraction fraction0 = Fraction.THREE_FIFTHS;
      // Undeclared exception!
      try { 
        fraction0.TWO_QUARTERS.multiplyBy((Fraction) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The fraction must not be null
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test66()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(0, 32);
      Fraction fraction1 = fraction0.ONE.add(fraction0);
      assertEquals(1, fraction1.getNumerator());
      assertEquals(32, fraction0.getDenominator());
  }

  @Test(timeout = 4000)
  public void test67()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(0, 32);
      Fraction fraction1 = fraction0.ZERO.subtract(fraction0);
      assertNotSame(fraction1, fraction0);
      assertEquals(32, fraction1.getDenominator());
      assertTrue(fraction1.equals((Object)fraction0));
      assertEquals(0.0, fraction0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test68()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_HALF;
      // Undeclared exception!
      try { 
        fraction0.THREE_QUARTERS.add((Fraction) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The fraction must not be null
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test69()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_FIFTHS;
      Fraction fraction1 = Fraction.getFraction(Integer.MIN_VALUE, 2147483646);
      // Undeclared exception!
      try { 
        fraction1.add(fraction0);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // overflow: mul
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test70()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_QUARTERS;
      Fraction fraction1 = fraction0.ONE.pow(Integer.MIN_VALUE);
      assertEquals(1.0F, fraction1.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test71()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_QUARTERS;
      Fraction fraction1 = fraction0.pow(0);
      assertEquals(1, fraction1.getProperWhole());
  }

  @Test(timeout = 4000)
  public void test72()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-1), (-1));
      Fraction fraction1 = fraction0.abs();
      assertEquals(1, fraction0.getNumerator());
      assertEquals(1, fraction1.getProperWhole());
  }

  @Test(timeout = 4000)
  public void test73()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-3950.07061040265));
      Fraction fraction1 = fraction0.abs();
      assertEquals(3950.0706104103233, fraction1.doubleValue(), 0.01);
      assertEquals((-3950.0706104103233), fraction0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test74()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-3535.9));
      Fraction fraction1 = fraction0.invert();
      assertEquals(35359, fraction1.getDenominator());
      assertEquals((-3535.9), fraction0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test75()  throws Throwable  {
      Fraction fraction0 = Fraction.ONE_HALF;
      // Undeclared exception!
      try { 
        fraction0.ZERO.invert();
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // Unable to invert zero.
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test76()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(1236, 1236, 1236);
      Fraction fraction1 = fraction0.reduce();
      assertEquals(1237, fraction1.getNumerator());
      assertEquals((short)1237, fraction1.shortValue());
  }

  @Test(timeout = 4000)
  public void test77()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-3535.9));
      Fraction fraction1 = fraction0.subtract(fraction0);
      Fraction fraction2 = fraction1.reduce();
      assertSame(fraction2, fraction1);
      assertEquals((-35359), fraction0.getNumerator());
      assertEquals(1, fraction2.getDenominator());
      assertEquals((-3535.9F), fraction0.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test78()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-1), (-1));
      Fraction fraction1 = fraction0.reduce();
      assertSame(fraction1, fraction0);
      assertEquals((short)1, fraction1.shortValue());
      assertEquals(1, fraction1.getDenominator());
  }

  @Test(timeout = 4000)
  public void test79()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction("u<?1}J.80f{EO5`2ch%");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
      }
  }

  @Test(timeout = 4000)
  public void test80()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The string must not be null
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test81()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction("-3535 9/10");
      assertEquals((-3535.9), fraction0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test82()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction(1.7976931348623157E308);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // The value must not be greater than Integer.MAX_VALUE or NaN
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test83()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getReducedFraction(5, Integer.MIN_VALUE);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // overflow: can't negate
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test84()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((double) 0);
      assertEquals(0.0, fraction0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test85()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getReducedFraction(0, 0);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // The denominator must not be zero
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test86()  throws Throwable  {
      Fraction fraction0 = Fraction.getReducedFraction((-181), (-1));
      assertEquals(181.0, fraction0.doubleValue(), 0.01);
      assertEquals(1, fraction0.getDenominator());
  }

  @Test(timeout = 4000)
  public void test87()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction(1762, 1242, Integer.MAX_VALUE);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // Numerator too large to represent as an Integer.
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test88()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(0, 25, 1790);
      assertEquals(0.01396648F, fraction0.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test89()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction(5, (-73), 4);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // The numerator must not be negative
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test90()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction(680, 256, (-2491));
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // The denominator must not be negative
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test91()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction(0, 0, 0);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // The denominator must not be zero
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test92()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction(0, Integer.MIN_VALUE);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // overflow: can't negate
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test93()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // overflow: can't negate
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test94()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction(0, 2259);
      Fraction fraction1 = fraction0.reduce();
      assertEquals(1, fraction1.getDenominator());
      assertFalse(fraction1.equals((Object)fraction0));
      assertEquals(2259, fraction0.getDenominator());
      assertEquals(0, fraction1.getNumerator());
  }

  @Test(timeout = 4000)
  public void test95()  throws Throwable  {
      // Undeclared exception!
      try { 
        Fraction.getFraction(0, 0);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // The denominator must not be zero
         //
         verifyException("org.apache.commons.lang3.math.Fraction", e);
      }
  }

  @Test(timeout = 4000)
  public void test96()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-1), (-1));
      long long0 = fraction0.longValue();
      assertEquals(1L, long0);
      assertEquals(1, fraction0.getDenominator());
  }

  @Test(timeout = 4000)
  public void test97()  throws Throwable  {
      Fraction fraction0 = Fraction.getFraction((-1), 337, 337);
      String string0 = fraction0.toProperString();
      assertEquals("-2", string0);
  }

  @Test(timeout = 4000)
  public void test98()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_FIFTHS;
      Fraction fraction1 = Fraction.THREE_QUARTERS;
      fraction0.ONE_HALF.hashCode();
      fraction0.toString();
      Fraction fraction2 = fraction1.abs();
      Fraction fraction3 = Fraction.getFraction((-1623), (-1623));
      Fraction fraction4 = fraction1.invert();
      Fraction fraction5 = fraction4.ONE_FIFTH.abs();
      Fraction fraction6 = fraction4.ZERO.negate();
      String string0 = fraction0.toProperString();
      assertEquals("2/5", string0);
      
      fraction1.ONE_FIFTH.abs();
      fraction0.equals(fraction4);
      Fraction fraction7 = fraction1.negate();
      Fraction fraction8 = Fraction.getFraction((-1623), (-1623));
      fraction8.ONE_HALF.reduce();
      Fraction fraction9 = Fraction.TWO_THIRDS;
      Fraction fraction10 = fraction9.add(fraction7);
      assertEquals((-0.083333336F), fraction10.floatValue(), 0.01F);
      
      Fraction fraction11 = fraction2.ONE_QUARTER.subtract(fraction9);
      assertEquals(12, fraction11.getDenominator());
      
      Fraction fraction12 = Fraction.ONE_FIFTH;
      Fraction fraction13 = fraction2.reduce();
      Fraction fraction14 = Fraction.THREE_FIFTHS;
      Fraction fraction15 = fraction2.add(fraction14);
      Fraction fraction16 = fraction4.ONE_HALF.divideBy(fraction13);
      Fraction fraction17 = Fraction.getReducedFraction((-1623), (-1623));
      Fraction fraction18 = Fraction.getReducedFraction((-3838), 58);
      assertEquals(29, fraction18.getDenominator());
      
      Fraction fraction19 = fraction15.reduce();
      assertSame(fraction19, fraction15);
      
      fraction17.longValue();
      assertEquals(1, fraction17.getNumerator());
      
      int int0 = fraction13.compareTo(fraction0);
      assertEquals(1, int0);
      
      fraction6.toString();
      fraction5.invert();
      int int1 = fraction13.intValue();
      assertEquals(0, int1);
      
      fraction3.toString();
      assertEquals(1, fraction3.intValue());
      
      fraction2.divideBy(fraction16);
      assertTrue(fraction16.equals((Object)fraction9));
  }

  @Test(timeout = 4000)
  public void test99()  throws Throwable  {
      Fraction fraction0 = Fraction.TWO_FIFTHS;
      Fraction fraction1 = fraction0.add(fraction0);
      assertEquals(4, fraction1.getNumerator());
      assertEquals(0.8F, fraction1.floatValue(), 0.01F);
  }
}
