public String[] getPropertyNames(Object object) { [EOL]     Map map = (Map) object; [EOL]     Set set = map.keySet(); [EOL]     String[] names = new String[set.size()]; [EOL]     Iterator it = set.iterator(); [EOL]     for (int i = 0; i < names.length; i++) { [EOL]         names[i] = String.valueOf(it.next()); [EOL]     } [EOL]     return names; [EOL] } <line_num>: 36,45
public Object getProperty(Object object, String propertyName) { [EOL]     return ((Map) object).get(propertyName); [EOL] } <line_num>: 50,52
public void setProperty(Object object, String propertyName, Object value) { [EOL]     ((Map) object).put(propertyName, value); [EOL] } <line_num>: 57,59
