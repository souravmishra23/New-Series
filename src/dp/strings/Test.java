package dp.strings;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        FastReader fr;
        PrintWriter out;

        File inFile = new File("input.txt");
        if (inFile.exists()) {
            fr = new FastReader(new FileInputStream(inFile));
            out = new PrintWriter(new FileOutputStream("output.txt"));
        } else {
            fr = new FastReader();
            out = new PrintWriter(System.out);
        }

        // Example usage:
        int a = fr.nextInt();
        int b = fr.nextInt();
        out.println(a + b);
         System.out.println("Hello World");
        out.flush();
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        double nextDouble() throws IOException { return Double.parseDouble(next()); }
        String nextLine() throws IOException { return br.readLine(); }
    }
}
    