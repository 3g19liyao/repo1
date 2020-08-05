package LiKou;

public class MaximalSquare {
    public static void main(String[] args){
        char[][] chars={{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}};
        System.out.println(maximalSquare(chars));
    }
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length==0){

        }
        int wide=matrix.length;
        int len=matrix[0].length;
        System.out.println(wide+"....."+len);
        int maxside=1;
        for(int i=0;i<wide;i++){
            for(int j=0;j<len;j++){
                if(matrix[i][j]=='1'){
                    int max=Math.min(wide-1-i,len-1-j);
                    for(int x=1;x<=max;x++){
                        int flag=1;
                        if(matrix[i+x][j+x]=='0'){
                            break;
                        }
                        else{
                            for(int p=0;p<=x;p++){
                                if(matrix[i+p][j+x]=='0' || matrix[i+x][j+p]=='0'){
                                    flag=0;
                                }
                            }
                            if(flag==1){
                                maxside=Math.max(maxside,x+1);
                            }else{
                                break;
                            }
                        }
                    }
                }
            }
        }
        return maxside*maxside;
    }
}
