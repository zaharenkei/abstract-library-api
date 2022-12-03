package demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Coin extends CoinData {

    @Id
    private int id;

    public Coin(int id, CoinData coinData) {
        setId(id);
        setType(coinData.getType());
        setValue(coinData.getValue());
    }

    public Coin(CoinData coinData) {
        setId(id);
        setType(coinData.getType());
        setValue(coinData.getValue());
    }

    public Coin() {
    }
}