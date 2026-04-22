class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1++]);
                p2++;
            }
            else if(nums1[p1] < nums2[p2]) p1++;
            else p2++;
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}