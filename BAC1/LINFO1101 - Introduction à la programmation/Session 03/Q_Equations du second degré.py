def rho(a,b,c):
    return b**2 - 4*a*c

def n_solutions(a,b,c):
    delta = rho(a,b,c)
    if delta < 0 and (a > 0 or b > 0) and c == 0:
        return 1
    elif delta < 0:
        return 0
    elif delta == 0:
        return 1
    else:
        return 2

def solution(a,b,c):
    delta = rho(a,b,c)
    if delta == 0:
        return -b/(2*a)
    else:
        root = racine_carree(delta)
        if ((-b-root)/(2*a)) > ((-b+root)/(2*a)):
            return ((-b+root)/(2*a))
        else:
            return ((-b-root)/(2*a))