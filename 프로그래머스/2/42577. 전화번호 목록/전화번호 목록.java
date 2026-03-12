import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> set = new HashSet<>();
        
        for(String phone : phone_book){
            set.add(phone);
        }
        
        for(String number : phone_book){
            for(int i = 1; i < number.length(); i++){
                String s = number.substring(0, i);
                if(set.contains(s)) return false;
            }
        }
        return true;
    }
}