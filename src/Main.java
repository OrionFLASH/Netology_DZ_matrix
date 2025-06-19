import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;
    public static final int COLOR_COUNT = 256;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];
        fillRandom(colors);

        System.out.println("Исходная матрица:");
        printMatrix(colors);

        int angle = readAngle();


        int[][] rotated = rotateMatrix(colors, angle);
        System.out.println("Повернутая матрица на " + angle + " градусов:");
        printMatrix(rotated);

    }

    // Заполнение матрицы
    private static void fillRandom(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextInt(COLOR_COUNT);
            }
        }
    }

    // Ввод угла
    private static int readAngle() {
        Scanner scanner = new Scanner(System.in);
        int angle = 0;
        boolean correct = false;
        while (!correct) {
            System.out.print("Введите угол поворота (90, 180 или 270): ");
            if (scanner.hasNextInt()) {
                angle = scanner.nextInt();
                if (angle == 90 || angle == 180 || angle == 270) {
                    correct = true;
                } else {
                    System.out.println("Ошибка: только 90, 180 или 270.");
                }
            } else {
                System.out.println("Ошибка: введите число.");
                scanner.next(); // Очистить неверный ввод
            }
        }
        return angle;
    }

    // целый поворот
    private static int[][] rotateMatrix(int[][] matrix, int angle) {
        int[][] result = matrix;
        int turns = angle / 90;
        for (int t = 0; t < turns; t++) {
            result = rotateMatrix90(result);
        }
        return result;
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
