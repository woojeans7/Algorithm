# 깊이 우선 탐색 (DFS)

깊이 우선 탐색(Depth-First Search)은 그래프의 시작 노드에서 출발하여 탐색할 한 쪽 분기를 정하여 최대 깊이까지 탐색을 마친 후 다른 쪽 분기로 이동하여 다시 탐색을 수행하는 알고리즘이다.

재귀함수나 스택 자료구조를 사용하여 구현한다.

## 재귀함수

깊이를 따라 들어갔다가, 막히면 되돌아오는 패턴을 가지기 때문에 재귀함수로 구현할 수 있다.
쉽게 한 놈씩 한 놈만 패는 구조로 타고, 타고, 타고 들어가서 한 놈만 찾아낸다고 생각하면 쉽다.

### 동작 방식

인접 리스트 그래프로 표현, 방문을 저장할 배열 초기화

1. 그래프, 방문 배열, 시작 노드를 입력으로 받는 dfs 메서드 작성
2. 방문 배열에 시작 노드를 추가
3. 그래프에서 현재 노드의 인접 노드를 하나씩 꺼내어서 방문했는지 체크
4. 인접노드가 방문한 적이 없으면 dfs 메서드를 재귀로 호출 후 반복

## 스택 (Stack)

탐색방식이 후입선출(LIFO) 특성을 가지기 때문에 스택이 적합하다.

### 동작 방식

인접리스트 그래프로 표현, 방문을 저장할 배열 초기화

1. 시작할 노드를 정한 후 사용할 자료구조(인접 리스트) 초기화
2. 스택에 시작 노드 저장
3. 스택에서 노드를 꺼낸 후 꺼낸 노드의 인접 노드를 스택에 저장
4. 스택에 값이 없을 때까지 반복

## 활용 예시

- 미로 탐색
- 모든 경로 찾기
- 그래프 연결 요소 찾기
- 백트래킹 문제 (e.g., 퍼즐, 조합 찾기)

## DFS 구현하기

### 재귀로 구현

```java
import java.util.*;

public class DFS {
    // visited를 set으로 구현
    public void dfs(List<List<Integer>> graph, Set<Integer> visited, int curVertex) {
        visited.add(curVertex);
        for (int nextVertex : graph.get(curVertex)) {
            if (!visited.contains(nextVertex)) {
                dfs(graph, visited, nextVertex);
            }
        }
    }

    public void solve(List<List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        dfs(graph, new HashSet<>(), 0);
        System.out.println(visited); // 방문지점 확인
    }

    // 실행용 메소드
    public static void main(String[] args) {

        // *** graph 정보 추가 ***

        (new DFS()).solve(graph);
    }
```

### 스택으로 구현

```java
import java.util.*;

public class DFS {
    // 실행용 메서드
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        // *** 그래프 추가 ***

        dfs(graph, 1);
    }

    public static void dfs(List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>(); // 스택 사용

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;

                // 인접 노드를 역순으로 넣어야 번호 작은 쪽부터 탐색
                List<Integer> neighbors = graph.get(node);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
```
