package lotto.model;

import java.util.List;
import java.util.ArrayList;

public class LottoTicket {
    private final List<Lotto> lottoList;

    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoTicket fromPurchaseNumber(int purchaseNumber) {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < purchaseNumber; i++) {
            lottoList.add(Lotto.fromRandomNumbers());
        }
        return new LottoTicket(lottoList);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getPurchaseCount() {
        return lottoList.size();
    }
}
