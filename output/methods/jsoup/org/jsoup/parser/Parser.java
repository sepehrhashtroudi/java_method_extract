private Parser(String html, String baseUri, boolean isBodyFragment) { [EOL]     Validate.notNull(html); [EOL]     Validate.notNull(baseUri); [EOL]     stack = new LinkedList<Element>(); [EOL]     tq = new TokenQueue(html); [EOL]     this.baseUri = baseUri; [EOL]     if (isBodyFragment) { [EOL]         doc = Document.createShell(baseUri); [EOL]         stack.add(doc.body()); [EOL]     } else { [EOL]         doc = new Document(baseUri); [EOL]         stack.add(doc); [EOL]     } [EOL] } <line_num>: 27,42
public static Document parse(String html, String baseUri) { [EOL]     Parser parser = new Parser(html, baseUri, false); [EOL]     return parser.parse(); [EOL] } <line_num>: 50,53
public static Document parseBodyFragment(String bodyHtml, String baseUri) { [EOL]     Parser parser = new Parser(bodyHtml, baseUri, true); [EOL]     return parser.parse(); [EOL] } <line_num>: 61,64
private Document parse() { [EOL]     while (!tq.isEmpty()) { [EOL]         if (tq.matches("<!--")) { [EOL]             parseComment(); [EOL]         } else if (tq.matches("<![CDATA[")) { [EOL]             parseCdata(); [EOL]         } else if (tq.matches("<?") || tq.matches("<!")) { [EOL]             parseXmlDecl(); [EOL]         } else if (tq.matches("</")) { [EOL]             parseEndTag(); [EOL]         } else if (tq.matches("<")) { [EOL]             parseStartTag(); [EOL]         } else { [EOL]             parseTextNode(); [EOL]         } [EOL]     } [EOL]     return doc.normalise(); [EOL] } <line_num>: 66,83
private void parseComment() { [EOL]     tq.consume("<!--"); [EOL]     String data = tq.chompTo("->"); [EOL]     if (data.endsWith("-")) [EOL]         data = data.substring(0, data.length() - 1); [EOL]     Comment comment = new Comment(data, baseUri); [EOL]     last().appendChild(comment); [EOL] } <line_num>: 85,93
private void parseXmlDecl() { [EOL]     tq.consume("<"); [EOL]     Character firstChar = tq.consume(); [EOL]     boolean procInstr = firstChar.toString().equals("!"); [EOL]     String data = tq.chompTo(">"); [EOL]     XmlDeclaration decl = new XmlDeclaration(data, baseUri, procInstr); [EOL]     last().appendChild(decl); [EOL] } <line_num>: 95,103
private void parseEndTag() { [EOL]     tq.consume("</"); [EOL]     String tagName = tq.consumeWord(); [EOL]     tq.chompTo(">"); [EOL]     if (tagName.length() != 0) { [EOL]         Tag tag = Tag.valueOf(tagName); [EOL]         popStackToClose(tag); [EOL]     } [EOL] } <line_num>: 105,114
private void parseStartTag() { [EOL]     tq.consume("<"); [EOL]     String tagName = tq.consumeWord(); [EOL]     if (tagName.length() == 0) { [EOL]         tq.addFirst("&lt;"); [EOL]         parseTextNode(); [EOL]         return; [EOL]     } [EOL]     Attributes attributes = new Attributes(); [EOL]     while (!tq.matchesAny("<", "/>", ">") && !tq.isEmpty()) { [EOL]         Attribute attribute = parseAttribute(); [EOL]         if (attribute != null) [EOL]             attributes.put(attribute); [EOL]     } [EOL]     Tag tag = Tag.valueOf(tagName); [EOL]     Element child = new Element(tag, baseUri, attributes); [EOL]     boolean isEmptyElement = tag.isEmpty(); [EOL]     if (tq.matchChomp("/>")) { [EOL]         isEmptyElement = true; [EOL]     } else { [EOL]         tq.matchChomp(">"); [EOL]     } [EOL]     if (tag.isData()) { [EOL]         String data = tq.chompTo("</" + tagName); [EOL]         tq.chompTo(">"); [EOL]         Node dataNode; [EOL]         if (tag.equals(titleTag) || tag.equals(textareaTag)) [EOL]             dataNode = TextNode.createFromEncoded(data, baseUri); [EOL]         else [EOL]             dataNode = new DataNode(data, baseUri); [EOL]         child.appendChild(dataNode); [EOL]     } [EOL]     if (child.tagName().equals("base")) { [EOL]         String href = child.absUrl("href"); [EOL]         if (href.length() != 0) { [EOL]             baseUri = href; [EOL]             doc.setBaseUri(href); [EOL]         } [EOL]     } [EOL]     addChildToParent(child, isEmptyElement); [EOL] } <line_num>: 116,166
private Attribute parseAttribute() { [EOL]     tq.consumeWhitespace(); [EOL]     String key = tq.consumeAttributeKey(); [EOL]     String value = ""; [EOL]     tq.consumeWhitespace(); [EOL]     if (tq.matchChomp("=")) { [EOL]         tq.consumeWhitespace(); [EOL]         if (tq.matchChomp(SQ)) { [EOL]             value = tq.chompTo(SQ); [EOL]         } else if (tq.matchChomp(DQ)) { [EOL]             value = tq.chompTo(DQ); [EOL]         } else { [EOL]             StringBuilder valueAccum = new StringBuilder(); [EOL]             while (!tq.matchesAny("<", "/>", ">") && !tq.matchesWhitespace() && !tq.isEmpty()) { [EOL]                 valueAccum.append(tq.consume()); [EOL]             } [EOL]             value = valueAccum.toString(); [EOL]         } [EOL]         tq.consumeWhitespace(); [EOL]     } [EOL]     if (key.length() != 0) [EOL]         return Attribute.createFromEncoded(key, value); [EOL]     else { [EOL]         tq.consume(); [EOL]         return null; [EOL]     } [EOL] } <line_num>: 168,196
private void parseTextNode() { [EOL]     String text = tq.consumeTo("<"); [EOL]     TextNode textNode = TextNode.createFromEncoded(text, baseUri); [EOL]     last().appendChild(textNode); [EOL] } <line_num>: 198,202
private void parseCdata() { [EOL]     tq.consume("<![CDATA["); [EOL]     String rawText = tq.chompTo("]]>"); [EOL]     TextNode textNode = new TextNode(rawText, baseUri); [EOL]     last().appendChild(textNode); [EOL] } <line_num>: 204,209
private Element addChildToParent(Element child, boolean isEmptyElement) { [EOL]     Element parent = popStackToSuitableContainer(child.tag()); [EOL]     Tag childTag = child.tag(); [EOL]     boolean validAncestor = stackHasValidParent(childTag); [EOL]     if (!validAncestor) { [EOL]         Tag parentTag = childTag.getImplicitParent(); [EOL]         Element implicit = new Element(parentTag, baseUri); [EOL]         if (child.tag().equals(bodyTag)) { [EOL]             Element head = new Element(headTag, baseUri); [EOL]             implicit.appendChild(head); [EOL]         } [EOL]         implicit.appendChild(child); [EOL]         Element root = addChildToParent(implicit, false); [EOL]         if (!isEmptyElement) [EOL]             stack.addLast(child); [EOL]         return root; [EOL]     } [EOL]     parent.appendChild(child); [EOL]     if (!isEmptyElement) [EOL]         stack.addLast(child); [EOL]     return parent; [EOL] } <line_num>: 211,239
private boolean stackHasValidParent(Tag childTag) { [EOL]     if (stack.size() == 1 && childTag.equals(htmlTag)) [EOL]         return true; [EOL]     for (int i = stack.size() - 1; i >= 0; i--) { [EOL]         Element el = stack.get(i); [EOL]         Tag parent2 = el.tag(); [EOL]         if (parent2.isValidParent(childTag)) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 241,253
private Element popStackToSuitableContainer(Tag tag) { [EOL]     while (!stack.isEmpty()) { [EOL]         if (last().tag().canContain(tag)) [EOL]             return last(); [EOL]         else [EOL]             stack.removeLast(); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 255,263
private Element popStackToClose(Tag tag) { [EOL]     int counter = 0; [EOL]     Element elToClose = null; [EOL]     for (int i = stack.size() - 1; i > 0; i--) { [EOL]         counter++; [EOL]         Element el = stack.get(i); [EOL]         Tag elTag = el.tag(); [EOL]         if (elTag.equals(bodyTag) || elTag.equals(htmlTag)) { [EOL]             break; [EOL]         } else if (elTag.equals(tag)) { [EOL]             elToClose = el; [EOL]             break; [EOL]         } [EOL]     } [EOL]     if (elToClose != null) { [EOL]         for (int i = 0; i < counter; i++) { [EOL]             stack.removeLast(); [EOL]         } [EOL]     } [EOL]     return elToClose; [EOL] } <line_num>: 265,286
private Element last() { [EOL]     return stack.getLast(); [EOL] } <line_num>: 288,290
