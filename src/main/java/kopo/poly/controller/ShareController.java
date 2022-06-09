package kopo.poly.controller;

import kopo.poly.dto.ShareDTO;
import kopo.poly.service.IShareService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class ShareController {

    @Resource(name = "ShareService")
    private IShareService shareService;

    @RequestMapping(value = "/Share/RegPark")
    public String ShareRegPark(){
        return "/Share/ShareReg";
    }

    @PostMapping(value = "/Share/insertRegPark")
    public String ShareInsert(HttpSession session, HttpServletRequest request, ModelMap model){

        log.info(this.getClass().getName() + ".ShareInsert start");

        String url = "";

        String msg = "";

        ShareDTO pDTO = null;


        try{

            String user_id = CmmUtil.nvl((String) session.getAttribute("SS_USER_ID"));
            String sp_title = CmmUtil.nvl(request.getParameter("sp_title"));
            String sp_contents = CmmUtil.nvl(request.getParameter("sp_contents"));
            String start_time = CmmUtil.nvl(request.getParameter("start_time"));
            String end_time = CmmUtil.nvl(request.getParameter("end_time"));
            String sp_place = CmmUtil.nvl(request.getParameter("sp_place"));


            log.info("user_id :" + user_id);
            log.info("sp_title :" + sp_title);
            log.info("sp_contents :" + sp_contents);
            log.info("start_time :" + start_time);
            log.info("end_time :" + end_time);
            log.info("sp_place :" + sp_place);


            pDTO = new ShareDTO();

            pDTO.setUser_id(user_id);
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


}
