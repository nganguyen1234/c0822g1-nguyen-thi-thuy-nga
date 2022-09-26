function gradingStudents(grades) {
    let lamTron = (parseInt(grades / 5) + 1) * 5;
    if (grades < 38) {
        return grades;
    } else if (lamTron - grades < 3) {
        return grades = lamTron;
    } else {
        return grades;
    }

}
document.write(gradingStudents(73));