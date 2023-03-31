| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞힌 사람 | 정답 비율 |
| --- | --- | --- | --- | --- | --- |
| 2 초 | 128 MB | 226066 | 85245 | 50588 | 36.535% |

## [문제](https://www.acmicpc.net/problem/1260)

그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

## 입력

첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

## 출력

첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

## 예제 입력 1

```
4 5 1
1 2
1 3
1 4
2 4
3 4

```

## 예제 출력 1

```
1 2 4 3
1 2 3 4

```

## 예제 입력 2

```
5 5 3
5 4
5 2
1 2
3 4
3 1

```

## 예제 출력 2

```
3 1 2 5 4
3 1 4 2 5

```

## 예제 입력 3

```
1000 1 1000
999 1000

```

## 예제 출력 3

```
1000 999
1000 999
```

**풀이법**

---

가장 기본적인 DFS와 BFS 알고리즘 원리를 사용해서 로직을 구현하는 문제였다.

이 알고리즘을 구현해놓으면 다른 DFS,BFS 문제들에 응용하기 아주 좋은 문제였던 것 같다.

DFS는 스택과 재귀를 이용해서 구현하지만 구현 조건이 있을 때 구현하기 더 쉬운 재귀를 활용하는 것이 더 좋을 것 같다.

BFS는 큐를 이용해서 구현을 하고 항상 방문한 노드는 체크하고 탐색을 다시 시작해야한다는 것을 잊지 말자. 이 부분을 놓쳐서 계속 출력이 하나씩 더 되는 문제가 있었다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited; // 방문을 체크할 배열
    static int[][] nodes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //정점 갯수, 간선 갯수, 시작 정점 노드 입력받기
        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int v = Integer.valueOf(st.nextToken()); // 시작 위치

        visited = new boolean[n];
        nodes = new int[n][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

            int a = Integer.valueOf(st2.nextToken());
            int b = Integer.valueOf(st2.nextToken());

            nodes[a - 1][b - 1] = 1; //연결된 곳은 1로 표시
            nodes[b - 1][a - 1] = 1;
        }

        dfs(v - 1);

        Arrays.fill(visited, false);
        System.out.println();

        bfs(v - 1);
    }

    public static void dfs(int v) {

        System.out.print(v + 1 + " "); // 방문한 노드는 출력
        visited[v] = true;

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[v][i] == 1 && !visited[i]) { // 갈 수 있는 노드이고 방문하지 않은 노드이면
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int num = q.poll();

            System.out.print(num + 1 + " "); // 뽑아서 확인

            for (int i = 0; i < nodes.length ; i++) {
                if (nodes[num][i] == 1 && !visited[i]) {

                    q.add(i); // 큐에 넣고
                    visited[i] = true; // 방문했다고 표시
                }
            }
        }
    }
}
```
