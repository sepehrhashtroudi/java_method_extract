protected ConverterManager() { [EOL]     super(); [EOL]     iInstantConverters = new ConverterSet(new Converter[] { ReadableInstantConverter.INSTANCE, StringConverter.INSTANCE, CalendarConverter.INSTANCE, DateConverter.INSTANCE, LongConverter.INSTANCE, NullConverter.INSTANCE }); [EOL]     iPartialConverters = new ConverterSet(new Converter[] { ReadablePartialConverter.INSTANCE, ReadableInstantConverter.INSTANCE, StringConverter.INSTANCE, CalendarConverter.INSTANCE, DateConverter.INSTANCE, LongConverter.INSTANCE, NullConverter.INSTANCE }); [EOL]     iDurationConverters = new ConverterSet(new Converter[] { ReadableDurationConverter.INSTANCE, ReadableIntervalConverter.INSTANCE, StringConverter.INSTANCE, LongConverter.INSTANCE, NullConverter.INSTANCE }); [EOL]     iPeriodConverters = new ConverterSet(new Converter[] { ReadableDurationConverter.INSTANCE, ReadablePeriodConverter.INSTANCE, ReadableIntervalConverter.INSTANCE, StringConverter.INSTANCE, NullConverter.INSTANCE }); [EOL]     iIntervalConverters = new ConverterSet(new Converter[] { ReadableIntervalConverter.INSTANCE, StringConverter.INSTANCE, NullConverter.INSTANCE }); [EOL] } <line_num>: 104,147
public static ConverterManager getInstance() { [EOL]     if (INSTANCE == null) { [EOL]         INSTANCE = new ConverterManager(); [EOL]     } [EOL]     return INSTANCE; [EOL] } <line_num>: 88,93
public InstantConverter getInstantConverter(Object object) { [EOL]     InstantConverter converter = (InstantConverter) iInstantConverters.select(object == null ? null : object.getClass()); [EOL]     if (converter != null) { [EOL]         return converter; [EOL]     } [EOL]     throw new IllegalArgumentException("No instant converter found for type: " + (object == null ? "null" : object.getClass().getName())); [EOL] } <line_num>: 159,167
public InstantConverter[] getInstantConverters() { [EOL]     ConverterSet set = iInstantConverters; [EOL]     InstantConverter[] converters = new InstantConverter[set.size()]; [EOL]     set.copyInto(converters); [EOL]     return converters; [EOL] } <line_num>: 175,180
public InstantConverter addInstantConverter(InstantConverter converter) throws SecurityException { [EOL]     checkAlterInstantConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     InstantConverter[] removed = new InstantConverter[1]; [EOL]     iInstantConverters = iInstantConverters.add(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 193,203
public InstantConverter removeInstantConverter(InstantConverter converter) throws SecurityException { [EOL]     checkAlterInstantConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     InstantConverter[] removed = new InstantConverter[1]; [EOL]     iInstantConverters = iInstantConverters.remove(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 212,222
private void checkAlterInstantConverters() throws SecurityException { [EOL]     SecurityManager sm = System.getSecurityManager(); [EOL]     if (sm != null) { [EOL]         sm.checkPermission(new JodaTimePermission("ConverterManager.alterInstantConverters")); [EOL]     } [EOL] } <line_num>: 229,234
public PartialConverter getPartialConverter(Object object) { [EOL]     PartialConverter converter = (PartialConverter) iPartialConverters.select(object == null ? null : object.getClass()); [EOL]     if (converter != null) { [EOL]         return converter; [EOL]     } [EOL]     throw new IllegalArgumentException("No partial converter found for type: " + (object == null ? "null" : object.getClass().getName())); [EOL] } <line_num>: 246,254
public PartialConverter[] getPartialConverters() { [EOL]     ConverterSet set = iPartialConverters; [EOL]     PartialConverter[] converters = new PartialConverter[set.size()]; [EOL]     set.copyInto(converters); [EOL]     return converters; [EOL] } <line_num>: 262,267
public PartialConverter addPartialConverter(PartialConverter converter) throws SecurityException { [EOL]     checkAlterPartialConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     PartialConverter[] removed = new PartialConverter[1]; [EOL]     iPartialConverters = iPartialConverters.add(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 280,290
public PartialConverter removePartialConverter(PartialConverter converter) throws SecurityException { [EOL]     checkAlterPartialConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     PartialConverter[] removed = new PartialConverter[1]; [EOL]     iPartialConverters = iPartialConverters.remove(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 299,309
private void checkAlterPartialConverters() throws SecurityException { [EOL]     SecurityManager sm = System.getSecurityManager(); [EOL]     if (sm != null) { [EOL]         sm.checkPermission(new JodaTimePermission("ConverterManager.alterPartialConverters")); [EOL]     } [EOL] } <line_num>: 316,321
public DurationConverter getDurationConverter(Object object) { [EOL]     DurationConverter converter = (DurationConverter) iDurationConverters.select(object == null ? null : object.getClass()); [EOL]     if (converter != null) { [EOL]         return converter; [EOL]     } [EOL]     throw new IllegalArgumentException("No duration converter found for type: " + (object == null ? "null" : object.getClass().getName())); [EOL] } <line_num>: 333,341
public DurationConverter[] getDurationConverters() { [EOL]     ConverterSet set = iDurationConverters; [EOL]     DurationConverter[] converters = new DurationConverter[set.size()]; [EOL]     set.copyInto(converters); [EOL]     return converters; [EOL] } <line_num>: 349,354
public DurationConverter addDurationConverter(DurationConverter converter) throws SecurityException { [EOL]     checkAlterDurationConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     DurationConverter[] removed = new DurationConverter[1]; [EOL]     iDurationConverters = iDurationConverters.add(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 367,377
public DurationConverter removeDurationConverter(DurationConverter converter) throws SecurityException { [EOL]     checkAlterDurationConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     DurationConverter[] removed = new DurationConverter[1]; [EOL]     iDurationConverters = iDurationConverters.remove(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 386,396
private void checkAlterDurationConverters() throws SecurityException { [EOL]     SecurityManager sm = System.getSecurityManager(); [EOL]     if (sm != null) { [EOL]         sm.checkPermission(new JodaTimePermission("ConverterManager.alterDurationConverters")); [EOL]     } [EOL] } <line_num>: 403,408
public PeriodConverter getPeriodConverter(Object object) { [EOL]     PeriodConverter converter = (PeriodConverter) iPeriodConverters.select(object == null ? null : object.getClass()); [EOL]     if (converter != null) { [EOL]         return converter; [EOL]     } [EOL]     throw new IllegalArgumentException("No period converter found for type: " + (object == null ? "null" : object.getClass().getName())); [EOL] } <line_num>: 420,428
public PeriodConverter[] getPeriodConverters() { [EOL]     ConverterSet set = iPeriodConverters; [EOL]     PeriodConverter[] converters = new PeriodConverter[set.size()]; [EOL]     set.copyInto(converters); [EOL]     return converters; [EOL] } <line_num>: 436,441
public PeriodConverter addPeriodConverter(PeriodConverter converter) throws SecurityException { [EOL]     checkAlterPeriodConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     PeriodConverter[] removed = new PeriodConverter[1]; [EOL]     iPeriodConverters = iPeriodConverters.add(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 454,464
public PeriodConverter removePeriodConverter(PeriodConverter converter) throws SecurityException { [EOL]     checkAlterPeriodConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     PeriodConverter[] removed = new PeriodConverter[1]; [EOL]     iPeriodConverters = iPeriodConverters.remove(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 473,483
private void checkAlterPeriodConverters() throws SecurityException { [EOL]     SecurityManager sm = System.getSecurityManager(); [EOL]     if (sm != null) { [EOL]         sm.checkPermission(new JodaTimePermission("ConverterManager.alterPeriodConverters")); [EOL]     } [EOL] } <line_num>: 490,495
public IntervalConverter getIntervalConverter(Object object) { [EOL]     IntervalConverter converter = (IntervalConverter) iIntervalConverters.select(object == null ? null : object.getClass()); [EOL]     if (converter != null) { [EOL]         return converter; [EOL]     } [EOL]     throw new IllegalArgumentException("No interval converter found for type: " + (object == null ? "null" : object.getClass().getName())); [EOL] } <line_num>: 507,515
public IntervalConverter[] getIntervalConverters() { [EOL]     ConverterSet set = iIntervalConverters; [EOL]     IntervalConverter[] converters = new IntervalConverter[set.size()]; [EOL]     set.copyInto(converters); [EOL]     return converters; [EOL] } <line_num>: 523,528
public IntervalConverter addIntervalConverter(IntervalConverter converter) throws SecurityException { [EOL]     checkAlterIntervalConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     IntervalConverter[] removed = new IntervalConverter[1]; [EOL]     iIntervalConverters = iIntervalConverters.add(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 541,551
public IntervalConverter removeIntervalConverter(IntervalConverter converter) throws SecurityException { [EOL]     checkAlterIntervalConverters(); [EOL]     if (converter == null) { [EOL]         return null; [EOL]     } [EOL]     IntervalConverter[] removed = new IntervalConverter[1]; [EOL]     iIntervalConverters = iIntervalConverters.remove(converter, removed); [EOL]     return removed[0]; [EOL] } <line_num>: 560,570
private void checkAlterIntervalConverters() throws SecurityException { [EOL]     SecurityManager sm = System.getSecurityManager(); [EOL]     if (sm != null) { [EOL]         sm.checkPermission(new JodaTimePermission("ConverterManager.alterIntervalConverters")); [EOL]     } [EOL] } <line_num>: 577,582
public String toString() { [EOL]     return "ConverterManager[" + iInstantConverters.size() + " instant," + iPartialConverters.size() + " partial," + iDurationConverters.size() + " duration," + iPeriodConverters.size() + " period," + iIntervalConverters.size() + " interval]"; [EOL] } <line_num>: 588,595
