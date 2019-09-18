"""
This uses a similar approach to BTLevelorderTraversal but the only difference here is we are appending 
the last node values in the list since it will always be right side node.
"""
def rightSideView(self, root):
        sink = [[root]]
        result = []
        
        if root is None:
            return []
        
        while sink:
            accumulator = sink.pop()
            print accumulator
            
            rightnode = accumulator[-1].val
            print rightnode
            result.append(rightnode)
            
            temp = []
            for node in accumulator:
                if node.left:
                    temp.append(node.left)
                    
                if node.right:
                    temp.append(node.right)
                    
            if len(temp) > 0:
                sink.append(temp)
                
        return result