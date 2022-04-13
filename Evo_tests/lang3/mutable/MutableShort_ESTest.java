/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 14:08:25 GMT 2022
 */

package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.lang3.mutable.MutableShort;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class MutableShort_ESTest extends MutableShort_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short) (-991));
      mutableShort0.decrement();
      MutableShort mutableShort1 = new MutableShort((short) (-991));
      boolean boolean0 = mutableShort0.equals(mutableShort1);
      assertEquals((short) (-992), mutableShort0.shortValue());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort("8");
      Short short0 = mutableShort0.toShort();
      assertEquals((short)8, (short)short0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Double double0 = new Double((-983.1855));
      MutableShort mutableShort0 = new MutableShort(double0);
      Short short0 = mutableShort0.toShort();
      assertEquals((short) (-983), (short)short0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)0);
      mutableShort0.decrement();
      mutableShort0.toShort();
      assertEquals((byte) (-1), mutableShort0.byteValue());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Long long0 = new Long(0L);
      MutableShort mutableShort0 = new MutableShort(long0);
      short short0 = mutableShort0.shortValue();
      assertEquals((short)0, short0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)123);
      short short0 = mutableShort0.shortValue();
      assertEquals((short)123, short0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      long long0 = mutableShort0.longValue();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short) (-1476));
      long long0 = mutableShort0.longValue();
      assertEquals((-1476L), long0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)1);
      int int0 = mutableShort0.intValue();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)0);
      mutableShort0.decrement();
      int int0 = mutableShort0.intValue();
      assertEquals((byte) (-1), mutableShort0.byteValue());
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      mutableShort0.setValue((short)15);
      Short short0 = mutableShort0.getValue();
      assertEquals((short)15, (short)short0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Double double0 = new Double((-983.1855));
      MutableShort mutableShort0 = new MutableShort(double0);
      Short short0 = mutableShort0.getValue();
      assertEquals((short) (-983), (short)short0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short) (-2690));
      Long long0 = new Long(3570L);
      mutableShort0.subtract((Number) long0);
      Short short0 = mutableShort0.getValue();
      assertEquals((short) (-6260), (short)short0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)0);
      mutableShort0.increment();
      float float0 = mutableShort0.floatValue();
      assertEquals((short)1, (short)mutableShort0.toShort());
      assertEquals(1.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short) (-991));
      float float0 = mutableShort0.floatValue();
      assertEquals((-991.0F), float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)0);
      double double0 = mutableShort0.doubleValue();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Byte byte0 = new Byte((byte) (-73));
      MutableShort mutableShort0 = new MutableShort((Number) byte0);
      double double0 = mutableShort0.doubleValue();
      assertEquals((-73.0), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short) (-2690));
      // Undeclared exception!
      try { 
        mutableShort0.subtract((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableShort", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      // Undeclared exception!
      try { 
        mutableShort0.setValue((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableShort", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      // Undeclared exception!
      try { 
        mutableShort0.compareTo((MutableShort) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableShort", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short) (-1057));
      // Undeclared exception!
      try { 
        mutableShort0.add((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableShort", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      MutableShort mutableShort0 = null;
      try {
        mutableShort0 = new MutableShort((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableShort", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short) (-2690));
      short short0 = mutableShort0.shortValue();
      assertEquals((short) (-2690), short0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)1);
      Double double0 = new Double((short)1);
      mutableShort0.add((Number) double0);
      MutableShort mutableShort1 = new MutableShort((short)1);
      int int0 = mutableShort0.compareTo(mutableShort1);
      assertEquals(2.0F, mutableShort0.floatValue(), 0.01F);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      MutableShort mutableShort1 = new MutableShort((short) (-1052));
      int int0 = mutableShort1.compareTo(mutableShort0);
      assertEquals((-1), int0);
      assertEquals((-1052L), mutableShort1.longValue());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)1);
      int int0 = mutableShort0.compareTo(mutableShort0);
      assertEquals(0, int0);
      assertEquals((short)1, mutableShort0.shortValue());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      MutableShort mutableShort1 = new MutableShort((short) (-1052));
      boolean boolean0 = mutableShort0.equals(mutableShort1);
      assertFalse(boolean0);
      assertFalse(mutableShort1.equals((Object)mutableShort0));
      assertEquals((short) (-1052), mutableShort1.shortValue());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      boolean boolean0 = mutableShort0.equals(mutableShort0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      Short short0 = mutableShort0.getValue();
      boolean boolean0 = mutableShort0.equals(short0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)1);
      mutableShort0.subtract((short) (-743));
      assertEquals(744, mutableShort0.intValue());
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      float float0 = mutableShort0.floatValue();
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      int int0 = mutableShort0.intValue();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      Byte byte0 = new Byte((byte) (-41));
      mutableShort0.setValue((Number) byte0);
      assertEquals("-41", mutableShort0.toString());
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)1);
      long long0 = mutableShort0.longValue();
      assertEquals(1L, long0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort();
      Short short0 = mutableShort0.toShort();
      assertEquals((short)0, (short)short0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)1);
      String string0 = mutableShort0.toString();
      assertEquals("1", string0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)1);
      mutableShort0.hashCode();
      assertEquals("1", mutableShort0.toString());
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      MutableShort mutableShort0 = null;
      try {
        mutableShort0 = new MutableShort("");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         //
         // For input string: \"\"
         //
         verifyException("java.lang.NumberFormatException", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)1);
      double double0 = mutableShort0.doubleValue();
      assertEquals(1.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      MutableShort mutableShort0 = new MutableShort((short)1);
      mutableShort0.add((short)3165);
      assertEquals((short)3166, (short)mutableShort0.toShort());
  }
}
