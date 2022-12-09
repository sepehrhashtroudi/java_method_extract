public MillerUpdatingRegressionTest()
public void testHasIntercept()
public void testAddObsGetNClear()
public void testNegativeTestAddObs()
public void testNegativeTestAddMultipleObs()
public void testRegressAirlineConstantExternal()
public void testRegressAirlineConstantInternal()
public void testFilippelli()
public void testWampler1()
public void testWampler2()
public void testWampler3()
public void testWampler4()
public void testLongly()
public void testOneRedundantColumn()
public void testThreeRedundantColumn()
public void testPCorr()
public void testHdiag()
public void testHdiagConstant()
public void testSubsetRegression()
double[][] airdata=Optional[{ /*"I",*/
new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, /*"T",*/
new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, /*"C",*/
new double[] { 1140640, 1215690, 1309570, 1511530, 1676730, 1823740, 2022890, 2314760, 2639160, 3247620, 3787750, 3867750, 3996020, 4282880, 4748320, 569292, 640614, 777655, 999294, 1203970, 1358100, 1501350, 1709270, 2025400, 2548370, 3137740, 3557700, 3717740, 3962370, 4209390, 286298, 309290, 342056, 374595, 450037, 510412, 575347, 669331, 783799, 913883, 1041520, 1125800, 1096070, 1198930, 1170470, 145167, 170192, 247506, 309391, 354338, 373941, 420915, 474017, 532590, 676771, 880438, 1052020, 1193680, 1303390, 1436970, 91361, 95428, 98187, 115967, 138382, 156228, 183169, 210212, 274024, 356915, 432344, 524294, 530924, 581447, 610257, 68978, 74904, 83829, 98148, 118449, 133161, 145062, 170711, 199775, 276797, 381478, 506969, 633388, 804388, 1009500 }, /*"Q",*/
new double[] { 0.952757, 0.986757, 1.09198, 1.17578, 1.16017, 1.17376, 1.29051, 1.39067, 1.61273, 1.82544, 1.54604, 1.5279, 1.6602, 1.82231, 1.93646, 0.520635, 0.534627, 0.655192, 0.791575, 0.842945, 0.852892, 0.922843, 1, 1.19845, 1.34067, 1.32624, 1.24852, 1.25432, 1.37177, 1.38974, 0.262424, 0.266433, 0.306043, 0.325586, 0.345706, 0.367517, 0.409937, 0.448023, 0.539595, 0.539382, 0.467967, 0.450544, 0.468793, 0.494397, 0.493317, 0.086393, 0.09674, 0.1415, 0.169715, 0.173805, 0.164272, 0.170906, 0.17784, 0.192248, 0.242469, 0.256505, 0.249657, 0.273923, 0.371131, 0.421411, 0.051028, 0.052646, 0.056348, 0.066953, 0.070308, 0.073961, 0.084946, 0.095474, 0.119814, 0.150046, 0.144014, 0.1693, 0.172761, 0.18667, 0.213279, 0.037682, 0.039784, 0.044331, 0.050245, 0.055046, 0.052462, 0.056977, 0.06149, 0.069027, 0.092749, 0.11264, 0.154154, 0.186461, 0.246847, 0.304013 }, /*"PF",*/
new double[] { 106650, 110307, 110574, 121974, 196606, 265609, 263451, 316411, 384110, 569251, 871636, 997239, 938002, 859572, 823411, 103795, 111477, 118664, 114797, 215322, 281704, 304818, 348609, 374579, 544109, 853356, 1003200, 941977, 856533, 821361, 118788, 123798, 122882, 131274, 222037, 278721, 306564, 356073, 378311, 555267, 850322, 1015610, 954508, 886999, 844079, 114987, 120501, 121908, 127220, 209405, 263148, 316724, 363598, 389436, 547376, 850418, 1011170, 951934, 881323, 831374, 118222, 116223, 115853, 129372, 243266, 277930, 317273, 358794, 397667, 566672, 848393, 1005740, 958231, 872924, 844622, 117112, 119420, 116087, 122997, 194309, 307923, 323595, 363081, 386422, 564867, 874818, 1013170, 930477, 851676, 819476 }, /*"LF",*/
new double[] { 0.534487, 0.532328, 0.547736, 0.540846, 0.591167, 0.575417, 0.594495, 0.597409, 0.638522, 0.676287, 0.605735, 0.61436, 0.633366, 0.650117, 0.625603, 0.490851, 0.473449, 0.503013, 0.512501, 0.566782, 0.558133, 0.558799, 0.57207, 0.624763, 0.628706, 0.58915, 0.532612, 0.526652, 0.540163, 0.528775, 0.524334, 0.537185, 0.582119, 0.579489, 0.606592, 0.60727, 0.582425, 0.573972, 0.654256, 0.631055, 0.56924, 0.589682, 0.587953, 0.565388, 0.577078, 0.432066, 0.439669, 0.488932, 0.484181, 0.529925, 0.532723, 0.549067, 0.55714, 0.611377, 0.645319, 0.611734, 0.580884, 0.572047, 0.59457, 0.585525, 0.442875, 0.462473, 0.519118, 0.529331, 0.557797, 0.556181, 0.569327, 0.583465, 0.631818, 0.604723, 0.587921, 0.616159, 0.605868, 0.594688, 0.635545, 0.448539, 0.475889, 0.500562, 0.500344, 0.528897, 0.495361, 0.510342, 0.518296, 0.546723, 0.554276, 0.517766, 0.580049, 0.556024, 0.537791, 0.525775 } }]
