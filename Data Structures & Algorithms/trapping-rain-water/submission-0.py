class Solution:
    def trap(self, height: List[int]) -> int:

        l = 0
        r = len(height) - 1

        l_m = 0
        r_m = 0

        water = 0

        while l < r:
            if height[l] <= height[r]:

                if height[l] >= l_m:
                    l_m = height[l]
                else:
                    water += l_m - height[l]

                l += 1

            else:

                if height[r] >= r_m:
                    r_m = height[r]
                else:
                    water += r_m - height[r]

                r -= 1

        return water