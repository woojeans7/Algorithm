# 시간복잡도 (Time Complexity)

> 시간복잡도(Time Complexity)는 알고리즘이 문제를 해결하는 데 걸리는 시간을 입력 크기에 따라 표현한 것이다.

알고리즘의 효율성을 평가하는 가장 중요한 지표 중 하나로, "입력 크기 n이 커질 때 실행 시간이 얼마나 증가하는가?"를 나타낸다.

## 특징

1. **Big-O 표기법**: 최악의 경우(Worst Case)를 기준으로 알고리즘의 성능을 평가한다. 가장 보편적으로 사용된다.
2. **입력 크기 n에 대한 함수**: 연산 횟수를 정확하게 세는 것이 아니라, n이 증가할 때의 **증가율**을 중점적으로 본다.
3. **상수 제거**: $O(3n)=O(n)$처럼 상수는 무시한다. 큰 입력에서는 계수보다 차수가 중요하기 때문이다.
4. **최고차항만 고려**: $O(n^2+n)=O(n^2)$처럼 가장 영향이 큰 항만 남긴다.

## 대표적인 시간복잡도

성능 순서 (빠름 → 느림):

$$O(1) < O(\log n) < O(n) < O(n \log n) < O(n^2) < O(2^n) < O(n!)$$

### $O(1)$ - 상수 시간
입력 크기와 관계없이 **항상 일정한 시간**이 걸린다.

```java
int getFirst(int[] arr) {
    return arr[0];  // 배열의 첫 번째 원소 접근
}
```

**예시**:
- 배열의 인덱스 접근
- HashMap의 get, put 연산 (평균)
- 스택의 push, pop

---

### $O(log n)$ - 로그 시간
입력 크기가 커져도 **매우 천천히** 증가한다. 보통 **문제를 절반씩 나누는** 알고리즘에서 나타난다.

