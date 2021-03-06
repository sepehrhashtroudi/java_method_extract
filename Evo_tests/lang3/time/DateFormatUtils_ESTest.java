/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 14:29:16 GMT 2022
 */

package org.apache.commons.lang3.time;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockCalendar;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.evosuite.runtime.mock.java.util.MockGregorianCalendar;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class DateFormatUtils_ESTest extends DateFormatUtils_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      MockDate mockDate0 = new MockDate((-1827), (-1827), (-1827));
      Locale locale0 = new Locale("'KT'HH:mm:sZZ");
      String string0 = DateFormatUtils.formatUTC((Date) mockDate0, "'KT'HH:mm:sZZ", locale0);
      assertEquals("KT00:00:0+00:00", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      String string0 = DateFormatUtils.formatUTC((Date) mockDate0, "}+)");
      assertEquals("}+)", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Locale locale0 = Locale.FRENCH;
      String string0 = DateFormatUtils.formatUTC((long) 517, "&[4@", locale0);
      assertEquals("&[4@", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      MockDate mockDate0 = new MockDate(1, 1, 1, 1, 1);
      TimeZone timeZone0 = TimeZone.getTimeZone("org.apache.commons.lang3.time.FastDateParser$TimeZoneStrategy");
      String string0 = DateFormatUtils.format((Date) mockDate0, "&3S", timeZone0, (Locale) null);
      assertEquals("&30", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      MockDate mockDate0 = new MockDate(0, 65, 65, 0, 0);
      TimeZone timeZone0 = TimeZone.getTimeZone("^mbb0}2`BN9 ");
      String string0 = DateFormatUtils.format((Date) mockDate0, "yyyy-MM-dd", timeZone0);
      assertEquals("1905-08-04", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      Locale locale0 = new Locale("HH:mm:ss", "'T'HH:mm:ssZZ");
      String string0 = DateFormatUtils.format((Date) mockDate0, "HH:mm:ss", locale0);
      assertEquals("20:21:21", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      String string0 = DateFormatUtils.format((Date) mockDate0, ":");
      assertEquals(":", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      ZoneOffset zoneOffset0 = ZoneOffset.UTC;
      TimeZone timeZone0 = TimeZone.getTimeZone((ZoneId) zoneOffset0);
      Locale locale0 = Locale.PRC;
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(timeZone0, locale0);
      String string0 = DateFormatUtils.format((Calendar) mockGregorianCalendar0, "$", timeZone0, locale0);
      assertEquals("$", string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone((-749), "1970-01-01+00:00");
      String string0 = DateFormatUtils.format(95L, "1970-01-01+00:00", (TimeZone) simpleTimeZone0);
      assertEquals("1970-01-01+00:00", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      String string0 = DateFormatUtils.format(717L, "yyyy-MM-dd'T'HH:mm:ss");
      assertEquals("1970-01-01T00:00:00", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      Locale locale0 = Locale.GERMANY;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) mockDate0, "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Locale locale0 = Locale.TRADITIONAL_CHINESE;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) null, "'T'HH:mm:ssZZ", locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      MockDate mockDate0 = new MockDate(0L);
      Locale locale0 = Locale.CHINESE;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) mockDate0, "LYpJ.", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: L
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      MockDate mockDate0 = new MockDate(39, 39, 1, 39, (-392));
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) mockDate0, "");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) null, (String) null);
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
      MockDate mockDate0 = new MockDate(0L);
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) mockDate0, "FastDateParser[");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: t
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Locale locale0 = Locale.ITALY;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((-631L), "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Locale locale0 = Locale.CANADA_FRENCH;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC(171L, (String) null, locale0);
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
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC(2244L, "");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC(0L, (String) null);
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
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((-3943L), "q");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: q
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone(0, "~2Q97");
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "yyyy-MM-dd'T'HH:mm:ssZZ", (TimeZone) simpleTimeZone0, (Locale) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      MockDate mockDate0 = new MockDate(396, 0, 0, 396, 0);
      TimeZone timeZone0 = TimeZone.getDefault();
      Locale locale0 = Locale.GERMANY;
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
  public void test23()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      Locale locale0 = new Locale("HH:mm:ss", "'T'HH:mm:ssZZ");
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "org.apache.commons.lang3.time.FastDateParser$TimeZoneStrategy", timeZone0, locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: o
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone((-749), "1970-01-01+00:00");
      MockDate mockDate0 = new MockDate(0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "", (TimeZone) simpleTimeZone0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getTimeZone("");
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "EEE, dd MMM yyyy HH:mm:ss Z", timeZone0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      MockDate mockDate0 = new MockDate(0L);
      TimeZone timeZone0 = TimeZone.getTimeZone("(p{IsNd}++)");
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
  public void test27()  throws Throwable  {
      MockDate mockDate0 = new MockDate(2829, 2338, 2338);
      Locale locale0 = Locale.TAIWAN;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      MockDate mockDate0 = new MockDate(43, 12, 0);
      Locale locale0 = Locale.ROOT;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, (String) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Locale locale0 = Locale.US;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "(GMT[+-]d{0,1}d{2}|[+-]d{2}:?d{2}|", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: T
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, 0, 0, 0, 0, 60);
      Date date0 = mockGregorianCalendar0.getGregorianChange();
      // Undeclared exception!
      try { 
        DateFormatUtils.format(date0, "");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "9\"MG-+%%6");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(9, (-2414), 9);
      Date date0 = mockGregorianCalendar0.getGregorianChange();
      // Undeclared exception!
      try { 
        DateFormatUtils.format(date0, "org.apache.commons.lang3.time.FastDatePrinter$PaddedNumberField");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: o
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      ZoneOffset zoneOffset0 = ZoneOffset.UTC;
      TimeZone timeZone0 = TimeZone.getTimeZone((ZoneId) zoneOffset0);
      Locale locale0 = Locale.PRC;
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(timeZone0, locale0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, "", timeZone0, locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-1), 711, (-949), (-949), 0);
      Locale locale0 = Locale.UK;
      mockGregorianCalendar0.setTimeZone((TimeZone) null);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, "yyyy-MM-ddZZ", (TimeZone) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.GregorianCalendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getTimeZone("");
      Calendar calendar0 = MockCalendar.getInstance(timeZone0);
      Locale locale0 = Locale.UK;
      // Undeclared exception!
      try { 
        DateFormatUtils.format(calendar0, "DPogq4{>{3l", timeZone0, locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: P
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Calendar calendar0 = MockCalendar.getInstance();
      // Undeclared exception!
      try { 
        DateFormatUtils.format(calendar0, "", (TimeZone) null);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      ZoneOffset zoneOffset0 = ZoneOffset.ofTotalSeconds(1);
      TimeZone timeZone0 = TimeZone.getTimeZone((ZoneId) zoneOffset0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "yyyy-MM-ddZZ", timeZone0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter$PaddedNumberField", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getDefault();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(timeZone0);
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
  public void test39()  throws Throwable  {
      Locale locale0 = new Locale("1970-01-01T00:00:00", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss");
      Calendar calendar0 = MockCalendar.getInstance(locale0);
      TimeZone timeZone0 = TimeZone.getTimeZone("1970-01-01T00:00:00");
      // Undeclared exception!
      try { 
        DateFormatUtils.format(calendar0, "1970-01-01T00:00:00", timeZone0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: T
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      Locale locale0 = Locale.ITALIAN;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "HH:mm:ss", (Locale) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter$TwoDigitNumberField", e);
      }
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      Locale locale0 = Locale.FRENCH;
      Calendar calendar0 = MockCalendar.getInstance(locale0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format(calendar0, (String) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Calendar calendar0 = MockCalendar.getInstance();
      Locale locale0 = Locale.PRC;
      // Undeclared exception!
      try { 
        DateFormatUtils.format(calendar0, "org.apache.commons.lang3.time.DateFormatUtils", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: o
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone(1830, "");
      Calendar calendar0 = MockCalendar.getInstance((TimeZone) simpleTimeZone0);
      // Undeclared exception!
      try { 
        DateFormatUtils.format(calendar0, "");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "yyyy-MM-dd");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter$PaddedNumberField", e);
      }
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, (String) null);
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
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(501, 501, 501);
      mockGregorianCalendar0.setLenient(false);
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) mockGregorianCalendar0, "&[F@");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // MONTH
         //
         verifyException("java.util.GregorianCalendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Calendar) null, "A$Pc56r2@'UA");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: A
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone(1, "");
      Locale locale0 = Locale.CHINA;
      // Undeclared exception!
      try { 
        DateFormatUtils.format(1908L, "", (TimeZone) simpleTimeZone0, locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      Locale locale0 = Locale.FRANCE;
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((-709L), (String) null, timeZone0, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      Locale locale0 = new Locale("GMT", "ad5>je,.y%C", "GMT");
      // Undeclared exception!
      try { 
        DateFormatUtils.format((-394L), "GMT", (TimeZone) null, locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: T
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format(1760L, (String) null, (TimeZone) null);
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
      TimeZone timeZone0 = TimeZone.getTimeZone("YH+>1OHIEg~");
      // Undeclared exception!
      try { 
        DateFormatUtils.format(15L, "YH+>1OHIEg~", timeZone0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: Y
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      Locale locale0 = Locale.FRANCE;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((-111L), "", locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      Locale locale0 = Locale.FRANCE;
      // Undeclared exception!
      try { 
        DateFormatUtils.format((-709L), (String) null, locale0);
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
      // Undeclared exception!
      try { 
        DateFormatUtils.format(0L, "y_bMzK%rNA$XsKX2", (Locale) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: b
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
        DateFormatUtils.format(1929L, (String) null);
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
      Locale locale0 = Locale.ROOT;
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "", timeZone0, locale0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test60()  throws Throwable  {
      Locale locale0 = Locale.CHINA;
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(locale0);
      ZoneOffset zoneOffset0 = ZoneOffset.ofHours(0);
      TimeZone timeZone0 = TimeZone.getTimeZone((ZoneId) zoneOffset0);
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
  public void test61()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(517, 517, 517, 517, 517, 517);
      String string0 = DateFormatUtils.format((Calendar) mockGregorianCalendar0, "&[F@");
      assertEquals("&[4@", string0);
  }

  @Test(timeout = 4000)
  public void test62()  throws Throwable  {
      Locale locale0 = Locale.GERMANY;
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC(1L, "T00:00:02+00:00", locale0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: T
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test63()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, "]", (Locale) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test64()  throws Throwable  {
      DateFormatUtils dateFormatUtils0 = new DateFormatUtils();
  }

  @Test(timeout = 4000)
  public void test65()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format(1190L, "", (TimeZone) null);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test66()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      Locale locale0 = Locale.US;
      String string0 = DateFormatUtils.format((Calendar) mockGregorianCalendar0, ":", locale0);
      assertEquals(":", string0);
  }

  @Test(timeout = 4000)
  public void test67()  throws Throwable  {
      MockDate mockDate0 = new MockDate();
      TimeZone timeZone0 = TimeZone.getDefault();
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) mockDate0, "yyyMM'ddZZ", timeZone0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Failed to parse \"yyyMM'ddZZ\" ; gave up at index 5
         //
         verifyException("org.apache.commons.lang3.time.FastDateParser", e);
      }
  }

  @Test(timeout = 4000)
  public void test68()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.format((long) 305, "mcfe3bz_{s");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal pattern component: c
         //
         verifyException("org.apache.commons.lang3.time.FastDatePrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test69()  throws Throwable  {
      Locale locale0 = new Locale("'KT'HH:mm:sZZ");
      String string0 = DateFormatUtils.format((long) (-1827), "'KT'HH:mm:sZZ", locale0);
      assertEquals("KT23:59:58+00:00", string0);
  }

  @Test(timeout = 4000)
  public void test70()  throws Throwable  {
      Locale locale0 = Locale.US;
      ZoneId zoneId0 = ZoneId.systemDefault();
      TimeZone timeZone0 = TimeZone.getTimeZone(zoneId0);
      String string0 = DateFormatUtils.format(1885L, ":", timeZone0, locale0);
      assertEquals(":", string0);
  }

  @Test(timeout = 4000)
  public void test71()  throws Throwable  {
      String string0 = DateFormatUtils.formatUTC((long) (-1827), "'KT'HH:mm:sZZ");
      assertEquals("KT23:59:58+00:00", string0);
  }

  @Test(timeout = 4000)
  public void test72()  throws Throwable  {
      Locale locale0 = Locale.ROOT;
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      Date date0 = mockGregorianCalendar0.getGregorianChange();
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC(date0, (String) null, locale0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test73()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateFormatUtils.formatUTC((Date) null, "3");
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
      // Undeclared exception!
      try { 
        DateFormatUtils.format((Date) null, (String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // pattern must not be null
         //
         verifyException("org.apache.commons.lang3.time.FormatCache", e);
      }
  }

  @Test(timeout = 4000)
  public void test75()  throws Throwable  {
      TimeZone timeZone0 = TimeZone.getDefault();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      String string0 = DateFormatUtils.format((Calendar) mockGregorianCalendar0, "m/39", timeZone0);
      assertEquals("21/39", string0);
  }
}
