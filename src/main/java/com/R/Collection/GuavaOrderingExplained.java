package com.R.collection;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * User: lijiaren
 * Date: 2016/5/4
 * Time: 10:39
 */
public class GuavaOrderingExplained {
    public static void main(String[] args){
        /**
        List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("jhon");
        list.add("neron");

        System.out.println("list:"+ list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

        System.out.println("naturalOrdering:"+ naturalOrdering.sortedCopy(list));
        System.out.println("usingToStringOrdering:"+ usingToStringOrdering.sortedCopy(list));
        System.out.println("arbitraryOrdering:"+ arbitraryOrdering.sortedCopy(list));
//        Ordering<String> byLengthOrdering = new Ordering<String>() {
//            public int compare(String left, String right) {
//                return Ints.compare(left.length(), right.length());
//            }
//        };
        Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo, String>() {
            public String apply(Foo foo) {
                return foo.sortedBy;
            }
        });
        List<Foo> foolist = Lists.newArrayList();
        foolist.add(new Foo("a"));
        foolist.add(new Foo("1"));
        foolist.add(new Foo("b"));
        foolist.add(new Foo("2"));
        System.out.println("customOrdering:"+ ordering.sortedCopy(foolist));
         **/
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<String> result = Collections2.filter(names, Predicates.containsPattern("a"));
        for(Iterator it = result.iterator(); it.hasNext(); ) {
            Object o = it.next();
            System.out.println(o);
        }
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith("A") || input.startsWith("T");
            }
        };

        Function<String, Integer> func = new Function<String,Integer>(){
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        };

        List<String> names2 = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<Integer> result2 = FluentIterable.from(names)
                .filter(predicate)
                .transform(func)
                .toList();
        for(Iterator it = result2.iterator(); it.hasNext(); ) {
            Object o = it.next();
            System.out.println(o);
        }
    }
}
