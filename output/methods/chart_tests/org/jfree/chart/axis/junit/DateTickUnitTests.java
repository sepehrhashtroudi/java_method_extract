public DateTickUnitTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 77,79
public static Test suite() { [EOL]     return new TestSuite(DateTickUnitTests.class); [EOL] } <line_num>: 68,70
public void testEquals() { [EOL]     DateTickUnit t1 = new DateTickUnit(DateTickUnitType.DAY, 1); [EOL]     DateTickUnit t2 = new DateTickUnit(DateTickUnitType.DAY, 1); [EOL]     assertTrue(t1.equals(t2)); [EOL] } <line_num>: 84,88
public void testHashCode() { [EOL]     DateTickUnit t1 = new DateTickUnit(DateTickUnitType.DAY, 1); [EOL]     DateTickUnit t2 = new DateTickUnit(DateTickUnitType.DAY, 1); [EOL]     assertTrue(t1.equals(t2)); [EOL]     int h1 = t1.hashCode(); [EOL]     int h2 = t2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 93,100
public void testSerialization() { [EOL]     DateTickUnit a1 = new DateTickUnit(DateTickUnitType.DAY, 7); [EOL]     DateTickUnit a2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(a1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         a2 = (DateTickUnit) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(a1, a2); [EOL] } <line_num>: 105,126
