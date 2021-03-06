/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 13:25:17 GMT 2022
 */

package org.apache.commons.lang3.text;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Formattable;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.MissingFormatArgumentException;
import java.util.UnknownFormatConversionException;
import org.apache.commons.lang3.text.FormattableUtils;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.mock.java.io.MockFileOutputStream;
import org.evosuite.runtime.mock.java.io.MockPrintStream;
import org.evosuite.runtime.mock.java.io.MockPrintWriter;
import org.evosuite.runtime.testdata.EvoSuiteFile;
import org.evosuite.runtime.testdata.FileSystemHandling;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class FormattableUtils_ESTest extends FormattableUtils_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      char[] charArray0 = new char[0];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      DataOutputStream dataOutputStream0 = new DataOutputStream((OutputStream) null);
      Formatter formatter0 = new Formatter(dataOutputStream0);
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, 1041, 1041, 1041, (CharSequence) charBuffer0);
      assertSame(formatter0, formatter1);
      
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, formatter0, (-2273), 1003, (-2273), '%');
        fail("Expecting exception: UnknownFormatConversionException");
      
      } catch(UnknownFormatConversionException e) {
         //
         // Conversion = '%'
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Formattable formattable0 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      String string0 = FormattableUtils.toString(formattable0);
      assertEquals("", string0);
      
      Formatter formatter0 = new Formatter((Appendable) null);
      int int0 = 1052;
      char char0 = 'L';
      FormattableUtils.append((CharSequence) "", formatter0, 1052, 1052, 1052, 'L');
      int int1 = 0;
      Formatter formatter1 = FormattableUtils.append((CharSequence) "", formatter0, 1052, 0, 1052);
      Formattable formattable1 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable1);
      formatter1.close();
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) "", formatter1, 0, 0, 0, (CharSequence) "");
        fail("Expecting exception: FormatterClosedException");
      
      } catch(FormatterClosedException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      CharBuffer charBuffer0 = CharBuffer.allocate(1041);
      CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0);
      Formatter formatter0 = new Formatter(charBuffer0);
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, 1003, 1041, 1003, '$');
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer1, formatter1, 1036, 1003, 1036, ':', (CharSequence) charBuffer1);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Formattable formattable0 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable0);
      Formatter formatter0 = new Formatter();
      // Undeclared exception!
      FormattableUtils.append((CharSequence) "", formatter0, 1974, 32767, 1604, 'q');
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Formattable formattable0 = null;
      FormattableUtils.toString((Formattable) null);
      FormattableUtils.toString((Formattable) null);
      FileSystemHandling.shouldAllThrowIOExceptions();
      Formatter formatter0 = new Formatter((Locale) null);
      String string0 = "";
      formatter0.format((Locale) null, "", (Object[]) null);
      String string1 = "%s";
      formatter0.format("%s", (Object[]) null);
      int int0 = (-2791);
      Formatter formatter1 = FormattableUtils.append((CharSequence) "null", formatter0, 1662, (-2791), (-155));
      FormattableUtils.toString((Formattable) null);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) "%s", formatter1, 422, 1662, 2490);
        fail("Expecting exception: MissingFormatArgumentException");
      
      } catch(MissingFormatArgumentException e) {
         //
         // Format specifier '%s'
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Charset charset0 = Charset.defaultCharset();
      ByteBuffer byteBuffer0 = charset0.encode("Specified ellipsis '%1$s' exceeds precision of %2$s");
      CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
      Formatter formatter0 = new Formatter();
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, formatter0, 322, 127, 52, 'T', (CharSequence) "Specified ellipsis '%1$s' exceeds precision of %2$s");
        fail("Expecting exception: MissingFormatArgumentException");
      
      } catch(MissingFormatArgumentException e) {
         //
         // Format specifier '%1$s'
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      char[] charArray0 = new char[5];
      FileSystemHandling.shouldAllThrowIOExceptions();
      charArray0[0] = 'c';
      charArray0[1] = '<';
      charArray0[2] = '?';
      charArray0[3] = 'c';
      charArray0[4] = '7';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      Locale locale0 = Locale.JAPANESE;
      Formatter formatter0 = new Formatter(charBuffer0, locale0);
      charBuffer0.put('<');
      FileSystemHandling.createFolder((EvoSuiteFile) null);
      CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0);
      charBuffer1.asReadOnlyBuffer();
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, (-1802), (-1802), 986, (CharSequence) charBuffer1);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer1, formatter1, 1009, (-1802), 995, '#', (CharSequence) charBuffer1);
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.Buffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Formattable formattable0 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable0);
      CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) "");
      Formatter formatter0 = new Formatter();
      int int0 = 0;
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, (-320), 3058, 0);
      Formatter formatter2 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, 3058, (-320), (-320), (CharSequence) charBuffer0);
      Formattable formattable1 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable1);
      Formatter formatter3 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, (-128), (-320), 3058, '>');
      Formattable formattable2 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable2);
      FormattableUtils.append((CharSequence) "", formatter2, (-320), 71, 2529, '6', (CharSequence) "");
      Formatter formatter4 = FormattableUtils.append((CharSequence) "", formatter3, (-128), 2540, (-1), ';', (CharSequence) charBuffer0);
      FormattableUtils.append((CharSequence) charBuffer0, formatter4, 2979, 2540, 0);
      FormattableUtils.append((CharSequence) "", formatter1, 2979, 293, 0, '6', (CharSequence) "");
      FormattableUtils.append((CharSequence) "", formatter1, 2540, (-1), (-170), ';', (CharSequence) "");
      Formatter formatter5 = formatter3.format("", (Object[]) null);
      Formattable formattable3 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable3);
      // Undeclared exception!
      FormattableUtils.append((CharSequence) "", formatter5, 481, 2538, (-2977), (CharSequence) "");
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      char[] charArray0 = new char[9];
      FileSystemHandling.appendStringToFile((EvoSuiteFile) null, "Z%N|4}kVi%O5a");
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      DataOutputStream dataOutputStream0 = new DataOutputStream((OutputStream) null);
      Formatter formatter0 = new Formatter();
      Formatter formatter1 = new Formatter(dataOutputStream0);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) "Z%N|4}kVi%O5a", formatter0, 12, 2565, 3618, (CharSequence) charBuffer0);
        fail("Expecting exception: UnknownFormatConversionException");
      
      } catch(UnknownFormatConversionException e) {
         //
         // Conversion = 'N'
         //
         verifyException("java.util.Formatter$FormatSpecifier", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      char[] charArray0 = new char[0];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      charBuffer0.codePoints();
      int int0 = 1041;
      Locale locale0 = Locale.SIMPLIFIED_CHINESE;
      Formatter formatter0 = new Formatter(charBuffer0, locale0);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, formatter0, 0, 1041, (-711), ']', (CharSequence) charBuffer0);
        fail("Expecting exception: BufferOverflowException");
      
      } catch(BufferOverflowException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.CharBuffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      byte[] byteArray0 = new byte[0];
      FileSystemHandling.appendDataToFile((EvoSuiteFile) null, byteArray0);
      Object object0 = new Object();
      Formatter formatter0 = new Formatter();
      Formatter formatter1 = FormattableUtils.append((CharSequence) "*iD@/x=dLZ*faT!", formatter0, (-587), 1318, 2, 'A');
      // Undeclared exception!
      FormattableUtils.append((CharSequence) "*iD@/x=dLZ*faT!", formatter1, 949, 32767, 0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Formattable formattable0 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable0);
      CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) "");
      Locale locale0 = Locale.CHINESE;
      Formatter formatter0 = new Formatter(charBuffer0, locale0);
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, 795, 0, 795);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, formatter1, 0, 795, (-473), 'L');
        fail("Expecting exception: ReadOnlyBufferException");
      
      } catch(ReadOnlyBufferException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.CharBuffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Formattable formattable0 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable0);
      Formatter formatter0 = new Formatter();
      formatter0.close();
      char char0 = 'Y';
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) "", formatter0, 569, 150, 150, 'Y');
        fail("Expecting exception: FormatterClosedException");
      
      } catch(FormatterClosedException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      int int0 = 331;
      FileSystemHandling.createFolder((EvoSuiteFile) null);
      CharBuffer charBuffer0 = CharBuffer.allocate(331);
      int int1 = 0;
      int int2 = 0;
      CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0, 0, 0);
      Formatter formatter0 = new Formatter(charBuffer1);
      Locale locale0 = Locale.TAIWAN;
      String string0 = null;
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, formatter0, 112, 112, (-1632));
        fail("Expecting exception: ReadOnlyBufferException");
      
      } catch(ReadOnlyBufferException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.CharBuffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Formattable formattable0 = null;
      FormattableUtils.toString((Formattable) null);
      Locale locale0 = Locale.KOREA;
      Formatter formatter0 = new Formatter(locale0);
      formatter0.close();
      int int0 = 1635;
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) "null", formatter0, 1021, 2507, 1635, '[', (CharSequence) "null");
        fail("Expecting exception: FormatterClosedException");
      
      } catch(FormatterClosedException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      char[] charArray0 = new char[4];
      charArray0[0] = 'X';
      char char0 = '|';
      charArray0[1] = '|';
      charArray0[2] = 'A';
      charArray0[3] = '%';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      Formatter formatter0 = new Formatter();
      int int0 = 756;
      Locale locale0 = Locale.ROOT;
      Object[] objectArray0 = new Object[8];
      objectArray0[0] = (Object) '%';
      objectArray0[1] = (Object) 'X';
      Object object0 = new Object();
      objectArray0[2] = object0;
      objectArray0[3] = (Object) '%';
      objectArray0[4] = (Object) 'X';
      objectArray0[5] = (Object) 'A';
      objectArray0[6] = (Object) 'X';
      objectArray0[7] = (Object) 'A';
      formatter0.format(locale0, "E/{B3", objectArray0);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, formatter0, 756, 630, 630, 'X', (CharSequence) charBuffer0);
        fail("Expecting exception: UnknownFormatConversionException");
      
      } catch(UnknownFormatConversionException e) {
         //
         // Conversion = '%'
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      StringWriter stringWriter0 = new StringWriter();
      StringBuffer stringBuffer0 = stringWriter0.getBuffer();
      String string0 = "";
      Locale locale0 = new Locale("V$4_;~QXjeP_gH|[", "V$4_;~QXjeP_gH|[", "");
      Formatter formatter0 = new Formatter(locale0);
      formatter0.close();
      int int0 = 0;
      LinkedList<Locale.LanguageRange> linkedList0 = new LinkedList<Locale.LanguageRange>();
      LinkedList<Locale> linkedList1 = new LinkedList<Locale>();
      Locale.filter((List<Locale.LanguageRange>) linkedList0, (Collection<Locale>) linkedList1);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) stringBuffer0, formatter0, 0, (-1559), 0, '-', (CharSequence) stringBuffer0);
        fail("Expecting exception: FormatterClosedException");
      
      } catch(FormatterClosedException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Formattable formattable0 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable0);
      FormattableUtils formattableUtils0 = new FormattableUtils();
      Formatter formatter0 = new Formatter();
      Object[] objectArray0 = new Object[0];
      Formatter formatter1 = formatter0.format("", objectArray0);
      int int0 = 0;
      Formatter formatter2 = FormattableUtils.append((CharSequence) "", formatter0, 2128, 0, 2128, (CharSequence) "");
      int int1 = 1;
      int int2 = 0;
      char[] charArray0 = new char[0];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      CharBuffer charBuffer1 = charBuffer0.duplicate();
      formatter2.format("", objectArray0);
      charBuffer0.chars();
      FormattableUtils.append((CharSequence) "", formatter0, 1, 0, (-677), (CharSequence) charBuffer0);
      charBuffer1.mark();
      char char0 = 'z';
      FormattableUtils.append((CharSequence) "", formatter1, 0, 5398, 0, 'z', (CharSequence) charBuffer0);
      // Undeclared exception!
      FormattableUtils.append((CharSequence) "", formatter2, 5398, 5398, 0, 'z', (CharSequence) charBuffer0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      FormattableUtils formattableUtils0 = new FormattableUtils();
      CharBuffer charBuffer0 = CharBuffer.allocate(0);
      Formatter formatter0 = new Formatter();
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, 0, 2213, (-3072), ';', (CharSequence) charBuffer0);
      Formatter formatter2 = FormattableUtils.append((CharSequence) charBuffer0, formatter1, 3665, 0, 0, (CharSequence) charBuffer0);
      assertSame(formatter2, formatter1);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      FormattableUtils formattableUtils0 = new FormattableUtils();
      Formattable formattable0 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable0);
      StringWriter stringWriter0 = new StringWriter();
      StringBuffer stringBuffer0 = stringWriter0.getBuffer();
      Formatter formatter0 = null;
      int int0 = 0;
      char[] charArray0 = new char[4];
      charArray0[0] = 'Q';
      charArray0[1] = 'q';
      charArray0[2] = 't';
      charArray0[3] = 'u';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0, 0, 0);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) stringBuffer0, (Formatter) null, 0, 0, 0, (CharSequence) charBuffer0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      char[] charArray0 = new char[8];
      charArray0[0] = '7';
      charArray0[1] = '4';
      charArray0[2] = 'l';
      charArray0[3] = 'd';
      charArray0[4] = '1';
      charArray0[5] = 'r';
      charArray0[6] = '^';
      charArray0[7] = '-';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0, 1, 1);
      Locale locale0 = Locale.CHINA;
      Formatter formatter0 = new Formatter(charBuffer0, locale0);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, formatter0, 946, 946, (-119), (CharSequence) charBuffer0);
        fail("Expecting exception: BufferOverflowException");
      
      } catch(BufferOverflowException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.CharBuffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      int int0 = 2411;
      CharBuffer charBuffer0 = CharBuffer.allocate(2411);
      Locale locale0 = Locale.SIMPLIFIED_CHINESE;
      Formatter formatter0 = new Formatter(charBuffer0, locale0);
      charBuffer0.flip();
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, formatter0, 2411, 2411, 2411);
        fail("Expecting exception: BufferOverflowException");
      
      } catch(BufferOverflowException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.CharBuffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      char[] charArray0 = new char[1];
      charArray0[0] = 'F';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      Locale locale0 = Locale.UK;
      Formatter formatter0 = new Formatter(locale0);
      int int0 = 0;
      charBuffer0.codePoints();
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, (-1105), 0, 0, 'F');
      Formattable formattable0 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      Object[] objectArray0 = new Object[5];
      objectArray0[0] = (Object) formatter0;
      objectArray0[1] = (Object) formatter0;
      objectArray0[2] = (Object) formatter0;
      objectArray0[3] = (Object) 'F';
      objectArray0[4] = (Object) formattable0;
      formatter1.format(locale0, "Q<KQaZ", objectArray0);
      FormattableUtils.toString(formattable0);
      Formatter formatter2 = FormattableUtils.append((CharSequence) charBuffer0, formatter1, 0, (-1105), (-1105), (CharSequence) "");
      FormattableUtils.append((CharSequence) charBuffer0, formatter2, 0, (-1105), 151);
      FormattableUtils.append((CharSequence) "", formatter0, 0, 0, 0);
      int int1 = 0;
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, (Formatter) null, (-1105), 0, 0, 'F');
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) null, (Formatter) null, 1, (-4361), 1, 'l');
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      StringWriter stringWriter0 = new StringWriter();
      StringBuffer stringBuffer0 = stringWriter0.getBuffer();
      MockPrintWriter mockPrintWriter0 = new MockPrintWriter(stringWriter0);
      mockPrintWriter0.println(1050.9474895101268);
      Formatter formatter0 = new Formatter(mockPrintWriter0);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) stringBuffer0, formatter0, 0, 0, 0, '[', (CharSequence) stringBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Specified ellipsis '1050.9474895101268
         // ' exceeds precision of 0
         //
         verifyException("org.apache.commons.lang3.Validate", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      char[] charArray0 = new char[5];
      charArray0[0] = 'E';
      charArray0[1] = 'V';
      charArray0[2] = 'i';
      charArray0[3] = 'A';
      charArray0[4] = 'i';
      int int0 = 0;
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0, 0, 0);
      Formatter formatter0 = null;
      int int1 = 28;
      charBuffer0.compact();
      int int2 = 0;
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, (Formatter) null, 0, 28, 0, (CharSequence) charBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Specified ellipsis 'EViAi' exceeds precision of 0
         //
         verifyException("org.apache.commons.lang3.Validate", e);
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      FormattableUtils formattableUtils0 = new FormattableUtils();
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) null, (Formatter) null, (-3063), (-3063), 1, 'R', (CharSequence) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Formattable formattable0 = mock(Formattable.class, new ViolatedAssumptionAnswer());
      FormattableUtils.toString(formattable0);
      Formatter formatter0 = new Formatter();
      formatter0.close();
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) "", formatter0, 616, 616, 616);
        fail("Expecting exception: FormatterClosedException");
      
      } catch(FormatterClosedException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      FormattableUtils formattableUtils0 = new FormattableUtils();
      char[] charArray0 = new char[4];
      charArray0[0] = 'd';
      charArray0[1] = '=';
      charArray0[2] = '}';
      charArray0[3] = '.';
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0);
      MockPrintStream mockPrintStream0 = new MockPrintStream("L *JIR");
      Formatter formatter0 = new Formatter((PrintStream) mockPrintStream0);
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer1, formatter0, 3133, 0, 1406, '=', (CharSequence) "L *JIR");
      assertSame(formatter1, formatter0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Charset charset0 = Charset.defaultCharset();
      byte[] byteArray0 = new byte[2];
      byteArray0[0] = (byte)0;
      byteArray0[1] = (byte) (-38);
      ByteBuffer byteBuffer0 = ByteBuffer.wrap(byteArray0);
      CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, (Formatter) null, (-1567), (-1), (int) (byte)0, (CharSequence) charBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Specified ellipsis '\u0000\uFFFD' exceeds precision of 0
         //
         verifyException("org.apache.commons.lang3.Validate", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      FormattableUtils.toString((Formattable) null);
      Charset charset0 = Charset.defaultCharset();
      ByteBuffer byteBuffer0 = charset0.encode("");
      CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
      CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) "null", 0, 0);
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, (Formatter) null, 0, 0, 0, (CharSequence) charBuffer1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      CharBuffer charBuffer0 = CharBuffer.allocate(331);
      CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0, 0, 0);
      Formatter formatter0 = new Formatter(charBuffer1);
      int int0 = 1;
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) charBuffer0, formatter0, 0, 1, 0, '=', (CharSequence) charBuffer1);
        fail("Expecting exception: ReadOnlyBufferException");
      
      } catch(ReadOnlyBufferException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.CharBuffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      char[] charArray0 = new char[0];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      DataOutputStream dataOutputStream0 = new DataOutputStream((OutputStream) null);
      Formatter formatter0 = new Formatter(dataOutputStream0);
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, 1041, 1041, 0, (CharSequence) charBuffer0);
      assertSame(formatter0, formatter1);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      FormattableUtils.toString((Formattable) null);
      Formatter formatter0 = null;
      try {
        formatter0 = new Formatter((String) null, "null");
        fail("Expecting exception: UnsupportedEncodingException");
      
      } catch(Throwable e) {
         //
         // null
         //
         verifyException("java.util.Formatter", e);
      }
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      StringWriter stringWriter0 = new StringWriter();
      StringWriter stringWriter1 = stringWriter0.append('.');
      StringBuffer stringBuffer0 = stringWriter1.getBuffer();
      CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) stringBuffer0);
      MockFileOutputStream mockFileOutputStream0 = new MockFileOutputStream("hW2 HjzkU@.5", false);
      Formatter formatter0 = new Formatter(mockFileOutputStream0);
      Formatter formatter1 = FormattableUtils.append((CharSequence) charBuffer0, formatter0, 0, 369, 0);
      assertSame(formatter1, formatter0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      StringWriter stringWriter0 = new StringWriter();
      StringBuffer stringBuffer0 = stringWriter0.getBuffer();
      Formatter formatter0 = new Formatter();
      Formatter formatter1 = FormattableUtils.append((CharSequence) stringBuffer0, formatter0, (-1), (-231), (-1808));
      assertEquals("", formatter1.toString());
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      FormattableUtils formattableUtils0 = new FormattableUtils();
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) null, (Formatter) null, 800, 2471, 800);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      FormattableUtils.toString((Formattable) null);
      FormattableUtils formattableUtils0 = new FormattableUtils();
      Formatter formatter0 = new Formatter();
      Formatter formatter1 = FormattableUtils.append((CharSequence) "null", formatter0, (-694), (-694), 1, 'T');
      Formatter formatter2 = FormattableUtils.append((CharSequence) "null", formatter1, (-694), (int) 'T', (-694), 'T', (CharSequence) "null");
      Formatter formatter3 = FormattableUtils.append((CharSequence) "null", formatter0, (int) 'T', 1, (-694));
      FormattableUtils.append((CharSequence) "null", formatter3, (-5), (int) 'T', (-5));
      // Undeclared exception!
      try { 
        FormattableUtils.append((CharSequence) "null", formatter2, (-694), (-5), 0, 'T', (CharSequence) "null");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Specified ellipsis 'null' exceeds precision of 0
         //
         verifyException("org.apache.commons.lang3.Validate", e);
      }
  }
}
