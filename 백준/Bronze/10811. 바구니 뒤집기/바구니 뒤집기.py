i,j = map(int, input().split())
list1 = list(range(1,i+1))
for x in range(j):
    a, b = map(int, input().split())
    while(b-a > 0):
        list1[a-1],list1[b-1] = list1[b-1], list1[a-1]
        a += 1
        b -= 1
print(*list1)