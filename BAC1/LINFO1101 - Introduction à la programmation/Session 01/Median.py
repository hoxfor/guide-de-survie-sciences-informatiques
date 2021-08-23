# a = ... #variable à évaluer
# b = ... #variable à évaluer
# c = ... #variable à évaluer
# median = ... #enregistrez dans cette variable la médiane des trois variables
# Détermination de la médianne
if a > b:
    if a < c:
        median = a
    elif b > c:
        median = b
    else:
        median = c
else:
    if a > c:
        median = a
    elif b < c:
        median = b
    else:
        median = c
# Affichage de la médianne
print('La medianne est :', median)
