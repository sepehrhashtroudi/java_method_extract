protected PeriodFormat() { [EOL]     super(); [EOL] } <line_num>: 54,56
public static PeriodFormatter getDefault() { [EOL]     return wordBased(Locale.ENGLISH); [EOL] } <line_num>: 66,68
public static PeriodFormatter wordBased() { [EOL]     return wordBased(Locale.getDefault()); [EOL] } <line_num>: 78,80
public static PeriodFormatter wordBased(Locale locale) { [EOL]     PeriodFormatter pf = FORMATTERS.get(locale); [EOL]     if (pf == null) { [EOL]         ResourceBundle b = ResourceBundle.getBundle(BUNDLE_NAME, locale); [EOL]         String[] variants = { b.getString("PeriodFormat.space"), b.getString("PeriodFormat.comma"), b.getString("PeriodFormat.commandand"), b.getString("PeriodFormat.commaspaceand") }; [EOL]         pf = new PeriodFormatterBuilder().appendYears().appendSuffix(b.getString("PeriodFormat.year"), b.getString("PeriodFormat.years")).appendSeparator(b.getString("PeriodFormat.commaspace"), b.getString("PeriodFormat.spaceandspace"), variants).appendMonths().appendSuffix(b.getString("PeriodFormat.month"), b.getString("PeriodFormat.months")).appendSeparator(b.getString("PeriodFormat.commaspace"), b.getString("PeriodFormat.spaceandspace"), variants).appendWeeks().appendSuffix(b.getString("PeriodFormat.week"), b.getString("PeriodFormat.weeks")).appendSeparator(b.getString("PeriodFormat.commaspace"), b.getString("PeriodFormat.spaceandspace"), variants).appendDays().appendSuffix(b.getString("PeriodFormat.day"), b.getString("PeriodFormat.days")).appendSeparator(b.getString("PeriodFormat.commaspace"), b.getString("PeriodFormat.spaceandspace"), variants).appendHours().appendSuffix(b.getString("PeriodFormat.hour"), b.getString("PeriodFormat.hours")).appendSeparator(b.getString("PeriodFormat.commaspace"), b.getString("PeriodFormat.spaceandspace"), variants).appendMinutes().appendSuffix(b.getString("PeriodFormat.minute"), b.getString("PeriodFormat.minutes")).appendSeparator(b.getString("PeriodFormat.commaspace"), b.getString("PeriodFormat.spaceandspace"), variants).appendSeconds().appendSuffix(b.getString("PeriodFormat.second"), b.getString("PeriodFormat.seconds")).appendSeparator(b.getString("PeriodFormat.commaspace"), b.getString("PeriodFormat.spaceandspace"), variants).appendMillis().appendSuffix(b.getString("PeriodFormat.millisecond"), b.getString("PeriodFormat.milliseconds")).toFormatter(); [EOL]         FORMATTERS.putIfAbsent(locale, pf); [EOL]     } [EOL]     return pf; [EOL] } <line_num>: 94,129