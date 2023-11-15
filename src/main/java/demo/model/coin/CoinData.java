package demo.model.coin;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class CoinData {

    private String type;
    private Integer value;
}
