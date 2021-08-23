class Student:
    __next_number = 0
    def __init__(self, firstname, surname, birthday, email):
        self.__number = Student.__next_number
        Student.__next_number += 1
        self.firstname = firstname
        self.surname = surname
        self.birthday = birthday
        self.email = email
    def __str__(self):
        return 'Student number {0}: {1} {2} born the {3}, can be reached at {4}'.format(
            self.__number, self.firstname, self.surname, self.birthday, self.email
        )