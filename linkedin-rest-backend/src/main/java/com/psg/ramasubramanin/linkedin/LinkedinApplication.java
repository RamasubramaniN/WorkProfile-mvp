package com.psg.ramasubramanin.linkedin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={CassandraDataAutoConfiguration.class})
public class LinkedinApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedinApplication.class, args);
		System.out.println("Linkedin Application Started...");
	}

}
