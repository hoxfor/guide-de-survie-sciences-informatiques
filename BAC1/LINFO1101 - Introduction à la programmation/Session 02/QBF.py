for entier in range (1, n+1):
    div = 0
    x = 1
    for i in range (1, entier):
        x += 1
        if entier % i == 0:
            div += 1
    print (x, ":", div,)