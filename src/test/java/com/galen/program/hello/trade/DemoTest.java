package com.galen.program.hello.trade;

import com.galen.program.hello.trade.entity.Asset;
import com.galen.program.hello.trade.entity.Store;
import com.galen.program.hello.trade.entity.Trade;
import com.galen.program.hello.trade.entity.Trader;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p><b>     </b></p><br>
 * <p>     <br>
 * <br><p>
 *
 * @author baogen.zhang          2020-10-20 16:01
 */

//TODO  cqrs event sourcing transaction command process flow
public class DemoTest {
    private List<Trader> trades = new ArrayList<>();
    private List<Store> stores = new ArrayList<>();

    @Test
    public void test(){
        Trader a = new Trader("A");
        Trader b = new Trader("B");
        Asset m = new Asset("m");
        Asset n = new Asset("n");
        Trade tradeA = new Trade(a,b,m,n);
        Trade tradeB = new Trade(a,b,n,m);


        AtomicReference<FluxSink<Trader>> traderSink = new AtomicReference<>();
        Flux<Trader> traderFlux = Flux.create(sink -> {
            traderSink.set(sink);
        });
        traderFlux.subscribe( trade -> {
            save(trade);
        });
        traderSink.get().next(a);
        traderSink.get().next(b);

        AtomicReference<FluxSink<Trade>> tradeSink = new AtomicReference<>();
        Flux<Trade> tradeFlux = Flux.create(sink -> {
            tradeSink.set(sink);
        });
        tradeFlux.subscribe( trade -> {
            delStore(trade.getIn(),trade.getInAsset());
            addStore(trade.getIn(),trade.getOutAsset());
            delStore(trade.getOut(),trade.getOutAsset());
            addStore(trade.getOut(),trade.getInAsset());
        });

        tradeSink.get().next(tradeA);
        listStore();
        tradeSink.get().next(tradeB);
        listStore();
    }

    public void save(Trader trade){
        trades.add(trade);
    }
    public void addStore(Trader trader, Asset asset){
        queryStore(trader).addAsset(asset);
    }
    public void delStore(Trader trader, Asset asset){
        queryStore(trader).delAsset(asset);
    }
    public  Store queryStore(Trader trader){
         return stores.stream().filter( store -> store.getTrader().equals(trader)).findAny().orElseGet(() -> {
              Store s = new Store(trader);
              stores.add(s);
              return s;
         });
    }
    public void listStore(){
        stores.forEach(
                store -> System.out.println(store));
    }
}
