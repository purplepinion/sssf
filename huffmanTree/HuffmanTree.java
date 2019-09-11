package com.chrisz.algorithm.example.huffmanTree;

import java.util.*;

public class HuffmanTree {

    Node root;

    Map<Character,Integer> charToWeightMap;

    Map<Integer, List<String>> weightToCodeMap;

    public static void main(String[] args) {

        int[] test = {1,1,1,2,2,2,4,4,4,5,5,9};
        HuffmanTree huffmanTree = new HuffmanTree(test);

        huffmanTree.decode();

        Map<Integer, List<String>> codes = huffmanTree.weightToCodeMap;

        for (Map.Entry keyAndValue : codes.entrySet()
                ) {
            Integer key = (Integer) keyAndValue.getKey();
            List<String> codeList = (List<String>) keyAndValue.getValue();
            for (int i = 0; i < codeList.size(); i++) {
                System.out.println("weight:" + key + "code:" + codeList.get(i));
            }

        }

//        o: 1000   u: 10010  d: 100110  y: 100111  i: 101
//        a : 110     k: 1110    e: 1111       j: 0000       v: 0001
//        l: 001          : 01

//        weight:1code:10010
//        weight:1code:100110
//        weight:1code:100111
//        weight:2code:0000
//        weight:2code:0001
//        weight:2code:1000
//        weight:4code:001
//        weight:4code:1110
//        weight:4code:1111
//        weight:5code:101
//        weight:5code:110
//        weight:9code:01


    }

    HuffmanTree(int[] weights) {
        Node[] nodes = new Node[weights.length];

        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < weights.length; i++) {
            nodes[i] = new Node(weights[i]);

            minHeap.offer(nodes[i]);
        }

        while (minHeap.size() > 1) {
            Node node1 = minHeap.poll();
            Node node2 = minHeap.poll();

            Node newNode = new Node(node1.val + node2.val);

            if (node1.val <= node2.val) {
                newNode.left = node1;
                newNode.right = node2;
            } else {
                newNode.left = node2;
                newNode.right = node1;
            }

            minHeap.offer(newNode);
        }

        root = minHeap.poll();

    }

    public void decode() {
        weightToCodeMap = new HashMap<Integer, List<String>>();

        String code = "";

        decodeHelper(root.left, code, 0, weightToCodeMap);
        decodeHelper(root.right, code, 1, weightToCodeMap);
    }

    private void decodeHelper(Node root,
                              String code,
                              Integer leftOrRight,
                              Map<Integer, List<String>> weightToCodeMap) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            List<String> codeList = weightToCodeMap.get(root.val);
            if(codeList==null){
                codeList = new ArrayList<String>();
            }
            codeList.add(code + leftOrRight);
            weightToCodeMap.put(root.val, codeList);
            //System.out.println(code + leftOrRight);
            return;
        }

        if (root.left != null) {

            decodeHelper(root.left, code + leftOrRight, 0, weightToCodeMap);
        }

        if (root.right != null)

            decodeHelper(root.right, code + leftOrRight, 1, weightToCodeMap);
        }


    }




class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}