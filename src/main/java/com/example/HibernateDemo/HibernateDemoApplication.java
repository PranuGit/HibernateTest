package com.example.HibernateDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.example.Model.Alien;
import com.example.Model.AlienName;

//@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(HibernateDemoApplication.class, args);
		
		AlienName name= new AlienName();
		name.setFname("Pranali");
		name.setLname("More");
		
		
		Alien telusko=new Alien();
		telusko.setAid(123);
		telusko.setAname(name); 
		telusko.setColour("Orange");
		
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Alien.class);
		
		StandardServiceRegistry reg= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		//ServiceRegistry reg=new  StandardServiceRegistryImpl(null, null, null, null)
		
		SessionFactory sessionFactory=configuration.buildSessionFactory(reg);
		
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		//telusko=(Alien)session.get(Alien.class,102);
		session.save(telusko);
		
		tx.commit();
		
		 System.out.print(telusko);
		
	}

}
