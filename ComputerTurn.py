import itertools
import enchant
from GameRules import *

class ComputerTurn:

    points = GameRules()
    possibleWords = []
    wordStringList = []
    wordList = []
    dictionary = enchant.Dict("en_US")
    scoreList = []
    cpuTurnPoints = 0

    def playCpu(self, letters):
        self.possibleWords = self.createWords(letters)
        self.wordStringList = self.filterWords(self.possibleWords)
        self.wordList = self.checkWords(self.wordStringList)
        self.cpuTurnPoints = self.compareWords(self.wordList)
        return self.cpuTurnPoints

    def createWords(self, lettersInPlay):  # create all permutations of 3 to seven letters that the cpu has been given
        for i in range(3, 8):
            for subset in itertools.permutations(lettersInPlay, i):
                if subset not in self.possibleWords:
                    self.possibleWords.append(subset)
        return self.possibleWords

    def filterWords(self, possibleWordList):  # filter out any permutation that does not have a vowel
        for possibleWord in possibleWordList:
            possibleWord = ''.join(possibleWord)
            self.wordStringList.append(possibleWord)
        for string in self.wordStringList:
            if any(v in string for v in 'aeiou') == False:
                self.wordStringList.remove(string)
        return self.wordStringList

    def checkWords(self, listOfPossibleWords):  # check possible word strings against dictionary and output valid words
        for possibleWord in listOfPossibleWords:
            if self.dictionary.check(possibleWord):
                self.wordList.append(possibleWord)
        return self.wordList

    def compareWords(self, wordList):
        for word in wordList:
            score = 0
            for letter in self.points.onePointLetters:
                score = score + (word.count(letter)*1)
            for letter in self.points.twoPointLetters:
                score = score + (word.count(letter)*2)
            for letter in self.points.threePointLetters:
                score = score + (word.count(letter)*3)
            for letter in self.points.fourPointLetters:
                score = score + (word.count(letter)*4)
            for letter in self.points.fivePointLetters:
                score = score + (word.count(letter)*5)
            for letter in self.points.eightPointLetters:
                score = score + (word.count(letter)*8)
            for letter in self.points.tenPointLetters:
                score = score + (word.count(letter)*10)
            self.scoreList.append(score)
        return self.wordList[self.scoreList.index(max(self.scoreList))], max(self.scoreList)  # return tuple of word with maximum score and score
