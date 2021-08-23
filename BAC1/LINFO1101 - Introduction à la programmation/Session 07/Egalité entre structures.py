def equal(l,d):
    dic = True
    lis = True
    for x,y in d:
        try:
            if l[x][y] != d[(x,y)]:
                dic = False
        except:
            None
    for i in range(len(l)):
        for j in range(len(l[i])):
            try:
                if l[i][j] != d[(i,j)]:
                    lis = False
            except:
                if l[i][j] != 0:
                    lis = False
    return (dic and lis)