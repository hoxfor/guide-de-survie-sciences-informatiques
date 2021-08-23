def primes(max):
    not_pri = [False] * (max + 1)
    pri = []
    for i in range(2, (max + 1)):
        if not_pri[i]:
            continue
        for f in range(i*2, (max + 1), i):
            not_pri[f] = True

        pri.append(i)
    return pri