package hooooong.com.basiclayout.View.Presenter;

import hooooong.com.basiclayout.Model.CalculatorData;

/**
 * Created by Android Hong on 2017-09-12.
 */

public interface ICalculator {

    interface View{

        // 연산식을 보여주기 위한 메소드
        void setProgressValueText(String processText);
        // 현재 누른 값과 결과값을 보여주기 위한 메소드
        void setValueText(String value);
    }

    interface Presenter{

        void attachView(View view);
        void detachView();

        void setCalculatorData(CalculatorData calculatorData);

        // 값을 눌렀을 때
        void appendValue(String value);
        // 연산자를 눌렀을 때
        void appendCalculate(String calculate);
        // C 를 눌렀을 때
        void clearValue();
        // = 을 눌렀을 때
        void resultValue();
    }
}
