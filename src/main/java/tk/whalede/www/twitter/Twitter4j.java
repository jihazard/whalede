package tk.whalede.www.twitter;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter4j {

	public static List<Status> twitter(String keyword){
	 ConfigurationBuilder cb1 = new ConfigurationBuilder();
	 ConfigurationBuilder cb = new ConfigurationBuilder();
     cb1.setDebugEnabled(true)
            .setOAuthConsumerKey("1iH9zEVk88hxhhBK8yENr8p5i")
            .setOAuthConsumerSecret("Dqavvun3kDkNj7LNauTavj4nKuio2GSwEqjJJxYlokjs0uAwpt")
            .setOAuthAccessToken("829895408281202689-UODSSQH8DpaWvuU9yfoP8NMsZyRyCBB")
            .setOAuthAccessTokenSecret("dK4sDHy4dFi7caxMK0MSNCnXAS3KDMLhYLviK3jH0DWdu");
     
     
     cb.setDebugEnabled(true)
     .setOAuthConsumerKey("VAhjGZ1uhI7D9kJXj1YAfyUly")
     .setOAuthConsumerSecret("FDMI9paVe3N9lWUjAKroMGIQKhP4k7pbRAfRBLuEq2f1Vr1IZ9")
     .setOAuthAccessToken("829895408281202689-rIOiZIoN17p4lqrtXjPtw0MvlaZ5weC")
     .setOAuthAccessTokenSecret("qLExKHucWdUUn5kGb1yucpziWmrcgY8bKEdpTgHxhSbUv");

      TwitterFactory tf = new TwitterFactory(cb.build());
      Twitter twitter = tf.getInstance();
	
      List<Status> tweets = new ArrayList<Status>();

	
	
	try {
		
	 
	
	//트위터 서치
	 
	 int wantedTweets = 100;
	 long lastSearchID = Long.MAX_VALUE;
	 int remainingTweets = wantedTweets;
	
 
	    Query query = new Query(keyword);
        while(remainingTweets > 0)
        {
          remainingTweets = wantedTweets - tweets.size();
          if(remainingTweets > 100)
          {
            query.count(100);
          }
          else
          {
           query.count(remainingTweets); 
          }
          QueryResult result = twitter.search(query);
          tweets.addAll(result.getTweets());
          Status s = tweets.get(tweets.size()-1);
          long firstQueryID = s.getId();
          query.setMaxId(firstQueryID);
          remainingTweets = wantedTweets - tweets.size();
        }
        
        for (Status status : tweets) {
        	 System.out.println(status.getText());
        	 	 
        }
        System.out.println("tweets.size() "+tweets.size() );   
      
	

				} catch (TwitterException te) {
				    te.printStackTrace();
				    System.out.println("Failed to send a direct message: " + te.getMessage());
				    System.exit(-1);


		}
		return tweets;
	
	
    }
}
