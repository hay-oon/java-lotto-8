package lotto.model;

import java.util.List;
import java.util.ArrayList;

public class LottoTicket {
    private final List<Lotto> lottoList;
    private final int purchaseNumber;

    public LottoTicket(List<Lotto> lottoList, int purchaseNumber) {
        this.lottoList = lottoList;
        this.purchaseNumber = purchaseNumber;
    }

    public static LottoTicket fromPurchaseNumber(int purchaseNumber) {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < purchaseNumber; i++) {
            lottoList.add(Lotto.fromRandomNumbers());
        }
        return new LottoTicket(lottoList, purchaseNumber);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }
}
