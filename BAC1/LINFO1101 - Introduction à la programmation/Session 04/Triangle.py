def triangle(n):
    imb_list = []
    for i in range(n+1):
        sub_list = []
        for element in range(i+1):
            sub_list.append(element)
        imb_list.append(sub_list)
    return imb_list