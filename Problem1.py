# Time Complexity: O(N)
# Space Complexity: O(1)
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
      # if not root:
      #   return []
      # q = collections.deque()
      # q.append((root, 0))
      # res = []
      # while q:
      #   n, level = q.popleft()
      #   if len(res) <= level:
      #     res.append([n.val])
      #   else:
      #     res[level].append(n.val)
      #   if n.left:
      #     q.append((n.left, level + 1))
      #   if n.right:
      #     q.append((n.right, level + 1))
      
      # return res
      # res = []

      # def helper(node, level):
      #   if not node:
      #     return
      #   if len(res) <= level:
      #     res.append([node.val]) 
      #   else:
      #     res[level].append(node.val)
        
      #   helper(node.left, level + 1)
      #   helper(node.right, level + 1)
      # helper(root, 0) 
      # return res
      if not root:
        return [] 
      res = []
      q = collections.deque()
      q.append(root)
      while q:
        curr_level = []
        for i in range(len(q)):
          n = q.popleft()
          curr_level.append(n.val)
          if n.left:
            q.append(n.left)
          if n.right:
            q.append(n.right)
        res.append(curr_level)
      return re
