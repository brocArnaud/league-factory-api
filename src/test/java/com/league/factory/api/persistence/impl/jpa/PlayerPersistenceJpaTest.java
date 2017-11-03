/*
 * Created on 2017-10-13 ( Date ISO 2017-10-13 - Time 10:51:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package com.league.factory.api.persistence.impl.jpa;

import org.junit.Test;

import com.league.factory.api.persistence.PlayerPersistence ;
import com.league.factory.api.persistence.PlayerPersistenceGenericTest;

/**
 * JUnit tests for Player persistence service
 * 
 * @author Telosys Tools
 *
 */
public class PlayerPersistenceJpaTest extends PlayerPersistenceGenericTest {

	@Test
	public void testPersistenceService() {

    	PlayerPersistence persistenceService = new PlayerPersistenceJpa();


    	testPersistenceServiceWithAutoincrementedKey(persistenceService);
	}	
}
