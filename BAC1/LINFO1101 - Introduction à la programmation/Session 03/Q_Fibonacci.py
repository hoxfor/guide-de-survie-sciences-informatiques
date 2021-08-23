def fibonacci(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    fibone = 1
    fibtwo = 0
    a = 2
    while a <= n:
        fibn = fibone + fibtwo  
        fibtwo = fibone
        fibone = fibn
        a += 1
    return fibn