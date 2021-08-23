def create_dict(lst):
    d = {}
    for x, y in lst:
        if x in d:
            d[x].append(y)
        else:
            d[x] = [y]
    return d