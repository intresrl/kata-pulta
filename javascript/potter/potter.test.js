const resolve = require("./potter");


const sapiens = (input, expectedOutput) => {
    expect(resolve(input)+'').toEqual(expectedOutput+ '')
};

describe('Harry Potter bookshop', () => {

    it('Book A costs 8 euros', () => sapiens("A", 8))

    it(`Book F returns 'ERROR'`, () => sapiens("F", 'ERROR'))

})
