class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] nums3 = new int[n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                nums3[k] = nums1[i];
                i++;
            }
            else{
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            nums3[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n2){
            nums3[k] = nums2[j];
            j++;
            k++;
        }
        if(n % 2 == 1){
            return nums3[n/2];
        }
        return (nums3[n/2] + nums3[(n/2) - 1])/2.0;
    }
}
