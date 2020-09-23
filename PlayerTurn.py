import enchant
import itertools
from GameRules import *


class PlayerTurn:

    points = GameRules()
    dictionary = enchant.Dict("en_US")
    iterations = []

    def playPlayer(self, playerLetters, playerInput):
        playerWord = self.verifyWord(playerLetters, playerInput)
        playerTurn = self.scoreWord(playerWord)
        return playerTurn

    def verifyWord(self, playerLetters, playerInput):  # take player letters and player word and determine if input is valid
        playerLetterIterations = []
        playerWordIterations = []
        for i in range(3, 8):
            for subset in itertools.permutations(playerLetters, i):
                if subset not in playerLetterIterations:
                    playerLetterIterations.append(subset)
            for iteration in playerLetterIterations:
                iteration = "".join(iteration)
                playerWordIterations.append(iteration)
        if playerInput in playerWordIterations:
            if self.dictionary.check(playerInput):
                return playerInput
            else:
                print "Player input not a word in the US dictionary"
                return 0
        else:
            print "Player input not a combination of player letters"
            return 0

    def scoreWord(self, playerWord):  # determine score of player word
        score = 0
        for letter in self.points.onePointLetters:
            score = score + (playerWord.count(letter) * 1)
        for letter in self.points.twoPointLetters:
            score = score + (playerWord.count(letter) * 2)
        for letter in self.points.threePointLetters:
            score = score + (playerWord.count(letter) * 3)
        for letter in self.points.fourPointLetters:
            score = score + (playerWord.count(letter) * 4)
        for letter in self.points.fivePointLetters:
            score = score + (playerWord.count(letter) * 5)
        for letter in self.points.eightPointLetters:
            score = score + (playerWord.count(letter) * 8)
        for letter in self.points.tenPointLetters:
            score = score + (playerWord.count(letter) * 10)
        return playerWord, score
