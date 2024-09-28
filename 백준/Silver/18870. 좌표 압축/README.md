# [Silver II] 좌표 압축 - 18870 

[문제 링크](https://www.acmicpc.net/problem/18870) 

### 성능 요약

메모리: 262816 KB, 시간: 1852 ms

### 분류

값 / 좌표 압축, 정렬

### 코드 분석

1. 초기 코드: 리스트의 indexOf()메서드를 사용 → 시간복잡도(O^2)라서 시간 초과
   
2. 수정 코드: HashMap의 key로 입력받은 숫자를, value로 index를 저장

※ containsKey(), get() 메서드 사용
   
3. 랭킹 코드: 입력값 배열과 index 배열을 동시에 병합정렬(MergeSort) → 정렬된 입력값 배열을 기준으로 같은 인덱스의 index 배열값 위치에 0부터 배치

```java
//arr = [999, 999, 999, 1000, 1000, 1000]
//idx = [5, 3, 1, 4, 2, 0]
        int cnt = 0;
        int num=arr[0];
        int[] res = new int[T];
        for(int i=0;i<T;i++){
            if(arr[i]==num){
                res[idx[i]]=cnt;  // → 새 배열 res에 원래 arr[0](=999)의 위치인 idx[0](=5)에 0 배치 
            }else{
                num=arr[i];       // i번째 이후의 배열의 가장 작은 값 변경
                res[idx[i]]=++cnt;// → 새 배열 res에 원래 arr[i]의 위치인 idx[i]에 cnt를 증가시킨 후 배치
            }
        }
```

### 제출 일자

2024년 9월 28일 19:33:52

### 문제 설명

<p>수직선 위에 N개의 좌표 X<sub>1</sub>, X<sub>2</sub>, ..., X<sub>N</sub>이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.</p>

<p>X<sub>i</sub>를 좌표 압축한 결과 X'<sub>i</sub>의 값은 X<sub>i</sub> > X<sub>j</sub>를 만족하는 서로 다른 좌표 X<sub>j</sub>의 개수와 같아야 한다.</p>

<p>X<sub>1</sub>, X<sub>2</sub>, ..., X<sub>N</sub>에 좌표 압축을 적용한 결과 X'<sub>1</sub>, X'<sub>2</sub>, ..., X'<sub>N</sub>를 출력해보자.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다.</p>

<p>둘째 줄에는 공백 한 칸으로 구분된 X<sub>1</sub>, X<sub>2</sub>, ..., X<sub>N</sub>이 주어진다.</p>

### 출력 

 <p>첫째 줄에 X'<sub>1</sub>, X'<sub>2</sub>, ..., X'<sub>N</sub>을 공백 한 칸으로 구분해서 출력한다.</p>

