from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inbound = [0 for i in range(numCourses)]
        q = deque()
        adjacency_list = []
        ind_dep_map = {}

        for req in prerequisites:
            inbound[req[1]] += 1

            if req[0] in ind_dep_map :
                ind_dep_map[req[0]].append(req[1])
            else :
                ind_dep_map[req[0]] = [req[1]]

        count = 0
    
        for i in range(len(inbound)) :
            if inbound[i] == 0 :
                q.append(i)
                count += 1

        if len(q) == 0 :
            return False

        while(count != numCourses and len(q)!= 0) :
            course = q.popleft()

            if course in ind_dep_map :
                dependent_list = ind_dep_map[course]

                for dep in dependent_list:
                    inbound[dep] -= 1
                
                    if inbound[dep] == 0 :
                        q.append(dep)
                        count += 1

        if count == numCourses :
            return True

        return False
                
            
                
            

            
            

