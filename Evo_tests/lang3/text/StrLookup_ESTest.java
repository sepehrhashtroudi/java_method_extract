/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 12 13:52:43 GMT 2022
 */

package org.apache.commons.lang3.text;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.StrLookup;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class StrLookup_ESTest extends StrLookup_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      HashMap<String, Object> hashMap0 = new HashMap<String, Object>();
      hashMap0.put("r", "r");
      StrLookup.MapStrLookup<Object> strLookup_MapStrLookup0 = new StrLookup.MapStrLookup<Object>(hashMap0);
      String string0 = strLookup_MapStrLookup0.lookup("r");
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      StrLookup.MapStrLookup<Integer> strLookup_MapStrLookup0 = new StrLookup.MapStrLookup<Integer>((Map<String, Integer>) null);
      String string0 = strLookup_MapStrLookup0.lookup("A70)5jCJ");
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      StrLookup<?> strLookup0 = StrLookup.noneLookup();
      assertNotNull(strLookup0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      StrLookup<String> strLookup0 = StrLookup.systemPropertiesLookup();
      // Undeclared exception!
      try { 
        strLookup0.lookup((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      HashMap<String, Object> hashMap0 = new HashMap<String, Object>();
      StrLookup<Object> strLookup0 = StrLookup.mapLookup((Map<String, Object>) hashMap0);
      assertNotNull(strLookup0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      HashMap<String, Object> hashMap0 = new HashMap<String, Object>();
      StrLookup.MapStrLookup<Object> strLookup_MapStrLookup0 = new StrLookup.MapStrLookup<Object>(hashMap0);
      String string0 = strLookup_MapStrLookup0.lookup("r");
      assertNull(string0);
  }
}
