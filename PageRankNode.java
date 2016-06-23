class PageRankNode{
    String name; //ノードの名前
    int value; //ページランクの値
    int goingEdgeNum; //そのノードから出て行っている矢印の数
    
    PageRankNode(String name, int value, int goingEdgeNum){
	this.name = name;
	this.value = value;
	this.goingEdgeNum = goingEdgeNum;
    }
}
