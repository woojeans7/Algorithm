class Solution {
    public int[] solution(int brown, int yellow) {

        // 갈색 * 노란색 = 면적의 크기
        int size = brown + yellow;
        
        // 노란색이 가운데로 가야한다.
        // 3칸은 있어야 1칸의 노란색이 가운데에 들어갈 수 있음. -> 합의 제곱근이 최소 길이
        int minHeight = (int) Math.sqrt(size);
        
        for(int h = 3; h <= minHeight; h++){
            if(size % h == 0){
                int w = (int) (size / h);
                
                if(brown == (w + h - 2) * 2){
                    return new int[]{w, h};
                }
            }
        }
        return new int[]{};
    }
}