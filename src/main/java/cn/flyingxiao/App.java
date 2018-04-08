package cn.flyingxiao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] test = {5, 1, 3, 7, 9, 3, 2, 1, 5, 8, 9, 10, 4, 3, 12};
        select(test);
        for (int e : test) {
            System.out.println(e);
        }
    }

    public static void select(int[] in) {
        int min;
        int l = in.length;
        for (int i = 0; i < l; i++) {
            min = in[i];
            for (int j = i + 1; j < l; j++) {
                if (in[j] < min) {
                    in[i] = in[j];
                    in[j] = min;
                    min = in[i];
                }
            }
        }
    }
}
