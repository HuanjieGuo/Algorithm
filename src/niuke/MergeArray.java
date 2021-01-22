package niuke;

public class MergeArray {
    public void merge(int A[], int m, int B[], int n) {
        int aIndex = m-1;
        int bIndex = n-1;
        int totalIndex = m+n-1;
        while (aIndex>=0&&bIndex>=0) {
            if (A[aIndex] > B[bIndex]) {
                A[totalIndex] = A[aIndex];
                aIndex--;
            } else {
                A[totalIndex] = B[bIndex];
                bIndex--;
            }
            totalIndex--;
        }
        if(aIndex<0)
            for(;bIndex>=0;bIndex--)
                A[bIndex] = B[bIndex];

    }
}
