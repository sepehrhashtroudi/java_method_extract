/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 05:22:06 GMT 2021
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
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>((String) null);
      String string0 = constantInitializer0.getObject();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ConstantInitializer<Object> constantInitializer0 = new ConstantInitializer<Object>((Object) null);
      Object object0 = constantInitializer0.get();
      assertNull(object0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>((String) null);
      Object object0 = new Object();
      boolean boolean0 = constantInitializer0.equals(object0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Integer integer0 = new Integer(1);
      ConstantInitializer<Object> constantInitializer0 = new ConstantInitializer<Object>(integer0);
      ConstantInitializer<ConstantInitializer<Object>> constantInitializer1 = new ConstantInitializer<ConstantInitializer<Object>>(constantInitializer0);
      Object object0 = constantInitializer1.getObject();
      boolean boolean0 = constantInitializer0.equals(object0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Integer integer0 = new Integer(1);
      ConstantInitializer<Object> constantInitializer0 = new ConstantInitializer<Object>(integer0);
      ConstantInitializer<ConstantInitializer<Object>> constantInitializer1 = new ConstantInitializer<ConstantInitializer<Object>>(constantInitializer0);
      boolean boolean0 = constantInitializer1.equals(constantInitializer0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ConstantInitializer<Integer> constantInitializer0 = new ConstantInitializer<Integer>((Integer) null);
      constantInitializer0.hashCode();
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>("t");
      String string0 = constantInitializer0.get();
      assertEquals("t", string0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>("t");
      String string0 = constantInitializer0.toString();
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      ConstantInitializer<String> constantInitializer0 = new ConstantInitializer<String>("t");
      constantInitializer0.hashCode();
  }
}
