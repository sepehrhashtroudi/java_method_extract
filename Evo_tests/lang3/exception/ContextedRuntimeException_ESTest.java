/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 12:49:21 GMT 2022
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
import org.evosuite.runtime.mock.java.lang.MockThrowable;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ContextedRuntimeException_ESTest extends ContextedRuntimeException_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      String string0 = contextedRuntimeException0.getRawMessage();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      ContextedRuntimeException contextedRuntimeException1 = new ContextedRuntimeException("2v|/6-", contextedRuntimeException0);
      String string0 = contextedRuntimeException1.getRawMessage();
      assertEquals("2v|/6-", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("Exception Context:\n");
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("Exception Context:\n", mockThrowable0);
      String string0 = contextedRuntimeException0.getMessage();
      assertEquals("Exception Context:\n", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      String string0 = contextedRuntimeException0.getFormattedExceptionMessage("+n`G=_F/x*T ");
      assertEquals("+n`G=_F/x*T ", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("Exception Context:\n");
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("Exception Context:\n", mockThrowable0);
      Object object0 = new Object();
      ContextedRuntimeException contextedRuntimeException1 = contextedRuntimeException0.addContextValue("Exception Context:\n", object0);
      Object object1 = contextedRuntimeException1.getFirstContextValue("Exception Context:\n");
      assertSame(object1, object0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      Object object0 = new Object();
      ContextedRuntimeException contextedRuntimeException1 = contextedRuntimeException0.setContextValue("ua<{DWZ|Y%", object0);
      List<Object> list0 = contextedRuntimeException1.getContextValues("ua<{DWZ|Y%");
      assertFalse(list0.contains("ua<{DWZ|Y%"));
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      contextedRuntimeException0.addContextValue("g&')17T", "g&')17T");
      Set<String> set0 = contextedRuntimeException0.getContextLabels();
      assertFalse(set0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("", mockThrowable0, (ExceptionContext) null);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      ContextedRuntimeException contextedRuntimeException1 = contextedRuntimeException0.addContextValue("1a?9CH\f50A+]h)", "1a?9CH\f50A+]h)");
      List<Pair<String, Object>> list0 = contextedRuntimeException1.getContextEntries();
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      Set<String> set0 = contextedRuntimeException0.getContextLabels();
      assertTrue(set0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      String string0 = contextedRuntimeException0.getMessage();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      List<Pair<String, Object>> list0 = contextedRuntimeException0.getContextEntries();
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      ContextedRuntimeException contextedRuntimeException1 = new ContextedRuntimeException(contextedRuntimeException0);
      assertFalse(contextedRuntimeException1.equals((Object)contextedRuntimeException0));
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException();
      List<Object> list0 = contextedRuntimeException0.getContextValues("ua<{DWZ|Y%");
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("");
      String string0 = contextedRuntimeException0.getFormattedExceptionMessage("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      ContextedException contextedException0 = new ContextedException();
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("", mockThrowable0, contextedException0);
      String string0 = contextedRuntimeException0.getRawMessage();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("org.apache.commons.lang3.exception.ContextedRuntimeException");
      ContextedRuntimeException contextedRuntimeException0 = new ContextedRuntimeException("org.apache.commons.lang3.exception.ContextedRuntimeException", mockThrowable0);
      Object object0 = contextedRuntimeException0.getFirstContextValue("os?)_Lm://B<o");
      assertNull(object0);
  }
}
