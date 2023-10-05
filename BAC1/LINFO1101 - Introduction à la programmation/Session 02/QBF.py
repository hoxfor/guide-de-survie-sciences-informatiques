for entier in range (1, n+1):
    div = 0
    for i in range (1, entier):
        if entier % i == 0:
            div += 1
    print (entier, ":", div,)