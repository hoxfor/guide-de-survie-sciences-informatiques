def fact(n):
    """
        pre: -
        post: calcule la factorielle de n
    """
    f = 1
    for i in range (0,n):
        f *= (n-i)
    return f
print(fact(5))