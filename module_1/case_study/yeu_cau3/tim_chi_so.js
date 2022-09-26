let numerators = [3, 2, 1];
let denominators = [1, 2, 3];
let max = numerators[0] / denominators [0];
let index = 0;
for (let i = 1; i < numerators.length; i++) {
    if (numerators[i] / denominators[i] > max) {
        index = i;
        max = numerators[i] / denominators[i];
    }
}
console.log(index)