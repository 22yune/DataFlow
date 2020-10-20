package com.galen.program.hello.trade.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p><b>     </b></p><br>
 * <p>     <br>
 * <br><p>
 *
 * @author baogen.zhang          2020-10-20 11:24
 */
public class Store {
    private Trader trader;
    private List<Asset>  assets = new ArrayList<>();

    public Store(Trader trader) {
        this.trader = trader;
    }
    public void addAsset(Asset asset){
        assets.add(asset);
    }
    public void delAsset(Asset asset){
        assets.remove(asset);
    }

    public Trader getTrader() {
        return trader;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    @Override
    public String toString() {
        return "Store{" +
                "trader=" + trader +
                ", assets=" + Arrays.toString(assets.toArray()) +
                '}';
    }
}
