/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rds.collection.compare;

import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gadieichhorn
 */
public class LinkedListNode implements Node {

    private static final Logger logger = LoggerFactory.getLogger(LinkedListNode.class);
    private String reference;

    private final List<Node> nodes = new LinkedList<>();
    private final List<Leaf> leafs = new LinkedList<>();

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public List<Leaf> getLeafs() {
        return leafs;
    }

    @Override
    public boolean addLeaf(Leaf leaf) {
        return this.leafs.add(leaf);
    }

    @Override
    public boolean addNode(Node node) {
        return this.nodes.add(node);
    }

}
