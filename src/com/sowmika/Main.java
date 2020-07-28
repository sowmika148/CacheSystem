package com.sowmika;

public class Main {

    public static void main(String[] args) {
        CacheSystem cacheSystem = new CacheSystem(2, CacheDeletionMode.LEAST_RECENTLY_USED);
        cacheSystem.cache(1);
        cacheSystem.cache(2);
        cacheSystem.cache(3);
        cacheSystem.cache(2);
        cacheSystem.getCacheElements().forEach(System.out::println);
    }
}
