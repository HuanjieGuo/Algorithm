package leetcode;

/**
 下一个数是对上一个数的描述，
 比方说 1211 里有 “ 1 个 1 ， 1 个 2 ， 2 个 1 ” ，
 那么 111221 就是它的下一个数。通常我们把这个数列叫做“外观数列”。
 */
public class A0038_CountAndSay {
    public static String countAndSay(int n) {
        String str = "1";
        int i = 1;
        while (i<n){
            StringBuilder nextString = new StringBuilder("");
            Character lastCh = null;
            int count = 0;
            for(char ch:str.toCharArray()){
                if (lastCh==null) lastCh = ch;
                else if(ch!=lastCh) {
                    nextString.append(count);
                    nextString.append(lastCh);
                    lastCh = ch;
                    count = 0;
                }
                count++;
            }
            nextString.append(count);
            nextString.append(lastCh);
            // 从新赋值
            str = nextString.toString();
            i++;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
