/*
 * Created on 2017-10-13 ( Date ISO 2017-10-13 - Time 10:51:31 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package com.league.factory.api.persistence.commons;

import com.league.factory.api.commons.ImplementationProvider;

/**
 * Persistence service provider 
 * 
 * @author Telosys
 *
 */
public class PersistenceServiceProvider {

	private final static ImplementationProvider provider = new ImplementationProvider(PersistenceServicePattern.PATTERN);
	
	/**
	 * Returns the persistence service implementing the given interface
	 * @param interfaceClass
	 * @return
	 */
	public final static <T> T getService(Class<T> interfaceClass) {
		return provider.getServiceInstance(interfaceClass);
	}
	
}