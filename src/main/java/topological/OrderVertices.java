package topological;

import java.util.*;

public class OrderVertices {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        Map<Integer,Integer> inDegree = new HashMap<>(); // mapping of number of incoming nodes
        Map<Integer,List<Integer>> graph = new HashMap<>(); // mapping of parent to child nodes
        Queue<Integer> sources = new LinkedList<>();
        // intialize indegree and graph
        for(int i=0;i<vertices;i++){
            inDegree.put(i,0);
            graph.put(i,new ArrayList<>());
        }

        // build the graph from edges
        for(int i=0;i<edges.length;i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child);
            inDegree.put(child,inDegree.get(child) + 1);
        }
        // find source and offer to queue
        for(Map.Entry<Integer, Integer> edge : inDegree.entrySet()){
            if(edge.getValue()==0)
                sources.offer(edge.getKey());
        }
        for(int c : inDegree.keySet()){
            
        }

        while(!sources.isEmpty()){
            int source = sources.poll();
            sortedOrder.add(source);
            // now reduce from indegree
            List<Integer> childrens = graph.get(source);
            for(int child : childrens ){
                inDegree.put(child,inDegree.get(child) -1);
                if(inDegree.get(child) == 0) // offer to source
                    sources.offer(child);
            }
        }

        if(sortedOrder.size()!= vertices)
            return new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = OrderVertices.sort(5,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 1, 3 },new int[] { 1, 4 }  });
        System.out.println(result);

//        result = OrderVertices.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
//                new int[] { 2, 1 }, new int[] { 3, 1 } });
//        System.out.println(result);
//
//        result = OrderVertices.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
//                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
//        System.out.println(result);
    }
}
