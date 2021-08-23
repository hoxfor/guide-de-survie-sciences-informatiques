def count(events, i, j):
    count = 0
    for (k,l) in events:
        if (k,l) == (i,j):
            count += 1
    return count