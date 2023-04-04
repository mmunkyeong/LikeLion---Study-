# ❓ Static Pages, Dynamic Pages

<aside>
💡 Static Pages(정적 페이지) :
클라이언트가 고정된 페이지를 요청하면 웹 서버는 일치하는 페이지를 단순히 반환한다.
→ ex) GET :/member/index.html  |  /static/common.css 등

</aside>

<aside>
💡 Dynamic Pages(동적 페이지) :
클라이언트가 인자를 포함한 페이지를 요청하면 해당 인자에 맞는 페이지를 구성하여 반환한다.
→ ex) GET :/likeablePerson/delete/3

</aside>

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/05d0a0cf-6413-4d27-828b-d64e25c49a4f/Untitled.png)

# ❓ Web Server

<aside>
💡 Web Server :
클라이언트로부터 요청을 받아 정적인 컨텐츠를 반환하는 컴퓨터 프로그램

</aside>

### 기능)

1. **정적인 컨텐츠 제공**
2. **WAS를 거치지 않고 바로 자원 제공**
3. **동적인 컨텐츠 제공을 위한 요청 전달**
4. **클라이언트의 요청을 WAS에 보내고, WAS가 처리한 결과를 클라이언트에게 응답**

### 예시)

- **Apache Server, Nginx, IIS(윈도우 전용 웹 서버) 등**

# ❓ Web Application Server

<aside>
💡 Web Application Server :
**Web Server + Web Container**
DB 조회나 다양한 로직 처리를 요구하는 동적인 컨텐츠를 제공하기 위한 Application Server

❗Web Container : Servlet Container 라고도 불리며, JSP/Servlet을 실행시킬 수 있는 소프트웨어이다. 즉, JSP/Servlet 구동 환경을 제공한다.

</aside>

### 기능)

1. **프로그램 실행 환경과 DB 접속 기능 제공**
2. **여러 개의 트랜잭션 관리 기능**
3. **업무를 처리하는 비즈니스 로직 수행**

### 예시)

- **Tomcat, JBoss, Jeus, Web Sphere 등**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/046af122-ddb8-40f1-8514-f603de0fd139/Untitled.png)

# ❓ Web Server가 필요한 이유

- **클라이언트에 이미지 파일을 보내는 과정**
    - 이미지 파일과 같은 정적인 파일들은 웹 문서(HTML)가 클라이언트로 보내질 때 함께 보내지지 않는다.
    - 클라이언트는 HTML을 먼저 받고, 그에 따라 필요한 정적인 파일들(이미지 파일들)을 다시 서버에 요청하면 그제서야 정적인 파일들을 받아온다.
    - Web Server를 통해 정적인 파일들을 Application Server까지 가지 않고, 앞단에서 빠르게 줄 수 있다.

> **따라서 Web Server에서는 정적인 파일들만 처리하도록 기능을 분배하면, 서버의 부담을 줄일 수 있다!**
>

# ❓ Web Application Server가 필요한 이유

- **웹페이지는 정적 컨텐츠와 동적 컨텐츠가 공존한다.**
    - 클라이언트의 요청에 맞게 적절한 컨텐츠를 만들어서 제공해야 한다.
    - 이때, Web Server만 사용하려면 클라이언트의 모든 요청을 대비해서 미리 만들어두고 서비스를 해야한다.
    - 하지만 이렇게 하면 자원이 절대적으로 부족하다!

> **따라서 WAS를 통해 고객의 요청에 맞게 그때그때 마다 DB 작업과 비즈니스 로직들을 수행해 결과물을 만들어서 제공함으로써 자원을 효율적으로 쓸 수 있다.**
>

<aside>
💡 **그렇다면 WAS가 Web Server의 기능까지 모두 수행하면, WAS만 사용해도 되는 것 아닌가?**

</aside>

> **결론을 먼저 말하면 가능하다. 하지만 여러가지 문제점들이 발생할 수 있다.**
>

### ❗문제점

1. **서버 과부하**
    1. WAS는 DB 조회나 다양한 로직들을 처리하느라 바쁘기에 단순한 정적 컨텐츠들은 Web Server로 빠르게 처리하는게 좋다.
    2. WAS는 기본적으로 동적 컨텐츠들을 위한 서버이다.
    3. 만약 정적 컨텐츠까지 담당하게 된다면, 정적 + 동적 데이터 처리가 지연됨에 따라 수행 속도가 느려질 수 있다.
    4. 즉, 이로 인해 페이지 로딩 시간이 길어진다.
2. **물리적으로 분리하여 보안 강화**
    1. SSL에 대한 암복호화 처리에 Web Server를 사용한다.
    2. WAS에서 SSL 처리를 하면, 웹 애플리케이션의 코드에 의해 SSL 인증서가 제대로 관리되지 않거나, SSL 프로토콜 버전이 적절하지 않은 등의 보안 문제가 발생할 수 있다. 반면, Web Server에서 SSL 처리를 하면 보안 설정을 중앙 집중적으로 관리할 수 있어서 보안성이 높아진다.
3. **여러 대의 WAS를 연결 가능**
    1. Load Balancing을 위해서 Web Server를 사용한다.
    2. fail over(장애 극복), fail back 처리에 유리하다.
    3. 특히 대용량 웹 어플리케이션의 경우, Web Server와 WAS를 분리하여 무중단 운영을 위한 장애 극복에 쉽게 대응할 수 있다.
    4. 예를 들어, 앞 단의 Web Server에서 오류가 발생한 WAS를 이용하지 못하게 한 후, 해당 서버로의 요청을 다른 서버로 돌리고 WAS를 재시작함으로써 사용자는 오류를 느끼지 못하고 이용할 수 있다.
4. **여러 웹 어플리케이션 서비스 가능**
    1. Load Balancing을 통해 여러 대의 서버를 이용하면, PHP Application과 Java Application처럼 서로 다른 언어나 프레임워크를 사용할 수 있다.

<aside>
💡 **Web Server에서는 단순히 HTTP 요청을 처리하는 역할만 수행하므로, 동적인 데이터 처리나 비즈니스 로직 처리와 같은 기능은 WAS에서 처리해야 한다.

즉, 자원 이용의 효율성 및 장애 극복, 배포 및 유지 보수의 편의성을 위해 Web Server와 WAS를 분리한다.

Web Server를 WAS 앞에 두고 필요한 WAS들을 Web Server에 플러그인 형태로 설정하면 더욱 효율적인 분산 처리가 가능하다.

따라서, Web Server와 WAS를 조합하여 사용하는 것이 좋다.**

</aside>