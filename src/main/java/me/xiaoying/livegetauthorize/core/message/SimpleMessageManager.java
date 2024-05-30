package me.xiaoying.livegetauthorize.core.message;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Manager Message Simple
 */
public class SimpleMessageManager implements MessageManager {
    private final Map<String, List<MessageExecutor>> knownMessageExecutor = new HashMap<>();

    public void registerMessageExecutor(String type, MessageExecutor executor) {
        List<MessageExecutor> list;
        if (this.knownMessageExecutor.get(type) != null)
            list = this.knownMessageExecutor.get(type);
        else
            list = new ArrayList<>();
        if (list.contains(executor))
            return;

        list.add(executor);
        this.knownMessageExecutor.put(type, list);
    }

    public void callMessage(String string, Object... objects) {
        String type = this.getType(string);

        if (type == null)
            return;

        if (!this.knownMessageExecutor.containsKey(type))
            return;

        this.knownMessageExecutor.get(type).forEach(messageExecutor -> messageExecutor.execute(JSONObject.parseObject(string), objects));
    }

    public void unregisterMessage(String type) {
        this.knownMessageExecutor.remove(type);
    }

    public void unregisterMessage(String type, MessageExecutor messageExecutor) {
        Iterator<MessageExecutor> iterator = this.knownMessageExecutor.get(type).iterator();
        MessageExecutor executor;
        while (iterator.hasNext() && (executor = iterator.next()) != null) {
            if (executor != messageExecutor)
                continue;

            iterator.remove();
            break;
        }
    }

    public void unregisterMessages() {
        this.knownMessageExecutor.clear();
    }

    public String getType(String string) {
        JSONObject jsonObject;
        try {
            jsonObject = JSONObject.parseObject(string);
        } catch (Exception e) {
            return null;
        }

        return jsonObject.getString("type");
    }
}