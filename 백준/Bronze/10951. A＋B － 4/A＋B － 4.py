n = open(0).readlines()
for i in n:
    a,b = map(int,i.split())
    print(a+b)