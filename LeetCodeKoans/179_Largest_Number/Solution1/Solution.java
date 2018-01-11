public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null) {
            return null;
        }
        
        if(nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        
        //String[] values = Arrays.Stream(nums).sorted().mapToObj(String::valueOf).toArray(String[]::new);
        String[] values = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            values[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comparator = new Comparator<String>(){
            @Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
        };
        
        Arrays.sort(values, comparator);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < nums.length; i++) {
            sb.append(values[i]);
        }
        
        if(values[0].charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
            
        /*
        Integer[] what = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
        
        Arrays.sort(what, Collections.reverseOrder());
        
        int[] numsN = Arrays.stream(what).mapToInt(Integer::intValue).toArray();
        
        String origin = String.valueOf(numsN[0]);
        
        for(int i = 1; i < numsN.length; i++) {
            String a = String.valueOf(numsN[i]);
            
            if((a+origin).compareTo(origin+a) >= 0) {
                origin = a + origin;
            } else {
                origin = origin + a;
            }
        }
        
        if(origin.charAt(0) == '0') {
            return String.valueOf(0);
        }
        
        return origin;
        */
    }
}
