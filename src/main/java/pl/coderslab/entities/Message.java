package pl.coderslab.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	private String content;
	
	private User sender;
	
	private User reciever;
	
	private boolean isItRead;
}
