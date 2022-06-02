package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class InCheonParkDTO {

    private String objectid;
    private String sido;
    private String name;
    private String x;
    private String y;

    @Override
    public String toString(){
        return "InCheonParkDTO [objectid=" + objectid + ", sido=" + sido +
                ", name=" + name + ", x=" + x + ", y=" + y + "]";
    }
}
