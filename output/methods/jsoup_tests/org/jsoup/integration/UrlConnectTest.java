public void fetchURl() throws IOException { [EOL]     String url = "http://www.google.com"; [EOL]     Document doc = Jsoup.parse(new URL(url), 10 * 1000); [EOL]     assertTrue(doc.title().contains("Google")); [EOL] } <line_num>: 17,21
public void exceptOnUnknownContentType() { [EOL]     String url = "http://jsoup.org/rez/osi_logo.png"; [EOL]     boolean threw = false; [EOL]     try { [EOL]         Document doc = Jsoup.parse(new URL(url), 3000); [EOL]     } catch (IOException e) { [EOL]         threw = true; [EOL]     } [EOL]     assertTrue(threw); [EOL] } <line_num>: 24,33
@Test [EOL] public void noop() { [EOL] } <line_num>: 35,35