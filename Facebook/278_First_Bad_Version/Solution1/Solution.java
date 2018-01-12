/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n < 1) {
            return 0;
        }

        return binarySearch(1, n);
    }

    public int binarySearch(int l, int r) {
        int mid = (l + r) >>> 1;

        if(isBadVersion(mid)) {
            // is Bad, left
            if(!isBadVersion(mid - 1)) {
                return mid;
            } else {
                return binarySearch(l, mid);
            }
        } else {
            if(isBadVersion(mid + 1)) {
                return mid + 1;
            } else {
                return binarySearch(mid + 1, r);
            }
        }
    }
}
