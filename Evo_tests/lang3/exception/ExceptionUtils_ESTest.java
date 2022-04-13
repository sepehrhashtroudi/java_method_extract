/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 12:50:53 GMT 2022
 */

package org.apache.commons.lang3.exception;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.io.MockPrintStream;
import org.evosuite.runtime.mock.java.io.MockPrintWriter;
import org.evosuite.runtime.mock.java.lang.MockThrowable;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ExceptionUtils_ESTest extends ExceptionUtils_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      LinkedList<String> linkedList0 = new LinkedList<String>();
      linkedList0.addLast("getRootCause");
      LinkedList<String> linkedList1 = new LinkedList<String>();
      linkedList1.add("");
      linkedList0.add("");
      ExceptionUtils.removeCommonFrames(linkedList0, linkedList1);
      assertFalse(linkedList0.contains(""));
      assertEquals(1, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      LinkedList<String> linkedList0 = new LinkedList<String>();
      linkedList0.add("getRootCause");
      linkedList0.add("getThrowable");
      ExceptionUtils.removeCommonFrames(linkedList0, linkedList0);
      assertFalse(linkedList0.contains("getRootCause"));
      assertEquals(0, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      MockThrowable mockThrowable1 = new MockThrowable();
      mockThrowable0.initCause(mockThrowable1);
      MockThrowable mockThrowable2 = new MockThrowable(mockThrowable0);
      String[] stringArray0 = ExceptionUtils.getRootCauseStackTrace(mockThrowable2);
      assertEquals(3, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("");
      MockThrowable mockThrowable1 = new MockThrowable("", mockThrowable0);
      Class<String> class0 = String.class;
      int int0 = ExceptionUtils.indexOfType((Throwable) mockThrowable1, (Class<?>) class0);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("");
      Class<String> class0 = String.class;
      int int0 = ExceptionUtils.indexOfType((Throwable) mockThrowable0, (Class<?>) class0, 1);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable((String) null);
      MockThrowable mockThrowable1 = new MockThrowable((String) null, mockThrowable0);
      MockThrowable mockThrowable2 = new MockThrowable(mockThrowable1);
      String string0 = ExceptionUtils.getRootCauseMessage(mockThrowable2);
      assertEquals("MockThrowable: ", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("D");
      Class<Throwable> class0 = Throwable.class;
      int int0 = ExceptionUtils.indexOfType((Throwable) mockThrowable0, (Class<?>) class0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      Class<MockThrowable> class0 = MockThrowable.class;
      int int0 = ExceptionUtils.indexOfThrowable((Throwable) mockThrowable0, (Class<?>) class0, (-1));
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("");
      Throwable[] throwableArray0 = ExceptionUtils.getThrowables(mockThrowable0);
      assertEquals(1, throwableArray0.length);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("");
      int int0 = ExceptionUtils.getThrowableCount(mockThrowable0);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      String[] stringArray0 = ExceptionUtils.getStackFrames("");
      assertEquals(0, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      List<String> list0 = ExceptionUtils.getStackFrameList((Throwable) null);
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable(" in an array of ");
      StackTraceElement[] stackTraceElementArray0 = new StackTraceElement[4];
      StackTraceElement stackTraceElement0 = new StackTraceElement("tzS-GT4K8T3", "OpenBSD", "OpenBSD", 1902);
      stackTraceElementArray0[0] = stackTraceElement0;
      stackTraceElementArray0[1] = stackTraceElement0;
      StackTraceElement stackTraceElement1 = new StackTraceElement("at", "tzS-GT4K8T3", "tzS-GT4K8T3", (-1));
      stackTraceElementArray0[2] = stackTraceElement1;
      stackTraceElementArray0[3] = stackTraceElementArray0[1];
      mockThrowable0.setStackTrace(stackTraceElementArray0);
      List<String> list0 = ExceptionUtils.getStackFrameList(mockThrowable0);
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("D");
      MockThrowable mockThrowable1 = new MockThrowable("D", mockThrowable0);
      Throwable throwable0 = ExceptionUtils.getCause((Throwable) mockThrowable1);
      assertNotSame(throwable0, mockThrowable1);
      assertNotNull(throwable0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      LinkedList<String> linkedList0 = new LinkedList<String>();
      linkedList0.add((String) null);
      // Undeclared exception!
      try { 
        ExceptionUtils.removeCommonFrames(linkedList0, linkedList0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("getRootCause");
      mockThrowable0.setOriginForDelegate((StackTraceElement) null);
      // Undeclared exception!
      try { 
        ExceptionUtils.getStackTrace(mockThrowable0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      // Undeclared exception!
      try { 
        ExceptionUtils.getStackFrames((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable((Throwable) null);
      mockThrowable0.setOriginForDelegate((StackTraceElement) null);
      // Undeclared exception!
      try { 
        ExceptionUtils.getStackFrameList(mockThrowable0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("tzS-G?4K8JT3");
      mockThrowable0.setOriginForDelegate((StackTraceElement) null);
      // Undeclared exception!
      try { 
        ExceptionUtils.getRootCauseStackTrace(mockThrowable0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("D");
      String string0 = ExceptionUtils.getMessage(mockThrowable0);
      assertEquals("MockThrowable: D", string0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      String string0 = ExceptionUtils.getMessage((Throwable) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      String[] stringArray0 = ExceptionUtils.getStackFrames(" in an array of ");
      assertEquals(1, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("tzS-G?4K8JT3");
      MockThrowable mockThrowable1 = new MockThrowable("tzS-G?4K8JT3", mockThrowable0);
      mockThrowable0.initCause(mockThrowable1);
      String[] stringArray0 = ExceptionUtils.getRootCauseStackTrace(mockThrowable0);
      assertEquals(2, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      MockPrintStream mockPrintStream0 = new MockPrintStream("sun.reflect.GeneratedConstructorAccessor40.newInstance(Unknown Source)\n<evosuite>.<evosuite>(<evosuite>)\n<evosuite>.<evosuite>(<evosuite>)\n<evosuite>.<evosuite>(<evosuite>)\n<evosuite>.<evosuite>(<evosuite>)\n<evosuite>.<evosuite>(<evosuite>)\n");
      ExceptionUtils.printRootCauseStackTrace((Throwable) mockThrowable0, (PrintStream) mockPrintStream0);
      assertNull(mockThrowable0.getMessage());
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("tzS-G?4K8JT3");
      MockThrowable mockThrowable1 = new MockThrowable("tzS-G?4K8JT3", mockThrowable0);
      mockThrowable0.initCause(mockThrowable1);
      List<Throwable> list0 = ExceptionUtils.getThrowableList(mockThrowable0);
      assertEquals(2, list0.size());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable((Throwable) null);
      List<Throwable> list0 = ExceptionUtils.getThrowableList(mockThrowable0);
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      List<Throwable> list0 = ExceptionUtils.getThrowableList((Throwable) null);
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("", (Throwable) null);
      Throwable throwable0 = ExceptionUtils.getRootCause(mockThrowable0);
      assertNull(throwable0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      MockThrowable mockThrowable1 = new MockThrowable(mockThrowable0);
      Throwable throwable0 = ExceptionUtils.getCause((Throwable) mockThrowable1, (String[]) null);
      assertNotNull(throwable0);
      assertEquals("org.evosuite.runtime.mock.java.lang.MockThrowable", throwable0.toString());
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      String[] stringArray0 = new String[0];
      Throwable throwable0 = ExceptionUtils.getCause((Throwable) null, stringArray0);
      assertNull(throwable0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("getRootCause");
      String string0 = ExceptionUtils.getStackTrace(mockThrowable0);
      //  // Unstable assertion: assertEquals("sun.reflect.GeneratedConstructorAccessor38.newInstance(Unknown Source)\n<evosuite>.<evosuite>(<evosuite>)\n<evosuite>.<evosuite>(<evosuite>)\n<evosuite>.<evosuite>(<evosuite>)\n<evosuite>.<evosuite>(<evosuite>)\n<evosuite>.<evosuite>(<evosuite>)\n", string0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Throwable[] throwableArray0 = ExceptionUtils.getThrowables((Throwable) null);
      assertEquals(0, throwableArray0.length);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      MockThrowable mockThrowable1 = new MockThrowable(mockThrowable0);
      String string0 = ExceptionUtils.getRootCauseMessage(mockThrowable1);
      assertEquals("MockThrowable: ", string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      String string0 = ExceptionUtils.getRootCauseMessage((Throwable) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      String[] stringArray0 = ExceptionUtils.getStackFrames((Throwable) null);
      assertEquals(0, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("tzS-G?4K8JT3");
      String[] stringArray0 = ExceptionUtils.getStackFrames(mockThrowable0);
      assertEquals(6, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      LinkedList<String> linkedList0 = new LinkedList<String>();
      linkedList0.addLast("getRootCause");
      LinkedList<String> linkedList1 = new LinkedList<String>();
      linkedList1.add("tzS-G?4K8JT3");
      ExceptionUtils.removeCommonFrames(linkedList0, linkedList1);
      assertEquals(1, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      // Undeclared exception!
      try { 
        ExceptionUtils.removeCommonFrames((List<String>) null, (List<String>) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The List must not be null
         //
         verifyException("org.apache.commons.lang3.exception.ExceptionUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable(" in an array of ");
      StackTraceElement[] stackTraceElementArray0 = new StackTraceElement[4];
      StackTraceElement stackTraceElement0 = new StackTraceElement("tzS-GT4K8T3", "OpenBSD", "OpenBSD", 1902);
      stackTraceElementArray0[0] = stackTraceElement0;
      stackTraceElementArray0[1] = stackTraceElement0;
      StackTraceElement stackTraceElement1 = new StackTraceElement("at", "tzS-GT4K8T3", "tzS-GT4K8T3", (-1));
      stackTraceElementArray0[2] = stackTraceElement1;
      stackTraceElementArray0[3] = stackTraceElement0;
      mockThrowable0.setStackTrace(stackTraceElementArray0);
      String[] stringArray0 = ExceptionUtils.getRootCauseStackTrace(mockThrowable0);
      assertEquals(2, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      String[] stringArray0 = ExceptionUtils.getRootCauseStackTrace((Throwable) null);
      assertEquals(0, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable((Throwable) null);
      // Undeclared exception!
      try { 
        ExceptionUtils.printRootCauseStackTrace((Throwable) mockThrowable0, (PrintWriter) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The PrintWriter must not be null
         //
         verifyException("org.apache.commons.lang3.exception.ExceptionUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      ExceptionUtils.printRootCauseStackTrace((Throwable) null, (PrintWriter) null);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("Ghm>S");
      MockPrintWriter mockPrintWriter0 = new MockPrintWriter("java.clhss.pdt`");
      ExceptionUtils.printRootCauseStackTrace((Throwable) mockThrowable0, (PrintWriter) mockPrintWriter0);
      assertEquals("Ghm>S", mockThrowable0.getMessage());
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("Ghm>S");
      // Undeclared exception!
      try { 
        ExceptionUtils.printRootCauseStackTrace((Throwable) mockThrowable0, (PrintStream) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The PrintStream must not be null
         //
         verifyException("org.apache.commons.lang3.exception.ExceptionUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      MockPrintStream mockPrintStream0 = new MockPrintStream("Solaris");
      ExceptionUtils.printRootCauseStackTrace((Throwable) null, (PrintStream) mockPrintStream0);
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      Class<MockThrowable> class0 = MockThrowable.class;
      int int0 = ExceptionUtils.indexOfThrowable((Throwable) mockThrowable0, (Class<?>) class0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable((String) null);
      Class<Object> class0 = Object.class;
      int int0 = ExceptionUtils.indexOfType((Throwable) mockThrowable0, (Class<?>) class0, (-1));
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("");
      int int0 = ExceptionUtils.indexOfThrowable((Throwable) mockThrowable0, (Class<?>) null);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("");
      MockThrowable mockThrowable1 = new MockThrowable("", mockThrowable0);
      mockThrowable0.initCause(mockThrowable1);
      Class<String> class0 = String.class;
      int int0 = ExceptionUtils.indexOfThrowable((Throwable) mockThrowable0, (Class<?>) class0);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable(" in an array of ");
      String string0 = ExceptionUtils.getRootCauseMessage(mockThrowable0);
      assertEquals("MockThrowable:  in an array of ", string0);
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      MockThrowable mockThrowable1 = new MockThrowable(mockThrowable0);
      Throwable throwable0 = ExceptionUtils.getRootCause(mockThrowable1);
      assertNotNull(throwable0);
      assertEquals("org.evosuite.runtime.mock.java.lang.MockThrowable", throwable0.toString());
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("tzS-G?4K8JT3");
      MockThrowable mockThrowable1 = new MockThrowable("tzS-G?4K8JT3", mockThrowable0);
      ExceptionUtils.printRootCauseStackTrace((Throwable) mockThrowable1);
      assertEquals("tzS-G?4K8JT3", mockThrowable1.getMessage());
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable();
      String[] stringArray0 = new String[1];
      Throwable throwable0 = ExceptionUtils.getCause((Throwable) mockThrowable0, stringArray0);
      assertNull(throwable0);
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable(" in an array of ");
      Throwable throwable0 = ExceptionUtils.getCause((Throwable) mockThrowable0, (String[]) null);
      assertNull(throwable0);
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      ExceptionUtils exceptionUtils0 = new ExceptionUtils();
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      String[] stringArray0 = ExceptionUtils.getDefaultCauseMethodNames();
      assertEquals(12, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      Class<Integer> class0 = Integer.class;
      int int0 = ExceptionUtils.indexOfType((Throwable) null, class0);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test57()  throws Throwable  {
      MockThrowable mockThrowable0 = new MockThrowable("tzS-G?4K8JT3");
      Class<Throwable> class0 = Throwable.class;
      int int0 = ExceptionUtils.indexOfThrowable((Throwable) mockThrowable0, (Class<?>) class0, 98);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test58()  throws Throwable  {
      int int0 = ExceptionUtils.getThrowableCount((Throwable) null);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test59()  throws Throwable  {
      Throwable throwable0 = ExceptionUtils.getCause((Throwable) null);
      assertNull(throwable0);
  }
}
