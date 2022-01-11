class Solution:
    def levelOrder(self, root):
        r = []
        q = [] 
        if root:
            q.append(root)
        else:
            return r
        while q:
            l = []
            for i in range(len(q)):
                curr = q.pop(0)
                l.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            r.append(l)
        return r
          
        
        
        
