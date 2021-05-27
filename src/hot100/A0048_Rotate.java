package hot100;

public class A0048_Rotate {
    public void rotate(int[][] matrix) {
        // 左斜线镜像
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i>j) continue;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 垂直镜像
        int mid = matrix.length==0?0: matrix.length/2;
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = tmp;
            }
        }
    }
}
