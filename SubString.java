public class SubString {
    public static void main(String[] args) {
        String text = "abcbababccaabcabc";
        String substring = "ab";

        int count = text.split(substring, -1).length - 1;
        System.out.println("The substring '" + substring + "' appears " + count + " times.");
    }
}