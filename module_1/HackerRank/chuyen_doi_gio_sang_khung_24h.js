//time = "hh:mm:ssAM"


function convert(s) {
    let time1 = s.split("");
    if (time1[8] === "A") {
        if (time1[0] == 1 && time1[1] == 2) {
            time1.splice(0, 2, 0, 0)
        }
        time1.splice(8, 2);

    }
    if (s[8] === "P") {
        if (time1[0] == 0 && time1[1] <= 9) {
            let temp = parseFloat(time1[1]) + 12;
            time1.splice(0, 2, temp);
        }
        if (time1[0] == 1 && time1[1] <= 1) {
            let temp = parseFloat(time1[1]) + 22;
            time1.splice(0, 2, temp);
        }
        time1.splice(7, 2);
        if(time1[0] == 1 && time1[1] == 2){
            time1.splice(8,2);
        }
    }

    alert(time1.join(''));
}

let a = prompt("nhập giờ theo format hh:mm:ssAM");
convert(a);