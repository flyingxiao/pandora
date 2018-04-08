package cn.flyingxiao;

/**
 * Created by flyingxiao on 2018/3/22.
 */
public class Sort {

    public static void main(String[] args) {
        int len = 5000000;
        int[] input = new int[len];
        for (int i = 0; i < len; i++) {
            input[i] = (int) (Math.random() * 1000000);
        }

        //        shellsort(input);

        long start1 = System.currentTimeMillis();
        mergemain(input);
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

//        long start2 = System.currentTimeMillis();
//        quicksortmain(input);
//        long end2 = System.currentTimeMillis();
//        System.out.println(end2 - start2);
//        show(input);
    }

    public static void show(int[] a) {
        int i = 0;
        for (int t : a) {
            System.out.println(a[i++]);
        }
    }

    public static void shellsort(int[] a){
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for(int i=h;i<len;i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void popsort(int[] a) {
        int len = a.length;
        for(int i=0;i<len-1;i++) {
            for(int j=1;j<len;j++) {
                if(a[j] < a[j-1]){
                    exch(a,j,j-1);
                }
            }
        }
    }


    /**
     *将元素交换位置
     * @param a
     * @param i
     * @param j
     */
    public static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    ////快速排序  START
    public static void quicksortmain(int[] a) {
        recursivequick(a, 0, a.length - 1);
    }

    public static void recursivequick(int[] a, int start, int end) {
        if (start < end) {
            int j = quicksort(a, start, end);
            recursivequick(a, start, j - 1);
            recursivequick(a, j + 1, end);
        }
    }

    public static int quicksort(int[] a, int start, int end) {
        int i = start, j = end;
        int x = a[i];
        int ret = 0;
        while (i < j) {
            while(a[j] > x && i < j) {
                j--;
            }
            if (a[j] <= x) {
                a[i] = a[j];
                ret = j;
            }

            while (a[i] <= x && i < j) {
                i++;
            }
            if (a[i] > x) {
                a[j] = a[i];
                ret = i;
            }
        }
        a[ret] = x;
        return ret;
    }
    ////快速排序  END

    ////归并排序  START
    public static void mergemain(int[] a) {
        int[] c = new int[a.length];
        recursivemerge(a, 0, a.length - 1, c);
    }

    public static void recursivemerge(int[] a, int start, int end, int[] c) {
        if (start < end) {
            int mid = (start + end) / 2;
            recursivemerge(a, start, mid, c);
            recursivemerge(a, mid + 1, end, c);
            mergesort(a, start, mid, end, c);
        }
    }

    public static void mergesort(int[] a, int start, int mid, int end, int[] c) {
//        System.out.println(start + " : " + mid + " : " + end);
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[j++];
            }
        }
        while (i <= mid) {
            c[k++] = a[i++];
        }
        while (j <= end) {
            c[k++] = a[j++];
        }

        for (int l = start; l <= end; l++) {
            a[l] = c[l];
        }
    }

    ////归并排序  END

}
