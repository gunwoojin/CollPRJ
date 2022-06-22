package kopo.poly.service.impl;

import kopo.poly.dto.ImgDTO;
import kopo.poly.dto.ShareDTO;


import kopo.poly.persistance.mapper.IShareMapper;
import kopo.poly.service.IShareService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Slf4j
@Service("ShareService")
public class ShareService implements IShareService {

    private final IShareMapper shareMapper;

    @Autowired
    public ShareService(IShareMapper shareMapper){
        this.shareMapper = shareMapper;
    }


    @Transactional
    @Override
    public int InsertShare(ShareDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".InsertShare Start!");


        return shareMapper.InsertShare(pDTO);
    }

    @Override
    public List<ShareDTO> getShareList(String user_id) throws Exception {

        log.info(this.getClass().getName() + ".getShareList start");

        return shareMapper.getShareList(user_id);
    }

    @Override
    public List<ShareDTO> getShareListAll() throws Exception {

        log.info(this.getClass().getName() + ".getShareListAll Start");

        return shareMapper.getShareListAll();
    }

    @Override
    public ShareDTO getParkInfo(ShareDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".getParkInfo Start!");

        return shareMapper.getParkInfo(pDTO);
    }

    @Transactional
    @Override
    public void updateParkInfo(ShareDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".update start");

        shareMapper.updateParkInfo(pDTO);
    }

    @Transactional
    @Override
    public void deleteParkInfo(ShareDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".delete start");

        shareMapper.deleteParkInfo(pDTO);
    }

    @Transactional
    @Override
    public int Reservation(ShareDTO pDTO) throws Exception {

        int res = 0;

        if (pDTO == null){
            pDTO = new ShareDTO();
        }

        ShareDTO rDTO = shareMapper.getReserExists(pDTO);

        if (rDTO == null){

            int success = shareMapper.Reservation(pDTO);

            if (success > 0){
                res = 1;

            }else {
                res = 0;
            }
        }

        log.info(this.getClass().getName() + ".Reserv start");

       return res;
    }
    
}

