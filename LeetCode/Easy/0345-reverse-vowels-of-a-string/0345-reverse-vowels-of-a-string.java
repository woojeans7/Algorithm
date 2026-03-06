class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // 투포인터로 앞에서부터 하나씩 비교
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();

        while(left < right){
            // 앞자리가 모음일 때까지 찾기
            if(left < right && !vowels.contains(s.charAt(left))){
                left++;
                continue;
            }
            // 뒷자리가 모음일 때까지 찾기
            if(left < right && !vowels.contains(s.charAt(right))){
                right--;
                continue;
            } 

            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            left++;
            right--;
        }

        return String.valueOf(arr);

    }
}