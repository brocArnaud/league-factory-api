/*
 * Created on 2017-10-13 ( Date ISO 2017-10-13 - Time 10:51:31 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package com.league.factory.api.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import com.league.factory.api.data.record.PlayerRecord ;

/**
 * Generic test class for a persistence service
 * 
 * @author Telosys 
 *
 */
public class PlayerPersistenceGenericTest {

	/**
	 * Persistence service generic test for a record with an auto-incremented key
	 * @param persistenceService
	 * @throws SQLException
	 */
	public void testPersistenceServiceWithAutoincrementedKey(PlayerPersistence persistenceService) {
    	System.out.println("--- test PlayerPersistence ");

		long initialCount = persistenceService.countAll() ;
    	System.out.println("Initial count = " + initialCount );

    	//--- CREATE #1
    	PlayerRecord record = new PlayerRecord();
		// Set initial values ( auto-incremented key : nothing to set in the Primary Key )
		record.setName("A"); // "name" : java.lang.String
		record.setTeam(Long.valueOf(1000L)); // "team" : java.lang.Long
    	System.out.println("Create : " + record);
    	persistenceService.create(record);
		// Retrieve the generated id 
		long generatedId = record.getId() ;
    	System.out.println("Generated id #1 = " + generatedId ); 
    	assertTrue( persistenceService.exists(generatedId) );
		assertTrue( persistenceService.exists(record) );
		long count = persistenceService.countAll() ;
    	System.out.println("Count = " + count );
		assertEquals(initialCount+1, count );

    	//--- CREATE #2
		record = new PlayerRecord();  // A new instance is mandatory for JPA 
		// Set initial values ( auto-incremented key : nothing to set in the Primary Key )
		record.setName("A"); // "name" : java.lang.String
		record.setTeam(Long.valueOf(1000L)); // "team" : java.lang.Long
		persistenceService.create(record);
		// Retrieve the generated id 
		long generatedId2 = record.getId() ;
    	System.out.println("Generated id #2 = " + generatedId2 ); 
    	long nextId = generatedId ; nextId++ ;
		assertEquals(nextId, generatedId2 );

    	//--- CREATE #3
		record = new PlayerRecord();  // A new instance is mandatory for JPA 
		// Set initial values ( auto-incremented key : nothing to set in the Primary Key )
		record.setName("A"); // "name" : java.lang.String
		record.setTeam(Long.valueOf(1000L)); // "team" : java.lang.Long
		persistenceService.create(record);
		// Retrieve the generated id 
		long generatedId3 = record.getId() ;
    	System.out.println("Generated id #3 = " + generatedId3 ); 
    	long nextId2 = generatedId2 ; nextId2++ ;
		assertEquals(nextId2, generatedId3 );

    	//--- FIND #1
    	System.out.println("Find by id #1 ..." );
    	PlayerRecord record1 = persistenceService.findById(generatedId);
    	System.out.println("Found : " + record1 );
    	assertNotNull(record1);
    	assertTrue( persistenceService.exists(record1) ) ;

    	//--- FIND #2
    	System.out.println("Find by id #2 ..." );
    	PlayerRecord record2 = persistenceService.findById(generatedId2);
    	System.out.println("Found : " + record2 );
    	assertNotNull(record2);
    	assertTrue( persistenceService.exists(record2) ) ;

    	//--- UPDATE
		//--- Change values
		record2.setName("B"); // "name" : java.lang.String
		record2.setTeam(Long.valueOf(2000L)); // "team" : java.lang.Long
    	System.out.println("Update : " + record2 );
    	assertTrue( persistenceService.update(record2) );

    	//--- RELOAD AFTER UPDATE
    	System.out.println("Find by id..." );
    	PlayerRecord record2reloaded = persistenceService.findById(generatedId2);
    	assertNotNull(record2reloaded);
    	System.out.println("Found : " + record2reloaded );

		// Check same data in the reloaded instance
		assertEquals(record2.getName(), record2reloaded.getName() ); 
		assertEquals(record2.getTeam(), record2reloaded.getTeam() ); 

    	//--- DELETE
    	System.out.println("Delete : " + record2 );
    	assertTrue(  persistenceService.delete(record2) ); // First delete : OK
    	assertFalse( persistenceService.delete(record2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(generatedId2) ); // Nothing (already deleted)

	}
}
