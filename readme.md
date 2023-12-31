# [헥사고날 아키텍쳐의 이해]


## 도메인
- 어플리케이션의 핵심 가치
- 포트를 통해서만 외부와 통신할 수 있다
- 주의 : 도메인 != 엔티티


## 포트 
- 도메인이 외부와 통신할 때 사용되는 인터페이스
- 개발 관점에서 보면 서비스는 인풋포트(유스케이스)를 상속받고 아웃풋포트를 주입받는 구현체가 된다
- 인풋포트 
  - 외부에서 도메인에 접근할 때 사용한다
  - 유스케이스가 이에 해당되며 이는 핵심 비지니스 로직이 된다
- 아웃풋포트 
  - 도메인을 외부로 내보낼 때 사용한다
  - 도메인당 CRUD 하나씩 만들어준다 


## 어댑터
- 육각형 구조의 바깥에 해당하며 포트와 연결되어 실제로 외부와 통신을 한다
- 인풋 어댑터 
  - 웹 관점에서 컨트롤러가 이에 해당된다.
  - 컨트롤러는 인풋포트를 주입받아 도메인에 접근한다
- 아웃풋 어댑터
  - JPA, QueryDSL 등이 이에 해당된다
  - 개발 관점에서 보면 아웃풋 어댑터는 아웃풋 포트를 상속받는다

----

## 도메인 및 비지니스 로직
### USER
    사용자 등록

### Account
    - 계좌 등록
    - 계좌 조회
    - 입금
    - 출금
<Br>

----

## 개발 포인트

- 인풋 포트별로 command 를 주고 command 에서 validation 을 진행합니다
- 예외는 ExceptionAdvice 에서 공통으로 처리합니다
- 사용자 정보를 암호화하여 저장됩니다

<br>
<br>







