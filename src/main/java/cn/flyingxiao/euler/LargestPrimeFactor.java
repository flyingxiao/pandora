package cn.flyingxiao.euler;

/**
 * Created by Mtime on 2018/3/27.
 */
public class LargestPrimeFactor {
    public static void main(String[] args) {
//        long test = 600851475143l;
        long test = 100l;
        maxPrimeFactor1(test);
        maxPrimeFactor2(test);
    }

    public static void maxPrimeFactor2(long test) {
        long start = System.currentTimeMillis();

        long d = 2;
        while (test > 1) {
            if (test % d == 0) {
                test /= d;
                d--;
            }
            d++;
        }
        long end = System.currentTimeMillis();
        System.out.println("The answer is [" + d + "], 耗时: [" + (end - start) + "]ms");
    }

    public static void maxPrimeFactor1(long test) {
        long start = System.currentTimeMillis();

        long m1 = (long)Math.sqrt(test);
//        System.out.println(m1);

        long m2 = (long)Math.sqrt(m1);
//        System.out.println(m2);

        long maxprime = 1l;

        for (long i = m1; i > m2; i--) {
            if (isPrime(i) && test % i == 0) {
                maxprime = i;
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("The answer is [" + maxprime + "], 耗时: [" + (end - start) + "]ms");
    }

    private static boolean isPrime(long num) {
        long m1 = (long)Math.sqrt(num);

        for (int i = 2; i <= m1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
