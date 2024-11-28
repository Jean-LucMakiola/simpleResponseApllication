package com.example.simpleresponse.springapi.service;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.List;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        // Query to find the maximum ID
        int maxId = (int)session.createQuery("SELECT COALESCE(MAX(id), 0) FROM User").uniqueResult();

        // Check for gaps in IDs
        List<Integer> existingIds = session.createQuery("SELECT id FROM User", Integer.class).getResultList();

        for (int i = 1; i <= maxId + 1; i++) {
            if (!existingIds.contains(i)) {
                return i; // Return the first available gap
            }
        }

        return maxId + 1; // If no gaps, return the next sequential ID
    }
}
