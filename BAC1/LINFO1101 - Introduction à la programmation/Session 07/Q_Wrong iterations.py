class EvenCounter:
    def __init__(self, matrix):
        self.matrix = matrix
        self.max = len(matrix) - 1
        self.index = 0
        self.sub_max = len(matrix[self.index]) - 1
        self.sub_index = 0
    def __iter__(self):
        return self
    def __next__(self):
        self.elem = self.matrix[self.index][self.sub_index]
        self.found = 0
        if self.elem % 2 == 0:
            self.found = self.elem
        if self.sub_index < self.sub_max:
            self.sub_index += 1
        else:
            self.sub_index = 0
            self.index += 1
            if self.index > self.max:
                raise StopIteration
            else:
                self.sub_max = len(matrix[self.index]) - 1
        return self.found
    def calc_last(self):
        self.elem = self.matrix[-1][-1]
        self.found = 0
        if self.elem % 2 == 0:
            self.found = self.elem
        return self.found
        

sum_even = 0
count = EvenCounter(matrix)
try:
    while True:
        sum_even += next(count)
except StopIteration:
    sum_even += count.calc_last()