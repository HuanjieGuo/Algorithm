package secondOffer.str;

public class Offer0005_ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder(s);
        for(int i=0;i<builder.length();i++){
            if(builder.charAt(i)==' ') {
                builder.insert(i + 1, "%20");
                builder.deleteCharAt(i);
            }
        }
        return builder.toString();
    }
}
