public Well44497b() { [EOL]     super(K, M1, M2, M3); [EOL] } <line_num>: 56,58
public Well44497b(int seed) { [EOL]     super(K, M1, M2, M3, seed); [EOL] } <line_num>: 63,65
public Well44497b(int[] seed) { [EOL]     super(K, M1, M2, M3, seed); [EOL] } <line_num>: 71,73
public Well44497b(long seed) { [EOL]     super(K, M1, M2, M3, seed); [EOL] } <line_num>: 78,80
@Override [EOL] protected int next(final int bits) { [EOL]     final int indexRm1 = iRm1[index]; [EOL]     final int indexRm2 = iRm2[index]; [EOL]     final int v0 = v[index]; [EOL]     final int vM1 = v[i1[index]]; [EOL]     final int vM2 = v[i2[index]]; [EOL]     final int vM3 = v[i3[index]]; [EOL]     final int z0 = (0xFFFF8000 & v[indexRm1]) ^ (0x00007FFF & v[indexRm2]); [EOL]     final int z1 = (v0 ^ (v0 << 24)) ^ (vM1 ^ (vM1 >>> 30)); [EOL]     final int z2 = (vM2 ^ (vM2 << 10)) ^ (vM3 << 26); [EOL]     final int z3 = z1 ^ z2; [EOL]     final int z2Prime = ((z2 << 9) ^ (z2 >>> 23)) & 0xfbffffff; [EOL]     final int z2Second = ((z2 & 0x00020000) != 0) ? (z2Prime ^ 0xb729fcec) : z2Prime; [EOL]     int z4 = z0 ^ (z1 ^ (z1 >>> 20)) ^ z2Second ^ z3; [EOL]     v[index] = z3; [EOL]     v[indexRm1] = z4; [EOL]     v[indexRm2] &= 0xFFFF8000; [EOL]     index = indexRm1; [EOL]     z4 = z4 ^ ((z4 << 7) & 0x93dd1400); [EOL]     z4 = z4 ^ ((z4 << 15) & 0xfa118000); [EOL]     return z4 >>> (32 - bits); [EOL] } <line_num>: 83,117
