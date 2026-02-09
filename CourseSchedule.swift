//
//  CourseSchedule.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/19/26.
//

/*
 (1, 0) -> in order to do course 1, we should have finished course 0.
 prerequisites array -> [[1,0], [], []] -> if we draw, we will figure out that it's edges array.
 chekc if 0,1,2,3,4,5 -> courses can be finished.
 initially we can
 
 => How to identidy if it's a graph problem or not ?
 start drawing. If we find connections..
 
 Different ways to represent graph - adjacency list or adjacency matrix, an array of edges.
 
 choose an independent one. process it.
 others which becomes independet then next will b eindependent...so on and so forth -
 Topological sort
 indegrees array -> how many sharp edges are incoming to a new node.
 
 all the babies of an independent node has to be processed.
 use BFS. use queue.
 how to find that what all items should be added to the queue when doing BFS.
 
 --> if we process 0 then search the edges array for dependent once.
 search is leanr.
 so for search optimization , use hashing baed data structure. Hence, hash map.
 
 use independetn to dependent list.
 if added children t queue. reduce indegree by 1. if it turned into 0 means it has become independent, If not, not yet become independent.
 
 Taking inside the queue means we can complete the course. If all indegrees are 0 then
 
 -> two ways of representing a graph.
 hash map - 1 is dependt on 0.
 4 has outgoinf to 5
 
 which format is applkicable for out problem is critical decision.
 
 
 level up ->
 If indegree of two elements are 0, then
 if we put both i queue -> then it will
 if we don't put both - thne it will not. if all independent nodes are not going i queue then it will not work.
 for BFS - all sould be processed. allnodes of particular level hosul be processed together.
 DFS - we can use any
 
 ********** all nodes of particular level hosul be processed together in BFS.
 
 Toplological sort is used to check a cycle. Somenodes will not be gong inside the queue. If thetre is cyclic dependency then we can identify it.
 
 Using DFS also, we can detect the cycle.
 topological sort ->
 
 
 time complexity of the solution -> O(V + E). which ever is bigger, that will be considered.
 space compelxityt -> adjacency list O(V + E)
 from hash map. we are picking all eges for a particular vertex, we are processing al, those edges. thats;w combinly called E
 No of edges are greater than no of vertices.
 In worst case, edges can go upto n^2.
 E - consolidation of all children, all edges.
 
 */

//toplological sort solution
class CourseSchedule {
    
    init() {
        
    }
    
    func canFinish(_ numCourses: Int, _ prerequisites: [[Int]]) -> Bool {
        
        var indegrees = Array(repeating: 0, count: numCourses)
        var adjacencyMap = [Int:[Int]]()
        for course in prerequisites {
            //for each course, set the indegrees
            let independent = course[1]
            let dependent = course[0]
            
            if (adjacencyMap[course[1]] != nil) {
                adjacencyMap[course[1]]!.append(dependent)
            } else {
                adjacencyMap[course[1]] = [dependent]
            }
            indegrees[dependent] += 1
        }
        
        //topological sort started
        //add the courses for which indegrees are 0
        var queue = QueueUsingLL<Int>()
        var count = 0 //how many nodes are going inside the queue
        for (index, value) in indegrees.enumerated() {
            if (value == 0) {
                queue.enqueue(index)
                count += 1
            }
        }
        
        if (count == numCourses) {
            //if all courses has gone into the queue so all are taken.
            return true
        }
        //If queue is empty initially, it means there is a cycle. Nothing will go inside the queue
        if (queue.isEmpty) {
            return false
        }
        
        while (queue.size != 0) {
            let curr = queue.dequeue()
            if let curr = curr {
                //check in adjacency list the connections from this node
                if let children = adjacencyMap[curr] {
                    for val in children {
                        indegrees[val] -= 1
                        if (indegrees[val] == 0) {
                            queue.enqueue(val)
                            //whenever putting inside the queue, increment the count by 1
                            count += 1
                            if (count == numCourses) {
                                return true
                            }
                        }
                    }
                }
            }
        }
        return false
    }
}

