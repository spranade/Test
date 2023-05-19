package ideas.saas;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Solution {
    /*
     * Complete the function below.
     */
	
	public static void main(String[] args) {
		System.out.println(getTopicCount("pizza"));
	}

    static int getTopicCount(String topic) {
        try{
        	StringBuilder stringBuilder = new StringBuilder("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=");
            stringBuilder.append(topic);
            URL obj = new URL(stringBuilder.toString());
            
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            //con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
                String textElement = jsonResponse.get("parse").getAsJsonObject().get("text").toString();//.replaceAll("\\<.*?\\>", "");
                
                int lastIndex = 0;
                int count = 0;
                while(lastIndex != -1){
                    lastIndex = textElement.indexOf(topic,lastIndex);
                    if(lastIndex != -1){
                        count ++;
                        lastIndex += topic.length();
                    }
                }
                
                return count;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}

