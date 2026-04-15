n,m = map(int,input().split())
ball = [i for i in range(1,n+1)]
for i in range(m):
    a,b = map(int,input().split())
    c = ball[a-1];
    d = ball[b-1]
    ball[a-1] = d
    ball[b-1] = c
print(*ball)