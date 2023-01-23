// ############ Approach 1: BFS ################

// Time Complexity: O(n) 
// Space Complexity: O(n)

// Approach 1:
// We need to process the nodes level by level, nodes at same level should be processed at the same time.
// Queue is the best data structure as we can process one level, take the nodes out and put nodes in of next level.
// We start with root and add it to the queue
// Until the queue is empty, we process each level with nodes of that level (while loop)
// One iteration of while loop corresponds to one level, so we need to initialize the arraylist for that level
// We get the size of the queue which corresponds to the no of nodes in each level
// We iterate over each node of that level (for loop), take it out of the queue and add it to the arraylist for that level 
// Then we add the left and right child to the queue for processing it in the next level
// After the entire level is processed, we add the level arraylist to the resultant arrayList.


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        
        if(root==null) return result;
        
        //add root first
        q.add(root);
        
        //processing each level
        while(!q.isEmpty()){   
            
        int size=q.size(); // size corresponds to no. of nodes on the same level
        //System.out.println(size);    
        List<Integer> li=new ArrayList<>(); //before processing a level initiate arraylist
        
        for(int i=0;i<size;i++){ //iterate over nodes of that level
            
            //take out the current node and add to arraylist
            TreeNode curr=q.poll();
            li.add(curr.val);
            
            //put children in queue (to be processed in another level)
             if(curr.left!=null) q.add(curr.left);
             if(curr.right!=null) q.add(curr.right);      
        }
            result.add(li); //add to resultant array after every level is processed
        
        }
        
        return result;
    }
}

// ############ Approach 2: DFS ################

// Time Complexity: O(n) 
// Space Complexity: O(H)

// Approach 2:
// We can use DFS to return level order by traversing each branch.
// We need recursion and maintain also maintain the depth
// Here the index of the resultant arr list corresponds to the level of the binary tree
// If level=0 and resultant arr size is 0, means we need to create a new subarraylist in the resultant arraylist corresponding to level 0
// We do PREORDER traversal, starting with root and then left branch, we add sub arraylists for each level and add the nodes.
// We then traverse the right branch, now since level subarraylists are already created we only need to append the elements to the subarray list 
// corresponding to that level

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result=new ArrayList<>();
        helper(root,0);
        return result;
        
    }
    private void helper(TreeNode root,int depth){
        //base
        if(root==null) return;
        //logic
        if(result.size()==depth){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        
        helper(root.left,depth+1);
        helper(root.right,depth+1);
        
        
    }
}