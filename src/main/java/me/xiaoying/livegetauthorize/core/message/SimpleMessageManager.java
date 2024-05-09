package me.xiaoying.livegetauthorize.core.message;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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