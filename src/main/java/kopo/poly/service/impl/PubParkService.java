package kopo.poly.service.impl;

import kopo.poly.dto.PubParkDTO;
import kopo.poly.persistance.IPubParkMapper;
import kopo.poly.service.IPubParkService;
import kopo.poly.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Service("PubParkService")
public class PubParkService  implements IPubParkService {


        @Resource(name="PubParkMapper")
        private IPubParkMapper pubParkMapper;

        private final String colNm = "PubPark_"+ DateUtil.getDateTime("yyyy_MM_dd_hh_mm");


    @Override
    public int insertPubPark(List<PubParkDTO> rList) throws Exception {


        log.info(this.getClass().getName() + ".Start!! insert pubPark");

        log.info(this.getClass().getName()+"colNM 바끼는지확인하기"+ colNm);

        int res = pubParkMapper.insertPubPark(rList,colNm);

        log.info(this.getClass().getName() + ".End insert pubPark");

        return res;
    }
}



