package tk.whalede.www.whale.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;

import scala.collection.Seq;
import tk.whalede.www.kumo.Kumo;
import tk.whalede.www.twitter.Twitter4j;
import tk.whalede.www.twitter.TwitterKorean;
import twitter4j.Status;

@Controller
@RequestMapping(value="/whale")
public class whaleController {
	 Logger logger = Logger.getLogger(this.getClass());
		
	
	
	@RequestMapping(value="/index.do")
	public String index(){
		
		return "basic/main";
	}
	
	@ResponseBody
	@RequestMapping(value="/search.do")
	public String search(@RequestParam("keyword") String key , Model model ,HttpServletRequest request) throws IOException{
		String result="";
		logger.info("서치 호출"+key);
		String sid=request.getRequestedSessionId();
		logger.info("sid"+sid);
		String docRoot=request.getServletContext().getRealPath("");
		logger.info("위치 : "  +  docRoot);
		//키워드 확인 
		
		String keyw = key;

		if(keyw.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			System.out.println("한글");
			// 한글 검색어
			//1. 입력 받은 키워드로 트위터 서칭
			List<Status> keyword=Twitter4j.twitter(key);

			//2. 서칭한 문장을 단어화 함 
			List<String> rekeyword=TwitterKorean.twitterkorean(keyword);
			
			//3. 단어 리스트로 클라우드 만듬 
			result=Kumo.buildWordCloud(docRoot, rekeyword, key);
			System.out.println(result);
			
			
		} else {
			System.out.println("영어");
		// 영어 검색어
			List<String> list=new ArrayList<String>();
			//1. 입력 받은 키워드로 트위터 서칭
			List<Status> keyword=Twitter4j.twitter(key);
            //2 키워드 값을 list<string> 형으로 변환
			 for (Status status : keyword) {
		       	 
		       	 
		         	list.add(status.getText().toString()); //단어를 key list에 입력 
		        
		       }					
			//3. 단어 리스트로 클라우드 만듬 
			result=Kumo.buildWordCloud(docRoot, list, key);
			System.out.println(result);
		}
		
		
		
			
		
		
		
		
		model.addAttribute("result", result);
	
		
		return result;

	}
	
	
}
