class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 종료 조건: 루트가 null이거나 p, q 중 하나와 같으면 루트 반환
        if (root == null || root == p || root == q) {
            return root;
        }

        // 좌측 서브트리 탐색
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 우측 서브트리 탐색
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 양쪽 모두에서 값이 올라왔으면, 현재 루트가 LCA
        if (left != null && right != null) {
            return root;
        }

        // 한쪽만 결과가 있으면 그쪽 결과 반환
        return (left != null) ? left : right;
    }
}