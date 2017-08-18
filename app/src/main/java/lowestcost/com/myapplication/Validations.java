package lowestcost.com.myapplication;

/**
 * Created by Shivakumar on 8/17/17.
 */

public class Validations {

    public boolean validateForAlphabets(String inputText) {

        boolean validationStatus = false;
        if (inputText.length() > 0) {
            boolean checkIfAlpha = isAlpha(inputText);
            if(checkIfAlpha == true) {
                validationStatus = true;
            }
            else {
                validationStatus = false;
            }
        }
        return validationStatus;
    }

    //Validation for checking if the input data is an integer
    public boolean isAlpha(String inputData) {

        String NumberPattern = "[0-9]+";
        String modifiedData = inputData;
        modifiedData = modifiedData.replace(" ", "");
        modifiedData = modifiedData.replace("-", "");
        if (modifiedData.matches(NumberPattern)) {
            //It is a number
            return true;
        }
        return  false;
    }
}
