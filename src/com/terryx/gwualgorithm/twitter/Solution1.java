package com.terryx.gwualgorithm.twitter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

/**
 * @author taoranxue on 10/27/16 3:40 PM.
 */
public class Solution1 {
    private static class Log implements Comparable<Log> {
        String url;
        int successCnt;
        int totalCnt;
        Date date;

        public Log(String url) {
            this.url = url;
            this.date = null;
            this.successCnt = 0;
        }

        public void addSuccessCnt() {
            this.successCnt++;
        }

        public void addTotalCnt() {
            this.totalCnt++;
        }

        public double getSuccessRate() {
            return (double) this.successCnt * 100.0 / this.totalCnt;
        }

        public void setDate(Date date) {
            if (this.date == null || date.compareTo(this.date) < 0) {
                this.date = date;
            }
        }

        @Override
        public int compareTo(Log other) {
            if (!this.date.equals(other.date))
                return this.date.compareTo(other.date);
            return this.url.compareTo(other.url);
        }
    }

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        Map<String, Log> map = new HashMap<>();
        while (in.hasNextLine()) {
            String str = in.nextLine();
            if (str.equals("")) break;
            String timePattern = "\\[(.*)\\]";
            String urlGETPattern = "GET\\s(.*)\\sHTTP/1.1\"";
            String urlPOSTPattern = "POST\\s(.*)\\sHTTP/1.1\"";
            String resPattern = "HTTP/1.1\"\\s(.*)\\s\"";

            Pattern timeRegex = Pattern.compile(timePattern);
            Pattern urlGETRegex = Pattern.compile(urlGETPattern);
            Pattern urlPOSTRegex = Pattern.compile(urlPOSTPattern);
            Pattern resRegex = Pattern.compile(resPattern);

            Matcher matcher = timeRegex.matcher(str);
            String timeStr = "";
            if (matcher.find()) {
                timeStr = matcher.group(1);
            }


            matcher = urlGETRegex.matcher(str);
            String urlStr = "";
            if (matcher.find()) {
                urlStr = matcher.group(1);
            }
            if (urlStr.equals("")) {
                matcher = urlPOSTRegex.matcher(str);
                if (matcher.find()) {
                    urlStr = matcher.group(1);
                }
            }
            if (urlStr.contains("?")) {
                urlStr = (urlStr.split("\\?"))[0];
            }

            String resStr = "";
            matcher = resRegex.matcher(str);
            if (matcher.find()) {
                resStr = matcher.group(1);
            }
            resStr = resStr.split(" ")[0];

            DateFormat df = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z");
            Date date = df.parse(timeStr);
            date.setSeconds(0);

            long time = date.getTime();
            String code = Long.toString(time) + urlStr;
            if (map.containsKey(code)) {
                Log log = map.get(code);
                log.addTotalCnt();
                log.setDate(date);
                if (!(resStr.contains("500") || resStr.contains("501") || resStr.contains("502") || resStr.contains("503") ||
                        resStr.contains("504") || resStr.contains("505") || resStr.contains("506") || resStr.contains("507") ||
                        resStr.contains("508") || resStr.contains("509"))) {
                    log.addSuccessCnt();
                }
            } else {
                Log log = new Log(urlStr);
                log.addTotalCnt();
                log.setDate(date);
                if (!(resStr.contains("500") || resStr.contains("501") || resStr.contains("502") || resStr.contains("503") ||
                        resStr.contains("504") || resStr.contains("505") || resStr.contains("506") || resStr.contains("507") ||
                        resStr.contains("508") || resStr.contains("509"))) {
                    log.addSuccessCnt();
                }
                map.put(code, log);
            }


        }

        List<Log> logList = new ArrayList<>();
        logList.addAll(map.values());
        Collections.sort(logList);

        DateFormat convertDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        convertDf.setTimeZone(TimeZone.getTimeZone("GMT"));
        for (Log l : logList) {
            System.out.format("%s %s %.2f\n", convertDf.format(l.date), l.url, l.getSuccessRate());
        }
    }

}
