# TC: O(n)
# SC: o(w) - width of the tree

from collections import deque

def levelOrder(root):
    if not root:
        return []
    q = deque()
    q.append(root)
    
    result = []
    while q:
        inter_result = []
        level = len(q)
        for _ in range(level):
            ele = q.popleft()
            inter_result.append(ele.val)
            if ele.left: q.append(ele.left)
            if ele.right: q.append(ele.right)
        level += 1
        result.append(inter_result)
    
    return result