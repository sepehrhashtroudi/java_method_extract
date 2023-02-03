public CoreFunction(int functionCode, Expression[] args) { [EOL]     super(args); [EOL]     this.functionCode = functionCode; [EOL] } <line_num>: 45,48
public int getFunctionCode() { [EOL]     return functionCode; [EOL] } <line_num>: 50,52
protected String getFunctionName() { [EOL]     switch(functionCode) { [EOL]         case Compiler.FUNCTION_LAST: [EOL]             return "last"; [EOL]         case Compiler.FUNCTION_POSITION: [EOL]             return "position"; [EOL]         case Compiler.FUNCTION_COUNT: [EOL]             return "count"; [EOL]         case Compiler.FUNCTION_ID: [EOL]             return "id"; [EOL]         case Compiler.FUNCTION_LOCAL_NAME: [EOL]             return "local-name"; [EOL]         case Compiler.FUNCTION_NAMESPACE_URI: [EOL]             return "namespace-uri"; [EOL]         case Compiler.FUNCTION_NAME: [EOL]             return "name"; [EOL]         case Compiler.FUNCTION_STRING: [EOL]             return "string"; [EOL]         case Compiler.FUNCTION_CONCAT: [EOL]             return "concat"; [EOL]         case Compiler.FUNCTION_STARTS_WITH: [EOL]             return "starts-with"; [EOL]         case Compiler.FUNCTION_CONTAINS: [EOL]             return "contains"; [EOL]         case Compiler.FUNCTION_SUBSTRING_BEFORE: [EOL]             return "substring-before"; [EOL]         case Compiler.FUNCTION_SUBSTRING_AFTER: [EOL]             return "substring-after"; [EOL]         case Compiler.FUNCTION_SUBSTRING: [EOL]             return "substring"; [EOL]         case Compiler.FUNCTION_STRING_LENGTH: [EOL]             return "string-length"; [EOL]         case Compiler.FUNCTION_NORMALIZE_SPACE: [EOL]             return "normalize-space"; [EOL]         case Compiler.FUNCTION_TRANSLATE: [EOL]             return "translate"; [EOL]         case Compiler.FUNCTION_BOOLEAN: [EOL]             return "boolean"; [EOL]         case Compiler.FUNCTION_NOT: [EOL]             return "not"; [EOL]         case Compiler.FUNCTION_TRUE: [EOL]             return "true"; [EOL]         case Compiler.FUNCTION_FALSE: [EOL]             return "false"; [EOL]         case Compiler.FUNCTION_LANG: [EOL]             return "lang"; [EOL]         case Compiler.FUNCTION_NUMBER: [EOL]             return "number"; [EOL]         case Compiler.FUNCTION_SUM: [EOL]             return "sum"; [EOL]         case Compiler.FUNCTION_FLOOR: [EOL]             return "floor"; [EOL]         case Compiler.FUNCTION_CEILING: [EOL]             return "ceiling"; [EOL]         case Compiler.FUNCTION_ROUND: [EOL]             return "round"; [EOL]         case Compiler.FUNCTION_KEY: [EOL]             return "key"; [EOL]         case Compiler.FUNCTION_FORMAT_NUMBER: [EOL]             return "format-number"; [EOL]     } [EOL]     return "unknownFunction" + functionCode + "()"; [EOL] } <line_num>: 54,116
public Expression getArg1() { [EOL]     return args[0]; [EOL] } <line_num>: 118,120
public Expression getArg2() { [EOL]     return args[1]; [EOL] } <line_num>: 122,124
public Expression getArg3() { [EOL]     return args[2]; [EOL] } <line_num>: 126,128
public int getArgumentCount() { [EOL]     if (args == null) { [EOL]         return 0; [EOL]     } [EOL]     return args.length; [EOL] } <line_num>: 130,135
public boolean computeContextDependent() { [EOL]     if (super.computeContextDependent()) { [EOL]         return true; [EOL]     } [EOL]     switch(functionCode) { [EOL]         case Compiler.FUNCTION_LAST: [EOL]         case Compiler.FUNCTION_POSITION: [EOL]             return true; [EOL]         case Compiler.FUNCTION_BOOLEAN: [EOL]         case Compiler.FUNCTION_LOCAL_NAME: [EOL]         case Compiler.FUNCTION_NAME: [EOL]         case Compiler.FUNCTION_NAMESPACE_URI: [EOL]         case Compiler.FUNCTION_STRING: [EOL]         case Compiler.FUNCTION_LANG: [EOL]         case Compiler.FUNCTION_NUMBER: [EOL]             return args == null || args.length == 0; [EOL]         case Compiler.FUNCTION_COUNT: [EOL]         case Compiler.FUNCTION_ID: [EOL]         case Compiler.FUNCTION_CONCAT: [EOL]         case Compiler.FUNCTION_STARTS_WITH: [EOL]         case Compiler.FUNCTION_CONTAINS: [EOL]         case Compiler.FUNCTION_SUBSTRING_BEFORE: [EOL]         case Compiler.FUNCTION_SUBSTRING_AFTER: [EOL]         case Compiler.FUNCTION_SUBSTRING: [EOL]         case Compiler.FUNCTION_STRING_LENGTH: [EOL]         case Compiler.FUNCTION_NORMALIZE_SPACE: [EOL]         case Compiler.FUNCTION_TRANSLATE: [EOL]         case Compiler.FUNCTION_NOT: [EOL]         case Compiler.FUNCTION_TRUE: [EOL]         case Compiler.FUNCTION_FALSE: [EOL]         case Compiler.FUNCTION_SUM: [EOL]         case Compiler.FUNCTION_FLOOR: [EOL]         case Compiler.FUNCTION_CEILING: [EOL]         case Compiler.FUNCTION_ROUND: [EOL]             return false; [EOL]         case Compiler.FUNCTION_FORMAT_NUMBER: [EOL]             return args != null && args.length == 2; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 142,186
public String toString() { [EOL]     StringBuffer buffer = new StringBuffer(); [EOL]     buffer.append(getFunctionName()); [EOL]     buffer.append('('); [EOL]     Expression[] args = getArguments(); [EOL]     if (args != null) { [EOL]         for (int i = 0; i < args.length; i++) { [EOL]             if (i > 0) { [EOL]                 buffer.append(", "); [EOL]             } [EOL]             buffer.append(args[i]); [EOL]         } [EOL]     } [EOL]     buffer.append(')'); [EOL]     return buffer.toString(); [EOL] } <line_num>: 188,203
public Object compute(EvalContext context) { [EOL]     return computeValue(context); [EOL] } <line_num>: 205,207
public Object computeValue(EvalContext context) { [EOL]     switch(functionCode) { [EOL]         case Compiler.FUNCTION_LAST: [EOL]             return functionLast(context); [EOL]         case Compiler.FUNCTION_POSITION: [EOL]             return functionPosition(context); [EOL]         case Compiler.FUNCTION_COUNT: [EOL]             return functionCount(context); [EOL]         case Compiler.FUNCTION_LANG: [EOL]             return functionLang(context); [EOL]         case Compiler.FUNCTION_ID: [EOL]             return functionID(context); [EOL]         case Compiler.FUNCTION_LOCAL_NAME: [EOL]             return functionLocalName(context); [EOL]         case Compiler.FUNCTION_NAMESPACE_URI: [EOL]             return functionNamespaceURI(context); [EOL]         case Compiler.FUNCTION_NAME: [EOL]             return functionName(context); [EOL]         case Compiler.FUNCTION_STRING: [EOL]             return functionString(context); [EOL]         case Compiler.FUNCTION_CONCAT: [EOL]             return functionConcat(context); [EOL]         case Compiler.FUNCTION_STARTS_WITH: [EOL]             return functionStartsWith(context); [EOL]         case Compiler.FUNCTION_CONTAINS: [EOL]             return functionContains(context); [EOL]         case Compiler.FUNCTION_SUBSTRING_BEFORE: [EOL]             return functionSubstringBefore(context); [EOL]         case Compiler.FUNCTION_SUBSTRING_AFTER: [EOL]             return functionSubstringAfter(context); [EOL]         case Compiler.FUNCTION_SUBSTRING: [EOL]             return functionSubstring(context); [EOL]         case Compiler.FUNCTION_STRING_LENGTH: [EOL]             return functionStringLength(context); [EOL]         case Compiler.FUNCTION_NORMALIZE_SPACE: [EOL]             return functionNormalizeSpace(context); [EOL]         case Compiler.FUNCTION_TRANSLATE: [EOL]             return functionTranslate(context); [EOL]         case Compiler.FUNCTION_BOOLEAN: [EOL]             return functionBoolean(context); [EOL]         case Compiler.FUNCTION_NOT: [EOL]             return functionNot(context); [EOL]         case Compiler.FUNCTION_TRUE: [EOL]             return functionTrue(context); [EOL]         case Compiler.FUNCTION_FALSE: [EOL]             return functionFalse(context); [EOL]         case Compiler.FUNCTION_NULL: [EOL]             return functionNull(context); [EOL]         case Compiler.FUNCTION_NUMBER: [EOL]             return functionNumber(context); [EOL]         case Compiler.FUNCTION_SUM: [EOL]             return functionSum(context); [EOL]         case Compiler.FUNCTION_FLOOR: [EOL]             return functionFloor(context); [EOL]         case Compiler.FUNCTION_CEILING: [EOL]             return functionCeiling(context); [EOL]         case Compiler.FUNCTION_ROUND: [EOL]             return functionRound(context); [EOL]         case Compiler.FUNCTION_KEY: [EOL]             return functionKey(context); [EOL]         case Compiler.FUNCTION_FORMAT_NUMBER: [EOL]             return functionFormatNumber(context); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 212,276
protected Object functionLast(EvalContext context) { [EOL]     assertArgCount(0); [EOL]     int old = context.getCurrentPosition(); [EOL]     context.reset(); [EOL]     int count = 0; [EOL]     while (context.nextNode()) { [EOL]         count++; [EOL]     } [EOL]     if (old != 0) { [EOL]         context.setPosition(old); [EOL]     } [EOL]     return new Double(count); [EOL] } <line_num>: 278,294
protected Object functionPosition(EvalContext context) { [EOL]     assertArgCount(0); [EOL]     return new Integer(context.getCurrentPosition()); [EOL] } <line_num>: 296,299
protected Object functionCount(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     Expression arg1 = getArg1(); [EOL]     int count = 0; [EOL]     Object value = arg1.compute(context); [EOL]     if (value instanceof NodePointer) { [EOL]         value = ((NodePointer) value).getValue(); [EOL]     } [EOL]     if (value instanceof EvalContext) { [EOL]         EvalContext ctx = (EvalContext) value; [EOL]         while (ctx.hasNext()) { [EOL]             ctx.next(); [EOL]             count++; [EOL]         } [EOL]     } else if (value instanceof Collection) { [EOL]         count = ((Collection) value).size(); [EOL]     } else if (value == null) { [EOL]         count = 0; [EOL]     } else { [EOL]         count = 1; [EOL]     } [EOL]     return new Double(count); [EOL] } <line_num>: 301,326
protected Object functionLang(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     String lang = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     NodePointer pointer = (NodePointer) context.getSingleNodePointer(); [EOL]     if (pointer == null) { [EOL]         return Boolean.FALSE; [EOL]     } [EOL]     return pointer.isLanguage(lang) ? Boolean.TRUE : Boolean.FALSE; [EOL] } <line_num>: 328,336
protected Object functionID(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     String id = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     JXPathContext jxpathContext = context.getJXPathContext(); [EOL]     NodePointer pointer = (NodePointer) jxpathContext.getContextPointer(); [EOL]     return pointer.getPointerByID(jxpathContext, id); [EOL] } <line_num>: 338,344
protected Object functionKey(EvalContext context) { [EOL]     assertArgCount(2); [EOL]     String key = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     String value = InfoSetUtil.stringValue(getArg2().computeValue(context)); [EOL]     JXPathContext jxpathContext = context.getJXPathContext(); [EOL]     NodePointer pointer = (NodePointer) jxpathContext.getContextPointer(); [EOL]     return pointer.getPointerByKey(jxpathContext, key, value); [EOL] } <line_num>: 346,353
protected Object functionNamespaceURI(EvalContext context) { [EOL]     if (getArgumentCount() == 0) { [EOL]         NodePointer ptr = context.getCurrentNodePointer(); [EOL]         String str = ptr.getNamespaceURI(); [EOL]         return str == null ? "" : str; [EOL]     } [EOL]     assertArgCount(1); [EOL]     Object set = getArg1().compute(context); [EOL]     if (set instanceof EvalContext) { [EOL]         EvalContext ctx = (EvalContext) set; [EOL]         if (ctx.hasNext()) { [EOL]             NodePointer ptr = (NodePointer) ctx.next(); [EOL]             String str = ptr.getNamespaceURI(); [EOL]             return str == null ? "" : str; [EOL]         } [EOL]     } [EOL]     return ""; [EOL] } <line_num>: 355,372
protected Object functionLocalName(EvalContext context) { [EOL]     if (getArgumentCount() == 0) { [EOL]         NodePointer ptr = context.getCurrentNodePointer(); [EOL]         return ptr.getName().getName(); [EOL]     } [EOL]     assertArgCount(1); [EOL]     Object set = getArg1().compute(context); [EOL]     if (set instanceof EvalContext) { [EOL]         EvalContext ctx = (EvalContext) set; [EOL]         if (ctx.hasNext()) { [EOL]             NodePointer ptr = (NodePointer) ctx.next(); [EOL]             return ptr.getName().getName(); [EOL]         } [EOL]     } [EOL]     return ""; [EOL] } <line_num>: 374,389
protected Object functionName(EvalContext context) { [EOL]     if (getArgumentCount() == 0) { [EOL]         NodePointer ptr = context.getCurrentNodePointer(); [EOL]         return ptr.getName().toString(); [EOL]     } [EOL]     assertArgCount(1); [EOL]     Object set = getArg1().compute(context); [EOL]     if (set instanceof EvalContext) { [EOL]         EvalContext ctx = (EvalContext) set; [EOL]         if (ctx.hasNext()) { [EOL]             NodePointer ptr = (NodePointer) ctx.next(); [EOL]             return ptr.getName().toString(); [EOL]         } [EOL]     } [EOL]     return ""; [EOL] } <line_num>: 391,406
protected Object functionString(EvalContext context) { [EOL]     if (getArgumentCount() == 0) { [EOL]         return InfoSetUtil.stringValue(context.getCurrentNodePointer()); [EOL]     } [EOL]     assertArgCount(1); [EOL]     return InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL] } <line_num>: 408,414
protected Object functionConcat(EvalContext context) { [EOL]     if (getArgumentCount() < 2) { [EOL]         assertArgCount(2); [EOL]     } [EOL]     StringBuffer buffer = new StringBuffer(); [EOL]     Expression[] args = getArguments(); [EOL]     for (int i = 0; i < args.length; i++) { [EOL]         buffer.append(InfoSetUtil.stringValue(args[i].compute(context))); [EOL]     } [EOL]     return buffer.toString(); [EOL] } <line_num>: 416,426
protected Object functionStartsWith(EvalContext context) { [EOL]     assertArgCount(2); [EOL]     String s1 = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     String s2 = InfoSetUtil.stringValue(getArg2().computeValue(context)); [EOL]     return s1.startsWith(s2) ? Boolean.TRUE : Boolean.FALSE; [EOL] } <line_num>: 428,433
protected Object functionContains(EvalContext context) { [EOL]     assertArgCount(2); [EOL]     String s1 = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     String s2 = InfoSetUtil.stringValue(getArg2().computeValue(context)); [EOL]     return s1.indexOf(s2) != -1 ? Boolean.TRUE : Boolean.FALSE; [EOL] } <line_num>: 435,440
protected Object functionSubstringBefore(EvalContext context) { [EOL]     assertArgCount(2); [EOL]     String s1 = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     String s2 = InfoSetUtil.stringValue(getArg2().computeValue(context)); [EOL]     int index = s1.indexOf(s2); [EOL]     if (index == -1) { [EOL]         return ""; [EOL]     } [EOL]     return s1.substring(0, index); [EOL] } <line_num>: 442,451
protected Object functionSubstringAfter(EvalContext context) { [EOL]     assertArgCount(2); [EOL]     String s1 = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     String s2 = InfoSetUtil.stringValue(getArg2().computeValue(context)); [EOL]     int index = s1.indexOf(s2); [EOL]     if (index == -1) { [EOL]         return ""; [EOL]     } [EOL]     return s1.substring(index + s2.length()); [EOL] } <line_num>: 453,462
protected Object functionSubstring(EvalContext context) { [EOL]     int ac = getArgumentCount(); [EOL]     if (ac != 2 && ac != 3) { [EOL]         assertArgCount(2); [EOL]     } [EOL]     String s1 = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     double from = InfoSetUtil.doubleValue(getArg2().computeValue(context)); [EOL]     if (Double.isNaN(from)) { [EOL]         return ""; [EOL]     } [EOL]     from = Math.round(from); [EOL]     if (from > s1.length() + 1) { [EOL]         return ""; [EOL]     } [EOL]     if (ac == 2) { [EOL]         if (from < 1) { [EOL]             from = 1; [EOL]         } [EOL]         return s1.substring((int) from - 1); [EOL]     } else { [EOL]         double length = InfoSetUtil.doubleValue(getArg3().computeValue(context)); [EOL]         length = Math.round(length); [EOL]         if (length < 0) { [EOL]             return ""; [EOL]         } [EOL]         double to = from + length; [EOL]         if (to < 1) { [EOL]             return ""; [EOL]         } [EOL]         if (to > s1.length() + 1) { [EOL]             if (from < 1) { [EOL]                 from = 1; [EOL]             } [EOL]             return s1.substring((int) from - 1); [EOL]         } [EOL]         if (from < 1) { [EOL]             from = 1; [EOL]         } [EOL]         return s1.substring((int) from - 1, (int) (to - 1)); [EOL]     } [EOL] } <line_num>: 464,511
protected Object functionStringLength(EvalContext context) { [EOL]     String s; [EOL]     if (getArgumentCount() == 0) { [EOL]         s = InfoSetUtil.stringValue(context.getCurrentNodePointer()); [EOL]     } else { [EOL]         assertArgCount(1); [EOL]         s = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     } [EOL]     return new Double(s.length()); [EOL] } <line_num>: 513,523
protected Object functionNormalizeSpace(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     String s = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     char[] chars = s.toCharArray(); [EOL]     int out = 0; [EOL]     int phase = 0; [EOL]     for (int in = 0; in < chars.length; in++) { [EOL]         switch(chars[in]) { [EOL]             case 0x20: [EOL]             case 0x9: [EOL]             case 0xD: [EOL]             case 0xA: [EOL]                 if (phase == 0) { [EOL]                     ; [EOL]                 } else if (phase == 1) { [EOL]                     phase = 2; [EOL]                     chars[out++] = ' '; [EOL]                 } [EOL]                 break; [EOL]             default: [EOL]                 chars[out++] = chars[in]; [EOL]                 phase = 1; [EOL]         } [EOL]     } [EOL]     if (phase == 2) { [EOL]         out--; [EOL]     } [EOL]     return new String(chars, 0, out); [EOL] } <line_num>: 525,554
protected Object functionTranslate(EvalContext context) { [EOL]     assertArgCount(3); [EOL]     String s1 = InfoSetUtil.stringValue(getArg1().computeValue(context)); [EOL]     String s2 = InfoSetUtil.stringValue(getArg2().computeValue(context)); [EOL]     String s3 = InfoSetUtil.stringValue(getArg3().computeValue(context)); [EOL]     char[] chars = s1.toCharArray(); [EOL]     int out = 0; [EOL]     for (int in = 0; in < chars.length; in++) { [EOL]         char c = chars[in]; [EOL]         int inx = s2.indexOf(c); [EOL]         if (inx != -1) { [EOL]             if (inx < s3.length()) { [EOL]                 chars[out++] = s3.charAt(inx); [EOL]             } [EOL]         } else { [EOL]             chars[out++] = c; [EOL]         } [EOL]     } [EOL]     return new String(chars, 0, out); [EOL] } <line_num>: 556,576
protected Object functionBoolean(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     return InfoSetUtil.booleanValue(getArg1().computeValue(context)) ? Boolean.TRUE : Boolean.FALSE; [EOL] } <line_num>: 578,583
protected Object functionNot(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     return InfoSetUtil.booleanValue(getArg1().computeValue(context)) ? Boolean.FALSE : Boolean.TRUE; [EOL] } <line_num>: 585,590
protected Object functionTrue(EvalContext context) { [EOL]     assertArgCount(0); [EOL]     return Boolean.TRUE; [EOL] } <line_num>: 592,595
protected Object functionFalse(EvalContext context) { [EOL]     assertArgCount(0); [EOL]     return Boolean.FALSE; [EOL] } <line_num>: 597,600
protected Object functionNull(EvalContext context) { [EOL]     assertArgCount(0); [EOL]     return null; [EOL] } <line_num>: 602,605
protected Object functionNumber(EvalContext context) { [EOL]     if (getArgumentCount() == 0) { [EOL]         return InfoSetUtil.number(context.getCurrentNodePointer()); [EOL]     } [EOL]     assertArgCount(1); [EOL]     return InfoSetUtil.number(getArg1().computeValue(context)); [EOL] } <line_num>: 607,613
protected Object functionSum(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     Object v = getArg1().compute(context); [EOL]     if (v == null) { [EOL]         return ZERO; [EOL]     } else if (v instanceof EvalContext) { [EOL]         double sum = 0.0; [EOL]         EvalContext ctx = (EvalContext) v; [EOL]         while (ctx.hasNext()) { [EOL]             NodePointer ptr = (NodePointer) ctx.next(); [EOL]             sum += InfoSetUtil.doubleValue(ptr); [EOL]         } [EOL]         return new Double(sum); [EOL]     } [EOL]     throw new JXPathException("Invalid argument type for 'sum': " + v.getClass().getName()); [EOL] } <line_num>: 615,632
protected Object functionFloor(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     double v = InfoSetUtil.doubleValue(getArg1().computeValue(context)); [EOL]     return new Double(Math.floor(v)); [EOL] } <line_num>: 634,638
protected Object functionCeiling(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     double v = InfoSetUtil.doubleValue(getArg1().computeValue(context)); [EOL]     return new Double(Math.ceil(v)); [EOL] } <line_num>: 640,644
protected Object functionRound(EvalContext context) { [EOL]     assertArgCount(1); [EOL]     double v = InfoSetUtil.doubleValue(getArg1().computeValue(context)); [EOL]     return new Double(Math.round(v)); [EOL] } <line_num>: 646,650
private Object functionFormatNumber(EvalContext context) { [EOL]     int ac = getArgumentCount(); [EOL]     if (ac != 2 && ac != 3) { [EOL]         assertArgCount(2); [EOL]     } [EOL]     double number = InfoSetUtil.doubleValue(getArg1().computeValue(context)); [EOL]     String pattern = InfoSetUtil.stringValue(getArg2().computeValue(context)); [EOL]     DecimalFormatSymbols symbols = null; [EOL]     if (ac == 3) { [EOL]         String symbolsName = InfoSetUtil.stringValue(getArg3().computeValue(context)); [EOL]         symbols = context.getJXPathContext().getDecimalFormatSymbols(symbolsName); [EOL]     } else { [EOL]         NodePointer pointer = context.getCurrentNodePointer(); [EOL]         Locale locale; [EOL]         if (pointer != null) { [EOL]             locale = pointer.getLocale(); [EOL]         } else { [EOL]             locale = context.getJXPathContext().getLocale(); [EOL]         } [EOL]         symbols = new DecimalFormatSymbols(locale); [EOL]     } [EOL]     DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(); [EOL]     format.setDecimalFormatSymbols(symbols); [EOL]     format.applyLocalizedPattern(pattern); [EOL]     return format.format(number); [EOL] } <line_num>: 652,686
private void assertArgCount(int count) { [EOL]     if (getArgumentCount() != count) { [EOL]         throw new JXPathInvalidSyntaxException("Incorrect number of argument: " + this); [EOL]     } [EOL] } <line_num>: 688,693