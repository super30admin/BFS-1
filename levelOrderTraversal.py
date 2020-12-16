# The level order travversal can be implemented using queueand all nodes at one level can be traversed
#Tiime complexity: O(n)
#Space Complexity: O(n/2)
import queue

class Node: 
	def __init__(self,key): 
		self.left = None
		self.right = None
		self.val = key 
class bfs:
    def bfsQueue(self,node):
        bfsq = queue.Queue()
        bfsq.put(node)
        result = list()
        while(not bfsq.empty()):
            node = bfsq.get()
            result.append(node.val)

            if (node.left != None):
                bfsq.put(node.left)

            if (node.right!= None):
                bfsq.put(node.right)
        return result

root = Node(1) 
n2	 = Node(2) 
n3	 = Node(3)
root.left = n2
root.right = n3
n2.left = Node(4)
n2.right = Node(5)
n3.right = Node(6)
b = bfs()
r = b.bfsQueue(root)
print(r)
