package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/8/16 9:38 PM.
 */
public class Solution355 {
    public class Twitter {
        private static final int RECENT_NUMBER = 10;
        private int timestamp;
        private Map<Integer, User> userMap;

        private class User {
            int id;
            int time;
            Tweet tweetHead;
            Set<User> follows;

            public User(int id) {
                this.id = id;
                this.time = timestamp++;
                this.tweetHead = null;
                this.follows = new HashSet<>();
                this.follows.add(this);
            }

            public void post(int tweetId) {
                Tweet newTweet = new Tweet(tweetId);
                newTweet.next = this.tweetHead;
                this.tweetHead = newTweet;
            }

            public void follow(User followee) {
                if (followee == null)
                    follows.add(followee);
            }

            public void unfollow(User followee) {
                if (followee != null)
                    follows.remove(followee);
            }

        }

        private class Tweet {
            int id;
            int time;
            Tweet next;

            public Tweet(int id) {
                this.id = id;
                time = timestamp++;
                next = null;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            timestamp = 0;
            userMap = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new User(userId));
            }
            userMap.get(userId).post(tweetId);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> pq = new PriorityQueue<>(new Comparator<Tweet>() {
                @Override
                public int compare(Tweet p, Tweet q) {
                    if (p.time > q.time) return -1;
                    if (p.time == q.time) return 0;
                    return 1;
                }
            });

            List<Integer> res = new ArrayList<>();
            if (!userMap.containsKey(userId)) return res;
            Set<User> users = userMap.get(userId).follows;
            for (User user : users) {
                Tweet t = user.tweetHead;
                if (t != null) {
                    pq.offer(t);
                }
            }
            int cnt = 0;
            while (!pq.isEmpty() && cnt < RECENT_NUMBER) {
                Tweet tweet = pq.poll();
                cnt++;
                res.add(tweet.id);
                if (tweet.next != null) {
                    pq.offer(tweet.next);
                }
            }
            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId))
                userMap.put(followerId, new User(followerId));
            if (!userMap.containsKey(followeeId))
                userMap.put(followeeId, new User(followeeId));
            userMap.get(followerId).follow(userMap.get(followeeId));
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId) || followerId == followeeId) return;
            userMap.get(followerId).unfollow(userMap.get(followeeId));
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
