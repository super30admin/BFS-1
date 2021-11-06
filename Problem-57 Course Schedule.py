# 207. Course Schedule
# https://leetcode.com/problems/course-schedule/

# Time Complexiety: O(V+E)
# Space Complexiety: O(V+E)

# Logic: We make a graph as there is dependency in the question between subjects. 
# We create a hashtable with the courses as index and the count of subjects they are depenedent on as the value. 
# We then use the adj_list to store the subject as key and subjects which can only be completed after the key as values. 
# We start traversing from an independent subject (0 count in the hashtable) and for every subject on the hashtable reduce the count. 
# If after all the subjects have been visited, the count of the hashtable is 0, then we can say all the subjects can be completed.

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:        
        # Create hashtable
        hashTable = [0 for _ in range(numCourses)]
        adj_list = dict()
        
        
        for i,j in prerequisites:
            hashTable[i] += 1
            
            if j in adj_list:
                adj_list[j].append(i)
            else:
                adj_list[j] = [i]
        
        q = list()
        visited = set()
        
        for idx, item in enumerate(hashTable):
            if item == 0:
                q.append(idx)
                visited.add(idx)
                
        if len(q) == 0:
            return False
        
        while q and sum(hashTable) != 0:
            node = q.pop(0)
            
            if node in adj_list:
                for i in adj_list[node]:            
                    if hashTable[i] > 0:
                        hashTable[i] -= 1

            for idx, item in enumerate(hashTable):
                if item == 0 and idx not in visited:
                    q.append(idx)
                    visited.add(idx)
        
        if sum(hashTable) != 0:
            return False
        return True