package leetcode;
import java.util.*;

/**
 * Created by Taewoo Kim on 2/1/2017.
 * cool design problem that uses sorting linked lists
 * be careful of edge cases such as:
 * -following oneself, following someone you are already following,
 * unfollowing oneself, unfollowing someone you are not following,
 * having no newsfeed (null vs emtpy list?)
 * etc.
 */
class Twitter {
    private static int time;
    private Map<Integer, User> users;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        time = 0;
        users = new HashMap<>();
    }

    private class Tweet {
        int timeStamp;
        int tweetId;
        Tweet next;

        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.timeStamp = time++;
        }
    }

    private class User {
        int userId;
        Set<Integer> followees;//by userId
        //queue of tweets (linked list)
        Tweet tweets;

        User(int userId) {
            this.userId = userId;
            followees = new HashSet<>();
            followees.add(userId);//follow itself
        }
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)){
            users.put(userId, new User(userId));
        }
        User user = users.get(userId);
        //add new tweet to head of linked list of tweets of the user
        Tweet newTweet = new Tweet(tweetId);
        newTweet.next = user.tweets;
        user.tweets = newTweet;
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        User user = users.get(userId);
        if (user == null) return new ArrayList<>();

        //priority queue of tweets sorted descending by time
        Queue<Tweet> maxHeap = new PriorityQueue<Tweet>((a, b) -> b.timeStamp - a.timeStamp);

        //add all followees' tweets (includes own tweets)
        for (Integer followeeId : user.followees) {
            User followee = users.get(followeeId);
            if (followee != null && followee.tweets != null) {
                maxHeap.add(followee.tweets);
            }
        }

        List<Integer> news = new ArrayList<>();
        //get 10 most recent news
        for (int i = 0; i < 10; i++) {
            if (!maxHeap.isEmpty()) {
                Tweet top = maxHeap.remove();
                news.add(top.tweetId);
                if (top.next != null) maxHeap.add(top.next);
            }
        }

        return news;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        if (follower == null){
            follower = new User(followerId);
            users.put(followerId, follower);
        }
        if (followee == null){
            followee = new User(followeeId);
            users.put(followeeId, followee);
        }

        follower.followees.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        if (follower == null || followee == null || followerId == followeeId) return;

        if (follower.followees.contains(followeeId)) {
            follower.followees.remove(followeeId);
        }
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