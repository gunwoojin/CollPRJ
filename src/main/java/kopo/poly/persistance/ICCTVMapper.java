package kopo.poly.persistance;

import kopo.poly.dto.CCTVDTO;

import java.util.List;

public interface ICCTVMapper {

    int insertCCTV(List<CCTVDTO> rList, String colNm) throws Exception;
}
