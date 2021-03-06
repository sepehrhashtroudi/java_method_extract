/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 03:43:26 GMT 2021
 */

package org.apache.commons.lang3.time;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockZonedDateTime;
import org.evosuite.runtime.mock.java.util.MockCalendar;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.evosuite.runtime.mock.java.util.MockGregorianCalendar;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class DateFormatUtils_ESTest extends DateFormatUtils_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      Locale locale0 = Locale.TAIWAN;
      String string0 = DateFormatUtils.formatUTC((Date) mockDate0, "^", locale0);
      assertEquals("^", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      String string0 = DateFormatUtils.formatUTC(0L, ".");
      assertEquals(".", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      MockDate mockDate0 = new MockDate((-583), 1346, 1346);
      TimeZone timeZone0 = TimeZone.getTimeZone("JcZ<'3eIot");
      Locale locale0 = Locale.JAPAN;
      String string0 = DateFormatUtils.format((Date) mockDate0, "'T'HH:mm:ss", timeZone0, locale0);
      assertEquals("T00:00:00", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      MockDate mockDate0 = new MockDate(0, 12, 0, 12, 0);
      Locale locale0 = Locale.ITALY;
      String string0 = DateFormatUtils.format((Date) mockDate0, "yyyy-MM-dd", locale0);
      assertEquals("1900-12-31", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      LinkedList<Locale.LanguageRange> linkedList0 = new LinkedList<Locale.LanguageRange>();
      LinkedList<Locale> linkedList1 = new LinkedList<Locale>();
      Locale locale0 = Locale.lookup(linkedList0, linkedList1);
      String string0 = DateFormatUtils.format((Calendar) null, ".", (TimeZone) null, locale0);
      assertEquals(".", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      String string0 = DateFormatUtils.format((Calendar) mockGregorianCalendar0, "F", (TimeZone) null);
      assertEquals("2", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MockDate mockDate0 = new MockDate(0L);
      Locale locale0 = Locale.ITALY;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) mockDate0, "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      MockDate mockDate0 = new MockDate(8, 8, 8, 0, 8);
      Locale locale0 = Locale.UK;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) mockDate0, (String) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Locale locale0 = Locale.CHINA;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) null, "SRP#1$3`I", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: R
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) null, "");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) null, "1");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      MockDate mockDate0 = new MockDate((-860), (-4294), 32);
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) mockDate0, (String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) null, "JP");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: J
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Locale locale0 = Locale.JAPANESE;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC(2367L, "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Locale locale0 = Locale.CHINA;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((-853L), (String) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Locale locale0 = Locale.ITALY;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC(1L, "ctYo~VWw6W,ib]T=Lqh", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: c
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC(1L, "");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((-1L), (String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone(3695, "");
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "", (TimeZone) simpleTimeZone0, (Locale) null);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Locale locale0 = Locale.TAIWAN;
      MockDate mockDate0 = new MockDate((-1), (-1), (-1), (-1), 650);
      TimeZone timeZone0 = TimeZone.getTimeZone("1969-12-31");
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, (String) null, timeZone0, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Locale locale0 = Locale.KOREA;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "org.apache.commons.lang3.time.FastDatePrinter$StringLiteral", (TimeZone) null, locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: o
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      MockDate mockDate0 = new MockDate(1980, 1980, 1980);
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone((-2300), "yyyy-MM-dd");
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "", (TimeZone) simpleTimeZone0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      ZoneOffset zoneOffset0 = ZoneOffset.ofTotalSeconds(0);
      TimeZone timeZone0 = TimeZone.getTimeZone((ZoneId) zoneOffset0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "HH:mm:ssZZ", timeZone0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, (String) null, timeZone0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      MockDate mockDate0 = new MockDate(0, 1, 0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "xSv3\"*l+ii4:", (TimeZone) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: x
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      Locale locale0 = new Locale("", "", "oF(/=9%] 9=#|rzB*");
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Locale locale0 = Locale.CHINESE;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, (String) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      MockDate mockDate0 = new MockDate((-1), 0, (-3246));
      Locale locale0 = Locale.CANADA_FRENCH;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "org.apache.commons.lang3.time.FastDatePrinter", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: o
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "s!z.S>`m");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MockDate mockDate0 = new MockDate((-3003), (-3003), (-3003));
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, (String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "ujTk@PkPMCF6^x;|n\"");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: u
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Locale locale0 = Locale.ROOT;
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(locale0);
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, "", timeZone0, locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "yyyy-MM-dd'T'HH:mm:ss", timeZone0, (Locale) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter$PaddedNumberField", e);
      }
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Locale locale0 = Locale.UK;
      Calendar calendar0 = MockCalendar.getInstance(locale0);
      TimeZone timeZone0 = TimeZone.getTimeZone("yyyy-MM-ddZZ");
      // Undeclared exception!
      try { 
        DateFormatUtils.format(calendar0, "t", timeZone0, locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: t
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "'T'HH:mm:ssZZ", (TimeZone) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter$TwoDigitNumberField", e);
      }
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, (String) null, timeZone0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      mockGregorianCalendar0.set(0, 996);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, "F", (TimeZone) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Invalid era
         //
         verifyException("java.util.GregorianCalendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getTimeZone("\" ; gave up at index ");
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "\" ; gave up at index ", timeZone0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: g
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(3087, 3087, 3087);
      Locale locale0 = Locale.KOREA;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      ZoneOffset zoneOffset0 = ZoneOffset.MIN;
      ZonedDateTime zonedDateTime0 = MockZonedDateTime.now((ZoneId) zoneOffset0);
      GregorianCalendar gregorianCalendar0 = MockGregorianCalendar.from(zonedDateTime0);
      gregorianCalendar0.setTimeZone((TimeZone) null);
      Locale locale0 = Locale.TRADITIONAL_CHINESE;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) gregorianCalendar0, "F", locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, (String) null, (Locale) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      ZonedDateTime zonedDateTime0 = MockZonedDateTime.now();
      GregorianCalendar gregorianCalendar0 = MockGregorianCalendar.from(zonedDateTime0);
      gregorianCalendar0.set(0, 4156);
      Locale locale0 = Locale.CHINESE;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) gregorianCalendar0, "F", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Invalid era
         //
         verifyException("java.util.GregorianCalendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Locale locale0 = Locale.JAPAN;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "T00:00:00", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: T
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      Locale locale0 = Locale.forLanguageTag("");
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(locale0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, "");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "a");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter$TextField", e);
      }
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getTimeZone("8g_v=h");
      Locale locale0 = Locale.ENGLISH;
      Calendar calendar0 = MockCalendar.getInstance(timeZone0, locale0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format(calendar0, (String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "j;lm");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: j
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      Locale locale0 = new Locale("'T'HH:mm:ssZZ");
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format(0L, "", timeZone0, locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone(976, "yyyy-MM-ddZZ");
      // Undeclared exception!
      try { 
        DateFormatUtils.format(677L, (String) null, (TimeZone) simpleTimeZone0, (Locale) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getDefault();
      Locale locale0 = Locale.TRADITIONAL_CHINESE;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((-2976L), "a|*t(`ok'", timeZone0, locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: t
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((-891L), "", timeZone0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getTimeZone("");
      // Undeclared exception!
      try { 
        DateFormatUtils.format((-1615L), (String) null, timeZone0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format(0L, "org.apache.commons.lang3.time.DateFormatUtils", timeZone0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: o
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      Locale locale0 = Locale.GERMANY;
      // Undeclared exception!
      try { 
        DateFormatUtils.format(0L, "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      Locale locale0 = Locale.CANADA_FRENCH;
      // Undeclared exception!
      try { 
        DateFormatUtils.format(3954L, (String) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      Locale locale0 = Locale.PRC;
      // Undeclared exception!
      try { 
        DateFormatUtils.format(0L, "n/Dl\"bYB", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: n
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test57()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format(0L, "");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test58()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((-704L), (String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test59()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format(0L, "yMSr3`3S?SaP:");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: r
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test60()  throws Throwable  {
      Locale locale0 = Locale.US;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "yyyy-MM-dd", (TimeZone) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test61()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, 69, (-1), 0, 0);
      TimeZone timeZone0 = TimeZone.getDefault();
      Locale locale0 = Locale.GERMANY;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, (String) null, timeZone0, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test62()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      String string0 = DateFormatUtils.format((Calendar) mockGregorianCalendar0, "2");
      assertEquals("2", string0);
  }

  @Test(timeout = 4000)
  public void test63()  throws Throwable  {
      String string0 = DateFormatUtils.formatUTC(0L, "$", (Locale) null);
      assertEquals("$", string0);
  }

  @Test(timeout = 4000)
  public void test64()  throws Throwable  {
      Locale locale0 = Locale.UK;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, ",", locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test65()  throws Throwable  {
      DateFormatUtils dateFormatUtils0 = new DateFormatUtils();
  }

  @Test(timeout = 4000)
  public void test66()  throws Throwable  {
      String string0 = DateFormatUtils.format(0L, ".", (TimeZone) null);
      assertEquals(".", string0);
  }

  @Test(timeout = 4000)
  public void test67()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      Locale locale0 = Locale.ROOT;
      String string0 = DateFormatUtils.format((Calendar) mockGregorianCalendar0, "F", locale0);
      assertEquals("2", string0);
  }

  @Test(timeout = 4000)
  public void test68()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      String string0 = DateFormatUtils.format((Date) mockDate0, "F", (TimeZone) null);
      assertEquals("2", string0);
  }

  @Test(timeout = 4000)
  public void test69()  throws Throwable  {
      String string0 = DateFormatUtils.format(0L, ".");
      assertEquals(".", string0);
  }

  @Test(timeout = 4000)
  public void test70()  throws Throwable  {
      Locale locale0 = new Locale("HH:mm:ssZZ");
      String string0 = DateFormatUtils.format((long) (-58), "HH:mm:ssZZ", locale0);
      assertEquals("23:59:59+00:00", string0);
  }

  @Test(timeout = 4000)
  public void test71()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getTimeZone("EEE, dd MMM yyyy HH:mm:ss Z");
      Locale locale0 = Locale.PRC;
      String string0 = DateFormatUtils.format(1L, "EEE, dd MMM yyyy HH:mm:ss Z", timeZone0, locale0);
      assertEquals("\u661F\u671F\u56DB, 01 \u4E00\u6708 1970 00:00:00 +0000", string0);
  }

  @Test(timeout = 4000)
  public void test72()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((long) (-801), "1029-12-17T1:25:39+00:00");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: T
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test73()  throws Throwable  {
      Locale locale0 = Locale.ENGLISH;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) null, "Fs##*&w3/|``)", locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test74()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      String string0 = DateFormatUtils.formatUTC((Date) mockDate0, "F");
      assertEquals("2", string0);
  }

  @Test(timeout = 4000)
  public void test75()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      String string0 = DateFormatUtils.format((Date) mockDate0, "2");
      assertEquals("2", string0);
  }

  @Test(timeout = 4000)
  public void test76()  throws Throwable  {
      Locale locale0 = new Locale("");
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(locale0);
      ZoneOffset zoneOffset0 = ZoneOffset.UTC;
      TimeZone timeZone0 = TimeZone.getTimeZone((ZoneId) zoneOffset0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, "", timeZone0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }
}
