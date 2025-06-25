class Solution {

    public static void main(String[] args) {
        int[] nums1 = {-2, -1, 0, 1, 2};
        int[] nums2 = {-3, -1, 2, 4, 5};
        int k = 3;

        long result = new Solution().kthSmallestProduct(nums1, nums2, k);
        System.out.println("Kth smallest product is: " + result);
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L, right = 10000000000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countPairs(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private long countPairs(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a == 0) {
                if (x >= 0) count += nums2.length;
            } else if (a > 0) {
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) a * nums2[m] <= x) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                count += l;
            } else { // a < 0
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) a * nums2[m] <= x) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                count += nums2.length - l;
            }
        }
        return count;
    }
}