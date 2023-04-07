## Transaction의 의미

- 더 이상 쪼갤 수 없는 하나의 연산 단위
- 송금 관련 문제가 대표적이다
    - A가 1000원을 B에게 송금
    - 송금을 하기 위해선 다음과 같은 과정이 필요
        - A의 계좌에 1000원 이상 있는지 확인
        - A의 계좌에서 1000원을 출금
        - B의 계좌 잔액에 1000원을 더함
    - 이러한 일련의 과정이 송금을 하기 위한 최소 연산 단위 → 트랜잭션
- 만일 송금 과정중에서 문제가 생기게 된다면 어떻게 해야할까?

## Rollback, Commit


![11](https://user-images.githubusercontent.com/49267211/230520707-adcb1084-a74d-494f-9972-518b11505d52.png)

- 앞서 말한 문제가 발생하지 않기 위해 Transaction 전체가 성공한 경우가 아니라면 Rollback을 하여 변경 된 것들을 모두 되돌려 놓는다.
- 마무리 작업까지 적용이 된다면 Commit을 통해 DB에 적용한다.

## ACID

- Atomicity (원자성) : 모두 성공하거나 모두 실패하거나
- Consistency (일관성) : 일관성있는 처리 결과
- Isolation (독립성) : 여러 트랜잭션이 이루어져도 독립적으로
- Durability (지속성) : 커밋된 트랜잭션의 결과는 영구 저장

## 독립성을 유지할 수 있는 방법

![22](https://user-images.githubusercontent.com/49267211/230520715-631e47e8-54ff-4632-aba9-f4c5acc85617.png)

- 어떠한 Transaction이 사용하고 있는 데이터에 행위에 따라 Table lock, Row lock 등이 걸리게 된다. → 다른 트랜잭션이 건들지 못하게 하는 것
- Transaction 간 격리가 엄격할 수록 일관성이 높아지지만 동시성이 낮아진다.
- 각 트랜잭션에 따라서 격리 수준을 조정하여 성능을 높일 수 있다.
    - READ UNCOMMITTED : 커밋, 롤백과 상관없이 읽기 가능 
    → 다른 Transaction이 끝나지도 않는데 데이터를 읽는 Dirty-Read 발생
    - READ COMMITTED : 기본 세팅, 백업 레코드에서 데이터를 읽어옴
    → 이 경우에도 금전거래 예시와 같은 문제 발생
    - REPEATABLE READ : Transaction ID를 매겨 ID가 더 낮은 곳에서 변경된 것만을 읽는다.
    → 변경 작업에 따라 결과가 보였다 안보였다 하는 Phantom-Read 발생
    - SERIALIZABLE : 제일 엄격하고 사용 되어지지 않는 → 동시성이 사실상 제로

## References.

- [https://youtu.be/sLJ8ypeHGlM](https://youtu.be/sLJ8ypeHGlM)
- [https://velog.io/@jifrozen/Dining-together-트랜잭션Transaction과-Transactional-정리](https://velog.io/@jifrozen/Dining-together-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98Transaction%EA%B3%BC-Transactional-%EC%A0%95%EB%A6%AC)
