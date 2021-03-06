/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 13:41:07 GMT 2022
 */

package org.apache.commons.lang3.text.translate;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.StringWriter;
import java.io.Writer;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.apache.commons.lang3.text.translate.UnicodeEscaper;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UnicodeEscaper_ESTest extends UnicodeEscaper_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      UnicodeEscaper unicodeEscaper0 = UnicodeEscaper.outsideOf(255, 0);
      StringWriter stringWriter0 = new StringWriter();
      boolean boolean0 = unicodeEscaper0.translate(255, (Writer) stringWriter0);
      assertEquals("\\u00FF", stringWriter0.toString());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      JavaUnicodeEscaper javaUnicodeEscaper0 = new JavaUnicodeEscaper(0, 2370, false);
      StringWriter stringWriter0 = new StringWriter(92);
      boolean boolean0 = javaUnicodeEscaper0.translate(4095, (Writer) stringWriter0);
      assertEquals("\\u0FFF", stringWriter0.toString());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      StringWriter stringWriter0 = new StringWriter(1332);
      UnicodeEscaper unicodeEscaper0 = UnicodeEscaper.outsideOf(65535, 1332);
      boolean boolean0 = unicodeEscaper0.translate(65535, (Writer) stringWriter0);
      assertEquals("\\uFFFF", stringWriter0.toString());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      UnicodeEscaper unicodeEscaper0 = UnicodeEscaper.below(1332);
      String string0 = unicodeEscaper0.toUtf16Escape(1332);
      assertEquals("\\u534", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      JavaUnicodeEscaper javaUnicodeEscaper0 = new JavaUnicodeEscaper((-1307), (-1620), false);
      // Undeclared exception!
      try { 
        javaUnicodeEscaper0.toUtf16Escape((-1620));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.lang.Character", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      JavaUnicodeEscaper javaUnicodeEscaper0 = JavaUnicodeEscaper.between(1, 1);
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

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      UnicodeEscaper unicodeEscaper0 = UnicodeEscaper.above(265);
      StringWriter stringWriter0 = new StringWriter();
      boolean boolean0 = unicodeEscaper0.translate(265, (Writer) stringWriter0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      UnicodeEscaper unicodeEscaper0 = new UnicodeEscaper(4095, 4095, false);
      StringWriter stringWriter0 = new StringWriter();
      boolean boolean0 = unicodeEscaper0.translate(15, (Writer) stringWriter0);
      assertEquals("\\u000F", stringWriter0.toString());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      JavaUnicodeEscaper javaUnicodeEscaper0 = new JavaUnicodeEscaper(2242, 2242, true);
      StringWriter stringWriter0 = new StringWriter();
      boolean boolean0 = javaUnicodeEscaper0.translate(2242, (Writer) stringWriter0);
      assertEquals("\\u08C2", stringWriter0.toString());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      UnicodeEscaper unicodeEscaper0 = UnicodeEscaper.between(1722, (-3368));
      StringWriter stringWriter0 = new StringWriter();
      boolean boolean0 = unicodeEscaper0.translate(1722, (Writer) stringWriter0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      UnicodeEscaper unicodeEscaper0 = UnicodeEscaper.between(1722, (-3368));
      StringWriter stringWriter0 = new StringWriter();
      boolean boolean0 = unicodeEscaper0.translate((-3368), (Writer) stringWriter0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      UnicodeEscaper unicodeEscaper0 = UnicodeEscaper.below((-6334));
      String string0 = unicodeEscaper0.translate((CharSequence) "FFFFEE34");
      assertEquals("FFFFEE34", string0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      UnicodeEscaper unicodeEscaper0 = UnicodeEscaper.between((-6334), 8);
      // Undeclared exception!
      try { 
        unicodeEscaper0.translate(0, (Writer) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.text.translate.UnicodeEscaper", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      UnicodeEscaper unicodeEscaper0 = new UnicodeEscaper();
      // Undeclared exception!
      try { 
        unicodeEscaper0.translate(Integer.MAX_VALUE, (Writer) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.text.translate.UnicodeEscaper", e);
      }
  }
}
