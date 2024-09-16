class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        
        #1 figure out starting node in the graph
        #2 figure out way to traverse the graph
        #3 peform topological sort
        
        incoming_edges = [0] * numCourses
        print(incoming_edges)
        hashMap = {}
        queue = deque()
        
        for edge in prerequisites:
            print(edge)
            first = edge[0]
            second = edge[1]
            
            incoming_edges[first] += 1
            if second not in hashMap:
                hashMap[second] = []
            hashMap.get(second).append(first)
        
        print(incoming_edges)
        print(hashMap)
    
        for _ in range(0, len(incoming_edges)):
            if incoming_edges[_] == 0:
                queue.append(_)
        print(queue)
        
        if(not queue):
            return False
        
        while(queue):
            top = queue.popleft()
            print(top)
            
            if top in hashMap:
                vertices = hashMap.get(top)
                for v in vertices:
                    incoming_edges[v] -=1
                    if incoming_edges[v] == 0:
                        queue.append(v)
        
        for edge in incoming_edges:
            if edge is not 0:
                return False
        
        return True
