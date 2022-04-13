public int getValue(final int holder) { [EOL]     return getRawValue(holder) >> _shift_count; [EOL] }
public short getShortValue(final short holder) { [EOL]     return (short) getValue(holder); [EOL] }
public int getRawValue(final int holder) { [EOL]     return holder & _mask; [EOL] }
public short getShortRawValue(final short holder) { [EOL]     return (short) getRawValue(holder); [EOL] }
public boolean isSet(final int holder) { [EOL]     return (holder & _mask) != 0; [EOL] }
public boolean isAllSet(final int holder) { [EOL]     return (holder & _mask) == _mask; [EOL] }
public int setValue(final int holder, final int value) { [EOL]     return (holder & ~_mask) | ((value << _shift_count) & _mask); [EOL] }
public short setShortValue(final short holder, final short value) { [EOL]     return (short) setValue(holder, value); [EOL] }
public int clear(final int holder) { [EOL]     return holder & ~_mask; [EOL] }
public short clearShort(final short holder) { [EOL]     return (short) clear(holder); [EOL] }
public byte clearByte(final byte holder) { [EOL]     return (byte) clear(holder); [EOL] }
public int set(final int holder) { [EOL]     return holder | _mask; [EOL] }
public short setShort(final short holder) { [EOL]     return (short) set(holder); [EOL] }
public byte setByte(final byte holder) { [EOL]     return (byte) set(holder); [EOL] }
public int setBoolean(final int holder, final boolean flag) { [EOL]     return flag ? set(holder) : clear(holder); [EOL] }
public short setShortBoolean(final short holder, final boolean flag) { [EOL]     return flag ? setShort(holder) : clearShort(holder); [EOL] }
public byte setByteBoolean(final byte holder, final boolean flag) { [EOL]     return flag ? setByte(holder) : clearByte(holder); [EOL] }
