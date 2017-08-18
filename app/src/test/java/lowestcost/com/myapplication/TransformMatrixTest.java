package lowestcost.com.myapplication;

/**
 * Created by Shivakumar on 8/17/17.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class TransformMatrixTest {

    Utility utility = new Utility();
    @Test
    public void transform_isCorrect() throws Exception {

        int inputData[][]= { {3, 4, 1},
                {6, 1, 8},
                {5, 9, 3},
        };
        int outputData[][] = { {3,6,5},
                {4,1,9},
                {1,8,3}

        };

        int transformedMatrix[][] = utility.transformMatrix(inputData);

        assertEquals(outputData, transformedMatrix);
    }
}
