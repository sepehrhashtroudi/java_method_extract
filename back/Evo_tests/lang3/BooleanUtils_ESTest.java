/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 05:29:48 GMT 2021
 */

package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.lang3.BooleanUtils;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class BooleanUtils_ESTest extends BooleanUtils_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test000()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("O4");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test001()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean("0X");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test002()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("{");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test003()  throws Throwable  {
      Boolean boolean0 = Boolean.TRUE;
      Integer integer0 = new Integer(676);
      Integer integer1 = new Integer(676);
      Integer integer2 = BooleanUtils.toIntegerObject(boolean0, integer0, integer1, integer1);
      assertEquals(676, (int)integer2);
  }

  @Test(timeout = 4000)
  public void test004()  throws Throwable  {
      Integer integer0 = new Integer(905);
      Integer integer1 = Integer.valueOf(2033);
      Integer integer2 = BooleanUtils.toIntegerObject(false, integer0, integer1);
      assertEquals(2033, (int)integer2);
  }

  @Test(timeout = 4000)
  public void test005()  throws Throwable  {
      int int0 = BooleanUtils.toInteger((Boolean) null, 76, 3468, 0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test006()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.toBooleanObject(0, 1674, 169, 2);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Integer did not match any specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test007()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.toBooleanObject(79, 3, 3, 3);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Integer did not match any specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test008()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.toBoolean(605, 0, 2670);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Integer did not match either specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test009()  throws Throwable  {
      Integer integer0 = new Integer(21);
      Boolean boolean0 = BooleanUtils.toBooleanObject(integer0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test010()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean((-1605));
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test011()  throws Throwable  {
      Boolean[] booleanArray0 = new Boolean[1];
      // Undeclared exception!
      try { 
        BooleanUtils.xor(booleanArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The array must not contain any null elements
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test012()  throws Throwable  {
      Boolean[] booleanArray0 = new Boolean[3];
      // Undeclared exception!
      try { 
        BooleanUtils.or(booleanArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The array must not contain any null elements
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test013()  throws Throwable  {
      Boolean[] booleanArray0 = new Boolean[5];
      // Undeclared exception!
      try { 
        BooleanUtils.and(booleanArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The array must not contain any null elements
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test014()  throws Throwable  {
      String string0 = BooleanUtils.toStringYesNo((Boolean) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test015()  throws Throwable  {
      String string0 = BooleanUtils.toStringOnOff((Boolean) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test016()  throws Throwable  {
      String string0 = BooleanUtils.toString(false, "Array element ", (String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test017()  throws Throwable  {
      String string0 = BooleanUtils.toString(false, "", "");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test018()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject(0, (-430), 1442, 0);
      assertNull(boolean0);
      
      String string0 = BooleanUtils.toString(boolean0, "false", "{}", "false");
      assertEquals("false", string0);
  }

  @Test(timeout = 4000)
  public void test019()  throws Throwable  {
      Integer integer0 = new Integer((-2823));
      Integer integer1 = BooleanUtils.toIntegerObject(false, integer0, integer0);
      assertEquals((-2823), (int)integer1);
  }

  @Test(timeout = 4000)
  public void test020()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Integer integer1 = BooleanUtils.toIntegerObject(true, integer0, (Integer) null);
      assertEquals(0, (int)integer1);
  }

  @Test(timeout = 4000)
  public void test021()  throws Throwable  {
      Integer integer0 = new Integer(2779);
      Integer integer1 = new Integer((-2003));
      Integer integer2 = BooleanUtils.toIntegerObject((Boolean) null, integer0, integer0, integer1);
      assertEquals((-2003), (int)integer2);
  }

  @Test(timeout = 4000)
  public void test022()  throws Throwable  {
      int int0 = BooleanUtils.toInteger(true, 0, (-1));
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test023()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean("+z3MuP", "C2uoH-dC|hM;+1ypuI", "+z3MuP");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test024()  throws Throwable  {
      Boolean boolean0 = Boolean.FALSE;
      boolean boolean1 = BooleanUtils.isTrue(boolean0);
      assertFalse(boolean1);
  }

  @Test(timeout = 4000)
  public void test025()  throws Throwable  {
      Boolean boolean0 = new Boolean("nS^%_]Yz(2y=8(ctg9");
      boolean boolean1 = BooleanUtils.isFalse(boolean0);
      assertTrue(boolean1);
  }

  @Test(timeout = 4000)
  public void test026()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[2];
      booleanArray0[0] = true;
      booleanArray0[1] = true;
      boolean boolean0 = BooleanUtils.xor(booleanArray0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test027()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[5];
      booleanArray0[0] = true;
      boolean boolean0 = BooleanUtils.or(booleanArray0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test028()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[1];
      booleanArray0[0] = true;
      boolean boolean0 = BooleanUtils.and(booleanArray0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test029()  throws Throwable  {
      String string0 = BooleanUtils.toString(false, "Pl=kr", "T(yEy");
      assertEquals("T(yEy", string0);
  }

  @Test(timeout = 4000)
  public void test030()  throws Throwable  {
      String string0 = BooleanUtils.toString(true, "o", "");
      assertEquals("o", string0);
  }

  @Test(timeout = 4000)
  public void test031()  throws Throwable  {
      Boolean boolean0 = new Boolean("l+Twxa)v3-+?Fz_");
      String string0 = BooleanUtils.toString(boolean0, "l+Twxa)v3-+?Fz_", (String) null, "");
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test032()  throws Throwable  {
      Boolean boolean0 = Boolean.TRUE;
      String string0 = BooleanUtils.toString(boolean0, "", "", "");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test033()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject(")l(BL");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test034()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("no");
      assertNotNull(boolean0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test035()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("0");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test036()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("/JyWGl6d;AEV{^Nuhj;");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test037()  throws Throwable  {
      boolean boolean0 = BooleanUtils.isFalse((Boolean) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test038()  throws Throwable  {
      Boolean[] booleanArray0 = new Boolean[0];
      // Undeclared exception!
      try { 
        BooleanUtils.xor(booleanArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Array is empty
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test039()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.xor((Boolean[]) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Array must not be null
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test040()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[1];
      booleanArray0[0] = true;
      Boolean[] booleanArray1 = new Boolean[2];
      booleanArray1[0] = (Boolean) booleanArray0[0];
      booleanArray1[1] = (Boolean) true;
      Boolean boolean0 = BooleanUtils.xor(booleanArray1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test041()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[1];
      booleanArray0[0] = true;
      boolean boolean0 = BooleanUtils.xor(booleanArray0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test042()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[0];
      // Undeclared exception!
      try { 
        BooleanUtils.xor(booleanArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Array is empty
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test043()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.xor((boolean[]) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Array must not be null
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test044()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[1];
      boolean boolean0 = BooleanUtils.xor(booleanArray0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test045()  throws Throwable  {
      Boolean boolean0 = new Boolean(false);
      Boolean[] booleanArray0 = new Boolean[4];
      booleanArray0[0] = boolean0;
      booleanArray0[1] = boolean0;
      booleanArray0[2] = (Boolean) false;
      booleanArray0[3] = boolean0;
      Boolean boolean1 = BooleanUtils.or(booleanArray0);
      assertFalse(boolean1);
  }

  @Test(timeout = 4000)
  public void test046()  throws Throwable  {
      Boolean[] booleanArray0 = new Boolean[0];
      // Undeclared exception!
      try { 
        BooleanUtils.or(booleanArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Array is empty
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test047()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.or((Boolean[]) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Array must not be null
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test048()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[1];
      Boolean[] booleanArray1 = new Boolean[2];
      booleanArray1[0] = (Boolean) booleanArray0[0];
      booleanArray1[1] = (Boolean) true;
      Boolean boolean0 = BooleanUtils.or(booleanArray1);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test049()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[0];
      // Undeclared exception!
      try { 
        BooleanUtils.or(booleanArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Array is empty
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test050()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.or((boolean[]) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Array must not be null
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test051()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[17];
      boolean boolean0 = BooleanUtils.or(booleanArray0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test052()  throws Throwable  {
      Boolean[] booleanArray0 = new Boolean[2];
      Boolean boolean0 = BooleanUtils.toBooleanObject("vjm@8I}9pL-9$^D", "vjm@8I}9pL-9$^D", "", "Wx/fR7^T5S\" >9P[");
      booleanArray0[0] = boolean0;
      Boolean boolean1 = Boolean.valueOf("vjm@8I}9pL-9$^D");
      booleanArray0[1] = boolean1;
      Boolean boolean2 = BooleanUtils.and(booleanArray0);
      assertFalse(boolean2);
  }

  @Test(timeout = 4000)
  public void test053()  throws Throwable  {
      Boolean[] booleanArray0 = new Boolean[0];
      // Undeclared exception!
      try { 
        BooleanUtils.and(booleanArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Array is empty
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test054()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.and((Boolean[]) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Array must not be null
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test055()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("yes");
      Boolean[] booleanArray0 = new Boolean[4];
      booleanArray0[0] = boolean0;
      booleanArray0[1] = boolean0;
      booleanArray0[2] = boolean0;
      booleanArray0[3] = boolean0;
      Boolean boolean1 = BooleanUtils.and(booleanArray0);
      assertTrue(boolean1);
  }

  @Test(timeout = 4000)
  public void test056()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[0];
      // Undeclared exception!
      try { 
        BooleanUtils.and(booleanArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Array is empty
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test057()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.and((boolean[]) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Array must not be null
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test058()  throws Throwable  {
      boolean[] booleanArray0 = new boolean[17];
      boolean boolean0 = BooleanUtils.and(booleanArray0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test059()  throws Throwable  {
      String string0 = BooleanUtils.toStringYesNo(true);
      assertEquals("yes", string0);
  }

  @Test(timeout = 4000)
  public void test060()  throws Throwable  {
      String string0 = BooleanUtils.toStringTrueFalse((Boolean) false);
      assertEquals("false", string0);
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test061()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.toBoolean("", "Lj. 'N6'", "vH?W");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The String did not match either specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test062()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean("", "", "");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test063()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean("#", "#", "");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test064()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.toBoolean((String) null, "", "off");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The String did not match either specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test065()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("W!M/5+USt", "STk88|Icg:Hg5", "STk88|Icg:Hg5", "W!M/5+USt");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test066()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("off", (String) null, "off", "");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test067()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.toBooleanObject("false", "yes", "f(RqLFg-(lsY){Ds", ", '");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The String did not match any specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test068()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.toBooleanObject((String) null, "tQ", "Z,U}\"P(Dx3-HoQ:;d!L", "Z,U}\"P(Dx3-HoQ:;d!L");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The String did not match any specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test069()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((String) null, "g,SXP", "w#4xU.0t'5b#", (String) null);
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test070()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((String) null, (String) null, (String) null, (String) null);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test071()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((String) null, "Array and element annot both be null", (String) null, "O`|q ?");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test072()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("sZS/");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test073()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("+Xp");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test074()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("OYq");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test075()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("off");
      Integer integer0 = Integer.getInteger("SRAz^H&'aNT");
      Integer integer1 = Integer.valueOf((-98));
      Integer integer2 = BooleanUtils.toIntegerObject(boolean0, integer1, integer0, integer0);
      assertNull(integer2);
  }

  @Test(timeout = 4000)
  public void test076()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("O}");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test077()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("on");
      assertNotNull(boolean0);
      
      Boolean boolean1 = new Boolean(false);
      Boolean[] booleanArray0 = new Boolean[3];
      booleanArray0[0] = boolean1;
      booleanArray0[1] = boolean1;
      booleanArray0[2] = boolean0;
      Boolean boolean2 = BooleanUtils.xor(booleanArray0);
      assertTrue(boolean2);
  }

  @Test(timeout = 4000)
  public void test078()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("false");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test079()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean("yes");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test080()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("{}");
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test081()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((String) null);
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test082()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("true");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test083()  throws Throwable  {
      Integer integer0 = new Integer((-2091));
      Boolean boolean0 = BooleanUtils.toBooleanObject((-2091), (-2091), 0, 0);
      Integer integer1 = BooleanUtils.toIntegerObject(boolean0, integer0, integer0, integer0);
      assertEquals((-2091), (int)integer1);
  }

  @Test(timeout = 4000)
  public void test084()  throws Throwable  {
      Integer integer0 = BooleanUtils.toIntegerObject(true);
      Integer integer1 = BooleanUtils.toIntegerObject(true, integer0, integer0);
      assertEquals(1, (int)integer1);
  }

  @Test(timeout = 4000)
  public void test085()  throws Throwable  {
      Integer integer0 = Integer.getInteger("w#4xU.0t'5b#");
      Integer integer1 = BooleanUtils.toIntegerObject(false, integer0, (Integer) null);
      assertNull(integer1);
  }

  @Test(timeout = 4000)
  public void test086()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject(0);
      int int0 = BooleanUtils.toInteger(boolean0, Integer.MAX_VALUE, 0, 3775);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test087()  throws Throwable  {
      int int0 = BooleanUtils.toInteger((Boolean) null, 3, 3, 3);
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test088()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((-2091), (-2091), 0, 0);
      int int0 = BooleanUtils.toInteger(boolean0, (-2091), Integer.MAX_VALUE, 0);
      assertEquals((-2091), int0);
  }

  @Test(timeout = 4000)
  public void test089()  throws Throwable  {
      int int0 = BooleanUtils.toInteger(true, (-410), (-410));
      assertEquals((-410), int0);
  }

  @Test(timeout = 4000)
  public void test090()  throws Throwable  {
      int int0 = BooleanUtils.toInteger(false, (-803), 93);
      assertEquals(93, int0);
  }

  @Test(timeout = 4000)
  public void test091()  throws Throwable  {
      Integer integer0 = BooleanUtils.toIntegerObject((Boolean) null);
      Integer integer1 = BooleanUtils.toIntegerObject((Boolean) null, (Integer) null, integer0, (Integer) null);
      assertNull(integer1);
  }

  @Test(timeout = 4000)
  public void test092()  throws Throwable  {
      Integer integer0 = BooleanUtils.toIntegerObject(false);
      Boolean boolean0 = Boolean.valueOf((String) null);
      Integer integer1 = BooleanUtils.toIntegerObject(boolean0, integer0, integer0, (Integer) null);
      assertEquals(0, (int)integer1);
      assertNotNull(integer1);
  }

  @Test(timeout = 4000)
  public void test093()  throws Throwable  {
      int int0 = BooleanUtils.toInteger(true);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test094()  throws Throwable  {
      int int0 = BooleanUtils.toInteger(false);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test095()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject(875);
      Integer integer0 = BooleanUtils.toIntegerObject(boolean0);
      Boolean boolean1 = BooleanUtils.toBooleanObject(integer0, (Integer) null, (Integer) null, integer0);
      assertNull(boolean1);
  }

  @Test(timeout = 4000)
  public void test096()  throws Throwable  {
      Integer integer0 = new Integer(68);
      Integer integer1 = new Integer((-1960));
      Boolean boolean0 = BooleanUtils.toBooleanObject(integer0, integer1, integer0, integer1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test097()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject("vjm@8I}9pL-9$^D", "vjm@8I}9pL-9$^D", "", "Wx/fR7^T5S\" >9P[");
      Integer integer0 = BooleanUtils.toIntegerObject(boolean0);
      Integer integer1 = new Integer((-3996));
      // Undeclared exception!
      try { 
        BooleanUtils.toBooleanObject(integer0, integer1, (Integer) null, integer1);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Integer did not match any specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test098()  throws Throwable  {
      Integer integer0 = new Integer(10);
      Boolean boolean0 = BooleanUtils.toBooleanObject((Integer) null, integer0, integer0, (Integer) null);
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test099()  throws Throwable  {
      Integer integer0 = new Integer(881);
      // Undeclared exception!
      try { 
        BooleanUtils.toBooleanObject((Integer) null, integer0, integer0, integer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Integer did not match any specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test100()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((Integer) null, (Integer) null, (Integer) null, (Integer) null);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test101()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Boolean boolean0 = BooleanUtils.toBooleanObject((Integer) null, integer0, (Integer) null, integer0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test102()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Boolean boolean0 = BooleanUtils.toBooleanObject(integer0, integer0, integer0, integer0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test103()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((-1109596119), 110, (-1109596119), 110);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test104()  throws Throwable  {
      Integer integer0 = BooleanUtils.toIntegerObject(true);
      assertEquals(1, (int)integer0);
      
      Integer integer1 = Integer.getInteger("CGRo", 117);
      boolean boolean0 = BooleanUtils.toBoolean(integer0, integer1, integer0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test105()  throws Throwable  {
      Integer integer0 = BooleanUtils.toIntegerObject(true);
      assertEquals(1, (int)integer0);
      
      boolean boolean0 = BooleanUtils.toBoolean(integer0, integer0, integer0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test106()  throws Throwable  {
      Boolean boolean0 = Boolean.FALSE;
      Integer integer0 = BooleanUtils.toIntegerObject(boolean0);
      assertEquals(0, (int)integer0);
      
      boolean boolean1 = BooleanUtils.toBoolean((Integer) null, integer0, (Integer) null);
      assertFalse(boolean1);
  }

  @Test(timeout = 4000)
  public void test107()  throws Throwable  {
      Boolean boolean0 = Boolean.FALSE;
      Integer integer0 = BooleanUtils.toIntegerObject(boolean0);
      // Undeclared exception!
      try { 
        BooleanUtils.toBoolean((Integer) null, integer0, integer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Integer did not match either specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test108()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean((Integer) null, (Integer) null, (Integer) null);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test109()  throws Throwable  {
      Integer integer0 = new Integer((-410));
      // Undeclared exception!
      try { 
        BooleanUtils.toBoolean(integer0, (Integer) null, (Integer) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Integer did not match either specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test110()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean(0, 472, 0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test111()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean(85, 85, 85);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test112()  throws Throwable  {
      // Undeclared exception!
      try { 
        BooleanUtils.toBoolean(151, (-394), 0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The Integer did not match either specified value
         //
         verifyException("org.apache.commons.lang3.BooleanUtils", e);
      }
  }

  @Test(timeout = 4000)
  public void test113()  throws Throwable  {
      Integer integer0 = new Integer((-2091073820));
      Boolean boolean0 = BooleanUtils.toBooleanObject(integer0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test114()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((Integer) null);
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test115()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Boolean boolean0 = BooleanUtils.toBooleanObject(integer0);
      assertFalse(boolean0);
      assertNotNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test116()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean(3832);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test117()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean(0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test118()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBooleanDefaultIfNull((Boolean) null, false);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test119()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject(85, 85, 3832, 85);
      boolean boolean1 = BooleanUtils.toBooleanDefaultIfNull(boolean0, true);
      assertTrue(boolean1);
  }

  @Test(timeout = 4000)
  public void test120()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((-1320));
      boolean boolean1 = BooleanUtils.toBoolean(boolean0);
      assertTrue(boolean1);
  }

  @Test(timeout = 4000)
  public void test121()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject(0);
      boolean boolean1 = BooleanUtils.toBoolean(boolean0);
      assertFalse(boolean1);
  }

  @Test(timeout = 4000)
  public void test122()  throws Throwable  {
      boolean boolean0 = BooleanUtils.toBoolean((Boolean) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test123()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject((-1320));
      boolean boolean1 = BooleanUtils.isNotFalse(boolean0);
      assertTrue(boolean1);
  }

  @Test(timeout = 4000)
  public void test124()  throws Throwable  {
      boolean boolean0 = BooleanUtils.isNotTrue((Boolean) null);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test125()  throws Throwable  {
      Boolean boolean0 = Boolean.valueOf(true);
      boolean boolean1 = BooleanUtils.isNotTrue(boolean0);
      assertFalse(boolean1);
  }

  @Test(timeout = 4000)
  public void test126()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject(85, 85, 3832, 85);
      Boolean boolean1 = BooleanUtils.negate(boolean0);
      assertFalse(boolean1);
  }

  @Test(timeout = 4000)
  public void test127()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.negate((Boolean) null);
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test128()  throws Throwable  {
      Boolean boolean0 = Boolean.FALSE;
      Boolean boolean1 = BooleanUtils.negate(boolean0);
      assertTrue(boolean1);
      assertNotNull(boolean1);
  }

  @Test(timeout = 4000)
  public void test129()  throws Throwable  {
      BooleanUtils booleanUtils0 = new BooleanUtils();
  }

  @Test(timeout = 4000)
  public void test130()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject(68);
      String string0 = BooleanUtils.toStringYesNo(boolean0);
      assertNotNull(string0);
      assertEquals("yes", string0);
  }

  @Test(timeout = 4000)
  public void test131()  throws Throwable  {
      boolean boolean0 = BooleanUtils.isNotFalse((Boolean) false);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test132()  throws Throwable  {
      Boolean boolean0 = new Boolean(true);
      boolean boolean1 = BooleanUtils.isTrue(boolean0);
      assertTrue(boolean1);
  }

  @Test(timeout = 4000)
  public void test133()  throws Throwable  {
      String string0 = BooleanUtils.toStringTrueFalse(false);
      assertEquals("false", string0);
  }

  @Test(timeout = 4000)
  public void test134()  throws Throwable  {
      Boolean boolean0 = BooleanUtils.toBooleanObject(4388, 4388, (-636), (-636));
      String string0 = BooleanUtils.toStringOnOff(boolean0);
      assertEquals("on", string0);
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test135()  throws Throwable  {
      String string0 = BooleanUtils.toStringOnOff(false);
      assertEquals("off", string0);
  }

  @Test(timeout = 4000)
  public void test136()  throws Throwable  {
      String string0 = BooleanUtils.toStringTrueFalse((Boolean) null);
      assertNull(string0);
  }
}
