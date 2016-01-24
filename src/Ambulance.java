import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ambulance extends Vehicle {
	public boolean finish = false;
	public int activeTurn;
    private int wait3count = 0;
    private boolean active;
    private boolean HaveAPatient;
    public ArrayList <String> ShortestPath = new ArrayList <String>();
    public Node destinationNode;
    public Node rootNode;
   
    public Ambulance (String Name, String activeturn)
    {
        this.activeTurn = Integer.parseInt(activeturn);
        this.keyname = Name;
        active = false;
    }
    ArrayList<Node> VisitedNodes = new ArrayList<Node>();
    public void ambulanceShortestPath()
	{
		Queue<Node> NodeQueue = new LinkedList<Node>();
		NodeQueue.add(currentnode);
		while (true)
		{
			Node tempnode = NodeQueue.remove();
			VisitedNodes.add(tempnode);
			if (tempnode.key == destinationNode.key)
			{
				break;
			}
			else
			{
				if(tempnode.GetNodeE() != null)
				{
					if(!isVisitedNode(tempnode.GetNodeE().key))
					NodeQueue.add(tempnode.GetNodeE());
				}
				if(tempnode.GetNodeW() != null)
				{
					if(!isVisitedNode(tempnode.GetNodeW().key))
					NodeQueue.add(tempnode.GetNodeW());
				}
				if(tempnode.GetNodeS() != null)
				{
					if(!isVisitedNode(tempnode.GetNodeS().key))
					NodeQueue.add(tempnode.GetNodeS());
				}
				if(tempnode.GetNodeN() != null)
				{
					if(!isVisitedNode(tempnode.GetNodeN().key))
					NodeQueue.add(tempnode.GetNodeN());
				}
			}
			
		}
		//reversing path
		GetPathFromBFS(destinationNode);
		while (true)
		{
			if(!reversepath.isEmpty())
			{
				String a = reversepath.pop();
				ShortestPath.add(a);
				
			}
			else
			{
				break;
			}
		}
	}
    private boolean isVisitedNode(String a) // path findingte önceden gezilmiþ noktalarý bulmak için kullanýlýyor
    {
    	boolean alfa = false;
    	for (int i = 0; i < VisitedNodes.size(); i++) {
			if (VisitedNodes.get(i).key.equals(a))
			{
				alfa = true;
				break;
			}
		}
    	return alfa;
    }
    public Stack<String> reversepath= new Stack<String>();
    private void GetPathFromBFS(Node a)
    {
    	if (!a.key.equals(rootNode.key))
    	{
    		for (int i = 0; i < VisitedNodes.size(); i++) {
    			if (VisitedNodes.get(i).GetNodeE() != null && VisitedNodes.get(i).GetNodeE().key.equals(a.key))
    			{
    				reversepath.push("E");
    				GetPathFromBFS(VisitedNodes.get(i));
    				break;
    				
    			}
    			else if (VisitedNodes.get(i).GetNodeW() != null && VisitedNodes.get(i).GetNodeW().key.equals(a.key))
    			{
    				reversepath.push("W");
    				GetPathFromBFS(VisitedNodes.get(i));
    				break;
    			}
    			else if (VisitedNodes.get(i).GetNodeN() != null && VisitedNodes.get(i).GetNodeN().key.equals(a.key))
    			{
    				reversepath.push("N");
    				GetPathFromBFS(VisitedNodes.get(i));
    				break;
    			}
    			else if (VisitedNodes.get(i).GetNodeS() != null && VisitedNodes.get(i).GetNodeS().key.equals(a.key))
    			{
    				reversepath.push("S");
    				GetPathFromBFS(VisitedNodes.get(i));
    				break;
    			}
    		}
    	}
    	
    }
    public void NextMove(int time)
    {
    	if (time >= activeTurn )
    	{
    		if(!finish)
    		{
    			if(ShortestPath.size() != 0)
    	    	{
    	    		String Move = ShortestPath.get(0);
    	    		ShortestPath.remove(0);
    	    		if(Move.equals("E"))
    	    		{
    	    			if (currentnode.GetNodeE().getCarSize() == 4)
    	    			{
    	    				currentnode.GetNodeE().removeAnotherVehicle();
    	    			}
    	    			currentnode.removeVehicle(keyname);
    	    			lastNode =currentnode;
    	    			currentnode = currentnode.GetNodeE();
    	    			currentnode.addVehicle(this);
    	    				
    	    		}
    	    		else if(Move.equals("W"))
    	    		{
    	    			if (currentnode.GetNodeW().getCarSize() == 4)
    	    			{
    	    				currentnode.GetNodeW().removeAnotherVehicle();
    	    			}
    	    			currentnode.removeVehicle(keyname);
    	    			lastNode =currentnode;
    	    			currentnode = currentnode.GetNodeW();
    	    			currentnode.addVehicle(this);
    	    				
    	    		}
    	    		if(Move.equals("N"))
    	    		{
    	    			if (currentnode.GetNodeN().getCarSize() == 4)
    	    			{
    	    				currentnode.GetNodeN().removeAnotherVehicle();
    	    			}
    	    			currentnode.removeVehicle(keyname);
    	    			lastNode =currentnode;
    	    			currentnode = currentnode.GetNodeN();
    	    			currentnode.addVehicle(this);
    	    				
    	    		}
    	    		if(Move.equals("S"))
    	    		{
    	    			if (currentnode.GetNodeS().getCarSize() == 4)
    	    			{
    	    				currentnode.GetNodeS().removeAnotherVehicle();
    	    			}
    	    			currentnode.removeVehicle(keyname);
    	    			lastNode =currentnode;
    	    			currentnode = currentnode.GetNodeS();
    	    			currentnode.addVehicle(this);
    	    				
    	    		}
    	    	}
    	    	else
    	    	{
    	    		if(HaveAPatient)
    	    		{
    	    			if (wait3count == 2)
    	    			{
    	    				finish = true;
    	    				currentnode.removeVehicle(keyname);
    	    			}
    	    			else
    	    			{
    	    				wait3count ++;
    	    				if(wait3count == 2)
    	    				{
    	    					Node tempnode = destinationNode;
    	            			destinationNode = rootNode;
    	            			rootNode = tempnode;
    	            			VisitedNodes = new ArrayList<Node>();
    	            			ambulanceShortestPath();
    	    				}
    	    				
    	    			}
    	    		}
    	    		else
    	    		{
    	    			HaveAPatient = true;
    	    			
    	    		}
    	    	}
    		}
    	}
    	
    }
    
    
    
    
    public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public int getActiveTurn() {
		return activeTurn;
	}


	public void setActiveTurn(int activeTurn) {
		this.activeTurn = activeTurn;
	}
}