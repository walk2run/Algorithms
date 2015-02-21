def kthSmall(A, a0, m, B, b0, n, k):
    if m > n:
        return kthSmall(B, b0, n, A, a0, m, k)
    if m == 0:
        return B[b0 + k - 1]
    if k == 1:
        return min(A[a0], B[b0])
    pa = min(k / 2, m)
    pb = k - pa
    v1 = A[a0 + pa - 1]
    v2 = B[b0 + pb - 1]
    if v1 == v2:
        return v1
    if v1 < v2:
        return kthSmall(A, a0 + pa, m - pa, B, b0, pb, k - pa)
    else:
        return kthSmall(A, a0, pa, B, b0 + pb, n - pb, k - pb)

class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
        m = len(A)
        n = len(B)
        length = m + n
        if length & 1:
            return kthSmall(A, 0, m, B, 0, n, length / 2 + 1)
        else:
            return float(kthSmall(A, 0, m, B, 0, n, length / 2) + 
                kthSmall(A, 0, m, B, 0, n, length / 2 + 1)) / 2
