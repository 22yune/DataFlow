package com.galen.program.hello.trade.entity;

/**
 * <p><b>     </b></p><br>
 * <p>     <br>
 * <br><p>
 *
 * @author baogen.zhang          2020-10-20 11:21
 */
public class Trade   {
    private Trader in;
    private Trader out;
    private Asset inAsset;
    private Asset outAsset;

    public Trade(Trader in, Trader out, Asset inAsset, Asset outAsset) {
        this.in = in;
        this.out = out;
        this.inAsset = inAsset;
        this.outAsset = outAsset;
    }

    public Trader getIn() {
        return in;
    }

    public void setIn(Trader in) {
        this.in = in;
    }

    public Trader getOut() {
        return out;
    }

    public void setOut(Trader out) {
        this.out = out;
    }

    public Asset getInAsset() {
        return inAsset;
    }

    public void setInAsset(Asset inAsset) {
        this.inAsset = inAsset;
    }

    public Asset getOutAsset() {
        return outAsset;
    }

    public void setOutAsset(Asset outAsset) {
        this.outAsset = outAsset;
    }

}
