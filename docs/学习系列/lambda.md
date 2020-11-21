老样子先说需求

使用JAVA 将集合里面的元素按照两个字段分组，然后按照这一组数从小到大输出

首先创建对象类，BO,这是我们的基本操作

```
class BO {
    public BO() {

    }
    // 集合元素
    HashMap<String, Object> map = new HashMap<>();
    public Object get(String param) {
    return map.get(param);
    }
    public void set(String key, Object value) {
    map.put(key, value);
    }
}
```

然后进行核心代码的书写

```
List<BO> detailList = new ArrayList<>();
        BO b1 = new BO();
        b1.set("TRANSPORT_TYPE","海运");
        b1.set("CIRCUIT_NAME","北京");
        b1.set("START_VAL",1);

        BO b2 = new BO();
        b2.set("TRANSPORT_TYPE","海运");
        b2.set("CIRCUIT_NAME","北京");
        b2.set("START_VAL",2);

        BO b3 = new BO();
        b3.set("TRANSPORT_TYPE","空运");
        b3.set("CIRCUIT_NAME","北京");
        b3.set("START_VAL",3);

        detailList.add(b1);
        detailList.add(b2);
        detailList.add(b3);

        Map<String, List<BO>> groupMap = detailList.stream().collect(Collectors.groupingBy(e -> e.get("TRANSPORT_TYPE") + "_" + e.get("CIRCUIT_NAME")));
        for (String key : groupMap.keySet()) {
            List<BO> boList = groupMap.get(key);
            //3:按照START_VAL 进行排序
            List<BO> sortBoList = boList.stream().sorted((x, y) -> {
                        Integer a =  Integer.parseInt(x.get("START_VAL").toString());
                        Integer b =  Integer.parseInt(y.get("START_VAL").toString());
                        return a.compareTo(b);
                    }
            ).collect(Collectors.toList());
            for (BO b:sortBoList) {
                System.out.print("-----"+b.get("START_VAL")+"---");
            }
            System.out.println();
        }
```

后记：学习是人类进步的阶梯，我一直在奔跑的路上，诸君共勉。