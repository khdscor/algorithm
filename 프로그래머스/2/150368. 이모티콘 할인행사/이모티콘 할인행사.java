class Solution {
    
    // 이모티콘과 할인율을 저장할 배열
    private static Emoticon[] arrays;
    
    // 최종 결과 갯수, 가격
    private int resultCount = 0;
    private int resultPrice = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        arrays = new Emoticon[emoticons.length];
        // 값 초기화
        for(int i = 0; i < emoticons.length; i++) {
            arrays[i] = new Emoticon(emoticons[i], 0);
        }
        // 계산
        search(0, users);
        int[] answer = {resultCount, resultPrice};
        return answer;
    }

    // 완전 탐색 - 이모티콘들에 할인율 설정
    public void search (int index, int[][] users){
        // 마지막 이모티콘까지 할인율을 적용하였을 경우
        if (index == arrays.length) {
            // 해당 경우에서 가입자 수, 가격 계산
            int totalCount = 0;
            int totalPrice = 0;
            for(int i = 0; i < users.length; i++){
                // 결과 계산
                int minPercent = users[i][0];
                int minPrice = users[i][1];
                // 고객이 구매할 이모티콘들의 총 가격
                int tempPrice = 0;
                for(int j = 0; j < arrays.length; j++){
                    // 고객이 원하는 할인율 보다 많이 할인하는 이모티콘일 경우 구매
                    if(minPercent <= arrays[j].discount){
                        tempPrice += arrays[j].price * (100 - arrays[j].discount) / 100;
                    }
                }
                // 고객이 지정한 가격보다 총 구매 가격이 높을 경우 플러스 가입, 아닐 경우 각 이모티콘 구입 가격 저장
                if(tempPrice >= minPrice){
                    totalCount++;
                } else {
                    totalPrice += tempPrice;
                }
            }
            
            // 만약 resultCount보다 크다면 갱신, 같다면 가격 비교 후 갱신
            if(resultCount < totalCount){
                resultCount = totalCount;
                resultPrice = totalPrice;
            } else if(resultCount == totalCount){
                resultPrice = Math.max(resultPrice, totalPrice);
            }
        } else {
            // index에 해당하는 이모티콘의 할인율을 지정
            for(int i = 10; i <= 40; i += 10){
                arrays[index].setDiscount(i);
                // 다음 이모티콘 탐색
                search(index + 1, users);
            }
        }
    }
    
    // 이모티콘 및 배율 설정 정보
    public class Emoticon {
        public int price;
        public int discount;
        
        public Emoticon(int price, int discount){
            this.price = price;
            this.discount = discount;
        }
        
        public void setDiscount(int discount){
            this.discount = discount;
        }
    }
}


