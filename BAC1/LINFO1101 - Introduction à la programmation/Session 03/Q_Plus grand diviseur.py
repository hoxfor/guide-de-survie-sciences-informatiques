if a == 0 or a == 1 : return None
l = []
for i in range(1, a+1):
    if not a % i:
        l.append(i)
return l[-2]