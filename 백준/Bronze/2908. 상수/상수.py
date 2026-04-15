n, m = input().split()
n = ''.join(reversed(n))
m = ''.join(reversed(m))
print(n) if(n > m) else print(m)