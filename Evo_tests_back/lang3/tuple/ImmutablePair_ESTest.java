/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 05:33:14 GMT 2021
 */

package org.apache.commons.lang3.tuple;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ImmutablePair_ESTest extends ImmutablePair_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ImmutablePair<String, String> immutablePair0 = ImmutablePair.of((String) null, "");
      assertNotNull(immutablePair0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ImmutablePair<Object, String> immutablePair0 = new ImmutablePair<Object, String>("Q?!9Dh", "");
      String string0 = immutablePair0.getRight();
      assertEquals("", string0);
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ImmutablePair<String, Object> immutablePair0 = new ImmutablePair<String, Object>("#X(oH<XmBW", "#X(oH<XmBW");
      String string0 = immutablePair0.getLeft();
      assertEquals("#X(oH<XmBW", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ImmutablePair<String, Object> immutablePair0 = ImmutablePair.of((String) null, (Object) null);
      Object object0 = immutablePair0.getRight();
      assertNull(object0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ImmutablePair<Object, String> immutablePair0 = new ImmutablePair<Object, String>((Object) null, "");
      Object object0 = immutablePair0.getLeft();
      assertNull(object0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ImmutablePair<String, Comparable<String>> immutablePair0 = ImmutablePair.of("", (Comparable<String>) "");
      // Undeclared exception!
      try { 
        immutablePair0.setValue("(,)");
        fail("Expecting exception: UnsupportedOperationException");
      
      } catch(UnsupportedOperationException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.tuple.ImmutablePair", e);
      }
  }
}
