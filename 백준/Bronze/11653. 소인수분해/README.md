# [Bronze I] 소인수분해 - 11653 

[문제 링크](https://www.acmicpc.net/problem/11653) 

### 성능 요약

메모리: 14340 KB, 시간: 100 ms

### 분류

수학, 정수론, 소수 판정

### 코드 분석

내 방법: `a = b × c` 로 쪼개서(=재귀) 리스트에 담고, 크기 순 정렬하기

랭킹 코드)
1. 2중 반복문으로 소수를 반복 나눗셈 (~ 제곱근까지) + 소수 추가
2. n이 2,3이거나 1번 수행결과 남은 n이 1보다 큰 경우(=제곱근 보다 큰 마지막 소수), n 추가

```java
import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=2;i<=Math.sqrt(n);i++){
            while(n % i == 0){
                sb.append(i).append("\n");
                //System.out.println(sb.toString());	
                n /= i;
            }
        }

        if(n > 1){
            sb.append(n).append("\n");
        }
            
    	System.out.println(sb.toString());		            
	}
}
```

### 제출 일자

2024년 9월 16일 16:30:21

### 문제 설명

<p>정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.</p>

### 출력 

 <p>N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.</p>

