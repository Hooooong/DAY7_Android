package hooooong.com.basiclayout.Model;

import java.util.ArrayList;

/**
 * Created by Android Hong on 2017-09-12.
 */

public class CalculatorData {

    private ArrayList<String> progressValue;

    private static CalculatorData calculator;
    private CalculatorData(){
        progressValue = new ArrayList<>();
    }

    public static CalculatorData getInstance(){
        if (calculator == null)
            calculator = new CalculatorData();
        return calculator;
    }

    public ArrayList<String> getProgressValue() {
        return progressValue;
    }

    public void setProgressValue(ArrayList<String> progressValue) {
        this.progressValue = progressValue;
    }
}
