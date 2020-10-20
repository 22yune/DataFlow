package com.galen.program.system.source;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * <p><b>     </b></p><br>
 * <p>     <br>
 * <br><p>
 *
 * @author baogen.zhang          2020-10-12 16:21
 */
public class AbstractSource<T extends AbstractSource<T>> implements Source<T>{

    //TODO 定制队列，先进先出等，参考 Stream 、data flow 编程。

    /**
     * 队列需给各个不同订阅者使用。数据持久化也通过订阅者实现。
     * @return
     */
    protected Queue<T> container(){
        return new ArrayBlockingQueue<T>(1) ;
    }

    @Override
    public void produce(T t){
        container().add(t);
    }

    @Override
    public void subscribe(Subscriber<? super T> s){
        s.onSubscribe(new Subscription() {
            private Iterator<T> iterator ;
            @Override
            public void request(long n) {
                for(int i = 0 ; i < n ; i++){
                    if(iterator.hasNext()){
                        s.onNext(iterator.next());
                    } else {
                        s.onComplete();
                        s.onError(new RuntimeException());
                    }
                }
            }

            @Override
            public void cancel() {

            }
        });
    }
}
