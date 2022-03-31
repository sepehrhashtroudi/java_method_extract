/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 04:26:55 GMT 2021
 */

package org.apache.commons.lang3.text.translate;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class JavaUnicodeEscaper_ESTest extends JavaUnicodeEscaper_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      JavaUnicodeEscaper javaUnicodeEscaper0 = JavaUnicodeEscaper.between((-2857), Integer.MAX_VALUE);
      assertNotNull(javaUnicodeEscaper0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      JavaUnicodeEscaper javaUnicodeEscaper0 = JavaUnicodeEscaper.below(65543);
      String string0 = javaUnicodeEscaper0.toUtf16Escape(65543);
      assertEquals("\\uD800\\uDC07", string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      JavaUnicodeEscaper javaUnicodeEscaper0 = JavaUnicodeEscaper.outsideOf(Integer.MAX_VALUE, 2137);
      // Undeclared exception!
      try { 
        javaUnicodeEscaper0.toUtf16Escape(Integer.MAX_VALUE);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.lang.Character", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      JavaUnicodeEscaper javaUnicodeEscaper0 = new JavaUnicodeEscaper((-1326), 10, false);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      JavaUnicodeEscaper javaUnicodeEscaper0 = JavaUnicodeEscaper.above(1);
      // Undeclared exception!
      try { 
        javaUnicodeEscaper0.toUtf16Escape(1);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 1
         //
         verifyException("org.apache.commons.lang3.text.translate.JavaUnicodeEscaper", e);
      }
  }
}
