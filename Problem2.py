class Solution(object):
    def canFinish(self, numCourses, prerequisites): #T.C -> O(N) , S.C -> O(N/2)
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        indegrees = [0] * numCourses
        hash_map = {}

        for pr in prerequisites:
            #pr[0] dependent
            #pr[1] independent

            indegrees[pr[0]] += 1

            if pr[1] in hash_map:
                hash_map[pr[1]].append(pr[0])
            else:
                hash_map[pr[1]] = [pr[0]]
        count = 0
        queue = deque()
        for i in range(numCourses):
            if indegrees[i] == 0:
                queue.append(i)
                count+=1
        
        while len(queue) != 0:
            curr = queue.popleft()
            print(curr)
            if curr in hash_map: #this will handle the keyerror for hash_map
                temp_list = hash_map[curr]
            else:
                continue
            if len(temp_list) != 0:
                for value in temp_list:
                    indegrees[value] -=1

                    if indegrees[value] == 0:
                        queue.append(value)
                        count+=1
        if count == numCourses: return True
        return False
