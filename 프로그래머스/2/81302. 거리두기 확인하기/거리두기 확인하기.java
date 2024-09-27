import java.util.*;

class Solution {

    public char[][] arrays = new char[5][5];
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            // 배열로 입력
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    arrays[j][k] = places[i][j].charAt(k);
                }
            }
            // bfs 실행
            answer[i] = checkDistance() ? 1 : 0;
        }
        
        return answer;
    }

    // 거리두기 확인
    public boolean checkDistance() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arrays[i][j] == 'P') {
                    if (!bfs(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // BFS를 통해 거리두기 확인
    public boolean bfs(int y, int x) {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        
        boolean[][] visit = new boolean[5][5];
        Queue<Student> queue = new LinkedList<>();
        queue.add(new Student(x, y, 0));
        visit[y][x] = true;
        
        while (!queue.isEmpty()) {
            Student student = queue.poll();

            // 거리 2 이하만 확인
            if (student.distance > 0 && student.distance <= 2 && arrays[student.y][student.x] == 'P') {
                return false;
            }

            // 다음 위치 탐색
            for (int i = 0; i < 4; i++) {
                int nx = student.x + dx[i];
                int ny = student.y + dy[i];
                
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visit[ny][nx] && arrays[ny][nx] != 'X') {
                    queue.add(new Student(nx, ny, student.distance + 1));
                    visit[ny][nx] = true;
                }
            }
        }
        return true;
    }

    // 학생의 위치 객체
    public class Student {
        int x;
        int y;
        int distance;

        public Student(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}