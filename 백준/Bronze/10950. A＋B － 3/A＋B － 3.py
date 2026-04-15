n = open(0).readlines()
for i in n[1:]:
    a, b = map(int,i.split())
    print(a+b)