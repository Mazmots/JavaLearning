package com.example.serivce;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.nio.charset.StandardCharsets;

public class BloomFilterTest {

    /**
     * 期望插入数据数
     */
    private static int expectedInsertions = 1000000;

    /**
     * 期望误判率
     */
    private static double fpp = 0.01;

    /**
     * 布隆过滤器
     */
    private static BloomFilter<CharSequence> bloomFilter =
            BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), expectedInsertions, fpp);

    public static void main(String[] args) {
//        int n = 1000000;
//        for (int i = 0; i < n; i++) {
//            bloomFilter.put(String.valueOf(i));
//        }
//
//        int falseCount = 0;
//        for (int i = 0; i < (n*2); i++) {
//            if (bloomFilter.mightContain(String.valueOf(i))) {
//                falseCount++;
//            }
//        }
//
//        System.out.println("过滤器误判率：" + (falseCount - n)/Double.valueOf(n));
            double p =fpp;
            int n=expectedInsertions;

            if (p == 0.0D) {
                p = 4.9E-324D;
            }

        long l = (long) ((double) (-n) * Math.log(p) / (Math.log(2.0D) * Math.log(2.0D)));
        System.out.println(l);

    }
}
