'''
207. Course Schedule

TIME COMPLEXITY: O( numCourses + len(prerequisites) )
SPACE COMPLEXITY: O( numCourses + len(prerequisites) )
LEETCODE: yes
APPROACH: Queue and incoming nodes
DIFFICULTIES: Yes. Solved after the class
'''


from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites) == 0:
            return True
        n_v = 0
        mmap = {}
        ingress = [-1 for i in range(0, numCourses+1)]
        
        for sub, pre_req in prerequisites:
            if ingress[sub] == -1:
                ingress[sub] = 1
                n_v += 1
            else:
                ingress[sub] += 1
            
            if ingress[pre_req] == -1:
                n_v += 1
                ingress[pre_req] = 0
            
            if pre_req in mmap.keys():
                mmap[pre_req].append(sub)
            else:
                mmap[pre_req] = [sub]
            
            if sub not in mmap.keys():
                mmap[sub] = []
        
        q = deque()
        for i in range(0, len(ingress)):
            if ingress[i] == 0:
                q.append(i)
        
        while len(q) != 0:
            independent = q.popleft() 
            n_v -= 1
            if independent in mmap.keys():
                dependents = mmap[independent]
                for item in dependents:
                    ingress[item] -= 1
                    if ingress[item] == 0:
                        q.append(item)
            
        
        if n_v == 0:
            return True
        else:
            return False
