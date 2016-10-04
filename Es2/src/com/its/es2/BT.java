package com.its.es2;

import com.its.constants.constants;
import com.its.exceptions.NodeAlreadyExistsException;
import com.its.exceptions.NodeDoesNotExistException;

public class BT {
	private Node root;
	
	public BT(int value){
		root = new Node(value, null);
	}
	
	public Node getRoot(){
		return root;
	}
	
	public Node getNode(){
		return root;
	}
	
	public Node searchFirst(int element){
		return searchFirstRec(root, element);
	}
	
	private Node searchFirstRec(Node node, int element){
		Node l, r;
		if (node == null){
			return null;
		}
		else if (node.getValue() == new Integer(element)){
			return node;
		}
		l = searchFirstRec(node.getSx(), element);
		if (l != null){
			return l;
		}
		else {
			r = searchFirstRec(node.getSx(), element);
			return r;
		}
	}
	
	public Node insertRight(Node n, int value) throws NodeAlreadyExistsException{
		if (n.getDx() == null){
			n.setDx(value);
			return n;
		}
		else
			throw new NodeAlreadyExistsException(n.getDx());
	}
	
	public Node insertRightAgain(Node n, int value) throws NodeAlreadyExistsException{
		for (int i = 0; i < constants.MAX_REINSERT_ATTEMPTS; i++){
			if (n.getDx() == null){
				n.setDx(value);
				//System.out.println(i);
				return n;
			}
		}
		throw new NodeAlreadyExistsException(n.getDx());
	}
	
	public Node insertLeft(Node n, int value) throws NodeAlreadyExistsException{
		if (n.getSx() == null){
			n.setSx(value);
			return n;
		}
		else
			throw new NodeAlreadyExistsException(n.getSx());
	}
	
	public Node insertLeftAgain(Node n, int value) throws NodeAlreadyExistsException{
		for (int i = 0; i < constants.MAX_REINSERT_ATTEMPTS; i++){
			if (n.getSx() == null){
				n.setSx(value);
				//System.out.println(i);
				return n;
			}
		}
		throw new NodeAlreadyExistsException(n.getSx());
	}
	
	public void updateNode(Node n, int val){
		n.setValue(val);
	}
	
	public void deleteNode(Node n) throws Exception{
		if (n == null)
			throw new NodeDoesNotExistException();
		if (n.getFather().getDx() == n)
			n.getFather().setDx(null);
		if (n.getFather().getSx() == n)
			n.getFather().setSx(null);
	}
}
