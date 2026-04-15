arr = open(0).readlines()
for i in arr[:len(arr)-1]:print(sum(map(int,i.split())))