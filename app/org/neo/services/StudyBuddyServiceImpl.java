/*
 * Copyright (c)  [2011-2015] "Neo Technology" / "Graph Aware Ltd."
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with separate copyright notices and license terms. Your use of the source code for these subcomponents is subject to the terms and conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 *
 */

package org.neo.services;

import org.neo.Neo4jSessionFactory;
import org.neo.models.StudyBuddy;

import java.util.Collections;
import java.util.Map;

//@Service("studyBuddyService")
public class StudyBuddyServiceImpl extends GenericService<StudyBuddy> implements StudyBuddyService {

    @Override
    public Iterable<Map<String,Object>> getStudyBuddiesByPopularity() {
        String query = "MATCH (s:StudyBuddy)-[:BUDDY]->(p:Student) return p, count(s) as buddies ORDER BY buddies DESC";
        return Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, Collections.EMPTY_MAP);
    }

    @Override
    public Class<StudyBuddy> getEntityType() {
        return StudyBuddy.class;
    }
}
