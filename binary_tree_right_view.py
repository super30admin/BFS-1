class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        queue = []
        if not root:
            return root
        
        queue.append(root)
        while(len(queue)>0):
            temp = []
            l = len(queue)
            for _ in range(l):
                node = queue.pop(0)
                temp.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(temp[-1])
        return result
        
        #same approch as of level order just while appending the list of numbers in a particular level to result, append the last number. tc sc o(n) 
