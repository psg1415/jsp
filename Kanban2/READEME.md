# 칸반보드
## 개요
### 1. 서비스 내용
```
```
* PHP로 구현된 칸반 보드 <>
* NODE.js로 구현된 칸반 보드: <http://example.com/>


### 2. 적용 기술
```

```

3. 각 페이지별 소개
* 메인페이지
![메인페이지](https://www.google.com/images/branding/googlelogo/1x/googlelogo_light_color_272x92dp.png)


## 핵심기술
### 1. 회원가입
#### 동작 방식에 대한 설명
```
    if (process.env.NODE_ENV === 'development') require('dotenv').config()
    var express = require('express');
    var path = require('path');
    var serveStatic = require('serve-static');
    app = express();
    app.use(serveStatic(__dirname));
    var port = process.env.PORT || 5000;
    app.listen(port);
    console.log('server started '+ port);
```
