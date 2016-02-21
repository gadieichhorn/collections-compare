/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rds.collection.compare;

/**
 *
 * @author gadieichhorn
 */
public class Property implements Leaf {

    private String reference;
    private String value;

    public Property() {
    }

    public Property(String reference, String value) {
        this.reference = reference;
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String getReference() {
        return reference;
    }

    public String getValue() {
        return value;
    }

}
