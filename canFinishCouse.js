// Time Complexity : O(V + E)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


var canFinish = function(numCourses, prerequisites) {
    let map = new Map();
    let inDegree = new Array(numCourses).fill(0);

    //form the hash map

    for(let i = 0; i < prerequisites.length; i++){
        inDegree[prerequisites[i][0]]++;
        if(!map.has(prerequisites[i][1])) map.set(prerequisites[i][1], new Array());
        map.get(prerequisites[i][1]).push(prerequisites[i][0]);
    }

    let q = [];
    for(let i = 0; i < numCourses; i++){
        if(inDegree[i] == 0) q.push(i);
    }

    //checking for unique cources

    while(q.length > 0){
        let curr = q.shift();
        let children = map.get(curr);

        if(children != null){
            for(let child of children){
                inDegree[child]--
    
                if(inDegree[child] == 0) q.push(child)
            }
        }
    }

    for(let i = 0; i < numCourses; i++){
        if(inDegree[i] > 0){
            return false
        }
    }

    return true;

}