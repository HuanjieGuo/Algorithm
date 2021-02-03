package niuke;

public class ReverseString {
    public String solve (String str) {
        // write code here
        StringBuilder strBuilder = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--)
            strBuilder.append(str.charAt(i));
        return strBuilder.toString();
    }
}
