
public class Vehicle {
    protected String keyname;
    protected Node lastNode;
    protected Node currentnode ;
    protected int stat_wait = 0;
	public Node getCurrentnode() {
		return currentnode;
	}
	public void setCurrentnode(Node currentnode) {
		this.currentnode = currentnode;
	}
}