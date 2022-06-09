package kopo.poly.controller;


import kopo.poly.dto.CCTVDTO;

import kopo.poly.service.ICCTVService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
public class CCTVController {

    // Map 객체를 사용한 데이터 처리
    @Resource(name = "CCTVService")
    private ICCTVService cctvservice;


    @RequestMapping(value = "PRJ/CCTV")
    public String showCCTV(HttpSession session, HttpServletRequest request, HttpServletResponse response,
                           ModelMap model) throws Exception {

        List<CCTVDTO> rList = new ArrayList<>();

        log.info(this.getClass().getName() + "start@@");

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/3510500/illegal_parking_control_cctv/getList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=eOF6GnWVvldbBgvM8HdXTSg2a4ZjW6p90CAQUyGhEWDLEXWqJ6ZCW8VFscCnCbgfPxlbheQPn5zC1E5SP%2BzQOw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(default : 1)*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*페이지당수(default : 10)*/
        urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*JSON/XML(default : JSON)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        log.info("#####파싱한데이터########");
        log.info(sb.toString());

        JSONObject result = null;
        result = (JSONObject) new JSONParser().parse(sb.toString());
        //result.get("response");
        JSONObject result1 = (JSONObject) result.get("response");
        JSONObject result2 = (JSONObject) result1.get("body");
        JSONObject result3 = (JSONObject) result2.get("items");
        JSONArray result4 = (JSONArray) result3.get("item");

        log.info(String.valueOf(result1));
        log.info(String.valueOf(result2));
        log.info(String.valueOf(result3));
        log.info(String.valueOf(result4));

        for (int i =0;i<result4.size();i++) {



            JSONObject cctv = (JSONObject) result4.get(i);




            String no = String.valueOf(cctv.get("no"));
            String lot = String.valueOf(cctv.get("lot"));
            String addr = (String) cctv.get("ist_place");
            String data = (String) cctv.get("data_base_date");
            String lat = String.valueOf(cctv.get("lat"));

            log.info("no :"+no);
            log.info("lot : "+ lot);
            log.info("addr : "+ addr);
            log.info("data : "+ data);
            log.info("lat : "+ lat);



            CCTVDTO pDTO = new CCTVDTO();



            pDTO.setNo(no);
            pDTO.setAddr(addr);
            pDTO.setData(data);
            pDTO.setLat(lat);
            pDTO.setLot(lot);

            rList.add(pDTO);





        }
        int res = cctvservice.insertCCTV(rList);

        log.info(this.getClass().getName()+"res :"+res); //res가 1이면 저장 완료
        return "CCTV/test";
    }



}


