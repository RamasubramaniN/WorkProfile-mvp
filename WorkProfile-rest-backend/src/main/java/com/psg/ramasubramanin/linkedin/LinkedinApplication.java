package com.psg.ramasubramanin.linkedin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories(basePackages = "com.psg.ramasubramanin.linkedin")
@SpringBootApplication
public class LinkedinApplication {
	public static void main(String[] args) {
		SpringApplication.run(LinkedinApplication.class, args);
		System.out.println("Linkedin Application Started...");
	}
}
