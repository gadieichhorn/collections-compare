/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rds.collection.compare;

import java.util.Comparator;

/**
 *
 * @author gadieichhorn
 * @param <T>
 */
public class ReferenceComparator<T extends Model> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getReference().compareTo(o2.getReference());
    }

}
