package com.terryx.leecode.weeklycontest.contest57;

import java.util.*;

/**
 * @author taoranxue on 1/31/18 7:24 PM.
 */
public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return accounts;
        }
        int parent[] = new int[10010], rank[] = new int[10010];
        //Arrays.fill(parent, 0);
        int emailIdx = 0;
        Map<String, Integer> emailMap = new HashMap<>();
        Map<Integer, String> nameMap = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); ++i) {
                String email = account.get(i);
                if (!emailMap.containsKey(email)) {
                    int id = emailIdx++;
                    emailMap.put(email, id);
                    parent[id] = id;
                }
                unite(emailMap.get(account.get(1)), emailMap.get(email), parent, rank);
            }
            if (account.size() > 1) {
                nameMap.put(find(emailMap.get(account.get(1)), parent), name);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Integer nameId : nameMap.keySet()) {
            TreeSet<String> tmp = new TreeSet<>();
            for (String email : emailMap.keySet()) {
                int emailId = emailMap.get(email);
                if (find(emailId, parent) == nameId) {
                    tmp.add(email);
                }
            }
            if (!tmp.isEmpty()) {
                List<String> l = new ArrayList<>();
                l.add(nameMap.get(nameId));
                l.addAll(tmp);
                res.add(l);
            }

        }
        return res;
    }

    private int find(int x, int parent[]) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    private void unite(int x, int y, int parent[], int rank[]) {
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) {
            return;
        }
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        }
    }

    //[["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
    // ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
    public static void main(String[] args) {
        Solution721 m = new Solution721();
        List<List<String>> list = new ArrayList<>();
//        list.add(Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"));
//        list.add(Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"));
//        list.add(Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"));
//        list.add(Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"));
//        list.add(Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"));

        list.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        list.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        list.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        list.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        list.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));
        System.out.println(m.accountsMerge(list));
    }

}
