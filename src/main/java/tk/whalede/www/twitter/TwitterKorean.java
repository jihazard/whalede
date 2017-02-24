package tk.whalede.www.twitter;

import java.util.ArrayList;
import java.util.List;

import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer.KoreanToken;

import scala.collection.Seq;
import twitter4j.Status;

public class TwitterKorean {

	public static List<String> twitterkorean(List<Status> tweetpharse){
	    List<String> key=new ArrayList<String>();
	    /*String text = "꿈꿔또 나 귀신꿈꿔또ㅋㅋㅋㅋㅋ #한국어";
        List<List<KoreanTokenJava>> li=null;
	    // Normalize
	    CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
	    System.out.println(normalized);
	    // 한국어를 처리하는 예시입니다ㅋㅋ #한국어


	    // Tokenize
	    Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);
	    System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(tokens));
	   
	    // [한국어, 를, 처리, 하는, 예시, 입니, 다, ㅋㅋ, #한국어]
	    System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens));
	    // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하는(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 입니(Adjective: 12, 2), 다(Eomi: 14, 1), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]


	    // Stemming
	    Seq<KoreanTokenizer.KoreanToken> stemmed = TwitterKoreanProcessorJava.stem(tokens);
	    System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(stemmed));
	    // [한국어, 를, 처리, 하다, 예시, 이다, ㅋㅋ, #한국어]
	    System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(stemmed));
	    // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하다(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 이다(Adjective: 12, 3), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]
         
	    // Phrase extraction
	    List<KoreanPhraseExtractor.KoreanPhrase> phrases = TwitterKoreanProcessorJava.extractPhrases(tokens, true, true);
	     System.out.println(phrases);
	    // [한국어(Noun: 0, 3), 처리(Noun: 5, 2), 처리하는 예시(Noun: 5, 7), 예시(Noun: 10, 2), #한국어(Hashtag: 18, 4)]
*/   
	    
	    //전달받은 트위터 문장을 형태소 분석을 통해 단어화 시킴
	  for (Status status : tweetpharse) {
       	 System.out.println((String)status.getText());  
       	 CharSequence retext = TwitterKoreanProcessorJava.normalize(status.getText());
         Seq<KoreanTokenizer.KoreanToken> retokens = TwitterKoreanProcessorJava.tokenize(retext);
         Seq<KoreanTokenizer.KoreanToken> stemmed1 = TwitterKoreanProcessorJava.stem(retokens);  //단어화
         List<String> word= TwitterKoreanProcessorJava.tokensToJavaStringList(stemmed1);
         System.out.println(stemmed1.toString());
         key.add(word.toString()); //단어를 key list에 입력 
        
       }
	    	     
      System.out.println("단어화"+key);
      
	return key;
	
} 	
	
	
}
