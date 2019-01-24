class Solution {
    public double minAreaFreeRect(int[][] points) {
        /*
        1 2
        2 1
        1 0
        0 1
        */

        // for(int i = 0; i < points.length; i++) {
        //     for (int j = 0; j < points[0].length; j++) {
        //         System.out.print(points[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        double area = Double.MAX_VALUE;

        if (points == null) {
            return area;
        }

        Set<String> set = new HashSet<String>();

        for (int[] p : points) {
            set.add(p[0] + "," + p[1]);
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = j +1; k < points.length; k++) {
                    if(i == j || i == k)
                        continue;

                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    // p2 - p1 = a, p3 - p1 = b; a.b = |a||b|cos90 == 0
                    if((p2[0] - p1[0])*(p3[0] - p1[0]) + (p2[1] - p1[1])*(p3[1] - p1[1]) != 0)
                        continue;

                    // x4 = x3 + (x2 - x1)
                    //y4 = y3 + (y2 - y1)
                    int x4 = p3[0] + p2[0] - p1[0];
                    int y4 = p3[1] + p2[1] - p1[1];
                    if(!set.contains(x4 + "," + y4))
                        continue;
                    area = Math.min(area, area(p1, p2, p3));

                }
            }
        }

        return  area == Double.MAX_VALUE ? 0: area;
    }

    public double area(int[] p1, int[] p2, int[] p3) {
        return Math.sqrt(dist(p1, p2) * dist(p1, p3));
    }

    public double dist(int[] p1, int[] p2) {
        return 1.0 * (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
