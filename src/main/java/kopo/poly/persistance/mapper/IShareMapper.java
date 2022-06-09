package kopo.poly.persistance.mapper;

import kopo.poly.dto.ShareDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IShareMapper {

    int InsertShare(ShareDTO pDTO) throws Exception;

}
