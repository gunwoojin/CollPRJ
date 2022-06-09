package kopo.poly.controller;

import kopo.poly.dto.UserInfoDTO;
import kopo.poly.service.IUserInfoService;
import kopo.poly.util.CmmUtil;
import kopo.poly.util.EncryptUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        String url = "";

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
                url = "/PRJ/loginForm";
            }else if(res==2) {
                msg = "이미 가입된 이메일 주소입니다";
                url = "/PRJ/userRegForm";
            }else{
                msg = "오류로 인해 회원가입이 실패하였습니다";
                url = "/PRJ/userRegForm";
            }

        }catch (Exception e){
            //저장 시류ㅐ시 사용자에게 보여줄 메시지
            msg = "실패하였습니다 : " + e.toString();
            log.info(e.toString());
            e.printStackTrace();

        }finally {
            log.info(this.getClass().getName() + ".insertUserInfo end!");

            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            model.addAttribute("pDTO", pDTO);

            pDTO = null;
        }

        return "/redirect";
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
            String email = CmmUtil.nvl(request.getParameter("email"));
            String user_phone = CmmUtil.nvl(request.getParameter("user_phone"));
            String address = CmmUtil.nvl(request.getParameter("address"));

            log.info("user_id : " + user_id);
            log.info("password : " + password);

            UserInfoDTO pDTO = new UserInfoDTO();

            pDTO.setUser_id(user_id);
            pDTO.setPassword(EncryptUtil.encHashSHA256(password));
            pDTO.setEmail(email);
            pDTO.setUser_phone(user_phone);
            pDTO.setAddress(address);

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
                session.setAttribute("SS_USER_PHONE",rDTO.getUser_phone());
                session.setAttribute("SS_ADDRESS",rDTO.getAddress());

                log.info("SS_USER_ID : " + rDTO.getUser_id());
                log.info("SS_USER_SEQ : " + rDTO.getUser_seq());
                log.info("SS_USER_PHONE :" + rDTO.getUser_phone());
                log.info("SS_ADDRESS :" + rDTO.getAddress());
            }
            rDTO = null;

        }catch (Exception e){
            msg = "실패하였습니다 :" + e.toString();
            System.out.println("오류로 인해 로그인이 실패하였습니다");
            log.info(e.toString());
            e.printStackTrace();
        }finally {
            log.info(this.getClass().getName() + ".insertUser end!");
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
        }
        return "/redirect";
    }

    //-----------------------로그아웃--------------------------
    @RequestMapping(value = "PRJ/Logout")
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


    //----------------------회원탈퇴-----------------------------------
    @GetMapping(value = "PRJ/deleteUser")
    public String deleteUser(HttpSession session, HttpServletResponse response,HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName() + ".deleteUser start!");

        String msg = "";
        String url = "";

        try {

//            String user_seq = CmmUtil.nvl(request.getParameter("user_seq"));
            String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));


            log.info("user_id :" + user_id);

            UserInfoDTO pDTO = new UserInfoDTO();
            pDTO.setUser_id(user_id);

            int res= userInfoService.deleteUser(pDTO);

            log.info("res  :" + res);
            msg = "회원탈퇴에 성공하였습니다";
            url = "/PRJ/loginForm";

            session.invalidate(); // session clear


        } catch (Exception e) {
            msg = "회원탈퇴 실패 : " + e.getMessage();
            url = "/PRJmain";
            log.info(e.toString());
            e.printStackTrace();
        } finally {
            log.info(this.getClass().getName() + ".deleteUser end!");

            model.addAttribute("msg", msg);
            model.addAttribute("url", url);


        }

        return "/redirect";
    }

    //-----------------회원정보 보기---------------
    @RequestMapping(value = "/PRJ/myPage")
    public String MyPage(){
        return "/PRJ/myPage1";
    }


    //--------------------예약내역 보기----------------
    @RequestMapping(value = "/PRJ/myPage2")
    public String MyPage2(){
        return "/PRJ/myPage2";
    }


    //-------------------공유내역 보기------------------
    @RequestMapping(value = "/PRJ/myPage3")
    public String MyPage3(){return "PRJ/myPage3";}


    //----------------회원정보 수정으로 이동--------------
    @RequestMapping(value = "/PRJ/updateUserMove")
    public String updateUserMove(HttpSession session, HttpServletRequest request, ModelMap model)
    {return "/PRJ/updateUser";}


    //--------------------회원정보 수정----------------
    @RequestMapping(value = "PRJ/updateUser")
    public String updateUser(HttpSession session, HttpServletRequest request, ModelMap model) {

        log.info(this.getClass().getName() + ".userUpdate start!");

        String msg = "";
        String url = "";

        try {

            String user_seq = CmmUtil.nvl(request.getParameter("user_seq"));
            String address = CmmUtil.nvl(request.getParameter("address"));
            String user_phone = CmmUtil.nvl(request.getParameter("user_phone"));


            log.info("user_seq:" + user_seq);
            log.info("address:" + address);
            log.info("user_phone:" + user_phone);

            UserInfoDTO pDTO = new UserInfoDTO();

            pDTO.setUser_seq(user_seq);
            pDTO.setAddress(address);
            pDTO.setUser_phone(user_phone);

            userInfoService.updateUser(pDTO);

            msg = "수정되었습니다";
            url = "/PRJ/myPage";

            session.setAttribute("SS_USER_PHONE",pDTO.getUser_phone());
            session.setAttribute("SS_ADDRESS",pDTO.getAddress());
        }catch (Exception e){

            msg = "수정 실패";
            url = "/PRJ/myPage";
            log.info("수정 실패" + e.getMessage());
            e.printStackTrace();
        }finally {
            log.info(this.getClass().getName() + ".UserUpdate end");

            model.addAttribute("msg",msg);
            model.addAttribute("url",url);
        }

        log.info("url:" + url);

        return "/redirect";}




}
