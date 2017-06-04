package com.terryx.leecode.contest35;

import java.util.Stack;

/**
 * @author taoranxue on 6/3/17 10:19 PM.
 */

public class Solution591 {
    String code;
    int p;

    public boolean isTag() {
        try {
            System.out.println("tag");
            if (code.charAt(p++) != '<') return false;
            StringBuilder tagName = new StringBuilder();
            while (p < code.length() && Character.isUpperCase(code.charAt(p))) {
                tagName.append(code.charAt(p++));
            }
            if (code.charAt(p++) != '>') return false;
            isContent();
            if (code.charAt(p++) != '<') return false;
            if (code.charAt(p++) != '/') return false;
            StringBuilder _tagName = new StringBuilder();
            while (p < code.length() && Character.isUpperCase(code.charAt(p))) {
                _tagName.append(code.charAt(p++));
            }
            if (!tagName.equals(_tagName))
                return false;
            if (code.charAt(p++) != '>') return false;
            return true;
        } catch (Exception e) {
            System.out.println("E in tag!");
            return false;
        }
    }

    public boolean isCdata() {
        try {
            System.out.println("cdata");
            int q = code.substring(p).indexOf("<![CDATA[");
            System.out.println("[[[[[[[[[" + q);
            if (q != p) {
                System.out.println("aaaa");
                return false;
            }
            p += 9;
            q = code.substring(p).indexOf("]]>");
            if (q == -1) return false;
            p = q + 3;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void isContent() {
        System.out.println("content");
        while (p < code.length()) {
            if (code.charAt(p) != '<') ++p;
            else {
                int q = p;
                if (isTag()) {
                    p = q;
                    return;
                } else if (isCdata()) {
                    p = q;
                    return;
                } else {
                    break;
                }
            }
        }
    }

    public boolean isValid(String code) {
        this.code = code;
        this.p = 0;
        return isTag();
    }
}