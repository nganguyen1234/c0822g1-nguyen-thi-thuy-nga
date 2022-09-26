function findMinIn2DArr(arr) {
    let min = arr[0][0];
    for (let i = 0; i < arr.length ; i++) {
        for (let j = 0; j < arr[i].length ; j++) {
            if (min > arr[i][j]){
                min = arr[i][j];
            }
        }
    } return min;
}
function findMaxIn2DArr(arr) {
    let max = arr[0][0];
    for (let i = 0; i < arr.length ; i++) {
        for (let j = 0; j < arr[i].length ; j++) {
            if (max < arr[i][j]){
                max = arr[i][j];
            }
        }
    } return max;
}

let arr2 = [
    [1, 2, 4, 6],
    [3, 5, 7, 9],
    [11, 33, 12, 7]
]
let min = findMinIn2DArr(arr2);
let max = findMaxIn2DArr(arr2);
document.write("giá trị lớn nhất trong mảng là: "+ max+ ", giá trị nhỏ nhất trong mảng là: "+ min)