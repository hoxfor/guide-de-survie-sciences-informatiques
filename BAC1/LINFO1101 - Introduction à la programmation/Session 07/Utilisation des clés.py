def get_country(l, name):
    localized = False
    for i in l:
        if i["City"] == name:
            localized = i["Country"]
            break
    return localized