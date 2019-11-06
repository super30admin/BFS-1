Time Complecity-O(N)
Space Complexity- Max N/2 nodes in queue-O(N)
Leetcode Submission-Successfu


    public List<Integer> rightSideView(TreeNode root) {
          List<Integer> result = new ArrayList<>();
        if (root == null)
          return result;

      Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                 TreeNode currentNode = queue.poll();
                       if (i == levelSize - 1)
                          result.add(currentNode.val);
                        if (currentNode.left != null)
                          queue.offer(currentNode.left);
                        if (currentNode.right != null)
                          queue.offer(currentNode.right);
      }
    }

    return result;
    }
