def quetelet(height, weight):
    bmi = weight/height**2
    if bmi < 20:
        return "thin"
    elif bmi >= 20 and bmi <= 25:
        return "normal"
    elif bmi > 25 and bmi <= 30:
        return "overweight"
    else:
        return "obese"