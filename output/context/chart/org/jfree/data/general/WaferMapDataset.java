public WaferMapDataset(int maxChipX, int maxChipY)
public WaferMapDataset(int maxChipX, int maxChipY, Number chipSpace)
public void addValue(Number value, Comparable chipx, Comparable chipy)
public void addValue(int v, int x, int y)
public void setValue(Number value, Comparable chipx, Comparable chipy)
public int getUniqueValueCount()
public Set getUniqueValues()
public Number getChipValue(int chipx, int chipy)
public Number getChipValue(Comparable chipx, Comparable chipy)
public boolean isMaxValue(Number check)
public boolean isMinValue(Number check)
public Number getMaxValue()
public Number getMinValue()
public int getMaxChipX()
public void setMaxChipX(int maxChipX)
public int getMaxChipY()
public void setMaxChipY(int maxChipY)
public double getChipSpace()
public void setChipSpace(double space)
DefaultKeyedValues2D data
int maxChipX
int maxChipY
double chipSpace
Double maxValue
Double minValue
double DEFAULT_CHIP_SPACE=Optional[1d]
