package io;

import junit.framework.TestCase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DeepCopyTest extends TestCase implements Serializable {

    public void testCopy() throws Exception {
        BigFatObject bigFatObject = new BigFatObject();
        bigFatObject.fieldStr = "БИГ ФЭТ TEST";
        bigFatObject.fieldArray = new String[]{"aaa","bbb"};
        bigFatObject.fieldMap = new HashMap<String, String>();
        bigFatObject.fieldMap.put("1","AAA");
        bigFatObject.fieldMap.put("2","BBB");
        bigFatObject.fieldBigFat = bigFatObject;
        BigFatObject clone = (BigFatObject) DeepCopy.copy(bigFatObject);
        assertEquals(clone.fieldStr, "БИГ ФЭТ TEST");
        assertEquals(clone.fieldArray[1], "bbb");
        assertEquals(clone.fieldMap.get("2"), "BBB");
        assertEquals(clone.fieldBigFat.fieldArray[1], "bbb");
    }

    class BigFatObject implements Serializable {
        String fieldStr;
        String[] fieldArray;
        Map fieldMap;
        BigFatObject fieldBigFat;
    }

}
