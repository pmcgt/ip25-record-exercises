import common.Position;

void main() {
    int[][] array = {{1,2,3},{4,5,4},{3,2,1}};
    IO.println(findFirst(array, 3));
    IO.println(findLast(array, 3));
    IO.println(count(array, 3));
    IO.println(Arrays.toString(findAll(array, 3)));
}

Position findFirst(int[][] array, int value) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            if(array[i][j] == value) {
                return new Position(i,j);
            }
        }
    }
    return null;
}

Position findLast(int[][] array, int value) {
    for (int i = array.length - 1; i>=  0; i--) {
        for (int j = array[i].length -1; j >= 0 ; j--) {
            if(array[i][j] == value) {
                return new Position(i,j);
            }
        }
    }
    return null;
}

int count(int[][] array, int value) {
    int count = 0;
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            if(array[i][j] == value) {
                count++;
            }
        }
    }
    return count;
}

Position[] findAll(int[][] array, int value) {
    Position[] positions = new Position[count(array, value)];
    for (int i = 0, idx = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            if(array[i][j] == value) {
               positions[idx] = new Position(i,j);
               idx++;
            }
        }
    }
    return positions;
}
