public DummyChromosome() { [EOL]     this.fitness = counter; [EOL]     counter++; [EOL] } <line_num>: 95,98
@Test [EOL] public void testNextGeneration() { [EOL]     ElitisticListPopulation pop = new ElitisticListPopulation(100, 0.203); [EOL]     for (int i = 0; i < pop.getPopulationLimit(); i++) { [EOL]         pop.addChromosome(new DummyChromosome()); [EOL]     } [EOL]     Population nextGeneration = pop.nextGeneration(); [EOL]     Assert.assertEquals(20, nextGeneration.getPopulationSize()); [EOL] } <line_num>: 31,42
@Test [EOL] public void testSetElitismRate() { [EOL]     final double rate = 0.25; [EOL]     final ElitisticListPopulation pop = new ElitisticListPopulation(100, 0.203); [EOL]     pop.setElitismRate(rate); [EOL]     Assert.assertEquals(rate, pop.getElitismRate(), 1e-6); [EOL] } <line_num>: 44,50
@Test(expected = OutOfRangeException.class) [EOL] public void testSetElitismRateTooLow() { [EOL]     final double rate = -0.25; [EOL]     final ElitisticListPopulation pop = new ElitisticListPopulation(100, 0.203); [EOL]     pop.setElitismRate(rate); [EOL] } <line_num>: 52,57
@Test(expected = OutOfRangeException.class) [EOL] public void testSetElitismRateTooHigh() { [EOL]     final double rate = 1.25; [EOL]     final ElitisticListPopulation pop = new ElitisticListPopulation(100, 0.203); [EOL]     pop.setElitismRate(rate); [EOL] } <line_num>: 59,64
@Test(expected = OutOfRangeException.class) [EOL] public void testConstructorTooLow() { [EOL]     final double rate = -0.25; [EOL]     new ElitisticListPopulation(100, rate); [EOL] } <line_num>: 66,70
@Test(expected = OutOfRangeException.class) [EOL] public void testConstructorTooHigh() { [EOL]     final double rate = 1.25; [EOL]     new ElitisticListPopulation(100, rate); [EOL] } <line_num>: 72,76
@Test(expected = OutOfRangeException.class) [EOL] public void testChromosomeListConstructorTooLow() { [EOL]     final List<Chromosome> chromosomes = Collections.emptyList(); [EOL]     final double rate = -0.25; [EOL]     new ElitisticListPopulation(chromosomes, 100, rate); [EOL] } <line_num>: 78,83
@Test(expected = OutOfRangeException.class) [EOL] public void testChromosomeListConstructorTooHigh() { [EOL]     final List<Chromosome> chromosomes = Collections.emptyList(); [EOL]     final double rate = 1.25; [EOL]     new ElitisticListPopulation(chromosomes, 100, rate); [EOL] } <line_num>: 85,90
public double fitness() { [EOL]     return this.fitness; [EOL] } <line_num>: 100,102