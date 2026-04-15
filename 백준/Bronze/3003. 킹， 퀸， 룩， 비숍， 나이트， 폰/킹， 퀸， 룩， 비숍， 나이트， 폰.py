ori = [1,1,2,2,2,8]
import sys
a = list(map(int,sys.stdin.readline().split()))
for i in range(6):
    ori[i] = ori[i] - a[i]
print(*ori)