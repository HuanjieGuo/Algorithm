import java.util.*;

public class Main {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(2<<29);
        System.out.println(bitSet.toLongArray().length);
//        bitSet.set(1024);
//        System.out.println(bitSet.toLongArray().length);
    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            int place = in.nextInt();
//            int route = in.nextInt();
//            System.out.println(place+" "+route);
//            for(int i=0;i<route;i++)
//                in.nextLine();
//            int[] height = new int[place];
//            for(int i=0;i<place;i++)
//                height[i] = in.nextInt();
//            Deque<Integer> ascQueue = new LinkedList<>();
//            Deque<Integer> descQueue = new LinkedList<>();
//            int max = 0;
//            for(int num:height){
//                if(ascQueue.size()==0){
//                    ascQueue.addLast(num);
//                }else {
//                    if(ascQueue.getLast()>num) ascQueue.clear();
//                    ascQueue.addLast(num);
//                }
//                max = Math.max(max,ascQueue.size());
//            }
//            for(int num:height){
//                if(descQueue.size()==0){
//                    descQueue.addLast(num);
//                }else {
//                    if(descQueue.getLast()<num) descQueue.clear();
//                    descQueue.addLast(num);
//                }
//                max = Math.max(max,descQueue.size());
//            }
//            System.out.println(max);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            int length = in.nextInt();
//            int windowSize = in.nextInt();
//            int[] nums = new int[length];
//            for(int i=0;i<length;i++)
//                nums[i] = in.nextInt();
//            TreeMap<Integer,Integer> map = new TreeMap<>();
//            for(int i=0;i<length;i++){
//                if(i>=windowSize){
//                    map.put(nums[i-windowSize],map.getOrDefault(nums[i-windowSize],0)-1);
//                }
//                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//                if(i<windowSize-1) continue;
//
//                int most = -1;
//                int count = 0;
//                for(int key:map.keySet()){
//                    if(map.get(key)>count){
//                        most = key;
//                        count = map.get(key);
//                    }
//                }
//                System.out.println(most);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            int n = in.nextInt();
//            int m = in.nextInt();
//            int [][] origin = new int[m][n];
//            for(int i=0;i<n;i++)
//                for(int j=0;j<m;j++)
//                    origin[j][i] = in.nextInt();
//            for( int i = 0;i<m;i++){
//                StringBuilder str = new StringBuilder();
//                for(int j=0;j<n;j++)
//                    if(j==n-1) str.append(origin[i][j]);
//                    else str.append(origin[i][j]).append(" ");
//                System.out.println(str);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            String str = in.nextLine();
//            StringBuilder subStr = new StringBuilder();
//            PriorityQueue<Long> queue = new PriorityQueue<>();
//            for(Character ch:str.toCharArray()){
//                if(ch>='0'&&ch<='9') subStr.append(ch);
//                else {
//                    try{
//                        queue.offer(Long.parseLong(subStr.toString()));
//                        subStr.delete(0,subStr.length());
//                    }catch (Exception e){
//                        subStr.delete(0,subStr.length());
//                    }
//                }
//            }
//            if(str.length()!=0) {
//                try {
//                    queue.offer(Long.parseLong(subStr.toString()));
//                    subStr.delete(0, subStr.length());
//                } catch (Exception e) {
//                    subStr.delete(0, subStr.length());
//                }
//            }
//
//            while (queue.size()!=0)System.out.println(queue.poll());
//        }
//    }
}
