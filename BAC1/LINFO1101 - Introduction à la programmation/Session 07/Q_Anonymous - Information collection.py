def collect(filename):
    collected = {}
    with open(filename) as file:
        data = file.read()
    pattern = treatment(extract(data))
    collected[pattern] = 1
    return collected