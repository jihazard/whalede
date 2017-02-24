package tk.whalede.www.kumo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.ui.Model;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;

public class Kumo {
	
		//WordCloud a=new WordCloud(null, null);
	
	
	   public static String buildWordCloud(String docroot,List<String> tweetword, String keyword) throws IOException {
	      
		   
		   final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
	        frequencyAnalyzer.setWordFrequenciesToReturn(300);
	        frequencyAnalyzer.setMinWordLength(2);
	        frequencyAnalyzer.setStopWords(loadStopWords());
	        FileOutputStream fos=null;
	       
	        //final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(getInputStream("text/datarank.txt"));
	        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(tweetword);
		       
	        final Dimension dimension = new Dimension(990, 618);
	        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
	        wordCloud.setPadding(2);
	        wordCloud.setBackground(new PixelBoundryBackground(getInputStream("backgrounds/whale.png")));
	        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
	        wordCloud.setFontScalar(new LinearFontScalar(20, 50));
	        wordCloud.build(wordFrequencies);
	        BufferedImage img=wordCloud.getBufferedImage();
	        System.out.println("리스트"+wordCloud);      
	        
	        
	        ImageIO.write(img, "png", new File(docroot+"/cloud_"+keyword+".png"));
	        String msg="제작완료";
	        System.out.println("제작완료");
	        System.out.println(docroot+"/cloud_"+keyword+".png");
	        String result="cloud_"+keyword+".png";
	        
	        return result;
	    }

	    private static InputStream getInputStream(final String path) {
	        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
	    }
	    private static Set<String> loadStopWords() {
	        try {
	            final List<String> lines = IOUtils.readLines(getInputStream("text/stop_words.txt"));
	            return new HashSet<String>(lines);

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return Collections.emptySet();
	    }
	
	
	
  }
