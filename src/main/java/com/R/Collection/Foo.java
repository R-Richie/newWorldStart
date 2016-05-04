package com.R.collection;

import com.sun.istack.internal.Nullable;

/**
 * User: lijiaren
 * Date: 2016/5/4
 * Time: 10:50
 */

public class Foo {
    @Nullable String sortedBy;
    int notSortedBy;

    public Foo(String sortedBy) {
        this.sortedBy = sortedBy;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "sortedBy='" + sortedBy + '\'' +
                '}';
    }

    public String getSortedBy() {
        return sortedBy;
    }
}
