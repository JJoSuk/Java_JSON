package javatpc_project.project;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;
import java.net.URLEncoder;

public class Project01_D {
    public static void main(String[] args) {
//        String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode";
        String client_id = "8vdvnglhiu";
        String client_secret = "Wf7VI5JCHlXc7EqcN3IoiUu8bwcnkEqnoOnAJeAv";
        //             바이트 스트림                =            브릿지 스트림
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("주소를 입력하세요.");
            String address = io.readLine();
            String addr = URLEncoder.encode(address, "UTF-8");
            String reqUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr;

            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", client_id);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);
            BufferedReader br;

            int responseCode = conn.getResponseCode(); // 200
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String line;
            StringBuffer response = new StringBuffer(); // JSON
            while((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            JSONTokener tokener = new JSONTokener(response.toString());
            JSONObject object = new JSONObject(tokener);
            System.out.println(object.toString(2));

            JSONArray arr = object.getJSONArray("addresses");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject temp = (JSONObject) arr.get(i);
                System.out.println("address : " + temp.get("roadAddress"));
                System.out.println("jibunAddress : " + temp.get("jibunAddress"));
                System.out.println("경도 : " + temp.get("x"));
                System.out.println("위도 : " + temp.get("y"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
