class Solution {
    public long solution(int price, long money, int count) {
        long m=0;
        for(int i=1; i<=count; i++){
            m+=price*i;
        }
        if(m>money) return m-money;
        else return 0;
    }
}
