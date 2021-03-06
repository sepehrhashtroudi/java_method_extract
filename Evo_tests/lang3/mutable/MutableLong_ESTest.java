/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 14:11:51 GMT 2022
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
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.setValue((-1180L));
      mutableLong0.hashCode();
      assertEquals((-1180L), mutableLong0.longValue());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong((-289L));
      MutableLong mutableLong1 = new MutableLong(mutableLong0);
      mutableLong0.decrement();
      boolean boolean0 = mutableLong1.equals(mutableLong0);
      assertEquals((-290.0), mutableLong0.doubleValue(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      Float float0 = new Float(2536.42494394915);
      MutableLong mutableLong1 = new MutableLong(float0);
      mutableLong0.subtract((Number) mutableLong1);
      assertEquals((-2536L), mutableLong0.longValue());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong((-375L));
      mutableLong0.add(3281L);
      Long long0 = mutableLong0.toLong();
      assertEquals(2906L, (long)long0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Byte byte0 = new Byte((byte) (-98));
      MutableLong mutableLong0 = new MutableLong((Number) byte0);
      mutableLong0.setValue((-490L));
      Long long0 = mutableLong0.toLong();
      assertEquals((-490L), (long)long0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong((-375L));
      Long long0 = mutableLong0.toLong();
      assertEquals((-375L), (long)long0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      long long0 = mutableLong0.longValue();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong((-289L));
      long long0 = mutableLong0.longValue();
      assertEquals((-289L), long0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      int int0 = mutableLong0.intValue();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      Integer integer0 = new Integer((-1772));
      mutableLong0.add((Number) integer0);
      int int0 = mutableLong0.intValue();
      assertEquals((short) (-1772), mutableLong0.shortValue());
      assertEquals((-1772), int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Byte byte0 = new Byte((byte) (-98));
      MutableLong mutableLong0 = new MutableLong((Number) byte0);
      Long long0 = mutableLong0.getValue();
      assertEquals((-98L), (long)long0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.setValue(1173L);
      float float0 = mutableLong0.floatValue();
      assertEquals(1173.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong((-854L));
      float float0 = mutableLong0.floatValue();
      assertEquals((-854.0F), float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong((-854L));
      double double0 = mutableLong0.doubleValue();
      assertEquals((-854.0), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
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
  public void test15()  throws Throwable  {
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
  public void test16()  throws Throwable  {
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
  public void test17()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
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
  public void test18()  throws Throwable  {
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
  public void test19()  throws Throwable  {
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
  public void test20()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong(288L);
      long long0 = mutableLong0.longValue();
      assertEquals(288L, long0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      Float float0 = new Float(2536.42494394915);
      MutableLong mutableLong1 = new MutableLong(float0);
      int int0 = mutableLong1.compareTo(mutableLong0);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      MutableLong mutableLong1 = new MutableLong("0");
      mutableLong0.decrement();
      int int0 = mutableLong0.compareTo(mutableLong1);
      assertEquals((-1L), mutableLong0.longValue());
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong(288L);
      int int0 = mutableLong0.compareTo(mutableLong0);
      assertEquals((byte)32, mutableLong0.byteValue());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      MutableLong mutableLong1 = new MutableLong("0");
      mutableLong0.decrement();
      boolean boolean0 = mutableLong0.equals(mutableLong1);
      assertEquals((-1.0F), mutableLong0.floatValue(), 0.01F);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong(288L);
      boolean boolean0 = mutableLong0.equals(mutableLong0);
      assertTrue(boolean0);
      assertEquals((short)288, mutableLong0.shortValue());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong(288L);
      Long long0 = mutableLong0.getValue();
      assertEquals(288L, (long)long0);
      
      boolean boolean0 = mutableLong0.equals(long0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.subtract((-1L));
      assertEquals(1L, (long)mutableLong0.toLong());
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.increment();
      assertEquals(1L, (long)mutableLong0.toLong());
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      double double0 = mutableLong0.doubleValue();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      float float0 = mutableLong0.floatValue();
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      Float float0 = new Float((float) 0);
      mutableLong0.setValue((Number) float0);
      assertEquals((short)0, mutableLong0.shortValue());
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      mutableLong0.setValue(1173L);
      double double0 = mutableLong0.doubleValue();
      assertEquals(1173.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      String string0 = mutableLong0.toString();
      assertEquals("0", string0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong(16L);
      int int0 = mutableLong0.intValue();
      assertEquals(16, int0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      Long long0 = mutableLong0.getValue();
      assertEquals(0L, (long)long0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      MutableLong mutableLong0 = new MutableLong();
      Long long0 = mutableLong0.toLong();
      assertEquals(0L, (long)long0);
  }
}
