package com.terryx.leecode.weeklycontest.contest39;

import java.util.*;

/**
 * @author taoranxue on 7/1/17 9:36 PM.
 */
public class Solution635 {
    public class LogSystem {
        HashMap<Integer, String> map;

        public LogSystem() {
            map = new HashMap<>();
        }

        public void put(int id, String timestamp) {
            map.put(id, timestamp);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            String st = "0000:00:00:00:00:00";
            String ed = "9999:12:31:59:59:59";
            String start = "", end = "";
            switch (gra) {
                case "Year":
                    start = s.substring(0, 4) + st.substring(4);
                    end = e.substring(0, 4) + ed.substring(4);
                    break;
                case "Month":
                    start = s.substring(0, 7) + st.substring(7);
                    end = e.substring(0, 7) + ed.substring(7);
                    break;
                case "Day":
                    start = s.substring(0, 10) + st.substring(10);
                    end = e.substring(0, 10) + ed.substring(10);
                    break;
                case "Hour":
                    start = s.substring(0, 13) + st.substring(13);
                    end = e.substring(0, 13) + ed.substring(13);
                    break;
                case "Minute":
                    start = s.substring(0, 16) + st.substring(16);
                    end = e.substring(0, 16) + ed.substring(16);
                    break;
                case "Second":
                    start = s.substring(0, 19) + st.substring(19);
                    end = e.substring(0, 19) + ed.substring(19);
                    break;
            }
            List<Integer> res = new ArrayList<>();
            for (Integer id : map.keySet()) {
                if (start.compareTo(map.get(id)) <= 0 && end.compareTo(map.get(id)) >= 0) {
                    res.add(id);
                }
            }
            return res;
        }
    }
}
