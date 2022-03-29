package com.niuke.community;

public class Solution {
    int max=0;
    public int movingCount(int m, int n, int k) {
        int[][] arr =new int[m][n];
        int num1;
        int num2;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                num1 = i==100? 1:(i%10+i/10);
                num2 = j==100? 1:(j%10+j/10);
                arr[i][j]=num1+num2;
            }
        }
        dfs(0,0,k,arr);
        return max;
    }
    void dfs(int i,int j,int k,int[][] arr){

        if(i>=arr.length||i<0||j>=arr[0].length||j<0||arr[i][j]>k)  return;
        max++;
        int temp = arr[i][j];
        arr[i][j]=100;
        dfs(i+1,j,k,arr);
        dfs(i,j+1,k,arr);
        //arr[i][j]=temp;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(38, 15, 9));
    }
}
