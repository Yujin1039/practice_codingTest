# [Gold I] 2048 (Easy) - 12100 

[문제 링크](https://www.acmicpc.net/problem/12100) 

### 성능 요약

메모리: 22468 KB, 시간: 164 ms

### 분류

백트래킹, 브루트포스 알고리즘, 구현, 시뮬레이션

### 시행착오

1. 문제 잘못 파악
   - 이동방식: "한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다." → 같은 블럭이 모두 합쳐진다고 생각
     
2. 매개변수로 가져온 배열 수정시, 호출 전 배열에도 영향을 미침
   - `Arrays.copyOf()`를 사용해 배열의 깊은 복사를 한 후, 매개변수로 전달
     
3. 요소 교환 이후, 포인터 위치 변환에 문제
   - 너무 헷갈려서 위치 변환을 삭제하여 모두 순회
     
4. 요소가 더해진 뒤 다른 요소를 0으로 바꾸면, 0인 자리에 다른 값을 옮겨오기만 해서 0이 아닌 같은 값끼리 충돌하더라도 더해지지 않음
   - ex) 2 2 2 2 → 0 2 2 4
   - 기존 배열 수정 후 반환이 아닌 새로운 배열에 값 저장 후 반환
     
5. 가로,세로,탐색위치에 대한 i,j,l,k 잘못 사용(14% 틀림)
   
6. 같은 방향으로 2번 이상 옮기더라도 값이 변화할 수 있음(77% 틀림)
   - 기존 방향과 같은 방향으로 미는걸 제외했었는데 모든 방향을 순회해야함
   - ex) 우측으로 밀기: 2 2 2 2 → 0 0 4 4 → 0 0 0 8

### 제출 일자

2025년 1월 10일 17:46:06

### 문제 설명

<p>2048 게임은 4×4 크기의 보드에서 혼자 즐기는 재미있는 게임이다. 이 <a href="https://gabrielecirulli.github.io/2048/">링크</a>를 누르면 게임을 해볼 수 있다.</p>

<p>이 게임에서 한 번의 이동은 보드 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동시키는 것이다. 이때, 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다. 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다. (실제 게임에서는 이동을 한 번 할 때마다 블록이 추가되지만, 이 문제에서 블록이 추가되는 경우는 없다)</p>

<table class="table">
	<tbody>
		<tr>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/1.png" style="height:250px; width:251px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/2.png" style="height:250px; width:246px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/3.png" style="height:250px; width:250px"></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td style="text-align:center"><그림 1></td>
			<td style="text-align:center"><그림 2></td>
			<td style="text-align:center"><그림 3></td>
		</tr>
	</tfoot>
</table>

<p><그림 1>의 경우에서 위로 블록을 이동시키면 <그림 2>의 상태가 된다. 여기서, 왼쪽으로 블록을 이동시키면 <그림 3>의 상태가 된다.</p>

<table class="table">
	<tbody>
		<tr>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/4.png" style="height:250px; width:247px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/5.png" style="height:250px; width:246px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/6.png" style="height:250px; width:247px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/7.png" style="height:250px; width:250px"></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td style="text-align:center"><그림 4></td>
			<td style="text-align:center"><그림 5></td>
			<td style="text-align:center"><그림 6></td>
			<td style="text-align:center"><그림 7></td>
		</tr>
	</tfoot>
</table>

<p><그림 4>의 상태에서 블록을 오른쪽으로 이동시키면 <그림 5>가 되고, 여기서 다시 위로 블록을 이동시키면 <그림 6>이 된다. 여기서 오른쪽으로 블록을 이동시켜 <그림 7>을 만들 수 있다.</p>

<table class="table">
	<tbody>
		<tr>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/8.png" style="height:250px; width:247px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/10.png" style="height:250px; width:249px"></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td style="text-align:center"><그림 8></td>
			<td style="text-align:center"><그림 9></td>
		</tr>
	</tfoot>
</table>

<p><그림 8>의 상태에서 왼쪽으로 블록을 옮기면 어떻게 될까? 2가 충돌하기 때문에, 4로 합쳐지게 되고 <그림 9>의 상태가 된다.</p>

<table class="table">
	<tbody>
		<tr>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/17.png" style="height:250px; width:248px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/18.png" style="height:250px; width:252px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/19.png" style="height:250px; width:250px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/20.png" style="height:250px; width:250px"></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td style="text-align:center"><그림 10></td>
			<td style="text-align:center"><그림 11></td>
			<td style="text-align:center"><그림 12></td>
			<td style="text-align:center"><그림 13></td>
		</tr>
	</tfoot>
</table>

<p><그림 10>에서 위로 블록을 이동시키면 <그림 11>의 상태가 된다. </p>

<p><그림 12>의 경우에 위로 블록을 이동시키면 <그림 13>의 상태가 되는데, 그 이유는 한 번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없기 때문이다.</p>

<table class="table">
	<tbody>
		<tr>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/21.png" style="height:250px; width:249px"></td>
			<td style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/12094/22.png" style="height:250px; width:249px"></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td style="text-align:center"><그림 14></td>
			<td style="text-align:center"><그림 15></td>
		</tr>
	</tfoot>
</table>

<p>마지막으로, 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다. 예를 들어, 위로 이동시키는 경우에는 위쪽에 있는 블록이 먼저 합쳐지게 된다. <그림 14>의 경우에 위로 이동하면 <그림 15>를 만든다.</p>

<p>이 문제에서 다루는 2048 게임은 보드의 크기가 N×N 이다. 보드의 크기와 보드판의 블록 상태가 주어졌을 때, 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 보드의 크기 N (1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 게임판의 초기 상태가 주어진다. 0은 빈 칸을 나타내며, 이외의 값은 모두 블록을 나타낸다. 블록에 쓰여 있는 수는 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴이다. 블록은 적어도 하나 주어진다.</p>

### 출력 

 <p>최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력한다.</p>

