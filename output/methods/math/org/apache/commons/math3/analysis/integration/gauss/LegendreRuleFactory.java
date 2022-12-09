@Override [EOL] protected Pair<Double[], Double[]> computeRule(int numberOfPoints) throws DimensionMismatchException { [EOL]     if (numberOfPoints == 1) { [EOL]         return new Pair<Double[], Double[]>(new Double[] { 0d }, new Double[] { 2d }); [EOL]     } [EOL]     final Double[] previousPoints = getRuleInternal(numberOfPoints - 1).getFirst(); [EOL]     final Double[] points = new Double[numberOfPoints]; [EOL]     final Double[] weights = new Double[numberOfPoints]; [EOL]     final int iMax = numberOfPoints / 2; [EOL]     for (int i = 0; i < iMax; i++) { [EOL]         double a = (i == 0) ? -1 : previousPoints[i - 1].doubleValue(); [EOL]         double b = (iMax == 1) ? 1 : previousPoints[i].doubleValue(); [EOL]         double pma = 1; [EOL]         double pa = a; [EOL]         double pmb = 1; [EOL]         double pb = b; [EOL]         for (int j = 1; j < numberOfPoints; j++) { [EOL]             final int two_j_p_1 = 2 * j + 1; [EOL]             final int j_p_1 = j + 1; [EOL]             final double ppa = (two_j_p_1 * a * pa - j * pma) / j_p_1; [EOL]             final double ppb = (two_j_p_1 * b * pb - j * pmb) / j_p_1; [EOL]             pma = pa; [EOL]             pa = ppa; [EOL]             pmb = pb; [EOL]             pb = ppb; [EOL]         } [EOL]         double c = 0.5 * (a + b); [EOL]         double pmc = 1; [EOL]         double pc = c; [EOL]         boolean done = false; [EOL]         while (!done) { [EOL]             done = b - a <= Math.ulp(c); [EOL]             pmc = 1; [EOL]             pc = c; [EOL]             for (int j = 1; j < numberOfPoints; j++) { [EOL]                 final double ppc = ((2 * j + 1) * c * pc - j * pmc) / (j + 1); [EOL]                 pmc = pc; [EOL]                 pc = ppc; [EOL]             } [EOL]             if (!done) { [EOL]                 if (pa * pc <= 0) { [EOL]                     b = c; [EOL]                     pmb = pmc; [EOL]                     pb = pc; [EOL]                 } else { [EOL]                     a = c; [EOL]                     pma = pmc; [EOL]                     pa = pc; [EOL]                 } [EOL]                 c = 0.5 * (a + b); [EOL]             } [EOL]         } [EOL]         final double d = numberOfPoints * (pmc - c * pc); [EOL]         final double w = 2 * (1 - c * c) / (d * d); [EOL]         points[i] = c; [EOL]         weights[i] = w; [EOL]         final int idx = numberOfPoints - i - 1; [EOL]         points[idx] = -c; [EOL]         weights[idx] = w; [EOL]     } [EOL]     if (numberOfPoints % 2 != 0) { [EOL]         double pmc = 1; [EOL]         for (int j = 1; j < numberOfPoints; j += 2) { [EOL]             pmc = -j * pmc / (j + 1); [EOL]         } [EOL]         final double d = numberOfPoints * pmc; [EOL]         final double w = 2 / (d * d); [EOL]         points[iMax] = 0d; [EOL]         weights[iMax] = w; [EOL]     } [EOL]     return new Pair<Double[], Double[]>(points, weights); [EOL] } <line_num>: 35,140