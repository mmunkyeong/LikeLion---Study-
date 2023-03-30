# JPA Persistence Context (영속성 컨텍스트)

### !!JPA는 인터페이스이며 ORM(Object Relational Mapper)인 hibernate가 구현체이다!!

### Persistence → 영구적인 Context → 맥락, 문맥

- 트랜잭션이 일어나고 난 이후에도 해당 결과가 지속되어야하는 의미가 영속성을 뜻함
- JPA에서의 Persistence Context는 Application과 DB 사이에서 Entity를 영구적으로 저장해주는 환경이라고 이해하면 OK

### JPA 동작원리

![영속성1](https://user-images.githubusercontent.com/49267211/228696609-8a608084-c74f-445a-bc93-d3773523f6cb.png)

- Entity Manager Factory
    - Entity Manager를 생성하는 관리자
    - Application 실행 시 1개만 생성
- Entity Manager
    - 요청이 들어올 때마다 (Thread가 생길 때 마다) 1개씩 생성
    - DB connection pool 사용하여 접근
    - 고객의 요청 종료 시 close
    - ***하나의 Manager에 하나의 Persistence Context가 있다***
- Entity
    - DB의 테이블과 매핑되는 Class
    - Entity는 Enitity Manager에 의해 다루어진다

### Entity의 Life Cycle

![영속성2](https://user-images.githubusercontent.com/49267211/228696645-e1ceb977-0282-4742-ac3a-2fcbf4785a5f.png)

- Entity 생성 시 persist()를 통해 EntityManager에 ***영속***
- Entity 삭제 시 remove()를 통해 ***비영속***
- Entity를 사용한 후 분리하여 ***준영속***
- EntityManager는 flush()를 통해 DB와 Persistence Context를 동기화
- 비영속과 준영속의 차이? 1차 캐시에서의 식별자 값 보유 여부

### Persistence Context의 특징

- 1차 캐싱: 영속 상태의 Entity를 저장하고 식별자를 갖고 있는 일종의 테이블인 1차 캐시를 보유
- 동일성 보장: 하나의 트랜잭션에서 같은 키값으로 같은 Entity 핸들링 가능
- 쓰기 지연(Transactional write-behind): DB 커밋 직전까지 내부 쿼리 저장소에 모았다가 한번에 처리하기에 성능상으로 이점
- 변경 감지: DB에서 불러온 Entity의 스냅샷 저장 후 이와 비교하여 변경 내용 감지, 자동 Update

### References.

- [https://velog.io/@neptunes032/JPA-영속성-컨텍스트란](https://velog.io/@neptunes032/JPA-%EC%98%81%EC%86%8D%EC%84%B1-%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8%EB%9E%80)
- [https://gmlwjd9405.github.io/2019/08/06/persistence-context.html](https://gmlwjd9405.github.io/2019/08/06/persistence-context.html)
