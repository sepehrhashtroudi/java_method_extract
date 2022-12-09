@Before [EOL] public void setUp() throws FractionConversionException { [EOL]     javaMap.put(50, new Fraction(100.0)); [EOL]     javaMap.put(75, new Fraction(75.0)); [EOL]     javaMap.put(25, new Fraction(500.0)); [EOL]     javaMap.put(Integer.MAX_VALUE, new Fraction(Integer.MAX_VALUE)); [EOL]     javaMap.put(0, new Fraction(-1.0)); [EOL]     javaMap.put(1, new Fraction(0.0)); [EOL]     javaMap.put(33, new Fraction(-0.1)); [EOL]     javaMap.put(23234234, new Fraction(-242343.0)); [EOL]     javaMap.put(23321, new Fraction(Integer.MIN_VALUE)); [EOL]     javaMap.put(-4444, new Fraction(332.0)); [EOL]     javaMap.put(-1, new Fraction(-2323.0)); [EOL]     javaMap.put(Integer.MIN_VALUE, new Fraction(44.0)); [EOL]     javaMap.putAll(generate()); [EOL] } <line_num>: 43,61
private Map<Integer, Fraction> generate() { [EOL]     Map<Integer, Fraction> map = new HashMap<Integer, Fraction>(); [EOL]     Random r = new Random(); [EOL]     double dd = 0; [EOL]     for (int i = 0; i < 2000; ++i) dd = r.nextDouble(); [EOL]     try { [EOL]         map.put(r.nextInt(), new Fraction(dd)); [EOL]     } catch (FractionConversionException e) { [EOL]         throw new IllegalStateException("Invalid :" + dd, e); [EOL]     } [EOL]     return map; [EOL] } <line_num>: 63,75
private OpenIntToFieldHashMap<Fraction> createFromJavaMap(Field<Fraction> field) { [EOL]     OpenIntToFieldHashMap<Fraction> map = new OpenIntToFieldHashMap<Fraction>(field); [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : javaMap.entrySet()) { [EOL]         map.put(mapEntry.getKey(), mapEntry.getValue()); [EOL]     } [EOL]     return map; [EOL] } <line_num>: 77,83
@Test [EOL] public void testPutAndGetWith0ExpectedSize() { [EOL]     OpenIntToFieldHashMap<Fraction> map = new OpenIntToFieldHashMap<Fraction>(field, 0); [EOL]     assertPutAndGet(map); [EOL] } <line_num>: 85,89
@Test [EOL] public void testPutAndGetWithExpectedSize() { [EOL]     OpenIntToFieldHashMap<Fraction> map = new OpenIntToFieldHashMap<Fraction>(field, 500); [EOL]     assertPutAndGet(map); [EOL] } <line_num>: 91,95
@Test [EOL] public void testPutAndGet() { [EOL]     OpenIntToFieldHashMap<Fraction> map = new OpenIntToFieldHashMap<Fraction>(field); [EOL]     assertPutAndGet(map); [EOL] } <line_num>: 97,101
private void assertPutAndGet(OpenIntToFieldHashMap<Fraction> map) { [EOL]     assertPutAndGet(map, 0, new HashSet<Integer>()); [EOL] } <line_num>: 103,105
private void assertPutAndGet(OpenIntToFieldHashMap<Fraction> map, int mapSize, Set<Integer> keysInMap) { [EOL]     Assert.assertEquals(mapSize, map.size()); [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : javaMap.entrySet()) { [EOL]         map.put(mapEntry.getKey(), mapEntry.getValue()); [EOL]         if (!keysInMap.contains(mapEntry.getKey())) [EOL]             ++mapSize; [EOL]         Assert.assertEquals(mapSize, map.size()); [EOL]         Assert.assertEquals(mapEntry.getValue(), map.get(mapEntry.getKey())); [EOL]     } [EOL] } <line_num>: 107,117
@Test [EOL] public void testPutAbsentOnExisting() { [EOL]     OpenIntToFieldHashMap<Fraction> map = createFromJavaMap(field); [EOL]     int size = javaMap.size(); [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : generateAbsent().entrySet()) { [EOL]         map.put(mapEntry.getKey(), mapEntry.getValue()); [EOL]         Assert.assertEquals(++size, map.size()); [EOL]         Assert.assertEquals(mapEntry.getValue(), map.get(mapEntry.getKey())); [EOL]     } [EOL] } <line_num>: 119,128
@Test [EOL] public void testPutOnExisting() { [EOL]     OpenIntToFieldHashMap<Fraction> map = createFromJavaMap(field); [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : javaMap.entrySet()) { [EOL]         map.put(mapEntry.getKey(), mapEntry.getValue()); [EOL]         Assert.assertEquals(javaMap.size(), map.size()); [EOL]         Assert.assertEquals(mapEntry.getValue(), map.get(mapEntry.getKey())); [EOL]     } [EOL] } <line_num>: 130,138
@Test [EOL] public void testGetAbsent() { [EOL]     Map<Integer, Fraction> generated = generateAbsent(); [EOL]     OpenIntToFieldHashMap<Fraction> map = createFromJavaMap(field); [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : generated.entrySet()) Assert.assertTrue(field.getZero().equals(map.get(mapEntry.getKey()))); [EOL] } <line_num>: 140,147
@Test [EOL] public void testGetFromEmpty() { [EOL]     OpenIntToFieldHashMap<Fraction> map = new OpenIntToFieldHashMap<Fraction>(field); [EOL]     Assert.assertTrue(field.getZero().equals(map.get(5))); [EOL]     Assert.assertTrue(field.getZero().equals(map.get(0))); [EOL]     Assert.assertTrue(field.getZero().equals(map.get(50))); [EOL] } <line_num>: 149,155
@Test [EOL] public void testRemove() { [EOL]     OpenIntToFieldHashMap<Fraction> map = createFromJavaMap(field); [EOL]     int mapSize = javaMap.size(); [EOL]     Assert.assertEquals(mapSize, map.size()); [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : javaMap.entrySet()) { [EOL]         map.remove(mapEntry.getKey()); [EOL]         Assert.assertEquals(--mapSize, map.size()); [EOL]         Assert.assertTrue(field.getZero().equals(map.get(mapEntry.getKey()))); [EOL]     } [EOL]     assertPutAndGet(map); [EOL] } <line_num>: 157,170
@Test [EOL] public void testRemove2() { [EOL]     OpenIntToFieldHashMap<Fraction> map = createFromJavaMap(field); [EOL]     int mapSize = javaMap.size(); [EOL]     int count = 0; [EOL]     Set<Integer> keysInMap = new HashSet<Integer>(javaMap.keySet()); [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : javaMap.entrySet()) { [EOL]         keysInMap.remove(mapEntry.getKey()); [EOL]         map.remove(mapEntry.getKey()); [EOL]         Assert.assertEquals(--mapSize, map.size()); [EOL]         Assert.assertTrue(field.getZero().equals(map.get(mapEntry.getKey()))); [EOL]         if (count++ > 5) [EOL]             break; [EOL]     } [EOL]     assertPutAndGet(map, mapSize, keysInMap); [EOL] } <line_num>: 173,190
@Test [EOL] public void testRemoveFromEmpty() { [EOL]     OpenIntToFieldHashMap<Fraction> map = new OpenIntToFieldHashMap<Fraction>(field); [EOL]     Assert.assertTrue(field.getZero().equals(map.remove(50))); [EOL] } <line_num>: 192,196
@Test [EOL] public void testRemoveAbsent() { [EOL]     Map<Integer, Fraction> generated = generateAbsent(); [EOL]     OpenIntToFieldHashMap<Fraction> map = createFromJavaMap(field); [EOL]     int mapSize = map.size(); [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : generated.entrySet()) { [EOL]         map.remove(mapEntry.getKey()); [EOL]         Assert.assertEquals(mapSize, map.size()); [EOL]         Assert.assertTrue(field.getZero().equals(map.get(mapEntry.getKey()))); [EOL]     } [EOL] } <line_num>: 198,210
private Map<Integer, Fraction> generateAbsent() { [EOL]     Map<Integer, Fraction> generated = new HashMap<Integer, Fraction>(); [EOL]     do { [EOL]         generated.putAll(generate()); [EOL]         for (Integer key : javaMap.keySet()) generated.remove(key); [EOL]     } while (generated.size() < 100); [EOL]     return generated; [EOL] } <line_num>: 215,223
@Test [EOL] public void testCopy() { [EOL]     OpenIntToFieldHashMap<Fraction> copy = new OpenIntToFieldHashMap<Fraction>(createFromJavaMap(field)); [EOL]     Assert.assertEquals(javaMap.size(), copy.size()); [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : javaMap.entrySet()) Assert.assertEquals(mapEntry.getValue(), copy.get(mapEntry.getKey())); [EOL] } <line_num>: 225,233
@Test [EOL] public void testContainsKey() { [EOL]     OpenIntToFieldHashMap<Fraction> map = createFromJavaMap(field); [EOL]     for (Entry<Integer, Fraction> mapEntry : javaMap.entrySet()) { [EOL]         Assert.assertTrue(map.containsKey(mapEntry.getKey())); [EOL]     } [EOL]     for (Map.Entry<Integer, Fraction> mapEntry : generateAbsent().entrySet()) { [EOL]         Assert.assertFalse(map.containsKey(mapEntry.getKey())); [EOL]     } [EOL]     for (Entry<Integer, Fraction> mapEntry : javaMap.entrySet()) { [EOL]         int key = mapEntry.getKey(); [EOL]         Assert.assertTrue(map.containsKey(key)); [EOL]         map.remove(key); [EOL]         Assert.assertFalse(map.containsKey(key)); [EOL]     } [EOL] } <line_num>: 235,250
@Test [EOL] public void testIterator() { [EOL]     OpenIntToFieldHashMap<Fraction> map = createFromJavaMap(field); [EOL]     OpenIntToFieldHashMap<Fraction>.Iterator iterator = map.iterator(); [EOL]     for (int i = 0; i < map.size(); ++i) { [EOL]         Assert.assertTrue(iterator.hasNext()); [EOL]         iterator.advance(); [EOL]         int key = iterator.key(); [EOL]         Assert.assertTrue(map.containsKey(key)); [EOL]         Assert.assertEquals(javaMap.get(key), map.get(key)); [EOL]         Assert.assertEquals(javaMap.get(key), iterator.value()); [EOL]         Assert.assertTrue(javaMap.containsKey(key)); [EOL]     } [EOL]     Assert.assertFalse(iterator.hasNext()); [EOL]     try { [EOL]         iterator.advance(); [EOL]         Assert.fail("an exception should have been thrown"); [EOL]     } catch (NoSuchElementException nsee) { [EOL]     } [EOL] } <line_num>: 252,272
@Test [EOL] public void testConcurrentModification() { [EOL]     OpenIntToFieldHashMap<Fraction> map = createFromJavaMap(field); [EOL]     OpenIntToFieldHashMap<Fraction>.Iterator iterator = map.iterator(); [EOL]     map.put(3, new Fraction(3)); [EOL]     try { [EOL]         iterator.advance(); [EOL]         Assert.fail("an exception should have been thrown"); [EOL]     } catch (ConcurrentModificationException cme) { [EOL]     } [EOL] } <line_num>: 274,285
@Test [EOL] public void testPutKeysWithCollisions() { [EOL]     OpenIntToFieldHashMap<Fraction> map = new OpenIntToFieldHashMap<Fraction>(field); [EOL]     int key1 = -1996012590; [EOL]     Fraction value1 = new Fraction(1); [EOL]     map.put(key1, value1); [EOL]     int key2 = 835099822; [EOL]     map.put(key2, value1); [EOL]     int key3 = 1008859686; [EOL]     map.put(key3, value1); [EOL]     Assert.assertEquals(value1, map.get(key3)); [EOL]     Assert.assertEquals(3, map.size()); [EOL]     map.remove(key2); [EOL]     Fraction value2 = new Fraction(2); [EOL]     map.put(key3, value2); [EOL]     Assert.assertEquals(value2, map.get(key3)); [EOL]     Assert.assertEquals(2, map.size()); [EOL] } <line_num>: 292,310
@Test [EOL] public void testPutKeysWithCollision2() { [EOL]     OpenIntToFieldHashMap<Fraction> map = new OpenIntToFieldHashMap<Fraction>(field); [EOL]     int key1 = 837989881; [EOL]     Fraction value1 = new Fraction(1); [EOL]     map.put(key1, value1); [EOL]     int key2 = 476463321; [EOL]     map.put(key2, value1); [EOL]     Assert.assertEquals(2, map.size()); [EOL]     Assert.assertEquals(value1, map.get(key2)); [EOL]     map.remove(key1); [EOL]     Fraction value2 = new Fraction(2); [EOL]     map.put(key2, value2); [EOL]     Assert.assertEquals(1, map.size()); [EOL]     Assert.assertEquals(value2, map.get(key2)); [EOL] } <line_num>: 316,332
