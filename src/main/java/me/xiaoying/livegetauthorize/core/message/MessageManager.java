package me.xiaoying.livegetauthorize.core.message;

/**
 * Manager Message
 */
public interface MessageManager {
    void registerMessageExecutor(String type, MessageExecutor executor);

    void callMessage(String string, Object... objects);

    void unregisterMessage(String type);

    void unregisterMessage(String type, MessageExecutor messageExecutor);

    void unregisterMessages();
}