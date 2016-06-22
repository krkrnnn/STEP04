import java.util.*;
public class RunPageRank{
    static PageRankNode[] nodes;
    public static void main(String[] args){
	

	
	Scanner sc = new Scanner(System.in);

	int nodeNum = sc.nextInt(); //ページの数
	PageRankNode[] nodes = new PageRankNode[nodeNum]; //ページの数の大きさの配列生成
	//nodes[0].value = sc.nextInt();
	for(int i = 0; i< nodeNum; i++){
	    nodes[i].name = sc.next(); //ノードの名前の設定
	    nodes[i].value = 100; //ノードの値の初期値を100にする
	}

	int edgeNum = sc.nextInt(); //矢印の数
	PageRankEdge[] edges = new PageRankEdge[edgeNum]; //矢印の数の配列生成
	for(int i = 0; i < edgeNum; i++){
	    edges[i].fromName = sc.next();
	    edges[i].toName = sc.next();
	}

	int count = 0;
	while(count < 1000){//とりあえず1000回動かして見る
	    for(int i = 0; i<edgeNum; i++){//それぞれの矢印上を移動する値を決定する
		for(int j = 0; j< nodeNum; i++){
		    if(edges[i].fromName == nodes[j].name){
			edges[i].moveNum = nodes[j].value / 2;
		    }	
		}
	    }

	    //矢印上の数字を矢印の指している先に足す
	    for(int i = 0; i< edgeNum; i++){
		for(int j = 0; j< nodeNum; j++){
		    if(edges[i].toName == nodes[j].name){
			nodes[j].value = nodes[j].value + edges[i].moveNum;
		    }
		}
	    }
	}
	count++;



	for(int i = 0; i< nodeNum; i++){
	    System.out.println(nodes[i].name +":"+ nodes[i].value);
	}
    

    }
    
}
