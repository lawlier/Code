package year_2016.polygongame;
/*
 * ����
 * 
 */
public class Edge {
	private Node p1, p2; //���ֱ����������������
	private int index;//�ߵ����
	private char op; //������
	public Edge(Node p1, Node p2, char op, int index){
		//���캯��
		this.p1 = p1;
		this.p2 = p2;
		this.index = index;
		this.op = op;
		p1.addEdge(this);
		p2.addEdge(this);
	}
	public void setNode(Node p1, Node p2, Node p){
		//����p1����p2��ȵĽڵ����¸�ֵΪ�µĽڵ�p
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
		//�ϲ��ߵ������ڵ�
		//�ϲ�����½ڵ�
		Node p = null;
		if(op == '+'){
			p = p1.mergeAdd(p2);
		}else{
			p = p1.mergeMulti(p2);
		}
		//����������ڵ������ߵĽڵ�ֵ
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
