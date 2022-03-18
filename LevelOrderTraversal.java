//Time Complexity: O(n)
//Space Complexity: O(n)
//didn't face any problems
//runs successfully


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        List<Integer> currLevel = new ArrayList<>();
        Queue<TreeNode> next = new LinkedList<>();

        while(!curr.isEmpty())
        {

            TreeNode node = curr.remove();

            currLevel.add(node.val);

            if(node.left!= null)  next.add(node.left);
            if(node.right!= null) next.add(node.right);

            if(curr.isEmpty())
            {
                result.add(currLevel);
                currLevel = new ArrayList<>();

                curr =next;
                next = new LinkedList<>();
            }
        }
        return result;
    }
}



//Using DFS
public class BinaryTreeLevelOrderTraversal102LeetCode {

    //DFS Approach
    List<List<Integer>> result;                                     //creating the result list


    public List<List<Integer>> levelOrder(TreeNode root) {

        result = new ArrayList<>();

        if(root == null){                                   //if root is null then return the empty list
            return result;
        }

        levelOrder(root, 0);                            //calling the function with root and its level zero

        return result;

    }

    private void levelOrder(TreeNode node, int level){

        if(node == null){                               //if node is null then return
            return;
        }

        if(result.size()!= level){                      //if list size is not equal to level which means we already visited element of the same level
            List<Integer> list = result.get(level);     //so just get the list from the global list corresponding to its level
            list.add(node.val);                         //and add current element to the list
        }
        else{                                           //it means that we are visiting the first element of this level
            List<Integer> list = new ArrayList<>();     //so creating the new list and add current element
            list.add(node.val);                         // and add this list to global list
            result.add(list);
        }

        levelOrder(node.left, level+1);                 //calling the recursive function with left child and increment the level
        levelOrder(node.right, level+1);                 //calling the recursive function with right child and increment the level

    }

