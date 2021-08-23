def recherche (m,v):
    numrows = len(m)
    numcols = len(m[0])
    for i in range (numrows):
        for l in range (numcols):
            if v == m[i][l]:
                return True
    return False