@Before [EOL] public void setUp() throws IOException { [EOL]     descriptives = new DescriptiveStatistics(); [EOL]     summaries = new SummaryStatistics(); [EOL]     certifiedValues = new HashMap<String, Double>(); [EOL]     loadData(); [EOL] } <line_num>: 49,56
private void loadData() throws IOException { [EOL]     BufferedReader in = null; [EOL]     try { [EOL]         URL resourceURL = getClass().getClassLoader().getResource(getResourceName()); [EOL]         in = new BufferedReader(new InputStreamReader(resourceURL.openStream())); [EOL]         String line = in.readLine(); [EOL]         while (line != null) { [EOL]             line = line.trim(); [EOL]             if (!("".equals(line) || line.startsWith("#"))) { [EOL]                 int n = line.indexOf('='); [EOL]                 if (n == -1) { [EOL]                     double value = Double.parseDouble(line); [EOL]                     descriptives.addValue(value); [EOL]                     summaries.addValue(value); [EOL]                 } else { [EOL]                     String name = line.substring(0, n).trim(); [EOL]                     String valueString = line.substring(n + 1).trim(); [EOL]                     Double value = Double.valueOf(valueString); [EOL]                     certifiedValues.put(name, value); [EOL]                 } [EOL]             } [EOL]             line = in.readLine(); [EOL]         } [EOL]     } finally { [EOL]         if (in != null) { [EOL]             in.close(); [EOL]         } [EOL]     } [EOL] } <line_num>: 58,96
protected abstract String getResourceName(); <line_num>: 98,98
protected double getMaximumAbsoluteError() { [EOL]     return 1.0e-5; [EOL] } <line_num>: 100,102
@After [EOL] public void tearDown() { [EOL]     descriptives.clear(); [EOL]     descriptives = null; [EOL]     summaries.clear(); [EOL]     summaries = null; [EOL]     certifiedValues.clear(); [EOL]     certifiedValues = null; [EOL] } <line_num>: 104,114
@Test [EOL] public void testCertifiedValues() { [EOL]     for (String name : certifiedValues.keySet()) { [EOL]         Double expectedValue = certifiedValues.get(name); [EOL]         Double summariesValue = getProperty(summaries, name); [EOL]         if (summariesValue != null) { [EOL]             TestUtils.assertEquals("summary value for " + name + " is incorrect.", summariesValue.doubleValue(), expectedValue.doubleValue(), getMaximumAbsoluteError()); [EOL]         } [EOL]         Double descriptivesValue = getProperty(descriptives, name); [EOL]         if (descriptivesValue != null) { [EOL]             TestUtils.assertEquals("descriptive value for " + name + " is incorrect.", descriptivesValue.doubleValue(), expectedValue.doubleValue(), getMaximumAbsoluteError()); [EOL]         } [EOL]     } [EOL] } <line_num>: 116,135
protected Double getProperty(Object bean, String name) { [EOL]     try { [EOL]         String prop = "get" + name.substring(0, 1).toUpperCase() + name.substring(1); [EOL]         Method meth = bean.getClass().getMethod(prop, new Class[0]); [EOL]         Object property = meth.invoke(bean, new Object[0]); [EOL]         if (meth.getReturnType().equals(Double.TYPE)) { [EOL]             return (Double) property; [EOL]         } else if (meth.getReturnType().equals(Long.TYPE)) { [EOL]             return Double.valueOf(((Long) property).doubleValue()); [EOL]         } else { [EOL]             Assert.fail("wrong type: " + meth.getReturnType().getName()); [EOL]         } [EOL]     } catch (NoSuchMethodException nsme) { [EOL]     } catch (InvocationTargetException ite) { [EOL]         Assert.fail(ite.getMessage()); [EOL]     } catch (IllegalAccessException iae) { [EOL]         Assert.fail(iae.getMessage()); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 138,159