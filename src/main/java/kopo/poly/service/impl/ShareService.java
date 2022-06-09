package kopo.poly.service.impl;


import kopo.poly.dto.ShareDTO;

import kopo.poly.persistance.mapper.IShareMapper;
import kopo.poly.service.IShareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("ShareService")
public class ShareService implements IShareService {

    private final IShareMapper shareMapper;

    @Autowired
    public ShareService(IShareMapper shareMapper){
        this.shareMapper = (IShareMapper) shareMapper;
    }


    @Transactional
    @Override
    public int InsertShare(ShareDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".InsertShare Start!");


        return shareMapper.InsertShare(pDTO);
    }

}
