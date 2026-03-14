package strings;

public class Base62 {
    public static void main(String[] args) {

        long id = 5669040L;

        final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        long temp = id;
        StringBuilder sb = new StringBuilder();
        while (temp > 0) {
            sb.append(BASE62.charAt((int) (temp % 62)));
            temp /= 62;
        }

        System.out.println(sb);
    }


}
