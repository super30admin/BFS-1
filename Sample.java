//Binary Tree Level Order Traversal 

//Time Complexity = O(N)
//Space Complexity = O(N)



- Definition for a binary tree node.
- public class TreeNode {
-     int val;
-     TreeNode left;
-     TreeNode right;
-     TreeNode() {}
-     TreeNode(int val) { this.val = val; }
-     TreeNode(int val, TreeNode left, TreeNode right) {
-         this.val = val;
-         this.left = left;
-         this.right = right;
-     }
- }

  class Solution {
  List<List<Integer>> result = new ArrayList();
  public List<List<Integer>> levelOrder(TreeNode root) {
  if(root == null) {
  return new ArrayList();
  }
          helper(root, 0);
          return result;
      }

      private void helper(TreeNode root, int level) {
          if(root == null) {
              return;
          }

          if(result.size() == level) {
              result.add(new ArrayList());
          }
          result.get(level).add(root.val);

          helper(root.left,level+1);
          helper(root.right,level+1);


      }
  }





//Course Schedule 
//Time Complexity = O(numCourses + prerequisites)
//Space Complexity = O(numCourses + prerequisites)

class Solution {
public boolean canFinish(int numCourses, int[][] prerequisites) {
if(prerequisites == null || prerequisites.length == 0) {
return true;
}

        HashMap<Integer, List<Integer>> courseMap = new HashMap();
        int[] indegrees = new int[numCourses];

        for(int[] prereq : prerequisites) {
            int out = prereq[1];
            int in = prereq[0];

            if(!courseMap.containsKey(out)) {
                courseMap.put(out, new ArrayList());
            }
            courseMap.get(out).add(in);
            indegrees[in]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses;i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }
        if(queue.size() == 0) {
            return false;
        }
        if(queue.size() == numCourses) {
            return true;
        }
        int completed = 0;
        while(!queue.isEmpty()) {
            int prereq = queue.poll();
            completed++;

            List<Integer> courses = courseMap.get(prereq);

            if(courses != null) {
                for(int course : courses) {
                    indegrees[course]--;

                    if(indegrees[course] == 0) {
                        queue.add(course);
                    }
                }
            }
        }
        return completed == numCourses;
    }

}