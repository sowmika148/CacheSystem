package com.sowmika;

import java.util.List;

public class CacheSystem {
    private int size;
    private Cache cache;
    private CacheDelete cacheDelete;

    CacheSystem(int size, CacheDeletionMode cacheDeletionMode) {
        this.size = size;
        cache = new Cache();
        this.cacheDelete = CacheDeletionHandler.getCacheDeleteInstance(cacheDeletionMode);
    }

    private boolean isCacheHit(Object object) {
        return cache.contains(object);
    }

    private void reRankTheObject(Object object) {
        cache.reRankObject(object);
    }

    private boolean isCacheFull() {
        return cache.isFull(this.size);
    }

    void cache(Object object) {
        if (isCacheHit(object)) {
            reRankTheObject(object);
        } else {
            if (isCacheFull()) {
                cacheDelete.deleteElement(cache);
                cache(object);
            } else {
                cache.addElement(object);
            }
        }
    }

    List<Object> getCacheElements() {
        return cache.getElements();
    }
}


