public AbstractIntegrator(final String name) { [EOL]     this.name = name; [EOL]     stepHandlers = new ArrayList<StepHandler>(); [EOL]     stepStart = Double.NaN; [EOL]     stepSize = Double.NaN; [EOL]     eventsStates = new ArrayList<EventState>(); [EOL]     statesInitialized = false; [EOL]     evaluations = new Incrementor(); [EOL]     setMaxEvaluations(-1); [EOL]     evaluations.resetCount(); [EOL] } <line_num>: 84,94
protected AbstractIntegrator() { [EOL]     this(null); [EOL] } <line_num>: 98,100
public String getName() { [EOL]     return name; [EOL] } <line_num>: 103,105
public void addStepHandler(final StepHandler handler) { [EOL]     stepHandlers.add(handler); [EOL] } <line_num>: 108,110
public Collection<StepHandler> getStepHandlers() { [EOL]     return Collections.unmodifiableCollection(stepHandlers); [EOL] } <line_num>: 113,115
public void clearStepHandlers() { [EOL]     stepHandlers.clear(); [EOL] } <line_num>: 118,120
public void addEventHandler(final EventHandler handler, final double maxCheckInterval, final double convergence, final int maxIterationCount) { [EOL]     addEventHandler(handler, maxCheckInterval, convergence, maxIterationCount, new BracketingNthOrderBrentSolver(convergence, 5)); [EOL] } <line_num>: 123,130
public void addEventHandler(final EventHandler handler, final double maxCheckInterval, final double convergence, final int maxIterationCount, final UnivariateSolver solver) { [EOL]     eventsStates.add(new EventState(handler, maxCheckInterval, convergence, maxIterationCount, solver)); [EOL] } <line_num>: 133,140
public Collection<EventHandler> getEventHandlers() { [EOL]     final List<EventHandler> list = new ArrayList<EventHandler>(eventsStates.size()); [EOL]     for (EventState state : eventsStates) { [EOL]         list.add(state.getEventHandler()); [EOL]     } [EOL]     return Collections.unmodifiableCollection(list); [EOL] } <line_num>: 143,149
public void clearEventHandlers() { [EOL]     eventsStates.clear(); [EOL] } <line_num>: 152,154
public double getCurrentStepStart() { [EOL]     return stepStart; [EOL] } <line_num>: 157,159
public double getCurrentSignedStepsize() { [EOL]     return stepSize; [EOL] } <line_num>: 162,164
public void setMaxEvaluations(int maxEvaluations) { [EOL]     evaluations.setMaximalCount((maxEvaluations < 0) ? Integer.MAX_VALUE : maxEvaluations); [EOL] } <line_num>: 167,169
public int getMaxEvaluations() { [EOL]     return evaluations.getMaximalCount(); [EOL] } <line_num>: 172,174
public int getEvaluations() { [EOL]     return evaluations.getCount(); [EOL] } <line_num>: 177,179
protected void initIntegration(final double t0, final double[] y0, final double t) { [EOL]     evaluations.resetCount(); [EOL]     for (final EventState state : eventsStates) { [EOL]         state.setExpandable(expandable); [EOL]         state.getEventHandler().init(t0, y0, t); [EOL]     } [EOL]     for (StepHandler handler : stepHandlers) { [EOL]         handler.init(t0, y0, t); [EOL]     } [EOL]     setStateInitialized(false); [EOL] } <line_num>: 186,201
protected void setEquations(final ExpandableStatefulODE equations) { [EOL]     this.expandable = equations; [EOL] } <line_num>: 206,208
protected ExpandableStatefulODE getExpandable() { [EOL]     return expandable; [EOL] } <line_num>: 214,216
protected Incrementor getEvaluationsCounter() { [EOL]     return evaluations; [EOL] } <line_num>: 222,224
public double integrate(final FirstOrderDifferentialEquations equations, final double t0, final double[] y0, final double t, final double[] y) throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException { [EOL]     if (y0.length != equations.getDimension()) { [EOL]         throw new DimensionMismatchException(y0.length, equations.getDimension()); [EOL]     } [EOL]     if (y.length != equations.getDimension()) { [EOL]         throw new DimensionMismatchException(y.length, equations.getDimension()); [EOL]     } [EOL]     final ExpandableStatefulODE expandableODE = new ExpandableStatefulODE(equations); [EOL]     expandableODE.setTime(t0); [EOL]     expandableODE.setPrimaryState(y0); [EOL]     integrate(expandableODE, t); [EOL]     System.arraycopy(expandableODE.getPrimaryState(), 0, y, 0, y.length); [EOL]     return expandableODE.getTime(); [EOL] } <line_num>: 227,251
public abstract void integrate(ExpandableStatefulODE equations, double t) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException; <line_num>: 272,274
public void computeDerivatives(final double t, final double[] y, final double[] yDot) throws MaxCountExceededException, DimensionMismatchException { [EOL]     evaluations.incrementCount(); [EOL]     expandable.computeDerivatives(t, y, yDot); [EOL] } <line_num>: 283,287
protected void setStateInitialized(final boolean stateInitialized) { [EOL]     this.statesInitialized = stateInitialized; [EOL] } <line_num>: 296,298
public int compare(EventState es0, EventState es1) { [EOL]     return orderingSign * Double.compare(es0.getEventTime(), es1.getEventTime()); [EOL] } <line_num>: 333,335
protected double acceptStep(final AbstractStepInterpolator interpolator, final double[] y, final double[] yDot, final double tEnd) throws MaxCountExceededException, DimensionMismatchException, NoBracketingException { [EOL]     double previousT = interpolator.getGlobalPreviousTime(); [EOL]     final double currentT = interpolator.getGlobalCurrentTime(); [EOL]     if (!statesInitialized) { [EOL]         for (EventState state : eventsStates) { [EOL]             state.reinitializeBegin(interpolator); [EOL]         } [EOL]         statesInitialized = true; [EOL]     } [EOL]     final int orderingSign = interpolator.isForward() ? +1 : -1; [EOL]     SortedSet<EventState> occurringEvents = new TreeSet<EventState>(new Comparator<EventState>() { [EOL]  [EOL]         public int compare(EventState es0, EventState es1) { [EOL]             return orderingSign * Double.compare(es0.getEventTime(), es1.getEventTime()); [EOL]         } [EOL]     }); [EOL]     for (final EventState state : eventsStates) { [EOL]         if (state.evaluateStep(interpolator)) { [EOL]             occurringEvents.add(state); [EOL]         } [EOL]     } [EOL]     while (!occurringEvents.isEmpty()) { [EOL]         final Iterator<EventState> iterator = occurringEvents.iterator(); [EOL]         final EventState currentEvent = iterator.next(); [EOL]         iterator.remove(); [EOL]         final double eventT = currentEvent.getEventTime(); [EOL]         interpolator.setSoftPreviousTime(previousT); [EOL]         interpolator.setSoftCurrentTime(eventT); [EOL]         interpolator.setInterpolatedTime(eventT); [EOL]         final double[] eventYComplete = new double[y.length]; [EOL]         expandable.getPrimaryMapper().insertEquationData(interpolator.getInterpolatedState(), eventYComplete); [EOL]         int index = 0; [EOL]         for (EquationsMapper secondary : expandable.getSecondaryMappers()) { [EOL]             secondary.insertEquationData(interpolator.getInterpolatedSecondaryState(index++), eventYComplete); [EOL]         } [EOL]         for (final EventState state : eventsStates) { [EOL]             state.stepAccepted(eventT, eventYComplete); [EOL]             isLastStep = isLastStep || state.stop(); [EOL]         } [EOL]         for (final StepHandler handler : stepHandlers) { [EOL]             handler.handleStep(interpolator, isLastStep); [EOL]         } [EOL]         if (isLastStep) { [EOL]             System.arraycopy(eventYComplete, 0, y, 0, y.length); [EOL]             return eventT; [EOL]         } [EOL]         boolean needReset = false; [EOL]         for (final EventState state : eventsStates) { [EOL]             needReset = needReset || state.reset(eventT, eventYComplete); [EOL]         } [EOL]         if (needReset) { [EOL]             interpolator.setInterpolatedTime(eventT); [EOL]             System.arraycopy(eventYComplete, 0, y, 0, y.length); [EOL]             computeDerivatives(eventT, y, yDot); [EOL]             resetOccurred = true; [EOL]             return eventT; [EOL]         } [EOL]         previousT = eventT; [EOL]         interpolator.setSoftPreviousTime(eventT); [EOL]         interpolator.setSoftCurrentTime(currentT); [EOL]         if (currentEvent.evaluateStep(interpolator)) { [EOL]             occurringEvents.add(currentEvent); [EOL]         } [EOL]     } [EOL]     interpolator.setInterpolatedTime(currentT); [EOL]     final double[] currentY = new double[y.length]; [EOL]     expandable.getPrimaryMapper().insertEquationData(interpolator.getInterpolatedState(), currentY); [EOL]     int index = 0; [EOL]     for (EquationsMapper secondary : expandable.getSecondaryMappers()) { [EOL]         secondary.insertEquationData(interpolator.getInterpolatedSecondaryState(index++), currentY); [EOL]     } [EOL]     for (final EventState state : eventsStates) { [EOL]         state.stepAccepted(currentT, currentY); [EOL]         isLastStep = isLastStep || state.stop(); [EOL]     } [EOL]     isLastStep = isLastStep || Precision.equals(currentT, tEnd, 1); [EOL]     for (StepHandler handler : stepHandlers) { [EOL]         handler.handleStep(interpolator, isLastStep); [EOL]     } [EOL]     return currentT; [EOL] } <line_num>: 313,436
protected void sanityChecks(final ExpandableStatefulODE equations, final double t) throws NumberIsTooSmallException, DimensionMismatchException { [EOL]     final double threshold = 1000 * FastMath.ulp(FastMath.max(FastMath.abs(equations.getTime()), FastMath.abs(t))); [EOL]     final double dt = FastMath.abs(equations.getTime() - t); [EOL]     if (dt <= threshold) { [EOL]         throw new NumberIsTooSmallException(LocalizedFormats.TOO_SMALL_INTEGRATION_INTERVAL, dt, threshold, false); [EOL]     } [EOL] } <line_num>: 445,456