Android Programing
----------------------------------------------------
#### 2017.09.12 1일차

###### 예제
____________________________________________________

  - [Layout 예제](https://github.com/Hooooong/DAY7_Android/tree/master/app/src/main/java/hooooong/com/basiclayout)

###### 공부정리
____________________________________________________

- Android 기본 구조

    - Android 란?

        > [안드로이드(영어: Android)](https://ko.wikipedia.org/wiki/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C_(%EC%9A%B4%EC%98%81_%EC%B2%B4%EC%A0%9C)는 휴대 전화를 비롯한 휴대용 장치를 위한 운영 체제와 미들웨어, 사용자 인터페이스 그리고 표준 응용 프로그램(웹 브라우저, 이메일 클라이언트, 단문 메시지 서비스(SMS), 멀티미디어 메시지 서비스(MMS)등)을 포함하고 있는 소프트웨어 스택이자 모바일 운영 체제이다. 안드로이드는 개발자들이 자바 언어로 응용 프로그램을 작성할 수 있게 하였으며, 컴파일된 바이트코드를 구동할 수 있는 런타임 라이브러리를 제공한다. 또한 안드로이드 소프트웨어 개발 키트(SDK)를 통해 응용 프로그램을 개발하는 데 필요한 각종 도구와 API를 제공한다.<br>
         안드로이드는 리눅스 커널 위에서 동작하며, 다양한 안드로이드 시스템 구성 요소에서 사용되는 C/C++ 라이브러리들을 포함하고 있다. 안드로이드는 기존의 자바 가상 머신과는 다른 (~~가상 머신인 달빅 가상 머신을 통해(4.4 킷켓 미만 버전)~~) 기존의 달빅VM의 한계점을 해결하기 위해서 구글에서 새로 개발한 런타임인 안드로이드 런타임(Android Runtime)( 4.4킷켓 이상부터 )에서 바로 작성된 응용 프로그램을 별도의 프로세스에서 실행하는 구조로 되어 있다.

    - Android Framwork 구조

        ![]()

    -

- Android Layout

  - Layout 이란?

    > View 위젯들을 화면에 배치하는 과정에서, 위젯의 위치를 정렬하거나, 연관된 위젯들을 그룹화 하는 역할을 수행한다.<br>즉, Layout 클래스는 ViewGroup 이라고 할 수 있다. 모든 Layout 클래스의 부모는 ViewGroup 클래스이기 때문에 View를 담을 수 있는 컨테이너 역할을 할 수 있다.

  - Layout 종류

    > Layout 중 가장 많이 사용되는 LinearLayout, RelativeLayout, FrameLayout, GridLayout, ConstraintLayout, CoordinatorLayout 이 있다.

    - __LinearLayout__

        ![LinearLayout_vertical]()  ![LinearLayout_horizontal]()

        - 선형인 레이아웃으로, 여러 View 위젯들을 가로(속성 : Horizontal) 또는 세로(속성 : vertical)로 나열할 때 사용하는 Layout 클래스이다
        - 기본적으로 중첩이 되지 않으며, 가로&세로 속성에 맞게 나열이 된다

        - 속성

            - WeightSum : View 에 대해서 총 Weight의 값을 설정한다.
            - Layout_wegiht : View 의 비율을 설정할 수 있다.

    - __RelativeLayout__

        ![RelativeLayout]()

        - View 위젯들이 서로 간의 상대적 배치 관계에 때라 화면에 나열할 때 사용하는 Layout 클래스이다.

        - 속성

            - layout_above : ~의 위에 배치하라
            - layout_below : ~의 밑에 배치하라
            - layout_toLeftOf : ~의 왼쪽에 배치하라
            - layout_toRightOf : ~의 오른쪽에 배치하라

            - layout_alignTop : ~와 위쪽 변을 맞춰라
            - layout_alignBottom : ~와 밑쪽 변을 맞춰라
            - layout_alignLeft : ~와 왼쪽 변을 맞춰라
            - layout_alignRight : ~와 오른쪽 변을 맞춰라

            - layout_alignParentTop : true이면 부모와 위쪽 변을 맞춰라
            - layout_alignParentBottom true이면 부모와 밑쪽 변을 맞춰라
            - layout_alignParentLeft : true이면 부모와 왼쪽 변을 맞춰라
            - layout_alignParentRight : true이면 부모와 오른쪽 변을 맞춰라

            - layout_centerHorizontal : true이면 부모의 수평 중앙에 배치하라
            - layout_centerVertical : true이면 부모의 수직 중앙에 배치하라
            - layout_centerInParent : true이면 부모의 수평, 수직 중앙에 배치하라

            - layout_alignBaseLine : ~와 베이스라인을 맞춰라

    - __FrameLayout__

        ![FrameLayout]()

        - 하나의 View 만 보여줄 때 사용하는 Layout 클래스이다.
        - 중첩이 되기 때문에 가장 최근에 중첩된 View를 상위에 보여주게 된다.

    - __GridLayout__

        ![GridLayout]()

        - 속성

            - columnCount : 하나의 줄에 들어갈 수 있는 View 의 갯수를 정함
            - layout_colSpan : 좌우 크기의 갯수를 정한다.
            - layout_rowSpan : 상하 크기의 갯수를 정한다.

    -__ConstraintLayout__

        - 미추가

    -__CoordinatorLayout__

        - 미추가
