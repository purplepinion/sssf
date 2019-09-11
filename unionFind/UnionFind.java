package com.chrisz.algorithm.example.unionFind;

public class UnionFind {

    private int[] father;
    private int[] size;
    private int count;

    public UnionFind(int n){
        father = new int[n+1];
        size = new int[n+1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
            size[i] = 1;

            count = n;
        }
    }

    public int find(int x){
        if(father[x]==x){
            return x;
        }

        //路径压缩
        return father[x] = find(father[x]);
    }

    public void union(int a,int b){
        int root_a = find(a);
        int root_b = find(b);

        if(root_a!=root_b){
            father[root_a] = root_b;

            size[root_b] += size[root_a];

            count--;
        }
    }

    /**
     * 查询a与b是否相连
     * @param a
     * @param b
     * @return
     */
    public boolean query(int a,int b){
        int root_a = find(a);
        int root_b = find(b);

        return root_a == root_b;
    }

    /**
     * 查询集合个数
     * @return
     */
    public int query(){
        return count;
    }

    /**
     * 返回和a相连的个数
     * @param a
     * @return
     */
    public int query(int a){

        int root_a = find(a);

        return size[root_a];
    }

}
