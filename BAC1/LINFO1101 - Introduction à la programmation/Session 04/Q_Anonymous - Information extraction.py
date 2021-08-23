def extract(code):
    extracted = ""
    for carac in code:
        try:
            carac = int(carac)
        except:
            pass
        ctype = type(carac)
        if ctype is int:
            extracted += "number "
        elif ctype is str:
            vowel = ["a", "e", "i", "o", "u", "y"]
            if carac.lower() in vowel:
                add = "vowel"
            else:
                add = "consonant"
            if carac.isupper():
                add += "-up "
            else:
                add += "-low "
            extracted += add
    return extracted