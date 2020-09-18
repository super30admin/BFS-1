#Time complexity- O(N), going through every element in tree
#Space complexity- O(B), storing length of each bradth of the tree in queue

#using BFS- iterative solution, popping each element and storing left and right values of it in queue.



class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        result = []
        q = deque([root])
        
        if root == None:
            return None
        
        
        while q:
            
            right_element = q[-1]
            result.append(right_element.val)
            
            for i in range(0, len(q)):
                

                temp = q.popleft()
                
                if temp.left != None:
                    q.append(temp.left)
                    
                if temp.right != None:
                    q.append(temp.right)
                 
        return result
