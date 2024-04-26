class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int compress = 1; compress <= s.length()/2; compress++) {
            int count = 0;
            int result = s.length();
            for(int i = 0; i <= s.length()-compress*2; i+=compress) {
                if(s.substring(i, i+compress).equals(s.substring(i+compress, i+compress*2))){
                    count++;
                }
                else if(count > 0){
                    result += Math.log10(count+1)+1;
                    result -= compress*count;
                    count = 0;
                }
            }
            if(count > 0) {
                result -= compress*count;
                result += Math.log10(count+1)+1;
            }
            answer = Math.min(result, answer);
        }
        return answer;
    }
}