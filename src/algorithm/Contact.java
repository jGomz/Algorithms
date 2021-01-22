package algorithm;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Contact {
    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        ArrayList<Integer> array = new ArrayList<>();

        Hashtable<Character, ArrayList<String>> hashContact = new Hashtable<>();
        int count = 0;
        for(int i=0; i<queries.length ; i++){
            //System.out.println(queries[i][0] +" "+ queries[i][1]);
            char ch = queries[i][1].charAt(0);
            if(queries[i][0].equals("add")){
                if(hashContact.get(ch) != null){
                    hashContact.get(ch).add(queries[i][1]);
                }else{
                    ArrayList<String> contactList = new ArrayList<>();
                    contactList.add(queries[i][1]);
                    hashContact.put(ch,contactList);
                }
            }else if(queries[i][0].equals("find")){
                ArrayList<String> al = hashContact.get(ch);
                if(al != null){
                    for(int j=0 ; j<al.size() ; j++){
                        if(al.get(j).startsWith(queries[i][1])){
                            count++;
                        }
                    }
                    array.add(count);
                }else{
                    array.add(0);
                }
                count = 0;
            }
        }

        int[] res = new int[array.size()];
        for(int j=0; j<array.size(); j++){
           res[j] = array.get(j);
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*add hack
        add hackerrank
        find hac
        find hak
        */
        String[][] queries = new String[][]{{"add", "hack"}, {"add", "hackerrank"}, {"find", "hac"}, {"find", "hak"}};

        int[] result = contacts(queries);

        System.out.print(Arrays.toString(result));

    }
}
