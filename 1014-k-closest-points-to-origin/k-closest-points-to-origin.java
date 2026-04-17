class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Sort points by squared distance to origin
        Arrays.sort(points, (a, b) -> 
            (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])
        );
        
        // Copy first k points
        return Arrays.copyOfRange(points, 0, k);
    }
}
