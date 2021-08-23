def translate(data, lan):
    translated = ''
    data = data.lower().split()
    for word in data:
        if word in lan:
            translated += lan[word] + ' '
        else:
            translated += word + ' '
    return translated