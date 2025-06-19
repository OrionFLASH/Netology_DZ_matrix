import java.util.Random;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];
        fillRandom(colors);

        System.out.println("Исходная матрица:");
        printMatrix(colors);

        int[][] rotatedColors = rotateMatrix90(colors);

        System.out.println("Повернутая матрица:");
        printMatrix(rotatedColors);
    }

    // Заполнение матрицы
    private static void fillRandom(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextInt(256);
            }
        }
    }

    // Поворот
    private static int[][] rotateMatrix90(int[][] matrix) {
        int[][] result = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[j][SIZE - 1 - i] = matrix[i][j];
            }
        }
        return result;
    }

    // вывод матрицы
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
