def ajoute (l,v):
    present = False
    for i in range (len(l)):
        if v == l[i]:
            present = True
    if present != True:
        l.append(v)