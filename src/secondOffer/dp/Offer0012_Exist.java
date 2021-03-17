package secondOffer.dp;

/**
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

 [["a","b","c","e"],
 ["s","f","c","s"],
 ["a","d","e","e"]]

 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 */
public class Offer0012_Exist {
    boolean exist;
    char[][] board;
    int width;
    int height;
    public boolean exist(char[][] board, String word) {
        if(board.length==0) return false;
        this.board = board;
        height = board.length;
        width = board[0].length;
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++)
                dfs(i,j,new StringBuilder(word));
        return exist;
    }
    void dfs(int i,int j,StringBuilder word){
        if(exist) return;
        if(word.length()==0) {
            exist =true;
            return;
        }
        if(i<0||j<0||i>=height||j>=width) return;
        if(board[i][j]=='.'||board[i][j]!=word.charAt(0)) return;
        // 等于第一个了
        char chInWord = word.charAt(0);
        char chInboard = board[i][j];
        board[i][j] = '.';
        word.deleteCharAt(0);
        // 四个方向搜
        dfs(i-1,j,word);
        dfs(i+1,j,word);
        dfs(i,j-1,word);
        dfs(i,j+1,word);
        // 复位
        board[i][j] = chInboard;
        word.insert(0,chInWord);
    }
}
