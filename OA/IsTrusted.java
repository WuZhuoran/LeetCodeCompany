/*

Your task is to check whether a given node within a trust graph is considered trusted or not, and return true of false accordingly.

A node is considered trusted if it has a trust distance of trustedDistance or less from any pre-trusted peer in the graph. Trust distance is calculated by finding a shortest path between two nodes, measured by summing up all of the edge weights specified in trustGraph. Pre-trusted peers are specified using an array of pre-trusted peer indices in prestrustedPeers.

Notes:

The trustGraph is represented by an NxN symmetric adjecency matrix where edge weights are represented by positive integers. The lack of an edge is represented with a 0 value.
The trust graph can contain cycles.
If node itself is listed in the pretrustedPeers array, then it is trusted.
Inputs and Outputs:

[execution time limit] 3 seconds (java)

[input] integer node

The index of the node that you want to check whether it's trusted or not.

[input] array.array.integer trustGraph

The graph of trust relationships between nodes, represented as an adjacency matrix. This graph is symmetric and can contain loops. A value of 0 indicates no edge between nodes, and a positive value represents the trust edge weight.

[input] array.integer pretrustedPeers

List of pre-trusted peers

[input] integer trustThreshold

The max trust distance from a pre-trusted peer to be considered trusted.

[output] boolean

Whether node is considered trusted or not (ie whether it has a trust distance that is less than or equal to trustThreshold, from a node in pretrustedPeers.
[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}

*/

boolean IsTrusted(int node, int[][] trustGraph, int[] pretrustedPeers, int trustThreshold) {
    if (trustGraph == null) {
        return false;
    }

    int[] distance = new int[trustGraph.length];

    dijkstra(trustGraph, node, distance);

    // for (int i = 0; i < trustGraph.length; i++) {
    //     System.out.println("From node 0 To node " + i + " distance: " + distance[i]);
    // }

    boolean flag = false;

    for (int i = 0; i < pretrustedPeers.length; i++) {
        int n = pretrustedPeers[i];
        int dist = distance[n];
        if (dist <= trustThreshold) {
            flag = true;
            break;
        }
    }

    return flag;
}

int getMinNode(boolean[] mst, int[] key, int nodes) {
    int minKey = Integer.MAX_VALUE;
    int node = -1;
    for (int i = 0; i < nodes; i++) {
        if(mst[i] == false && minKey > key[i]) {
            minKey = key[i];
            node = i;
        }
    }
    return node;
}

void dijkstra(int[][] trustGraph, int node, int[] distance) {

    int dist = 0;

    int nodes = trustGraph.length;

    boolean[] spt = new boolean[nodes];

    for (int i = 0; i < nodes; i++) {
        distance[i] = Integer.MAX_VALUE;
    }

    distance[node] = 0;

    for (int i = 0; i < nodes; i++) {
        int nodeU = getMinNode(spt, distance, nodes);

        spt[nodeU] = true;

        for (int nodeV = 0; nodeV < nodes; nodeV++) {
            if(trustGraph[nodeU][nodeV] > 0) {
                if (spt[nodeV] == false && trustGraph[nodeU][nodeV] != Integer.MAX_VALUE) {
                    int newKey = trustGraph[nodeU][nodeV] + distance[nodeU];
                    if(newKey < distance[nodeV]) {
                        distance[nodeV] = newKey;
                    }
                }
            }
        }
    }
}
