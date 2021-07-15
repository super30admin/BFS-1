# Time Complexity: O(n), where n is the number of nodes in the tree
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        result = []
        q = deque()
        q.append(root)

        while q:
            # For every level, create a new list and get the size of that level
            temp = []
            size = len(q)

            for i in range(size):
                # Append node from current level to the list
                root = q.popleft()
                temp.append(root.val)

                # Append its left and right child to the queue
                if root.left:
                    q.append(root.left)
                if root.right:
                    q.append(root.right)

            # Append the current level list to the result
            result.append(temp)

        return result

