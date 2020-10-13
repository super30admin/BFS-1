from collections import deque
def zigzagtraversal(root):
  result = []
  if not root:
    return result
    
  queue = deque()
  queue.append(root)
  lefttoright = True
  while len(queue)>0:
    temp = deque()
    for _ in range(len(queue)):
      node = queue.popleft()
      if lefttoright:
        temp.append(node.val)

      else:
        temp.appendleft(node.val)

      if node.left:
        queue.append(node.left)

      if node.right:
        queue.append(node.right)
    result.append(temp)
    lefttoright = not lefttoright
    
  return result
  
  #tc and sc are o(n)
      
     
