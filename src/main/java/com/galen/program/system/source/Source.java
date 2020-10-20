package com.galen.program.system.source;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.*;

/**
 * <p><b> 数据源    </b></p><br>
 * <p>  负责数据的生成   <br>
 *     数据的读取由数据库系统处理
 * <br><p>
 *
 * @author baogen.zhang          2020-10-12 15:21
 */
public interface Source<T extends Source<T>> extends Publisher<T> {
    /**
     * 生产数据
     * 生产的数据由{@link com.galen.program.system.flow.Flow}消费，并持久化。一般对应到数据库的一张表。
     * @param t
     */
    public void produce(T t);

    /**
     * 订阅数据源
     * //TODO 注意历史数据的处理
     * 注意不处理历史数据，当系统启动时，负责订阅的时机，只有订阅后生产的数据才会被通知。
     * @param s
     */
    @Override
    public void subscribe(Subscriber<? super T> s);
}
