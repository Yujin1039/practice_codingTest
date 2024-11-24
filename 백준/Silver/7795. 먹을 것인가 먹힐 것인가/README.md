# [Silver III] 먹을 것인가 먹힐 것인가 - 7795 

[문제 링크](https://www.acmicpc.net/problem/7795) 

### 성능 요약

메모리: 34728 KB, 시간: 404 ms

### 분류

이분 탐색, 정렬, 두 포인터

### 이분 탐색(upper bound)

기본적으로 이분 탐색 라이브러리를 lower bound를 사용하기 때문에 upper bound를 원하면 커스텀해야함

`upper bound`: 같은 값이 여러 개 있을 때, 가장 오른쪽에 값 삽입

```java
    static int binarySearch(int[] a,int tmp){
        int start = 0;
        int end = a.length; // ✅ 마지막 인덱스+1
        
        while(start < end){
            int mid = (start+end)/2;
            if(tmp >= a[mid]) start = mid+1; // ✅ 같은 값의 경우, 해당 값 뒤쪽 배열 선택
            else end = mid;
        }
        return start; // ✅ end를 사용하면, tmp가 a의 모든 요소보다 큰 경우 오류 발생
    }
```

### 제출 일자

2024년 11월 25일 01:35:07

### 문제 설명

<p>심해에는 두 종류의 생명체 A와 B가 존재한다. A는 B를 먹는다. A는 자기보다 크기가 작은 먹이만 먹을 수 있다. 예를 들어, A의 크기가 {8, 1, 7, 3, 1}이고, B의 크기가 {3, 6, 1}인 경우에 A가 B를 먹을 수 있는 쌍의 개수는 7가지가 있다. 8-3, 8-6, 8-1, 7-3, 7-6, 7-1, 3-1.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/ee(1).png" style="height:164px; width:209px"></p>

<p>두 생명체 A와 B의 크기가 주어졌을 때, A의 크기가 B보다 큰 쌍이 몇 개나 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 A의 수 N과 B의 수 M이 주어진다. 둘째 줄에는 A의 크기가 모두 주어지며, 셋째 줄에는 B의 크기가 모두 주어진다. 크기는 양의 정수이다. (1 ≤ N, M ≤ 20,000) </p>

### 출력 

 <p>각 테스트 케이스마다, A가 B보다 큰 쌍의 개수를 출력한다.</p>

