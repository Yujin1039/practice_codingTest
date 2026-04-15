n = int(input())
for i in range(1,n):
    print(" "*(n-i),end="")
    print("*"*(2*i-1))
print("*"*(2*n-1))
for i in range(n-1,0,-1):
    print(" "*(n-i),end="")
    print("*"*(2*i-1))