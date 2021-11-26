/*
 * This file was automatically generated by EvoSuite
 * Fri Nov 26 03:14:14 GMT 2021
 */

package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.Reader;
import java.io.StringReader;
import org.apache.commons.csv.CSVFormat;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CSVFormat_ESTest extends CSVFormat_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      CSVFormat cSVFormat1 = cSVFormat0.withEscape('`');
      CSVFormat cSVFormat2 = cSVFormat1.withLineSeparator("");
      assertEquals(',', cSVFormat1.getDelimiter());
      assertEquals('\"', cSVFormat2.getEncapsulator());
      assertEquals('`', cSVFormat2.getEscape());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('`', cSVFormat1.getEscape());
      assertEquals('\uFFFE', cSVFormat1.getCommentStart());
      assertEquals(',', cSVFormat2.getDelimiter());
      assertEquals('\"', cSVFormat1.getEncapsulator());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      CSVFormat cSVFormat1 = cSVFormat0.MYSQL.withDelimiter('Y');
      assertEquals('Y', cSVFormat1.getDelimiter());
      assertEquals('\\', cSVFormat1.getEscape());
      assertFalse(cSVFormat1.isCommentingEnabled());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals('\uFFFE', cSVFormat1.getEncapsulator());
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      CSVFormat cSVFormat1 = cSVFormat0.withEscape('\t');
      assertEquals('\uFFFE', cSVFormat1.getEncapsulator());
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertEquals('\t', cSVFormat1.getEscape());
      assertEquals('\uFFFE', cSVFormat1.getCommentStart());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.DEFAULT;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('O');
      CSVFormat cSVFormat2 = cSVFormat1.withSurroundingSpacesIgnored(false);
      assertEquals('\"', cSVFormat1.getEncapsulator());
      assertEquals(',', cSVFormat1.getDelimiter());
      assertFalse(cSVFormat2.isSurroundingSpacesIgnored());
      assertTrue(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('\"', cSVFormat2.getEncapsulator());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertEquals('O', cSVFormat2.getCommentStart());
      assertEquals('O', cSVFormat1.getCommentStart());
      assertEquals(',', cSVFormat2.getDelimiter());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.DEFAULT;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('*');
      CSVFormat cSVFormat2 = cSVFormat1.withHeader((String[]) null);
      CSVFormat cSVFormat3 = cSVFormat2.withLineSeparator("");
      assertEquals('\"', cSVFormat3.getEncapsulator());
      assertEquals(',', cSVFormat3.getDelimiter());
      assertEquals('\uFFFE', cSVFormat3.getEscape());
      assertEquals('*', cSVFormat3.getCommentStart());
      assertFalse(cSVFormat3.isSurroundingSpacesIgnored());
      assertTrue(cSVFormat3.isEmptyLinesIgnored());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('');
      CSVFormat cSVFormat2 = cSVFormat1.withDelimiter('');
      CSVFormat cSVFormat3 = cSVFormat2.withEscape('q');
      assertFalse(cSVFormat3.isSurroundingSpacesIgnored());
      assertEquals(',', cSVFormat1.getDelimiter());
      assertEquals('', cSVFormat1.getCommentStart());
      assertEquals('q', cSVFormat3.getEscape());
      assertEquals('', cSVFormat3.getDelimiter());
      assertEquals('', cSVFormat3.getCommentStart());
      assertFalse(cSVFormat3.isEmptyLinesIgnored());
      assertEquals('\"', cSVFormat3.getEncapsulator());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.DEFAULT;
      CSVFormat cSVFormat1 = cSVFormat0.RFC4180.withEmptyLinesIgnored(true);
      assertEquals(',', cSVFormat1.getDelimiter());
      assertEquals('\"', cSVFormat1.getEncapsulator());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertEquals('\uFFFE', cSVFormat1.getCommentStart());
      assertTrue(cSVFormat1.isEmptyLinesIgnored());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('');
      CSVFormat cSVFormat2 = cSVFormat1.withEmptyLinesIgnored(false);
      assertEquals('\"', cSVFormat2.getEncapsulator());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertFalse(cSVFormat2.isEmptyLinesIgnored());
      assertEquals('', cSVFormat1.getCommentStart());
      assertEquals('', cSVFormat2.getCommentStart());
      assertEquals('\"', cSVFormat1.getEncapsulator());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals(',', cSVFormat2.getDelimiter());
      assertEquals(',', cSVFormat1.getDelimiter());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('\uFFFE');
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
      assertFalse(cSVFormat1.isCommentingEnabled());
      assertEquals('\uFFFE', cSVFormat1.getEncapsulator());
      assertEquals('\\', cSVFormat1.getEscape());
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.RFC4180;
      CSVFormat cSVFormat1 = cSVFormat0.withSurroundingSpacesIgnored(true);
      boolean boolean0 = cSVFormat1.isSurroundingSpacesIgnored();
      assertEquals('\"', cSVFormat1.getEncapsulator());
      assertTrue(boolean0);
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
      assertEquals(',', cSVFormat1.getDelimiter());
      assertFalse(cSVFormat1.isCommentingEnabled());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.RFC4180;
      CSVFormat cSVFormat1 = cSVFormat0.MYSQL.withEncapsulator(')');
      boolean boolean0 = cSVFormat1.isEscaping();
      assertEquals(')', cSVFormat1.getEncapsulator());
      assertEquals('\uFFFE', cSVFormat1.getCommentStart());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertEquals('\\', cSVFormat1.getEscape());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      boolean boolean0 = cSVFormat0.isEscaping();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      CSVFormat cSVFormat1 = cSVFormat0.MYSQL.withEncapsulator('A');
      boolean boolean0 = cSVFormat1.isEncapsulating();
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals('\\', cSVFormat1.getEscape());
      assertFalse(cSVFormat1.isCommentingEnabled());
      assertTrue(boolean0);
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('A', cSVFormat1.getEncapsulator());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      boolean boolean0 = cSVFormat0.isEncapsulating();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.DEFAULT;
      boolean boolean0 = cSVFormat0.isEmptyLinesIgnored();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      String[] stringArray0 = new String[4];
      CSVFormat cSVFormat0 = new CSVFormat('T', '(', '(', '(', false, false, (String) null, stringArray0);
      cSVFormat0.getLineSeparator();
      assertEquals('(', cSVFormat0.getCommentStart());
      assertEquals('(', cSVFormat0.getEncapsulator());
      assertFalse(cSVFormat0.isSurroundingSpacesIgnored());
      assertEquals('(', cSVFormat0.getEscape());
      assertFalse(cSVFormat0.isEmptyLinesIgnored());
      assertEquals('T', cSVFormat0.getDelimiter());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.TDF;
      CSVFormat cSVFormat1 = cSVFormat0.withLineSeparator("");
      cSVFormat1.getLineSeparator();
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertEquals('\"', cSVFormat1.getEncapsulator());
      assertTrue(cSVFormat1.isEmptyLinesIgnored());
      assertTrue(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertEquals('\uFFFE', cSVFormat1.getCommentStart());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      String[] stringArray0 = cSVFormat0.getHeader();
      assertNull(stringArray0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.TDF;
      String[] stringArray0 = new String[1];
      CSVFormat cSVFormat1 = cSVFormat0.withHeader(stringArray0);
      cSVFormat1.getHeader();
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertFalse(cSVFormat1.isCommentingEnabled());
      assertTrue(cSVFormat1.isSurroundingSpacesIgnored());
      assertTrue(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('\"', cSVFormat1.getEncapsulator());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.TDF;
      String[] stringArray0 = new String[0];
      CSVFormat cSVFormat1 = cSVFormat0.withHeader(stringArray0);
      CSVFormat cSVFormat2 = cSVFormat1.withEmptyLinesIgnored(false);
      cSVFormat2.getHeader();
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertFalse(cSVFormat2.isEmptyLinesIgnored());
      assertTrue(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals('\t', cSVFormat2.getDelimiter());
      assertTrue(cSVFormat2.isSurroundingSpacesIgnored());
      assertEquals('\"', cSVFormat2.getEncapsulator());
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertEquals('\uFFFE', cSVFormat1.getCommentStart());
      assertEquals('\"', cSVFormat1.getEncapsulator());
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      String[] stringArray0 = new String[0];
      CSVFormat cSVFormat0 = new CSVFormat('k', 'c', '.', '3', false, false, "", stringArray0);
      char char0 = cSVFormat0.getEscape();
      assertEquals('3', char0);
      assertEquals('.', cSVFormat0.getCommentStart());
      assertEquals('c', cSVFormat0.getEncapsulator());
      assertFalse(cSVFormat0.isEmptyLinesIgnored());
      assertFalse(cSVFormat0.isSurroundingSpacesIgnored());
      assertEquals('k', cSVFormat0.getDelimiter());
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      CSVFormat cSVFormat1 = cSVFormat0.TDF.withEscape('e');
      char char0 = cSVFormat1.getEscape();
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertTrue(cSVFormat1.isSurroundingSpacesIgnored());
      assertFalse(cSVFormat1.isCommentingEnabled());
      assertTrue(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('e', char0);
      assertEquals('\"', cSVFormat1.getEncapsulator());
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      CSVFormat cSVFormat1 = cSVFormat0.RFC4180.withEncapsulator('5');
      char char0 = cSVFormat1.getEncapsulator();
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertFalse(cSVFormat1.isCommentingEnabled());
      assertEquals('5', char0);
      assertEquals(',', cSVFormat1.getDelimiter());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      String[] stringArray0 = new String[2];
      CSVFormat cSVFormat0 = new CSVFormat('M', 'p', 'm', 'p', false, true, "iz1i8Pa", stringArray0);
      char char0 = cSVFormat0.getEncapsulator();
      assertEquals('p', cSVFormat0.getEscape());
      assertFalse(cSVFormat0.isSurroundingSpacesIgnored());
      assertEquals('p', char0);
      assertTrue(cSVFormat0.isEmptyLinesIgnored());
      assertEquals('M', cSVFormat0.getDelimiter());
      assertEquals('m', cSVFormat0.getCommentStart());
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.TDF;
      CSVFormat cSVFormat1 = cSVFormat0.withDelimiter('9');
      char char0 = cSVFormat1.getDelimiter();
      assertTrue(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals('9', char0);
      assertEquals('\"', cSVFormat1.getEncapsulator());
      assertTrue(cSVFormat1.isEmptyLinesIgnored());
      assertFalse(cSVFormat1.isCommentingEnabled());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.TDF;
      CSVFormat cSVFormat1 = cSVFormat0.withDelimiter('m');
      char char0 = cSVFormat1.getDelimiter();
      assertEquals('\"', cSVFormat1.getEncapsulator());
      assertEquals('m', char0);
      assertTrue(cSVFormat1.isSurroundingSpacesIgnored());
      assertTrue(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertEquals('\uFFFE', cSVFormat1.getCommentStart());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.TDF;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('0');
      char char0 = cSVFormat1.getCommentStart();
      assertTrue(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertEquals('0', char0);
      assertTrue(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertEquals('\"', cSVFormat1.getEncapsulator());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('W');
      char char0 = cSVFormat1.getCommentStart();
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertEquals('\uFFFE', cSVFormat1.getEncapsulator());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals('W', char0);
      assertEquals('\\', cSVFormat1.getEscape());
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      String[] stringArray0 = new String[1];
      String string0 = cSVFormat0.DEFAULT.format(stringArray0);
      assertEquals(',', cSVFormat0.getDelimiter());
      assertEquals("\"\"", string0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.DEFAULT;
      String[] stringArray0 = new String[0];
      String string0 = cSVFormat0.format(stringArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.DEFAULT;
      // Undeclared exception!
      try { 
        cSVFormat0.parse((Reader) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.io.Reader", e);
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      CSVFormat cSVFormat0 = new CSVFormat('?', '?', '?', '?', true, true, "", (String[]) null);
      StringReader stringReader0 = new StringReader("Delimiter=<?> Escape=<?> Encapsulator=<x> CommentStart=<?> EmptyLines:ignored SurroundingSpaces:ignored");
      // Undeclared exception!
      try { 
        cSVFormat0.parse(stringReader0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The encapsulator character and the delimiter cannot be the same (\"?\")
         //
         verifyException("org.apache.commons.csv.CSVFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      CSVFormat cSVFormat1 = cSVFormat0.TDF.withCommentStart('O');
      boolean boolean0 = cSVFormat1.isCommentingEnabled();
      assertTrue(cSVFormat1.isEmptyLinesIgnored());
      assertFalse(cSVFormat0.isCommentingEnabled());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertTrue(cSVFormat1.isSurroundingSpacesIgnored());
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertEquals('\"', cSVFormat1.getEncapsulator());
      assertTrue(boolean0);
      assertEquals('O', cSVFormat1.getCommentStart());
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      boolean boolean0 = cSVFormat0.isCommentingEnabled();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.DEFAULT;
      boolean boolean0 = cSVFormat0.isSurroundingSpacesIgnored();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      char char0 = cSVFormat0.getEscape();
      assertEquals('\\', char0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      char char0 = cSVFormat0.getEncapsulator();
      assertEquals('\"', char0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      boolean boolean0 = cSVFormat0.isEmptyLinesIgnored();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      char char0 = cSVFormat0.getCommentStart();
      assertEquals('\uFFFE', char0);
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      char char0 = cSVFormat0.getDelimiter();
      assertEquals('\t', char0);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      String string0 = cSVFormat0.TDF.toString();
      assertEquals("Delimiter=<\t> Encapsulator=<\"> EmptyLines:ignored SurroundingSpaces:ignored", string0);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('');
      String string0 = cSVFormat1.toString();
      assertEquals("Delimiter=<,> Encapsulator=<\"> CommentStart=<>", string0);
      assertFalse(cSVFormat0.isCommentingEnabled());
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      String string0 = cSVFormat0.toString();
      assertEquals("Delimiter=<\t> Escape=<\\>", string0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      String[] stringArray0 = new String[4];
      CSVFormat cSVFormat0 = new CSVFormat('d', '\u0018', '\u0018', '\u0018', true, true, (String) null, stringArray0);
      CSVFormat cSVFormat1 = cSVFormat0.withEncapsulator(')');
      // Undeclared exception!
      try { 
        cSVFormat1.format(stringArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The comment start and the escape character cannot be the same (\"\u0018\")
         //
         verifyException("org.apache.commons.csv.CSVFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.TDF;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('n');
      CSVFormat cSVFormat2 = cSVFormat1.withEncapsulator('n');
      try { 
        cSVFormat2.validate();
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The comment start character and the encapsulator cannot be the same (\"n\")
         //
         verifyException("org.apache.commons.csv.CSVFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      String[] stringArray0 = new String[2];
      CSVFormat cSVFormat0 = new CSVFormat('-', '-', '-', '-', true, true, "J\"$TTd([rs:`0bL=c", stringArray0);
      cSVFormat0.MYSQL.validate();
      assertEquals('-', cSVFormat0.getCommentStart());
      assertTrue(cSVFormat0.isSurroundingSpacesIgnored());
      assertEquals('-', cSVFormat0.getEncapsulator());
      assertTrue(cSVFormat0.isEmptyLinesIgnored());
      assertEquals('-', cSVFormat0.getDelimiter());
      assertEquals('-', cSVFormat0.getEscape());
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      String[] stringArray0 = new String[2];
      CSVFormat cSVFormat0 = new CSVFormat('-', '-', '-', '-', true, true, "J\"$TTd([rs:`0bL=c", stringArray0);
      CSVFormat cSVFormat1 = cSVFormat0.withEncapsulator('S');
      try { 
        cSVFormat1.validate();
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The escape character and the delimiter cannot be the same (\"-\")
         //
         verifyException("org.apache.commons.csv.CSVFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      CSVFormat cSVFormat1 = cSVFormat0.withCommentStart('');
      CSVFormat cSVFormat2 = cSVFormat1.withDelimiter('');
      // Undeclared exception!
      try { 
        cSVFormat2.format((String[]) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The comment start character and the delimiter cannot be the same (\"\")
         //
         verifyException("org.apache.commons.csv.CSVFormat", e);
      }
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      CSVFormat cSVFormat1 = cSVFormat0.EXCEL.withHeader((String[]) null);
      assertEquals('\"', cSVFormat1.getEncapsulator());
      assertFalse(cSVFormat1.isSurroundingSpacesIgnored());
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
      assertEquals(',', cSVFormat1.getDelimiter());
      assertEquals('\uFFFE', cSVFormat1.getEscape());
      assertEquals('\uFFFE', cSVFormat1.getCommentStart());
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      // Undeclared exception!
      try { 
        cSVFormat0.format((String[]) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.csv.CSVPrinter", e);
      }
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      CSVFormat cSVFormat1 = cSVFormat0.withSurroundingSpacesIgnored(true);
      assertEquals('\t', cSVFormat1.getDelimiter());
      assertFalse(cSVFormat1.isEmptyLinesIgnored());
      assertEquals('\\', cSVFormat1.getEscape());
      assertFalse(cSVFormat1.isCommentingEnabled());
      assertEquals('\uFFFE', cSVFormat1.getEncapsulator());
      assertTrue(cSVFormat1.isSurroundingSpacesIgnored());
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.MYSQL;
      String string0 = cSVFormat0.getLineSeparator();
      assertEquals("\n", string0);
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      CSVFormat cSVFormat0 = CSVFormat.EXCEL;
      StringReader stringReader0 = new StringReader(" EmptyLines:ignored");
      cSVFormat0.TDF.parse(stringReader0);
      assertEquals(',', cSVFormat0.getDelimiter());
      assertEquals('\"', cSVFormat0.getEncapsulator());
      assertFalse(cSVFormat0.isCommentingEnabled());
  }
}