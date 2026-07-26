class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        int[] result =
                hm.entrySet()
                  .stream()
                  .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                  .limit(k)
                  .mapToInt(Map.Entry::getKey)
                  .toArray();

        return result;
        
    }
}
