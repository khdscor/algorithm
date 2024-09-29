class Solution {
    public int count = 0;
    public String result = "";
    public char[] arrays = new char[5];
    public int solution(String word) {
        // word 길이가 5가 될때까지 뒷부분에 B 추가
        result = word;
        for(int i = 0; result.length() < 5; i++){
            result += "B";
        }
        // 1. 크기가 5인 배열에 공백의 의미로 B를 지정
        arrays[0] = 'B';
        arrays[1] = 'B';
        arrays[2] = 'B';
        arrays[3] = 'B';
        arrays[4] = 'B';
        dfs(0, false);
        if(result.equals("" + arrays[0] + arrays[1] + arrays[2] + arrays[3] + arrays[4])){
            System.out.println("success : " + arrays[0] + arrays[1] + arrays[2] + arrays[3] + arrays[4]);
        }
        return count;
    }
    
    public int dfs(int index, boolean u){
        // 마지막 index인 경우
        if(index == 4){
            while(true){
                // 1. 목표 달성할 경우 1 반환하여 중지 요청
                if(result.equals("" + arrays[0] + arrays[1] + arrays[2] + arrays[3] + arrays[4])){
                    return 1;
                }
                // 2. 각각의 경우별 알파벳 상승 후 count 증가
                if(arrays[index] == 'B'){
                    arrays[index] = 'A';
                    count++;
                    continue;
                }
                if(arrays[index] == 'A'){
                    arrays[index] = 'E';
                    count++;
                    continue;
                }
                if(arrays[index] == 'E'){
                    arrays[index] = 'I';
                    count++;
                    continue;
                }
                if(arrays[index] == 'I'){
                    arrays[index] = 'O';
                    count++;
                    continue;
                }
                if(arrays[index] == 'O'){
                    arrays[index] = 'U';
                    count++;
                    continue;
                }
                // index에 해당하는 값이 U인 경우
                if(u){
                    // word가 UUUUU인 경우
                    return 1;
                }
                count++;
                arrays[index] = 'B';
                // 2. index에 해당하는 값이 U일 경우 2반환하여 값 증가 요청
                return 2;
            }
        // 길이를 다 못채웠을 경우
        } else {
            while(true){
                // 1. 목표 달성할 경우 1 반환하여 중지 요청
                if(result.equals("" + arrays[0] + arrays[1] + arrays[2] + arrays[3] + arrays[4])){
                    return 1;
                }
                // 2. index에 해당하는 값이 B일 경우 A로 진화 후 반복문 진행
                if(arrays[index] == 'B'){
                    arrays[index] = 'A';
                    count++;
                    continue;
                } 
                // 3. index에 해당하는 값이 A, E, I, O 중 하나일 경우 다음 index로 이동
                int value = dfs(index + 1, false);
                if(value == 1){
                    return 1;
                }
                if(value == 2){
                    if(arrays[index] == 'A'){
                        arrays[index] = 'E';
                        continue;
                    }
                    if(arrays[index] == 'E'){
                        arrays[index] = 'I';
                        continue;
                    }
                    if(arrays[index] == 'I'){
                        arrays[index] = 'O';
                        continue;
                    }
                    if(arrays[index] == 'O'){
                        arrays[index] = 'U';
                        continue;
                    }
                    // 앞에 index가 모두 U인 경우 더이상 앞 부분 진행 x
                    if(u){
                        dfs(index + 1, true);
                        return 1;
                    }
                    arrays[index] = 'B';
                    return 2;
                }
            }
        }
    }
}