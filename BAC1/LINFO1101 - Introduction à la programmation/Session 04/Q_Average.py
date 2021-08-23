sum = 0
if not list:
    return None
else:
    for i in list:
        sum += i
    return sum / len(list)