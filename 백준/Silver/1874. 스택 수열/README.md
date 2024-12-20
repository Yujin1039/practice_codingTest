# [Silver II] 스택 수열 - 1874 

[문제 링크](https://www.acmicpc.net/problem/1874) 

### 성능 요약

메모리: 26772 KB, 시간: 296 ms

### 분류

자료 구조, 스택

### 랭킹 코드

https://www.acmicpc.net/source/80571362

배열과 현재 저장된 가장 큰 숫자를 의미하는 start를 써서 작성했다는건 알겠는데

"NO"가 도출되는 로직이 이해가지 않는다.

### 해결 시간이 많이 소요된 이유

이미 stack에 포함된 요소의 "다음 숫자"부터 push 해야함을 찾는데 시간 소모가 컸고

stack에 포함된 요소 중 "가장 큰 숫자"보다 큰 수를 push 해야함을 늦게 알았다.

입력값은 push하지 않고 pop만 하여(입력값 -1까지만 push함), 맨 처음 1이 등장하는 경우, "+"를 한 뒤에 "-"를 하는 로직이 없어 계속 틀렸다.

### 제출 일자

2024년 10월 18일 13:42:52

### 문제 설명

<p>스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.</p>

<p>1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.</p>

### 입력 

 <p>첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.</p>

### 출력 

 <p>입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.</p>

