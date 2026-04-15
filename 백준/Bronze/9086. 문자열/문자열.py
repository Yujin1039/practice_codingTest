a = open(0).readlines()
for i in a[1:]:
    print(i[0]+i[-2])