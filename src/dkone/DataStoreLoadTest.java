package dkone;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DataStoreLoadTest {

    @Test
    public void loadStringToArray() {
        DataStoreLoad test = new DataStoreLoad();
        String input = "key1=value1;key2=value2\nkeyA=valueA";
        HashMap[] arrayMap = new HashMap[2];
        arrayMap[0] = new HashMap();
        arrayMap[0].put("key1", "value1");
        arrayMap[0].put("key2", "value2");
        arrayMap[1] = new HashMap();
        arrayMap[1].put("keyA", "valueA");
        assertArrayEquals(arrayMap, test.loadStringToArray(input));


        input = "orange=5;papaya=100;apple=2;strawberry=1;melon=3\nchicken=10;meat=5;lobster=20";
        arrayMap = new HashMap[2];
        arrayMap[0] = new HashMap();
        arrayMap[0].put("strawberry", "1");
        arrayMap[0].put("apple", "2");
        arrayMap[0].put("orange", "5");
        arrayMap[0].put("papaya", "100");
        arrayMap[0].put("melon", "3");
        arrayMap[1] = new HashMap();
        arrayMap[1].put("chicken", "10");
        arrayMap[1].put("meat", "5");
        arrayMap[1].put("lobster", "20");
        assertArrayEquals(arrayMap, test.loadStringToArray(input));
    }


    @Test
    public void storeArrayMapToString() {
        DataStoreLoad test = new DataStoreLoad();
        String input = "key1=value1;key2=value2\nkeyA=valueA";
        HashMap[] arrayMap = test.loadStringToArray(input);
        assertEquals(input, test.storeArrayMapToString(arrayMap));

        input = "orange=5;papaya=100;apple=2;strawberry=1;melon=3\nchicken=10;meat=5;lobster=20";
        arrayMap = test.loadStringToArray(input);
        assertEquals(input, test.storeArrayMapToString(arrayMap));
    }

}