package mx.kiteso.Graph.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
	int id;
	List<Double> coords;

	double latitude;
	double longitude;
	boolean nodoDefinitivo;
	ArrayList<Link> links = new ArrayList<Link>();
	Tag tag;

	public Node(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.nodoDefinitivo = false;
	}
	
	//getters and setters
	public int getId() { return this.id; }
	public double getLatitude(){
		return coords.get(0);
	}
	public double getLongitude(){
		return coords.get(1);
	}
	public ArrayList<Node> getAdyacentedNodes() {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		for(int i=0; i < links.size(); i++) {
			nodeList.add(links.get(i).getTarget());
		}
		return nodeList;
	}
	
	public void setLatitude(double latitude){
		this.latitude= latitude;
	}
	public void setLongitude(double longitude){
		this.longitude= longitude;
	}
	public void setNodoDefinitivo(boolean nodoDefinitivo) {this.nodoDefinitivo= nodoDefinitivo;}
	public void setTag(Tag tag) {this.tag = tag;}

	public void addLink(Node target){
		Link newLink = new Link(this, target);
		links.add(newLink);
	}
}
