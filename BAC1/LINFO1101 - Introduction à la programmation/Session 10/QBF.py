def moveforward(self,distance) :
    self.addHistory(("forward",distance))
    self.r1.addHistory(("forward",distance))
    self.r2.addHistory(("backward",distance))

def movebackward(self,distance) :
    self.addHistory(("backward",distance))
    self.r1.addHistory(("backward",distance))
    self.r2.addHistory(("forward",distance))

def turnright(self) :
    self.addHistory(("right",90))
    self.r1.addHistory(("right",90))
    self.r2.addHistory(("left",90))

def turnleft(self) :
    self.addHistory(("left",90))
    self.r1.addHistory(("left",90))
    self.r2.addHistory(("right",90))

def __undoAction(self,action) :
        operation = action[0]
        parameter = action[1]
        if operation == "forward" :
            self.movebackward(parameter)
        elif operation == "backward" :
            self.moveforward(parameter)
        elif operation == "right" :
            self.turnleft()
        elif operation == "left" :
            self.turnright()

def unplay(self) :
    history = self.getHistory()
    for i in range(len(history), 0, -1) :
        self.__undoAction(history[i-1])
    self.clearHistory()
    self.r1.clearHistory()
    self.r2.clearHistory()