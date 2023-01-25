package com.demo.collection;

import java.util.*;
public class SortedKeysTreeMap
{
  public static void main(String[] args)
  {
        Map<Integer, Object> sampleMap = new HashMap<Integer, Object>();
//        Map<Integer, Object> sampleMap = new HashMap<Integer, Object>();
        sampleMap.put(1,null); 
        sampleMap.put(50, null); 
        sampleMap.put(3, null); 
        sampleMap.put(2, null); 
        sampleMap.put(4, null); 
        sampleMap.put(null,"FiftyFive");
      sampleMap.put(null,"FiftySix");
       System.out.println(sampleMap);
   }
}