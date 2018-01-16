import javafx.util.Pair;

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A==null || B==null) {
            return new int[0][0];
        }
        /*
        // Naive Way
        int[][] C = new int[A.length][B[0].length];

        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < C[0].length; j++) {
                int sum = 0;

                for(int k = 0; k < A[0].length; k++) {
                    sum += A[i][k]*B[k][j];
                }

                C[i][j] = sum;
            }
        }

        return C;
        */

        /*
        // Better than Naive way
        int[][] D = new int[A.length][B[0].length];

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) {
                    for(int k = 0; k < D[0].length; k++) {
                        D[i][k] += A[i][j]*B[j][k];
                    }
                }

            }
        }

        return D;
        */

        List<List<Pair<Integer, Integer>>> table = new ArrayList<>();
        int[][] E = new int[A.length][B[0].length];

        for(int i = 0; i < A.length; i++) {
            List<Pair<Integer, Integer>> row = new ArrayList<Pair<Integer, Integer>>();

            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) {
                    row.add(new Pair<Integer, Integer>(j, A[i][j]));
                }
            }

            table.add(row);
        }

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < table.get(i).size(); j++ ) {
                int col = table.get(i).get(j).getKey();
                int val = table.get(i).get(j).getValue();

                for(int k = 0; k < B[0].length; k++) {
                    E[i][k] += val * B[col][k];
                }
            }
        }

        return E;


    }
}
