Car(String name, int color) { [EOL]     this.name = name; [EOL]     this.color = color; [EOL] } <line_num>: 221,224
Car() { [EOL] } <line_num>: 227,227
public void testWriteMixedStreamed() throws IOException { [EOL]     Gson gson = new Gson(); [EOL]     StringWriter stringWriter = new StringWriter(); [EOL]     JsonWriter jsonWriter = new JsonWriter(stringWriter); [EOL]     jsonWriter.beginArray(); [EOL]     jsonWriter.setIndent("  "); [EOL]     gson.toJson(BLUE_MUSTANG, Car.class, jsonWriter); [EOL]     gson.toJson(BLACK_BMW, Car.class, jsonWriter); [EOL]     gson.toJson(RED_MIATA, Car.class, jsonWriter); [EOL]     jsonWriter.endArray(); [EOL]     assertEquals(CARS_JSON, stringWriter.toString()); [EOL] } <line_num>: 50,63
public void testReadMixedStreamed() throws IOException { [EOL]     Gson gson = new Gson(); [EOL]     StringReader stringReader = new StringReader(CARS_JSON); [EOL]     JsonReader jsonReader = new JsonReader(stringReader); [EOL]     jsonReader.beginArray(); [EOL]     assertEquals(BLUE_MUSTANG, gson.fromJson(jsonReader, Car.class)); [EOL]     assertEquals(BLACK_BMW, gson.fromJson(jsonReader, Car.class)); [EOL]     assertEquals(RED_MIATA, gson.fromJson(jsonReader, Car.class)); [EOL]     jsonReader.endArray(); [EOL] } <line_num>: 65,75
public void testReaderDoesNotMutateState() throws IOException { [EOL]     Gson gson = new Gson(); [EOL]     JsonReader jsonReader = new JsonReader(new StringReader(CARS_JSON)); [EOL]     jsonReader.beginArray(); [EOL]     jsonReader.setLenient(false); [EOL]     gson.fromJson(jsonReader, Car.class); [EOL]     assertFalse(jsonReader.isLenient()); [EOL]     jsonReader.setLenient(true); [EOL]     gson.fromJson(jsonReader, Car.class); [EOL]     assertTrue(jsonReader.isLenient()); [EOL] } <line_num>: 77,89
public void testWriteDoesNotMutateState() throws IOException { [EOL]     Gson gson = new Gson(); [EOL]     JsonWriter jsonWriter = new JsonWriter(new StringWriter()); [EOL]     jsonWriter.beginArray(); [EOL]     jsonWriter.setHtmlSafe(true); [EOL]     jsonWriter.setLenient(true); [EOL]     gson.toJson(BLUE_MUSTANG, Car.class, jsonWriter); [EOL]     assertTrue(jsonWriter.isHtmlSafe()); [EOL]     assertTrue(jsonWriter.isLenient()); [EOL]     jsonWriter.setHtmlSafe(false); [EOL]     jsonWriter.setLenient(false); [EOL]     gson.toJson(BLUE_MUSTANG, Car.class, jsonWriter); [EOL]     assertFalse(jsonWriter.isHtmlSafe()); [EOL]     assertFalse(jsonWriter.isLenient()); [EOL] } <line_num>: 91,107
public void testReadInvalidState() throws IOException { [EOL]     Gson gson = new Gson(); [EOL]     JsonReader jsonReader = new JsonReader(new StringReader(CARS_JSON)); [EOL]     jsonReader.beginArray(); [EOL]     jsonReader.beginObject(); [EOL]     try { [EOL]         gson.fromJson(jsonReader, String.class); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException expected) { [EOL]     } [EOL] } <line_num>: 109,119
public void testReadClosed() throws IOException { [EOL]     Gson gson = new Gson(); [EOL]     JsonReader jsonReader = new JsonReader(new StringReader(CARS_JSON)); [EOL]     jsonReader.close(); [EOL]     try { [EOL]         gson.fromJson(jsonReader, new TypeToken<List<Car>>() { [EOL]         }.getType()); [EOL]         fail(); [EOL]     } catch (IllegalStateException expected) { [EOL]     } [EOL] } <line_num>: 121,130
public void testWriteInvalidState() throws IOException { [EOL]     Gson gson = new Gson(); [EOL]     JsonWriter jsonWriter = new JsonWriter(new StringWriter()); [EOL]     jsonWriter.beginObject(); [EOL]     try { [EOL]         gson.toJson(BLUE_MUSTANG, Car.class, jsonWriter); [EOL]         fail(); [EOL]     } catch (IllegalStateException expected) { [EOL]     } [EOL] } <line_num>: 132,141
public void testWriteClosed() throws IOException { [EOL]     Gson gson = new Gson(); [EOL]     JsonWriter jsonWriter = new JsonWriter(new StringWriter()); [EOL]     jsonWriter.beginArray(); [EOL]     jsonWriter.endArray(); [EOL]     jsonWriter.close(); [EOL]     try { [EOL]         gson.toJson(BLUE_MUSTANG, Car.class, jsonWriter); [EOL]         fail(); [EOL]     } catch (IllegalStateException expected) { [EOL]     } [EOL] } <line_num>: 143,154
public void testWriteNulls() { [EOL]     Gson gson = new Gson(); [EOL]     try { [EOL]         gson.toJson(new JsonPrimitive("hello"), (JsonWriter) null); [EOL]         fail(); [EOL]     } catch (NullPointerException expected) { [EOL]     } [EOL]     StringWriter stringWriter = new StringWriter(); [EOL]     gson.toJson(null, new JsonWriter(stringWriter)); [EOL]     assertEquals("", stringWriter.toString()); [EOL] } <line_num>: 156,167
public void testReadNulls() { [EOL]     Gson gson = new Gson(); [EOL]     try { [EOL]         gson.fromJson((JsonReader) null, Integer.class); [EOL]         fail(); [EOL]     } catch (NullPointerException expected) { [EOL]     } [EOL]     try { [EOL]         gson.fromJson(new JsonReader(new StringReader("true")), null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException expected) { [EOL]     } [EOL] } <line_num>: 169,181
public void testWriteHtmlSafe() { [EOL]     List<String> contents = Arrays.asList("<", ">", "&", "=", "'"); [EOL]     Type type = new TypeToken<List<String>>() { [EOL]     }.getType(); [EOL]     StringWriter writer = new StringWriter(); [EOL]     new Gson().toJson(contents, type, new JsonWriter(writer)); [EOL]     assertEquals("[\"\\u003c\",\"\\u003e\",\"\\u0026\",\"\\u003d\",\"\\u0027\"]", writer.toString()); [EOL]     writer = new StringWriter(); [EOL]     new GsonBuilder().disableHtmlEscaping().create().toJson(contents, type, new JsonWriter(writer)); [EOL]     assertEquals("[\"<\",\">\",\"&\",\"=\",\"'\"]", writer.toString()); [EOL] } <line_num>: 183,197
public void testWriteLenient() { [EOL]     List<Double> doubles = Arrays.asList(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, -0.0d, 0.5d, 0.0d); [EOL]     Type type = new TypeToken<List<Double>>() { [EOL]     }.getType(); [EOL]     StringWriter writer = new StringWriter(); [EOL]     JsonWriter jsonWriter = new JsonWriter(writer); [EOL]     new GsonBuilder().serializeSpecialFloatingPointValues().create().toJson(doubles, type, jsonWriter); [EOL]     assertEquals("[NaN,-Infinity,Infinity,-0.0,0.5,0.0]", writer.toString()); [EOL]     try { [EOL]         new Gson().toJson(doubles, type, new JsonWriter(new StringWriter())); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException expected) { [EOL]     } [EOL] } <line_num>: 199,215
@Override [EOL] public int hashCode() { [EOL]     return name.hashCode() ^ color; [EOL] } <line_num>: 229,231
@Override [EOL] public boolean equals(Object o) { [EOL]     return o instanceof Car && ((Car) o).name.equals(name) && ((Car) o).color == color; [EOL] } <line_num>: 233,237
