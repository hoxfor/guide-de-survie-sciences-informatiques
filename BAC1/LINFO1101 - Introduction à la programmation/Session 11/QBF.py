def remove(self,cargo):
    node = CircularLinkedList.Node(cargo, None)
    current = self.first()
    
    if self.first() == None:
        return None
    elif self.first().value() == cargo and self.first() == self.last():
        self.__first = None
        self.__last = None
        return node
    elif self.first().value() == cargo:
        self.__first = self.first().next()
        self.last().set_next(self.first())
        return node
    
    while current.next() is not self.first():
        if current.next().value() == cargo:
            if current.next() is self.last():
                self.__last=current
                self.__last.set_next(self.first())
                return node
            current.set_next(current.next().next())
            return node
        current = current.next()
    return None
    
def removeAll(self,cargo):
    exist = self.remove(cargo)
    while exist is not None:
        exist = self.remove(cargo)