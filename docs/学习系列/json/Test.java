package com.awspaas.test;
import com.alibaba.fastjson.JSONObject;
import com.awspaas.user.apps.contract.manage.web.CompareJson;
import net.sf.json.JSONArray;

import java.util.*;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class Test {

    public void tt(){
        // json1
        String str1 = "{\"CTRESOURCE\":\"1\",\"UPDATEUSER\":\"06499\",\"CONTRACTINGDEPTID\":\"1010101\",\"RATE\":\"6.285500\",\"CTPAYTYPE\":\"美元\",\"SIGNMAIN\":\"1013新建客户\",\"GUARANTEEDATE\":\"\",\"REMARKS\":\"\",\"ANNEX\":\"\",\"CRCTID\":\"\",\"PAYARTICLE\":\"\",\"LASTCRID\":\"CL202010131157\",\"STATUS\":\"已审批\",\"SALESMAN\":\"李银\",\"ISRECV\":\"1\",\"CTMB\":\"0\",\"WEIGHTARTICLE\":\"\",\"OURMAIN\":\"北京动力源科技股份有限公司\",\"SKILLARTICLE\":\"\",\"DELIVERARTICLE\":\"\",\"BUSINESSLINE\":\"01\",\"CTNAME\":\"1013测试合同\",\"INDUSTRY\":\"18\",\"CONTRACTINGDEPT\":\"董事会秘书室\",\"THIRDBUY\":\"1\",\"RMBSUM\":\"1744226.25\",\"PTLID\":\"\",\"LASTCR\":\"1013新建客户\",\"CRSIGNER\":\"1013测试合同\",\"ISINSTALL\":\"1\",\"CTTYPE\":\"4\",\"GUARANTEE\":\"0.00\",\"ORIGINALSUM\":\"277500.00\",\"ISSALES\":\"2\",\"BIDID\":\"\",\"SALESMANID\":\"06499\",\"OURMAINID\":\"101\",\"CTGROUPTYPE\":\"0\"}\n";
        // json2
        String str2 = "{\"CTRESOURCE\":\"1\",\"CONTRACTINGDEPTID\":\"1010101\",\"ISLAST\":\"0\",\"CTPAYTYPE\":\"美元\",\"GUARANTEEDATE\":\"\",\"REMARKS\":\"\",\"ANNEX\":\"\",\"PAYARTICLE\":\"\",\"STATUS\":\"已审批\",\"WEIGHTARTICLE\":\"\",\"ID\":\"a0fdbccf-e61e-4410-9ae7-ccd5046106cc\",\"APPLYDATE\":\"2020-10-13 14:36:16\",\"DELIVERARTICLE\":\"\",\"ORGID\":\"1\",\"BUSINESSLINE\":\"01\",\"CONTRACTINGDEPT\":\"董事会秘书室\",\"CREATEDATE\":\"2020-10-13 14:39:05.793\",\"UPDATEFOR\":\"\",\"UPDATEUSERID\":\"\",\"RMBSUM\":\"1744226.25\",\"UPDATEUSERNAME\":\"\",\"CRSIGNER\":\"1013测试合同\",\"CTTYPE\":\"4\",\"GUARANTEE\":\"0.00\",\"APPLYNAME\":\"李银\",\"ORIGINALSUM\":\"277500.00\",\"UPDATEDATE\":\"2020-10-19 14:16:15.457\",\"UPDATEUSER\":\"06499\",\"RATE\":\"6.285500\",\"UPDATEDATEA\":\"\",\"SIGNMAIN\":\"1013新建客户\",\"CRCTID\":\"\",\"LASTCRID\":\"CL202010131157\",\"BINDID\":\"20facdbb-322f-4219-95ef-0aa5af7be64b\",\"CREATEUSER\":\"06499\",\"SALESMAN\":\"李银\",\"ISRECV\":\"0\",\"CTMB\":\"0\",\"OURMAIN\":\"北京动力源科技股份有限公司\",\"SKILLARTICLE\":\"\",\"UPDATECONTENT\":\"\",\"CTNAME\":\"1013测试合同\",\"INDUSTRY\":\"18\",\"THIRDBUY\":\"0\",\"APPLYID\":\"06499\",\"CTNO\":\"HT202010130247\",\"PTLID\":\"\",\"LASTCR\":\"1013新建客户\",\"ISINSTALL\":\"0\",\"ISEND\":\"0\",\"ISSALES\":\"1\",\"BIDID\":\"\",\"SALESMANID\":\"06499\",\"OURMAINID\":\"101\",\"CTGROUPTYPE\":\"0\",\"PROCESSDEFID\":\"obj_1ac0b4d37d7f49dcae2ae831fc4d8c20\"}\n";
        // 两个json 比较不同
        String resultStr = new CompareJson("CTNO").compareJson(str1, str2);
        /* 引入阿里的包，将字符串转换成json*/
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        // 获取最外层所有的key，将key值转换成中文的值
        Map<String, String> keyMap = new HashMap<String, String>();
        // 获取JSON第一层所有的key
        Set<String> keys = jsonObject.keySet();
        // 获取第一层每个hekey对应的值 的类型
        for (String key : keys) {
            if(key.equals("THIRDBUY")){
                keyMap.put(key,"第三方采购");
            }
        }
        JSONObject jsonObj = CompareJson.changeJsonObj(JSONObject.parseObject(resultStr),keyMap);
        // 获取JSON第一层所有的key
        Set<String> keys2 = jsonObj.keySet();
        ArrayList arrayList = new ArrayList();
        // 获取第一层每个key对应的值 的类型
        for (String key : keys2) {
            JSONObject jsonObject2 = jsonObj.getJSONObject(key);
            jsonObject2.put("item",key);
            arrayList.add(jsonObject2);
        }
        JSONArray jsonarr = JSONArray.fromObject(arrayList);
    }

    public void test(){
        List<BO> oldList = new ArrayList<>();
        BO bo1 = new BO("1","A");
        BO bo2 = new BO("2","B");
        BO bo3 = new BO("3","C");
        BO bo4 = new BO("4","D");
        oldList.add(bo1);
        oldList.add(bo2);
        oldList.add(bo3);
        oldList.add(bo4);

        List<BO> newList = new ArrayList<>();
        BO b1 = new BO("1","X");
        BO b2 = new BO("2","Y");
        BO b3 = new BO("3","Z");
        BO b4 = new BO("5","Q");
        newList.add(b1);
        newList.add(b2);
        newList.add(b3);
        newList.add(b4);

        List<JSONObject> sonList = new ArrayList();
        JSONObject jsonobject = new JSONObject();

        Map<String,BO> map = new HashMap<String,BO>();
        for(BO b : oldList){
            map.put(b.getROWNO(),b);
        }
        List<BO> intersection = new ArrayList<BO> ();
        String ROWNO;
        for(BO b: newList) {
            ROWNO = b.getROWNO();
            if (map.containsKey(ROWNO)){
                intersection.add(map.get(ROWNO));
            }
        }
        // 这个时候能确定的是intersection 中的数据可以删掉，剩下的就是比old 多 的
        List<BO> copyNewList = new ArrayList<>();
        copyNewList.addAll(newList);

        List<BO> copyOldList = new ArrayList<>();
        copyOldList.addAll(oldList);

        // 删除元素
        List<BO> removeList = new ArrayList<>();
        copyNewList.stream().forEach(vo ->{
            for (int j = 0; j < intersection.size(); j++) {
                if(vo.getROWNO().equals(intersection.get(j).getROWNO())){
                    removeList.add(vo);
                }
            }
        });
        copyNewList.removeAll(removeList);

        for(BO bo:copyNewList){
            jsonobject = new JSONObject();
            String newName = bo.getNAME();
            jsonobject.put("rowNo",bo.getROWNO());
            jsonobject.put("oldName","");
            jsonobject.put("newName",newName);
            sonList.add(jsonobject);
        }

        // 删除元素
        List<BO> tempList = new ArrayList<>();
        copyOldList.stream().forEach(vo ->{
            for (int j = 0; j < intersection.size(); j++) {
                if(vo.getROWNO().equals(intersection.get(j).getROWNO())){
                    tempList.add(vo);
                }
            }
        });
        copyOldList.removeAll(tempList);

        System.out.println(copyOldList.size());
        for(BO bo:copyOldList){
            jsonobject = new JSONObject();
            String oldName = bo.getNAME();
            jsonobject.put("rowNo",bo.getROWNO());
            jsonobject.put("oldName",oldName);
            jsonobject.put("newName","");
            sonList.add(jsonobject);
        }

        // 两边相同行号的对比
        for (String key : map.keySet()) {
            for (int i = 0; i < newList.size(); i++) {
                if(key.equals(newList.get(i).getROWNO())){
                    jsonobject = new JSONObject();
                    String oldName = map.get(key).getNAME();
                    String newName = newList.get(i).getNAME();
                    jsonobject.put("rowNo",key);
                    jsonobject.put("oldName",oldName);
                    jsonobject.put("newName",newName);
                    sonList.add(jsonobject);
                }
            }
        }
        // 按照rowNo 排序
        Comparator<JSONObject> comparing = comparing((JSONObject a) -> a.getString("rowNo"));
        sonList.sort(comparing((JSONObject a) -> a.getString("rowNo")));
        System.out.println(sonList);
    }

    Integer a;
    int b;
    public void lambda(){

    }
    public void testP(String s){
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("qq");
            }
        };
        System.out.println(predicate.test(s));
    }
    public boolean judgeByFunction(int value,Predicate<Integer> predicate){
        return predicate.test(value);
    }
    public boolean testAndMethod(String stringOne, Predicate<String> predicateOne,Predicate<String> predicateTwo) {
        return predicateOne.and(predicateTwo).test(stringOne);
    }
    public static void main(String[] args) {
        Test test = new Test();
        while(true){}
    }
}
/** 需求：两个Json对比 目前有两个json 类型的数据，{"1":"A","2":"B","3":"C","4":"D"} 和 {"1":"X","2":"Y","3":"Z","5":"Q"}
 *  对比出来的结构需要有{"1":{"old":"A","new":"X"},"2":{"old":"B","new":"Y"},"3":{"old":"C","new":"Z"},"4":{"old":"D","new":""},"5":{"old":"","new":"Q"}}
 * **/
class BO{
    /** 行号 **/
    private String ROWNO;
    /** 名称 **/
    private String NAME;

    public BO(){

    }
    public BO(String ROWNO, String NAME) {
        this.ROWNO = ROWNO;
        this.NAME = NAME;
    }

    public String getROWNO() {
        return ROWNO;
    }

    public void setROWNO(String ROWNO) {
        this.ROWNO = ROWNO;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

}

interface MathOperation{
    int operation(int a,int b);
}