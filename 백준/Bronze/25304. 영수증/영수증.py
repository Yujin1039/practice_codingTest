price = open(0).readlines()
price1 = 0
for i in price[2:]:
    a, b = map(int,i.split())
    price1 += a*b
if int(price[0]) == price1:
    print("Yes")
else:
    print("No")