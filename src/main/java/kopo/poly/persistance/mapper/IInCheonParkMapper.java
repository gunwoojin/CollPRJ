package kopo.poly.persistance.mapper;

import kopo.poly.dto.InCheonParkDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IInCheonParkMapper {

    int insertInCheonInfo(InCheonParkDTO pDTO) throws Exception;

    List<InCheonParkDTO> getInCheonInfo() throws Exception;
}
