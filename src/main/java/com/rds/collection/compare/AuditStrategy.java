/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rds.collection.compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gadieichhorn
 */
public class AuditStrategy<T extends Model>  implements Strategy<T> {

    private static final Logger logger = LoggerFactory.getLogger(AuditStrategy.class);

    
    @Override
    public void compare(List<T> dto, List<T> cache, List<T> results, Comparator<T> comparator) {
        Collections.sort(dto, comparator);

        Iterator<T> from = dto.iterator();
        Iterator<T> to = cache.iterator();

        T lhs = from.hasNext() ? from.next() : null;
        T rhs = to.hasNext() ? to.next() : null;

        while (lhs != null && rhs != null) {
            int diff = comparator.compare(lhs, rhs);
            logger.info("From: {}", lhs.getReference());
            logger.info("To: {}", rhs.getReference());

            if (diff < 0) {
                logger.info("Create a new Property from LHS: {}", lhs.getReference());
                results.add(lhs);
                lhs = from.hasNext() ? from.next() : null;
                //fail();
            }

            if (diff > 0) {
                logger.info("Remove a Property from RHS: {}", rhs.getReference());
                results.add(rhs);
                rhs = to.hasNext() ? to.next() : null;
                //fail();
            }

            if (diff == 0) {
                logger.info("Compare Properties");
                results.add(lhs);
                lhs = from.hasNext() ? from.next() : null;
                rhs = to.hasNext() ? to.next() : null;
            }

        }

        while (lhs != null) {
            logger.info("Create a new Property from LHS: {}", lhs.getReference());
            results.add(lhs);
            lhs = from.hasNext() ? from.next() : null;
        }

        while (rhs != null) {
            logger.info("Remove a Property in from RHS: {}", rhs.getReference());
            results.add(rhs);
            rhs = to.hasNext() ? to.next() : null;
        }
    }

}
