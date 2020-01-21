```
基于一个82k的json文件

解析字节：com.jsoniter > com.fasterxml.jackson > com.alibaba.fastjson > com.google.gson > org.json
解析文件：com.jsoniter > com.fasterxml.jackson > com.alibaba.fastjson > com.google.gson > org.json
解析字符：com.fasterxml.jackson > com.jsoniter > com.alibaba.fastjson > com.google.gson > org.json

org.json              (bytes) 并发：5，累计：1000000次，实验5次，平均耗时：238797.4毫秒
com.fasterxml.jackson (bytes) 并发：5，累计：1000000次，实验5次，平均耗时： 64357.4毫秒
com.google.gson       (bytes) 并发：5，累计：1000000次，实验5次，平均耗时：142374.4毫秒
com.alibaba.fastjson  (bytes) 并发：5，累计：1000000次，实验5次，平均耗时： 98374.4毫秒
com.jsoniter          (bytes) 并发：5，累计：1000000次，实验5次，平均耗时： 50930.6毫秒

org.json              (file) 并发：5，累计：1000000次，实验5次，平均耗时：226818.0毫秒
com.fasterxml.jackson (file) 并发：5，累计：1000000次，实验5次，平均耗时： 67601.0毫秒
com.google.gson       (file) 并发：5，累计：1000000次，实验5次，平均耗时：148585.6毫秒
com.alibaba.fastjson  (file) 并发：5，累计：1000000次，实验5次，平均耗时：104180.2毫秒
com.jsoniter          (file) 并发：5，累计：1000000次，实验5次，平均耗时： 57571.8毫秒

org.json              (text) 并发：5，累计：1000000次，实验5次，平均耗时：196769.4毫秒
com.fasterxml.jackson (text) 并发：5，累计：1000000次，实验5次，平均耗时： 71433.8毫秒
com.google.gson       (text) 并发：5，累计：1000000次，实验5次，平均耗时：120887.4毫秒
com.alibaba.fastjson  (text) 并发：5，累计：1000000次，实验5次，平均耗时： 75838.4毫秒
com.jsoniter          (text) 并发：5，累计：1000000次，实验5次，平均耗时： 74132.6毫秒

org.json              : text  (196769.4) > file  (226818.0) > bytes (238797.4)
com.fasterxml.jackson : bytes ( 64357.4) > file  ( 67601.0) > text  ( 71433.8)
com.google.gson       : text  (120887.4) > bytes (142374.4) > file  (148585.6)
com.alibaba.fastjson  : text  ( 75838.4) > bytes ( 98374.4) > file  (104180.2)
com.jsoniter          : bytes ( 50930.6) > file  ( 57571.8) > text  ( 74132.6)

实验详情：
org.json (bytes) 并发：5，累计：1000000次，耗时：272416毫秒
org.json (bytes) 并发：5，累计：1000000次，耗时：245396毫秒
org.json (bytes) 并发：5，累计：1000000次，耗时：215959毫秒
org.json (bytes) 并发：5，累计：1000000次，耗时：216201毫秒
org.json (bytes) 并发：5，累计：1000000次，耗时：244015毫秒
com.fasterxml.jackson (bytes) 并发：5，累计：1000000次，耗时：65442毫秒
com.fasterxml.jackson (bytes) 并发：5，累计：1000000次，耗时：63830毫秒
com.fasterxml.jackson (bytes) 并发：5，累计：1000000次，耗时：64346毫秒
com.fasterxml.jackson (bytes) 并发：5，累计：1000000次，耗时：63369毫秒
com.fasterxml.jackson (bytes) 并发：5，累计：1000000次，耗时：64800毫秒
com.google.gson (bytes) 并发：5，累计：1000000次，耗时：148046毫秒
com.google.gson (bytes) 并发：5，累计：1000000次，耗时：138006毫秒
com.google.gson (bytes) 并发：5，累计：1000000次，耗时：147551毫秒
com.google.gson (bytes) 并发：5，累计：1000000次，耗时：139037毫秒
com.google.gson (bytes) 并发：5，累计：1000000次，耗时：139232毫秒
com.alibaba.fastjson (bytes) 并发：5，累计：1000000次，耗时：98718毫秒
com.alibaba.fastjson (bytes) 并发：5，累计：1000000次，耗时：97575毫秒
com.alibaba.fastjson (bytes) 并发：5，累计：1000000次，耗时：95737毫秒
com.alibaba.fastjson (bytes) 并发：5，累计：1000000次，耗时：98616毫秒
com.alibaba.fastjson (bytes) 并发：5，累计：1000000次，耗时：100326毫秒
com.jsoniter (bytes) 并发：5，累计：1000000次，耗时：49990毫秒
com.jsoniter (bytes) 并发：5，累计：1000000次，耗时：49326毫秒
com.jsoniter (bytes) 并发：5，累计：1000000次，耗时：52713毫秒
com.jsoniter (bytes) 并发：5，累计：1000000次，耗时：50113毫秒
com.jsoniter (bytes) 并发：5，累计：1000000次，耗时：52511毫秒

org.json (file) 并发：5，累计：1000000次，耗时：220431毫秒
org.json (file) 并发：5，累计：1000000次，耗时：221901毫秒
org.json (file) 并发：5，累计：1000000次，耗时：247008毫秒
org.json (file) 并发：5，累计：1000000次，耗时：220236毫秒
org.json (file) 并发：5，累计：1000000次，耗时：224514毫秒
com.fasterxml.jackson (file) 并发：5，累计：1000000次，耗时：67783毫秒
com.fasterxml.jackson (file) 并发：5，累计：1000000次，耗时：66847毫秒
com.fasterxml.jackson (file) 并发：5，累计：1000000次，耗时：70410毫秒
com.fasterxml.jackson (file) 并发：5，累计：1000000次，耗时：67441毫秒
com.fasterxml.jackson (file) 并发：5，累计：1000000次，耗时：65524毫秒
com.google.gson (file) 并发：5，累计：1000000次，耗时：148301毫秒
com.google.gson (file) 并发：5，累计：1000000次，耗时：152714毫秒
com.google.gson (file) 并发：5，累计：1000000次，耗时：146553毫秒
com.google.gson (file) 并发：5，累计：1000000次，耗时：143635毫秒
com.google.gson (file) 并发：5，累计：1000000次，耗时：151725毫秒
com.alibaba.fastjson (file) 并发：5，累计：1000000次，耗时：102912毫秒
com.alibaba.fastjson (file) 并发：5，累计：1000000次，耗时：107206毫秒
com.alibaba.fastjson (file) 并发：5，累计：1000000次，耗时：102354毫秒
com.alibaba.fastjson (file) 并发：5，累计：1000000次，耗时：102754毫秒
com.alibaba.fastjson (file) 并发：5，累计：1000000次，耗时：105675毫秒
com.jsoniter (file) 并发：5，累计：1000000次，耗时：56254毫秒
com.jsoniter (file) 并发：5，累计：1000000次，耗时：56246毫秒
com.jsoniter (file) 并发：5，累计：1000000次，耗时：59093毫秒
com.jsoniter (file) 并发：5，累计：1000000次，耗时：60035毫秒
com.jsoniter (file) 并发：5，累计：1000000次，耗时：56231毫秒

org.json (text) 并发：5，累计：1000000次，耗时：195897毫秒
org.json (text) 并发：5，累计：1000000次，耗时：209873毫秒
org.json (text) 并发：5，累计：1000000次，耗时：192065毫秒
org.json (text) 并发：5，累计：1000000次，耗时：191493毫秒
org.json (text) 并发：5，累计：1000000次，耗时：194519毫秒
com.fasterxml.jackson (text) 并发：5，累计：1000000次，耗时：72416毫秒
com.fasterxml.jackson (text) 并发：5，累计：1000000次，耗时：70410毫秒
com.fasterxml.jackson (text) 并发：5，累计：1000000次，耗时：72544毫秒
com.fasterxml.jackson (text) 并发：5，累计：1000000次，耗时：70199毫秒
com.fasterxml.jackson (text) 并发：5，累计：1000000次，耗时：71600毫秒
com.google.gson (text) 并发：5，累计：1000000次，耗时：121743毫秒
com.google.gson (text) 并发：5，累计：1000000次，耗时：119802毫秒
com.google.gson (text) 并发：5，累计：1000000次，耗时：120629毫秒
com.google.gson (text) 并发：5，累计：1000000次，耗时：120878毫秒
com.google.gson (text) 并发：5，累计：1000000次，耗时：121385毫秒
com.alibaba.fastjson (text) 并发：5，累计：1000000次，耗时：74363毫秒
com.alibaba.fastjson (text) 并发：5，累计：1000000次，耗时：75690毫秒
com.alibaba.fastjson (text) 并发：5，累计：1000000次，耗时：77349毫秒
com.alibaba.fastjson (text) 并发：5，累计：1000000次，耗时：73700毫秒
com.alibaba.fastjson (text) 并发：5，累计：1000000次，耗时：78090毫秒
com.jsoniter (text) 并发：5，累计：1000000次，耗时：73433毫秒
com.jsoniter (text) 并发：5，累计：1000000次，耗时：73301毫秒
com.jsoniter (text) 并发：5，累计：1000000次，耗时：77006毫秒
com.jsoniter (text) 并发：5，累计：1000000次，耗时：73478毫秒
com.jsoniter (text) 并发：5，累计：1000000次，耗时：73445毫秒
```
