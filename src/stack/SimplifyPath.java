package stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
    }
    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String [] dirs = path.split("/");

        for (String dir: dirs) {
            if (dir.equals(".") || dir.isEmpty()) continue;
            else if (dir.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(dir);
            }
        }

        return "/" + String.join("/", st);
    }
}
