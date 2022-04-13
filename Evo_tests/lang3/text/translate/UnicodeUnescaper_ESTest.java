/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 13:45:44 GMT 2022
 */

package org.apache.commons.lang3.text.translate;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.CharBuffer;
import org.apache.commons.lang3.text.translate.UnicodeUnescaper;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UnicodeUnescaper_ESTest extends UnicodeUnescaper_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      char[] charArray0 = new char[4];
      charArray0[1] = '\\';
      charArray0[2] = 'u';
      charArray0[3] = '\\';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      // Undeclared exception!
      try { 
        unicodeUnescaper0.translate((CharSequence) charBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Less than 4 hex digits in unicode value: '\\u\\' due to end of CharSequence
         //
         verifyException("org.apache.commons.lang3.text.translate.UnicodeUnescaper", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      char[] charArray0 = new char[5];
      charArray0[2] = '\\';
      charArray0[3] = '|';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      String string0 = unicodeUnescaper0.translate((CharSequence) charBuffer0);
      assertEquals("\u0000\u0000\\|\u0000", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      StringWriter stringWriter0 = new StringWriter();
      char[] charArray0 = new char[3];
      charArray0[0] = 'h';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      int int0 = unicodeUnescaper0.translate((CharSequence) charBuffer0, 0, (Writer) stringWriter0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      StringWriter stringWriter0 = new StringWriter();
      // Undeclared exception!
      try { 
        unicodeUnescaper0.translate((CharSequence) "41D", 1053, (Writer) stringWriter0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      StringWriter stringWriter0 = new StringWriter();
      // Undeclared exception!
      try { 
        unicodeUnescaper0.translate((CharSequence) null, 0, (Writer) stringWriter0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.text.translate.UnicodeUnescaper", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      char[] charArray0 = new char[4];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      // Undeclared exception!
      try { 
        unicodeUnescaper0.translate((CharSequence) charBuffer0, 287, (Writer) null);
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.Buffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      char[] charArray0 = new char[8];
      charArray0[2] = '\\';
      charArray0[3] = 'u';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      StringWriter stringWriter0 = new StringWriter(16);
      // Undeclared exception!
      try { 
        unicodeUnescaper0.translate((CharSequence) charBuffer0, 2, (Writer) stringWriter0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Unable to parse unicode value: \u0000\u0000\u0000\u0000
         //
         verifyException("org.apache.commons.lang3.text.translate.UnicodeUnescaper", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      char[] charArray0 = new char[4];
      charArray0[1] = '\\';
      charArray0[2] = 'u';
      charArray0[3] = 'u';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      StringWriter stringWriter0 = new StringWriter();
      // Undeclared exception!
      try { 
        unicodeUnescaper0.translate((CharSequence) charBuffer0, 1, (Writer) stringWriter0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Less than 4 hex digits in unicode value: '\\uu' due to end of CharSequence
         //
         verifyException("org.apache.commons.lang3.text.translate.UnicodeUnescaper", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      char[] charArray0 = new char[4];
      charArray0[2] = '\\';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      StringWriter stringWriter0 = new StringWriter(92);
      int int0 = unicodeUnescaper0.translate((CharSequence) charBuffer0, 2, (Writer) stringWriter0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      char[] charArray0 = new char[5];
      charArray0[4] = '\\';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      StringWriter stringWriter0 = new StringWriter(92);
      int int0 = unicodeUnescaper0.translate((CharSequence) charBuffer0, 4, (Writer) stringWriter0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      UnicodeUnescaper unicodeUnescaper0 = new UnicodeUnescaper();
      char[] charArray0 = new char[10];
      charArray0[1] = '\\';
      charArray0[2] = 'u';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      // Undeclared exception!
      try { 
        unicodeUnescaper0.translate((CharSequence) charBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Unable to parse unicode value: \u0000\u0000\u0000\u0000
         //
         verifyException("org.apache.commons.lang3.text.translate.UnicodeUnescaper", e);
      }
  }
}
