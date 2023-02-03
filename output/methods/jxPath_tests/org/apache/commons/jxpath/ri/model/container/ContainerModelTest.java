public ContainerModelTest(String name) { [EOL]     super(name); [EOL] } <line_num>: 47,49
public ListContainer() { [EOL]     list = new ArrayList(); [EOL]     list.add("foo"); [EOL]     list.add("bar"); [EOL] } <line_num>: 79,83
public static void main(String[] args) { [EOL]     TestRunner.run(suite()); [EOL] } <line_num>: 51,53
public static Test suite() { [EOL]     return (new TestSuite(ContainerModelTest.class)); [EOL] } <line_num>: 58,60
public Object getValue() { [EOL]     return array; [EOL] } <line_num>: 66,68
public void setValue(Object value) { [EOL]     throw new UnsupportedOperationException(); [EOL] } <line_num>: 70,72
public Object getValue() { [EOL]     return list; [EOL] } <line_num>: 85,87
public void setValue(Object value) { [EOL]     throw new UnsupportedOperationException(); [EOL] } <line_num>: 89,91
public ListContainer getContainer() { [EOL]     return container; [EOL] } <line_num>: 98,100
public void testContainerVariableWithCollection() { [EOL]     ArrayContainer container = new ArrayContainer(); [EOL]     String[] array = (String[]) container.getValue(); [EOL]     JXPathContext context = JXPathContext.newContext(null); [EOL]     context.getVariables().declareVariable("list", container); [EOL]     assertXPathValueAndPointer(context, "$list", array, "$list"); [EOL]     assertXPathValueAndPointer(context, "$list[1]", "foo", "$list[1]"); [EOL]     assertXPathValueAndPointer(context, "$list[2]", "bar", "$list[2]"); [EOL]     assertXPathSetValue(context, "$list[1]", "baz"); [EOL]     assertEquals("Checking setValue(index)", "baz", array[0]); [EOL] } <line_num>: 103,116
public void testContainerPropertyWithCollection() { [EOL]     Bean bean = new Bean(); [EOL]     List list = (List) bean.getContainer().getValue(); [EOL]     JXPathContext context = JXPathContext.newContext(bean); [EOL]     assertXPathValueAndPointer(context, "/container", list, "/container"); [EOL]     assertXPathValueAndPointer(context, "/container[1]", list.get(0), "/container[1]"); [EOL]     assertXPathValueAndPointer(context, "/container[2]", list.get(1), "/container[2]"); [EOL]     assertXPathSetValue(context, "/container[1]", "baz"); [EOL]     assertEquals("Checking setValue(index)", "baz", list.get(0)); [EOL] } <line_num>: 118,133
public void testContainerMapWithCollection() { [EOL]     ListContainer container = new ListContainer(); [EOL]     List list = (List) container.getValue(); [EOL]     Map map = new HashMap(); [EOL]     map.put("container", container); [EOL]     JXPathContext context = JXPathContext.newContext(map); [EOL]     assertXPathValueAndPointer(context, "/container", list, "/.[@name='container']"); [EOL]     assertXPathValueAndPointer(context, "/container[1]", list.get(0), "/.[@name='container'][1]"); [EOL]     assertXPathValueAndPointer(context, "/container[2]", list.get(1), "/.[@name='container'][2]"); [EOL]     assertXPathSetValue(context, "/container[1]", "baz"); [EOL]     assertEquals("Checking setValue(index)", "baz", list.get(0)); [EOL] } <line_num>: 135,153
public void testContainerRootWithCollection() { [EOL]     ArrayContainer container = new ArrayContainer(); [EOL]     String[] array = (String[]) container.getValue(); [EOL]     JXPathContext context = JXPathContext.newContext(container); [EOL]     context.getVariables().declareVariable("list", container); [EOL]     assertXPathValueAndPointer(context, "/", array, "/"); [EOL]     assertXPathValueAndPointer(context, "/.[1]", "foo", "/.[1]"); [EOL]     assertXPathValueAndPointer(context, "/.[2]", "bar", "/.[2]"); [EOL]     assertXPathSetValue(context, "/.[1]", "baz"); [EOL]     assertEquals("Checking setValue(index)", "baz", array[0]); [EOL] } <line_num>: 155,167
