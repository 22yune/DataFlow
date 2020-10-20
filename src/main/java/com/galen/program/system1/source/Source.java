package com.galen.program.system1.source;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.ArrayList;

/**
 * <p><b> 数据源    </b></p><br>
 * <p>  负责数据的生成   <br>
 *     数据的读取由数据库系统处理
 * <br><p>
 *
 * @author baogen.zhang          2020-10-12 15:21
 */
public class Source<T extends Source<T>> extends Flux<T> {

    private FluxSink<T> sink ;

    private volatile Flux<T> flux;

    public Source(FluxSink<T> sink, Flux<T> flux) {
        this.sink = sink;
        this.flux = flux;
    }

    /**
     *
     */
    public  FluxSink<T> sink(){
        return sink;
    }

    public static <E extends Source<E>> Source<E> newSource(){
        final FluxSink<E>[] fluxSink = new FluxSink[1];
        Flux<E> flux = Flux.create(sink -> {
            fluxSink[0] = sink;
        });
        return new Source<>(fluxSink[0],flux);
    }

    @Override
    public void subscribe(CoreSubscriber<? super T> actual) {
        flux.subscribe(actual);
    }
}
