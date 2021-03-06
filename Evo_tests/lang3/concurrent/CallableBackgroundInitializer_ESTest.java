/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 13:11:49 GMT 2022
 */

package org.apache.commons.lang3.concurrent;

import org.evosuite.shaded.org.mockito.MockSettings;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.concurrent.CallableBackgroundInitializer;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CallableBackgroundInitializer_ESTest extends CallableBackgroundInitializer_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Callable<String> callable0 = (Callable<String>) mock(Callable.class, (MockSettings) new ViolatedAssumptionAnswer());
      doReturn("8uV|ZJ").when(callable0).call();
      CallableBackgroundInitializer<String> callableBackgroundInitializer0 = new CallableBackgroundInitializer<String>(callable0);
      String string0 = callableBackgroundInitializer0.initialize();
      assertEquals("8uV|ZJ", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      CallableBackgroundInitializer<Object> callableBackgroundInitializer0 = null;
      try {
        callableBackgroundInitializer0 = new CallableBackgroundInitializer<Object>((Callable<Object>) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Callable must not be null!
         //
         verifyException("org.apache.commons.lang3.concurrent.CallableBackgroundInitializer", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      CallableBackgroundInitializer<Object> callableBackgroundInitializer0 = null;
      try {
        callableBackgroundInitializer0 = new CallableBackgroundInitializer<Object>((Callable<Object>) null, (ExecutorService) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Callable must not be null!
         //
         verifyException("org.apache.commons.lang3.concurrent.CallableBackgroundInitializer", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Callable<String> callable0 = (Callable<String>) mock(Callable.class, (MockSettings) new ViolatedAssumptionAnswer());
      CallableBackgroundInitializer<String> callableBackgroundInitializer0 = new CallableBackgroundInitializer<String>(callable0, (ExecutorService) null);
      assertFalse(callableBackgroundInitializer0.isStarted());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Callable<Delayed> callable0 = (Callable<Delayed>) mock(Callable.class, (MockSettings) new ViolatedAssumptionAnswer());
      doReturn((Object) null).when(callable0).call();
      CallableBackgroundInitializer<Delayed> callableBackgroundInitializer0 = new CallableBackgroundInitializer<Delayed>(callable0);
      Delayed delayed0 = callableBackgroundInitializer0.initialize();
      assertNull(delayed0);
  }
}
