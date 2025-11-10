# 그리디(Greedy)

**그리디 알고리즘(Greedy Algorithm)** 은 문제를 해결하기 위해 현재 단계에서 최적이라고 생각되는 것을 선택하는 알고리즘으로, 한글로는 **탐욕법**이라고 한다.

즉, "현재 상황에서 가장 좋아 보이는 것"을 선택하면서 최종 답을 만든다.

주로 문제를 분할 가능한 문제들로 분할한 뒤, 각 문제들에 대한 최적해를 구한 뒤 이를 결합하여 전체 문제의 최적해를 구하는 경우에 주로 사용된다.

그리디 알고리즘은 현재의 최적해가 항상 전체의 최적해를 보장하지는 못하기 때문에 **근사 알고리즘**이라고도 부른다.

## 그리디 성립 조건

그리디를 이용해서 문제를 풀려면 <mark style="background: #FFB86CA6;">탐욕스런 선택 조건(greedy choice property)</mark>과 <mark style="background: #FFB86CA6;">최적 부분 구조 조건(optimal substructure)</mark>이라는 두 가지 조건을 만족해야 한다.

### 1. 탐욕적 선택 속성 (Greedy Choice Property)

- 지금 선택이 나중 선택에 영향을 주지 않는다. (현재의 선택이 미래의 선택에 영향 X)
- 매 순간의 최선이 전체 최선으로 이어진다.

### 2. 최적 부분 구조 (Optimal Substructure)

- 문제의 최적 해결 방법이 부분 문제의 최적 해결 방법으로 구성된다.
- 작은 문제들을 최적으로 풀면, 전체도 최적이 된다.

  > 이 조건을 만족하지 않으면 그리디는 틀린 답을 낼 수 있다!
  >
  > 예시) 동전 문제에서 {1,3,4}원으로 6원을 만들 때, 그리디는 {4+1 +1}로 3개지만, 최적해는 {3+3}으로 2개이다.

## 동작 방식

그리디 알고리즘은 일반적으로 다음과 같은 패턴으로 동작한다.

1. 문제를 여러 단계로 나눈다.
2. 각 단계마다 현재 최선의 선택을 한다. (한 번 선택하면 번복하지 않고, 다음 단계로 넘어감)
3. 선택한 값을 결과에 추가한다.
4. 모든 단계를 완료하면 종료한다.

## 그리디 구현

### 정렬 기반 그리디

가장 기본적인 그리디 패턴. 정렬 후 순서대로 선택하면 최적해가 보장되는 경우

예제 : 거스름돈 문제
500원, 100원, 50원, 10원으로 1260원을 거슬러주는 문제

```java
public class Solution {
    public static int getMinCoins(int money) {
        int[] coins = {100, 500, 10, 50};
        int count = 0;

        Arrays.sort(coins, (a, b) -> b - a);

        for (int coin : coins) {
            count += money / coin;  // 현재 동전으로 최대한 거슬러줌
            money %= coin;          // 남은 금액 갱신
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getMinCoins(1260)); // 출력: 6
        // 500*2 + 100*2 + 50*1 + 10*1 = 6개
    }
}
```

### 구간 스케줄링

시작/끝 시간이 있는 구간 문제. 끝나는 시간 기준 정렬 후 겹치지 않게 선택

예제 : 회의실 배정

```java
import java.util.*;

public class MeetingRoom {
    static class Meeting {
        int start, end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int solution(Meeting[] meetings) {
        // 끝나는 시간 기준 정렬 (같으면 시작 시간 기준)
        Arrays.sort(meetings, (a, b) -> {
            if (a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        });

        int count = 0;
        int lastEnd = 0;

        for (Meeting m : meetings) {
            if (m.start >= lastEnd) {  // 겹치지 않으면
                count++;
                lastEnd = m.end;
            }
        }

        return count;
    }
}
```

### 우선순위 큐 활용

매 순간 최댓값/최솟값을 빠르게 찾아야 할 때. O(logN)으로 최적값 선택

예제: 수 묶기 (카드 합치기)

```java
import java.util.*;

public class MinimizeSum {
    public static int solution(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.offer(num);
        }

        int result = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;

            result += sum;
            pq.offer(sum);
        }

        return result;
    }
}
```

### 카운팅 후 판단

빈도수나 개수를 세어서 많은/적은 순서대로 처리할 때

예제 : Top K 빈도 문자 선택

```java
import java.util.*;

public class TopKFrequent {
    public static String solution(String s, int k) {
        // 1. 빈도수 계산
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // 2. 빈도수 기준으로 정렬
        List<Character> chars = new ArrayList<>(count.keySet());
        chars.sort((a, b) -> count.get(b) - count.get(a)); // 빈도 높은 순

        // 3. 빈도 높은 k개 선택
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(k, chars.size()); i++) {
            sb.append(chars.get(i));
        }

        return sb.toString();
    }
}
```

## 그리디 vs DP

그리디와 DP는 사촌 동생과도 같은 관계다.
완전 탐색이 오래걸려서 DP를 고안했지만 결국 DP도 모든 경우의 수를 체크함.
→ DP보다도 그리디로 더 빠르게 구할 수 있음.

| 구분       | 그리디                 | DP                            |
| ---------- | ---------------------- | ----------------------------- |
| **선택**   | 현재 최선만 고려       | 모든 경우 고려                |
| **번복**   | 불가능 (선택 확정)     | 가능 (메모이제이션)           |
| **속도**   | 빠름 (O(N) ~ O(NlogN)) | 느림 (O(N²) ~ O(2^N))         |
| **정확성** | 조건 만족 시 최적      | 항상 최적                     |
| **예시**   | 거스름돈, 회의실 배정  | 0-1 배낭, 최장 증가 부분 수열 |

<br>

**언제 그리디를 쓸까?**

- 정렬만으로 규칙을 찾을 수 있을 때
- "가장 큰/작은 것부터" 선택이 명확할 때
- 이전 선택이 이후에 영향을 주지 않을 때

## 활용예시

### 문제 유형

- 거스름돈 문제 : 가장 큰 단위 동전부터 사용
- 회의실 배정 : 끝나는 시간이 빠른 회의부터 선택
- 최소 신장 트리 (MST) : Kruskal, Prim 알고리즘 (가장 작은 가중치)
- 배낭 문제 : 단위 무게당 가치가 높은 물건부터 선택

### 추천 문제

- 프로그래머스 Lv.1 [체육복](https://school.programmers.co.kr/learn/courses/30/lessons/42862)
- 프로그래머스 Lv.2 [큰 수 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/42883)
- 프로그래머스 Lv.2 [조이스틱](https://school.programmers.co.kr/learn/courses/30/lessons/42860)
- 프로그래머스 Lv.3 [단속카메라](https://school.programmers.co.kr/learn/courses/30/lessons/42884)
- 백준 11399 [ATM](https://www.acmicpc.net/problem/11399)
- 백준 11047 [동전 0](https://www.acmicpc.net/problem/11047)
- 백준 1541 [잃어버린 괄호](https://www.acmicpc.net/problem/1541)
- 백준 1931 [회의실 배정](https://www.acmicpc.net/problem/1931)
- 백준 1202 [보석 도둑](https://www.acmicpc.net/problem/1202)
- 백준 11000 [강의실 배정](https://www.acmicpc.net/problem/11000)
