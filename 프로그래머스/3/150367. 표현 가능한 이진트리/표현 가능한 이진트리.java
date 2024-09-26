class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            // 1. 이진수로 변경 
            String value = "";
            long number = numbers[i];
            while(number > 0){
                if(number == 1){
                    value = 1 + value;
                    break;
                } else {
                long temp = number % 2;
                number /= 2;
                value = temp + value;
                }
            }
            // 2. 앞자리를 1,3,7,15 ... 길이에 맞게 0으로 채운다.
            int temp = 0;
            for(int j = 1;;j *= 2){
                temp += j;
                if(value.length() > temp){
                    continue;
                } else if(value.length() < temp) {
                    int length = value.length();
                    for(int k = 0 ; k < temp - length; k++){
                        value = "0" + value;
                    }
                    break;
                } else {
                    break;
                }
            }
            // 3. index가 짝수인 값이 1이면 그 사이의 값(ex. 0,2 사이의 값 1)이 1인지 확인
            // 4. 홀수의 값으로 새로운 String을 만들어 3번 반복
            int result = 1;
            A: 
            while(true){
                // 루트 노드만 남았을 경우
                if(value.length() == 1){
                    if(value.charAt(0) == '0'){
                        result = 0;
                    }
                    break;
                } else {
                    for(int j = 0; j < value.length() - 1; j += 2){
                        if(value.charAt(j) == '1' || (j + 2 < value.length() && value.charAt(j + 2) == '1')){
                            if(value.charAt(j + 1) == '0'){
                                result = 0;
                                break A;
                            }
                        }
                    }
                    String tempValue = "";
                    for(int j = 1; j < value.length(); j += 2){
                        tempValue = value.charAt(j) + tempValue;
                    }
                    value = tempValue;
                }
            }
        // 5. 모두 이상 없다면 true
        answer[i] = result;
        }
        return answer;
    }
}