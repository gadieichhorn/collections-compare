/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rds.collection.compare;

/**
 *
 * @author gadieichhorn
 * @param <T>
 */
public interface ModelFactory<T extends Model> {

    void createModel(T from);

    void deleteModel(T from);

    void updateModel(T from, T to);
}
