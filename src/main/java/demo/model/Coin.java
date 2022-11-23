package demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("coins")
@Data
public class Coin extends CoinData {
    @Id
    private int id;

    public Coin(CoinData coinData) {
        setId(id);
        setType(coinData.getType());
        setValue(coinData.getValue());
    }

    public Coin() {
    }
}
