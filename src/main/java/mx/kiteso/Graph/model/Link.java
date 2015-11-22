package mx.kiteso.Graph.model;

public class Link {
	Node source;
	Node target;
	double weight;

	//constructor By Luis R
	public Link(Node source, Node target) {
		this.source = source;
		this.target = target;
		this.weight = calculateWeight(source, target);
	}

	//getters and setters
	public Node getSource(){
		return this.source;
	}
	public Node getTarget(){
		return this.target;
	}
	public double getWeight(){
		return this.weight;
	}
	
	public void setSource(Node source){
		this.source= source;
	}
	public void setTarget(Node target){
		this.target= target;
	}
	public void setWeight(double weight){
		this.weight= weight;
	}

	//Calcular ponderacion del link
	private double calculateWeight(Node source, Node target){
		double a;
		double b;
		double c;

		a= source.getLatitude() - target.getLatitude();
		b = source.getLongitude() - target.getLongitude();
		c = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));

		return c;
	}
}
