package kopo.poly.controller;


import kopo.poly.dto.UserInfoDTO;
import kopo.poly.service.IUserInfoService;
import kopo.poly.util.CmmUtil;
import kopo.poly.util.EncryptUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Slf4j
@Controller
public class UserInfoController {

    private IUserInfoService userInfoService;

    @Autowired
    public void UserInfoService(IUserInfoService userInfoService) {this.userInfoService = userInfoService;}



     //--------------------------------------회원가입 페이지로 이동----------------------------

    @RequestMapping(value = "PRJ/userRegForm")
    public String userRegFrom(){
        log.info(this.getClass().getName() + ".user/userRegForm ok!");

        return "/PRJ/userRegForm";
    }


     //--------------------------- 회원가입 로직----------------------------------------

    @RequestMapping(value = "user/insertUserInfo",method = RequestMethod.POST)
    public String insertUserInfo (HttpServletRequest request, HttpServletResponse response,
                                  ModelMap model) throws Exception{

        log.info(this.getClass().getName() + ".insertUserInfo start!");

        String msg = "";

        UserInfoDTO pDTO = null;


        try{

            String user_id = CmmUtil.nvl(request.getParameter("user_id"));
            String password = CmmUtil.nvl(request.getParameter("password"));
            String email = CmmUtil.nvl(request.getParameter("email"));
            String address = CmmUtil.nvl(request.getParameter("address"));
            String user_phone = CmmUtil.nvl(request.getParameter("user_phone"));

            log.info("user_id :" + user_id);
            log.info("password :" + password);
            log.info("email :" + email);
            log.info("address :" + address);
            log.info("user_phone :" + user_phone);

            pDTO = new UserInfoDTO();

            pDTO.setUser_id(user_id);
            pDTO.setPassword(EncryptUtil.encHashSHA256(password));
            pDTO.setEmail(EncryptUtil.encAES128CBC(email));
            pDTO.setAddress(address);
            pDTO.setUser_phone(user_phone);

            int res = userInfoService.insertUserInfo(pDTO);

            if (res==1){
                msg = "회원가입 되었습니다";
            }else if(res==2) {
                msg = "이미 가입된 이메일 주소입니다";
            }else{
                msg = "오류로 인해 회원가입이 실패하였습니다";
            }

        }catch (Exception e){
            //저장 시류ㅐ시 사용자에게 보여줄 메시지
            msg = "실패하였습니다 : " + e.toString();
            log.info(e.toString());
            e.printStackTrace();

        }finally {
            log.info(this.getClass().getName() + ".insertUserInfo end!");

            model.addAttribute("msg", msg);

            model.addAttribute("pDTO", pDTO);

            pDTO = null;
        }

        return "/PRJ/PRJLogin";
    }

    //---------------------로그인을 위한 입력 화면으로 이동-----------------------
    @RequestMapping(value = "PRJ/loginForm")
    public String loginForm(){
        log.info(this.getClass().getName() + ".user/loginForm ko!");

        return "/PRJ/PRJLogin";
    }


    //-------------------------로그인 처리 및 결과 알려주는 화면-------------------------
    @PostMapping(value = "PRJ/getUserLoginCheck")
    public String getUserLoginCheck(HttpSession session, HttpServletRequest request, HttpServletResponse response,
                                    ModelMap model) throws Exception{
        log.info(this.getClass().getName() + ".getUserLoginCheck start!");

        String msg = "";
        String url = "";

        try{

            String user_id = CmmUtil.nvl(request.getParameter("user_id"));
            String password = CmmUtil.nvl(request.getParameter("password"));

            log.info("user_id : " + user_id);
            log.info("password : " + password);

            UserInfoDTO pDTO = new UserInfoDTO();

            pDTO.setUser_id(user_id);
            pDTO.setPassword(EncryptUtil.encHashSHA256(password));

            UserInfoDTO rDTO = userInfoService.getUserLoginCheck(pDTO);

            if (rDTO == null){
                rDTO = new UserInfoDTO();
                msg = "아이디 / 비밀번호를 확인해주세요";
                url = "/PRJ/loginForm";
            }else {
                msg = "로그인 성공";
                url = "/PRJmain";
                
                //session에 저장
                session.setAttribute("SS_USER_ID", rDTO.getUser_id());
                session.setAttribute("SS_USER_SEQ", rDTO.getUser_seq());

                log.info("SS_USER_ID : " + rDTO.getUser_id());
                log.info("SS_USER_SEQ : " + rDTO.getUser_seq());
            }
            rDTO = null;

        }catch (Exception e){
            msg = "실패하였습니다 :" + e.toString();
            System.out.println("오류로 인해 로그인이 실패하였습니다");
            log.info(e.toString());
            e.printStackTrace();
        }finally {
            log.info(this.getClass().getName() + "insertUser end!");
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
        }
        return "/redirect";
    }

    @RequestMapping(value = "PRJ/Logout") // 로그아웃
    public String Logout(HttpServletRequest request, ModelMap model) {
        log.info(this.getClass().getName() + ".Logout start!");
        HttpSession session = request.getSession();

        String url = "/PRJ/loginForm";
        String msg = "로그아웃 성공";
        session.invalidate(); // session clear
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        return "/redirect";
    }

    @RequestMapping(value = "/PRJ/myPage")
    public String MyPage(){
        return "/PRJ/myPage1";
    }

    @RequestMapping(value = "/PRJ/myPage2")
    public String MyPage2(){
        return "/PRJ/myPage2";
    }

    @RequestMapping(value = "/PRJ/myPage3")
    public String MyPage3(){
        return "/PRJ/myPage3";
    }

}
