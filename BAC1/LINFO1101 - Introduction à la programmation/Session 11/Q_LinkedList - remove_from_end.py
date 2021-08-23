def remove_from_end(self):
    if self.__length > 1:
        current = self.__head
        while current.next().next() is not None:
            current = current.next()
        current.set_next(None)
        self.__length -= 1
    else:
        self.__head = None
        self.__length = 0