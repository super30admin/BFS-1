// # Problem 2
// Course Schedule (https://leetcode.com/problems/course-schedule/)

const canFinish = function(numCourses, prerequisites) {
    if(!prerequisites.length || !prerequisites[0].length) return true;
    let indegrees = new Array(numCourses).fill(0); // 0 -> n-1
    let graph = new Map(); //HashMap<Integer, int[]>
    let queue = [];
    
    for(let i = 0; i < prerequisites.length; i++) {
        indegrees[prerequisites[i][0]] ++;
        let key = prerequisites[i][1];
        if(graph.has(key)) {                
            graph.set(key, graph.get(key).concat(prerequisites[i][0]));
        } else {
            graph.set(key, [prerequisites[i][0]]);
        }
    }
    indegrees.forEach((indegree, index) => {
        if(indegree === 0) queue.push(index);
    });
    while(queue.length) {
        let cur = queue.shift();
        let courses = graph.get(cur);
        for(let i = 0; courses && i < courses.length; i++) { 
            if(--indegrees[courses[i]] === 0) queue.push(courses[i]);
        }
    }
    for(let i = 0; i < indegrees.length; i++) {
        if(indegrees[i] !== 0) {
            return false;
        }
    }
    return true;
};

