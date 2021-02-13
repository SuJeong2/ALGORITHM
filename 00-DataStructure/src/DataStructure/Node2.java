package DataStructure;

public class Node2 {
	public String data;
	public Node2 link;
	
	public Node2(String data, Node2 link) {
		super();
		this.data=data;
		this.link=link;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node2 getLink() {
		return link;
	}
	public void setLink(Node2 link) {
		this.link = link;
	}
	
	public String toString() {
		return "Node [ data= "+this.data+", link= "+this.link+"]";
	}
}
