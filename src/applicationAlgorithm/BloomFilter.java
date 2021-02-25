package applicationAlgorithm;

import java.util.BitSet;

public class BloomFilter {
    // 布隆过滤器容量
    private static final int DEFAULT_SIZE = 2<<28;
    // bit数组,用来存放结果
    public static BitSet bitSet = new BitSet(DEFAULT_SIZE);
    // 扰乱值：后面hash函数会用，用来生成不同hash值，可随意设置
    private static final int[] hashInts = {1,6,16,38,58,68};

    // add方法,计算key的hash值，并将对应下标设置为true
    public void add(Object key){
        for(int i:hashInts)
            bitSet.set(hash(key,i));
    }

    /**
     * 判断key是否存在
     * true不一定说明key存在 （哈希冲突）
     * 但是false一定说明不存在！
     */
    public boolean isContain(Object key){
        boolean result = true;
        for(int i:hashInts)
            // 短路与，只要有一个bit位为false,则返回false
            result = result && bitSet.get(hash(key,i));
        return result;
    }

    // hash函数，借鉴了hashmap的扰动算法；强烈建议看懂
    // 通过不同i去扰乱最终key的hash值
    private int hash(Object key, int i){
        int h;
        return  key==null?0:(i*(DEFAULT_SIZE-1)&((h=key.hashCode()))^(h>>>16));
    }

    public static void main(String[] args) {
        System.out.println(DEFAULT_SIZE);
        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.add("张学友");
        bloomFilter.add("郭德纲");
        bloomFilter.add("蔡徐鸡");
        bloomFilter.add(666);
        System.out.println(bloomFilter.isContain("张学友"));//true
        System.out.println(bloomFilter.isContain("张学友 "));//false
        System.out.println(bloomFilter.isContain("张学友1"));//false
        System.out.println(bloomFilter.isContain("郭德纲"));//true
        System.out.println(bloomFilter.isContain("蔡徐老母鸡"));//false
        System.out.println(bloomFilter.isContain(666));//true
        System.out.println(bloomFilter.isContain(888));//false
        System.out.println(bloomFilter.bitSet);
    }
}
