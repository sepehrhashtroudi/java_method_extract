/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 04:49:39 GMT 2021
 */

package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.lang3.mutable.MutableLong;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class MutableLong_ESTest extends MutableLong_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong((-1L));
      mutableLong0.hashCode();
      assertEquals((-1.0), mutableLong0.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.add((-1L));
      MutableLong mutableLong1 = new MutableLong("0");
      boolean boolean0 = mutableLong0.equals(mutableLong1);
      assertEquals((byte) (-1), mutableLong0.byteValue());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.subtract((Number) mutableLong0);
      assertEquals(0, mutableLong0.intValue());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      Long long0 = mutableLong0.toLong();
      assertEquals(0L, (long)long0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Byte byte0 = new Byte((byte)0);
      MutableLong mutableLong0 = new MutableLong((Number) byte0);
      mutableLong0.increment();
      mutableLong0.toLong();
      assertEquals(1, mutableLong0.intValue());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Byte byte0 = new Byte((byte)88);
      MutableLong mutableLong0 = new MutableLong((Number) byte0);
      long long0 = mutableLong0.longValue();
      assertEquals(88L, long0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.decrement();
      long long0 = mutableLong0.longValue();
      assertEquals((-1), mutableLong0.intValue());
      assertEquals((-1L), long0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Float float0 = new Float(1.0F);
      MutableLong mutableLong0 = new MutableLong(float0);
      int int0 = mutableLong0.intValue();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.decrement();
      int int0 = mutableLong0.intValue();
      assertEquals((-1L), mutableLong0.longValue());
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Byte byte0 = new Byte((byte)0);
      MutableLong mutableLong0 = new MutableLong((Number) byte0);
      mutableLong0.subtract(984L);
      mutableLong0.getValue();
      assertEquals("-984", mutableLong0.toString());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Byte byte0 = new Byte((byte)88);
      MutableLong mutableLong0 = new MutableLong((Number) byte0);
      Long long0 = mutableLong0.getValue();
      assertEquals(88L, (long)long0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong(3217L);
      Double double0 = new Double(0.0);
      mutableLong0.setValue((Number) double0);
      mutableLong0.add(3217L);
      mutableLong0.getValue();
      assertEquals(3217L, (long)mutableLong0.toLong());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.setValue(525L);
      float float0 = mutableLong0.floatValue();
      assertEquals(525.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.subtract(563L);
      float float0 = mutableLong0.floatValue();
      assertEquals((-563L), (long)mutableLong0.getValue());
      assertEquals((-563.0F), float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong(0L);
      double double0 = mutableLong0.doubleValue();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong(810L);
      double double0 = mutableLong0.doubleValue();
      assertEquals(810.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong(0L);
      // Undeclared exception!
      try { 
        mutableLong0.subtract((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableLong", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      // Undeclared exception!
      try { 
        mutableLong0.setValue((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableLong", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      // Undeclared exception!
      try { 
        mutableLong0.compareTo((MutableLong) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableLong", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong((-1L));
      // Undeclared exception!
      try { 
        mutableLong0.add((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableLong", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      MutableLong mutableLong0 = null;
      try {
        mutableLong0 = new MutableLong("");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         //
         // For input string: \"\"
         //
         verifyException("java.lang.NumberFormatException", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      MutableLong mutableLong0 = null;
      try {
        mutableLong0 = new MutableLong((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableLong", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      long long0 = mutableLong0.longValue();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.increment();
      MutableLong mutableLong1 = new MutableLong("0");
      int int0 = mutableLong0.compareTo(mutableLong1);
      assertEquals(1.0F, mutableLong0.floatValue(), 0.01F);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Double double0 = new Double((-30.60225976818994));
      MutableLong mutableLong0 = new MutableLong(double0);
      MutableLong mutableLong1 = new MutableLong(810L);
      int int0 = mutableLong0.compareTo(mutableLong1);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      int int0 = mutableLong0.compareTo(mutableLong0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      boolean boolean0 = mutableLong0.equals(mutableLong0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Double double0 = new Double((-30.60225976818994));
      MutableLong mutableLong0 = new MutableLong(double0);
      boolean boolean0 = mutableLong0.equals(double0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Double double0 = new Double((-30.60225976818994));
      MutableLong mutableLong0 = new MutableLong(double0);
      mutableLong0.add((Number) double0);
      assertEquals((short) (-60), mutableLong0.shortValue());
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Double double0 = new Double((-30.60225976818994));
      MutableLong mutableLong0 = new MutableLong(double0);
      mutableLong0.subtract((Number) double0);
      assertEquals((short)0, mutableLong0.shortValue());
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.increment();
      MutableLong mutableLong1 = new MutableLong("0");
      boolean boolean0 = mutableLong0.equals(mutableLong1);
      assertEquals(1L, (long)mutableLong0.toLong());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Double double0 = new Double((-30.60225976818994));
      MutableLong mutableLong0 = new MutableLong(double0);
      double double1 = mutableLong0.doubleValue();
      assertEquals((-30.0), double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      float float0 = mutableLong0.floatValue();
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      String string0 = mutableLong0.toString();
      assertEquals("0", string0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      int int0 = mutableLong0.intValue();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      Long long0 = mutableLong0.getValue();
      assertEquals(0L, (long)long0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Double double0 = new Double((-30.60225976818994));
      MutableLong mutableLong0 = new MutableLong(double0);
      Long long0 = mutableLong0.toLong();
      assertEquals((-30L), (long)long0);
  }
}
