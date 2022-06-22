package kopo.poly.persistance;

import kopo.poly.dto.PubParkDTO;

import java.util.List;

public interface IPubParkMapper {

    int insertPubPark(List<PubParkDTO> rList, String colNm) throws Exception;

    List<PubParkDTO> getPubPark(String colNm) throws Exception;
}
