/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 12:53:05 GMT 2022
 */

package org.apache.commons.lang3.exception;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.exception.DefaultExceptionContext;
import org.apache.commons.lang3.tuple.Pair;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class DefaultExceptionContext_ESTest extends DefaultExceptionContext_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      DefaultExceptionContext defaultExceptionContext1 = defaultExceptionContext0.setContextValue((String) null, "Exception Context:\n\t[1:null=null]\n\t[2:~yub~!>4,#:CAl;=java.lang.String@0000000004]\n---------------------------------");
      Object object0 = defaultExceptionContext1.getFirstContextValue((String) null);
      assertNotNull(object0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      defaultExceptionContext0.setContextValue((String) null, (Object) null);
      List<Pair<String, Object>> list0 = defaultExceptionContext0.getContextEntries();
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      defaultExceptionContext0.addContextValue("~yub~!>4,#:CAl;", "~yub~!>4,#:CAl;");
      String string0 = defaultExceptionContext0.getFormattedExceptionMessage((String) null);
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      DefaultExceptionContext defaultExceptionContext1 = defaultExceptionContext0.setContextValue((String) null, (Object) null);
      String string0 = defaultExceptionContext1.getFormattedExceptionMessage("~yub~!>4,#:CAl;");
      assertEquals("~yub~!>4,#:CAl;\nException Context:\n\t[1:null=null]\n---------------------------------", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      String string0 = defaultExceptionContext0.getFormattedExceptionMessage("~yub~!>4,#:CAl;");
      assertEquals("~yub~!>4,#:CAl;", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      String string0 = defaultExceptionContext0.getFormattedExceptionMessage((String) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      DefaultExceptionContext defaultExceptionContext1 = defaultExceptionContext0.setContextValue((String) null, (Object) null);
      Set<String> set0 = defaultExceptionContext1.getContextLabels();
      assertFalse(set0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      Set<String> set0 = defaultExceptionContext0.getContextLabels();
      assertEquals(0, set0.size());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      DefaultExceptionContext defaultExceptionContext1 = defaultExceptionContext0.addContextValue("~yub~!>4,#:CAl;", "~yub~!>4,#:CAl;");
      Object object0 = defaultExceptionContext1.getFirstContextValue((String) null);
      assertNull(object0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      defaultExceptionContext0.addContextValue("~yub~!>4,#:CAl;", "~yub~!>4,#:CAl;");
      List<Object> list0 = defaultExceptionContext0.getContextValues((String) null);
      assertFalse(list0.contains("~yub~!>4,#:CAl;"));
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      defaultExceptionContext0.setContextValue((String) null, (Object) null);
      List<Object> list0 = defaultExceptionContext0.getContextValues((String) null);
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      DefaultExceptionContext defaultExceptionContext1 = defaultExceptionContext0.addContextValue("~yub~!>4,#:CAl;", "~yub~!>4,#:CAl;");
      DefaultExceptionContext defaultExceptionContext2 = defaultExceptionContext0.setContextValue((String) null, "Exception Context:\n\t[1:null=null]\n\t[2:~yub~!>4,#:CAl;=java.lang.String@0000000004]\n---------------------------------");
      assertSame(defaultExceptionContext2, defaultExceptionContext1);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      defaultExceptionContext0.setContextValue((String) null, (Object) null);
      DefaultExceptionContext defaultExceptionContext1 = defaultExceptionContext0.setContextValue((String) null, "Exception Context:\n\t[1:null=null]\n\t[2:~yub~!>4,#:CAl;=java.lang.String@0000000004]\n---------------------------------");
      assertSame(defaultExceptionContext0, defaultExceptionContext1);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      DefaultExceptionContext defaultExceptionContext0 = new DefaultExceptionContext();
      List<Pair<String, Object>> list0 = defaultExceptionContext0.getContextEntries();
      assertTrue(list0.isEmpty());
  }
}
