let arr1 = [7, 2, 5, 3, 5, 3];
let arr2 = [3, 3, 3, 7, 7, 2, 5, 4, 6, 3, 5, 3, 8];
for (let i = 0; i < arr2.length; i++) {
    for (let j = 0; j < arr1.length; j++) {
        if (arr2[i] === arr1[j]) {
            arr2.splice(i, 1);
            i--;
        }
    }
}
document.write(arr2);

