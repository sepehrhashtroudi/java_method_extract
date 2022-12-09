public SpreadsheetDate(final int day, final int month, final int year)
public SpreadsheetDate(final int serial)
public int toSerial()
public Date toDate()
public int getYYYY()
public int getMonth()
public int getDayOfMonth()
public int getDayOfWeek()
public boolean equals(final Object object)
public int hashCode()
public int compare(final SerialDate other)
public int compareTo(final Object other)
public boolean isOn(final SerialDate other)
public boolean isBefore(final SerialDate other)
public boolean isOnOrBefore(final SerialDate other)
public boolean isAfter(final SerialDate other)
public boolean isOnOrAfter(final SerialDate other)
public boolean isInRange(final SerialDate d1, final SerialDate d2)
public boolean isInRange(final SerialDate d1, final SerialDate d2, final int include)
private int calcSerial(final int d, final int m, final int y)
long serialVersionUID=Optional[-2039586705374454461L]
int serial
int day
int month
int year
