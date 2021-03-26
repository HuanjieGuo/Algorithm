package string;

public class Offer0058_II_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
