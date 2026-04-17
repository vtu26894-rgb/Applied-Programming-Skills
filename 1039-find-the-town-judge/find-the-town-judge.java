class Solution {
    public int findJudge(int n, int[][] trust) {
        int matrix[][]=new int[n][n];
        for(int i=0;i<n;i++){
            matrix[i][i]=1;
        }
        for(int i=0;i<trust.length;i++){
            matrix[trust[i][0]-1][trust[i][1]-1]=1;
        }
        Stack<Integer> st=new Stack<>();
        for(int i=1;i<=n;i++){
            st.push(i);
        }
        while(st.size()>1){
            int a=st.pop();
            int b=st.pop();
            if(matrix[a-1][b-1]==1){
                st.push(b);
            }
            else{
                st.push(a);
            }
        }
        int council=st.pop();
        for(int i=0;i<n;i++){
            if(i==council-1){
                continue;
            }
            if(matrix[council-1][i]==1||matrix[i][council-1]==0){
                return -1;
            }
            
        }
        return council;
    }
}