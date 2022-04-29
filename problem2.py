#Course Schedule

# // Time Complexity :O(max(v,e)) - v=vertices, e=edges
# // Space Complexity : O(max(v,e)) 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :very confusing, but lecture helped a lot



def canFinish( numCourses, prerequisites):
    if len(prerequisites)==0:
        return True
    hashmap={}
    class_list = [0]*numCourses
    for i in (prerequisites):
        class_list[i[0]]+=1
        if i[1] in hashmap:                                 #add all the classes that is required to be finished to take other classes to a hashmap
            hashmap[i[1]].append(i[0])
        else:
            hashmap[i[1]]=[i[0]]
        
    count=0  
    queue=[]
    for i in range(len(class_list)):                        #in a queue, add classes that dont depend on other classes
        if(class_list[i]==0):
            queue.append(i)
            count+=1
    
    if (len(queue)==0): return False                        #if there is no independent class, then theres a cycle, so return false
    
    while(queue):
        val = queue.pop(0)
        print(val)
        classes=hashmap.get(val,None)
        if(classes):
            for i in classes:                               #for all the class that depends on the class on the queue, decrement their value and check if its 0
                class_list[i]-=1
                if(class_list[i]==0):
                    queue.append(i)
                    count+=1
    
    return count==numCourses

#test
print(canFinish(2, [[1,0],[0,1]]))