def positions(p,s):
    p = p.upper()
    s = s.upper()
    result = []
    index = 0
    if p in s or "?" in p:
        if p[0] != "?":
            c = p[0]
        else:
            c = p[1]
            if c != "?": index = -1
        for ch in s:
            if ch == c or c == "?":
                if s[index:index + len(p)] == p or "?" in p:
                    result.append(index)
            index += 1
    try:
        result.remove(len(s)-1)
    except ValueError:
        pass
    return result