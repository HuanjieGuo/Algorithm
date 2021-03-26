package string;

public class Offer0058_I_ReverseWords {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i= strs.length-1;i>=0;i--) {
            String str = strs[i].replace(" ","");
            if(!str.equals("")) {
                builder.append(strs[i].replace(" ", ""));
                if (i != 0) builder.append(" ");
            }
        }
        return builder.toString().trim();
    }
}
