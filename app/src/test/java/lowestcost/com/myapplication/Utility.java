package lowestcost.com.myapplication;

/**
 * Created by Shivakumar on 8/17/17.
 */

public class Utility {

    public static int[][] transformMatrix(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] trasposedMatrix = new int[n][m];

        for(int x = 0; x < n; x++)
        {
            for(int y = 0; y < m; y++)
            {
                trasposedMatrix[x][y] = matrix[y][x];
            }
        }
        return trasposedMatrix;
    }
}
