function findCommonCharacter(str1, str2) {
    let arr1 = str1.split("");
    let arr2 = str2.split("");
    let count = 0;
    for (let i = 0; i < str1.length; i++) {
        for (let j = 0; j < str2.length; j++) {
            if (arr1[i] === arr2[j]) {
                count++;
                arr2.splice(j, 1);
                j--;
                break;
            }
        }
    }
    return count;
}

let s1 = "aabcc";
let s2 = "adcaa";
document.write(findCommonCharacter(s1, s2));