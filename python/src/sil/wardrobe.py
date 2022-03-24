import itertools
from itertools import chain, combinations, combinations_with_replacement

class wardrobElement(object):
    def __init__(self,eleDim,elePrice):
        self.eleDim=eleDim
        self.elePrice=elePrice

    @property
    def getEleDimProp(self):
        return self.eleDim
    @property
    def getElePriceProp(self):
        return self.elePrice

wardrobeElementsArray = []

wardrobeElementsArray.append(wardrobElement(50, 59))
wardrobeElementsArray.append(wardrobElement(75, 62))
wardrobeElementsArray.append(wardrobElement(100, 90))
wardrobeElementsArray.append(wardrobElement(120, 111))


class WardrobeCalculator:

    def spaceSaver(self):
        eleCombinations=[]
        for n in range(len(wardrobeElementsArray) + 1):
            combinationsObj=list(combinations(map(lambda o: o.getEleDimProp, wardrobeElementsArray), n))
            for i in combinationsObj:
                combinationWithReplacementList=list(combinations_with_replacement(i,len(i)))
                eleCombinations+=filter(lambda o: sum(o)==250,combinationWithReplacementList)
        return eleCombinations
    def moneySaver(self,eleCombinations):
        max=999999
        for combination in eleCombinations:
            combinationPrice=sum(map(lambda o: self.getPriceFromDim(o),combination))
            if(combinationPrice<=max):
                max=combinationPrice
                bestCombination=combination
        return bestCombination

    def getPriceFromDim(self,dim):
        if dim==50: return 59
        if dim==75: return 62
        if dim==100: return 90
        if dim==120: return 111
        else: return 0

x=WardrobeCalculator()
perfectFitCombinations=x.spaceSaver()
bestCombination=x.moneySaver(perfectFitCombinations)
print('fitting combination', perfectFitCombinations)
print('winning combination', bestCombination)

