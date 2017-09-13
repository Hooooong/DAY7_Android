package hooooong.com.basiclayout.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import hooooong.com.basiclayout.Model.CalculatorData;
import hooooong.com.basiclayout.R;
import hooooong.com.basiclayout.View.Presenter.CalculatorPresenter;
import hooooong.com.basiclayout.View.Presenter.ICalculator;

/**
 * Created by Android Hong on 2017-09-12.
 */

public class CalculatorActivity extends AppCompatActivity implements ICalculator.View{

    private CalculatorPresenter presenter;

    TextView valueTxt;
    TextView previewTxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initView();
        initListener();

        presenter = new CalculatorPresenter();
        presenter.attachView(this);
        presenter.setCalculatorData(CalculatorData.getInstance());
    }

    /**
     *
     */
    public void initView(){
        valueTxt = (TextView)findViewById(R.id.valueTxt);
        previewTxt = (TextView)findViewById(R.id.previewTxt);
    }

    /**
     * Listener 초기화
     */
    public void initListener(){
        findViewById(R.id.number1).setOnClickListener(onClickListener);
        findViewById(R.id.number2).setOnClickListener(onClickListener);
        findViewById(R.id.number3).setOnClickListener(onClickListener);
        findViewById(R.id.number4).setOnClickListener(onClickListener);
        findViewById(R.id.number5).setOnClickListener(onClickListener);
        findViewById(R.id.number6).setOnClickListener(onClickListener);
        findViewById(R.id.number7).setOnClickListener(onClickListener);
        findViewById(R.id.number8).setOnClickListener(onClickListener);
        findViewById(R.id.number9).setOnClickListener(onClickListener);
        findViewById(R.id.number0).setOnClickListener(onClickListener);
        findViewById(R.id.plus).setOnClickListener(onClickListener);
        findViewById(R.id.minus).setOnClickListener(onClickListener);
        findViewById(R.id.division).setOnClickListener(onClickListener);
        findViewById(R.id.multiple).setOnClickListener(onClickListener);
        findViewById(R.id.eqaul).setOnClickListener(onClickListener);
        findViewById(R.id.reset).setOnClickListener(onClickListener);
    }

    /**
     * 다시 시작했을 시
     */
    @Override
    protected void onResume() {
        super.onResume();
        presenter.clearValue();
    }

    /**
     * 버튼 클릭 이벤트 처리
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int getId = view.getId();
            switch (getId){
                case R.id.number1:
                    presenter.appendValue("1");
                    break;
                case R.id.number2:
                    presenter.appendValue("2");
                    break;
                case R.id.number3:
                    presenter.appendValue("3");
                    break;
                case R.id.number4:
                    presenter.appendValue("4");
                    break;
                case R.id.number5:
                    presenter.appendValue("5");
                    break;
                case R.id.number6:
                    presenter.appendValue("6");
                    break;
                case R.id.number7:
                    presenter.appendValue("7");
                    break;
                case R.id.number8:
                    presenter.appendValue("8");
                    break;
                case R.id.number9:
                    presenter.appendValue("9");
                    break;
                case R.id.number0:
                    presenter.appendValue("0");
                    break;
                case R.id.reset:
                    presenter.clearValue();
                    break;
                case R.id.plus:
                    presenter.appendCalculate("+");
                    break;
                case R.id.minus:
                    presenter.appendCalculate("-");
                    break;
                case R.id.multiple:
                    presenter.appendCalculate("*");
                    break;
                case R.id.division:
                    presenter.appendCalculate("/");
                    break;
                case R.id.eqaul:
                    presenter.resultValue();
                    break;

            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void setPreviewText(String processText) {
        previewTxt.setText(processText);
    }

    @Override
    public void setValueText(String value) {
        valueTxt.setText(value);
    }

    @Override
    public void setValueFontSize(String value) {
        switch (value.length()){
            case 11:
                valueTxt.setTextSize(20);
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
        }
    }
}
