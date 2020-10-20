package com.galen.program.system;

/**
 * <p><b>  系统   </b></p><br>
 * <p>  组装数据源、数据流、业务流程生成系统   <br>
 * <br><p>
 *
 * @author baogen.zhang          2020-10-12 15:38
 */
public interface Sytem {

    void init();
    void start();
    void suspend();
    void resume();
    void stop();

    //TODO System snapshoot

}
