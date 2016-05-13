package year_2016.polygongame;

public class Node {
	private float x, y;
	private int value;
	private int color;
	private Edge e1, e2;
	
	public Node(float x, float y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		//颜色暂时随机生成
		this.color = (int)(Math.random() * 10);
	}
	public void addEdge(Edge e){
		//添加一条边
		if(e1 == null)
			e1 = e;
		else 
			e2 = e;
	}
	public Edge getOtherEdge(Edge e){
		//获取与边e不等的另一条边
		if(e == e1 && e2 != null)
			return e2;
		else if(e1 != null)
			return e1;
		else 
			return null;
	}
	public void setOtherEdge(Edge last, Edge e){
		//设置与last相等另一条边为e
		if(last == e1){
			e1 = e;
		}else{
			e2 = e;
		}
	}
	public Edge getCommonEdge(Node p){
		//获取与p节点共有的边
		if( p.e1 == e1 || p.e1 == e2 ){
			return p.e1;
		}else if (p.e2 == e1 || p.e2 == e2){
			return p.e2;
		}else{
			return null;
		}
	}
	public void setValue(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public int getColor(){
		return color;
	}
	public void setColor(int color1,int color2){
		//合并两个节点的颜色
		this.color = (color1 + color2) % 10;
	}
	public Node mergeAdd(Node p){
		
		setColor(color, p.getColor());
		this.value += p.getValue();
		//更新与节点相连的边
		setOtherEdge(getCommonEdge(p),p.getOtherEdge(getCommonEdge(p))); 
		return this;
	}
	public Node mergeMulti(Node p){
		setColor(color, p.getColor());
		this.value *= p.getValue();
		//更新与节点相连的边
		setOtherEdge(getCommonEdge(p),p.getOtherEdge(getCommonEdge(p))); 
		return this;
	}
}
