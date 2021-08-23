if not lst:
    return None
else:
    present = []
    count = 0
    for i in lst:
        if not i in present:
            present.append(i)
            count += 1
    return count