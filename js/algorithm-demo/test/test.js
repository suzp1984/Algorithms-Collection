import { equal } from 'assert';
import {expect} from 'chai';

describe('Array', function() {
    describe('#indexOf()', function() {
        it('should return -1 when the value is not present', function() {
            equal(-1, [1, 2, 3].indexOf(4));
        });
    });
});

describe('Array', function() {
    describe('#indexOf()', function() {
        it('should return index when the value is present', function() {
            expect([1, 2, 3].indexOf(1)).to.equal(0);
        });
    });
});
