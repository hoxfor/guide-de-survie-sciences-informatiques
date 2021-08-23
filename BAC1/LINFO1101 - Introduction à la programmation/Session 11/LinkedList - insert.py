def insert(self, s):
    element = self.first()
    if element is not None:
        while s > element.next().value():
            element = element.next()
        string = LinkedList.Node(s, element.next())
        element.set_next(string)
        self.__length += 1
    else:
        self.add(s)