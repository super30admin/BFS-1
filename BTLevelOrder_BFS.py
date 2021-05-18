# TC: O(N) since we are processing all the nodes. 
# SC: O(N), O(N/2) to be precise, since we N/2 will be the max no.of leaf nodes in worst case and we will be having the max possible leaf nodes in the queue.

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        final = []
        
        if not root:
            return
        
        queue = collections.deque()
        queue.append(root)
        while queue:
            temp = []
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                temp.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            final.append(temp)
        
        return final
