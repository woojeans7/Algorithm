import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skillTree : skill_trees) {
            StringBuilder sb = new StringBuilder();

            for(char c : skillTree.toCharArray()) {
                if (skill.contains(String.valueOf(c)))
                    sb.append(c);
            }

            String filtered = sb.toString();
            if(skill.startsWith(filtered)) answer++;
        }

        return answer;
    }
}