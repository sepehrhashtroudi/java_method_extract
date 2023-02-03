public XMLModelTestCase(String name) { [EOL]     super(name); [EOL] } <line_num>: 45,47
public void setUp() { [EOL]     if (context == null) { [EOL]         DocumentContainer docCtr = createDocumentContainer(); [EOL]         context = createContext(); [EOL]         Variables vars = context.getVariables(); [EOL]         vars.declareVariable("document", docCtr.getValue()); [EOL]         vars.declareVariable("container", docCtr); [EOL]         vars.declareVariable("element", context.getPointer("vendor/location/address/street").getNode()); [EOL]     } [EOL] } <line_num>: 49,60
protected abstract String getModel(); <line_num>: 62,62
protected DocumentContainer createDocumentContainer() { [EOL]     return new DocumentContainer(JXPathTestCase.class.getResource("Vendor.xml"), getModel()); [EOL] } <line_num>: 64,68
protected abstract AbstractFactory getAbstractFactory(); <line_num>: 70,70
protected JXPathContext createContext() { [EOL]     JXPathContext context = JXPathContext.newContext(createDocumentContainer()); [EOL]     context.setFactory(getAbstractFactory()); [EOL]     context.registerNamespace("product", "productNS"); [EOL]     return context; [EOL] } <line_num>: 72,78
protected abstract String getXMLSignature(Object node, boolean elements, boolean attributes, boolean text, boolean pi); <line_num>: 85,90
protected void assertXMLSignature(JXPathContext context, String path, String signature, boolean elements, boolean attributes, boolean text, boolean pi) { [EOL]     Object node = context.getPointer(path).getNode(); [EOL]     String sig = getXMLSignature(node, elements, attributes, text, pi); [EOL]     assertEquals("XML Signature mismatch: ", signature, sig); [EOL] } <line_num>: 92,104
public void testDocumentOrder() { [EOL]     assertDocumentOrder(context, "vendor/location", "vendor/location/address/street", -1); [EOL]     assertDocumentOrder(context, "vendor/location[@id = '100']", "vendor/location[@id = '101']", -1); [EOL]     assertDocumentOrder(context, "vendor//price:amount", "vendor/location", 1); [EOL] } <line_num>: 108,126
public void testSetValue() { [EOL]     assertXPathSetValue(context, "vendor/location[@id = '100']", "New Text"); [EOL]     assertXMLSignature(context, "vendor/location[@id = '100']", "<E>New Text</E>", false, false, true, false); [EOL]     assertXPathSetValue(context, "vendor/location[@id = '101']", "Replacement Text"); [EOL]     assertXMLSignature(context, "vendor/location[@id = '101']", "<E>Replacement Text</E>", false, false, true, false); [EOL] } <line_num>: 129,157
public void testCreatePath() { [EOL]     assertXPathCreatePath(context, "/vendor[1]/location[3]", "", "/vendor[1]/location[3]"); [EOL]     assertXPathCreatePath(context, "/vendor[1]/location[3]/address/street", "", "/vendor[1]/location[3]/address[1]/street[1]"); [EOL]     assertXPathCreatePath(context, "/vendor[1]/location[2]/@manager", "", "/vendor[1]/location[2]/@manager"); [EOL]     assertXPathCreatePath(context, "/vendor[1]/location[1]/@name", "local", "/vendor[1]/location[1]/@name"); [EOL]     assertXPathCreatePathAndSetValue(context, "/vendor[1]/location[4]/@manager", "", "/vendor[1]/location[4]/@manager"); [EOL]     context.registerNamespace("price", "priceNS"); [EOL]     assertXPathCreatePath(context, "/vendor[1]/price:foo/price:bar", "", "/vendor[1]/price:foo[1]/price:bar[1]"); [EOL] } <line_num>: 162,204
public void testCreatePathAndSetValue() { [EOL]     assertXPathCreatePathAndSetValue(context, "vendor/location[3]", "", "/vendor[1]/location[3]"); [EOL]     assertXPathCreatePathAndSetValue(context, "vendor/location[3]/address/street", "Lemon Circle", "/vendor[1]/location[3]/address[1]/street[1]"); [EOL]     assertXPathCreatePathAndSetValue(context, "vendor/location[2]/@manager", "John Doe", "/vendor[1]/location[2]/@manager"); [EOL]     assertXPathCreatePathAndSetValue(context, "vendor/location[1]/@manager", "John Doe", "/vendor[1]/location[1]/@manager"); [EOL]     assertXPathCreatePathAndSetValue(context, "/vendor[1]/location[4]/@manager", "James Dow", "/vendor[1]/location[4]/@manager"); [EOL]     assertXPathCreatePathAndSetValue(context, "vendor/product/product:name/attribute::price:language", "English", "/vendor[1]/product[1]/product:name[1]/@price:language"); [EOL]     context.registerNamespace("price", "priceNS"); [EOL]     assertXPathCreatePathAndSetValue(context, "/vendor[1]/price:foo/price:bar", "123.20", "/vendor[1]/price:foo[1]/price:bar[1]"); [EOL] } <line_num>: 209,257
public void testRemovePath() { [EOL]     context.removePath("vendor/location[@id = '101']//street/text()"); [EOL]     assertEquals("Remove DOM text", "", context.getValue("vendor/location[@id = '101']//street")); [EOL]     context.removePath("vendor/location[@id = '101']//street"); [EOL]     assertEquals("Remove DOM element", new Double(0), context.getValue("count(vendor/location[@id = '101']//street)")); [EOL]     context.removePath("vendor/location[@id = '100']/@name"); [EOL]     assertEquals("Remove DOM attribute", new Double(0), context.getValue("count(vendor/location[@id = '100']/@name)")); [EOL] } <line_num>: 262,281
public Pointer getPointerByID(JXPathContext context, String id) { [EOL]     NodePointer ptr = (NodePointer) context.getPointer("/"); [EOL]     ptr = ptr.getValuePointer(); [EOL]     return ptr.getPointerByID(context, id); [EOL] } <line_num>: 285,289
public void testID() { [EOL]     context.setIdentityManager(new IdentityManager() { [EOL]  [EOL]         public Pointer getPointerByID(JXPathContext context, String id) { [EOL]             NodePointer ptr = (NodePointer) context.getPointer("/"); [EOL]             ptr = ptr.getValuePointer(); [EOL]             return ptr.getPointerByID(context, id); [EOL]         } [EOL]     }); [EOL]     assertXPathValueAndPointer(context, "id(101)//street", "Tangerine Drive", "id('101')/address[1]/street[1]"); [EOL]     assertXPathPointerLenient(context, "id(105)/address/street", "id(105)/address/street"); [EOL] } <line_num>: 283,302
public void testAxisChild() { [EOL]     assertXPathValue(context, "vendor/location/address/street", "Orchard Road"); [EOL]     assertXPathValue(context, "vendor/location/address/city", "Fruit Market"); [EOL]     assertXPathValue(context, "local-name(vendor/product/price:amount)", "amount"); [EOL]     assertXPathValue(context, "local-name(vendor/location)", "location"); [EOL]     assertXPathValue(context, "name(vendor/product/price:amount)", "value:amount"); [EOL]     assertXPathValue(context, "name(vendor/location)", "location"); [EOL]     assertXPathValue(context, "namespace-uri(vendor/product/price:amount)", "priceNS"); [EOL]     assertXPathValue(context, "vendor/product/prix", "934.99"); [EOL]     assertXPathValue(context, "/vendor/contact[@name='jim']", "Jim"); [EOL]     boolean nsv = false; [EOL]     try { [EOL]         context.setLenient(false); [EOL]         context.getValue("/vendor/contact[@name='jane']"); [EOL]     } catch (JXPathException ex) { [EOL]         nsv = true; [EOL]     } [EOL]     assertTrue("No such value: /vendor/contact[@name='jim']", nsv); [EOL]     nsv = false; [EOL]     try { [EOL]         context.setLenient(false); [EOL]         context.getValue("/vendor/contact[@name='jane']/*"); [EOL]     } catch (JXPathException ex) { [EOL]         nsv = true; [EOL]     } [EOL]     assertTrue("No such value: /vendor/contact[@name='jane']/*", nsv); [EOL]     assertXPathValue(context, "count(vendor/product/price:*)", new Double(2)); [EOL]     assertXPathValue(context, "count(vendor/product/*)", new Double(4)); [EOL]     assertXPathValue(context, "vendor/product/price:amount", "45.95"); [EOL]     context.registerNamespace("x", "temp"); [EOL]     assertXPathValue(context, "vendor/x:pos//number", "109"); [EOL] } <line_num>: 304,383
public void testDefaultNamespaceIgnored() { [EOL]     context.registerDefaultNamespace("temp"); [EOL]     assertXPathValueAndPointer(context, "//pos//number", "110", "/node()[1]/pos[2]/register[1]/number[1]"); [EOL]     context.registerDefaultNamespace(null); [EOL] } <line_num>: 385,390
public void testAxisChildIndexPredicate() { [EOL]     assertXPathValue(context, "vendor/location[2]/address/street", "Tangerine Drive"); [EOL] } <line_num>: 392,397
public void testAxisDescendant() { [EOL]     assertXPathValue(context, "//street", "Orchard Road"); [EOL]     assertXPathValue(context, "count(//price:*)", new Double(2)); [EOL]     assertXPathValueIterator(context, "vendor//saleEnds", list("never")); [EOL]     assertXPathValueIterator(context, "vendor//promotion", list("")); [EOL]     assertXPathValueIterator(context, "vendor//saleEnds[../@stores = 'all']", list("never")); [EOL]     assertXPathValueIterator(context, "vendor//promotion[../@stores = 'all']", list("")); [EOL] } <line_num>: 399,419
public void testAxisParent() { [EOL]     assertXPathPointer(context, "//street/..", "/vendor[1]/location[1]/address[1]"); [EOL]     assertXPathPointerIterator(context, "//street/..", list("/vendor[1]/location[2]/address[1]", "/vendor[1]/location[1]/address[1]")); [EOL]     assertXPathValue(context, "vendor/product/price:sale/saleEnds/parent::price:*" + "/saleEnds", "never"); [EOL] } <line_num>: 428,448
public void testAxisFollowingSibling() { [EOL]     assertXPathValue(context, "vendor/location[.//employeeCount = 10]/" + "following-sibling::location//street", "Tangerine Drive"); [EOL]     assertXPathPointer(context, "vendor/location[.//employeeCount = 10]/" + "following-sibling::location//street", "/vendor[1]/location[2]/address[1]/street[1]"); [EOL] } <line_num>: 450,464
public void testAxisPrecedingSibling() { [EOL]     assertXPathPointer(context, "//location[2]/preceding-sibling::location//street", "/vendor[1]/location[1]/address[1]/street[1]"); [EOL] } <line_num>: 466,472
public void testAxisAttribute() { [EOL]     assertXPathValue(context, "vendor/location/@id", "100"); [EOL]     assertXPathPointer(context, "vendor/location/@id", "/vendor[1]/location[1]/@id"); [EOL]     assertXPathValueIterator(context, "vendor/location/@id", list("100", "101")); [EOL]     assertXPathValue(context, "vendor/product/price:amount/@price:discount", "10%"); [EOL]     assertXPathValue(context, "namespace-uri(vendor/product/price:amount/@price:discount)", "priceNS"); [EOL]     assertXPathValue(context, "local-name(vendor/product/price:amount/@price:discount)", "discount"); [EOL]     assertXPathValue(context, "name(vendor/product/price:amount/@price:discount)", "price:discount"); [EOL]     assertXPathValue(context, "vendor/product/price:amount/@discount", "20%"); [EOL]     assertXPathValue(context, "namespace-uri(vendor/product/price:amount/@discount)", ""); [EOL]     assertXPathValue(context, "local-name(vendor/product/price:amount/@discount)", "discount"); [EOL]     assertXPathValue(context, "name(vendor/product/price:amount/@discount)", "discount"); [EOL]     assertXPathValueIterator(context, "vendor/product/price:amount/@price:*", list("10%")); [EOL]     assertXPathValueIterator(context, "vendor/location[1]/@*", set("100", "", "local")); [EOL]     assertXPathValueIterator(context, "vendor/product/price:amount/@*", list("20%")); [EOL]     assertXPathValue(context, "vendor/location/@manager", ""); [EOL]     assertXPathValueLenient(context, "vendor/location/@missing", null); [EOL]     assertXPathValueLenient(context, "vendor/location/@miss:missing", null); [EOL]     assertXPathValue(context, "vendor/location[@id='101']//street", "Tangerine Drive"); [EOL]     assertXPathValueIterator(context, "/vendor/location[1]/@*[name()!= 'manager']", list("100", "local")); [EOL] } <line_num>: 474,575
public void testAxisNamespace() { [EOL]     assertXPathValueAndPointer(context, "vendor/product/prix/namespace::price", "priceNS", "/vendor[1]/product[1]/prix[1]/namespace::price"); [EOL]     assertXPathValue(context, "count(vendor/product/namespace::*)", new Double(3)); [EOL]     assertXPathValue(context, "name(vendor/product/prix/namespace::price)", "price"); [EOL]     assertXPathValue(context, "local-name(vendor/product/prix/namespace::price)", "price"); [EOL] } <line_num>: 577,602
public void testAxisAncestor() { [EOL]     assertXPathValue(context, "vendor/product/price:sale/saleEnds/" + "ancestor::price:sale/saleEnds", "never"); [EOL]     assertXPathValue(context, "vendor/product/price:sale/saleEnds/ancestor::price:*" + "/saleEnds", "never"); [EOL] } <line_num>: 604,618
public void testAxisAncestorOrSelf() { [EOL]     assertXPathValue(context, "vendor/product/price:sale/" + "ancestor-or-self::price:sale/saleEnds", "never"); [EOL] } <line_num>: 620,627
public void testAxisFollowing() { [EOL]     assertXPathValueIterator(context, "vendor/contact/following::location//street", list("Orchard Road", "Tangerine Drive")); [EOL]     assertXPathValue(context, "//location/following::price:sale/saleEnds", "never"); [EOL] } <line_num>: 629,640
public void testAxisSelf() { [EOL]     assertXPathValue(context, "//price:sale/self::price:sale/saleEnds", "never"); [EOL]     assertXPathValueLenient(context, "//price:sale/self::x/saleEnds", null); [EOL] } <line_num>: 642,651
public void testNodeTypeComment() { [EOL]     assertXPathValue(context, "//product/comment()", "We are not buying this product, ever"); [EOL] } <line_num>: 653,659
public void testNodeTypeText() { [EOL]     assertXPathValue(context, "//product/text()[. != '']", "We love this product."); [EOL]     assertXPathPointer(context, "//product/text()", "/vendor[1]/product[1]/text()[1]"); [EOL] } <line_num>: 661,674
public void testNodeTypeProcessingInstruction() { [EOL]     assertXPathValue(context, "//product/processing-instruction()", "do not show anybody"); [EOL]     assertXPathValue(context, "//product/processing-instruction('report')", "average only"); [EOL]     assertXPathPointer(context, "//product/processing-instruction('report')", "/vendor[1]/product[1]/processing-instruction('report')[1]"); [EOL]     assertXPathValue(context, "name(//product/processing-instruction()[1])", "security"); [EOL] } <line_num>: 676,700
public void testLang() { [EOL]     assertXPathValue(context, "//product/prix/@xml:lang", "fr"); [EOL]     assertXPathValue(context, "//product/prix[lang('fr')]", "934.99"); [EOL]     assertXPathValue(context, "//product/price:sale[lang('en')]/saleEnds", "never"); [EOL] } <line_num>: 702,714
public void testDocument() { [EOL]     assertXPathValue(context, "$document/vendor/location[1]//street", "Orchard Road"); [EOL]     assertXPathPointer(context, "$document/vendor/location[1]//street", "$document/vendor[1]/location[1]/address[1]/street[1]"); [EOL]     assertXPathValue(context, "$document/vendor//street", "Orchard Road"); [EOL] } <line_num>: 716,728
public void testContainer() { [EOL]     assertXPathValue(context, "$container/vendor//street", "Orchard Road"); [EOL]     assertXPathValue(context, "$container//street", "Orchard Road"); [EOL]     assertXPathPointer(context, "$container//street", "$container/vendor[1]/location[1]/address[1]/street[1]"); [EOL]     assertXPathValue(context, "number(vendor/location/employeeCount)", new Double(10)); [EOL] } <line_num>: 730,745
public void testElementInVariable() { [EOL]     assertXPathValue(context, "$element", "Orchard Road"); [EOL] } <line_num>: 747,749
public void testTypeConversions() { [EOL]     assertXPathValue(context, "vendor/location/employeeCount + 1", new Double(11)); [EOL]     assertXPathValue(context, "vendor/location/employeeCount and true()", Boolean.TRUE); [EOL] } <line_num>: 751,763
public void testBooleanFunction() { [EOL]     assertXPathValue(context, "boolean(vendor//saleEnds[../@stores = 'all'])", Boolean.TRUE); [EOL]     assertXPathValue(context, "boolean(vendor//promotion[../@stores = 'all'])", Boolean.TRUE); [EOL]     assertXPathValue(context, "boolean(vendor//promotion[../@stores = 'some'])", Boolean.FALSE); [EOL] } <line_num>: 765,780
public void testFunctionsLastAndPosition() { [EOL]     assertXPathPointer(context, "vendor//location[last()]", "/vendor[1]/location[2]"); [EOL] } <line_num>: 782,787
public void testNamespaceMapping() { [EOL]     context.registerNamespace("rate", "priceNS"); [EOL]     context.registerNamespace("goods", "productNS"); [EOL]     assertEquals("Context node namespace resolution", "priceNS", context.getNamespaceURI("price")); [EOL]     assertEquals("Registered namespace resolution", "priceNS", context.getNamespaceURI("rate")); [EOL]     assertXPathValue(context, "count(vendor/product/rate:*)", new Double(2)); [EOL]     assertXPathValueAndPointer(context, "//product:name", "Box of oranges", "/vendor[1]/product[1]/goods:name[1]"); [EOL]     JXPathContext childCtx = JXPathContext.newContext(context, context.getContextBean()); [EOL]     assertXPathValueAndPointer(childCtx, "//product:name", "Box of oranges", "/vendor[1]/product[1]/goods:name[1]"); [EOL]     JXPathContext relativeCtx = context.getRelativeContext(context.getPointer("/vendor")); [EOL]     assertXPathValueAndPointer(relativeCtx, "product/product:name", "Box of oranges", "/vendor[1]/product[1]/goods:name[1]"); [EOL] } <line_num>: 789,827
