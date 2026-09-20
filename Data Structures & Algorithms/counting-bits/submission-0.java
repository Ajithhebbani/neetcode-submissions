class Solution {
    public int[] countBits(int n) {
        int[] op = new int[n + 1];

        for(int i = 1; i <= n; i++){
            op[i] = op[i & (i - 1)] + 1;
        }
        return op;
    }
}
