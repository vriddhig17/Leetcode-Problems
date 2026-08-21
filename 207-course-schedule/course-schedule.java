class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] courses = new ArrayList[numCourses];
        for(int i = 0; i < courses.length; i++) {
            courses[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        //pre = [1, 0]
        for(int[] pre : prerequisites) {
            int prevCourse = pre[1];//0
            int currCourse = pre[0];//1
            courses[prevCourse].add(currCourse);
            indegree[currCourse]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int coursesCompleted = 0;
        while(q.size() > 0) {
            int currCourse = q.poll();
            coursesCompleted++;
            for(int nextCourse : courses[currCourse]) {
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0) {
                    q.add(nextCourse);
                }
            }
        }
        return coursesCompleted == numCourses;
    }
}
