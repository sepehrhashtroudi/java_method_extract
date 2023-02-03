@JsonCreator [EOL] MyException(@JsonProperty("message") String msg, @JsonProperty("value") int v) { [EOL]     super(msg); [EOL]     myMessage = msg; [EOL]     value = v; [EOL] } <line_num>: 24,30
@JsonCreator [EOL] MyNoArgException() { [EOL] } <line_num>: 45,45
public int getValue() { [EOL]     return value; [EOL] } <line_num>: 32,32
public String getFoo() { [EOL]     return "bar"; [EOL] } <line_num>: 34,34
@JsonAnySetter [EOL] public void setter(String key, Object value) { [EOL]     stuff.put(key, value); [EOL] } <line_num>: 36,39
public void testIOException() throws IOException { [EOL]     IOException ioe = new IOException("TEST"); [EOL]     String json = MAPPER.writeValueAsString(ioe); [EOL]     IOException result = MAPPER.readValue(json, IOException.class); [EOL]     assertEquals(ioe.getMessage(), result.getMessage()); [EOL] } <line_num>: 56,62
public void testWithCreator() throws IOException { [EOL]     final String MSG = "the message"; [EOL]     String json = MAPPER.writeValueAsString(new MyException(MSG, 3)); [EOL]     MyException result = MAPPER.readValue(json, MyException.class); [EOL]     assertEquals(MSG, result.getMessage()); [EOL]     assertEquals(3, result.value); [EOL]     assertEquals(1, result.stuff.size()); [EOL]     assertEquals(result.getFoo(), result.stuff.get("foo")); [EOL] } <line_num>: 65,75
public void testWithNullMessage() throws IOException { [EOL]     final ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); [EOL]     String json = mapper.writeValueAsString(new IOException((String) null)); [EOL]     IOException result = mapper.readValue(json, IOException.class); [EOL]     assertNotNull(result); [EOL]     assertNull(result.getMessage()); [EOL] } <line_num>: 78,86
public void testNoArgsException() throws IOException { [EOL]     MyNoArgException exc = MAPPER.readValue("{}", MyNoArgException.class); [EOL]     assertNotNull(exc); [EOL] } <line_num>: 88,92
public void testJDK7SuppressionProperty() throws IOException { [EOL]     Exception exc = MAPPER.readValue("{\"suppressed\":[]}", IOException.class); [EOL]     assertNotNull(exc); [EOL] } <line_num>: 95,99
