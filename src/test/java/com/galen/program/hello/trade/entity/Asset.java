package com.galen.program.hello.trade.entity;

/**
 * <p><b>     </b></p><br>
 * <p>     <br>
 * <br><p>
 *
 * @author baogen.zhang          2020-10-20 11:22
 */
public class Asset {
    private String name;

    public String getName() {
        return name;
    }

    public Asset(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "name='" + name + '\'' +
                '}';
    }
}
