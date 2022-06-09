package kopo.poly.service.impl;


import kopo.poly.dto.UserInfoDTO;
import kopo.poly.persistance.mapper.IUserInfoMapper;
import kopo.poly.service.IUserInfoService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Slf4j
@Service("UserInfoService")
public class UserInfoService implements IUserInfoService {

    private final IUserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoService(IUserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }



    //-----------------Login------------------
    @Override
    public UserInfoDTO getUserLoginCheck(UserInfoDTO pDTO) throws Exception {

        if (pDTO == null) {
            pDTO = new UserInfoDTO();
        }
        return userInfoMapper.getUserLoginCheck(pDTO);
    }



    //회원가입
    @Override
    public int insertUserInfo(UserInfoDTO pDTO) throws Exception {

        int res = 0;

        if(pDTO == null){
            pDTO = new UserInfoDTO();
        }

        //회원가입 중복 방지를 위해 DB에서 데이터 조회
        UserInfoDTO rDTO = userInfoMapper.getUserExists(pDTO);

        if (rDTO == null){
            rDTO = new UserInfoDTO();
        }

        if (CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")){
            res = 2;

        }else{

            int success = userInfoMapper.InsertUserInfo(pDTO);

            if(success > 0){
                res = 1;

            }else{
                res = 0;
            }
        }

        return res;

    }



    @Transactional
    @Override
    public int deleteUser(UserInfoDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".deleteUser start!");

        int res = userInfoMapper.deleteUser(pDTO);

        return res;
    }



    @Transactional
    @Override
    public void updateUser(UserInfoDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".updateUser start!");

        userInfoMapper.updateUser(pDTO);

        log.info(this.getClass().getName() + ".updateUser end");
    }




    }





