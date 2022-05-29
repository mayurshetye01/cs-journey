package test.xor;

public class BinaryComplement {
    public static void main(String[] args) {
        System.out.println(getBinaryComplement(8));
    }

    private static int getBinaryComplement(final int num) {
        int bitCount = 0;
        int n = num;
        while (n > 0){
            bitCount++;
            n = n >> 1;
        }

        int allBitsSet = (int) Math.pow(2, bitCount) - 1;

        return num ^ allBitsSet;
    }
}
