package com.its.exceptions;

import com.its.es2.Node;

public class NodeAlreadyExistsException extends Exception {
	
	Node n;
	
	public NodeAlreadyExistsException(Node existingNode){ // generic 
		super(); 
		this.n = existingNode;
	} 
	
	public NodeAlreadyExistsException(String message, Node existingNode){ // accepts a messa
		super(message);
		this.n = existingNode;
	}
	
	public Node getNode(){
		return this.n;
	}
	
//	@Override
//	public String getMessage(){
//		return super.getMessage() + " -- " + n.getValue();
//	}
}
