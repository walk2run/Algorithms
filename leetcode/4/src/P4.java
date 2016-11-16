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

  // m, n are length
  private double find(int[] a, int a0, int m, int[] b, int b0, int n, int k) {
    if (m > n) return find(b, b0, n, a, a0, m, k);
    if (m == 0) return b[b0 + k - 1];
    if (k == 1) return Math.min(a[a0], b[b0]);
    int k1, k2, v1, v2;
    k1 = Math.min(k / 2, m);
    k2 = k - k1;
    v1 = a[a0 + k1 - 1];
    v2 = b[b0 + k2 - 1];
    if (v1 == v2)
      return v1;
    else if (v1 < v2)
      return find(a, a0 + k1, m - k1, b, b0, n, k - k1);
    else
      return find(a, a0, m, b, b0 + k2, n - k2, k - k2);
  }
}

public class P4 {
}

/*
Assume that the number of elements in A and B are both larger than k/2, and if we compare the k/2-th smallest element in A(i.e. A[k/2-1]) and the k-th smallest element in B(i.e. B[k/2 - 1]), there are three results:
(Becasue k can be odd or even number, so we assume k is even number here for simplicy. The following is also true when k is an odd number.)
A[k/2-1] = B[k/2-1]
A[k/2-1] > B[k/2-1]
A[k/2-1] < B[k/2-1]
if A[k/2-1] < B[k/2-1], that means all the elements from A[0] to A[k/2-1](i.e. the k/2 smallest elements in A) are in the range of k smallest elements in the union of A and B. Or, in the other word, A[k/2 - 1] can never be larger than the k-th smalleset element in the union of A and B.

Why?
We can use a proof by contradiction. Since A[k/2 - 1] is larger than the k-th smallest element in the union of A and B, then we assume it is the (k+1)-th smallest one. Since it is smaller than B[k/2 - 1], then B[k/2 - 1] should be at least the (k+2)-th smallest one. So there are at most (k/2-1) elements smaller than A[k/2-1] in A, and at most (k/2 - 1) elements smaller than A[k/2-1] in B.So the total number is k/2+k/2-2, which, no matter when k is odd or even, is surly smaller than k(since A[k/2-1] is the (k+1)-th smallest element). So A[k/2-1] can never larger than the k-th smallest element in the union of A and B if A[k/2-1]<B[k/2-1];
Since there is such an important conclusion, we can safely drop the first k/2 element in A, which are definitaly smaller than k-th element in the union of A and B. This is also true for the A[k/2-1] > B[k/2-1] condition, which we should drop the elements in B.
When A[k/2-1] = B[k/2-1], then we have found the k-th smallest element, that is the equal element, we can call it m. There are each (k/2-1) numbers smaller than m in A and B, so m must be the k-th smallest number. So we can call a function recursively, when A[k/2-1] < B[k/2-1], we drop the elements in A, else we drop the elements in B.


We should also consider the edge case, that is, when should we stop?
1. When A or B is empty, we return B[k-1]( or A[k-1]), respectively;
2. When k is 1(when A and B are both not empty), we return the smaller one of A[0] and B[0]
3. When A[k/2-1] = B[k/2-1], we should return one of them
 */
