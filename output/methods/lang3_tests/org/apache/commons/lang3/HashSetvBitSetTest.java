@Test [EOL] public void testTimes() { [EOL]     timeHashSet(10); [EOL]     timeBitSet(10); [EOL]     long timeDiff = printTimes(0); [EOL]     timeDiff += printTimes(5); [EOL]     timeDiff += printTimes(10); [EOL]     timeDiff += printTimes(200); [EOL]     timeDiff += printTimes(50); [EOL]     timeDiff += printTimes(100); [EOL]     timeDiff += printTimes(1000); [EOL]     timeDiff += printTimes(2000); [EOL]     Assert.assertTrue(timeDiff <= 0); [EOL] } <line_num>: 33,46
private long printTimes(final int count) { [EOL]     final long hashSet = timeHashSet(count); [EOL]     final long bitSet = timeBitSet(count); [EOL]     System.out.println("Ratio=" + (bitSet * 100 / hashSet) + "% count=" + count + " hash=" + hashSet + " bits=" + bitSet); [EOL]     return bitSet - hashSet; [EOL] } <line_num>: 51,57
private static long timeHashSet(final int count) { [EOL]     int[] result = new int[0]; [EOL]     final long start = System.nanoTime(); [EOL]     for (int i = 0; i < LOOPS; i++) { [EOL]         result = testHashSet(count); [EOL]     } [EOL]     final long elapsed = System.nanoTime() - start; [EOL]     Assert.assertEquals(count, result.length); [EOL]     return elapsed; [EOL] } <line_num>: 59,68
private static long timeBitSet(final int count) { [EOL]     int[] result = new int[0]; [EOL]     final long start = System.nanoTime(); [EOL]     for (int i = 0; i < LOOPS; i++) { [EOL]         result = testBitSet(count); [EOL]     } [EOL]     final long elapsed = System.nanoTime() - start; [EOL]     Assert.assertEquals(count, result.length); [EOL]     return elapsed; [EOL] } <line_num>: 70,79
@SuppressWarnings("boxing") [EOL] private static int[] testHashSet(final int count) { [EOL]     final HashSet<Integer> toRemove = new HashSet<Integer>(); [EOL]     int found = 0; [EOL]     for (int i = 0; i < count; i++) { [EOL]         toRemove.add(found++); [EOL]     } [EOL]     return extractIndices(toRemove); [EOL] } <line_num>: 81,89
private static int[] testBitSet(final int count) { [EOL]     final BitSet toRemove = new BitSet(); [EOL]     int found = 0; [EOL]     for (int i = 0; i < count; i++) { [EOL]         toRemove.set(found++); [EOL]     } [EOL]     return extractIndices(toRemove); [EOL] } <line_num>: 91,98
private static int[] extractIndices(final HashSet<Integer> coll) { [EOL]     final int[] result = new int[coll.size()]; [EOL]     int i = 0; [EOL]     for (final Integer index : coll) { [EOL]         result[i++] = index.intValue(); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 101,108
private static int[] extractIndices(final BitSet coll) { [EOL]     final int[] result = new int[coll.cardinality()]; [EOL]     int i = 0; [EOL]     int j = 0; [EOL]     while ((j = coll.nextSetBit(j)) != -1) { [EOL]         result[i++] = j++; [EOL]     } [EOL]     return result; [EOL] } <line_num>: 110,118
@Test [EOL] public void testTimesExtractOrBitset() { [EOL]     final BitSet toRemove = new BitSet(); [EOL]     final int[] array = new int[100]; [EOL]     toRemove.set(10, 20); [EOL]     timeBitSetRemoveAll(array, toRemove); [EOL]     timeExtractRemoveAll(array, toRemove); [EOL]     long timeDiff = printTimes(100, 1); [EOL]     timeDiff += printTimes(100, 10); [EOL]     timeDiff += printTimes(100, 50); [EOL]     timeDiff += printTimes(100, 100); [EOL]     timeDiff += printTimes(1000, 10); [EOL]     timeDiff += printTimes(1000, 100); [EOL]     timeDiff += printTimes(1000, 500); [EOL]     timeDiff += printTimes(1000, 1000); [EOL]     Assert.assertTrue(timeDiff <= 0); [EOL] } <line_num>: 120,136
private long printTimes(final int arraySize, final int bitSetSize) { [EOL]     final int[] array = new int[arraySize]; [EOL]     final BitSet remove = new BitSet(); [EOL]     for (int i = 0; i < bitSetSize; i++) { [EOL]         remove.set(i); [EOL]     } [EOL]     final long bitSet = timeBitSetRemoveAll(array, remove); [EOL]     final long extract = timeExtractRemoveAll(array, remove); [EOL]     System.out.println("Ratio=" + (bitSet * 100 / extract) + "% array=" + array.length + " count=" + remove.cardinality() + " extract=" + extract + " bitset=" + bitSet); [EOL]     return bitSet - extract; [EOL] } <line_num>: 138,149
private long timeBitSetRemoveAll(final int[] array, final BitSet toRemove) { [EOL]     int[] output = new int[0]; [EOL]     final long start = System.nanoTime(); [EOL]     for (int i = 0; i < LOOPS2; i++) { [EOL]         output = (int[]) ArrayUtils.removeAll(array, toRemove); [EOL]     } [EOL]     final long end = System.nanoTime(); [EOL]     Assert.assertEquals(array.length - toRemove.cardinality(), output.length); [EOL]     return end - start; [EOL] } <line_num>: 151,160
private long timeExtractRemoveAll(final int[] array, final BitSet toRemove) { [EOL]     int[] output = new int[0]; [EOL]     final long start = System.nanoTime(); [EOL]     for (int i = 0; i < LOOPS2; i++) { [EOL]         final int[] extractIndices = extractIndices(toRemove); [EOL]         output = (int[]) ArrayUtils.removeAll((Object) array, extractIndices); [EOL]     } [EOL]     final long end = System.nanoTime(); [EOL]     Assert.assertEquals(array.length - toRemove.cardinality(), output.length); [EOL]     return end - start; [EOL] } <line_num>: 162,172
