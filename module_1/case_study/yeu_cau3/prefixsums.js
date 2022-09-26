let array = [1,2,3];
let sum = 0;
let newArray = [];
for (let i = 0; i < array.length; i++) {
    sum += array[i];
    newArray.push(sum);
}

document.write(newArray);