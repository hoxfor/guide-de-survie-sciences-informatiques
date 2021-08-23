def translate(data):
    code = ""
    for carac in data:
        if carac in morse:
            code += morse[carac]
        else:
            raise TypeError
    return code