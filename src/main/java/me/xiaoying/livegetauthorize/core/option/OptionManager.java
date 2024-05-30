package me.xiaoying.livegetauthorize.core.option;

import java.util.List;

public interface OptionManager {
    void registerOption(Option option);

    void registerOption(String name, String value);

    void unregisterOption(String name);

    void unregisterOptions();

    Option getOption(String name);

    List<Option> getOptions();
}