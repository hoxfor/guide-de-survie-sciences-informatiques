def __init__(self, lst=[]):
    self.__length = 0
    self.__head = None
    tmp = lst.copy()
    tmp.reverse()
    for i in tmp:
        self.add(i)