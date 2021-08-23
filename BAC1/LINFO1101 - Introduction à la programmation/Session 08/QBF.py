class Employe:
    def __init__(self, name, salary):
        self.nom = name
        self.salaire = salary
        
    def __str__(self):
        return '{0} : {1}'.format(self.nom, self.salaire)
        
    def augmente(self, augmentation):
        self.salaire += self.salaire*(augmentation/100)