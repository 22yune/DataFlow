package com.galen.program.hello.trade.entity;

/**
 * <p><b>     </b></p><br>
 * <p>     <br>
 * <br><p>
 *
 * @author baogen.zhang          2020-10-20 11:20
 */
public class Trader {

    private String name;

    public Trader(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                '}';
    }
}
