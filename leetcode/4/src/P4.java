/**
 * Created by yfy on 2016/11/12.
 * Median of Two Sorted Arrays
 */

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1, len2, len;
    len1 = nums1.length;
    len2 = nums2.length;
    len = len1 + len2;
    if (len % 2 == 0)
      return (find(nums1, 0, len1, nums2, 0, len2, len / 2) +
          find(nums1, 0, len1, nums2, 0, len2, len / 2 + 1)) / 2;
    else
      return find(nums1, 0, len1, nums2, 0, len2, len / 2 + 1);
  }

  private double find(int[] a, int a0, int a1, int[] b, int b0, int b1, int k) {

  }

  private double search(int[] a, int a0, int a1, int v) {
    while () {
      int mid = (a0 + a1) / 2;
    }
  }

}

public class P4 {
}
