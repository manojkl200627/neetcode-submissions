public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int L = 0, R = points.length - 1;
        int pivot = points.length;

        while (pivot != k) {
            pivot = partition(points, L, R);
            if (pivot < k) {
                L = pivot + 1;
            } else {
                R = pivot - 1;
            }
        }
        int[][] res = new int[k][2];
        System.arraycopy(points, 0, res, 0, k);
        return res;
    }

    private int partition(int[][] points, int l, int r) {
        int pivotIdx = r;
        int pivotDist = euclidean(points[pivotIdx]);
        int i = l;
        for (int j = l; j < r; j++) {
            if (euclidean(points[j]) <= pivotDist) {
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
            }
        }
        int[] temp = points[i];
        points[i] = points[r];
        points[r] = temp;
        return i;
    }

    private int euclidean(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}





















