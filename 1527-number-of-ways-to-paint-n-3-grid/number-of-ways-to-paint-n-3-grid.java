class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        // Base cases for n = 1
        long aba = 6; // Pattern like Red-Yellow-Red
        long abc = 6; // Pattern like Red-Yellow-Green

        for (int i = 2; i <= n; i++) {
            long nextAba = (3 * aba + 2 * abc) % MOD;
            long nextAbc = (2 * aba + 2 * abc) % MOD;

            aba = nextAba;
            abc = nextAbc;
        }

        return (int) ((aba + abc) % MOD);
    }
}