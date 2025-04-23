public class Matrix {
    public static void main(String[] args) {
        displayMatrix(matrix1(5));
        displayMatrix(matrix2(5));
        displayMatrix(matrix3(7));
        displayMatrix(matrix4(8));
    }

    public static int[][] matrix1(int n){
        int[][]matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col){
                    matrix[row][col]= row+1;
                }
                else if (col > row){
                    matrix[row][col] = 10;
                }else{
                    matrix[row][col] = 20;
                }
            }
        }
        return matrix;
    }

    public static int[][] matrix2(int n){
        int[][]matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col){
                    matrix[row][col]= n - row;
                }
                if (col > row){
                    matrix[row][col]=20;
                }else if (row > col){
                    matrix[row][col]=10;
                }
            }
        }
        return matrix;
    }

    public static int[][] matrix3(int size) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Baris pertama dan kolom pertama
                if (i == 0) {
                    matrix[i][j] = j;  // baris pertama: 0 sampai 6
                } else if (j == 0) {
                    matrix[i][j] = i;  // kolom pertama: 1 sampai 6
                }

                // Kolom terakhir
                if (j == size - 1 && i != 0) {
                    matrix[i][j] = i + j;
                }

                // Baris terakhir
                if (i == size - 1 && j != 0) {
                    matrix[i][j] = i + j;
                }
            }
        }

        return matrix;
    }


    public static int[][] matrix4(int n) {
        int[][] matrix = new int[n][n];
        int total = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int value = i + j;
                matrix[i][j] = value;
                matrix[i][n - 1] += value;     // jumlah baris
                matrix[n - 1][j] += value;     // jumlah kolom
                total += value;                   // total akhir
            }
        }

        matrix[n - 1][n - 1] = total; // pojok kanan bawah (total keseluruhan)

        return matrix;
    }



    public static void displayMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.printf("%3s", matrix[row][col]);
            }
            System.out.println();
        }
    }


}
