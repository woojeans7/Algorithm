# 너비 우선 탐색 (BFS)

너비 우선 탐색(Breadth First Search)은 시작 정점에서 가까운 노드부터 차례로 탐색하는 방식이다.

먼저 방문한 노드를 기준으로 인접한 노드들을 한 층씩 넓게 탐색
큐(Queue) 자료구조를 이용해서 구현한다.

## 큐 (Queue)

탐색 방식이 선입선출(FIFO) 특성을 가지기 때문에 큐가 적합하다.
먼저 거리가 1인 노드를 넣어놓고, 2인 인접노드를 넣으면서 탐색.
거리가 1인 (인접한) 노드부터 처리함.

### 동작 방식

인접리스트 그래프 `graph` 로 표현, 방문을 저장할 배열 `visited` 초기화

1. 큐에 시작 노드를 추가 (방문 처리)
2. 큐에서 노드를 꺼낸 후 인접 노드 탐색
3. 꺼낸 노드의 인접 노드를 큐에 저장 (추가하면 방문처리)
4. 큐가 비어있을 때 까지 반복

## 활용 예시

- 최단 경로(거리) 찾기
- 레벨 탐색
- 미로 찾기

## BFS 구현하기

```java
import java.util.*;

public class BFS {
	public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

		// *** 그래프 추가 ***
		bfs(graph, 0);
	}
    public void bfs(List<List<Integer>> graph, int startVertex) {
        // 시작점 예약
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(startVertex);
        visited.add(startVertex);
        // queue가 비어있을 때까지 반복
        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int curVertex = queue.remove();
            // 다음 노드 예약
            for (int nextVertex : graph.get(curVertex)) {
                if (!visited.contains(nextVertex)) {
                    queue.add(nextVertex);
                    visited.add(nextVertex);
                }
            }
        }
    }
}


```
