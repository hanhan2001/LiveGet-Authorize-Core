package me.xiaoying.livegetauthorize.core.scheduler;

import me.xiaoying.livegetauthorize.core.plugin.JavaPlugin;

public interface Scheduler {
    void cancelTask(int task);

    void runTask(JavaPlugin plugin, Runnable runnable);

    int scheduleSyncDelayedTask(JavaPlugin plugin, Runnable runnable);
    int scheduleSyncDelayedTask(JavaPlugin plugin, Runnable runnable, long delay);
    int scheduleSyncRepeatingTask(JavaPlugin plugin, Runnable runnable, long delay, long period);

    int scheduleAsyncDelayedTask(JavaPlugin plugin, Runnable runnable);
    int scheduleAsyncDelayedTask(JavaPlugin plugin, Runnable runnable, long delay);
    int scheduleAsyncRepeatingTask(JavaPlugin plugin, Runnable runnable, long delay, long period);
}