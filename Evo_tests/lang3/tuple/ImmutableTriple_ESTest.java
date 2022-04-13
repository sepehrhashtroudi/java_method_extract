/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 14:01:42 GMT 2022
 */

package org.apache.commons.lang3.tuple;

import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ImmutableTriple_ESTest extends ImmutableTriple_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ImmutableTriple<Object, String, String> immutableTriple0 = ImmutableTriple.of((Object) null, "~s+Jv>4", "~s+Jv>4");
      Object object0 = immutableTriple0.getLeft();
      assertNull(object0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Integer integer0 = new Integer((-219));
      ImmutableTriple<Object, Integer, Integer> immutableTriple0 = new ImmutableTriple<Object, Integer, Integer>((Object) null, integer0, (Integer) null);
      Integer integer1 = immutableTriple0.getRight();
      assertNull(integer1);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ImmutableTriple<Object, Integer, String> immutableTriple0 = new ImmutableTriple<Object, Integer, String>((Object) null, (Integer) null, "org.apache.commons.lang3.tuple.MutableTriple");
      Integer integer0 = immutableTriple0.getMiddle();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Integer integer0 = new Integer(0);
      ImmutableTriple<Object, Object, Object> immutableTriple0 = ImmutableTriple.of((Object) null, (Object) integer0, (Object) null);
      Object object0 = immutableTriple0.getMiddle();
      assertEquals(0, object0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ImmutableTriple<String, Object, Object> immutableTriple0 = ImmutableTriple.of("", (Object) "", (Object) "Tp4`Fc{F/M=-)0 k");
      String string0 = immutableTriple0.getLeft();
      assertNotNull(string0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ImmutableTriple<Object, String, String> immutableTriple0 = new ImmutableTriple<Object, String, String>((Object) null, "org.apache.commons.lang3.tuple.ImmutableTriple", "org.apache.commons.lang3.tuple.ImmutableTriple");
      String string0 = immutableTriple0.getRight();
      assertEquals("org.apache.commons.lang3.tuple.ImmutableTriple", string0);
  }
}
