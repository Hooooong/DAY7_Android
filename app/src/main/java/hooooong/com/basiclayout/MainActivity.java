package hooooong.com.basiclayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import hooooong.com.basiclayout.View.CalculatorActivity;

/*
 * 안드로이드 화면 구조
 *
 * Application ( 어플 )
 * -> Activity (화면 한개 단위)
 * -> Fragment ( 화면 조각 )
 * -> Layout 또는 ViewGroup (뷰 그룹:컨테이너)
 * -> Widget(뷰)
 */
public class MainActivity extends AppCompatActivity{
                                    // Activity 기반 클래스를 상속받아서 구성된다.

    // 1. 레이아웃에 정의된 위젯의 아이디로 변수를 선언
    Button btnFrame;
    Button btnLinear;
    Button btnGrid;
    Button btnRelative;
    Button btnCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 0. 레이아웃 xml 파일을 메모리에 로드
        setContentView(R.layout.activity_main);

        // 2. 선언된 변수에 대한 값을 할당(findViewById());
        btnFrame = (Button)findViewById(R.id.btnFrame);
        btnLinear = (Button)findViewById(R.id.btnLinear);
        btnGrid = (Button)findViewById(R.id.btnGrid);
        btnRelative = (Button)findViewById(R.id.btnRelative);
        btnCalculator = (Button)findViewById(R.id.btnCalculator);

        // 3. 위에서 저장한 변수를 사용하면 된다.
        // 3-1. 이벤트 캐치 가 필요할 경우 Listener 를 달아주기
        // 3-2. d아래에 선언한 실행 객체를 리스너에 던저준다.
        btnFrame.setOnClickListener(onClickListener);
        btnLinear.setOnClickListener(onClickListener);
        btnGrid.setOnClickListener(onClickListener);
        btnRelative.setOnClickListener(onClickListener);
        btnCalculator.setOnClickListener(onClickListener);

        /*
         버튼같은 경우에는 생성하지 않아도 바로 사용가능하다.

         findViewById(R.id.btnFrame).setOnclickListener(onLickLister)
         findViewById(R.id.btnLinear).setOnclickListener(onLickLister)
         findViewById(R.id.btnGrid).setOnclickListener(onLickLister)
         findViewById(R.id.btnRelative).setOnclickListener(onLickLister)
         */

    }

    // 리스너를 전역 변수로 선언할 수 있다.
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int getId = view.getId();

            /*
                Activity, Service, Provider, Receiver 실행

                1. 인텐트 생성 ( 시스템에 전달되는 메시지 객체 ) 생성

                    Intent 인텐트명 = new Intent( 자신이 가지고있는 Context, 목적지.class);

                2. 인텐트 실행

                    2-1. 인텐트에 값 넣기

                        인텐트명.putExtra( 변수명, "넘겨줄변수명");

                    2-2. 인텐트 Flag 설정

                        인텐트명.addFlags()

                    2-3. 인텐트 실행

                        startActivity(인텐트명);

                        or

                        startActivityForResult(인텐트명);
             */
            Intent intent = null;

            switch (getId){
                case R.id.btnFrame:
                    intent = new Intent(MainActivity.this, FrameActivity.class);
                    break;
                case R.id.btnLinear:
                    intent  = new Intent(MainActivity.this, LinearActivity.class);
                    break;
                case R.id.btnGrid:
                    intent   = new Intent(MainActivity.this, GridActivity.class);
                    break;
                case R.id.btnRelative:
                    intent = new Intent(MainActivity.this, RelativeActivity.class);
                    break;
                case R.id.btnCalculator:
                    intent = new Intent(MainActivity.this, CalculatorActivity.class);
                    // or intent = new Intent(getBaseContext(), CalculatorActivity.class);
                    break;

            }
            startActivity(intent);
        }
    };
}

