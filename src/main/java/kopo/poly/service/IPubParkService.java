package kopo.poly.service;

import kopo.poly.dto.PubParkDTO;

import java.util.List;

public interface IPubParkService {

    int insertPubPark(List<PubParkDTO> rList) throws Exception;
}
