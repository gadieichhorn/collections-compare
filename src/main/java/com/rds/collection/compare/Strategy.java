/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rds.collection.compare;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author gadieichhorn
 * @param <T>
 */
public interface Strategy<T extends Model> {

    void compare(List<T> from, List<T> to, List<T> results, Comparator<T> comparator);

}
