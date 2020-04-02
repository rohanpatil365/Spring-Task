package com.rohan.demoapp.utils;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerUtils {
	
	@Autowired
    @Qualifier("schemaOneEntityManager")
	private EntityManager schemaOneEntityManager;
	
	@Autowired
    @Qualifier("schemaTwoEntityManager")
	private EntityManager schemaTwoEntityManager;
	
	@Autowired
    @Qualifier("schemaThreeEntityManager")
	private EntityManager schemaThreeEntityManager;
	
	public EntityManager getEntitymanagerForSchema(int em_id){
        switch(em_id)
        {
         case 0:
        	 return schemaOneEntityManager;
         case 1:
        	 return schemaTwoEntityManager;
         case 2:
        	 return schemaThreeEntityManager;
         default:
        	 return schemaOneEntityManager;
        }
		//return schemaThreeEntityManager;
    }

    public JpaRepositoryFactory getJpaFactory(int id){
        return new JpaRepositoryFactory( getEntitymanagerForSchema(id));
    }
}
