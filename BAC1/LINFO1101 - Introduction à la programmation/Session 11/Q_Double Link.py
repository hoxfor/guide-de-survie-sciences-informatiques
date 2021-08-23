class Node:
    def __init__(self, cargo, previous=None, next=None):
        self.__cargo = cargo
        self.previous = previous
        self.next = next

    def get_text(self):
        return self.__cargo

    def set_text(self, string):
        self.__cargo = string

        
class Tape:
    def __init__(self):
        self.pointer = None
        self.__length = 0
    
    def next(self):
        if self.pointer:
            if self.pointer.next:
                self.pointer = self.pointer.next
                return self.pointer.get_text()
        
    
    def previous(self):
        if self.pointer:
            if self.pointer.previous:
                self.pointer = self.pointer.previous
                return self.pointer.get_text()
    
    def get_length(self):
        return self.__length
    
    def add(self, s):
        if self.__length == 0:
            self.pointer = Node(s)
            self.__length += 1
        else:
            current = self.pointer
            while current.next:
                current = current.next # parcours la liste jusqu'au dernier noeud
            current.next = Node(s, previous=current)
            self.__length += 1
    
    def write(self, s):
        if self.pointer:
            self.pointer.set_text(s)
            
    
    def read(self):
        return self.pointer.get_text()
