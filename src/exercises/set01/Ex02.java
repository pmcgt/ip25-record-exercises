import common.Range;

void main() {
    int[] nats = naturals(new Range(2,8));
    IO.println(Arrays.toString(nats));
}


int[] naturals(Range r) {
    int[] array = new int[r.max() - r.min() + 1];
    for(int i = 0; i < array.length; i++) {
        array[i] = r.min() + i;
    }
    return array;
}