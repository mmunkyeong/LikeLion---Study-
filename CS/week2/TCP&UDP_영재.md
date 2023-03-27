# TCP&UDP

### 전송계층 (Transport Layer)

End-Point(프로세스와 프로세스) 간 신뢰성있는 데이터 전송을 담당하는 계층. 두 키워드가 전송계층을 이룬다고 해도 무방

> 신뢰성: 데이터를 순차적이고 안정적으로 전달한다는 의미
전송: 포트 번호에 해당하는 프로세스에 데이터를 전달
> 

위 두가지 키워드가 충족이 되지 않는다면

<aside>
💡 신뢰성이 없다면 데이터 순차 전송이 원활히 될 수 없다.

흐름 문제: 송수신자 간의 데이터 처리 속도 차이 수신자가 처리할 수 있는 데이터량을 초과
→ 꽉차서 받을 수 가 없는데 계속 보냄 못받은만큼 데이터 누락 발생

혼잡 문제: 네트워크의 데이터 처리 속도 문제. 네트워크가 혼잡해서 통신이 원활히 이루어지지 않음

</aside>

결과적으로 데이터 손실로 이어진다.

---

## TCP(Transmission Control Protocol)

- 신뢰성있는 데이터 통신을 가능하게 해주는 프로토콜
- 특징: Connection 연결이라고 할 수 있다. (3-way-handshake 방식) → `양방향 통신`
- 데이터 순차 전송 보장
- flow control (흐름제어)
- congestion control (혼잡 제어)
- error detection (오류 감지)
    - 이때 checksum이 활용

**Segment**

- TCP 프로토콜의 packet data unit
- TCP 데이터 전송 단위
- `TCP 헤더 + 데이터 = 세그먼트`

**TCP 헤더**

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/3d87eba2-15d9-4289-a0c3-98c0e46ce944/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230327%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230327T103142Z&X-Amz-Expires=86400&X-Amz-Signature=9c893557000d684032ee8475563993a392110349c714bb152dff8940e402389b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/bcf4ed22-9380-4d16-903c-393b3129ba6b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230327%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230327T103224Z&X-Amz-Expires=86400&X-Amz-Signature=261ca33809a9264d50da499ad32dc637ccdab5e0c3506a2a51cb3efe78534ec3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- [참고] Flag Bit : SYN, ACK, FIN 등 제어 번호 (6비트)

### **3-way handshake (connection 연결) → 연결을 위해 사용**

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/98111435-7d8f-4d4b-a1e8-a41385198ef3/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230327%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230327T103253Z&X-Amz-Expires=86400&X-Amz-Signature=b51b2d2c2e1fc38008e37783a32e20b2d7b453d7a7361d8e41d6f17e37b408bd&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

### **4-way handshake (연결을 해제하는 과정)**

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e3a4c001-b057-4768-9160-5d15827aa9b6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230327%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230327T103311Z&X-Amz-Expires=86400&X-Amz-Signature=988c99fdd3ff43160f580857a7dec09929b700232bb1aacac630655e79c89491&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

### 단점

전송 신뢰성은 보장하지만 매번 connection연결 시 3way handshake를 통해 시간 손실 발생, 패킷을 조금만 손실해도 다시 재전송

그래서 실제 데이터와 전체 결과는 별 차이가 없지만 손실이 조금이라도 나면 다시 전송한다.

---

## UDP (User Datagram Protocol)

TCP보다 신뢰성이 떨어지지만 전송 속도가 빠른 프로토콜

(순차 전송, 흐름 제어, 혼잡 제어를 하지 않음)

3-way handshake ❌ (단방향으로만)

체크섬에서 에러만 검출해줄 뿐

비교적 데이터의 신뢰성이 중요하지 않을 때 (영상 스트리밍할 때에 주로 사용)

데이터를 전송할 때에 TCP와의 차이점이라면 TCP는 데이터를 세그먼트 단위로 쪼개었었는데 UDP는 쪼개지 않음

**UDP 헤더는 TCP에 비해 아주 간단한 구조**

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ed2fd692-5f9c-4266-bd39-c99189a7e24a/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230327%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230327T103334Z&X-Amz-Expires=86400&X-Amz-Signature=5c09b958351e1fa155acc6df25ac9419a4dc1095957ec8407c9893c2173a7425&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

| 필드 | 내용 | 크기(bits) |
| --- | --- | --- |
| Source Port, Destination Port | 송수신 애플리케이션의 포트 번호 | 16 |
| Length | 헤더와 데이터 포함 전체 길이 | 16 |
| Checksum | 헤더와 데이터의 에러 확인 용도. UDP는 에러 복구를 위한 필드가 불필요하기 때문에 TCP 헤더에 비해 간단 | 16 |

전송도 일방적으로 송신 측에서 보내기만하고 수신 측에서는 받기만 함

---

TCP, UDP의 특성을 파악하고 상황에 따라 적절한 프로토콜을 사용하면 좋기 때문에 특징을 알아두면 좋다

TCP, UDP 헤더에 대해 파악하고 성능개선에 이용할 수 있다.

### 성능 개선에는 어떻게 활용할 수 있다는 거지?

### 체크섬에 대해서 더 정리해보는 시간을 가지면 좋겠다.
