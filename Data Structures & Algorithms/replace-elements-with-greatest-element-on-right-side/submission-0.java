class Solution {
    public int[] replaceElements(int[] arr) {
        int [] ar = new int[arr.length];
        int rigMax = -1;
        for ( int i = arr.length -1 ; i >= 0 ; i--){
            ar[i] =  rigMax;
            rigMax = Math.max(rigMax , arr[i]);
        }
        return ar;
    }
}
