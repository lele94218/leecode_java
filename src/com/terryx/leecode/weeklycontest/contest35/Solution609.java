package com.terryx.leecode.weeklycontest.contest35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoranxue on 6/3/17 9:54 PM.
 */
public class Solution609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; ++ i) {
            String[] files = paths[i].split(" ");
            for (int j = 1; j < files.length; ++ j) {
                String[] names = files[j].split("\\(");
                String filename = names[0];
                String content = names[1];

                content = content.substring(0, content.length() - 1);
                if (map.containsKey(content)) {
                    List<String> tmp = map.get(content);
                    tmp.add(files[0] + "/" + filename);
                } else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(files[0] + "/" + filename);
                    map.put(content, tmp);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry e : map.entrySet()) {
            List<String> tmp = (List<String>)e.getValue();
            if (tmp.size() > 1) {
                res.add(new ArrayList<>(tmp));
            }
        }

        return res;


    }
}
