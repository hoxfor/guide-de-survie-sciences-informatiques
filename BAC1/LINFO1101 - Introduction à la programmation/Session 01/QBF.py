# s0 = ...    #Entier de départ
si = s0
print(si)
while si != 1:  # Boucle tant que la suite n'est pas finie
    if si % 2 == 0:  # Si si est pair
        si = si // 2
    else:  # Si si est impair
        si = 3 * si + 1
    print(si)  # On retourne si
