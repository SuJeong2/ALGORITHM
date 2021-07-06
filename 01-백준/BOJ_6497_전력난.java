package com.ssafy.Jul.day0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_6497_전력난 {

   static int m,n,x,y,z, total, result, min, minVertex;
   static ArrayList<House>[] graph;
   static int minEdge[];
   static boolean visited[];
   
   static class House{
      int to, weight;

      public House(int to, int weight) {
         super();
         this.to = to;
         this.weight = weight;
      }
   }
   
   public static void main(String[] args) throws IOException {

      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      while(true) {
         st = new StringTokenizer(br.readLine());
         m = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());
         
         if(n==0 && m==0) break;
         
         graph = new ArrayList[m];
         minEdge = new int[m];
         visited = new boolean[m];

         for(int i=0; i<m; i++) {
            graph[i] = new ArrayList<>();
            minEdge[i] = Integer.MAX_VALUE;
         }
         
         min = Integer.MAX_VALUE;
         minVertex = 0;
         total = 0;
         result = 0;
         
         for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            
            if(min>z) {
               min=z;
               minVertex = x;
            }
            total+=z;
            
            graph[x].add(new House(y,z));
            graph[y].add(new House(x,z));
         }
         
         minEdge[minVertex] = 0;
         
         for(int i=0; i<m; i++) {
            min = Integer.MAX_VALUE;
            minVertex = 0;
            
            for(int j=0; j<m; j++) {
               if(!visited[j] && min>minEdge[j]) {
                  min = minEdge[j];
                  minVertex = j;
               }
            }
            
            result+=minEdge[minVertex];
            visited[minVertex] = true;
            
            for(int j=0; j<graph[minVertex].size(); j++) {
               House cur = graph[minVertex].get(j);
               if(!visited[cur.to] && minEdge[cur.to]>cur.weight) {
                  minEdge[cur.to] = cur.weight;
               }
            }
            
         }
         
         System.out.println(total-result);
      }
      
   }

}