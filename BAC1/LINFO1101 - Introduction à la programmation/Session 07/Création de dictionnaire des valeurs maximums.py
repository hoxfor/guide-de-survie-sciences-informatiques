def create_dict_max(lst):
    d = {}
    for x, y in lst:
        if x in d:
            if y > d[x]:
                d[x] = y
        else:
            d[x] = y
    return d