package me.xiaoying.livegetauthorize.core;

import me.xiaoying.livegetauthorize.core.plugin.PluginManager;
import me.xiaoying.livegetauthorize.core.server.Server;
import me.xiaoying.logger.Logger;
import me.xiaoying.logger.LoggerFactory;

public class LACore {
    private static final Logger logger = LoggerFactory.getLogger();
    private static Server server;

    public static Server getServer() {
        return server;
    }

    public static void setServer(Server server) {
        if (LACore.server != null)
            throw new UnsupportedOperationException("Cannot redefine singleton Server");

        LACore.server = server;
        logger.info("This server is running " + getName());
    }

    public static PluginManager getPluginManager() {
        return server.getPluginManager();
    }

    public static String getName() {
        return server.getName();
    }

    public static Logger getLogger() {
        return logger;
    }
}