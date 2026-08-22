class Twitter {

    static class Tweet {
        int tweetId;
        int userId;
        int time;

        Tweet(int tweetId, int userId, int time) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.time = time;
        }
    }

    List<Tweet> tweets;
    Map<Integer, List<Integer>> followMap;
    int curr = 0;

    public Twitter() {
        tweets = new ArrayList<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        curr++;
        tweets.add(new Tweet(tweetId, userId, curr));
    }

    public List<Integer> getNewsFeed(int userId) {

        Set<Integer> users = new HashSet<>();

        // User's own tweets
        users.add(userId);

        // Users they follow
        if (followMap.containsKey(userId)) {
            users.addAll(followMap.get(userId));
        }

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> b.time - a.time);

        // Only consider tweets from relevant users
        for (Tweet tweet : tweets) {
            if (users.contains(tweet.userId)) {
                pq.offer(tweet);
            }
        }

        List<Integer> news = new ArrayList<>();

        while (!pq.isEmpty() && news.size() < 10) {
            news.add(pq.poll().tweetId);
        }

        return news;
    }
public void follow(int followerId, int followeeId) {
    if (followerId == followeeId) {
        return;
    }

    followMap.putIfAbsent(followerId, new ArrayList<>());

    if (!followMap.get(followerId).contains(followeeId)) {
        followMap.get(followerId).add(followeeId);
    }
}


    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId)
                     .remove(Integer.valueOf(followeeId));
        }
    }
}
