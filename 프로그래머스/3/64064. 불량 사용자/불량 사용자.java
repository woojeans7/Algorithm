import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {

        dfs(0, user_id, banned_id, new HashSet<>());

        return result.size();
    }
    private void dfs(int depth, String[] user_id, String[] banned_id, Set<String> selected) {
        if(depth == banned_id.length) {
            result.add(new HashSet<>(selected));
            return;
        }

        for(String uid : user_id) {
            if(selected.contains(uid)) continue;

            if(isConvertable(uid, banned_id[depth])) {
                selected.add(uid);
                dfs(depth + 1, user_id,  banned_id, selected);
                selected.remove(uid);
            }
        }
    }
    private boolean isConvertable(String uid, String bid){
        if(uid.length() != bid.length()) return false;

        for(int i = 0; i < uid.length(); i++) {
            if(bid.charAt(i) != '*' && uid.charAt(i) != bid.charAt(i))
                return false;
        }

        return true;
    }
}