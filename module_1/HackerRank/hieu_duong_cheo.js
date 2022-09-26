
function diagonalDifference(arr) {
    for (let i = 0; i < arr.length ; i++) {
        if(arr[i].length< arr.length){
            arr.splice(i,1);
            i--;
        }
    }
    let sum1 = 0;
    let sum2 = 0;
    for (let i = 0; i < arr.length ; i++) {
        sum1 += arr[i][i];
        sum2 += arr[arr.length-1-i][i]
    }
    return Math.abs(sum1 - sum2);
}
let array = [[3],[11,2,4],[4,5,6],[10,8,-12]];
document.write(diagonalDifference(array))