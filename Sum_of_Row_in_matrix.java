import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int row = input.nextInt();
		int col = input.nextInt();
		int sum=0;
		int[][] max = new int[row][col];
		for (int i = 0; i < row; i++)
		{
		    for (int j = 0; j < col; j++){
		        max[i][j] = input.nextInt();
		    }
		}
		for (int i = 0; i < row; i++)
		{
		    for (int j = 0; j < col; j++){
		        sum += max[i][j];
		    }
		    System.out.println("sum of"+i+" is "+sum);
		}
	}
}
