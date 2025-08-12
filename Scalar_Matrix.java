import java.util.*;

public class Scalar_Matrix
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int row_size = input.nextInt();
		int col_size = input.nextInt();
		int sum=0;
		int[][] mat = new int[row_size][col_size];
		for (int i = 0; i < row_size; i++)
		{
		    for (int j = 0; j < col_size; j++){
		        mat[i][j] = input.nextInt();
		    }
		}
		
		boolean flag = false;
		for (int row = 0; row < row_size; row++){
		    if (mat[row][row]!=mat[row+1][row+1]){
		        flag = true;
		        break;
		    }
		}
		for (int i = 0; i < row_size; i++)
		{
		    for (int j = 0; j < col_size; j++){
		     if (i == j){
		         continue;
		     }  
		     else{
		         if (mat[i][j]!=0){
		             flag = true;
		             break;
		         }
		     }
		
		    }
		    if (flag==true) break;
		}
		if (flag == true) System.out.println("Scallar");
		else System.out.println("Not Scaller");
	}
}
