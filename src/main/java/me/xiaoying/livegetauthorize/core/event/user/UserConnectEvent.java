package me.xiaoying.livegetauthorize.core.event.user;

import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.event.HandlerList;
import org.java_websocket.WebSocket;

/**
 * Event user connect
 */
public class UserConnectEvent extends UserEvent {
    private final WebSocket webSocket;
    private static HandlerList handlers = new HandlerList();

    /**
     * 构造器
     *
     * @param user 用户
     * @param webSocket 连接
     */
    public UserConnectEvent(User user, WebSocket webSocket) {
        super(user);
        this.webSocket = webSocket;
    }

    /**
     * 获取连接
     *
     * @return WebSocket
     */
    public WebSocket getConnect() {
        return this.webSocket;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}