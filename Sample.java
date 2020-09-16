// Problem 1 - Binary Tree Level Order Traversal
// Time Complexity: O(n) where n = number of nodes
// Space Complexity: O(n)

// Algorithm
// 1 - initiliaze a queue
// 2 - while condition
// 3 - loop over the size of queue
// 4 - poll from Queue
// 5 - check if node.left not null, add to queue
// 6 - check if node.right not null, add to queue
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    // 1
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    queue.add(root);
    // 2
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> temp = new ArrayList<>();
      
      // 3
      for (int i=0; i<size; i++) {
        // 4
        TreeNode node = queue.poll();
        temp.add(node.val);
        
        // 5
        if (node.left != null) {
          queue.add(node.left);
        }
        // 6
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      result.add(temp);
    }

    return result;
  }
}

// Problem 2 - Course Schedule
// Time Complexity: O(V + E) where V = number of vertices and E = number of edges
// Space Complexity: O(V + E)

// Algorithm
// 1 - create incomingEdges array
// 2 - create a hashMap with vertex as the key and list of edges as value
// 3 - create a queue with initilially having course which has 0 incoming edge
// 4 - loop over queue until empty
// 5 - if hashMap contains vertex, then loop over the list of edges
// 6 - decrement incomingEdge by 1
// 7 - if incomingEdge count equals 0, add it to queue
// 8 - loop again over incomingEdges to check for any non-zero incomingEdge count
class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // 1
    int[] incomingEdges = new int[numCourses];
    // 2
    Map<Integer, List<Integer>> hashMap = new HashMap<>();

    for (int i=0; i<prerequisites.length; i++) {
      int in = prerequisites[i][0];
      int out = prerequisites[i][1];

      incomingEdges[in] += 1;

      if (!hashMap.containsKey(out)) {
        hashMap.put(out, new ArrayList<>());
      }
      hashMap.get(out).add(in);
    }
    
    // 3
    Queue<Integer> queue = new LinkedList<>();
    for (int i=0; i<incomingEdges.length; i++) {
      if (incomingEdges[i] == 0) {
        queue.add(i);
      }
    }

    if (queue.isEmpty()) {
      return false;
    }
    
    // 4
    while (!queue.isEmpty()) {
      int course = queue.poll();
      // 5
      if (hashMap.containsKey(course)) {
        for (int i : hashMap.get(course)) {
          // 6
          incomingEdges[i] -= 1;
          // 7
          if (incomingEdges[i] == 0) {
            queue.add(i);
          }
        }
      }
    }
    
    // 8
    for (int i=0; i<incomingEdges.length; i++) {
      if (incomingEdges[i] != 0) {
        return false;
      }
    }

    return true;
  }
}

// Problem 3 - Binary Tree Right Side View
// Time Complexity: O(n) where n = number of nodes
// Space Complexity: O(n)

// Algorithm
// 1 - initiliaze a queue
// 2 - add the root
// 3 - while condition
// 4 - get size of the queue
// 5 - loop over size
// 6 - poll the node from queue
// 7 - if on the last iteration, add the value to output list
// 8 - if node.left not null, add to queue
// 9 - if node.right not null, add to queue
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    // 1
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    // 2
    queue.add(root);
    // 3
    while(!queue.isEmpty()) {
      // 4
      int size = queue.size();
      // 5
      for (int i=0; i<size; i++) {
        // 6
        TreeNode node = queue.poll();
        // 7
        if (i == size - 1) {
          result.add(node.val);
        }
        // 8
        if (node.left != null) {
          queue.add(node.left);
        }
        // 9
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    return result;
  }
}
