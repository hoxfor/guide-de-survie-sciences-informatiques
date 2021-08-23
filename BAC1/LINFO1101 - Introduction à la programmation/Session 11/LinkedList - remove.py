def remove(self):
    if self.first() is not None:
        self.__head = self.first().next()
        self.__length -= 1