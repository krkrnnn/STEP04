class PageRankEdge{
    String fromName; //矢印の元のノードの名前
    String toName; //矢印の先のノードの名前
    int moveNum; //矢印上を移動する値

    PageRankEdge(String fromName, String toName, int moveNum){
	this.fromName = fromName;
	this.toName = toName;
	this.moveNum = moveNum;
    }
}
