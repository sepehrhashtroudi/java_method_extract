/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 04:43:14 GMT 2021
 */

package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.lang3.mutable.MutableFloat;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class MutableFloat_ESTest extends MutableFloat_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Float float0 = new Float((-2916.93448225));
      MutableFloat mutableFloat0 = new MutableFloat((Number) float0);
      MutableFloat mutableFloat1 = new MutableFloat();
      mutableFloat1.setValue((-1.0F));
      boolean boolean0 = mutableFloat0.equals(mutableFloat1);
      assertEquals((-1L), mutableFloat1.longValue());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Integer integer0 = new Integer(2280);
      MutableFloat mutableFloat0 = new MutableFloat((Number) integer0);
      Short short0 = new Short((short) (-1931));
      mutableFloat0.subtract((Number) short0);
      assertEquals(4211.0, mutableFloat0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Double double0 = new Double((-1.2639182580149089));
      MutableFloat mutableFloat0 = new MutableFloat(double0);
      mutableFloat0.add((Number) double0);
      assertEquals((-2L), mutableFloat0.longValue());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      mutableFloat0.subtract((-1.7143645F));
      mutableFloat0.toFloat();
      assertEquals(1.7143645286560059, mutableFloat0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      Integer integer0 = new Integer((-629));
      mutableFloat0.setValue((Number) integer0);
      mutableFloat0.add((float) (-629));
      Float float0 = mutableFloat0.toFloat();
      assertEquals((-1258.0F), (float)float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Float float0 = new Float((-2916.93448225));
      MutableFloat mutableFloat0 = new MutableFloat((Number) float0);
      Float float1 = mutableFloat0.toFloat();
      assertEquals((-2916.9346F), (float)float1, 0.01F);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      Short short0 = new Short((short) (-1));
      mutableFloat0.setValue((Number) short0);
      long long0 = mutableFloat0.longValue();
      assertEquals((-1L), long0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Float float0 = new Float((-2916.93448225));
      MutableFloat mutableFloat0 = new MutableFloat((Number) float0);
      mutableFloat0.setValue((-1.0F));
      mutableFloat0.increment();
      int int0 = mutableFloat0.intValue();
      assertEquals(0.0F, mutableFloat0.floatValue(), 0.01F);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat((-1032.271F));
      Byte byte0 = new Byte((byte)119);
      mutableFloat0.setValue((Number) byte0);
      int int0 = mutableFloat0.intValue();
      assertEquals((short)119, mutableFloat0.shortValue());
      assertEquals(119, int0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat(0.0F);
      mutableFloat0.increment();
      mutableFloat0.getValue();
      assertEquals(1.0F, mutableFloat0.getValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      Byte byte0 = new Byte((byte) (-2));
      mutableFloat0.setValue((Number) byte0);
      Float float0 = mutableFloat0.getValue();
      assertEquals((-2.0F), (float)float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Integer integer0 = new Integer(2280);
      MutableFloat mutableFloat0 = new MutableFloat((Number) integer0);
      float float0 = mutableFloat0.floatValue();
      assertEquals(2280.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      Byte byte0 = new Byte((byte) (-2));
      mutableFloat0.setValue((Number) byte0);
      float float0 = mutableFloat0.floatValue();
      assertEquals((-2.0F), float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat(0.0F);
      mutableFloat0.increment();
      double double0 = mutableFloat0.doubleValue();
      assertEquals(1.0F, mutableFloat0.toFloat(), 0.01F);
      assertEquals(1.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      Byte byte0 = new Byte((byte) (-2));
      mutableFloat0.setValue((Number) byte0);
      double double0 = mutableFloat0.doubleValue();
      assertEquals((-2.0), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat(0.0F);
      int int0 = mutableFloat0.compareTo(mutableFloat0);
      assertEquals(0, int0);
      assertEquals(0.0, mutableFloat0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat("5");
      MutableFloat mutableFloat1 = new MutableFloat(0.0F);
      int int0 = mutableFloat0.compareTo(mutableFloat1);
      assertEquals(1, int0);
      assertEquals("0.0", mutableFloat1.toString());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat(0.0F);
      MutableFloat mutableFloat1 = new MutableFloat(0.0F);
      mutableFloat1.increment();
      int int0 = mutableFloat0.compareTo(mutableFloat1);
      assertEquals((short)1, mutableFloat1.shortValue());
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat((-2860.708F));
      // Undeclared exception!
      try { 
        mutableFloat0.subtract((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableFloat", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat(1411.02F);
      // Undeclared exception!
      try { 
        mutableFloat0.setValue((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableFloat", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat(1791.0F);
      // Undeclared exception!
      try { 
        mutableFloat0.add((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableFloat", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      MutableFloat mutableFloat0 = null;
      try {
        mutableFloat0 = new MutableFloat((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      MutableFloat mutableFloat0 = null;
      try {
        mutableFloat0 = new MutableFloat((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableFloat", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      float float0 = mutableFloat0.floatValue();
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      MutableFloat mutableFloat1 = new MutableFloat((-1.7143645F));
      boolean boolean0 = mutableFloat1.equals(mutableFloat0);
      assertFalse(boolean0);
      assertFalse(mutableFloat0.equals((Object)mutableFloat1));
      assertEquals((-1.7143645F), mutableFloat1.toFloat(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      boolean boolean0 = mutableFloat0.equals(mutableFloat0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      boolean boolean0 = mutableFloat0.equals("d");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      String string0 = mutableFloat0.toString();
      assertEquals("0.0", string0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      mutableFloat0.hashCode();
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      double double0 = mutableFloat0.doubleValue();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      mutableFloat0.decrement();
      assertEquals((-1.0F), mutableFloat0.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      Float float0 = mutableFloat0.toFloat();
      assertEquals(0.0F, (float)float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      Float float0 = mutableFloat0.getValue();
      assertEquals(0.0F, (float)float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Double double0 = new Double((-1.2639182580149089));
      MutableFloat mutableFloat0 = new MutableFloat(double0);
      int int0 = mutableFloat0.intValue();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      mutableFloat0.increment();
      long long0 = mutableFloat0.longValue();
      assertEquals((byte)1, mutableFloat0.byteValue());
      assertEquals(1L, long0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      boolean boolean0 = mutableFloat0.isInfinite();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      MutableFloat mutableFloat0 = null;
      try {
        mutableFloat0 = new MutableFloat("");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      boolean boolean0 = mutableFloat0.isNaN();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      long long0 = mutableFloat0.longValue();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      MutableFloat mutableFloat0 = new MutableFloat();
      // Undeclared exception!
      try { 
        mutableFloat0.compareTo((MutableFloat) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableFloat", e);
      }
  }
}