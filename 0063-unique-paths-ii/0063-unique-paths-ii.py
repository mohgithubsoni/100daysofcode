class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        dp = []
        m = len(obstacleGrid)  # rows
        n = len(obstacleGrid[0])  # columns

        for _ in range(m):
            dp.append([0] * n)

        if obstacleGrid[0][0] == 1:
            dp[0][0] = 0
        else:
            dp[0][0]=1

        for i in range(m):
            for j in range(n):
                if i == j == 0:
                    continue
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0
                    continue
                val = 0
                if i > 0:
                    val += dp[i - 1][j]
                if j > 0:
                    val += dp[i][j - 1]
                dp[i][j] = val
        return dp[m - 1][n - 1]