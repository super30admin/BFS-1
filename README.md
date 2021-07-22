# BFS-1

# Problem 1

Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

<!-- Time Complexity = O(N)
Space Complexity = O(N) -->

/\*\*

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
  \*/
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

// class Solution {

// public List<List<Integer>> levelOrder(TreeNode root) {
// List<List<Integer>> result = new ArrayList();
// if(root == null) {
// return result;
// }
// Queue<TreeNode> queue = new LinkedList<>();
// queue.add(root);
// while(!queue.isEmpty()) {
// int sz = queue.size();
// List<Integer> list = new ArrayList();
// for(int i = 0; i < sz; i++) {
// TreeNode current = queue.poll();
// list.add(current.val);
// if(current.left != null) {
// queue.add(current.left);
// }
// if(current.right != null) {
// queue.add(current.right);
// }
// }
// result.add(list);
// }
// return result;
// }

// }

# Problem 2

Course Schedule (https://leetcode.com/problems/course-schedule/)

<!-- Time Complexity = O(numCourses + prerequisites)
Space Complexity = O(numCourses + prerequisites) -->

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
