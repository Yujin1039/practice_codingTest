# [Silver V] 분수찾기 - 1193 

[문제 링크](https://www.acmicpc.net/problem/1193) 

### 성능 요약

메모리: 16056 KB, 시간: 152 ms

### 분류

구현, 수학

### 랭킹 코드

idea: 구하고자 하는 숫자는 문제 속 사각형의 대각선 내에 속해있음

각 대각선에는 2,3,4,... 개수의 요소가 있으므로 

`a*(a+1)/2 ≤ 구하고자 하는 n번째 ≤ (a+1)(a+2)/2` 에 속하고

구하고자 하는 요소는 a번째 대각선의 l =`n - a*(a+1)/2`번째 요소임

홀수번째 대각선의 경우, 위 → 아래로 이동하므로 `(n+1)-l/l` 

짝수번째 대각선의 경우, 아래 → 위로 이동하므로 `l/(n+1)-l`

### 제출 일자

2024년 9월 13일 20:08:02

### 문제 설명

<p>무한히 큰 배열에 다음과 같이 분수들이 적혀있다.</p>

<table class="table table-bordered" style="width:30%">
	<tbody>
		<tr>
			<td style="width:5%">1/1</td>
			<td style="width:5%">1/2</td>
			<td style="width:5%">1/3</td>
			<td style="width:5%">1/4</td>
			<td style="width:5%">1/5</td>
			<td style="width:5%">…</td>
		</tr>
		<tr>
			<td>2/1</td>
			<td>2/2</td>
			<td>2/3</td>
			<td>2/4</td>
			<td>…</td>
			<td>…</td>
		</tr>
		<tr>
			<td>3/1</td>
			<td>3/2</td>
			<td>3/3</td>
			<td>…</td>
			<td>…</td>
			<td>…</td>
		</tr>
		<tr>
			<td>4/1</td>
			<td>4/2</td>
			<td>…</td>
			<td>…</td>
			<td>…</td>
			<td>…</td>
		</tr>
		<tr>
			<td>5/1</td>
			<td>…</td>
			<td>…</td>
			<td>…</td>
			<td>…</td>
			<td>…</td>
		</tr>
		<tr>
			<td>…</td>
			<td>…</td>
			<td>…</td>
			<td>…</td>
			<td>…</td>
			<td>…</td>
		</tr>
	</tbody>
</table>

<p>이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.</p>

<p>X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.</p>

### 출력 

 <p>첫째 줄에 분수를 출력한다.</p>

