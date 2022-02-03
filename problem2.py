#TIme Complexity =O(n)
#Space Complexity = O(n)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        arr = [0 for i in range(numCourses)]
        hashmap = {}
        for i in prerequisites:
            arr[i[0]]+=1
            if(i[1] not in hashmap):
                hashmap[i[1]] = []
            hashmap[i[1]].append(i[0])
            
        queue = []
        
        for i,v in enumerate(arr):
            if(v==0):
                queue.append(i)
        print(queue,arr,hashmap)
        while(len(queue)!=0):
            val = queue.pop(0)
            if(val in hashmap):
                for i in hashmap[val]:
                    arr[i]-=1
                    if(arr[i]==0):
                        queue.append(i)
        return sum(arr)==0
            
        
        