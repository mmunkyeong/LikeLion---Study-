## ☕What is Bean?

### Java Bean vs Spring Bean

- Java에서의 Bean은 DTO, VO와 같은 특정 형태를 갖는 객체
    - 특정 형태?
        - 모든 Field가 Private여서 Getter, Setter로만 접근이 가능한 ~
        - NoArguments 생성자를 갖는 형태 like POJO
- Spring에서의 Bean은 Spring IoC 컨테이너가 관리하는 객체
    - IoC (Inversion of Control) 
    : 제어의 역전, 객체의 생성, 호출을 개발자가 아닌 Spring이 Control
    - 무슨 관리를 하는데? → 생성, 호출, 라이프 사이클 관리, DI

### Using Spring Bean

- Annotation > xml
- 기본적으로 Singleton (객체가 한 번만 생성되는)
- request, session, global session은 Spring MVC Web Application에서 사용
- Singleton이 문제가 되는 경우?
    - 하나의 객체를 여러 요청에서 처리를 하게 될 때 Context Switching
    - ThreadLocal
        - Thread는 Stack 영역을 제외한 프로세스 메모리 공유
        - Stack 영역은 공유하지 않음
    - Controller, Service, Repository, Component에서도 문제일까?
    - 그렇다면 Entity는?
        
        ```java
        @Getter
        @Setter
        @Entity
        public class SiteUser {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
        
            @Column(unique=true)
            private String username;
        
            private String password;
        
            @Column(unique=true)
            private String email;
        }
        ```
        

References.

- [https://cofived.tistory.com/39](https://cofived.tistory.com/39)
- [https://velog.io/@gillog/Spring-DIDependency-Injection](https://velog.io/@gillog/Spring-DIDependency-Injection)
- [https://jjingho.tistory.com/10](https://jjingho.tistory.com/10)
- [https://youtu.be/3gURJvJw_T4](https://youtu.be/3gURJvJw_T4)
- [https://gmlwjd9405.github.io/2018/11/10/spring-beans.html](https://gmlwjd9405.github.io/2018/11/10/spring-beans.html)
- [https://docs.spring.io/spring-framework/docs/current/reference/html/core.html](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)
- [https://velog.io/@noakafka/Spring-동시성-문제](https://velog.io/@noakafka/Spring-%EB%8F%99%EC%8B%9C%EC%84%B1-%EB%AC%B8%EC%A0%9C)
- [https://jins-dev.tistory.com/entry/Spring-의-Bean-들의-Thread-safety-에-대한-정리](https://jins-dev.tistory.com/entry/Spring-%EC%9D%98-Bean-%EB%93%A4%EC%9D%98-Thread-safety-%EC%97%90-%EB%8C%80%ED%95%9C-%EC%A0%95%EB%A6%AC)
