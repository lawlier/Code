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
		//��ɫ��ʱ�������
		this.color = (int)(Math.random() * 10);
	}
	public void addEdge(Edge e){
		//���һ����
		if(e1 == null)
			e1 = e;
		else 
			e2 = e;
	}
	public Edge getOtherEdge(Edge e){
		//��ȡ���e���ȵ���һ����
		if(e == e1 && e2 != null)
			return e2;
		else if(e1 != null)
			return e1;
		else 
			return null;
	}
	public void setOtherEdge(Edge last, Edge e){
		//������last�����һ����Ϊe
		if(last == e1){
			e1 = e;
		}else{
			e2 = e;
		}
	}
	public Edge getCommonEdge(Node p){
		//��ȡ��p�ڵ㹲�еı�
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
		//�ϲ������ڵ����ɫ
		this.color = (color1 + color2) % 10;
	}
	public Node mergeAdd(Node p){
		
		setColor(color, p.getColor());
		this.value += p.getValue();
		//������ڵ������ı�
		setOtherEdge(getCommonEdge(p),p.getOtherEdge(getCommonEdge(p))); 
		return this;
	}
	public Node mergeMulti(Node p){
		setColor(color, p.getColor());
		this.value *= p.getValue();
		//������ڵ������ı�
		setOtherEdge(getCommonEdge(p),p.getOtherEdge(getCommonEdge(p))); 
		return this;
	}
}
