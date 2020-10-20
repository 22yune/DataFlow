package com.galen.program.system.flow.impl;

import com.galen.program.system.flow.Flow;
import com.galen.program.system.source.impl.Bill;
import org.reactivestreams.Subscription;

/**
 * <p><b>     </b></p><br>
 * <p>     <br>
 * <br><p>
 *
 * @author baogen.zhang          2020-10-12 15:54
 */
public class Trade implements Flow<Bill> {

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(Bill bill) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
