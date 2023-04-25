## HashSet

오늘 자바 심화 시간에 다룬 HashSet과 관련하여 새롭게 알게 된 점들이 많아 좀 더 검색해보았다.

우선 기존에 알고 있던 사실은 다음과 같다.

- Hash는 특정 알고리즘을 통해 데이터를 고정된 value (Hash Code)로 변환하는 것이다.
- Set은 중복된 값을 허용하지 않는 Collection이다.
- HashSet은 데이터를 Hash Code를 Key로 실제 값을 Value로 같는 일종의 테이블이다.
- 데이터의 삽입이 일어날 때는 데이터의 Hash Code를 먼저 얻고 이를 key - value 형태로 저장하게 된다.
- HashSet은 저장 순서를 보장하지 않고 LinkedHashSet은 보장한다.
- 같은 Hash Code 값을 같은다면 해시 충돌이 일어나게 되고 이를 해결하기 위한 방법은 Chaining 기법이 존재한다.

이는 자료구조에 대해 공부를 하게 되었을 때 알게 된 사실들이며 실제 자바에서 HashSet를 사용할 때 어렴풋이 알고 있던 상황에서 사용하고 있었다. 하지만 오늘 강의를 듣고 평소엔 아무 생각이 없었는데 의문이 생긴 점이 존재했다. 바로 평소 HashSet을 사용했을 때 **해시 충돌이 있어났는지**와 일어났다면 **어떻게 처리를 하는 지** 였다. 

학부생 시절에 Hash Table을 직접 구현해보면서 Chaining을 구현하고 그런 적은 있었는데 정작 자바에서 HashSet이 이러한 과정을 실제로 거치는지는 확인해본적이 없다. 따라서 직접 확인해보았다.

![set1png](https://user-images.githubusercontent.com/49267211/234174604-e04575bc-e66f-4d4d-8e75-d24dcf539b5d.png)


우선 예상한대로 HashSet은 HashMap의 형태를 띄고 있었다. 위의 ***serialVersionUID***의 경우에는 컴파일러가 해당 클래스를 사용하기 위해 인식표의 역할을 한다. ***PRESENT***의 경우에는 key-value 관계에서 value로 사용이 될 것입니다. 이는 아래에서 확인 가능하다.

![set2](https://user-images.githubusercontent.com/49267211/234174613-a6c8d694-be22-4c62-9c0b-a993b98a67dc.png)

HashSet에 add 하는 상황입니다. 여기서 이상한 점이 key가 Hash Code이고 value가 실제 데이터라고 생각했는데 key가 ***e***, value가 ***PRESENT***가 들어가고 있는 상황이다. 이를 확인하기 위해 HashMap의 put을 보자.

![set3](https://user-images.githubusercontent.com/49267211/234174624-62e561a0-e391-4fb8-8a27-d5d185298c60.png)
![set4](https://user-images.githubusercontent.com/49267211/234174627-e890a322-9bef-4c81-9bfe-b0aef3cddd2f.png)


HashMap.put()이 일어나면 그 안에서 putValue()라는 함수가 다시 실행되는 것을 알 수 있다. hash() 함수 또한 이곳에서 일어나게 된다. 이곳에선 Node라는 클래스를 사용하고 이를 저장하는 Node 배열인 tab이 사용되고 있다. 만일 새롭게 넣게 되는 Object의 hash 값과 같은 hash 값을 갖고 있는 기존 Node가 없다면 new Node를 통해 새로운 Head Node를 생성하게 되고 그렇지 않다면 일련의 과정을 통해 그 뒤에 붙이는 Chaining까지 진행하고 있다. 찾아보니 Chaining시에 사용되는 TreeNode의 경우 ***RBTree***에 사용한다고 한다.

다시 HashSet의 add로 돌아간다면 value 자리에 들어간 ***PRESENT***의 경우 단순한 상수값으로 해당 객체가 들어갔다는 것을 알려주는 용도로만 쓰이게 된다. HashMap의 형태를 그대로 사용하고는 싶으나 Set의 경우 단순히 Object가 들어가는 것이기에 key로써 Object가 들어가고 value는 그냥 자리만 지키면 되는 인턴과 같은 역할을 하게 된다.

![set5](https://user-images.githubusercontent.com/49267211/234174642-0b34b670-6c32-4952-89d7-9dba8818313c.png)

실제로 HashSet의 Contains를 보면 ContainsValue가 아닌 ContainsKey를 사용하고 있는 것을 볼 수 있다. 다시 한번 정리하게 되면 다음과 같다.

1. ***HashSet은 HashMap을 사용한다.***
2. ***HashSet에 Object를 삽입한다는 것은 HashMap에 key-value 형태로 Object와 상수값을 넣는 것이다.***
3. ***HashMap은 Node의 형태로 이며 Node는 Object의 hash value, Object 자신, 위에서 만든 상수 값, Chaining 시에 사용될 다음 Node의 주소값을 갖는다.***

이로써 평소에 생각했던 HashSet이 어떻게 동일한 값을 걸러주는지 알 수 있었다. 애초에 HashMap으로 이루어져있으면 Key값이 같은 것이 존재할 수 없기 때문이다.
