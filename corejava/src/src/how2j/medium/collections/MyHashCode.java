package how2j.medium.collections;

public class MyHashCode {
    public static int hashcode(String s) {
        if (s.length() == 0) {
            return 0;
        }
        else {
            int sum = 0;
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                sum += c;
            }
            sum *= 23;
//            if (sum > 1999) {
//                sum = sum%2000;
//            }
//            if (sum < 0) {
//                sum = Math.abs(sum);
//            }
            sum  = sum < 0 ? 0-sum : sum;
            sum %= 2000;
            return sum;
        }


    }
    private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int length = (int) (Math.random()*8 +2);
            String str = randomString(length);
            int hashcode = hashcode(str);
            System.out.printf("%-11s's own hashcode is:%d%n", str, hashcode);
        }
    }

}
