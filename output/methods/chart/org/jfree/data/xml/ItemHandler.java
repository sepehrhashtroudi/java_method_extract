public ItemHandler(RootHandler root, DefaultHandler parent) { [EOL]     this.root = root; [EOL]     this.parent = parent; [EOL]     this.key = null; [EOL]     this.value = null; [EOL] } <line_num>: 70,75
public Comparable getKey() { [EOL]     return this.key; [EOL] } <line_num>: 82,84
public void setKey(Comparable key) { [EOL]     this.key = key; [EOL] } <line_num>: 91,93
public Number getValue() { [EOL]     return this.value; [EOL] } <line_num>: 100,102
public void setValue(Number value) { [EOL]     this.value = value; [EOL] } <line_num>: 109,111
public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException { [EOL]     if (qName.equals(ITEM_TAG)) { [EOL]         KeyHandler subhandler = new KeyHandler(this.root, this); [EOL]         this.root.pushSubHandler(subhandler); [EOL]     } else if (qName.equals(VALUE_TAG)) { [EOL]         ValueHandler subhandler = new ValueHandler(this.root, this); [EOL]         this.root.pushSubHandler(subhandler); [EOL]     } else { [EOL]         throw new SAXException("Expected <Item> or <Value>...found " + qName); [EOL]     } [EOL] } <line_num>: 123,142
public void endElement(String namespaceURI, String localName, String qName) { [EOL]     if (this.parent instanceof PieDatasetHandler) { [EOL]         PieDatasetHandler handler = (PieDatasetHandler) this.parent; [EOL]         handler.addItem(this.key, this.value); [EOL]         this.root.popSubHandler(); [EOL]     } else if (this.parent instanceof CategorySeriesHandler) { [EOL]         CategorySeriesHandler handler = (CategorySeriesHandler) this.parent; [EOL]         handler.addItem(this.key, this.value); [EOL]         this.root.popSubHandler(); [EOL]     } [EOL] } <line_num>: 151,166
