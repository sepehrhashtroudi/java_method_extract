/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 05:10:51 GMT 2021
 */

package org.apache.commons.lang3.concurrent;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.concurrent.CallableBackgroundInitializer;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CallableBackgroundInitializer_ESTest extends CallableBackgroundInitializer_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Integer integer0 = new Integer((-1));
      Callable<Integer> callable0 = (Callable<Integer>) mock(Callable.class, new ViolatedAssumptionAnswer());
      doReturn(integer0).when(callable0).call();
      CallableBackgroundInitializer<Integer> callableBackgroundInitializer0 = new CallableBackgroundInitializer<Integer>(callable0);
      Integer integer1 = callableBackgroundInitializer0.initialize();
      assertEquals((-1), (int)integer1);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      TimeUnit timeUnit0 = TimeUnit.DAYS;
      ThreadFactory threadFactory0 = mock(ThreadFactory.class, new ViolatedAssumptionAnswer());
      ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0 = new ScheduledThreadPoolExecutor(3005, threadFactory0);
      BlockingQueue<Runnable> blockingQueue0 = scheduledThreadPoolExecutor0.getQueue();
      ThreadFactory threadFactory1 = mock(ThreadFactory.class, new ViolatedAssumptionAnswer());
      ThreadPoolExecutor.DiscardPolicy threadPoolExecutor_DiscardPolicy0 = new ThreadPoolExecutor.DiscardPolicy();
      ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(3005, 3005, 3005, timeUnit0, blockingQueue0, threadFactory1, threadPoolExecutor_DiscardPolicy0);
      CallableBackgroundInitializer<Runnable> callableBackgroundInitializer0 = null;
      try {
        callableBackgroundInitializer0 = new CallableBackgroundInitializer<Runnable>((Callable<Runnable>) null, threadPoolExecutor0);
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
      Callable<Integer> callable0 = (Callable<Integer>) mock(Callable.class, new ViolatedAssumptionAnswer());
      CallableBackgroundInitializer<Callable<Object>> callableBackgroundInitializer0 = null;
      try {
        callableBackgroundInitializer0 = new CallableBackgroundInitializer<Callable<Object>>((Callable<Callable<Object>>) null);
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
      Callable<Delayed> callable0 = (Callable<Delayed>) mock(Callable.class, new ViolatedAssumptionAnswer());
      CallableBackgroundInitializer<Delayed> callableBackgroundInitializer0 = new CallableBackgroundInitializer<Delayed>(callable0, (ExecutorService) null);
      Callable<Integer> callable1 = (Callable<Integer>) mock(Callable.class, new ViolatedAssumptionAnswer());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Callable<Integer> callable0 = (Callable<Integer>) mock(Callable.class, new ViolatedAssumptionAnswer());
      doReturn((Object) null).when(callable0).call();
      CallableBackgroundInitializer<Integer> callableBackgroundInitializer0 = new CallableBackgroundInitializer<Integer>(callable0);
      Integer integer0 = callableBackgroundInitializer0.initialize();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      CallableBackgroundInitializer<Callable<Object>> callableBackgroundInitializer0 = null;
      try {
        callableBackgroundInitializer0 = new CallableBackgroundInitializer<Callable<Object>>((Callable<Callable<Object>>) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Callable must not be null!
         //
         verifyException("org.apache.commons.lang3.concurrent.CallableBackgroundInitializer", e);
      }
  }
}
