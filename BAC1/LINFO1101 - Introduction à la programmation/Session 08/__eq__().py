def __eq__(self, p):
    if p is not None:
        return (self.a, self.b) == (p.a, p.b)
    else:
        return False