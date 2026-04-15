array = open(0).readlines()
max = 0
for i in array:
    num = int(i.rstrip('\n'))
    if num > max:
        max = num

print(max)
print(array.index(str(max)+'\n')+1)