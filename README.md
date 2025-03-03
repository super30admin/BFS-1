# BFS-1
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
class Solution {

   public List<List<Integer>> levelOrder(TreeNode root) {

       List<List<Integer>> result = new ArrayList<>();

       computeBfs(root,result,0);

       return result;

   }

   public void computeBfs(TreeNode root,List<List<Integer>> result, int level){

       if(root==null) return;

       if(result.size()==level)

           result.add(new ArrayList<Integer>());

       result.get(level).add(root.val);

           computeBfs(root.left,result,level+1);

           computeBfs(root.right,result,level+1);

       }

   }
# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)
class Solution {

   public boolean canFinish(int numCourses, int[][] prerequisites) {

       int [] degrees = new int [numCourses];//

       HashMap <Integer,List<Integer>> map = new HashMap<>();

       Queue <Integer> q = new LinkedList<>();

       for(int i = 0; i < prerequisites.length; i++){

           degrees[prerequisites[i][1]]++; //

           if(!map.containsKey(prerequisites[i][0])){

               map.put(prerequisites[i][0], new ArrayList<>());

           }

           map.get(prerequisites[i][0]).add(prerequisites[i][1]);

       }

       for(int i = 0; i < degrees.length; i++){

           if(degrees[i] == 0){

                q.add(i);

           }

       }

       while(!q.isEmpty()){

          int course = q.poll();

           List <Integer> children = map.get(course);

           if(children != null){

               for(Integer child : children){

               degrees[child]--;

                   if(degrees[child] == 0){

                       q.add(child);

                   }

               }

           }

       }

      for(int i = 0; i < degrees.length; i++){

          if(degrees[i] != 0) return false;

      }

      return true;

   }

}

