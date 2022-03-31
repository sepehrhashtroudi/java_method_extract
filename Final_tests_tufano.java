@Test    public void testSetValue1()    {
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );    }

@Test    public void testSet2() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void testIsAllSet3() {
for (int i = 0; i < 10; i++) {
    bitField.getValue(i);
}    }
@Test    public void testIsSet4() {
for (int i = 0; i < 10; i++) {
    bitField.isSet(i);
}    }
@Test    public void testIsSet5() {
for (int i = 0; i < 10; i++) {
    bitField.isSet(i);
}    }
@Test    public void testSetValue6()    {
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );    }
@Test    public void testSet7() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShortValue() {
assertEquals((short) 0, bitField.getShortValue((short) 0));
assertEquals((short) 0, bitField.getShortValue((short) 0));
assertEquals((short) 0, bitField.getShortValue((short) 0));    }
@Test    public void testSet8() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShort() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void setShortValue() {
assertEquals((short) 0, bitField.getShortValue((short) 0));
assertEquals((short) 0, bitField.getShortValue((short) 0));
assertEquals((short) 0, bitField.getShortValue((short) 0));    }
@Test    public void testSet9() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShort() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void testSet10() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShort() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void setShortBoolean() {
assertEquals((short) 0, bitField.getShortValue(0));    }
@Test    public void testSet11() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShort() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void setShortBoolean() {
assertEquals((short) 0, bitField.getShortValue(0));    }
@Test    public void testSet12() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShort() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void testSet13() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShort() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void testSet14() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test  public void setByte() {    assertEquals((byte) 0, bitField.getValue((byte) 0));    assertEquals((byte) 0, bitField.getValue((byte) 0));  }
@Test    public void setByteBoolean() {
assertEquals((byte) 0, bitField.getShortValue(0));    }
@Test    public void testSet15() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test  public void setByte() {    assertEquals((byte) 0, bitField.getValue((byte) 0));    assertEquals((byte) 0, bitField.getValue((byte) 0));  }
@Test    public void setByteBoolean() {
assertEquals((byte) 0, bitField.getShortValue(0));    }
@Test    public void testSet16() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test  public void setByte() {    assertEquals((byte) 0, bitField.getValue((byte) 0));    assertEquals((byte) 0, bitField.getValue((byte) 0));  }
@Test    public void testSet17() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test  public void setByte() {    assertEquals((byte) 0, bitField.getValue((byte) 0));    assertEquals((byte) 0, bitField.getValue((byte) 0));  }
@Test    public void testSet18() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setBoolean() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void testSet19() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void testSet20() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test	public void testGetValue21() {		Assert.assertEquals(0, bitField.getValue(0));		Assert.assertEquals(1, bitField.getValue(1));	}
@Test	public void testGetValue22() {		Assert.assertEquals(0, bitField.getValue(0));		Assert.assertEquals(1, bitField.getValue(1));	}
@Test    public void testGetShortValue23() {
for (int i = 0; i < 10; i++) {
    bitField.getShortValue(i);
}    }
@Test    public void testGetShortValue24() {
for (int i = 0; i < 10; i++) {
    bitField.getShortValue(i);
}    }
@Test    public void testGetShortRawValue25() {
assertEquals((short) 0, bitField.getShortRawValue((short) 0));
assertEquals((short) 0, bitField.getShortRawValue((short) 0));
assertEquals((short) 0, bitField.getShortRawValue((short) 0));    }
@Test    public void testGetShortRawValue26() {
assertEquals((short) 0, bitField.getShortRawValue((short) 0));
assertEquals((short) 0, bitField.getShortRawValue((short) 0));
assertEquals((short) 0, bitField.getShortRawValue((short) 0));    }
@Test	public void testGetRawValue27() {		Assert.assertEquals(0, bitField.getValue(0));		Assert.assertEquals(1, bitField.getValue(1));	}
@Test	public void testGetRawValue28() {		Assert.assertEquals(0, bitField.getValue(0));		Assert.assertEquals(1, bitField.getValue(1));	}
@Test    public void testClear29() {
for (int i = 0; i < 10; i++) {
    bitField.clear(i);
}    }
@Test    public void testClearShort30() {
assertEquals((short) 0, bitField.getShortValue((short) 0));    }
@Test    public void testClear31() {
for (int i = 0; i < 10; i++) {
    bitField.clear(i);
}    }
@Test    public void testClearShort32() {
assertEquals((short) 0, bitField.getShortValue((short) 0));    }
@Test    public void testClear33() {
for (int i = 0; i < 10; i++) {
    bitField.clear(i);
}    }
@Test  public void testClearByte34() {    assertEquals((byte) 0, bitField.getValue((byte) 0));    assertEquals((byte) 0, bitField.getValue((byte) 0));  }
@Test    public void testClear35() {
for (int i = 0; i < 10; i++) {
    bitField.clear(i);
}    }
@Test  public void testClearByte36() {    assertEquals((byte) 0, bitField.getValue((byte) 0));    assertEquals((byte) 0, bitField.getValue((byte) 0));  }
@Test    public void testClear37() {
for (int i = 0; i < 10; i++) {
    bitField.clear(i);
}    }
@Test    public void testClear38() {
for (int i = 0; i < 10; i++) {
    bitField.clear(i);
}    }
@Test    public void testClear39() {
for (int i = 0; i < 10; i++) {
    bitField.clear(i);
}    }
@Test  public void testClearByte40() {    assertEquals((byte) 0, bitField.getValue((byte) 0));    assertEquals((byte) 0, bitField.getValue((byte) 0));  }
@Test    public void testSet41() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShort() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void testClear42() {
for (int i = 0; i < 10; i++) {
    bitField.clear(i);
}    }
@Test    public void testSet43() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test  public void setByte() {    assertEquals((byte) 0, bitField.getValue((byte) 0));    assertEquals((byte) 0, bitField.getValue((byte) 0));  }
@Test	public void testGetValue44() {		Assert.assertEquals(0, bitField.getValue(0));		Assert.assertEquals(1, bitField.getValue(1));	}
@Test    public void testSet45() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void testSetValue46()    {
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );
assertEquals( 0, bitField.getValue( 0, 0 ) );    }
@Test    public void testSet47() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void testClear48() {
for (int i = 0; i < 10; i++) {
    bitField.clear(i);
}    }
@Test    public void testClearShort49() {
assertEquals((short) 0, bitField.getShortValue((short) 0));    }
@Test	public void testGetRawValue50() {		Assert.assertEquals(0, bitField.getValue(0));		Assert.assertEquals(1, bitField.getValue(1));	}
@Test    public void testSet51() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setBoolean() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void testSet52() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setBoolean() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void testIsAllSet53() {
for (int i = 0; i < 10; i++) {
    bitField.getValue(i);
}    }
@Test    public void testIsAllSet54() {
for (int i = 0; i < 10; i++) {
    bitField.getValue(i);
}    }
@Test    public void testIsSet55() {
for (int i = 0; i < 10; i++) {
    bitField.isSet(i);
}    }
@Test    public void testGetShortRawValue56() {
assertEquals((short) 0, bitField.getShortRawValue((short) 0));
assertEquals((short) 0, bitField.getShortRawValue((short) 0));
assertEquals((short) 0, bitField.getShortRawValue((short) 0));    }
@Test    public void testSet57() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShort() {
assertEquals(0, bitField.getShortValue(0));    }
@Test    public void setShortBoolean() {
assertEquals((short) 0, bitField.getShortValue(0));    }
@Test    public void testSet58() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test  public void setByte() {    assertEquals((byte) 0, bitField.getValue((byte) 0));    assertEquals((byte) 0, bitField.getValue((byte) 0));  }
@Test    public void setByteBoolean() {
assertEquals((byte) 0, bitField.getShortValue(0));    }
@Test    public void testGetShortValue59() {
for (int i = 0; i < 10; i++) {
    bitField.getShortValue(i);
}    }
@Test    public void setShortValue() {
assertEquals((short) 0, bitField.getShortValue((short) 0));
assertEquals((short) 0, bitField.getShortValue((short) 0));
assertEquals((short) 0, bitField.getShortValue((short) 0));    }
@Test    public void testSet60() {
for (int i = 0; i < 10; i++) {
    bitField.set(i);
}    }
@Test    public void setShort() {
assertEquals(0, bitField.getShortValue(0));    }
@Test(expected = IllegalArgumentException.class)    public void testIllegalArgumentException61() throws Exception {
new Expectations() {
    {

new Expectations() {

      {


   result = true;

      }

}
   };
}
