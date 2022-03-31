/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 09 03:51:15 GMT 2021
 */

package org.apache.commons.lang3.builder;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ReflectionToStringBuilder_ESTest extends ReflectionToStringBuilder_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      LinkedList<String> linkedList0 = new LinkedList<String>();
      StandardToStringStyle standardToStringStyle0 = new StandardToStringStyle();
      String string0 = ReflectionToStringBuilder.toString((Object) linkedList0, (ToStringStyle) standardToStringStyle0, true, false);
      assertFalse(linkedList0.contains(string0));
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.MULTI_LINE_STYLE;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder("java.lang.String@1[value={h,],o,G,z,~,#,D,*,K},hash=-1470175597]", toStringStyle0, (StringBuffer) null);
      Class<Object> class0 = Object.class;
      reflectionToStringBuilder0.appendFieldsIn(class0);
      assertFalse(reflectionToStringBuilder0.isAppendStatics());
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Object object0 = new Object();
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      Class<Object> class0 = Object.class;
      String string0 = ReflectionToStringBuilder.toString(object0, toStringStyle0, true, true, (Class<? super Object>) class0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Object object0 = new Object();
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      String string0 = ReflectionToStringBuilder.toString(object0, toStringStyle0, true, true);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      Object object0 = new Object();
      String string0 = ReflectionToStringBuilder.toString(object0, toStringStyle0, true);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Object object0 = new Object();
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      String string0 = ReflectionToStringBuilder.toString(object0, toStringStyle0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Object object0 = new Object();
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(object0, toStringStyle0);
      reflectionToStringBuilder0.toString();
      assertFalse(reflectionToStringBuilder0.isAppendStatics());
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      LinkedList<String> linkedList0 = new LinkedList<String>();
      String[] stringArray0 = ReflectionToStringBuilder.toNoNullStringArray(linkedList0);
      String[] stringArray1 = ReflectionToStringBuilder.toNoNullStringArray(stringArray0);
      assertEquals(0, stringArray1.length);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      LinkedList<String> linkedList0 = new LinkedList<String>();
      linkedList0.add("bA'rZ-*CMNc~eS");
      String[] stringArray0 = ReflectionToStringBuilder.toNoNullStringArray(linkedList0);
      String[] stringArray1 = ReflectionToStringBuilder.toNoNullStringArray(stringArray0);
      assertEquals(1, stringArray1.length);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Integer integer0 = new Integer(895);
      ToStringStyle toStringStyle0 = ToStringBuilder.getDefaultStyle();
      StringBuffer stringBuffer0 = new StringBuffer("");
      Class<Integer> class0 = Integer.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(integer0, toStringStyle0, stringBuffer0, (Class<? super Integer>) class0, true, true);
      boolean boolean0 = reflectionToStringBuilder0.isAppendTransients();
      assertTrue(boolean0);
      assertTrue(reflectionToStringBuilder0.isAppendStatics());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(toStringStyle0, toStringStyle0);
      boolean boolean0 = reflectionToStringBuilder0.isAppendStatics();
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Object object0 = new Object();
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(object0);
      reflectionToStringBuilder0.getUpToClass();
      assertFalse(reflectionToStringBuilder0.isAppendStatics());
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(toStringStyle0, toStringStyle0);
      String[] stringArray0 = new String[3];
      stringArray0[0] = "";
      reflectionToStringBuilder0.setExcludeFieldNames(stringArray0);
      String[] stringArray1 = reflectionToStringBuilder0.getExcludeFieldNames();
      assertEquals(1, stringArray1.length);
      assertFalse(reflectionToStringBuilder0.isAppendStatics());
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.DEFAULT_STYLE;
      Class<Object> class0 = Object.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder((Object) "<null>", toStringStyle0, (StringBuffer) null, (Class<? super Object>) class0, true, true);
      String[] stringArray0 = new String[0];
      ReflectionToStringBuilder reflectionToStringBuilder1 = reflectionToStringBuilder0.setExcludeFieldNames(stringArray0);
      reflectionToStringBuilder1.getExcludeFieldNames();
      assertTrue(reflectionToStringBuilder1.isAppendStatics());
      assertTrue(reflectionToStringBuilder1.isAppendTransients());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringBuilder.getDefaultStyle();
      StringBuffer stringBuffer0 = new StringBuffer(3590);
      String string0 = ReflectionToStringBuilder.toString((Object) stringBuffer0, toStringStyle0);
      // Undeclared exception!
      ReflectionToStringBuilder.toString((Object) string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      // Undeclared exception!
      try { 
        ReflectionToStringBuilder.toNoNullStringArray((Object[]) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.builder.ReflectionToStringBuilder", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.MULTI_LINE_STYLE;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder("java.lang.Integer@1[value=0]value=0]", toStringStyle0);
      // Undeclared exception!
      try { 
        reflectionToStringBuilder0.reflectionAppendArray((Object) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.lang.reflect.Array", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Integer integer0 = new Integer((-1159));
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(integer0);
      // Undeclared exception!
      try { 
        reflectionToStringBuilder0.getValue((Field) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.builder.ReflectionToStringBuilder", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.SHORT_PREFIX_STYLE;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder((Object) null, toStringStyle0);
      Class<Integer> class0 = Integer.class;
      // Undeclared exception!
      try { 
        reflectionToStringBuilder0.appendFieldsIn(class0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.DEFAULT_STYLE;
      Class<Object> class0 = Object.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder((Object) "<null>", toStringStyle0, (StringBuffer) null, (Class<? super Object>) class0, true, true);
      Class<Integer> class1 = Integer.class;
      // Undeclared exception!
      try { 
        reflectionToStringBuilder0.appendFieldsIn(class1);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.MULTI_LINE_STYLE;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder("java.lang.String@1[value={h,],o,G,z,~,#,D,*,K},hash=-1470175597]", toStringStyle0, (StringBuffer) null);
      // Undeclared exception!
      try { 
        reflectionToStringBuilder0.accept((Field) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.builder.ReflectionToStringBuilder", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Integer integer0 = new Integer(895);
      ToStringStyle toStringStyle0 = ToStringBuilder.getDefaultStyle();
      StringBuffer stringBuffer0 = new StringBuffer("");
      Class<Integer> class0 = Integer.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(integer0, toStringStyle0, stringBuffer0, (Class<? super Integer>) class0, true, true);
      reflectionToStringBuilder0.toString();
      assertEquals(717, stringBuffer0.length());
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Integer integer0 = new Integer(2438);
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(integer0);
      reflectionToStringBuilder0.toString();
      assertFalse(reflectionToStringBuilder0.isAppendStatics());
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.SHORT_PREFIX_STYLE;
      StringBuffer stringBuffer0 = new StringBuffer((CharSequence) "bA'rZ-*CMNc~eS");
      Class<Object> class0 = Object.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder((Integer) null, toStringStyle0, stringBuffer0, (Class<? super Integer>) class0, false, true);
      reflectionToStringBuilder0.toString();
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
      assertTrue(reflectionToStringBuilder0.isAppendStatics());
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      StringBuffer stringBuffer0 = new StringBuffer("");
      Class<Object> class0 = Object.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder((Object) null, toStringStyle0, stringBuffer0, (Class<? super Object>) class0, true, true);
      reflectionToStringBuilder0.setUpToClass(class0);
      assertTrue(reflectionToStringBuilder0.isAppendTransients());
      assertTrue(reflectionToStringBuilder0.isAppendStatics());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Object object0 = new Object();
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(object0);
      Class<Object> class0 = Object.class;
      reflectionToStringBuilder0.setUpToClass(class0);
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
      assertFalse(reflectionToStringBuilder0.isAppendStatics());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Object object0 = new Object();
      StandardToStringStyle standardToStringStyle0 = new StandardToStringStyle();
      StringBuffer stringBuffer0 = new StringBuffer("[dYPE");
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(object0, standardToStringStyle0, stringBuffer0);
      reflectionToStringBuilder0.setUpToClass((Class<?>) null);
      assertFalse(reflectionToStringBuilder0.isAppendStatics());
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      StandardToStringStyle standardToStringStyle0 = new StandardToStringStyle();
      StringBuffer stringBuffer0 = new StringBuffer("org.apache.commons.lang3.builder.ReflectionToStringBuilder");
      Class<String> class0 = String.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder("org.apache.commons.lang3.builder.ReflectionToStringBuilder", (ToStringStyle) standardToStringStyle0, stringBuffer0, (Class<? super String>) class0, true, true);
      reflectionToStringBuilder0.getUpToClass();
      assertTrue(reflectionToStringBuilder0.isAppendTransients());
      assertTrue(reflectionToStringBuilder0.isAppendStatics());
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Integer integer0 = new Integer(5);
      ToStringStyle toStringStyle0 = ToStringStyle.DEFAULT_STYLE;
      StringBuffer stringBuffer0 = new StringBuffer(5);
      Class<Object> class0 = Object.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder((Object) integer0, toStringStyle0, stringBuffer0, (Class<? super Object>) class0, false, true);
      boolean boolean0 = reflectionToStringBuilder0.isAppendStatics();
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.SHORT_PREFIX_STYLE;
      StringBuffer stringBuffer0 = new StringBuffer((CharSequence) "bA'rZ-*CMNc~eS");
      Class<Object> class0 = Object.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder((Integer) null, toStringStyle0, stringBuffer0, (Class<? super Integer>) class0, false, true);
      reflectionToStringBuilder0.setAppendStatics(true);
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
      assertTrue(reflectionToStringBuilder0.isAppendStatics());
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder("JmK~r2Q<Hg>.");
      assertFalse(reflectionToStringBuilder0.isAppendTransients());
      
      reflectionToStringBuilder0.setAppendTransients(true);
      assertTrue(reflectionToStringBuilder0.isAppendTransients());
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Integer integer0 = new Integer((-1159));
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(integer0);
      boolean boolean0 = reflectionToStringBuilder0.isAppendTransients();
      assertFalse(boolean0);
      assertFalse(reflectionToStringBuilder0.isAppendStatics());
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      String[] stringArray0 = new String[7];
      String string0 = ReflectionToStringBuilder.toStringExclude((Object) "<null>", stringArray0);
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      Integer integer0 = new Integer(36);
      Class<Integer> class0 = Integer.class;
      String string0 = ReflectionToStringBuilder.toString(integer0, toStringStyle0, true, true, (Class<? super Integer>) class0);
      assertEquals("36,1360826667806852920,4,2147483647,-2147483648,32,int,{0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9},{0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9},{0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z},{9,99,999,9999,99999,999999,9999999,99999999,999999999,2147483647}", string0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Object object0 = new Object();
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(object0);
      Class<String> class0 = String.class;
      // Undeclared exception!
      try { 
        reflectionToStringBuilder0.setUpToClass(class0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Specified class is not a superclass of the object
         //
         verifyException("org.apache.commons.lang3.builder.ReflectionToStringBuilder", e);
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Integer integer0 = new Integer(5);
      ToStringStyle toStringStyle0 = ToStringStyle.DEFAULT_STYLE;
      StringBuffer stringBuffer0 = new StringBuffer(5);
      Class<Object> class0 = Object.class;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder((Object) integer0, toStringStyle0, stringBuffer0, (Class<? super Object>) class0, false, true);
      reflectionToStringBuilder0.setExcludeFieldNames((String[]) null);
      //  // Unstable assertion: assertEquals(753, stringBuffer0.length());
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      LinkedList<String> linkedList0 = new LinkedList<String>();
      String string0 = ReflectionToStringBuilder.toString((Object) linkedList0);
      assertFalse(linkedList0.contains(string0));
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringBuilder.getDefaultStyle();
      Class<String> class0 = String.class;
      String string0 = ReflectionToStringBuilder.toString((String) null, toStringStyle0, true, true, (Class<? super String>) class0);
      LinkedList<String> linkedList0 = new LinkedList<String>();
      String string1 = ReflectionToStringBuilder.toStringExclude((Object) string0, (Collection<String>) linkedList0);
      assertFalse(string1.equals((Object)string0));
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Integer integer0 = new Integer((-74));
      ToStringStyle toStringStyle0 = ToStringStyle.SHORT_PREFIX_STYLE;
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder("java.lang.Integer@1[value=-74]value=-74]", toStringStyle0);
      // Undeclared exception!
      try { 
        reflectionToStringBuilder0.reflectionAppendArray(integer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Argument is not an array
         //
         verifyException("java.lang.reflect.Array", e);
      }
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringStyle.SIMPLE_STYLE;
      String string0 = ReflectionToStringBuilder.toString((Object) "%S", toStringStyle0, true);
      //  // Unstable assertion: assertEquals("{%,S},1230", string0);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder((Object) null, (ToStringStyle) null);
      // Undeclared exception!
      try { 
        reflectionToStringBuilder0.getExcludeFieldNames();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.builder.ReflectionToStringBuilder", e);
      }
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      ToStringStyle toStringStyle0 = ToStringBuilder.getDefaultStyle();
      StringBuffer stringBuffer0 = new StringBuffer(18);
      ReflectionToStringBuilder reflectionToStringBuilder0 = new ReflectionToStringBuilder(toStringStyle0, toStringStyle0, stringBuffer0);
      String[] stringArray0 = new String[7];
      ReflectionToStringBuilder reflectionToStringBuilder1 = reflectionToStringBuilder0.setExcludeFieldNames(stringArray0);
      reflectionToStringBuilder1.toString();
      String string0 = ReflectionToStringBuilder.toString((Object) stringBuffer0, toStringStyle0, true, true);
      LinkedList<String> linkedList0 = new LinkedList<String>();
      // Undeclared exception!
      ReflectionToStringBuilder.toStringExclude((Object) string0, (Collection<String>) linkedList0);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      Integer integer0 = new Integer((-74));
      String string0 = ReflectionToStringBuilder.toStringExclude((Object) integer0, (Collection<String>) null);
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      HashMap<String, Object> hashMap0 = new HashMap<String, Object>();
      Set<String> set0 = hashMap0.keySet();
      ToStringStyle toStringStyle0 = ToStringStyle.MULTI_LINE_STYLE;
      String string0 = ReflectionToStringBuilder.toString((Object) set0, toStringStyle0);
      assertFalse(set0.contains(string0));
  }
}
