switch (prompt("nhap ký tự")) {
    case 'a':
    case 'i':
    case 'e':
    case 'u':
    case 'o':
    case 'A':
    case 'E':
    case 'I':
    case 'O':
    case 'U':
        text = "ký tự là nguyên âm";
        break;
    default:
        text = "ký tự là phụ âm";

}
document.write(text);