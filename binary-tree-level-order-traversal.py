# tc O(n), sc O(n).
if not root:
    return []
from collections import deque
queue = deque([root])
res = []

while queue:
    curr_level = []
    for _ in range(len(queue)):
        node = queue.popleft()
        curr_level.append(node.val)
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    res.append(curr_level)

return res