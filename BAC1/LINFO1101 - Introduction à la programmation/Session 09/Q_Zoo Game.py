class Animal:
    
    def __init__(self, name):
        self.name = name
        self.diurnal = None
        self.nb_legs = None
        self.asleep = False
        
    def sleep(self):
        if self.asleep is False:
            self.asleep = True
        else:
            raise RuntimeError
    
    def wake_up(self):
        if self.asleep is True:
            self.asleep = False
        else:
            raise RuntimeError
    
    def typ(self):
        return 'Animal'

class Lion(Animal):
    
    def __init__(self, name):
        super().__init__(name)
        self.diurnal = True
        self.nb_legs = 4
    
    def roar():
        print ('ROARRR!!!')

class Owl(Animal):
    
    def __init__(self, name):
        super().__init__(name)
        self.diurnal = False
        self.nb_legs = 2
    
    def fly():
        pass
    
class Giraffe(Animal):
    
    def __init__(self, name, neck_length):
        super().__init__(name)
        self.diurnal = True
        self.nb_legs = 4
        if not isinstance(neck_length, (int, float)) or neck_length < 0:
            raise ValueError
        else:
            self.neck_length = neck_length
        
class Zoo:
    
    def __init__(self):
        self.animals = []
    
    def add_animal(self, animal):
        if animal.typ() != 'Animal':
            raise ValueError
        else:
            self.animals.append(animal)
        
def create_my_zoo():
    Prince = Lion('Thomas')
    Tocard = Owl('Romain')
    Ich_ich = Giraffe('Pierre', 42)
    Aristocrate = Giraffe('Dylan', 96)
    
    elite = Zoo()
    elite.add_animal(Prince)
    elite.add_animal(Tocard)
    elite.add_animal(Ich_ich)
    elite.add_animal(Aristocrate)
    
    return elite

create_my_zoo()