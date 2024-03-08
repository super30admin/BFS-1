#Time Complexity : O(n)
#Space Complexity : O(n)
#Any problem you faced while coding this : -

#The approach is a standard level-order traversal using a queue to process each level of the binary tree. The nodes at a particular level are determined based on the size of the queue.


from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []  # List to store the final result
        q = deque()  # Queue for level-order traversal

        if not root:
            return result  # Return empty list if the tree is empty

        q.append(root)  # Enqueue the root node

        while len(q) != 0:
            size = len(q)  # Number of nodes at the current level
            level = list()  # List to store values at the current level

            for i in range(size):
                curr = q.popleft()  # Dequeue the current node
                level.append(curr.val)  # Append its value to the current level list

                # Enqueue the left and right children if they exist
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)

            result.append(level)  # Append the current level list to the final result

        return result  # Return the list of lists representing level-order traversal