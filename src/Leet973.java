public class Leet973 {
    public int[][]  kClosest(int[][] points, int K) {
        int start=0, end=points.length-1;
        while(start < end) {
            int pivot = partition(points, start, end);
            if(pivot > (K-1)) {
                end = pivot-1;
            }
            else if(pivot < (K-1)) {
                start = pivot+1;
            }
            else {
                break; //found the Kth largest index
            }
        }

        int[][] result = new int[K][2];
        for(int i=0; i < K; i++) {
            result[i] = new int[]{points[i][0], points[i][1]};
        }
        return result;
    }

    private int partition(int[][] points, int start, int end) {
        int pivot = start;
        while(start <= end) {
            while(start <= end && calcDist(points[start]) <= calcDist(points[pivot])) start++;
            while(start <= end && calcDist(points[end]) > calcDist(points[pivot])) end--;
            if(start <= end) {
                swap(points, start, end);
                start++;
                end--;
            }
        }
        swap(points, end, pivot);
        return end;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[j];
        points[j] = points[i];
        points[i] = temp;
    }

    private int calcDist(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
