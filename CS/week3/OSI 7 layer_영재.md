### 1계층 (physical layer)

---

모든 파일과 프로그램은 0과 1로 이루어져 있다. 두 대의 컴퓨터가 통신을 하기 위해서는 0과 1의 나열이 필요하다.

하지만 현실 세계는 0과 1을 보내면 되지만 그렇게 딱 0,1 만 전송할 수 가 없음.

보낼 때에는 디지털 신호를 아날로그 신호로 (encoding)

받을 때에는 아날로그 신호를 디지털 신호로 (decoding)

0과 1의 나열로 해석해서 물리적으로 연결된 컴퓨터가 0, 1의 나열을 주고 받을 수 있게 해주는 모듈 (우리가 프로그래밍 할 때 만드는 함수라고 생각하자)

![Untitled](https://file.notion.so/f/s/ec280dbe-b8b0-4a6c-87f6-68a86ae46587/Untitled.png?id=43d0250a-eab8-49b6-8e62-d2a0c182a2b2&table=block&spaceId=31cca12f-8434-4350-8e15-b65cdbdefa03&expirationTimestamp=1680342228540&signature=peJ_xvk_Tn8Jn3MP2AfkA6Q6jqcK0sEzDphkkYy_xJM&downloadName=Untitled.png)

### physical layer는 어디에 구현되어 있을까?

---

1계층 모듈은 하드웨어적으로 구현되어 있음 (PHY칩)

네트워크의 기본 네트워크 하드웨어 전송 기술을 이룬다. (encode, decode, input, output,,,)

전송 단위는 Bit(0, 1)이다.

### 2계층을 알기 전에

여러 대의 컴퓨터 통신에 대해서 생각을 해보자

두 대의 컴퓨터가 통신을 하고 싶을 때 전선을 연결했는데 여러대이면 또 전선을 연결하고, 또 연결하고,,,

<aside>
💡 물리적으로 전선을 연결할 많은 구멍과 전선이 있기만하면 된다!
컴퓨터가 많아질수록 비용이 올라간다.

</aside>

전선을 계속 연결하는 방법 밖엔 없을까?

전선 하나로 여러 대를 연결할 수는 없을까?

![IMG_B8D784DF04F0-1.jpeg](https://file.notion.so/f/s/6a832645-c7f6-4873-86af-e816fd42c937/IMG_B8D784DF04F0-1.jpeg?id=89c8c245-1b77-43e0-b098-f925767f0c1c&table=block&spaceId=31cca12f-8434-4350-8e15-b65cdbdefa03&expirationTimestamp=1680342513102&signature=4vEmmfPiQb0K8jRBLs9nLP7IqLYRDz9e6ofrYKSyvwc&downloadName=IMG_B8D784DF04F0-1.jpeg)

A한테만 보내고 싶지만 모두가 다 받음

하지만 결과적으로 A가 받긴 했음!!

저 전선을 모두 구겨서 상자에 넣었다고 생각해보자

![IMG_3FFE7885AEA9-1.jpeg](https://file.notion.so/f/s/0bdad4f2-6395-4cf1-aa62-0862f136785e/IMG_3FFE7885AEA9-1.jpeg?id=583da163-302e-4ca4-9488-c954553f52bb&table=block&spaceId=31cca12f-8434-4350-8e15-b65cdbdefa03&expirationTimestamp=1680343193424&signature=IT9SaFAwXtxcRP0H8FBwhkb97cGksv2dJ5gEDbIlCmY&downloadName=IMG_3FFE7885AEA9-1.jpeg)

상자는 더미허브라고 한다.

<aside>
💡 결국 이래도 데이터는 보낼 수 있지만 원치 않는 사용자가 데이터를 읽을 수 있다는 문제가 있다.

</aside>

하지만 상자가 원하는 목적지를 확인해서 그 경로로만 데이터를 전송할 수 있게 한다면?

그걸 가능하게 한 상자를 스위치라고 한다. 일종의 컴퓨터로 동작

저 묶음 자체가 네트워크 (= 인트라넷)

![IMG_2CD990DE6401-1.jpeg](https://file.notion.so/f/s/cf7c98c8-32d6-4309-bce1-40179698c4dc/IMG_2CD990DE6401-1.jpeg?id=a6685c7b-582e-4624-8439-3c955bc10205&table=block&spaceId=31cca12f-8434-4350-8e15-b65cdbdefa03&expirationTimestamp=1680343211575&signature=lXEDCMU2w7cfVyxS-3YiEnljMJoegRN7FAohIAbIVk4&downloadName=IMG_2CD990DE6401-1.jpeg)

데이터 전송을 하고 싶지만 물리적으로 연결되어있지 않아 전송할 수 없다.

스위치와 스위치를 연결할 수 있다면?

<aside>
💡 두 네트워크에 속한 컴퓨터끼리 통신을 하게 해주는 장비를 라우터라고한다.

</aside>

이제 저 상자를 우리는 공유기라고 부른다.

이제 통신이 가능하다!! 

이런식으로 컴퓨터들을 연결한 것을 인터넷! 이라고 한다.

![IMG_303C87649A95-1.jpeg](https://file.notion.so/f/s/fec9f9e2-a91e-4c55-a772-82f9167d6e42/IMG_303C87649A95-1.jpeg?id=79e867ab-2d62-4b22-9689-9de386a78632&table=block&spaceId=31cca12f-8434-4350-8e15-b65cdbdefa03&expirationTimestamp=1680343239342&signature=bIlU-OCvcNXYRoreXCH4dO01GRYk9eebVBsshduGcgo&downloadName=IMG_303C87649A95-1.jpeg)

여러 대를 연결하는건 이제 알겠다.

여러 대의 컴퓨터가 동시에 한 컴퓨터에 데이터를 전송한다고 생각해보자. 데이터들이 011010101010010101,,, 이렇게 올건데 어디서부터 어디까지가 누가 보낸건지 알기가 어렵다.

이를 위해 송신을 하는 사람은 데이터 앞 뒤에 특정 비트열을 붙여서 보낸다. (ex: 1000 0001)

`1000`0110`0001`1010`1010`0101`0101` 이렇게 끊어서 읽게되어 누가 보냈는지 구분이 가능

### 2계층 (data-link layer)

---

- 같은 네트워크에 있는 여러 대의 컴퓨터들이 데이터를 주고받기 위해서 필요한 모듈
- framing : 데이터를 구분 짓기 위해 감싸는 작업
- 데이터 단위 `frame`
- 하드웨어적으로 구현되어 있음 (랜카드)

### 3계층 (network layer)

---

가 → 나로 데이터를 보내고 싶음

![IMG_25F536FDE04E-1 2.jpeg](https://file.notion.so/f/s/002b1351-a498-4a02-bf33-0c23ec5fa6c4/IMG_25F536FDE04E-1_2.jpeg?id=b439bdad-3e2a-44c1-a4ac-70af48ed0bc9&table=block&spaceId=31cca12f-8434-4350-8e15-b65cdbdefa03&expirationTimestamp=1680343262490&signature=g5johSbB5H24spNYDrrbtTGUf-IhToGf6C2Rr3SH17Q&downloadName=IMG_25F536FDE04E-1+2.jpeg)

가는 데이터와 함께 나의 목적지 주소를 붙임

이 주소가 IP 주소라고 한다!!

이를 알기 쉽게 변환한 것을 DNS (www.naver.com)

<aside>
💡 목적지 주소 + 데이터 = 패킷(datagram)

</aside>

라우터는 전송을 시작하는데 우리는 어떻게 데이터를 보내야 할지 직관적으로 알 수 있지만 라우터는 이를 직관적으로 알 수 가 없다. 

이를 위해서는 라우팅을 알아야 한다. 라우팅은 결국 목적지로 잘 갈 수 있도록 해주는 역할!!!

- 결국 목적지 주소를 가지고 라우팅(길을 찾는 과정)을 하면서 데이터를 계속 전달, 전달,,,(포워딩) 하여 데이터를 넘겨주는 과정이 진행되는 곳을 network layer라고 한다.
- 여러개의 노드를 거칠때마다 경로를 찾아주는 역할을 하는 계층으로 다양한 길이의 데이터를 네트워크들을 통해 전달하고, 그 과정에서 전송 계층이 요구하는 서비스 품질(QoS)을 제공하기 위한 기능적, 절차적 수단을 제공한다.
- 네트워크 계층은 라우팅, 흐름 제어, 세그멘테이션(segmentation/desegmentation), 오류 제어, 인터네트워킹(Internetworking; 많은 네트워크 속에서 데이터를 전송하는 작업) 등을 수행한다.
- 논리적인 주소 구조(IP), 곧 네트워크 관리자가 직접 주소를 할당하는 구조를 가지며, 계층적(hierarchical)이다.
- 데이터 전송 단위는 `Datagram(Packet)`이다.
- 운영체제 커널에 소프트웨어적으로 구현되어 있다.

### 4계층 (transport layer)

---

- 양 끝단(End to end)의 사용자들이 신뢰성있는 데이터를 주고 받을 수 있도록 해 주어, 상위 계층들이 데이터 전달의 유효성이나 효율성을 생각하지 않도록 해준다.
- 시퀀스 넘버 기반의 오류 제어 방식을 사용한다.
- 전송 계층은 특정 연결의 유효성을 제어하고, 일부 프로토콜은 상태 개념이 있고(stateful), 연결 기반(connection oriented)이다. (이는 전송 계층이 패킷들의 전송이 유효한지 확인하고 전송 실패한 패킷들을 다시 전송한다는 것을 뜻한다.)
- 가장 잘 알려진 전송 계층의 예는 TCP이다.
- 데이터 전송 단위는 Segment이다.
- 

### 5,6 계층

---

현대 네트워크 모델 OSI ❌

TCP/IP 모델 ⭕️ → 이 역시 네트워크 시스템에 대한 모델

시장 점유 경쟁에서 OSI가 밀렸음

7계층에 5,6계층이 합쳐져 있음

TCP/IP 소켓 프로그래밍

- OS의 transport layer에서 제공하는 API를 활용해 통신가능한 프로그램을 만드는 것

1. **세션 계층(Session layer)**
    - 양 끝단의 응용 프로세스가 통신을 관리하기 위한 방법을 제공한다.
    - 동시 송수신 방식(duplex), 반이중 방식(half-duplex), 전이중 방식(Full Duplex)의 통신과 함께, 체크 포인팅과 유휴, 종료, 다시 시작 과정 등을 수행한다.
    - 이 계층은 TCP/IP 세션을 만들고 없애는 책임을 진다.
2. **표현 계층(Presentation layer)**
    - 코드 간의 번역을 담당하여 사용자 시스템에서 데이터의 형식상 차이를 다루는 부담을 응용 계층으로부터 덜어 준다.
    - MIME 인코딩이나 암호화 등의 동작이 이 계층에서 이루어진다.

![Untitled](https://file.notion.so/f/s/1a7f380a-72dd-4bf9-a99d-e12396f82806/Untitled.png?id=0a4c011c-4cde-4c7f-9b7b-c51d5c387b94&table=block&spaceId=31cca12f-8434-4350-8e15-b65cdbdefa03&expirationTimestamp=1680343285924&signature=LEs8Dh3aB221irQECma4Yceqe2brwJiKcv3guBUxFdw&downloadName=Untitled.png)

### 7계층 (application layer)

---

응용 계층(Application layer)

- 응용 프로세스와 직접 관계하여 일반적인 응용 서비스를 수행한다.
- 일반적인 응용 서비스는 관련된 응용 프로세스들 사이의 전환을 제공한다.

응용 계층은 **애플리케이션과 데이터를 주고 받기 위한 역할**을 하는데, 서버가 이해할 수 있는 메시지(데이터)로 변환하고, 전송 계층에 전달하는 역할을 수행한다.

대표적인 프로토콜로 HTTP 인코딩 & 디코딩이 있다.

status code: 1xx, 2xx, 3xx,,, 등등 헤더 정보와 더 많은 정보들을 붙여서 인코딩

### 마무리

---

MVC 패턴은 소프트웨어 아키텍처 중 하나이다.

MVC 와 똑같이 소프트웨어 아키텍처 중에 layered architecture 가 있다.

이 아키텍처를 따르는 대표적인 예가 네트워크 시스템이다. 즉, 네트워크 시스템은 하나의 큰 소프트웨어

OSI 7 layer 모델은 거대한 소프트웨어의 구조를 설명하는 것 (MVC와 똑같은 아키텍처 구조)

References

---

[](https://t1.daumcdn.net/cfile/tistory/9947BD33599C18FE33)

[OSI 7 Layers 와 TCP/IP Model[수정필요]](https://velog.io/@amuse/OSI-7-Layers)

[[10분 테코톡] 🔮 히히의 OSI 7 Layer](https://www.youtube.com/watch?v=1pfTxp25MA8&t=5s)
