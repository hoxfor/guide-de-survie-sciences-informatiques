import java.util.Arrays;

public class Convolution  {

    /**
     *
     * @param input is a n1 x m1 non-null rectangular matrix with at least 3 rows and 3 cols
     * @param kernel is a 3 x 3 square matrix
     * @return a matrix M with dimension (n1-2) x (m1-2) with
     *         M[i][j] = sum_{k in 0..2, l in 0..2} input[i+k][j+l]*kernel[k][l]
     */

    //M[i][j] = sum_{k in 0..2, l in 0..2} input[i+k][j+l]*kernel[k][l]
    public static int [][] convolution(int [][] input, int [][] kernel) {
        int[][] M = new int[input.length-2][input[0].length-2];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        
                        sum += input[i+k][j+l]*kernel[k][l];
                        
                    }
                }
                M[i][j] = sum;
            }
        }
        return M;
    }

    public static void main(String[] a) {
        System.out.println("fromage");

        int[] array = new int[]{1,2,3};
        foo(array);
        System.out.println(Arrays.toString(array));

    }


    public static void foo(int[] a){
        a = new int[]{4,5,6};
    }

}
