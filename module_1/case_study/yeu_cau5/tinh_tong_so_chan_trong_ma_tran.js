let m = +prompt("nhập vào kích thước m của ma trận");
let n = +prompt("nhập vào kích thước n của ma trận");
let parentArr = [];
let sum = 0;
for (let i = 0; i < m ; i++) {
    parentArr[i] = [];
    for (let j = 0; j < n ; j++) {
        parentArr[i][j] = +prompt("nhập vào giá trị phần tử của ma trận")
        if (parentArr[i][j]%2===0){
            sum += parentArr[i][j];
        }
    }

}
document.write(sum);