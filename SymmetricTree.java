/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
/** Recursive Solution */
/**
    public boolean isSymmetric(TreeNode root) {
        if(root == null ) return true;
        else return checkSymmetry(root.left, root.right);
        
    }
    
    public boolean checkSymmetry(TreeNode n1, TreeNode n2){
        if      ((n1 == null) && (n2== null)) return true;
        else if (n1 == null || n2 == null) return false;
        else if (n1.val != n2.val) return false;
        else return checkSymmetry(n1.left, n2.right) && checkSymmetry(n1.right, n2.left);   
    }
*/
/** BFS Iterative solution Solution */    
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null ) return true;
        queue.add(root.left);
        queue.add(root.right);
        
        while(!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if      (n1 == null && n2 == null) continue;
            else if (n1 == null || n2 == null) return false;
            else if (n1.val != n2.val) return false;
            else    {
                queue.add(n1.left);
                queue.add(n2.right);
                queue.add(n1.right);
                queue.add(n2.left);
            }
            
        }
        return true;
        
        
    }
}
