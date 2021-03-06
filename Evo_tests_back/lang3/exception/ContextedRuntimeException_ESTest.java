/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 04:51:47 GMT 2021
 */

package org.apache.commons.lang3.exception;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.exception.ContextedException;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.apache.commons.lang3.exception.ExceptionContext;
import org.apache.commons.lang3.tuple.Pair;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ContextedRuntimeException_ESTest extends ContextedRuntimeException_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("---------------------------------");
      String string0 = contextedRuntimeException0.getRawMessage();
      assertEquals("---------------------------------", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("");
      String string0 = contextedRuntimeException0.getRawMessage();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("0qjgQ");
      String string0 = contextedRuntimeException0.getMessage();
      assertEquals("0qjgQ", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("");
      String string0 = contextedRuntimeException0.getFormattedExceptionMessage("Exception Context:\n");
      assertEquals("Exception Context:\n", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      ContextedException contextedException0 = new ContextedException("");
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("", contextedException0, contextedException0);
      ContextedRuntimeException contextedRuntimeException1 = contextedRuntimeException0.setContextValue("", contextedException0);
      Object object0 = contextedRuntimeException1.getFirstContextValue("");
      assertSame(object0, contextedException0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("");
      contextedRuntimeException0.setContextValue("", (Object) null);
      List<Object> list0 = contextedRuntimeException0.getContextValues("");
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("");
      contextedRuntimeException0.setContextValue("", (Object) null);
      Set<String> set0 = contextedRuntimeException0.getContextLabels();
      assertEquals(1, set0.size());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("");
      ContextedRuntimeException contextedRuntimeException1 = contextedRuntimeException0.addContextValue("", (Object) null);
      List<Pair<String, Object>> list0 = contextedRuntimeException1.getContextEntries();
      assertFalse(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("", (Throwable) null, (ExceptionContext) null);
      String string0 = contextedRuntimeException0.getFormattedExceptionMessage("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      ContextedRuntimeException contextedRuntimeException1 = contextedRuntimeException0.setContextValue("", (Object) null);
      assertSame(contextedRuntimeException1, contextedRuntimeException0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException((Throwable) null);
      Set<String> set0 = contextedRuntimeException0.getContextLabels();
      assertTrue(set0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException((String) null);
      ContextedRuntimeException contextedRuntimeException1 = new ContextedRuntimeException("", contextedRuntimeException0);
      assertFalse(contextedRuntimeException1.equals((Object)contextedRuntimeException0));
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException((Throwable) null);
      List<Pair<String, Object>> list0 = contextedRuntimeException0.getContextEntries();
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("");
      List<Object> list0 = contextedRuntimeException0.getContextValues("");
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("");
      String string0 = contextedRuntimeException0.getMessage();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      String string0 = contextedRuntimeException0.getRawMessage();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      ContextedException contextedException0 = new ContextedException("");
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("", contextedException0, contextedException0);
      Object object0 = contextedRuntimeException0.getFirstContextValue("");
      assertNull(object0);
  }
}
