package graphs;

import java.util.List;
import java.util.Stack;

public class KeysandRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean [] vis = new boolean[rooms.size()];

        vis[0] = true;
        Stack<Integer> st = new Stack<>();
        st.add(0);

        while (!st.isEmpty()) {
            Integer room = st.pop();

            for (Integer r: rooms.get(room)) {
                if (!vis[r]) {
                    vis[r] = true;
                    st.add(r);
                }
            }
        }
        
        for (boolean room: vis) {
            if (!room) {
                return false;
            }
        }

        return true;
    }

}
