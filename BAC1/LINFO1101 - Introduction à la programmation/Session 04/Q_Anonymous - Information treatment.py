def treatment(data):
    count = 0
    previous_element = None
    extract = ""
    to_add = ["number", "vowel-up", "vowel-low", "consonant-up", "consonant-low"]
    data = data.split()
    data.append("stop") # stop is ignored in extract
    for element in data:
        if previous_element is not None:
            if element == previous_element:
                count += 1
            else:
                extract += previous_element+"*"+str(count)+" "
                previous_element = element
                count = 1
        else:
            previous_element = element
            count = 1
    return extract[:-1]