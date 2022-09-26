function chuanHoa(str) {
    // let alphabetStr = "ABCDEFGHIJKLNMOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    let str1 = str.toLowerCase();
    let array1 = str1.split(" ");
    let newArray = [];
    for (let i = 0; i < array1.length; i++) {
        if (array1[i] !== "") {
            newArray.push(array1[i].split(""));
        }

    }
    console.log(newArray)
    for (let i = 0; i < newArray.length; i++) {
        newArray[i][0] = newArray[i][0].toUpperCase();
        newArray[i] = newArray[i].join("");
    }
    return newArray.join(" ");
}

function findLongestWord(str) {
    let wordArr = str.split(" ");
    let index = 0;
    let max = wordArr[0].length;
    for (let i = 0; i < wordArr.l; i++) {
        if (wordArr[i].length > max) {
            max = wordArr[i].length;
            index = i;
        }
    }
    return wordArr[index];
}


function display(str) {
    document.write("xâu trước khi chuẩn hóa là: " + str + "<br>")
    let result = chuanHoa(str);
    document.write("xâu sau khi chuẩn hóa là: " + result + "<br>");
    let longestWord = findLongestWord(result);
    document.write("từ dài nhất trong xâu là: " + longestWord);
}

let str1 = "   tRuong    TaN   HAI    ";
display(str1);