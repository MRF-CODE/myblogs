package com.awspaas.user.apps.contract.manage.web;

import com.actionsoft.bpms.bo.engine.BO;
import com.actionsoft.sdk.local.SDK;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

public class CompareJson {

    private static final String SysRoot = "sys_root";
    private static final String SysType = "sys_type";
    private static final String SysObj = "sys_obj";
    private static final String SysNew = "sys_new";
    private static final String SysOld = "sys_old";
    private static final String TypeNew = "new";
    private static final String TypeDelete = "delete";
    private static final String TypeDifference = "difference";

    private String itemKey;
    private List<String> ignoreKeys = new ArrayList<>();

    public CompareJson(String itemKey) {
        this.itemKey = itemKey;
    }

    public CompareJson(String itemKey, String ignoreKeys) {
        this.itemKey = itemKey;
        this.ignoreKeys = Arrays.asList(ignoreKeys.split("\\,"));
    }

    public static void main(String[] args) {


        final String json1 = "{\"CTRESOURCE\":\"\",\"CONTRACTINGDEPTID\":\"\",\"ISLAST\":\"0\",\"CTPAYTYPE\":\"\",\"GUARANTEEDATE\":\"\",\"REMARKS\":\"\",\"ANNEX\":\"\",\"PAYARTICLE\":\"\",\"STATUS\":\"\",\"WEIGHTARTICLE\":\"\",\"ID\":\"878fefa9-5ae9-460f-8b58-450261556306\",\"APPLYDATE\":\"\",\"DELIVERARTICLE\":\"\",\"ORGID\":\"1\",\"BUSINESSLINE\":\"\",\"CONTRACTINGDEPT\":\"\",\"CREATEDATE\":\"2020-10-15 19:00:37.997\",\"UPDATEFOR\":\"\",\"UPDATEUSERID\":\"\",\"RMBSUM\":\"0.00\",\"UPDATEUSERNAME\":\"\",\"CRSIGNER\":\"\",\"CTTYPE\":\"\",\"GUARANTEE\":\"0.00\",\"APPLYNAME\":\"\",\"ORIGINALSUM\":\"0.00\",\"UPDATEDATE\":\"2020-10-15 19:00:37.997\",\"UPDATEUSER\":\"06499\",\"RATE\":\"0.000000\",\"UPDATEDATEA\":\"\",\"SIGNMAIN\":\"\",\"CRCTID\":\"\",\"LASTCRID\":\"\",\"BINDID\":\"c4057e74-bc79-4eb1-bd8e-a792a399ce15\",\"CREATEUSER\":\"06499\",\"SALESMAN\":\"\",\"ISRECV\":\"0\",\"CTMB\":\"0\",\"OURMAIN\":\"\",\"SKILLARTICLE\":\"\",\"UPDATECONTENT\":\"\",\"CTNAME\":\"代码生成合同2\",\"INDUSTRY\":\"\",\"THIRDBUY\":\"0\",\"APPLYID\":\"\",\"CTNO\":\"GENERATECT2\",\"PTLID\":\"\",\"LASTCR\":\"\",\"ISINSTALL\":\"0\",\"ISEND\":\"0\",\"ISSALES\":\"0\",\"BIDID\":\"\",\"SALESMANID\":\"\",\"OURMAINID\":\"\",\"CTGROUPTYPE\":\"\",\"PROCESSDEFID\":\"obj_1ac0b4d37d7f49dcae2ae831fc4d8c20\"}";
        final String json2 = "{\"CTRESOURCE\":\"\",\"CONTRACTINGDEPTID\":\"\",\"ISLAST\":\"1\",\"CTPAYTYPE\":\"\",\"GUARANTEEDATE\":\"\",\"REMARKS\":\"\",\"ANNEX\":\"\",\"PAYARTICLE\":\"\",\"STATUS\":\"\",\"WEIGHTARTICLE\":\"\",\"ID\":\"2ba49e1a-9870-4749-ac6d-0309ba3c7d8c\",\"APPLYDATE\":\"\",\"DELIVERARTICLE\":\"\",\"ORGID\":\"1\",\"BUSINESSLINE\":\"\",\"CONTRACTINGDEPT\":\"\",\"CREATEDATE\":\"2020-10-15 17:08:34.367\",\"UPDATEFOR\":\"\",\"UPDATEUSERID\":\"\",\"RMBSUM\":\"0.00\",\"UPDATEUSERNAME\":\"\",\"CRSIGNER\":\"\",\"CTTYPE\":\"\",\"GUARANTEE\":\"0.00\",\"APPLYNAME\":\"\",\"ORIGINALSUM\":\"0.00\",\"UPDATEDATE\":\"2020-10-15 17:08:34.367\",\"UPDATEUSER\":\"06499\",\"RATE\":\"0.000000\",\"UPDATEDATEA\":\"\",\"SIGNMAIN\":\"\",\"CRCTID\":\"\",\"LASTCRID\":\"\",\"BINDID\":\"cff5b624-a5ee-45bc-b1aa-b79ab619818c\",\"CREATEUSER\":\"06499\",\"SALESMAN\":\"\",\"ISRECV\":\"0\",\"CTMB\":\"0\",\"OURMAIN\":\"\",\"SKILLARTICLE\":\"\",\"UPDATECONTENT\":\"\",\"CTNAME\":\"代码生成合同2\",\"INDUSTRY\":\"\",\"THIRDBUY\":\"0\",\"APPLYID\":\"\",\"CTNO\":\"GENERATECT2\",\"PTLID\":\"\",\"LASTCR\":\"\",\"ISINSTALL\":\"0\",\"ISEND\":\"0\",\"ISSALES\":\"0\",\"BIDID\":\"\",\"SALESMANID\":\"\",\"OURMAINID\":\"\",\"CTGROUPTYPE\":\"\",\"PROCESSDEFID\":\"obj_1ac0b4d37d7f49dcae2ae831fc4d8c20\"}";

        String resultStr = new CompareJson("copyId").compareJson(json1, json2);
        System.out.println(resultStr);
    }

