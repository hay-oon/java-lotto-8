package lotto.model;

import java.util.List;
import java.util.ArrayList;

public class LottoTicket {
    private final List<Lotto> lottoList;
    private final Integer purchaseNumber;

    public LottoTicket(List<Lotto> lottoList, Integer purchaseNumber) {
        this.lottoList = lottoList;
        this.purchaseNumber = purchaseNumber;
    }

    public static LottoTicket fromPurchaseNumber(Integer purchaseNumber) {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < purchaseNumber; i++) {
            lottoList.add(Lotto.fromRandomNumbers());
        }
        return new LottoTicket(lottoList, purchaseNumber);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Integer getPurchaseNumber() {
        return purchaseNumber;
    }
}
