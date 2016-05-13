package year_2016.polygongame;
/*
 * 边类
 * 
 */
public class Edge {
	private Node p1, p2; //与边直接相连的两个顶点
	private int index;//边的序号
	private char op; //操作符
	public Edge(Node p1, Node p2, char op, int index){
		//构造函数
		this.p1 = p1;
		this.p2 = p2;
		this.index = index;
		this.op = op;
		p1.addEdge(this);
		p2.addEdge(this);
	}
	public void setNode(Node p1, Node p2, Node p){
		//将与p1或者p2相等的节点重新赋值为新的节点p
		if( this.p1 == p1 || this.p2 == p1 )
			this.p1 = p;
		else if( this.p2 == p1 || this.p2 == p2){
			this.p2 = p;
		}
	}

	public void setNode1(Node p){
		this.p1 = p;
	}
	public void setNode2(Node p){
		this.p2 = p;
	}
	public Node getNode1(){
		return p1;
	}
	public Node getNode2(){
		return p2;
	}
	public char getOp(){
		return op;
	}
	public void merge(){
		//合并边的两个节点
		//合并后的新节点
		Node p = null;
		if(op == '+'){
			p = p1.mergeAdd(p2);
		}else{
			p = p1.mergeMulti(p2);
		}
		//更新与边相邻的其他边的节点值
		Edge otherEdge1 = p1.getOtherEdge(this);
		if(otherEdge1 != null){
			otherEdge1.setNode(p1, p2, p);
		}
		Edge otherEdge2 = p2.getOtherEdge(this);
		if(otherEdge2 != null){
			otherEdge2.setNode(p1, p2, p);
		}
	}
	
}
