import common.Range;

void main() {
    Range g = new Range(5,10);
    print(g);
    IO.println();
    printReverse(g);
    IO.println();
}

void print(Range g) {
    for(int i = g.min(); i <= g.max(); i++) {
        IO.print(i + " ");
    }
}

void printReverse(Range g) {
    for(int i = g.max(); i >= g.min(); i--) {
        IO.print(i + " ");
    }
}