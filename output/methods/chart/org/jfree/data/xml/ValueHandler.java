public ValueHandler(RootHandler rootHandler, ItemHandler itemHandler) { [EOL]     this.rootHandler = rootHandler; [EOL]     this.itemHandler = itemHandler; [EOL]     this.currentText = new StringBuffer(); [EOL] } <line_num>: 68,72
public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException { [EOL]     if (qName.equals(VALUE_TAG)) { [EOL]         clearCurrentText(); [EOL]     } else { [EOL]         throw new SAXException("Expecting <Value> but found " + qName); [EOL]     } [EOL] } <line_num>: 84,97
public void endElement(String namespaceURI, String localName, String qName) throws SAXException { [EOL]     if (qName.equals(VALUE_TAG)) { [EOL]         Number value; [EOL]         try { [EOL]             value = Double.valueOf(this.currentText.toString()); [EOL]             if (((Double) value).isNaN()) { [EOL]                 value = null; [EOL]             } [EOL]         } catch (NumberFormatException e1) { [EOL]             value = null; [EOL]         } [EOL]         this.itemHandler.setValue(value); [EOL]         this.rootHandler.popSubHandler(); [EOL]     } else { [EOL]         throw new SAXException("Expecting </Value> but found " + qName); [EOL]     } [EOL] } <line_num>: 108,130
public void characters(char[] ch, int start, int length) { [EOL]     if (this.currentText != null) { [EOL]         this.currentText.append(String.copyValueOf(ch, start, length)); [EOL]     } [EOL] } <line_num>: 139,143
protected String getCurrentText() { [EOL]     return this.currentText.toString(); [EOL] } <line_num>: 150,152
protected void clearCurrentText() { [EOL]     this.currentText.delete(0, this.currentText.length()); [EOL] } <line_num>: 157,159