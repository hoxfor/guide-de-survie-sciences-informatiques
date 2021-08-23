def set_a(self, n_a):
    self.p.a = n_a
    if self.p.a <= self.p.b:
        self.ordered = True
    else:
        self.ordered = False
def set_b(self, n_b):
    self.p.b = n_b
    if self.p.a <= self.p.b:
        self.ordered = True
    else:
        self.ordered = False