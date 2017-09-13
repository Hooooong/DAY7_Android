package hooooong.com.basiclayout.View.Presenter;

import java.util.ArrayList;

import hooooong.com.basiclayout.Model.CalculatorData;

/**
 * Created by Android Hong on 2017-09-12.
 */

public class CalculatorPresenter implements ICalculator.Presenter{

    // 연산 후(= 누르고) 더 계산할 것인지 검사하는 flag 값
    private boolean flag = false;

    private CalculatorData calculatorData;
    private ICalculator.View view;

    @Override
    public void attachView(ICalculator.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setCalculatorData(CalculatorData calculatorData) {
        this.calculatorData = calculatorData;
    }

    /**
     * 숫자를 눌렀을 경우
     *
     * @param value
     */
    @Override
    public void appendValue(String value) {

        ArrayList<String> numberArray = calculatorData.getProgressValue();

        if(flag){
            flag = false;
            clearValue();
        }

        if(checkNum(numberArray)){
            // 연산자 or size = 0 인 경우
            numberArray.add(value);
            calculatorData.setProgressValue(numberArray);
            view.setValueText(value);
        }else{
            // 연산자가 아니고 size != 0 인 경우
            String number = "";
            number = numberArray.get(numberArray.size() - 1);
            if("0".equals(number)){
                number = value;
                numberArray.set(numberArray.size() - 1, number);
            }else{
                number += value;
                numberArray.set(numberArray.size() - 1, number);
            }
            // 새로이 저장
            calculatorData.setProgressValue(numberArray);
            view.setValueText(number);
        }
    }

    /**
     * 연산자를 눌렀을 경우
     *
     * @param calculate
     */
    @Override
    public void appendCalculate(String calculate) {
        flag = false;

        // 1. Model 에 있는 데이터를 가져온다.
        ArrayList<String> numberArray = calculatorData.getProgressValue();

        // size != 0 이 아닐 경우
        // (첫 연산에 기호가 들어가지 못하게 하기 위한 장치)
        if (numberArray.size() != 0) {
            // 2. 연산자를 저장

            if (checkNum(numberArray)) {
                // 2-1. 가장 끝에 있는 값이 연산자인 경우에는
                //      연산자의 값을 바꿔준다.
                numberArray.set(numberArray.size() - 1, calculate);
                calculatorData.setProgressValue(numberArray);

            } else {
                // 2-2. 가장 끝에 있는 값이 연산자가 아닌 경우에는
                //      ArrayList 끝에 연산자를 추가한다.
                numberArray.add(calculate);
                calculatorData.setProgressValue(numberArray);
            }

            String calculation = "";
            for (String txt : numberArray) {
                calculation += txt;
            }

            view.setPreviewText(calculation);
        }
    }


    /**
     * C 를 눌렀을 경우
     */
    @Override
    public void clearValue() {
        // DB 초기화
        ArrayList<String> numberArray = calculatorData.getProgressValue();
        numberArray.clear();
        calculatorData.setProgressValue(numberArray);

        calculatorData.setProgressValue(numberArray);
        view.setValueText("");
        view.setPreviewText("");
    }

    /**
     * = 을 눌렀을 경우
     */
    @Override
    public void resultValue() {
        // 연산 하고 그 값을 보내줘야 한다.

        // 1. Model 에서 값을 가져온다.
        // Model 에 저장되어 있는 계산식
        ArrayList<String> numberArray = calculatorData.getProgressValue();
        double temp;

        if(numberArray.size() != 0) {

            // 2-1. 계산식 변수 설정
            String calculation = "";
            for (String txt : numberArray) {
                calculation += txt;
            }

            // 2-2. 결과값 변수 계산
            if (checkNum(numberArray)) {
                // 마지막 문자가 연산자인 경우에는 그 전 결과까지 연산한 후 마지막 문자를 해준다

                if (numberArray.size() != 1) {
                    // size 가 1인 경우에는
                    // 3 += 3
                    temp = Double.parseDouble(numberArray.get(0));

                    switch (numberArray.get(1)) {
                        case "+":
                            temp += temp;
                            break;
                        case "-":
                            temp -= temp;
                            break;
                        case "*":
                            temp *= temp;
                            break;
                        case "/":
                            temp /= temp;
                            break;
                    }
                    numberArray.set(0, String.valueOf(temp));

                } else {
                    // size 가 1보다 큰 경우에는

                    for (int i = 1; i < numberArray.size() - 1; i = i + 2) {
                        switch (numberArray.get(i)) {
                            case "*":
                                temp = Double.parseDouble(numberArray.get(i - 1)) * Double.parseDouble(numberArray.get(i + 1));
                                numberArray.set(i - 1, String.valueOf(temp));
                                numberArray.remove(i);
                                numberArray.remove(i);
                                i -= 2;
                                break;
                            case "/":
                                temp = Double.parseDouble(numberArray.get(i - 1)) / Double.parseDouble(numberArray.get(i + 1));
                                numberArray.set(i - 1, String.valueOf(temp));
                                numberArray.remove(i);
                                numberArray.remove(i);
                                i -= 2;
                                break;
                        }
                    }
                    for (int i = 1; i < numberArray.size() - 1; i = i + 2) {
                        switch (numberArray.get(i)) {
                            case "+":
                                temp = Double.parseDouble(numberArray.get(i - 1)) + Double.parseDouble(numberArray.get(i + 1));
                                numberArray.set(i - 1, String.valueOf(temp));
                                numberArray.remove(i);
                                numberArray.remove(i);
                                i -= 2;
                                break;
                            case "-":
                                temp = Double.parseDouble(numberArray.get(i - 1)) - Double.parseDouble(numberArray.get(i + 1));
                                numberArray.set(i - 1, String.valueOf(temp));
                                numberArray.remove(i);
                                numberArray.remove(i);
                                i -= 2;
                                break;
                        }
                    }
                    temp = Double.parseDouble(numberArray.get(0));

                    switch (numberArray.get(1)) {
                        case "+":
                            temp += temp;
                            break;
                        case "-":
                            temp -= temp;
                            break;
                        case "*":
                            temp *= temp;
                            break;
                        case "/":
                            temp /= temp;
                            break;
                    }
                    numberArray.set(0, String.valueOf(temp));
                }
                calculation += numberArray.get(0);
            } else {
                // 마지막 문자가 연산자가 아닌 경우

                for (int i = 1; i < numberArray.size(); i = i + 2) {
                    switch (numberArray.get(i)) {
                        case "*":
                            temp = Double.parseDouble(numberArray.get(i - 1)) * Double.parseDouble(numberArray.get(i + 1));
                            numberArray.set(i - 1, String.valueOf(temp));
                            numberArray.remove(i);
                            numberArray.remove(i);
                            i = i - 2;
                            break;
                        case "/":
                            temp = Double.parseDouble(numberArray.get(i - 1)) / Double.parseDouble(numberArray.get(i + 1));
                            numberArray.set(i - 1, String.valueOf(temp));
                            numberArray.remove(i);
                            numberArray.remove(i);
                            i = i - 2;
                            break;
                    }
                }
                for (int i = 1; i < numberArray.size(); i = i + 2) {
                    switch (numberArray.get(i)) {
                        case "+":
                            temp = Double.parseDouble(numberArray.get(i - 1)) + Double.parseDouble(numberArray.get(i + 1));
                            numberArray.set(i - 1, String.valueOf(temp));
                            numberArray.remove(i);
                            numberArray.remove(i);
                            i = i - 2;
                            break;
                        case "-":
                            temp = Double.parseDouble(numberArray.get(i - 1)) - Double.parseDouble(numberArray.get(i + 1));
                            numberArray.set(i - 1, String.valueOf(temp));
                            numberArray.remove(i);
                            numberArray.remove(i);
                            i = i - 2;
                            break;
                    }
                }
            }

            flag = true;

            // 초기화
            calculatorData.setProgressValue(numberArray);
            view.setValueText(numberArray.get(0));

            calculation += "=";
            view.setPreviewText(calculation);
        }
    }

    /**
     * 계산식의 마지막이 연산자 또는 길이가 0인지 구별하는 메소드
     *
     * @param numberArray
     * @return true : 연산자 맞음 , false : 연산자 아님
     */
    public boolean checkNum(ArrayList<String> numberArray){

        if(numberArray.size() == 0){
            return true;
        }else{
            // 가장 마지막값이
            String text = numberArray.get(numberArray.size()-1);
            if ("+".equals(text) || "-".equals(text) || "/".equals(text) || "*".equals(text)) {
                return true;
            }else{
                return false;
            }
        }
    }
}
