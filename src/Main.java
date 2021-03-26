import java.util.*;

public class Main {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(2<<29);
        System.out.println(bitSet.toLongArray().length);
//        bitSet.set(1024);
//        System.out.println(bitSet.toLongArray().length);
    }

}
