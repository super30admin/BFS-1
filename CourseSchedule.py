#Time Complexity : O(N)
# Space Complexity : O(N)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        list1 = [0] * numCourses
        tab = dict()
        for i in prerequisites:
            inp = i[0]
            out = i[1]
            list1[inp]+=1
            if(tab.get(i[1]) is None):
                tab[i[1]] = []
            tab[i[1]].append(i[0])
        
        queue1 = set()        
        for i in range(len(list1)):
            if(list1[i]==0):
                queue1.add(i)
        while(len(queue1)!=0):
            curr = queue1.pop()
            list2 = tab.get(curr)
            if list2 is None:
                continue
            else:
                for i in list2:
                    list1[i]-=1
                    if(list1[i]==0):
                        queue1.add(i)
        for i in list1:
            if i!=0:
                return False
        return True
            
                
            
            
            
            
        
        