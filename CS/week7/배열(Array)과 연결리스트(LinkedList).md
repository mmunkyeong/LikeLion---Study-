## Array

`배열`은 같은 타입의 변수들로 이루어져 있고 크기가 정해져 있으며, 인접한 메모리 위치에 있는 데이터를 모아 놓은 집합입니다. 또한 중복을 허용하고 순서가 있습니다. 

![image](https://user-images.githubusercontent.com/62290451/234778956-4752db83-0ccf-438d-9d4e-afc9408128ad.png)


배열은  `랜덤 접근(Random Access)` 이 가능합니다. 인덱스에 해당하는 원소를 빠르게 접근해야 하거나 간단하게 데이터를 쌓고 싶을 때 사용합니다. 따라서 데이터 추가와 삭제를 많이 하는 것은 연결리스트, 탐색을 많이 하는 것은 배열로 하는 것이 좋습니다.

<br>

### 선언

```java
int arr1[]= new int[5]; // 선언과 동시에 배열 크기 할당

int arr2[]={1,2,3,4,5}; // 선언과 동시에 배열 크기 지정 및 값 초기화

 // 3x3 2차원 배열 선언
int arr[][]=new int[3][3];
int arr[][]={{1,2,3},{1,2,5},{2,6,8}}; // 선언 및 초기화   
```

<br>

### 랜덤 접근

직접 접근이라고 하는 랜덤 접근은 동일한 시간에 배열과 같은 순차적인 데이터가 있을 때 임의의 인덱스에 해당하는 데이터에 접근할 수 있는 기능입니다.

<br>

## LinkedList

`연결리스트`는 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식의 자료구조입니다. 데이터를 담고 있는 노드들이 연결되어 있고, 노드의 포인터가 이전 노드와 다음 노드와의 연결을 담당합니다. Node는 LinkedList에 객체를 추가하거나 삭제하면 앞뒤 링크만 변경되고 나머지 링크는 변경되지 않습니다. 

![image](https://user-images.githubusercontent.com/62290451/234778991-7a5a926d-848f-4cbe-9a23-5899e0d4c75c.png)

중간에 데이터를 추가, 삭제 하더라도 전체의 인덱스가 한 칸씩 뒤로 밀리거나 당겨지는 일이 없기에 데이터의 추가나 삭제가 용이하지만 특정 요소에 접근하기 위해서는 순차 탐색이 필요로 하여 탐색속도가 떨어진다는 단점이 있습니다. 

<br>

### 선언

```java
LinkedList<Student> member = new LinkedList<Student>(); // 타입 설정 student 객체만 사용가능
LinkedList<Integer> list = new LinkedList<Integer>(); // 선언
LinkedList<Integer> list = new LinkedList<>(); // new에서 타입 파라미터 생략가능
```
<br>

### 값 추가

```java
list.addFirst(1); // 가장 앞에 데이터 추가
list.addLast(2); // 가장 뒤에 데이터 추가
list.add(3); // 데이터 추가
list.add(1,5); // index 1에 데이터 5 추가
```

값 추가시 index를 생략하면 가장 마지막에 데이터가 추가됩니다. addFirst 메소드를 사용하게 되면 가장 앞에 있는 Header의 값이 변경되고 addLast 메소드를 사용하게 되면 맨 뒤에 데이터가 추가됩니다.
<br>

![image](https://user-images.githubusercontent.com/62290451/234779031-13c02955-8447-4133-8406-602ef47ddf5b.png)

값이 추가되는 방식은 위의 그림과 같이 이전 노드는 추가되는 노드를 가리키게 하고 추가되는 노드는 그 다음 노드를 가리키도록 지정합니다. 

<br>

### 값 삭제

```java
list.removeFirst(); // 가장 앞의 데이터 제거
list.removeLast(); //가장 뒤의 데이터 제거
list.remove(); // 생략시 0번째 index 제거
list.remove(1); // index 1 제거
list.clear(); // 모든 값 제거
```

값이 삭제시 removeFirst()메소드를 사용하면 가장 첫 데이터가 removeLast()를 사용하면 가장 뒤에 있는 데이터가 삭제됩니다. remove(index)를 사용하여 특정 index의 값을 제거할 수 있습니다. 값을 전부 제거하려면 clear 메소드를 사용하면 됩니다.

<br>

![image](https://user-images.githubusercontent.com/62290451/234779069-896f4e4b-d954-4af6-ad3c-d6aaa3898831.png)

값이 제거되는 방식은 그림과 같이 삭제 대상 노드의 이전 노드가 삭제 대상 다음 노드를 가리키게 하고 해당 노드는 삭제됩니다. 

<br>

### 값 검색

```java
list.contains(1); // list에 1이 있는지 검색: true
list.indexOf(1); // 1이 있는 index 반환, 값이 없다면 -1 리턴
```

<br>

contains 메소드를 사용하여 만약  값이 있다면 true 값이 없다면 false가 리턴 됩니다. 값이 있는 index를 찾으려면 indexOf(value) 메소드를 사용하고 만약 값이 없다면 -1을 리턴합니다. 

### 종류

- `싱글 연결 리스트`: next 포인터만 가집니다.
- `이중 연결 리스트`: next 포인터와 prev 포인터를 가집니다.
- `원형 이중 연결 리스트`: 이중 연결 리스트와 같지만 마지막 노드와 next포인터가 헤드 노드를 가리키는 것을 말합니다.

<br>


### Array와 LinkedList의 비교
| 배열(Array) | 연결리스트(LinkedList) |
| --- | --- |
| 정적 자료구조 | 동적 자료구조 |
| 미리 크기를 정해 놓음 | 크기 정할 필요 없음 |
| 연속된 메모리 주소를 할당 받음 | 연속된 메모리 주소를 할당 받지 않음 |
| 접근, 탐색 용이 | 추가, 삭제 용이 |
| index 존재 | Node 존재 |

<br>
