package applicationAlgorithm;

import javafx.scene.effect.Bloom;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BloomFilter {
    int DEFAULT_SIZE = Integer.MAX_VALUE;
    BitSet bitSet = new BitSet(DEFAULT_SIZE);
    private static final int[] hashInts = {1,6,16,38,58,68,79,83};

    public void add(Object key){
        for(int i:hashInts)
            bitSet.set(hash(key,i));
    }

    public boolean isContain(Object key){
        boolean result = true;
        for(int i:hashInts)
            result = result && bitSet.get(hash(key,i));
        return result;
    }

    private int hash(Object key, int i){
        int h;
        return  key==null?0:((DEFAULT_SIZE-1)&((h=key.hashCode()*i))^(h>>>16));
    }

    public static void main(String[] args) {
        List<BloomFilter> bloomFilters = new ArrayList<>();
        for(int i=0;i<16;i++){
            bloomFilters.add(new BloomFilter());
        }
        // 2.5亿约为2的28次方
        for(int i=0;i<(2<<28);i++){
            int idx = i&15;
            bloomFilters.get(idx).add(i);
        }
        int count = 0;
        for(int i=2<<28;i<(2<<29);i++){
            if(bloomFilters.get(i&15).isContain(i)) count++;
        }
        // 碰撞概率：0.7505722641944885
        System.out.println("碰撞概率："+Double.valueOf(count)/(2<<28));
    }
}
