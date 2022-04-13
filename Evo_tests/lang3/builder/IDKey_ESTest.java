/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 14:26:48 GMT 2022
 */

package org.apache.commons.lang3.builder;

import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.lang3.builder.IDKey;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class IDKey_ESTest extends IDKey_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      IDKey iDKey0 = new IDKey((Object) null);
      IDKey iDKey1 = new IDKey((Object) null);
      boolean boolean0 = iDKey0.equals(iDKey1);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Object object0 = new Object();
      IDKey iDKey0 = new IDKey(object0);
      IDKey iDKey1 = new IDKey(iDKey0);
      boolean boolean0 = iDKey1.equals(iDKey0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Object object0 = new Object();
      IDKey iDKey0 = new IDKey(object0);
      IDKey iDKey1 = new IDKey(iDKey0);
      boolean boolean0 = iDKey0.equals(iDKey1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      IDKey iDKey0 = new IDKey((Object) null);
      boolean boolean0 = iDKey0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      IDKey iDKey0 = new IDKey((Object) null);
      iDKey0.hashCode();
  }
}