    private void compareJson(JSONObject jsonObject1, JSONObject jsonObject2, Map<String, Object> objectMap) {
        Iterator<String> iterator = jsonObject1.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (ignoreKeys.contains(key)) {
                continue;
            }

            Object value1 = jsonObject1.get(key);
            Object value2 = jsonObject2.get(key);
            compareJson(key, value1, value2, objectMap);
        }
    }

    private void compareJson(JSONArray jsonArray1, JSONArray jsonArray2, List<Map<String, Object>> arrayMap) {

        JSONArray jsonArray = (JSONArray) jsonArray1.clone();
        if (jsonArray2 != null) {
            jsonArray.addAll(jsonArray2);
        }

        for (int i = 0; i < jsonArray.size(); i++) {

            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Object keyValue = jsonObject.get(this.itemKey);
            if (keyValue == null) {
                continue;
            }

            JSONObject jsonObject1 = null;
            for (int j = 0; j < jsonArray1.size(); j++) {
                JSONObject jsonObj = (JSONObject) jsonArray1.get(j);
                if (keyValue.equals(jsonObj.get(this.itemKey))) {
                    jsonObject1 = jsonObj;
                    break;
                }
            }

            JSONObject jsonObject2 = null;
            for (int j = 0; j < jsonArray2.size(); j++) {
                JSONObject jsonObj = (JSONObject) jsonArray2.get(j);
                if (keyValue.equals(jsonObj.get(this.itemKey))) {
                    jsonObject2 = jsonObj;
                    break;
                }
            }

            Map<String, Object> objectMap = new HashMap<>();
            if (jsonObject1 != null && jsonObject2 == null) {
                objectMap.put(this.itemKey, keyValue);
                objectMap.put(SysType, TypeNew);
                objectMap.put(SysObj, jsonObject1);
            } else if (jsonObject1 == null && jsonObject2 != null) {
                objectMap.put(this.itemKey, keyValue);
                objectMap.put(SysType, TypeDelete);
                objectMap.put(SysObj, jsonObject2);
            } else {
                Map<String, Object> differenceMap = new HashMap<>();
                compareJson(jsonObject1, jsonObject2, differenceMap);
                if (differenceMap.size() > 0) {
                    objectMap.put(this.itemKey, keyValue);
                    objectMap.put(SysType, TypeDifference);
                    objectMap.put(SysObj, differenceMap);
                }
            }

            if (objectMap.size() > 0) {

                Map<String, Object> findMap = null;
                for (Map<String, Object> map : arrayMap) {
                    if (keyValue.equals(map.get(this.itemKey))) {
                        findMap = map;
                        break;
                    }
                }

                if (findMap == null) {
                    arrayMap.add(objectMap);
                }
            }
        }
    }

    private void compareJson(String key, Object json1, Object json2, Map<String, Object> resultMap) {
        if (json1 instanceof JSONObject) {

            Map<String, Object> objectMap = new HashMap<>();
            compareJson((JSONObject) json1, (JSONObject) json2, objectMap);
            if (objectMap.size() > 0) {
                resultMap.put(key, objectMap);
            }

        } else if (json1 instanceof JSONArray) {

            JSONArray jsonArray = (JSONArray) json1;
            if (jsonArray != null && jsonArray.size() > 0) {
                if (!(jsonArray.get(0) instanceof JSONObject)) { //["1","2"],[1,2]...
                    Map<String, Object> compareMap = new HashMap<>();
                    compareMap.put(SysNew, json1);
                    compareMap.put(SysOld, json2);
                    resultMap.put(key, compareMap);
                    return;
                }
            }

            List<Map<String, Object>> arrayMap = new ArrayList<>();
            compareJson((JSONArray) json1, (JSONArray) json2, arrayMap);
            if (arrayMap.size() > 0) {
                resultMap.put(key, arrayMap);
            }

        } else if ((json1 == null && json2 != null) || (json1 != null && !json1.equals(json2))) {
            Map<String, Object> compareMap = new HashMap<>();
            compareMap.put(SysNew, json1);
            compareMap.put(SysOld, json2);
            resultMap.put(key, compareMap);
        }
    }

    public String compareJson(String json1, String json2) {
        Object jsonObj1 = JSONObject.parse(json1);
        Object jsonObj2 = JSONObject.parse(json2);
        Map<String, Object> resultMap = new HashMap<>();
        compareJson(SysRoot, jsonObj1, jsonObj2, resultMap);
        String resultStr = JSON.toJSONString(resultMap.get(SysRoot), new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        return resultStr;
    }

    public static JSONObject changeJsonObj(JSONObject jsonObj,Map<String, String> keyMap) {
        JSONObject resJson = new JSONObject();
        Set<String> keySet = jsonObj.keySet();
        for (String key : keySet) {
            String resKey = keyMap.get(key) == null ? key : keyMap.get(key);
            try {
                JSONObject jsonobj1 = jsonObj.getJSONObject(key);
                resJson.put(resKey, changeJsonObj(jsonobj1, keyMap));
            } catch (Exception e) {
                try {
                    JSONArray jsonArr = jsonObj.getJSONArray(key);
                    resJson.put(resKey, changeJsonArr(jsonArr, keyMap));
                } catch (Exception x) {
                    resJson.put(resKey, jsonObj.get(key));
                }
            }
        }
        return resJson;
    }

    public static JSONArray changeJsonArr(JSONArray jsonArr,Map<String, String> keyMap) {
        JSONArray resJson = new JSONArray();
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            resJson.add(changeJsonObj(jsonObj, keyMap));
        }
        return resJson;
    }

}