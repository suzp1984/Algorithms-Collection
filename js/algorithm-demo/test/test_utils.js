import { generateRandomArray, copyArray } from '../src/utils';
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

    describe('#copyArray', () => {
        it('copy array', () => {
            let a = [1, 2, 3];
            let b = copyArray(a);

            expect(b).to.be.a('array');
            expect(b.length).to.equal(a.length);

            b.forEach((x, i) => {
                expect(x).to.equal(a[i]);
            });

            a[0] = 22;
            expect(b[0]).to.equal(1);
            expect(a[0]).to.equal(22);

        });
    });
});
