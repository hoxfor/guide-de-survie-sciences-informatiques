def carre(n):
    square = []
    for i in range(n):
        sub_list = []
        for l in range(n):
            sub_list.append(i*n+l)
        square.append(sub_list)
    return square