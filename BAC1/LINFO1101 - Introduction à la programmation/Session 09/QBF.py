class CD(Item):
    
    __next_serial_number = 100000
    
    def __init__(self, author, title, length):
        self.__author = author
        self.__title = title
        self.__length = length
        self.__serial = CD.__next_serial_number
        CD.__next_serial_number += 1
        
    def __str__(self):
        return "[{}] {}, {} ({} s)".format(self.__serial, self.__author, self.__title, self.__length)