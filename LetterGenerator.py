import random


class LetterGenerator:

    letterPool = []
    cpuLetters = []
    playerLetters = []

    def __init__(self):
        self.letterPool = self.generatePool()

    def generatePool(self):  # function that returns a pool of 99 letters according to standard scrabble rules
        for i in range(12):
            self.letterPool.append('e')
        for i in range(9):
            self.letterPool.append('a')
            self.letterPool.append('i')
            self.letterPool.append('o')
        for i in range(6):
            self.letterPool.append('n')
            self.letterPool.append('r')
            self.letterPool.append('t')
        for i in range(4):
            self.letterPool.append('l')
            self.letterPool.append('s')
            self.letterPool.append('u')
            self.letterPool.append('d')
        for i in range(3):
            self.letterPool.append('g')
        for i in range(2):
            self.letterPool.append('b')
            self.letterPool.append('c')
            self.letterPool.append('m')
            self.letterPool.append('p')
            self.letterPool.append('f')
            self.letterPool.append('h')
            self.letterPool.append('v')
            self.letterPool.append('w')
            self.letterPool.append('y')
        for i in range(1):
            self.letterPool.append('k')
            self.letterPool.append('j')
            self.letterPool.append('x')
            self.letterPool.append('q')
            self.letterPool.append('z')
        return self.letterPool

    def generateCpu(self):  # function that returns computer's 7 letters and removes them from letter pool
        for i in range(7):
            rand = random.randint(0, len(self.letterPool)-1)
            self.cpuLetters.append(self.letterPool[rand])
            del self.letterPool[rand]
        return self.cpuLetters

    def generatePlayer(self):  # function that returns player's 7 letters and removes them from letter pool
        for i in range(7):
            rand = random.randint(0, len(self.letterPool)-1)
            self.playerLetters.append(self.letterPool[rand])
            del self.letterPool[rand]
        return self.playerLetters

    def giveCpuLetter(self, numberOfLetters): # function that gives computer letters to get back to 7 after turn
        for i in range(numberOfLetters):
            rand = random.randint(0, len(self.letterPool)-1)
            self.cpuLetters.append(self.letterPool[rand])
            del self.letterPool[rand]
        return self.cpuLetters

    def givePlayerLetter(self, numberOfLetters): # function that gives player letters to get back to 7 after turn
        for i in range(numberOfLetters):
            rand = random.randint(0, len(self.letterPool)-1)
            self.playerLetters.append(self.letterPool[rand])
            del self.letterPool[rand]
        return self.playerLetters
