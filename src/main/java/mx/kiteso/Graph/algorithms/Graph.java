package mx.kiteso.Graph.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import mx.kiteso.Graph.model.Link;
import mx.kiteso.Graph.model.Node;
import mx.kiteso.Graph.model.Tag;

public class Graph {
	
	private static final double MAX_LATITUDE= 90;
	private static final double MIN_LATITUDE= -90;
	private static final double MAX_LONGITUDE= 180;
	private static final double MIN_LONGITUDE= -180;
	
	private ArrayList<Link> itesoGraph= null;

	public ArrayList<Node> nodes = new ArrayList<Node>();
	public ArrayList<Link> links = new ArrayList<Link>();
	
	/**
	 * Singleton instance
	 */
	private static Graph instance;
	public static synchronized Graph getInstance(){
		if(Graph.instance==null)
			Graph.instance= new Graph();
		return Graph.instance;
	}
	
	/**
	 * Constructor loads itesoGraph from JSON File
	 */
	public Graph() {
		//To implement...
	}

	public double searchLinkWeigh(Node source, Node target){
		for(int i=0; i<links.size(); i++) {
			if(links.get(i).getSource() == source && links.get(i).getTarget() == target)
				return links.get(i).getWeight();
		}

		return 0;
	}
	
	/**
	 * @return a list of links to walk through from source to target
	 */
	public ArrayList<Link> getShortestPath(Node source, Node target){
		ArrayList<Link> shortestPath = new ArrayList<Link>();

		Node nodoEvaluar = source;
		Node lastNode = source;
		int numeroIteracion = 0;
		source.setTag(new Tag(numeroIteracion,0,null));
		source.setNodoDefinitivo(true);

		numeroIteracion++;
		ArrayList<Node> adyacentNodes = nodoEvaluar.getAdyacentedNodes();
		for(int i=0; i < adyacentNodes.size(); i++) {
			adyacentNodes.get(i).setTag(new Tag(numeroIteracion,0,lastNode));
		}

		return shortestPath;
	}

	/*
			Metodo que convierte un archivo en formato JSON en una lista de nodos y la devuelve
	 */

	public List<Node> JsonNodes() {
		try{
			FileReader fileReader = new FileReader("nodes.json");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			Gson gson = new Gson();
			Type tipoListaNodos = new TypeToken<List<Node>>(){}.getType();
			List<Node> nodos = gson.fromJson(bufferedReader, tipoListaNodos);

			return nodos;
		}catch(Exception e) {
			System.out.print("ERROR");
			System.out.print(e);
			return null;
		}
	}
	
}