```java
int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

**예시**:
- 이진 탐색 (Binary Search)
- 균형 이진 트리의 탐색 (AVL, Red-Black Tree)
- 분할 정복 알고리즘의 분할 과정

---
### $O(n)$ - 선형 시간
입력 크기에 **비례**하여 시간이 증가한다. 모든 요소를 한 번씩 확인해야 하는 경우.

```java
int findMax(int[] arr) {
    int max = arr[0];
    for (int num : arr) {  // n번 반복
        if (num > max) max = num;
    }
    return max;
}
```

**예시**:
- 배열 순회
- 연결 리스트 탐색
- 선형 탐색

---

### $O(n log n)$ - 선형 로그 시간
효율적인 **정렬 알고리즘**의 시간복잡도. 분할 정복 방식에서 자주 등장한다.

```java
// 병합 정렬 (Merge Sort)
void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);      // 절반 분할 (log n)
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);   // 병합 (n)
    }
}
```

**예시**:
- 병합 정렬 (Merge Sort)
- 퀵 정렬 (Quick Sort - 평균)
- 힙 정렬 (Heap Sort)

---

### $O(n^2)$ - 이차 시간
**중첩된 반복문**에서 주로 나타난다. 입력 크기가 2배가 되면 시간은 4배가 된다.

```java
void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {      // n번
        for (int j = 0; j < arr.length - i - 1; j++) {  // n번
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

**예시**:
- 버블 정렬, 선택 정렬, 삽입 정렬
- 2차원 배열 순회
- 모든 쌍 비교 문제

---

### $O(2^n)$ - 지수 시간
입력이 1 증가할 때마다 시간이 **2배씩** 증가한다. 매우 비효율적이며, 작은 입력에서만 실행 가능하다.

```java
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);  // 2개의 재귀 호출
}
```

**예시**:
- 메모이제이션 없는 피보나치
- 모든 부분집합 생성
- 백트래킹 (최악의 경우)

---

### $O(n!)$ - 팩토리얼 시간

가장 느린 시간복잡도. **모든 순열**을 생성하는 경우 등에서 나타난다.

```java
void permutation(List<Integer> nums, List<Integer> current) {
    if (current.size() == nums.size()) {
        // 순열 완성
        return;
    }
    for (int num : nums) {  // n × (n-1) × (n-2) × ... × 1
        if (!current.contains(num)) {
            current.add(num);
            permutation(nums, current);
            current.remove(current.size() - 1);
        }
    }
}
```

**예시**:
- 모든 순열 생성
- 외판원 문제 (Brute Force)

## 시간복잡도 분석 방법

### 1. 반복문 횟수 세기

```java
for (int i = 0; i < n; i++) {        // n번
    for (int j = 0; j < n; j++) {    // n번
        // 연산
    }
}
// 총 n × n = O(n²)
```

### 2. 재귀 호출 분석

```java
void recursion(int n) {
    if (n <= 0) return;
    recursion(n / 2);  // 매번 절반씩 줄어듦
}
// T(n) = T(n/2) + O(1) → O(log n)
```

### 3. 분할 정복의 마스터 정리

$$T(n)=aT(n/b)+f(n)$$

- $a$ : 재귀 호출 횟수
- $b$ : 문제를 나누는 크기
- $f(n)$ : 분할/병합 비용

**예시**: 병합 정렬

$$T(n)=2T(n/2)+O(n)→O(nlog⁡n)$$

## 코딩테스트에서의 시간복잡도

입력 크기 $n$에 따른 **적절한 시간복잡도**:

| 입력 크기 (n)     | 시간복잡도 목표        | 알고리즘 예시       |     |
| ------------- | --------------- | ------------- | --- |
| $n≤10$        | $O(n!), O(2n)$  | 순열, 부분집합      |     |
| $n≤20$        | $O(2^n)$        | 비트마스킹, 백트래킹   |     |
| $n≤100$       | $O(n^3)$        | 플로이드-워셜       |     |
| $n≤1,000$     | $O(n^2)$        | 이중 반복문, DP    |     |
| $n≤10,000$    | $O(nlog⁡n)$     | 정렬, 우선순위 큐    |     |
| $n≤100,000$   | $O(nlog⁡n)$     | 병합 정렬, 이진 탐색  |     |
| $n≤1,000,000$ | $O(n)$          | 선형 탐색, 해시맵    |     |
| $n>1,000,000$ | $O(logn), O(1)$ | 이진 탐색, 수학적 공식 |     |

---

## 활용 시 주의사항

1. **입력 크기 확인**: 문제에서 주어진 n의 범위를 보고 적절한 알고리즘을 선택한다.
2. **시간 제한**: 보통 1초에 약 **1억(10⁸) 번의 연산**이 가능하다고 가정한다.
3. **공간복잡도 고려**: 시간복잡도가 좋아도 메모리 제한을 초과하면 안 된다.
4. **실제 실행 시간**: Big-O는 증가율을 나타내므로, 같은 $O(n)$ 이라도 상수가 다르면 실행 시간이 다를 수 있다.

---

## 추천 문제

### 시간복잡도 분석 연습

- **프로그래머스**: [k번째수](https://school.programmers.co.kr/learn/courses/30/lessons/42748) - $O(n\log⁡n)$
- **백준**: [수 정렬하기](https://www.acmicpc.net/problem/2750) - $O(n^2)$ vs $O(n \log n)$ 비교
- **LeetCode**: [Two Sum](https://leetcode.com/problems/two-sum/) - $O(n^2)$ → $O(n)$ 최적화

### 최적화 필요 문제

- **백준**: [수 찾기](https://www.acmicpc.net/problem/1920) - 선형 탐색 vs 이진 탐색
- **프로그래머스**: [가장 큰 수](https://school.programmers.co.kr/learn/courses/30/lessons/42746) - 정렬 활용
- **LeetCode**: [3Sum](https://leetcode.com/problems/3sum/) - $O(n^3)$ → $O(n^2)$ 최적화