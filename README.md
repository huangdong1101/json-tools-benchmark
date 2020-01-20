```
基于一个82k的json文件

com.google.gson 并发：5，累计：100000次，耗时：13282毫秒
com.google.gson 并发：5，累计：100000次，耗时：12126毫秒
com.google.gson 并发：5，累计：100000次，耗时：12248毫秒
com.google.gson 并发：5，累计：100000次，耗时：12113毫秒
com.google.gson 并发：5，累计：100000次，耗时：12172毫秒
avg: 12388.2毫秒

com.fasterxml.jackson 并发：5，累计：100000次，耗时：7356毫秒
com.fasterxml.jackson 并发：5，累计：100000次，耗时：7299毫秒
com.fasterxml.jackson 并发：5，累计：100000次，耗时：7441毫秒
com.fasterxml.jackson 并发：5，累计：100000次，耗时：7331毫秒
com.fasterxml.jackson 并发：5，累计：100000次，耗时：7413毫秒
avg: 7368毫秒

com.alibaba.fastjson 并发：5，累计：100000次，耗时：7959毫秒
com.alibaba.fastjson 并发：5，累计：100000次，耗时：7673毫秒
com.alibaba.fastjson 并发：5，累计：100000次，耗时：7867毫秒
com.alibaba.fastjson 并发：5，累计：100000次，耗时：7658毫秒
com.alibaba.fastjson 并发：5，累计：100000次，耗时：7903毫秒
avg: 7812毫秒

com.jsoniter 并发：5，累计：100000次，耗时：7491毫秒
com.jsoniter 并发：5，累计：100000次，耗时：7399毫秒
com.jsoniter 并发：5，累计：100000次，耗时：7487毫秒
com.jsoniter 并发：5，累计：100000次，耗时：7464毫秒
com.jsoniter 并发：5，累计：100000次，耗时：7548毫秒
avg: 7477.8毫秒

com.json 并发：5，累计：100000次，耗时：21349毫秒
com.json 并发：5，累计：100000次，耗时：24661毫秒
com.json 并发：5，累计：100000次，耗时：21350毫秒
com.json 并发：5，累计：100000次，耗时：21547毫秒
com.json 并发：5，累计：100000次，耗时：21432毫秒
avg: 22067.8毫秒

耗时：com.json > com.google.gson > com.alibaba.fastjson > com.jsoniter > com.fasterxml.jackson
最优：com.fasterxml.jackson
```
