class Weapon:
    def __init__(self, attack):
        self.attack = attack

class Cratos:
    def __init__(self, weapon):
        self.weapon = weapon
    def set_weapon(self, weapon):
        self.weapon = weapon
    def hit(self, enemy):
        enemy.get_hit(self.weapon.attack)
        
class Drauf:
    def __init__(self, life):
        self.life = life
    def get_hit(self, damage):
        self.life -= damage