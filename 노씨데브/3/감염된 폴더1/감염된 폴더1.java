import java.util.*;

class Solution {
    public String solution(String[][] folders, String p, String q) {
        String answer = "";

        Map<String, List<String>> newFolders = new HashMap<>();
        for(String[] folder : folders){
            String parent = folder[0];
            String child = folder[1];

            newFolders.putIfAbsent(parent, new ArrayList<>());
            newFolders.get(parent).add(child);
        }

        answer = dfs("root", newFolders, p, q);

        return answer;
    }
    public String dfs(String file, Map<String, List<String>> newFolders, String p, String q) {
        List<String> found = new ArrayList<>();

        if (file.equals(p) || file.equals(q)) found.add(file);

        for (String child : newFolders.getOrDefault(file, new ArrayList<>())) {
            String temp = dfs(child, newFolders, p, q);
            if (temp != null) found.add(temp);
        }

        if (found.size() >= 2) {
            return file;
        }

        return found.isEmpty() ? null : found.get(0);
    }
}