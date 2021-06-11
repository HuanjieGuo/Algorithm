package hot100;

public class A0079_Exist {
    char[] chs;
    char[][] board;
    int haveMatchCount;
    int length;
    int width;
    int height;
    boolean finish;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        if (board.length==0) return false;
        chs = word.toCharArray();
        haveMatchCount = 0;
        length = chs.length;
        height = board.length;
        width = board[0].length;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
            search(i,j);
        return finish;
    }
    void search(int i,int j){
        if(haveMatchCount==length){
            finish = true;
            return;
        }
        if(i<0||j<0||i>=height||j>=width||finish) return;
        if(board[i][j]=='/') return;
        if(board[i][j] == chs[haveMatchCount]){
            haveMatchCount++;
            char ch = board[i][j];
            board[i][j] = '/';
            search(i+1,j);
            search(i-1,j);
            search(i,j-1);
            search(i,j+1);
            board[i][j] = ch;
            haveMatchCount--;
        }
    }

    public static void main(String[] args) {
        A0079_Exist a0079_exist = new A0079_Exist();
        char[][] chs = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        a0079_exist.exist(chs,"ABCCED");
    }

}
