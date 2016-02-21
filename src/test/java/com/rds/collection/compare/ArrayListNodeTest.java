/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rds.collection.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gadieichhorn
 */
@RunWith(value = Parameterized.class)
public class ArrayListNodeTest {

    private static final Logger logger = LoggerFactory.getLogger(ArrayListNodeTest.class);
    private Node instance;

    public ArrayListNodeTest(Node node) {
        instance = node;
    }

    @Parameterized.Parameters
    public static List<Node> combinations() {
        return Arrays.asList(
                new ArrayListNode(),
                new LinkedListNode()
        );
    }
    
    
    private static void logInfo(Description description, String status, long nanos) {
        String testName = description.getMethodName();
        logger.info(String.format("Test %s %s, spent %d microseconds",
                testName, status, TimeUnit.NANOSECONDS.toMicros(nanos)));
    }

    @Rule
    public Stopwatch stopwatch = new Stopwatch() {
        @Override
        protected void succeeded(long nanos, Description description) {
            logInfo(description, "succeeded", nanos);
        }

        @Override
        protected void failed(long nanos, Throwable e, Description description) {
            logInfo(description, "failed", nanos);
        }

        @Override
        protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
            logInfo(description, "skipped", nanos);
        }

        @Override
        protected void finished(long nanos, Description description) {
            logInfo(description, "finished", nanos);
        }
    };

    @Before
    public void setUp() {
        instance = new ArrayListNode();
        instance.addLeaf(new Property("001", "value"));
        instance.addLeaf(new Property("003", "value"));
        instance.addLeaf(new Property("005", "value"));
        instance.addLeaf(new Property("007", "value"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getReference method, of class LinkedListCollection.
     */
    @Test
    public void testCompareReorder() {
        Node from = new ArrayListNode();
        from.addLeaf(new Property("001", "value"));
        from.addLeaf(new Property("005", "value"));
        from.addLeaf(new Property("004", "value"));
        from.addLeaf(new Property("007", "value"));
        from.addLeaf(new Property("003", "value"));

        //from.addNode(new ArrayListNode("003", "value"));
        
        Comparator<Model> comparator = new ReferenceComparator();
        Strategy listComparator = new AuditStrategy();

        List<Model> results = new ArrayList<>();

        listComparator.compare(from.getLeafs(), instance.getLeafs(), results, comparator);

    }

    /**
     * Test of setReference method, of class LinkedListCollection.
     */
    @Test
    public void testSetReference() {
        Node from = new ArrayListNode();
        from.addLeaf(new Property("001", "value"));
        from.addLeaf(new Property("005", "value"));
        from.addLeaf(new Property("004", "value"));
        from.addLeaf(new Property("007", "value"));
        from.addLeaf(new Property("002", "value"));
        from.addLeaf(new Property("003", "value"));
        from.addLeaf(new Property("006", "value"));
        from.addLeaf(new Property("008", "value"));
        from.addLeaf(new Property("009", "value"));

        Comparator<Model> comparator = new ReferenceComparator();
        Strategy listComparator = new AuditStrategy();

        List<Model> results = new ArrayList<>();

        listComparator.compare(from.getLeafs(), instance.getLeafs(), results, comparator);

    }

    /**
     * Test of setModel method, of class LinkedListCollection.
     */
    @Test
    public void testEmptyDTO() {
        Node from = new ArrayListNode();
        //from.addModel(new Property("001", "value"));

        Comparator<Model> comparator = new ReferenceComparator();
        Strategy listComparator = new AuditStrategy();

        List<Model> results = new ArrayList<>();

        listComparator.compare(from.getLeafs(), instance.getLeafs(), results, comparator);
    }

    /**
     * Test of getModel method, of class LinkedListCollection.
     */
    @Test
    public void testEMptyCache() {
        Node from = new ArrayListNode();
        Comparator<Model> comparator = new ReferenceComparator();
        Strategy listComparator = new AuditStrategy();
        List<Model> results = new ArrayList<>();
        listComparator.compare(instance.getLeafs(), from.getLeafs(), results, comparator);
    }

    /**
     * Test of addModel method, of class LinkedListCollection.
     */
    @Test
    public void testIdentityCompare() {
        Node from = new ArrayListNode();
        Comparator<Model> comparator = new ReferenceComparator();
        Strategy listComparator = new AuditStrategy();
        List<Model> results = new ArrayList<>();
        listComparator.compare(instance.getLeafs(), instance.getLeafs(), results, comparator);
    }

    /**
     * Test of removeModel method, of class LinkedListCollection.
     */
    @Test
    public void testIdentityEmpty() {
        Node from = new ArrayListNode();
        Comparator<Model> comparator = new ReferenceComparator();
        Strategy listComparator = new AuditStrategy();
        List<Model> results = new ArrayList<>();
        listComparator.compare(from.getLeafs(), from.getLeafs(), results, comparator);
    }

}
