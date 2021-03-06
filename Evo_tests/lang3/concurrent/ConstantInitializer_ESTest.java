/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 13:15:59 GMT 2022
 */

package org.apache.commons.lang3.concurrent;

import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.lang3.concurrent.ConstantInitializer;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ConstantInitializer_ESTest extends ConstantInitializer_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Integer integer0 = new Integer(2013);
      ConstantInitializer<Object> constantInitializer0 = new ConstantInitializer<Object>(integer0);
      Object object0 = constantInitializer0.getObject();
      assertEquals(2013, object0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>((String) null);
      String string0 = constantInitializer0.get();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>((String) null);
      String string0 = constantInitializer0.getObject();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ConstantInitializer<Object> constantInitializer0 = new ConstantInitializer<Object>((Object) null);
      ConstantInitializer<String> constantInitializer1 = new ConstantInitializer<String>("ConstantInitializer@1 [ object = null ]");
      ConstantInitializer<ConstantInitializer<String>> constantInitializer2 = new ConstantInitializer<ConstantInitializer<String>>(constantInitializer1);
      Object object0 = constantInitializer2.get();
      boolean boolean0 = constantInitializer0.equals(object0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>("ConstantInitializer@1 [ object = null ]");
      boolean boolean0 = constantInitializer0.equals("ConstantInitializer@1 [ object = null ]");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>("ConstantInitializer@1 [ object = null ]");
      constantInitializer0.hashCode();
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ConstantInitializer<Object> constantInitializer0 = new ConstantInitializer<Object>((Object) null);
      constantInitializer0.hashCode();
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>("ConstantInitializer@1 [ object = null ]");
      ConstantInitializer<ConstantInitializer<String>> constantInitializer1 = new ConstantInitializer<ConstantInitializer<String>>(constantInitializer0);
      Object object0 = constantInitializer1.get();
      boolean boolean0 = constantInitializer0.equals(object0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      ConstantInitializer<Object> constantInitializer0 = new ConstantInitializer<Object>((Object) null);
      String string0 = constantInitializer0.toString();
      assertNotNull(string0);
  }
}
