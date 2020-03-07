# java-lotto
로또 미션 진행을 위한 저장소

## 기능 목록
- 구입 금액을 입력 받는다.
        
- 수동 구매 갯수를 입력 받는다.

- 수동 구매 번호를 입력 받는다.
    - 예외
        - 입력 번호의 수가 6개가 아닌 경우
        - 구분자가 이상한 경우
        - int 타입이 아닌 입력이 들어온 경우
        - 로또 숫자 범위를 벗어난 입력이 들어온 경우

- 구매 갯수를 계산한다.
    - 예외
        - 최소 구매 갯수 보다 작은 경우
        - int 타입이 아닌 입력이 들어온 경우
        
- 구매 갯수를 출력한다.

- 로또 번호를 중복없이 랜덤하게 뽑는다.

- 로또 번호를 출력한다.

- 지난 주 당첨 번호를 입력 받는다.
    - 예외
        - 입력 번호의 수가 6개가 아닌 경우
        - 구분자가 이상한 경우
        - int 타입이 아닌 입력이 들어온 경우
        - 로또 숫자 범위를 벗어난 입력이 들어온 경우

- 보너스 볼을 입력 받는다.
    - 예외
        - 로또 숫자 범위를 벗어난 입력이 들어온 경우
        - int 타입이 아닌 입력이 들어온 경우

- 당첨 번호와 구매 로또 번호를 비교하여 당첨 결과를 계산한다.
    - 보너스 볼 일치 경우 계산
 
- 총 수익률을 계산한다.
    
- 당첨 통계를 출력한다.


## 기능 요구사항

- 로또 구입 금액을 입력하면 구임 금액에 해당하는 로또를 발급해야 한다.

- 로또 1장의 가격은 1000원이다.

## 프로그래밍 요구사항

- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.

- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. 
    - if문 안에 while문을 사용한다면 depth가 2단계가 된다.
    
- else를 사용하지 마라.

- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.

- method가 한 가지 일만 하도록 최대한 작게 만들어라.
    - 배열 대신 ArrayList를 사용한다.

- enum을 적용해 프로그래밍을 구현한다.