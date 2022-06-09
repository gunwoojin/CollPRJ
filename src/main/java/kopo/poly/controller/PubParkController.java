package kopo.poly.controller;


import kopo.poly.dto.PubParkDTO;

import kopo.poly.service.IPubParkService;
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
public class PubParkController {

    // Map 객체를 사용한 데이터 처리
    @Resource(name = "PubParkService")
    private IPubParkService pubParkService;



    @RequestMapping(value = "PRJ/PubPark")
    public String showPubPark(HttpSession session, HttpServletRequest request, HttpServletResponse response,
                           ModelMap model) throws Exception {

        List<PubParkDTO> rList = new ArrayList<>();

        log.info(this.getClass().getName() + "start@@");

        StringBuilder urlBuilder = new StringBuilder("http://211.252.37.224/rest/parking"); /*URL*/

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
        JSONArray result2= (JSONArray) result.get("parkingInfoList");

        log.info(String.valueOf(result2));



       for (int i =0;i<result2.size();i++) {

            JSONObject pubpark = (JSONObject) result2.get(i);
            String parkingName = String.valueOf(pubpark.get("parkingName"));  //주차장이름
            String operationRuleNm = String.valueOf(pubpark.get("operationRuleNm")); //공영인지 민영인지확인
            String addrRoad = (String) pubpark.get("addrRoad"); //도로명 주소
            String payYn = (String) pubpark.get("payYn"); //유무료 금액확인
            String lat = (String) pubpark.get("lat"); // X좌표
            String lng = (String) pubpark.get("lng"); // Y 좌표





            log.info("parkingName :"+parkingName);
            log.info("operationRuleNm : "+ operationRuleNm);
            log.info("addrRoad : "+ addrRoad);
            log.info("payYn : "+ payYn);
            log.info("lat : "+ lat);
            log.info("lng : "+ lng);



            PubParkDTO pDTO = new PubParkDTO();



            pDTO.setParkingName(parkingName);
            pDTO.setOperationRuleNm(operationRuleNm);
            pDTO.setAddrRoad(addrRoad);
            pDTO.setPayYn(payYn);
            pDTO.setLat(lat);
            pDTO.setLng(lng);



            rList.add(pDTO);





        }

       int res = pubParkService.insertPubPark(rList);

       log.info(this.getClass().getName()+"res : "+res);  //res가 1이면 저장완료

        log.info(this.getClass().getName()+"공영주차장 DB insert End!!! ");

        return "PubPark/pubparkmap";
    }



}


