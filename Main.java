package com.company;

public class Main {

    static final int NB_LINE = 9;
    static final int NB_COLUMN = 9;

    static int[][] currentGrid;


    public static void main(String[] args) {
        int grid[] = {
                0, 1, 0, 6, 0, 7, 0, 0, 4,
                0, 4, 2, 0, 0, 0, 0, 0, 0,
                8, 7, 0, 3, 0, 0, 6, 0, 0,
                0, 8, 0, 0, 7, 0, 0, 2, 0,
                0, 0, 0, 8, 9, 3, 0, 0, 0,
                0, 3, 0, 0, 6, 0, 0, 1, 0,
                0, 0, 8, 0, 0, 6, 0, 4, 5,
                0, 0, 0, 0, 0, 0, 1, 7, 0,
                4, 0, 0, 9, 0, 8, 0, 6, 0
        };
        //display1DGrid(grid);

        int grid2d[][] = parse1DGridTo2DGrid(grid);

        currentGrid = grid2d;

        display2DGrid(currentGrid);

        solve(0, 0);

        display2DGrid(currentGrid);
    }

    /**
     *
     * @param value
     * @param line
     * @return
     */
    public static boolean isInLine(int value, int line) {
        for (int col = 0; col < NB_COLUMN; col++) {
            if (currentGrid[line][col] == value) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param value
     * @param column
     * @return
     */
    public static boolean isInColumn(int value, int column) {
        for (int line = 0; line < NB_LINE; line++) {
            if (currentGrid[line][column] == value) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param value
     * @param line
     * @param column
     * @return
     */
    public static boolean isInSquare(int value, int line, int column) {
        int squareSize = 3;
        int topPosition = (line / squareSize) * squareSize;
        int leftPosition = (column / squareSize) * squareSize;

        for (int l = topPosition; l < topPosition + squareSize; l++) {
            for (int c = leftPosition; c < leftPosition + squareSize; c++) {
                if (currentGrid[l][c] == value) {
                    return true;
                }
            }
        }


        return false;
    }

    public static boolean isPossibleValue(int value, int line, int column) {
        return !isInLine(value, line) &&
                !isInColumn(value, column) &&
                !isInSquare(value, line, column);
    }

    public static boolean solve(int line, int column) {
        int nextLine;
        int nextCol;

        if (column == NB_COLUMN - 1) {
            nextCol = 0;
            nextLine = line + 1;
        } else {
            nextCol = column + 1;
            nextLine = line;
        }

        if (line == NB_LINE) {
            return true;
        }


        if (currentGrid[line][column] != 0) {
            return solve(nextLine, nextCol);
        } else {
            for (int possibleValue = 1; possibleValue < 10; possibleValue++) {
                if (!isPossibleValue(possibleValue, line, column)) {
                    continue;
                }
                currentGrid[line][column] = possibleValue;
                boolean correct = solve(nextLine, nextCol);
                if (correct) {
                    return true;
                }
            }
            currentGrid[line][column] = 0;

            return false;
        }
    }

    /**
     * Transforme un tableau en une dimension en tableau à 2 dimensions.
     * @param grid
     * @return
     */
    public static int[][] parse1DGridTo2DGrid(int[] grid) {
        int[][] grid2D = new int[NB_LINE][NB_COLUMN]; // On initialise un tableau a 2 dimensions de 9 colonnes et 9 lignes
        int current;

        // Parcours des lignes
        for (int line = 0; line < NB_LINE; line++) {
            // Parcours des colonnes
            for (int col = 0; col < NB_COLUMN; col++) {
                // On récupère la valeur courante
                current = grid[col + (line * NB_COLUMN)];
                // On affecte la valeur dans notre tableau à 2 dimensions;
                grid2D[line][col] = current;
            }
        }

        // Retour de la fonction
        return grid2D;
    }

    public static void display1DGrid(int[] grid) {
        int current;


        for (int line = 0; line < 9; line++) {
            if (line == 0 ) {
                System.out.println("-------------");
            }
            for (int col = 0; col < 9; col++) {
                if (col == 0) {
                    System.out.print('|');
                }
                current = grid[col + (line * NB_COLUMN)];
                if (current > 0) {
                    System.out.print(current);
                } else {
                    System.out.print('.');
                }
                if (col == 2 || col == 5 || col == 8) {
                    System.out.print('|');
                }
            }
            System.out.println();

            if (line == 2 || line == 5 || line == 8) {
                System.out.println("-------------");
            }
        }
    }

    public static void display2DGrid(int[][] grid) {
        int current;


        for (int line = 0; line < 9; line++) {
            if (line == 0 ) {
                System.out.println("-------------");
            }
            for (int col = 0; col < 9; col++) {
                if (col == 0) {
                    System.out.print('|');
                }
                current = grid[line][col];
                if (current > 0) {
                    System.out.print(current);
                } else {
                    System.out.print('.');
                }
                if (col == 2 || col == 5 || col == 8) {
                    System.out.print('|');
                }
            }
            System.out.println();

            if (line == 2 || line == 5 || line == 8) {
                System.out.println("-------------");
            }
        }
    }
}
