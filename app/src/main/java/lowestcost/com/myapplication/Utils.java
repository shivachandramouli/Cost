package lowestcost.com.myapplication;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Shivakumar on 8/17/17.
 */

public class Utils {

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

    public int getMinValue(ArrayList array) {

        Object obj = Collections.min(array);
        return (int) obj;
    }

    public int getPosition(ArrayList array, int element) {

        for (int i = 0;i<array.size();i++)  {
            Object obj = array.get(i);

            if ((int) obj == element) {
                return i;
            }
        }
        return -1;
    }

}
