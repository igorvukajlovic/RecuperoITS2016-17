package com.its.es2;

import com.its.exceptions.NodeAlreadyExistsException;
import com.its.exceptions.NodeDoesNotExistException;

public class Main {

	public static void main(String[] args) throws Exception {		
		BT t = new BT(2); // condizione di esistenza dell'albero � l'esistenza della root 
		Node root = t.getRoot();
		try{
			t.insertLeft(root, 3);
		} catch(NodeAlreadyExistsException e){
//			System.out.println(e.getNode());
			t.deleteNode(e.getNode());
			try{
				t.insertLeft(root, 3);
			} catch(NodeAlreadyExistsException e2){
				System.out.println(e2.getNode());
			}
		}
			
		Node nx = new Node(5, t.getNode());
		try{
			nx = t.insertRight(root, 3);
		} catch(NodeAlreadyExistsException e){
			//System.out.println(e.getNode());
			t.deleteNode(e.getNode());
			try{
				t.insertLeft(root, 3);
			} catch(NodeAlreadyExistsException e2){
				System.out.println(e2.getNode());
			}
		}
		
		try{
			t.insertLeft(nx, 5);
		} catch(NodeAlreadyExistsException e){
			//System.out.println(e.getNode());
			t.deleteNode(e.getNode());
			try{
				t.insertLeft(nx, 5);
			} catch(NodeAlreadyExistsException e2){
				System.out.println(e2.getNode());
			}
			
		}
		
		Node n5;
		n5 = t.searchFirst(3);
		try{
			t.deleteNode(n5);
		} catch (NodeDoesNotExistException e){
			System.out.println(e.getMessage());
		}
		
		t.updateNode(nx, 10);
		Node n3  = t.searchFirst(3);
		System.out.println("Is n3 != nx? It seems it's " + (n3 != nx));
	}
}
