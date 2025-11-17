import common.Range;

void main() {
    String cut = cut("bela string!", new Range(4,10));
    IO.println(cut);
}

String cut(String str, Range range) {
    int max =  range.max() > str.length() - 1 ? str.length() : range.max();
    String newStr = "";
    for(int i = 0; i < str.length(); i++) {
        if(i >= range.min() && i <= max) {
            newStr += "";
        } else {
            newStr += str.charAt(i);
        }
    }
    return newStr;
}


