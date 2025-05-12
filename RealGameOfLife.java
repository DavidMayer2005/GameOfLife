import java.util.Random;

public class RealGameOfLife {
    public static void main(String[] args) {


        int[][] matrix = new int[10][10];
        int[][] framedMatrix = new int[matrix.length + 2][matrix.length + 2];
        int cellsCounter = 0;
        int changes = 0;

        matrix = fillMatrixWith1Randomly(matrix);
        framedMatrix = frameMatrix(matrix);

        print2DArray(framedMatrix);
        System.out.println();


        while (true) {

            int[][] newMatrix = runTheGame(framedMatrix);

            print2DArray(newMatrix);
            System.out.println();
            System.out.println();

            if (checkForChanges(framedMatrix, newMatrix) == 0) {
                break;
            }
            framedMatrix = copyMatrix(newMatrix);
        }

        print2DArray(framedMatrix);






    }

    static int[][] runTheGame(int[][] framedMatrix) {

        int[][] nextMatrix = new int[framedMatrix.length][framedMatrix.length];
        int cellsCounter = 0;


        for (int i = 1; i < framedMatrix.length-1; i++) {
            for (int j = 1; j < framedMatrix[i].length-1; j++) {

                cellsCounter = countLiveCells(i, j, framedMatrix);

                if(checkForChanges(framedMatrix, nextMatrix)== 0 ) {
                    break;
                }

                else if (framedMatrix[i][j] == 1 && cellsCounter < 2) {// rule number 1.
                    nextMatrix[i][j] = 0;
                }

                else if (framedMatrix[i][j] == 1 && cellsCounter > 3) {// rule number 3.
                    nextMatrix[i][j] = 0;
                }

                else if (framedMatrix[i][j] == 0 && cellsCounter == 3) {// rule number 4.
                    nextMatrix[i][j] = 1;
                }

                else  {// rule number 2.
                    nextMatrix[i][j] = framedMatrix[i][j];
                }

            }
        }
        return nextMatrix;
    }


    static int[][] fillMatrixWith1Randomly(int[][] matrix) {

        Random rand = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = rand.nextInt(2);

            }
        }
    return matrix;

    }

    static int countLiveCells(int i, int j, int[][] matrix) {

        int cellsCounter = 0;
        int [] array = {matrix[i - 1][j],
                        matrix[i + 1][j],
                        matrix[i][j - 1],
                        matrix[i][j + 1],
                        matrix[i - 1][j - 1],
                        matrix[i - 1][j + 1],
                        matrix[i + 1][j - 1],
                        matrix[i + 1][j + 1]
                       };

        for (int k = 0; k < array.length; k++) {
            if(array[k] == 1)
                cellsCounter++;
        }
        return cellsCounter;
    }


    static int checkForChanges(int[][] matrix,int[][] nextMatrix) {

        int changes = 0;

        for (int i = 1; i < matrix.length-1; i++) {
            for (int j = 1; j < matrix[i].length-1; j++) {
                if (matrix[i][j] != nextMatrix[i][j]) {
                    changes++;
                }
            }
        }

        return changes;
    }


    static int[][] frameMatrix(int[][] matrix) {

        int[][] newMatrix = new int[matrix.length + 2][matrix.length + 2];
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows + 2; i++) {
            for (int j = 0; j < columns + 2; j++) {
                if (i == 0 || i == rows + 1 || j == 0 || j == columns + 1)
                    newMatrix[i][j] = 0;
            }
        }
        // copy original matrix to the new matrix.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix[i+1][j+1] = matrix[i][j];
            }
        }
        return newMatrix;
    }




    static void print2DArray(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }

    static int[][] copyMatrix(int[][] matrix) {

        int[][] newMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                newMatrix[i][j] = matrix[i][j];

            }
        }
        return newMatrix;
    }

}
