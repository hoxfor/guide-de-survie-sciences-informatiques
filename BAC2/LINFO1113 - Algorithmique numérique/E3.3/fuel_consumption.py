import numpy as np 
#E3.3 - Fuel Consumption calcul dérivation standard
x = [1198, 1715, 2530, 2014, 2136, 1492, 1652, 1168, 1492, 1602, 1192, 2045]        
y = [11.90, 6.80, 5.53, 6.38, 5.53, 8.50, 7.65, 13.60, 9.78, 8.93, 11.90, 6.38]

x_barre = np.mean(x)
y_barre = np.mean(y)
x_barre = round(x_barre,2)  
y_barre = round(y_barre,2)
print("moyenne de x = ",x_barre)    
print("moyenne de y = ",y_barre)

def calcul_b(x,y): 
    num = 0     
    denomi = 0
    for xi, yi in zip(x,y):
        num += (yi*(xi-x_barre))    
        denomi += (xi*(xi-x_barre))   
    #print(num, denomi)
    return num/denomi   

b = round(calcul_b(x,y),6)
print("b =",b )        

a = round(y_barre - x_barre*b,4) 
print("a =",a)

# a +bM
def f(x):
    return 18.386 +((- 0.005833)*x) 

def S(x,y):
    res = 0
    for xi, yi in zip(x,y):
        res += (yi - f(xi))**2
    return res

#Déviation standard :
print("dérivation standard = ",np.sqrt(S(x,y)/10))