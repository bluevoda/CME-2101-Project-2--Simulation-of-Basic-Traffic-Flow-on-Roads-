import java.util.ArrayList;

public class Node {
	public ArrayList<Vehicle> vehicles = new ArrayList<>();
 	boolean isvisited = false; //GUI de kullanýlýyor
    public String key;
    private Node W = null;
    private Node S = null;
    private Node N = null;
    private Node E = null;
    private int carSize;
    private int posX = 0;
    private int posY = 0;
    public int stat_visits = 0;
    public void statwrite()
    {
    	stat_visits = stat_visits + carSize;
    }
    
    public Node (String Key)
    {
        key = Key;
        carSize = 0;
        
    }
    
	public int getCarSize() {
		return carSize;
	}

	public void setCarSize(int carSize) {
		this.carSize = carSize;
	}

	public Node GetNodeE ()
    {
        return E;
    }public Node GetNodeW ()
    {
        return W;
    }public Node GetNodeS ()
    {
        return S;
    }
    public Node GetNodeN ()
    {
        return N;
    }
    public void SetNodeE (Node n)
    {
        E = n;
    }
    public void SetNodeW (Node n)
    {
        W = n;
    }
    public void SetNodeS (Node n)
    {
        S = n;
    }
    public void SetNodeN (Node n)
    {
        N = n;
    }
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public void removeVehicle (String id )
	{
		for (int i = 0; i < vehicles.size(); i++) {
			if(vehicles.get(i).keyname.equals(id))
			{
				vehicles.remove(i);
				carSize --;
				break;
			}
		}
	}
	public void removeAnotherVehicle()
	{
		for (int i = 0; i < vehicles.size(); i++) {
			if(vehicles.get(i).keyname.toLowerCase().charAt(0) == 'c')
			{
				Car a = (Car) vehicles.get(i);
				a.MoveLikeHeuristic1();
			}
		}
	}
	public void addVehicle (Vehicle a)
	{
		vehicles.add(a);
		carSize ++;
	}
    
}