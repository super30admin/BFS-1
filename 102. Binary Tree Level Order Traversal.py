class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        stack = deque([root])
        if not root:
            return root
        output = []
        while stack:
            temp = []
            for i in range(len(stack)):
                node = stack.popleft()
                temp.append(node.val)
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)
            output.append(temp)
        return output
                
Space = O(N)
Time = O(N)

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        output = []
        if not root:
            return root
        stack = deque([(root,0)])
        
        while stack:
            
            for i in range(len(stack)):
                node, curr = stack.pop()
                if curr == len(output):
                    output.append([])
                output[curr].append(node.val)
                if node.left:
                    stack.appendleft((node.left, curr+1))
                if node.right:
                    stack.appendleft((node.right, curr+1))
        
        return output

Space = O(N)
Time = O(N)
