/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author vojtechkylar
 */
public class core {

    /**
     * test použití Collections framework v Java 
     * Iterator r/
     * Collection r/
     * List r/
     * Set r/
     * Collections c/
     * Map r/
     *
     * @return
     */
    public static String testCF() {
        String s = "";
        java.util.List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        
        s+="Collections "+Collections.addAll(list, 22, 33, 22, 33, 61, 33, 45, 22)+"\n";
        s+="Collections "+list.addAll(Arrays.asList(222, 333, 222, 333, 616, 333, 454, 222))+"\n";
        
        s+="list.add "+list.add(4444)+"\n";
        list.add(1, 55555);
        list.addAll(1, Arrays.asList(3333, 4444, 7777));
        s+="List "+list+" \nsize: "+list.size()+"\n";
        s+="list.set "+list.set(1, 31313)+"\n";
        s+="List "+list+" \nsize: "+list.size()+"\n";
        for (int i = 0; i < list.size(); i++) {
            Integer get = list.get(i);
            s+=""+get+", ";
            
        }
        s+="\n";
        
        s+="list.remove(s) "+list.remove(new Integer(616))+"\n";
        s+="list.removeAll: "+list.removeAll(Arrays.asList(22, 333))+"\n";
       
        s+="List "+list+" \nsize: "+list.size()+"\n";
        
        list.clear();
        s+="List "+list+" \nsize: "+list.size()+"\n";
        
        s+="\nMapy\n-----------------------------------------------------------\n";
        java.util.Map<String, Integer> mapa = new HashMap<>();
        s+= "mapa.put(\"a\" "+mapa.put("a", 64)+"\n";
        s+= "mapa.put(\"b\"  "+mapa.put("b", 60)+"\n";
        s+= "mapa.put(\"c\"  "+mapa.put("c", 65)+"\n";
        s+= "mapa.put(\"d\"  "+mapa.put("d", 66)+"\n";
        s+= "mapa.put(\"d\"  "+mapa.put("d", 67)+"\n";
        s+= "mapa.put(\"d\"  "+mapa.replace("d", 67,70)+"\n";
        s+=""+mapa.remove("c");
        s+="\n";
        
        for (java.util.Map.Entry<String, Integer> entry : mapa.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            s+=key+" : "+val+"\n";
            
        }
        s+="\n";
        
        java.util.Set<String> klc = mapa.keySet();
        for (String klic : klc) {
            s+=klic+"::"+mapa.get(klic)+"\n";
            
        }
        s+="\n";
        
        java.util.Set<Map.Entry<String,Integer>> entrs = mapa.entrySet();
        for (Object entr : entrs) {
            s+=entr+"\n";
        }
        s+= "Map "+mapa+" Size: "+mapa.size()+"\n";
        return s;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("" + testCF());
    }

}
