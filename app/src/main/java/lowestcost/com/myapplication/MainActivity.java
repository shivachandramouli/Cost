package lowestcost.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

import static android.R.attr.alpha;
import static android.R.attr.button;
import static android.R.attr.key;
import static android.R.attr.max;
import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    LinkedHashMap<Integer, ArrayList<Integer>> linkedHashMap = new LinkedHashMap<Integer, ArrayList<Integer>>();
    ArrayList<Integer> positionArray = new ArrayList<Integer>();
    EditText input1;
    EditText input2;
    EditText input3;
    EditText input4;
    EditText input5;

    Button getResults;
    TextView output1;
    TextView output2;
    TextView output3;

    String[] inputString1;
    String[] inputString2;
    String[] inputString3;
    String[] inputString4;
    String[] inputString5;

    int inputData[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output1 = (TextView)findViewById(R.id.output1);
        output2 = (TextView)findViewById(R.id.output2);
        output3 = (TextView)findViewById(R.id.output3);

        int inputData[][]= { {3, 4, 1},
                             {6, 1, 8},
                             {5, 9, 3},
                             };

        input1 = (EditText)findViewById(R.id.input1);
        input2 = (EditText)findViewById(R.id.input2);
        input3 = (EditText)findViewById(R.id.input3);
        input4 = (EditText)findViewById(R.id.input4);
        input5 = (EditText)findViewById(R.id.input5);

        getResults = (Button)findViewById(R.id.Button);

        getResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isAlphaValidationPassed = validateForAlphabets();
                if (isAlphaValidationPassed == false) {
                    //Show Error message
                    return;
                }

                inputString1 = input1.getText().toString().split("\\ ");
                inputString2 = input2.getText().toString().split("\\ ");
                inputString3 = input3.getText().toString().split("\\ ");
                inputString4 = input4.getText().toString().split("\\ ");
                inputString5 = input5.getText().toString().split("\\ ");

                initialize2DArray();
            }
        });
    }

    private void initialize2DArray() {

        int totalRows = inputString1.length;

        int totalColumns = 0;
        if(inputString1.length > 1) {
            totalColumns = totalColumns + 1;
        }
        if (inputString2.length > 1) {
            totalColumns = totalColumns + 1;
        }
        if (inputString3.length > 1) {
            totalColumns = totalColumns + 1;
        }
        if (inputString4.length > 1) {
            totalColumns = totalColumns + 1;
        }
        if (inputString5.length > 1) {
            totalColumns = totalColumns + 1;
        }


        inputData = new int[totalColumns][totalRows];

        if(inputString1.length > 1) {
            for (int i = 0;i<inputString1.length;i++) {

                inputData[0][i] = Integer.parseInt(inputString1[i]);
            }
        }

        if(inputString2.length > 1) {
            for (int i = 0;i<inputString2.length;i++) {

                inputData[1][i] = Integer.parseInt(inputString2[i]);
            }
        }

        if(inputString3.length > 1) {
            for (int i = 0;i<inputString3.length;i++) {

                inputData[2][i] = Integer.parseInt(inputString3[i]);
            }
        }

        if(inputString4.length > 1) {
            for (int i = 0;i<inputString4.length;i++) {

                inputData[3][i] = Integer.parseInt(inputString4[i]);
            }
        }

        if(inputString5.length > 1) {
            for (int i = 0;i<inputString5.length;i++) {

                inputData[4][i] = Integer.parseInt(inputString5[i]);
            }
        }

        int transposeMatrix[][] = transformMatrix(inputData);
        buildDataStructure(transposeMatrix);
    }

    public void buildDataStructure(int[][] matrix) {

        for(int i=0; i<matrix.length; i++) {

            ArrayList<Integer> columnData = new ArrayList<Integer>();
            for(int j=0; j<matrix[i].length; j++) {
                columnData.add(j,matrix[i][j]);
            }
            linkedHashMap.put(i, columnData);
        }

        showOutput();
    }

    public void showOutput() {

        output2.setText(String.valueOf(getTotalCost()));
        output3.setText((String.valueOf(positionArray)));

        if (getTotalCost() > 50 ) {
            output1.setText("NO");
        }
        else {
            output1.setText("YES");
        }
    }

    private boolean validateForAlphabets() {

        boolean validationStatus = false;
        if (input1.getText().toString().length() > 0) {
            boolean checkIfAlpha = isAlpha(input1.getText().toString());
            if(checkIfAlpha == true) {
                validationStatus = true;
            }
            else {
                validationStatus = false;
            }
        }

        if (input2.getText().toString().length() > 0) {
            boolean checkIfAlpha = isAlpha(input2.getText().toString());
            if(checkIfAlpha == true) {
                validationStatus = true;
            }
            else {
                validationStatus = false;
            }
        }
        return validationStatus;
    }

    public boolean isAlpha(String inputData) {

        String NumberPattern = "[0-9]+";
        String modifiedData = inputData;
        modifiedData = modifiedData.replace(" ", "");
        modifiedData = modifiedData.replace("-", "");
        if (modifiedData.matches(NumberPattern)) {
            //It is a number
            return true;
        }
        else {
            //Not a number
            return false;
        }
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

    private int getTotalCost() {

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

        return totalValue;
    }
}
