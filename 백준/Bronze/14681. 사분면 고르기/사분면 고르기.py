x,y = map(int,open(0))
if x * y > 0:
    print(1) if x > 0 else print(3)
else:
    print(4) if x > 0 else print(2)