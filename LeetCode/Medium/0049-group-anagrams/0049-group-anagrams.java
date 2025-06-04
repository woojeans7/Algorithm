class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            String key = generateKey(str);
            map.putIfAbsent(key, new LinkedList<>());
            List<String> list = map.get(key);
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
    private String generateKey(String s){
        char[] chars = s.toCharArray();   // 문자열을 문자 배열로
        Arrays.sort(chars);  // 정렬
        return new String(chars);   
    }
    // 숫자로 카운팅하기
    // private String generateKey(String s){
    //     // 알파벳 숫자만큼 생성
    //     int[] map = new int[26];
        
    //     // 문자열을 배열로 변환
    //     char[] arr = s.toCharArray();
        
    //     // 알파벳 개수를 카운팅
    //     for(char c : arr){
    //         map[c - 'a']++;
    //     }
    //     // 문자열 붙이기
    //     StringBuilder sb = new StringBuilder();
    //     for(int num : map){
    //         sb.append(num); 
    //         sb.append(","); // 구분자
    //     }

    //     return sb.toString();
    // }
}