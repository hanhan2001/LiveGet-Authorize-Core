package me.xiaoying.livegetauthorize.core.scheduler;

import me.xiaoying.livegetauthorize.core.plugin.Plugin;

public interface Scheduler {
    void cancelTask(int task);

    void runTask(Plugin plugin, Runnable runnable);

    int scheduleSyncDelayedTask(Plugin plugin, Runnable runnable);
    int scheduleSyncDelayedTask(Plugin plugin, Runnable runnable, long delay);
    int scheduleSyncRepeatingTask(Plugin plugin, Runnable runnable, long delay, long period);

    int scheduleAsyncDelayedTask(Plugin plugin, Runnable runnable);
    int scheduleAsyncDelayedTask(Plugin plugin, Runnable runnable, long delay);
    int scheduleAsyncRepeatingTask(Plugin plugin, Runnable runnable, long delay, long period);
}