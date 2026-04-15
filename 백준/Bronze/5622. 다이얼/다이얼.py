dic = {"ABC":3,"DEF":4,"GHI":5,"JKL":6,"MNO":7,"PQRS":8,"TUV":9,"WXYZ":10}
sum = 0
pStr = input()
for i in pStr:
    for j in dic:
        if i in j:
            sum += dic[j]
print(sum)