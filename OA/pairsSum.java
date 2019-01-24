int pairsSum(int[] a) {
    int result = 0;
    
    if (a == null || a.length < 1) {
        return result;
    }
    
    Arrays.sort(a);
    
    List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
    
    for (int i = 0; i < a.length; i++) {
        for (int j = i; j < a.length; j++) {
            if (j != i && list.contains(a[i] + a[j])) {
                result++;
            }
        }
    }
    
    
    return result;
}
