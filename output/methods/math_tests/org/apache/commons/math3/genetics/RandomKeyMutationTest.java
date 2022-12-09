@Test [EOL] public void testMutate() { [EOL]     MutationPolicy mutation = new RandomKeyMutation(); [EOL]     int l = 10; [EOL]     for (int i = 0; i < 20; i++) { [EOL]         DummyRandomKey origRk = new DummyRandomKey(RandomKey.randomPermutation(l)); [EOL]         Chromosome mutated = mutation.mutate(origRk); [EOL]         DummyRandomKey mutatedRk = (DummyRandomKey) mutated; [EOL]         int changes = 0; [EOL]         for (int j = 0; j < origRk.getLength(); j++) { [EOL]             if (origRk.getRepresentation().get(j) != mutatedRk.getRepresentation().get(j)) { [EOL]                 changes++; [EOL]             } [EOL]         } [EOL]         Assert.assertEquals(1, changes); [EOL]     } [EOL] } <line_num>: 25,42
