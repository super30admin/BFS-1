//Problem 1: Binary Tree Level Order Traversal
// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem


// Your code here along with comments explaining your approach
 class Solution {
    // BFS Approach
    //time O(n)
    //space O(n) - Arraylist of leaf nodes O(n/2)
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> res= new ArrayList<>();
    //     if(root==null) return res;
    //     Queue<TreeNode> que= new LinkedList<>();
    //     que.add(root);
    //     while(!que.isEmpty()){
    //         int size=que.size(); //showcases nodes at that particular levelOrder
    //         List<Integer> li=new ArrayList<>();
    //         for(int i=0;i<size;i++){
    //             TreeNode cur=que.poll();
    //             li.add(cur.val);
    //             if(cur.left!=null)
    //                 que.add(cur.left);
    //             if(cur.right!=null)
    //                 que.add(cur.right);
    //         }
    //         res.add(li);
    //     }
    //     return res;
    // }

    //DFS Approach with height as local Variable
    //keep a List<height, List<>> traverse and add variables, keep height as local 
    //Time : O(n)
    //Space : O(h)
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.res= new ArrayList<>();
        dfs(root, 0); //call from root node
        return res;
    }

    private void dfs(TreeNode root, int height){
        if(root==null) return;

        if(height==res.size()) //chec if height equals size, if yes, there is no arraylist at given height, add it
            res.add(new ArrayList<>());
        dfs(root.left, height+1); //traverse to left node and increment height
        res.get(height).add(root.val); // add value in inorder manner
        dfs(root.right, height+1); //traverse to right node and increment height
    }
}

//Problem 2: Course Schedules
// Time Complexity :O(numCourses+PreReq) -> (V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //using BFS - 24th July
        //TC: O(V+E)
        //Space: O(V+E)
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        int[] indeg= new int[numCourses];

        for(int[] pr: prerequisites){ // O(E)
            //dependent pr[0] -> incoming edge and pr[1] is independednt-> outgoing
            indeg[pr[0]]++; // increase indegree of dependent, 
            if(!map.containsKey(pr[1])){ // key does not contain
                map.put(pr[1],new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }
        int count=0; //to keep count of courses taken
        Queue<Integer> que=new LinkedList<>();

        //add all independent nodes to queue
        for(int i=0;i<numCourses;i++){ //O(V)
            if(indeg[i]==0){ //independent courses
                que.add(i);
                count++; // increment number of courses added
            }
        }

        if(que.isEmpty()) return false; // all independent courses
        if(count == numCourses) //if all courses are completed,
            return true; //all courses are taken. a course is taken only if indegree is 0 -> basically node becomes independent.
        while(!que.isEmpty()){ //do a bfs traversal  //O(V+E)
            int cur=que.poll();

            List<Integer> child= map.get(cur); //get dependent nodes of independent node(cur)

            if(child!=null){ //there are dependencies
                for(int ch: child){
                    indeg[ch]--;
                    if(indeg[ch]==0){
                        que.add(ch);
                        count++;
                        if(count == numCourses) //if all courses are completed,
                            return true; //all courses are taken. a course is taken only if indegree is 0 -> basically node becomes independent.
                    }// if
                }// for
            }
        }

        return false; //count not equal to number of courses

    }
}