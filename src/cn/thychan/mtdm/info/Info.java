package cn.thychan.mtdm.info;

/**
 * Created by cn_cx on 2016/12/8.
 */

public class Info {
    private String value;

    public Info(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
