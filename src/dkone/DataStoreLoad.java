package dkone;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class DataStoreLoad {

    public HashMap[] loadStringToArray(String input) {

        String[] keyValueArray = input.split("\n");
        HashMap[] A = new HashMap[keyValueArray.length];

        int i = 0;
        for (String str: keyValueArray) {
            HashMap map = new HashMap<String,String>();
            for (String subStr: str.split(";")) {
                String[] keyValuePair = subStr.split("=");
                String key = keyValuePair[0];
                String value = keyValuePair[1];
                map.put(key, value);
            }
            A[i] = map;
            i += 1;
        }

        return A;
    }

    public String storeArrayMapToString(HashMap[] A) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < A.length; i++) {
            HashMap map = A[i];
            Iterator<Entry<String,String>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Entry<String,String> entry =  iterator.next();
                String key = entry.getKey();
                String value = entry.getValue();
                builder.append(key).append("=").append(value).append(";");
            }
            builder.deleteCharAt(builder.lastIndexOf(";"));
            if(i != A.length-1){
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        // Change input string here
        String input = "key1=value1;key2=value2\nkeyA=valueA";

        DataStoreLoad dataStoreLoad = new DataStoreLoad();
        HashMap[] map = dataStoreLoad.loadStringToArray(input);
        String strKeyValue = dataStoreLoad.storeArrayMapToString(map);

        System.out.println(strKeyValue);
    }
}
