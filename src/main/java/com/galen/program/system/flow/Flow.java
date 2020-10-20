package com.galen.program.system.flow;

import org.reactivestreams.Subscriber;

import java.util.Collection;

/**
 * <p><b> 数据流    </b></p><br>
 * <p>  订阅某些数据源，生产另一些数据源   <br>
 * <br><p>
 *
 * @author baogen.zhang          2020-10-12 15:35
 */
public interface Flow<T> extends Subscriber<T> {

}
