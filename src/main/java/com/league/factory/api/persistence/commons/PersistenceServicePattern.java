/*
 * Created on 2017-10-13 ( Date ISO 2017-10-13 - Time 10:51:31 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package com.league.factory.api.persistence.commons;

/**
 * The pattern defined here is used by the Persistence Service Provider <br>
 * to build the service implementation class name <br>
 * 
 * @author Telosys
 *
 */
public class PersistenceServicePattern {

	// Set the persistence service class pattern below ...
	// public final static String PATTERN =
	// PersistenceFakeServicePattern.PATTERN ;

	// public final static String PATTERN =
	// PersistenceJdbcServicePattern.PATTERN ;
	public final static String PATTERN = PersistenceJpaServicePattern.PATTERN;
}
