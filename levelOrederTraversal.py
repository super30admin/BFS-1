#Binary Tree level order traversal
#Solved on leetcode: Yes
#Time complexity: O(n) n - number of nodes
#Space complexity: O(n) n - numbner of nodes

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        q = collections.deque()
        q.append(root)
        while q:
            qLen = len(q)
            level = []
            for i in range(qLen):
                node = q.popleft()   
                if node:
                    level.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
            if level:
                result.append(level)  
        return result
