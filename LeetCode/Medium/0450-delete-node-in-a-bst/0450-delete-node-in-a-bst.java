class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null && root.right == null) return null;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            TreeNode temp = minNode(root.right);
            root.val = temp.val;
            root.right = deleteNode(root.right, temp.val);
        }
        return root;
    }
    private TreeNode minNode(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}