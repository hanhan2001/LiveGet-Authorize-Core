package me.xiaoying.livegetauthorize.core.message;

import com.alibaba.fastjson.JSONObject;

public interface MessageExecutor {
    void execute(JSONObject jsonObject);
}