package kopo.poly.controller;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;
import kopo.poly.dto.ImgDTO;
import kopo.poly.dto.ShareDTO;
import kopo.poly.service.IShareService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ShareController {

    @Resource(name = "ShareService")
    private IShareService shareService;


    //-------주차장 등록페이지로 이동-------
    @RequestMapping(value = "/Share/RegPark")
    public String ShareRegPark(HttpSession session, HttpServletRequest request)
    {
        return "/Share/RegTest";
    }



   /* @PostMapping(value = "/Share/insertRegPark")
    public String ShareInsert(HttpSession session, HttpServletRequest request, ModelMap model){

        log.info(this.getClass().getName() + ".ShareInsert start");

        String url = "";

        String msg = "";

        ShareDTO pDTO = null;


        try{

            String reg_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));
            String sp_title = CmmUtil.nvl(request.getParameter("sp_title"));
            String sp_contents = CmmUtil.nvl(request.getParameter("sp_contents"));
            String start_time = CmmUtil.nvl(request.getParameter("start_time"));
            String end_time = CmmUtil.nvl(request.getParameter("end_time"));
            String sp_place = CmmUtil.nvl(request.getParameter("sp_place"));


            log.info("sp_title :" + sp_title);
            log.info("sp_contents :" + sp_contents);
            log.info("start_time :" + start_time);
            log.info("end_time :" + end_time);
            log.info("sp_place :" + sp_place);


            pDTO = new ShareDTO();

            pDTO.setSp_title(sp_title);
            pDTO.setSp_contents(sp_contents);
            pDTO.setStart_time(start_time);
            pDTO.setEnd_time(end_time);
            pDTO.setSp_place(sp_place);

            int res = shareService.InsertShare(pDTO);

            log.info("res :" + res);

            url = "/PRJmain";
            msg = "등록되었습니다";

        } catch (Exception e) {

            url = "/Share/RegPark";
            msg = "등록실패 : " +e.getMessage();
            log.info(e.toString());
            e.printStackTrace();
        }finally {
            log.info(this.getClass().getName() + ".ShareInsert end");

            model.addAttribute("url", url);
            model.addAttribute("msg", msg);
            model.addAttribute("pDTO", pDTO);

            pDTO = null;
        }

        return "/redirect";
    }
*/


//-----공유내역 보기------
    @GetMapping(value = "PRJ/myPage3")
    public String ShareList(HttpSession session, HttpServletRequest request, ModelMap model) throws Exception {


        log.info(this.getClass().getName() + ".ShareList start");

        String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));

        List<ShareDTO> rList = shareService.getShareList(user_id);

        if (rList == null){
            rList = new ArrayList<>();
        }

        model.addAttribute("rList", rList);


        log.info("rList" + rList);


        log.info(this.getClass().getName() + "ShareList end");

        return "/PRJ/myPage3";
    }


    @GetMapping(value = "spMap_test")
    public String test(HttpSession session, HttpServletRequest request, ModelMap model) throws Exception{

        log.info(this.getClass().getName() + ".ShareListAll start");

        List<ShareDTO> rList = shareService.getShareListAll();

        if (rList == null){
            rList = new ArrayList<>();
        }

        model.addAttribute("rList", rList);

        log.info("### list : {}", rList.get(0));
        log.info("### list : {}", rList.get(1));

        log.info("rList :" + rList);

        log.info(this.getClass().getName() + ".ShareListALl end");

        return "/PRJ/spMap";

    }




    @GetMapping(value = "share/ParkInfo")
    public String ParkInfo(HttpServletRequest request, ModelMap model, HttpSession session){

        log.info(this.getClass().getName() + ".ParkInfo start!");

        String msg="";

        try{

            String sSeq = CmmUtil.nvl(request.getParameter("sSeq"));

            log.info("sSeq :" + sSeq);

            ShareDTO pDTO = new ShareDTO();
            pDTO.setSp_seq(sSeq);


            ShareDTO rDTO = shareService.getParkInfo(pDTO);
            rDTO.setSp_seq(sSeq);

            if (rDTO == null){
                rDTO = new ShareDTO();
            }

            log.info("rDTO222 : " + rDTO.getSp_place());

            log.info(this.getClass().getName() + ".getParkInfo success");

            model.addAttribute("rDTO", rDTO);

        }catch (Exception e){

            msg = "fail :" +e.getMessage();
            log.info(e.toString());
            e.printStackTrace();

        }finally {
            log.info(this.getClass().getName() + ".ParkInfo end");

            return "Share/ParkInfo";
        }
    }


    @PostMapping(value = "share/ParkUpdate")
    public String ParkUpdate(HttpSession session, HttpServletRequest request, ModelMap model){

        log.info(this.getClass().getName() + "Parkupdate start");

        String msg = "";
        String url = "";

        try {
            String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));
            String sSeq = CmmUtil.nvl(request.getParameter("sSeq"));
            String sp_title = CmmUtil.nvl(request.getParameter("sp_title"));
            String sp_contents = CmmUtil.nvl(request.getParameter("sp_contents"));
            String start_time = CmmUtil.nvl(request.getParameter("start_time"));
            String end_time = CmmUtil.nvl(request.getParameter("end_time"));
            String sp_place = CmmUtil.nvl(request.getParameter("sp_place"));

            log.info("user_id :" + user_id);
            log.info("sSeq :" + sSeq);
            log.info("sp_title :" + sp_title);
            log.info("sp_contents : " + sp_contents);
            log.info("start_time: " + start_time);
            log.info("end_time : " + end_time);
            log.info("sp_place: " + sp_place);

            ShareDTO pDTO = new ShareDTO();

            pDTO.setUser_id(user_id);
            pDTO.setSp_seq(sSeq);
            pDTO.setSp_title(sp_title);
            pDTO.setSp_contents(sp_contents);
            pDTO.setStart_time(start_time);
            pDTO.setEnd_time(end_time);
            pDTO.setSp_place(sp_place);

            shareService.updateParkInfo(pDTO);

            msg = "수정되었습니다";
            url = "/PRJmain";
        }catch (Exception e){
            msg = "fail :" + e.getMessage();
            url = "PRJmain";
            log.info(e.toString());
            e.printStackTrace();;
        }finally {
            log.info(this.getClass().getName() + ".Update end");

            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
        }

        return "/redirect";
    }

    @GetMapping(value = "share/ParkDelete")
    public String ParkDelete(HttpServletRequest request, ModelMap model){

        log.info(this.getClass().getName() + ".delete staert");

        String msg = "";
        String url = "";

        try{

            String sSeq = CmmUtil.nvl(request.getParameter("sSeq"));

            log.info("sSeq" + sSeq);

            ShareDTO pDTO = new ShareDTO();

            pDTO.setSp_seq(sSeq);

            shareService.deleteParkInfo(pDTO);

            msg = "삭제 완료";
            url = "/PRJmain";
        }catch (Exception e){
            msg = "삭제 실패" + e.getMessage();
            log.info(e.toString());

        }finally {
            log.info(this.getClass().getName() + ".delete end");

            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
        }

        return "redirect";
    }

    @RequestMapping(value = "share/reservation")
    public String Reservation(HttpSession session, HttpServletRequest request, HttpServletResponse response,
                              ModelMap model)throws Exception{


        log.info(this.getClass().getName() + ".reservation start");

        String msg = "";
        String url = "";

        try{

            String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));
            String sp_seq = CmmUtil.nvl(request.getParameter("sSeq"));

            log.info("user_id :" + user_id);
            log.info("sp_seq : " + sp_seq);

            ShareDTO pDTO = new ShareDTO();

            pDTO.setReser_id(user_id);
            pDTO.setSp_seq(sp_seq);

            int res = shareService.Reservation(pDTO);

            log.info("res" + res);

            msg = "예약 성공";
            url = "/PRJmain";


        }catch (Exception e){
            msg = "예약 실패" + e.getMessage();
            url = "/spMap_test";
            log.info(e.toString());
            e.printStackTrace();

        }finally {
            log.info(this.getClass().getName() + ".Reserv end");

            model.addAttribute("url", url);
            model.addAttribute("msg",msg);

        }

        return "/redirect";
    }


}
