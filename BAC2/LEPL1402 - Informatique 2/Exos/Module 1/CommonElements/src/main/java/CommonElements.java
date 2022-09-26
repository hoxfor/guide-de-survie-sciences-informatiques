public class CommonElements {
    /**
     *
     * @param tab1 is a non null array
     * @param tab2 is a non null array
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {i such that tab1[i] == tab2[i]}
     *         for instance count([1,3,5,5],[1,2,5,5,6]) = 3
     */
    public static int count(int [] tab1, int [] tab2) {
        int counter = 0;
        for (int i = 0; i < tab1.length; i++) {
            try{if (tab1[i] == tab2[i]) ++counter;
            }catch (Exception e){
                return counter;
            }
        }
        return counter;
    }

    /**
     *
     * @param tab1 is a non null 2D array
     * @param tab2 is a non null 2D array
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {(i,j) such that tab1[i][j] == tab2[i][j]}
     */
    public static int Count(int [][] tab1, int [][] tab2) {
        int counter = 0;
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                try{if (tab1[i][j] == tab2[i][j]) ++counter;
                }catch (Exception e){
                    return counter;
                }
            }
        }
         return counter;
    }
}

