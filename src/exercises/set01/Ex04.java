import common.Range;

void main() {
    Range f = findFirst("sei", "só sei que nada sei");
    IO.println(f);
}

Range findFirst(String word, String text) {
    int start = text.indexOf(word);
    if(start == -1) {
        return null;
    }
    return new Range(start, start + word.length() -1);
}



