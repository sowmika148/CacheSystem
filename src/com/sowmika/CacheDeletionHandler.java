package com.sowmika;

public class CacheDeletionHandler {

    public static CacheDelete getCacheDeleteInstance(CacheDeletionMode cacheDeletionMode) {
        if (cacheDeletionMode == null)
            return new LeastRecentlyUsedDeletion();
        switch (cacheDeletionMode) {
            case LEAST_RECENTLY_USED:
                return new LeastRecentlyUsedDeletion();
            case MOST_RECENTLY_USED:
                return new MostRecentlyUsedDeletion();
        }
        return new LeastRecentlyUsedDeletion();
    }

    static class LeastRecentlyUsedDeletion implements CacheDelete {

        @Override
        public void deleteElement(Cache cache) {
            cache.deleteLeastRecentlyUsedElement();
        }
    }

    static class MostRecentlyUsedDeletion implements CacheDelete {

        @Override
        public void deleteElement(Cache cache) {
            cache.deleteMostRecentlyUsedElement();
        }
    }
}
