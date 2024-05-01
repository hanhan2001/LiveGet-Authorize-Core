package me.xiaoying.livegetauthorize.core.classification;

import me.xiaoying.livegetauthorize.core.NamespacedKey;

import java.util.List;

/**
 * Service ClassificationManager
 */
public interface ClassificationManager {
    void registerClassification(NamespacedKey namespacedKey, Classification classification);

    /**
     * Get classification
     *
     * @param name NamespacedKey
     * @param classification Classification's name
     * @return Classification
     */
    Classification getClassification(String name, String classification);

    void unregisterClassification(String name);

    void unregisterClassification(String name, String classification);

    List<Classification> getClassifications();
}