class LinkedList:
    
    def __init__(self):
        self.__length = 0
        self.__head = None
    
    def add(self, val):
        node = Node(val, self.__head)
        self.__length += 1
        self.__head = node
    
    def get_reverse(self):
        element = self.__head
        reverse = element.get_value()
        while element.get_next() is not None:
            element = element.get_next()
            reverse = reverse + element.get_value()
        return reverse
    
class Node:
        
    def __init__(self, cargo=None, next=None):
        self.__cargo = cargo
        self.__next = next
        
    def get_value(self):
        return str(self.__cargo)
        
    def get_next(self):
        return self.__next