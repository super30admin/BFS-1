# Time Complexity: O(N)
# Space Complexity: O(1)
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
      if not root:
        return []
      q = collections.deque()
      q.append((root, 0))
      res = []
      while q:
        n, level = q.popleft()
        if len(res) <= level:
          res.append([n.val])
        else:
          res[level].append(n.val)
        if n.left:
          q.append((n.left, level + 1))
        if n.right:
          q.append((n.right, level + 1))
      
      return res
