package com.terryx.leecode.contest38;

import java.util.HashMap;

/**
 * @author taoranxue on 6/24/17 10:27 PM.
 */
public class Solution631 {
    public static class Excel {
        private int[][] table;
        private HashMap<Integer, String[]> map;

        public Excel(int H, char W) {
            table = new int[H][W - 'A' + 1];
            map = new HashMap<>();
        }

        public void set(int r, char c, int v) {
            table[r - 1][c - 'A'] = v;
            int _key = ((r - 1) << 8) + (c - 'A');
            if (map.containsKey(_key)) {
                map.remove(_key);
            }
            for (int key : map.keySet()) {
                int _r = (key >> 8) + 1;
                int _c = (key & (0xFF)) + 'A';
                sum(_r, (char) _c, map.get(key));
            }
        }

        public int get(int r, char c) {
            return table[r - 1][c - 'A'];
        }

        public int sum(int r, char c, String[] strs) {
            int _r = r - 1;
            int _c = c - 'A';
            int res = 0;
            for (String token : strs) {
                String[] cells = token.split(":");
                if (cells.length > 1) {
                    // A1:B2
                    int key1 = getKey(cells[0]);
                    int key2 = getKey(cells[1]);
                    int __r1 = key1 >> 8;
                    int __c1 = key1 & (0xFF);
                    int __r2 = key2 >> 8;
                    int __c2 = key2 & (0xFF);
                    System.out.println(token + " " + __r1 + "," + __c1 + ";" + __r2 + "," + __c2);
                    for (int i = __r1; i <= __r2; ++i) {
                        for (int j = __c1; j <= __c2; ++j) {
                            res += table[i][j];
                        }
                    }

                } else {
                    // A1
                    String cell = cells[0];
                    int key = getKey(cell);
                    int __r = key >> 8;
                    int __c = key & (0xFF);
                    res += table[__r][__c];
                }
            }
            map.put((_r << 8) + _c, strs);
            table[_r][_c] = res;
            return res;
        }

        private int getKey(String cell) {
            int r = 0;
            int c = cell.charAt(0) - 'A';
            for (int i = 1; i < cell.length(); ++i) {
                r = r * 10 + cell.charAt(i) - '0';
            }
            r--;
            return (r << 8) + c;
        }
    }

    public static void main(String args[]) {
// ["Excel","set","set","set","sum","get","set","get","sum","set","get","get","sum","set","get","get","get","get"]
// [5,"E"],
// [1,"A",5],
// [1,"B",3],
// [1,"C",2],
// [1,"C",["A1","A1:B1"]],
// [1,"C"],
// [1,"B",5],
// [1,"C"],
// [1,"B",["A1:A5"]],
// [5,"A",10],
// [1,"B"],
// [1,"C"],
// [3,"C",["A1:C1","A1:A5"]],
// [3,"A",3],
// [1,"B"],
// [1,"C"],
// [3,"C"],
// [5,"A"]]
        Excel excel = new Excel(5, 'E');
        excel.set(1, 'A', 5);
        excel.set(1, 'B', 5);
        excel.set(1, 'C', 2);
        System.out.println(excel.sum(1, 'C', new String[]{"A1", "A1:B1"}));
        System.out.println(excel.get(1, 'C'));
        excel.set(1, 'B', 5);
        System.out.println(excel.get(1, 'C'));
        System.out.println(excel.sum(1, 'B', new String[]{"A1:A5"}));
        excel.set(5, 'A', 10);
        System.out.println(excel.get(1, 'B'));
        System.out.println(excel.get(1, 'C'));
        System.out.println(excel.sum(3, 'C', new String[]{"A1:C1", "A1:A5"}));
        excel.set(3, 'A', 3);
        System.out.println(excel.get(1, 'B'));
        System.out.println(excel.get(1, 'C'));
        System.out.println(excel.get(3, 'C'));
        System.out.println(excel.get(5, 'A'));

    }
}
