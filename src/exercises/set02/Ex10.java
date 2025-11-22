import common.Position;

void main() {
    startTicTacToe();
}

void startTicTacToe() {
    int[][] gameboard = new int[3][3];
    boolean isPlayersTurn = true;
    boolean isPlayerEligibleForARetry = false;
    Position[] lastPositions = new Position[2];

    while (isGameOngoing(gameboard)) {
        printBoard(gameboard);

        if(isPlayersTurn && isPlayerEligibleForARetry) {
            boolean doesPlayerWantToUndoPreviousChoice = getPlayerUndoChoice();
            if(doesPlayerWantToUndoPreviousChoice) {
                resetBoardToPreviousState(gameboard, lastPositions);
                isPlayerEligibleForARetry = false;
                continue;
            }
        }

        updateBoard(gameboard, lastPositions, isPlayersTurn);
        isPlayersTurn = !isPlayersTurn;
        isPlayerEligibleForARetry = true;
    }

    printBoard(gameboard);
    printResult(getWinner(gameboard));
}


private void resetBoardToPreviousState(int[][] gameboard, Position[] lastPositions) {
    for (int i = 0; i < lastPositions.length; i++) {
        gameboard[lastPositions[i].row()][lastPositions[i].column()] = 0;
    }
}

private boolean getPlayerUndoChoice() {
    String response = IO.readln("Do you wish to undo previous choice? (y/n)  ");
    return response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes");
}

void updateBoard(int[][] gameboard, Position[] lastPositions, boolean isPlayersTurn) {
    int playingNumber = isPlayersTurn ? 1 : 2;
    Position chosenPosition;
    if(isPlayersTurn)  {
        chosenPosition = getPlayerChoice(gameboard);
        lastPositions[0] = chosenPosition;
    } else {
        chosenPosition = getComputerChoice(gameboard);
        lastPositions[1] = chosenPosition;
    }

    gameboard[chosenPosition.row()][chosenPosition.column()] = playingNumber;
}

Position getComputerChoice(int[][] gameboard) {
    int row;
    int column;
    do {
        row = (int) (Math.random() * 3);
        column = (int) (Math.random() * 3);
    } while(gameboard[row][column] != 0);

    return new Position(row, column);
}


Position getPlayerChoice(int[][] gameboard) {
    String rowResponse = IO.readln("X linha: ");
    String columnResponse = IO.readln("X coluna: ");

    int row = Integer.parseInt(rowResponse);
    int column = Integer.parseInt(columnResponse);

    while (!isPlayerChoiceValid(gameboard, row, column)) {
        IO.println("That spot is already taken or invalid position, try again");
        rowResponse = IO.readln("X linha: ");
        columnResponse = IO.readln("X coluna: ");

        row = Integer.parseInt(rowResponse);
        column = Integer.parseInt(columnResponse);
    }
    return new Position(row, column);
}

boolean isPlayerChoiceValid(int[][] gameboard, int row, int column) {
    return row < gameboard.length && column < gameboard[0].length && gameboard[row][column] == 0;
}

boolean isGameOngoing(int[][] gameboard) {
    return !isGameFinished(gameboard) && !isBoardFull(gameboard);
}

boolean isGameFinished(int[][] gameboard) {
    return getWinner(gameboard) != 0;
}

int getWinner(int[][] gameboard) {
    for (int i = 0; i < 3; i++) {
        // horizontal check
        if (gameboard[i][0] != 0 && gameboard[i][0] == gameboard[i][1] && gameboard[i][1] == gameboard[i][2]) {
            return gameboard[i][0];
        }

        // vertical check
        if (gameboard[0][i] != 0 && gameboard[0][i] == gameboard[1][i] && gameboard[1][i] == gameboard[2][i]) {
            return gameboard[0][i];
        }

        // diagonal check
        if (i != 1 && gameboard[1][1] != 0 &&
                gameboard[0][i] == gameboard[1][1] && gameboard[1][1] == gameboard[2][2 - i]) {
            return gameboard[1][1];
        }
    }

    return 0;
}


boolean isBoardFull(int[][] gameboard) {
    for (int i = 0; i < gameboard.length; i++) {
        for (int j = 0; j < gameboard[i].length; j++) {
            if (gameboard[i][j] == 0) {
                return false;
            }
        }
    }
    return true;
}

void printBoard(int[][] gameboard) {
    for (int i = 0; i < gameboard.length; i++) {
        IO.println(i == 0 ? "" : "-----------");
        for (int j = 0; j < gameboard[i].length; j++) {
            String playingSymbol = "   ";
            IO.print(j == 0 ? "" : "|");
            if (gameboard[i][j] == 1) {
                playingSymbol = " X ";
            }
            if (gameboard[i][j] == 2) {
                playingSymbol = " O ";
            }
            IO.print(playingSymbol);
        }
        IO.println();
    }
    IO.println();
}

private void printResult(int gameWinner) {
    if(gameWinner == 0) {
        IO.println("It's a tie, thanks for playing!");
    } else if(gameWinner == 1) {
        IO.println("Congratulations you won!");
    } else {
        IO.println("You lost, better luck next time!");
    }
}



