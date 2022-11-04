import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Coin extends CoinData {
    private int id;

    public Coin(int id, CoinData coinData) {
        setId(id);
        setType(coinData.getType());
        setValue(coinData.getValue());
    }
    public Coin(int id, String type, int value) {
        setId(id);
        setType(type);
        setValue(value);
    }
}
