@Test [EOL] public void testContains() throws MathArithmeticException { [EOL]     Plane p = new Plane(new Vector3D(0, 0, 1), new Vector3D(0, 0, 1)); [EOL]     Assert.assertTrue(p.contains(new Vector3D(0, 0, 1))); [EOL]     Assert.assertTrue(p.contains(new Vector3D(17, -32, 1))); [EOL]     Assert.assertTrue(!p.contains(new Vector3D(17, -32, 1.001))); [EOL] } <line_num>: 30,36
@Test [EOL] public void testOffset() throws MathArithmeticException { [EOL]     Vector3D p1 = new Vector3D(1, 1, 1); [EOL]     Plane p = new Plane(p1, new Vector3D(0.2, 0, 0)); [EOL]     Assert.assertEquals(-5.0, p.getOffset(new Vector3D(-4, 0, 0)), 1.0e-10); [EOL]     Assert.assertEquals(+5.0, p.getOffset(new Vector3D(6, 10, -12)), 1.0e-10); [EOL]     Assert.assertEquals(0.3, p.getOffset(new Vector3D(1.0, p1, 0.3, p.getNormal())), 1.0e-10); [EOL]     Assert.assertEquals(-0.3, p.getOffset(new Vector3D(1.0, p1, -0.3, p.getNormal())), 1.0e-10); [EOL] } <line_num>: 38,50
@Test [EOL] public void testPoint() throws MathArithmeticException { [EOL]     Plane p = new Plane(new Vector3D(2, -3, 1), new Vector3D(1, 4, 9)); [EOL]     Assert.assertTrue(p.contains(p.getOrigin())); [EOL] } <line_num>: 52,56
@Test [EOL] public void testThreePoints() throws MathArithmeticException { [EOL]     Vector3D p1 = new Vector3D(1.2, 3.4, -5.8); [EOL]     Vector3D p2 = new Vector3D(3.4, -5.8, 1.2); [EOL]     Vector3D p3 = new Vector3D(-2.0, 4.3, 0.7); [EOL]     Plane p = new Plane(p1, p2, p3); [EOL]     Assert.assertTrue(p.contains(p1)); [EOL]     Assert.assertTrue(p.contains(p2)); [EOL]     Assert.assertTrue(p.contains(p3)); [EOL] } <line_num>: 58,67
@Test [EOL] public void testRotate() throws MathArithmeticException, MathIllegalArgumentException { [EOL]     Vector3D p1 = new Vector3D(1.2, 3.4, -5.8); [EOL]     Vector3D p2 = new Vector3D(3.4, -5.8, 1.2); [EOL]     Vector3D p3 = new Vector3D(-2.0, 4.3, 0.7); [EOL]     Plane p = new Plane(p1, p2, p3); [EOL]     Vector3D oldNormal = p.getNormal(); [EOL]     p = p.rotate(p2, new Rotation(p2.subtract(p1), 1.7)); [EOL]     Assert.assertTrue(p.contains(p1)); [EOL]     Assert.assertTrue(p.contains(p2)); [EOL]     Assert.assertTrue(!p.contains(p3)); [EOL]     p = p.rotate(p2, new Rotation(oldNormal, 0.1)); [EOL]     Assert.assertTrue(!p.contains(p1)); [EOL]     Assert.assertTrue(p.contains(p2)); [EOL]     Assert.assertTrue(!p.contains(p3)); [EOL]     p = p.rotate(p1, new Rotation(oldNormal, 0.1)); [EOL]     Assert.assertTrue(!p.contains(p1)); [EOL]     Assert.assertTrue(!p.contains(p2)); [EOL]     Assert.assertTrue(!p.contains(p3)); [EOL] } <line_num>: 69,92
@Test [EOL] public void testTranslate() throws MathArithmeticException { [EOL]     Vector3D p1 = new Vector3D(1.2, 3.4, -5.8); [EOL]     Vector3D p2 = new Vector3D(3.4, -5.8, 1.2); [EOL]     Vector3D p3 = new Vector3D(-2.0, 4.3, 0.7); [EOL]     Plane p = new Plane(p1, p2, p3); [EOL]     p = p.translate(new Vector3D(2.0, p.getU(), -1.5, p.getV())); [EOL]     Assert.assertTrue(p.contains(p1)); [EOL]     Assert.assertTrue(p.contains(p2)); [EOL]     Assert.assertTrue(p.contains(p3)); [EOL]     p = p.translate(new Vector3D(-1.2, p.getNormal())); [EOL]     Assert.assertTrue(!p.contains(p1)); [EOL]     Assert.assertTrue(!p.contains(p2)); [EOL]     Assert.assertTrue(!p.contains(p3)); [EOL]     p = p.translate(new Vector3D(+1.2, p.getNormal())); [EOL]     Assert.assertTrue(p.contains(p1)); [EOL]     Assert.assertTrue(p.contains(p2)); [EOL]     Assert.assertTrue(p.contains(p3)); [EOL] } <line_num>: 94,116
@Test [EOL] public void testIntersection() throws MathArithmeticException, MathIllegalArgumentException { [EOL]     Plane p = new Plane(new Vector3D(1, 2, 3), new Vector3D(-4, 1, -5)); [EOL]     Line l = new Line(new Vector3D(0.2, -3.5, 0.7), new Vector3D(1.2, -2.5, -0.3)); [EOL]     Vector3D point = p.intersection(l); [EOL]     Assert.assertTrue(p.contains(point)); [EOL]     Assert.assertTrue(l.contains(point)); [EOL]     Assert.assertNull(p.intersection(new Line(new Vector3D(10, 10, 10), new Vector3D(10, 10, 10).add(p.getNormal().orthogonal())))); [EOL] } <line_num>: 118,127
@Test [EOL] public void testIntersection2() throws MathArithmeticException { [EOL]     Vector3D p1 = new Vector3D(1.2, 3.4, -5.8); [EOL]     Vector3D p2 = new Vector3D(3.4, -5.8, 1.2); [EOL]     Plane pA = new Plane(p1, p2, new Vector3D(-2.0, 4.3, 0.7)); [EOL]     Plane pB = new Plane(p1, new Vector3D(11.4, -3.8, 5.1), p2); [EOL]     Line l = pA.intersection(pB); [EOL]     Assert.assertTrue(l.contains(p1)); [EOL]     Assert.assertTrue(l.contains(p2)); [EOL]     Assert.assertNull(pA.intersection(pA)); [EOL] } <line_num>: 129,139
@Test [EOL] public void testIntersection3() throws MathArithmeticException { [EOL]     Vector3D reference = new Vector3D(1.2, 3.4, -5.8); [EOL]     Plane p1 = new Plane(reference, new Vector3D(1, 3, 3)); [EOL]     Plane p2 = new Plane(reference, new Vector3D(-2, 4, 0)); [EOL]     Plane p3 = new Plane(reference, new Vector3D(7, 0, -4)); [EOL]     Vector3D p = Plane.intersection(p1, p2, p3); [EOL]     Assert.assertEquals(reference.getX(), p.getX(), 1.0e-10); [EOL]     Assert.assertEquals(reference.getY(), p.getY(), 1.0e-10); [EOL]     Assert.assertEquals(reference.getZ(), p.getZ(), 1.0e-10); [EOL] } <line_num>: 141,151
@Test [EOL] public void testSimilar() throws MathArithmeticException { [EOL]     Vector3D p1 = new Vector3D(1.2, 3.4, -5.8); [EOL]     Vector3D p2 = new Vector3D(3.4, -5.8, 1.2); [EOL]     Vector3D p3 = new Vector3D(-2.0, 4.3, 0.7); [EOL]     Plane pA = new Plane(p1, p2, p3); [EOL]     Plane pB = new Plane(p1, new Vector3D(11.4, -3.8, 5.1), p2); [EOL]     Assert.assertTrue(!pA.isSimilarTo(pB)); [EOL]     Assert.assertTrue(pA.isSimilarTo(pA)); [EOL]     Assert.assertTrue(pA.isSimilarTo(new Plane(p1, p3, p2))); [EOL]     Vector3D shift = new Vector3D(0.3, pA.getNormal()); [EOL]     Assert.assertTrue(!pA.isSimilarTo(new Plane(p1.add(shift), p3.add(shift), p2.add(shift)))); [EOL] } <line_num>: 153,167