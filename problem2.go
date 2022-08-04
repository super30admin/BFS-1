// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var Path []bool
var Visited []bool
var Map map[int][]int

//DFS
func canFinish(numCourses int, prerequisites [][]int) bool {
    if numCourses == 0{
        return true
    }
    
    Map = make(map[int][]int)
    for _,val := range prerequisites{
        Map[val[1]] = append(Map[val[1]],val[0])
    }
    
    Path = make([]bool,numCourses)
    Visited = make([]bool,numCourses)
    
    
    //DFS
    for i:=0;i<len(Visited);i++{
        if Visited[i] == false && hasCycle(i){
            return false
        }
    }
    
    return true
}


func hasCycle(vertex int) bool{
    
    //base
    //logic
    if Path[vertex] == true{
        return true
    }
    
    if Visited[vertex] == true{
        return false
    }
    
    Path[vertex] = true
    Visited[vertex] = true
    
    //action
    if len(Map[vertex]) > 0{
        for _,val := range Map[vertex]{
            //recurse
            if hasCycle(val){
                return true
            }
        }
    } 
    //backtrack
    Path[vertex] = false
    return false
}
