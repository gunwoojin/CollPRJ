package kopo.poly.persistance.mongo;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import kopo.poly.dto.PubParkDTO;
import kopo.poly.persistance.IPubParkMapper;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component("PubParkMapper")
public class PubParkMapper extends AbstractMongoDBComon implements IPubParkMapper {


    @Override
    public int insertPubPark(List<PubParkDTO> rList, String colNm) throws Exception {

        log.info(this.getClass().getName() + ".insertData Start!");

        int res =0;

        super.createCollection(colNm);

        MongoCollection<Document> col = mongodb.getCollection(colNm);

        for(int i = 0; i < rList.size(); i++){

            col.insertOne(new Document(new ObjectMapper().convertValue(rList.get(i), Map.class)));
        }
        res = 1;

        log.info(this.getClass().getName() + ".insertData End!");

        return res;
    }
}
