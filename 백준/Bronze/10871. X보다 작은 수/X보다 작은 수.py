n,x = map(int,input().split())
array = list(map(int,input().split()))
for i in array:
    if i < x:
        print(i,end=' ')