/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rds.collection.compare;

import java.util.List;

/**
 *
 * @author gadieichhorn
 */
public interface Node extends Model {

    boolean addNode(Node node);

    List<Node> getNodes();

    boolean addLeaf(Leaf leaf);

    List<Leaf> getLeafs();
}
