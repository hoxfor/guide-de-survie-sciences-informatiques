def create_dictionary(filename):
    d = {}
    data = []
    with open(filename) as file:
        for line in file.readlines():
            line = line.strip().split()
            for word in line:
                data.append(word)
    for word in data:
        if word in d:
            d[word] += 1
        else:
            d[word] = 1
    return d

def occ(dictionary, word):
    try:
        return dictionary[word]
    except KeyError:
        return 0