package kopo.poly.service.impl;

import kopo.poly.dto.CCTVDTO;
import kopo.poly.persistance.ICCTVMapper;
import kopo.poly.service.ICCTVService;
import kopo.poly.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service("CCTVService")
public class CCTVService implements ICCTVService {

    @Resource(name="CCTVMapper")
    private ICCTVMapper cctvMapper;

    private final String colNm = "CCTV_"+ DateUtil.getDateTime("yyyy_MM_dd_hh_mm");


    @Override
    public int insertCCTV(List<CCTVDTO> rList)throws Exception {

        log.info(this.getClass().getName()+" Start!!@ insert CCTV");

         int res = cctvMapper.insertCCTV(rList,colNm);
        log.info(this.getClass().getName()+" Start!!@ insert CCTV");
        return res;
    }
}
