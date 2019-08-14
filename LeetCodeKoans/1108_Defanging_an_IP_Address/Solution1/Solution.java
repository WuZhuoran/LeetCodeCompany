class Solution {
    public String defangIPaddr(String address) {
        String[] parts = address.split("\\.");
        return new String(parts[0] + "[.]" + parts[1] + "[.]" + parts[2] + "[.]" + parts[3]);
    }
}