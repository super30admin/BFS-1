#Recursive

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        levels = []
        def helper(current,level):
            if current is None:
                return []
            if len(levels)==level:
                levels.append([])
            levels[level].append(current.val)

            if current.left:
                helper(current.left,level+1)

            if current.right:
                helper(current.right,level+1)
        helper(root,0)
        return levels

#Iterative

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        queue = []
        if not root:
          return root
        
        queue.append(root)
        while(len(queue)>0):
          temp = []
          len = len(queue)
          for _ in range(l):
            node = queue.pop(0)
            temp.append(node.val)
            if node.left:
              queue.append(node.left)
            if node.right:
              queue.append(node.right)
           result.append(temp)
        return result
        
        #both aproaches tc sc o(n).
            
            
       

