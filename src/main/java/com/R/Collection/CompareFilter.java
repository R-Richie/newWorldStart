package com.R.collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: lijiaren
 * Date: 2016/5/4
 * Time: 15:48
 */
public class CompareFilter {
    public static void main(String[] args){
        List<Foo> fooList = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            fooList.add(new Foo(String.valueOf(i)));
        }
        //过滤某个属性的值
        //for each
        long startTime=System.currentTimeMillis();
        List<Foo> fooListByEach = Lists.newArrayList();
        for (Foo foo:fooList) {
            if(foo.getSortedBy().equals("50")) {
                fooListByEach.add(foo);
            }
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println(fooListByEach.size());
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        //iterator
        long startTime1=System.currentTimeMillis();
        List<Foo> fooListIterator = Lists.newArrayList();
        for ( Iterator it = fooList.iterator(); it.hasNext();) {
            Foo next = (Foo)it.next();
            if(next.getSortedBy().equals("50")) {
                fooListIterator.add(next);
            }
        }
        long endTime1=System.currentTimeMillis(); //获取结束时间
        System.out.println(fooListIterator.size());
        System.out.println("程序运行时间： "+(endTime1-startTime1)+"ms");
        //guava filter
        long startTime2=System.currentTimeMillis();
        List<Foo> fooListGuavaFilter = Lists.newArrayList(Collections2.filter(fooList, new Predicate<Foo>() {
            @Override
            public boolean apply(Foo input) {
                if (input.getSortedBy() .equals("50")) {
                    return true;
                } else {
                    return false;
                }

            }
        }));
        long endTime2=System.currentTimeMillis(); //获取结束时间
        System.out.println(fooListGuavaFilter.size());
        System.out.println("程序运行时间： "+(endTime2-startTime2)+"ms");
        //java8 stream
        long startTime3=System.currentTimeMillis();
        List<Foo> fooListStream = fooList.stream().filter(record -> record.getSortedBy().equals("50")).collect(Collectors.toList());
        long endTime3=System.currentTimeMillis(); //获取结束时间
        System.out.println(fooListStream.size());
        System.out.println("程序运行时间： "+(endTime3-startTime3)+"ms");

    }
}
