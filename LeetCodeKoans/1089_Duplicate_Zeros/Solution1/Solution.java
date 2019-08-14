class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                q.add(arr[i]);
                q.add(0);
            } else {
                q.add(arr[i]);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = q.poll();
        } 
    }
}