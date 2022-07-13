import java.util.*;


public class Fibonachi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        long ans = modulFibonachi(n, m);
        System.out.println(ans);
    }

    public static int fibonachi(int n) { //  Вычисление числе Фибоначи
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static int nmberFibonachi(int n) { // Вычисление последней цифры числа фибонвчи
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10;
        }
        return arr[n];
    }

    public static long[] periodFib(int m) {
        long[] arr = new long[6 * m];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; ; i++) {
            arr[i] = (arr[i - 1] % m + arr[i - 2] % m) % m;
            if (arr[i] == 1 && arr[i - 1] == 0) {
                arr[arr.length - 1] = i - 1;
                break;
            }
        }
        return arr;
    }

    public static long modulFibonachi(long n, int m) {
        long[] arr = periodFib(m);
        long period = arr[arr.length - 1];
        int i = (int) (n % period);
        return arr[i];

    }
}

