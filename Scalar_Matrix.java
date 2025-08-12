import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int row_size = input.nextInt();
        int col_size = input.nextInt();
        
        int[][] mat = new int[row_size][col_size];
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                mat[i][j] = input.nextInt();
            }
        }
        
        boolean flag = false;
        
        // Check if all diagonal elements are the same
        for (int row = 0; row < row_size - 1; row++) {
            if (mat[row][row] != mat[row+1][row+1]) {
                flag = true;
                break;
            }
        }
        
        // Check if all off-diagonal elements are zero
        if (!flag) {
            for (int i = 0; i < row_size; i++) {
                for (int j = 0; j < col_size; j++) {
                    if (i != j && mat[i][j] != 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
        }
        
        if (flag) 
            System.out.println("Not Scalar");
        else 
            System.out.println("Scalar");
    }
}
