# [Silver IV] 다음 소수 - 4134 

[문제 링크](https://www.acmicpc.net/problem/4134) 

### 성능 요약

메모리: 14408 KB, 시간: 340 ms

### 분류

브루트포스 알고리즘, 수학, 정수론, 소수 판정

### 에라토스테네스의 체

전체(특정) 범위에 대해 소수를 구해야 할 때 유용

→ 여기서는 특정 숫자 이후의 오로지 **1개의 소수만** 탐색하므로 `소수 판별 알고리즘`을 적용하는 것이 유리

### 소수(수학)

소수 = `6 * k + 1` 또는 `6 * k - 1` 형태 (k ≥ 1, 2와 3의 배수가 아니라는 전제 하)

### 제출 일자

2024년 10월 9일 20:25:32

### 문제 설명

<p>
	정수 n(0 ≤ n ≤ 4*10<sup>9</sup>)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.</p>

### 입력 

 <p>
	첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.</p>

### 출력 

 <p>
	각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력한다.</p>

