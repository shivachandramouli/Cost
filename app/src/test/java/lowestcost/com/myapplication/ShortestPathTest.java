package lowestcost.com.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Shivakumar on 8/17/17.
 */

public class ShortestPathTest {

    LinkedHashMap<Integer, ArrayList<Integer>> linkedHashMap = new LinkedHashMap<Integer, ArrayList<Integer>>();
    ArrayList<Integer> positionArray = new ArrayList<Integer>();
    Utility utility = new Utility();

    @Test
    public void test_positions1() throws Exception {

        int inputData[][]= { {3, 4, 1},
                {6, 1, 8},
                {5, 9, 3},
        };

        List<Integer> outputData = Arrays.asList(1, 2, 1);

        int transformedMatrix[][] = utility.transformMatrix(inputData);
        buildDataStructure(transformedMatrix);

        ArrayList positionsArray = getPositions();

        assertEquals(outputData, positionsArray);
    }

    @Test
    public void test_positions2() throws Exception {

        int inputData[][]= { {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}
        };

        List<Integer> outputData = Arrays.asList(1, 2, 1, 1, 4, 2);

        int transformedMatrix[][] = utility.transformMatrix(inputData);
        buildDataStructure(transformedMatrix);

        ArrayList positionsArray = getPositions();

        assertEquals(outputData, positionsArray);
    }

    @Test
    public void test_positions3() throws Exception {

        int inputData[][]= { {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 1, 2, 3}
        };

        List<Integer> outputData = Arrays.asList(1, 2, 1, 5, 4, 5);

        int transformedMatrix[][] = utility.transformMatrix(inputData);
        buildDataStructure(transformedMatrix);

        ArrayList positionsArray = getPositions();

        assertEquals(outputData, positionsArray);
    }

    @Test
    public void test_positions4() throws Exception {

        int inputData[][]= { {19, 10, 19, 10, 19},
                {21, 23, 20, 19, 12},
                {20, 12, 20, 11, 10}
        };

        List<Integer> outputData = Arrays.asList(1, 1, 1, 1, 3);

        int transformedMatrix[][] = utility.transformMatrix(inputData);
        buildDataStructure(transformedMatrix);

        ArrayList positionsArray = getPositions();

        assertEquals(outputData, positionsArray);
    }

    @Test
    public void test_positions5() throws Exception {

        int inputData[][]= { {5, 8, 5, 3, 5}

        };

        List<Integer> outputData = Arrays.asList(1, 1, 1, 1, 1);

        int transformedMatrix[][] = utility.transformMatrix(inputData);
        buildDataStructure(transformedMatrix);

        ArrayList positionsArray = getPositions();

        assertEquals(outputData, positionsArray);
    }

    @Test
    public void test_positions6() throws Exception {

        int inputData[][]= { {5},
                {8},
                {5},
                {3},
                {5}
        };

        List<Integer> outputData = Arrays.asList(4);

        int transformedMatrix[][] = utility.transformMatrix(inputData);
        buildDataStructure(transformedMatrix);

        ArrayList positionsArray = getPositions();

        assertEquals(outputData, positionsArray);
    }

    @Test
    public void test_positions7() throws Exception {

        int inputData[][]= { {6,3,-5,9},
                {-5,2,4,10},
                {3,-2,6,10},
                {6,-1,-2,10}
        };

        List<Integer> outputData = Arrays.asList(2,3,1,1);

        int transformedMatrix[][] = utility.transformMatrix(inputData);
        buildDataStructure(transformedMatrix);

        ArrayList positionsArray = getPositions();

        assertEquals(outputData, positionsArray);
    }

    @Test
    public void test_positions8() throws Exception {

        int inputData[][]= { {51, 51},
                {0, 51},
                {51,51},
                {5,5}
        };

        List<Integer> outputData = Arrays.asList(2,4);

        int transformedMatrix[][] = utility.transformMatrix(inputData);
        buildDataStructure(transformedMatrix);

        ArrayList positionsArray = getPositions();

        assertEquals(outputData, positionsArray);
    }

    @Test
    public void test_positions9() throws Exception {

        int inputData[][]= { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };

        List<Integer> outputData = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

        int transformedMatrix[][] = utility.transformMatrix(inputData);
        buildDataStructure(transformedMatrix);

        ArrayList positionsArray = getPositions();

        assertEquals(outputData, positionsArray);
    }

    public ArrayList getPositions() {

        positionArray.clear();
        int totalValue = 0;
        int position = 0;
        for (int i = 0;i<linkedHashMap.size();i++) {

            ArrayList arrayList = linkedHashMap.get(i);
            int minimumValue = getMinValue(arrayList);
            position = getPosition(arrayList, minimumValue) + 1;
            positionArray.add(position);
            totalValue = totalValue + minimumValue;
        }

        return positionArray;
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


    public void buildDataStructure(int[][] matrix) {

        for(int i=0; i<matrix.length; i++) {

            ArrayList<Integer> columnData = new ArrayList<Integer>();
            for(int j=0; j<matrix[i].length; j++) {
                columnData.add(j,matrix[i][j]);
            }
            linkedHashMap.put(i, columnData);
        }
    }
}
