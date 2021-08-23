class Character:
    
    def __init__(self, life=100, damage=10):
        self.life = life
        self.attack_point = damage
    
    def attack(self, target):
        target.get_hit(self.attack_point)
    
    def get_hit(self, damage):
        self.life -= damage
    
class Cratos(Character):
    
    def __init__(self, life=100, damage=10):
        super().__init__(life, damage)
        self.life = life
        self.damage = damage
        self.experience = 0
    
    def gain_XP(self, amount):
        self.experience += amount
        while self.experience >= 10:
            self.experience -= 10
            self.attack_point += 1
    
class Drauf(Character):
    
    def __init__(self, life, damage):
        super().__init__(life, damage)