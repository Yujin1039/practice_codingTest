a,b,c = map(int,open(0).read().split())
h = a + c // 60
m = b + c % 60
if m >= 60:
    m -= 60
    h += 1
if h > 23:
    h -= 24
print(h,m)