# [Silver IV] 접미사 배열 - 11656 

[문제 링크](https://www.acmicpc.net/problem/11656) 

### 성능 요약

메모리: 22244 KB, 시간: 224 ms

### 분류

정렬, 문자열

### Arrays.sort() VS Collections.sort()

- `Arrays.sort()` : QuickSort 선택 -> 최악의 경우 ***O(n²)*** 시간복잡도
- `Collections.sort()` : MergeSort 선택 -> **항상** 시간복잡도가 ***O(n logn)***

### StringBuilder - substring()

- 기능: 기존 문자열을 인덱스 기준 부분 문자열로 받아옴
- 매개변수 특징
  1. (i,j): index가 i인 곳 ~ index가 j-1인 곳
  2. (k): index가 k인 곳 ~ 끝까 

### 제출 일자

2024년 11월 24일 00:21:22

### 문제 설명

<p>접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.</p>

<p>baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.</p>

<p>문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000보다 작거나 같다.</p>

### 출력 

 <p>첫째 줄부터 S의 접미사를 사전순으로 한 줄에 하나씩 출력한다.</p>

