import { generateRandomArray } from '../src/utils';
import { expect } from 'chai';

describe('Utils', () => {
    describe('#generateRandomArray', () => {
        it('should generate a array with random integers', () => {
            let a = generateRandomArray(10, 2, 13);
            a.forEach((p) => {
                expect(p).to.be.a('number');
                expect(p<=13).to.equal(true);
                expect(p>=2).to.equal(true);
            });
            
            expect(a.length).to.equal(10);
        });
    });
});
