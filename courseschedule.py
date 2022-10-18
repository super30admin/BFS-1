'''
Time Complexity: O(n)
Space Complexity: O(h)
'''
from collections import deque
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if(len(prerequisites)>0):
            q  = deque([])
            op = [0]*numCourses
            hashmap = {}
            rng = 0
            for i in prerequisites:
                op[i[0]] += 1
                if(i[1] in hashmap):
                    hashmap[i[1]].append(i[0])
                else:
                    hashmap[i[1]] = [i[0]]
            for i in range(len(op)):
                if(op[i]==0):
                    q.append(i)
            # print(op)
            # print(hashmap)
            # print(q)
            # print("_______________")
            while(len(q)>0):
                val = q.popleft()
                print(val)
                if(val in hashmap):
                    for i in hashmap[val]:
                        op[i] -= 1
                        if(op[i]==0):
                            q.append(i)
                # print(op)
                # print("_____________")
            #print(op)
            for i in op:
                if(i > 0):
                    return False
        return True



        