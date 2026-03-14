public class Test {
    public static void main(String[] args) {
        solve(new String [] {"F7", "TR", "F3", "TR", "TL", "TL", "F4", "U2", "F1", "TL", "F1"});


    }


    public static void solve(String[] arr) {
        int x = 0;
        int y = 0;
        String currShipDir = "R";

        for (String dir : arr) {

            if (dir.startsWith("F")) {
                int val = Integer.parseInt(dir.substring(1));
                switch (currShipDir) {
                    case "R" -> x += val;
                    case "L" -> x -= val;
                    case "U" -> y += val;
                    case "D" -> y -= val;
                }

            } else if (dir.startsWith("TR")) {
                currShipDir = getDirForTr(currShipDir);

            } else if (dir.startsWith("TL")) {
                currShipDir = getDirForTl(currShipDir);


            } else if (dir.startsWith("U")) {
                y += Integer.parseInt(dir.substring(1));

            } else if (dir.startsWith("D")) {
                y -= Integer.parseInt(dir.substring(1));

            } else if (dir.startsWith("R")) {
                x += Integer.parseInt(dir.substring(1));

            } else if (dir.startsWith("L")) {
                x -= Integer.parseInt(dir.substring(1));
            }
        }

        System.out.println(x);
        System.out.println(y);
    }

    private static String getDirForTl(String currShipDir) {
        return switch (currShipDir) {
            case "R" -> "U";
            case "U" -> "L";
            case "L" -> "D";
            case "D" -> "R";
            default -> currShipDir;
        };
    }

    private static String getDirForTr(String currShipDir) {
        return switch (currShipDir) {
            case "R" -> "D";
            case "D" -> "L";
            case "L" -> "U";
            case "U" -> "R";
            default -> currShipDir;
        };
    }

}
