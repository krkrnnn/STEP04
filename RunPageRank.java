import java.util.*;
public class RunPageRank{
    static PageRankNode[] nodes;
    public static void main(String[] args){
	

	
	Scanner sc = new Scanner(System.in);

	int nodeNum = sc.nextInt(); //ページの数
	PageRankNode[] nodes = new PageRankNode[nodeNum]; //ページの数の大きさの配列生成

	for(int i = 0; i< nodeNum; i++){
	    String nodeName = sc.next();
	    nodes[i] = new PageRankNode(nodeName, 100, 0); //ノードの名前と値の設定
	}

	int edgeNum = sc.nextInt(); //矢印の数
	PageRankEdge[] edges = new PageRankEdge[edgeNum]; //矢印の数の配列生成
	for(int i = 0; i < edgeNum; i++){
	    String fromName = sc.next();
	    String toName = sc.next();
	    edges[i] = new PageRankEdge(fromName, toName, 0);//矢印の方向の設定
	}
	
	//ノードから何本矢印が出て行っているのかを数える
	for(int i = 0; i<nodeNum; i++){
	    int goingEdgeN = 0;
	    for(int j = 0; j< edgeNum; j++){
		if(nodes[i].name.equals( edges[j].fromName)){
		    goingEdgeN = goingEdgeN + 1;
		}	
	    }
	    nodes[i].goingEdgeNum = goingEdgeN;
	}
	
	int count = 0;
	while(count < 1000){//とりあえず1000回動かして見る
	    for(int i = 0; i<edgeNum; i++){//それぞれの矢印上を移動する値を決定する
		for(int j = 0; j< nodeNum; j++){
		    if(edges[i].fromName.equals(nodes[j].name)){
			edges[i].moveNum = nodes[j].value / nodes[j].goingEdgeNum;
		    }	
		}
	    }

	    //矢印で移動する値が決まったらノードの値を空に
	    for(int i = 0; i< nodeNum; i++){
		nodes[i].value = 0;
	    }

	    //矢印上の数字を矢印の指している先に足す
	    for(int i = 0; i< edgeNum; i++){
		for(int j = 0; j< nodeNum; j++){
		    if(edges[i].toName.equals(nodes[j].name)){
			nodes[j].value = nodes[j].value + edges[i].moveNum;
		    }
		}
	    }
	    count++;
	}



	for(int i = 0; i< nodeNum; i++){
	    System.out.println(nodes[i].name +":"+ nodes[i].value);
	}
    

    }
    
}
