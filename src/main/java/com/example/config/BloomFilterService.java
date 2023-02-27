package com.example.config;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloomFilterService {
    /**
     * 容量
     */
    protected Long expectedInsertions = 1000000L;
    /**
     * 误差
     */
    protected Double falseProbability = 0.001;

    @Autowired
    private Redisson redisson;

    public void add(String key , String data) {
        RBloomFilter bloomFilter = redisson.getBloomFilter(key);
        bloomFilter.tryInit(expectedInsertions, falseProbability);
        bloomFilter.add(data);
    }

    public Boolean exist(String key , String data) {
        RBloomFilter bloomFilter = redisson.getBloomFilter(key);
        bloomFilter.tryInit(expectedInsertions , falseProbability);
        boolean isExist = bloomFilter.contains(data);
        return isExist;
    }
}
