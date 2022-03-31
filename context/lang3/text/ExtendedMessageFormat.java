ExtendedMessageFormat
public String toPattern()
public final void applyPattern(final String pattern)
public void setFormat(final int formatElementIndex, final Format newFormat)
public void setFormatByArgumentIndex(final int argumentIndex, final Format newFormat)
public void setFormats(final Format[] newFormats)
public void setFormatsByArgumentIndex(final Format[] newFormats)
public boolean equals(final Object obj)
public int hashCode()
private Format getFormat(final String desc)
private int readArgumentIndex(final String pattern, final ParsePosition pos)
private String parseFormatDescription(final String pattern, final ParsePosition pos)
private String insertFormats(final String pattern, final ArrayList<String> customPatterns)
private void seekNonWs(final String pattern, final ParsePosition pos)
private ParsePosition next(final ParsePosition pos)
private StringBuilder appendQuotedString(final String pattern, final ParsePosition pos, final StringBuilder appendTo, final boolean escapingOn)
private void getQuotedString(final String pattern, final ParsePosition pos, final boolean escapingOn)
private boolean containsElements(final Collection<?> coll)
long serialVersionUID=Optional[-2362048321261811743L]
int HASH_SEED=Optional[31]
String DUMMY_PATTERN=Optional[""]
String ESCAPED_QUOTE=Optional["''"]
char START_FMT=Optional[',']
char END_FE=Optional['}']
char START_FE=Optional['{']
char QUOTE=Optional['\'']
String toPattern
Map<String, ? extends FormatFactory> registry
