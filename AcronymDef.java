import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class AcronymDef {
	HashMap<String, String> def = new HashMap<String, String>();
	String[] Mess;
	AcronymDef(String filename){
		readFile(filename);
	}
	public void readFile(String filename){
		try{
			BufferedReader getWords = new BufferedReader(new FileReader(filename));
			String word = getWords.readLine();
			while(word!=null){
				String curWord = word;
				word = getWords.readLine();
				word = getWords.readLine();
				String value = word;
				def.put(curWord, value);
				word = getWords.readLine();
				word = getWords.readLine();
			}
			getWords.close();
		}
		catch(IOException x){
			
		}
	}
	public String decipher(){
		String message="";
		for(int start=0;start<Mess.length;start++){
			message= message + checkAcronym(Mess[start]) + " ";
		}
		return message;
	}
	public String checkAcronym(String wor){
		String word = wor.toUpperCase();
		String realWord = word;
		for(int start=0;start<def.size();start++){
			if(def.containsKey(word)){
				realWord=def.get(word);
				break;
			}
		}
		return realWord;
	}
	public String[] breakMessage(String message){
		Mess = message.split(" ");
		return Mess;
	}
	public static void main(String[] args) {
		AcronymDef a = new AcronymDef("ArcDef");
		System.out.println(a.checkAcronym("lol"));
//		System.out.println(a.checkAcronym("wtf"));
//		System.out.println(a.checkAcronym("wtf"));
	}
}