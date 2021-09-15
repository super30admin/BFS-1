import java.util.*;
public class Bfs {
    //time complexity : N
    //space complexity :N/2
    // did it run on leetcode : yes
    // any doubts : no 
//https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
    //using BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();        
        if(root == null) return result;
       
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i =0;i<size;i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(temp);
        }


        return result;
    }

    //Using DFS
    //time complexity : N
    // space complexity : H
    // did it run on leetcode : yes
    // any doubts : no 
    static List<List<Integer>> result1 = new ArrayList<>();
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        if(root == null) return result1;
        dfs(root,0);
        return result1;

    }
    private static void dfs(TreeNode root,int level){
        if(root == null) return;
        //logic
        if(result1.size() == level){
            result1.add(new ArrayList());
        }
            result1.get(level).add(root.val);
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    //https://leetcode.com/problems/course-schedule/
    //BFS
    //time complexity : V+E
    //space complexity : V+E
    // did it run on leetcode : yes
    // any doubts : no 

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge : prerequisites){
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList());
            }
                map.get(edge[1]).add(edge[0]);            
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i =0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> li = map.get(curr);
           if(li != null){
            for(int i : li){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                    count++;
                }
            }
           }
            

        }
        return count==numCourses;
        
    }
  
}
