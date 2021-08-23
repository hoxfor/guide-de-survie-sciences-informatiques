# import math
# float_nb = 3.14
# int_nb = math.ceil(float_nb)  # `int_nb` est égal à 4

import math

filled_time = 80/11 #temps pour que la baignoire contienne exactement 80L

int_filled_time = math.ceil(filled_time)

water_vol = 0

for i in range (1, int_filled_time+1):
    water_vol += 11
    print (i, " minutes, ", water_vol," l")
print ("Au bout de ", i, " minutes, la baignoire contiendra ", water_vol, " litres d'eau")