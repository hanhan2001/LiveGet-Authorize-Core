package me.xiaoying.livegetauthorize.core.option;

public class Option {
    private final String name;
    private Object value;

    public Option(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.value.toString();
    }
}