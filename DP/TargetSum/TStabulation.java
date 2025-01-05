package DP.TargetSum;

public class TStabulation {
    public static boolean targetSum(int arr[], int target){
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = true;
        }
        //i -> elements,   j-> cur target
        for(int i=1; i<=n; i++){
            for(int j=1; j<=target; j++){
                int val = arr[i-1];

                //include
                if(val <=j && dp[i-1][j-val] == true){
                    dp[i][j] = true;
                }
                else if(dp[i-1][j] == true){  //exclude
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][target];

    }
    public static void main(String[] args) {
        int val[] = {4,2,7,1,3};
        int target = 10;

        System.out.println(targetSum(val, target));
    }
}
