# ❓스택(Stack)

## 스택과 큐의 개념 설명

<aside>
💡 **스택 : LIFO 형태로 데이터를 저장하는 구조**

</aside>

### 주요 동작

- **push : 뽑아내다**
- **pop : 밀다**
- **peek : 몰래 엿보다**

### 동작 설명

**① push(1) → ② push(2) → ③ push(3) → ④ pop() → ⑤ peek() → ⑥ pop()**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d3b080e9-328a-4251-b1e6-4530fb446fec/Untitled.png)

<aside>
💡 **큐: FIFO 형태로 데이터를 저장하는 구조**

</aside>

### **주요 동작**

- **enqueue : 대기 행렬(큐)에 더하다.**
- **dequeue : 대기 행렬(큐)에서 해제시키다.**
- **peek : 몰래 엿보다**

### **동작 설명**

**① enqueue(1) → ② enqueue(2) → ③ enqueue(3) → ④ dequeue()**

**→ ⑤ dequeue() → ⑥ peek() → ⑦ enqueue(5) → ⑧ dequeue()**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/66ea65e9-e328-4ac2-89d9-623fdedf6fbf/Untitled.png)

### 스택 사용 사례

- **stack memory & stack frame**

```java
public class ABC {
    static void A() {
        B();
    }
    static void B() {
        C();
    }
    static void C() {
        System.out.println("끝");
    }

    public static void main(String[] args) {
        A();
    }
}
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/485947ea-228e-4001-a768-15e6719633d9/Untitled.png)

### 큐 사용 사례

- **producer/consumner architecture**

<aside>
💡 **Producer-Consumer Architecture(생산자-소비자 아키텍처)는 컴퓨터 과학에서 일반적으로 사용되는 디자인 패턴 중 하나입니다.

이 아키텍처는 데이터를 생성하는 Producer(생산자)와 데이터를 소비하는 Consumer(소비자) 사이의 효율적인 통신을 위해 사용됩니다.

Producer는 데이터를 생성하고, 이 데이터를 전송하여 Consumer가 소비하도록 합니다. 이를 통해 Producer와 Consumer는 병렬로 동작하여 시스템 전체적인 성능을 향상시킬 수 있습니다.

대표적으로 메세지 큐(Message Queue)가 있습니다.

메세지 큐는 Producer가 생성한 데이터를 큐에 저장하고, Consumer는 큐에서 데이터를 가져와 소비합니다.**

</aside>

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c2be8cc2-b07d-491f-9c59-0004180ece7d/Untitled.png)

### 기술 문서에서 큐를 만났을 때 팁

- **항상 FIFO를 의미하지는 않음**

<aside>
💡 **싱글코어 CPU 환경 멀티 테스킹**

</aside>

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ced91c9d-c660-43ab-8220-c47b08444282/Untitled.png)

**“데이터들을 대기하고 있는 공간”이라는 의미로도 사용됨**

**✨ priority queue는 큐이지만 FIFO가 아닌 우선순위가 높은 것이 먼저 빠져나가는 구조이다.**

### **스택과 큐 관련 에러와 해결 방법**

> **StackOverflowError : 스택 메모리를 다 썼을 때**
>
- **거의 대부분이 재귀 함수에서 탈출 못해서 발생**
- **해결 방법 : 탈출 조건을 잘 써주면 된다. 하지만 너무 깊은 재귀는 안될 수도 있다.**

> **OutOfMemoryError : 힙 메모리를 다 썼을 때**
>
- **큐에 데이터가 계속 쌓이기만 한다면 발생**
- **해결 방법 : 큐 사이즈를 고정한다.**
- **💀 방지하기 위해 사이즈를 고정했지만 큐가 다 찼을 땐?**
    - **예외 던지기**
    - **특별한 값을 반환 (null or false)**
    - **성공할 때까지(큐에 공간이 생길 때까지) 영원히 스레드 블락(block)
      → 블락이 된 이후 작업을 못하니 스레드 낭비가 발생 할 수 있음**
    - **제한된 시간만 블락되고 그래도 안되면 포기**
    - **대표적인 구현 클래스 : LinkedBlockingQueue**

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/38c89937-2681-4708-a05a-8a348d37e9a6/Untitled.png)


**참조 : [https://www.youtube.com/watch?v=-2YpvLCT5F8](https://www.youtube.com/watch?v=-2YpvLCT5F8)**