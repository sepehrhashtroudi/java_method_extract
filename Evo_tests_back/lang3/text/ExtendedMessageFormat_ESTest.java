/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 04:12:52 GMT 2021
 */

package org.apache.commons.lang3.text;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.commons.lang3.text.FormatFactory;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ExtendedMessageFormat_ESTest extends ExtendedMessageFormat_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Locale locale0 = Locale.FRANCE;
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat("=]g['ea2G3je{~.,j@", locale0, hashMap0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Invalid format argument index at position 13: ~
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Locale locale0 = Locale.KOREA;
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat("+{$TW<i#4sV~A5M68", locale0, hashMap0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Invalid format argument index at position 2: $
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("", hashMap0);
      String string0 = extendedMessageFormat0.toPattern();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("");
      // Undeclared exception!
      try { 
        extendedMessageFormat0.applyPattern((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Locale locale0 = new Locale("db2gu)Wdy|", "db2gu)Wdy|");
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("4\u0007SV.fi>[j3<MR0", locale0, hashMap0);
      // Undeclared exception!
      try { 
        extendedMessageFormat0.applyPattern("&{db/@IsJ3L");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Invalid format argument index at position 2: d
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Locale locale0 = Locale.ENGLISH;
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("@=^AN`J?nWy:O{4}", locale0, hashMap0);
      // Undeclared exception!
      try { 
        extendedMessageFormat0.applyPattern("=c{");
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat((String) null, hashMap0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Locale locale0 = Locale.GERMAN;
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat((String) null, locale0, hashMap0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Locale locale0 = Locale.KOREA;
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat("+{$TW<i#4sV~A5M68", locale0, (Map<String, ? extends FormatFactory>) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Unmatched braces in the pattern.
         //
         verifyException("java.text.MessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Locale locale0 = Locale.CHINESE;
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat("rb)57n{", locale0, hashMap0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Locale locale0 = Locale.TRADITIONAL_CHINESE;
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat((String) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Locale locale0 = Locale.JAPANESE;
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat("/DKAY{(Uv/$P<U@h|", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Unmatched braces in the pattern.
         //
         verifyException("java.text.MessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat("@w{tSu~(;*,");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Unmatched braces in the pattern.
         //
         verifyException("java.text.MessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat(":=|2,+.;gT[`kr", (Locale) null, hashMap0);
      extendedMessageFormat0.applyPattern("=YO+[0mpmH'ja");
      assertEquals("=YO+[0mpmHja", extendedMessageFormat0.toPattern());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("Cannot clone Cloneable type ", (Locale) null);
      // Undeclared exception!
      try { 
        extendedMessageFormat0.applyPattern("Wkj%zrSi{g?:_");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Unmatched braces in the pattern.
         //
         verifyException("java.text.MessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Locale locale0 = Locale.ENGLISH;
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat("@=^AN?nWy:{4", locale0, hashMap0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Unterminated format element at position 11
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("wW=pu_g4pcM6Wsuc!XP");
      Object object0 = extendedMessageFormat0.clone();
      boolean boolean0 = extendedMessageFormat0.equals(object0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("wW=pu_g4pcM6Wsuc!XP");
      NumberFormat numberFormat0 = NumberFormat.getIntegerInstance();
      boolean boolean0 = extendedMessageFormat0.equals(numberFormat0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("wW=pu_g4pcM6Wsuc!XP");
      boolean boolean0 = extendedMessageFormat0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("wW=pu_g4pcM6Wsuc!XP");
      boolean boolean0 = extendedMessageFormat0.equals(extendedMessageFormat0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("^6uX");
      ExtendedMessageFormat extendedMessageFormat1 = new ExtendedMessageFormat("^6uX", hashMap0);
      boolean boolean0 = extendedMessageFormat0.equals(extendedMessageFormat1);
      assertFalse(boolean0);
      assertEquals("^6uX", extendedMessageFormat1.toPattern());
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Locale locale0 = Locale.ENGLISH;
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("@=^AN`J?nWy:O{4}", locale0, hashMap0);
      extendedMessageFormat0.applyPattern("@=^AN`J?nWy:O{4}");
      assertEquals("@=^AN`J?nWy:O{4}", extendedMessageFormat0.toPattern());
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat("A'kM?(Pov{/D!AFl", hashMap0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Invalid format argument index at position 10: /
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Locale locale0 = Locale.SIMPLIFIED_CHINESE;
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("oWQWO8F#)>-&4Fy|<b<", locale0, hashMap0);
      NumberFormat numberFormat0 = NumberFormat.getIntegerInstance();
      // Undeclared exception!
      try { 
        extendedMessageFormat0.setFormatByArgumentIndex((-489), numberFormat0);
        fail("Expecting exception: UnsupportedOperationException");
      
      } catch(UnsupportedOperationException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Locale locale0 = Locale.CANADA_FRENCH;
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("m& mHZ;'N'wM", locale0, hashMap0);
      extendedMessageFormat0.hashCode();
      assertEquals("m& mHZ;NwM", extendedMessageFormat0.toPattern());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat(":=|2,+.;gT[`kr", (Locale) null, hashMap0);
      String string0 = extendedMessageFormat0.toPattern();
      assertEquals(":=|2,+.;gT[`kr", string0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("", hashMap0);
      // Undeclared exception!
      try { 
        extendedMessageFormat0.setFormats((Format[]) null);
        fail("Expecting exception: UnsupportedOperationException");
      
      } catch(UnsupportedOperationException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("^6uX");
      Format[] formatArray0 = new Format[5];
      // Undeclared exception!
      try { 
        extendedMessageFormat0.setFormatsByArgumentIndex(formatArray0);
        fail("Expecting exception: UnsupportedOperationException");
      
      } catch(UnsupportedOperationException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      HashMap<String, FormatFactory> hashMap0 = new HashMap<String, FormatFactory>();
      ExtendedMessageFormat extendedMessageFormat0 = new ExtendedMessageFormat("org.apache.commons.lang3.text.StrMatcher", hashMap0);
      DecimalFormat decimalFormat0 = new DecimalFormat();
      // Undeclared exception!
      try { 
        extendedMessageFormat0.setFormat(0, decimalFormat0);
        fail("Expecting exception: UnsupportedOperationException");
      
      } catch(UnsupportedOperationException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.text.ExtendedMessageFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      ExtendedMessageFormat extendedMessageFormat0 = null;
      try {
        extendedMessageFormat0 = new ExtendedMessageFormat("-^(6{mNk\"&8QJ", (Map<String, ? extends FormatFactory>) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Unmatched braces in the pattern.
         //
         verifyException("java.text.MessageFormat", e);
      }
  }
}
