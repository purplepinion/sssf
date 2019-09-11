package com.chrisz.algorithm.example.hash;

public class HashTable {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        for (int i = 0; i < 100; i++) {
            hashTable.add(i,i*2);
        }

        hashTable.list();
    }

    private LinkedList[] hashTable = null;


    HashTable(int size){
        hashTable = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList();
        }
    }
    public void add(int key,int val){

        int insertPos = hash(key);
        LinkedList curList = hashTable[insertPos];

        curList.add(new Node(key, val));
    }

    public int get(int key){
        int insertPos = hash(key);
        LinkedList curList = hashTable[insertPos];

        return curList.get(key).val;
    }

    public int hash(int key){

        return key % hashTable.length;
    }

    public void list(){
        for (int i = 0; i < hashTable.length; i++) {
            LinkedList curList = hashTable[i];
            System.out.println("第" + i + "个链表：");
            Node cur = curList.head;
            while (cur!=null){
                System.out.println("key: " + cur.key + ",val: " + cur.val);
                cur = cur.next;
            }
        }
    }
}

class Node{
    int key;
    int val;
    Node next;

    Node(int key,int val){
        this.key = key;
        this.val = val;
        next = null;
    }
}

class LinkedList{
    Node head;

    LinkedList(){

    }

    public void add(Node node){
        if (head == null){
            head = node;
            return;
        }

        Node cur = head;

        while (cur.next!=null){
            if(cur.key == node.key){
                cur.val = node.val;
                return;
            }
            cur = cur.next;
        }

        cur.next = node;
    }

    public Node get(int key){
        if(head == null){
            return null;
        }

        Node cur = head;

        while (cur!=null){
            if(cur.key==key){
                return new Node(cur.key,cur.val);
            }
            cur = cur.next;
        }

        return null;
    }
}