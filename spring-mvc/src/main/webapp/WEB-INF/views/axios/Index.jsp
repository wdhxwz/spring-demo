<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Axios Test</title>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
    <h1>Axios测试</h1>

    <div>
        <input type="button" onclick="getUser('123')" value="获取用户">
    </div>
</body>

<script type="text/javascript">
    var instance = axios.create({
        baseURL: 'http://127.0.0.1:8080/api/',
        timeout: 1000
    });
    function getUser(userId) {
        instance.get("getUser.do?userId=" + userId)
            .then(function(response) {
                console.log(response.data);
                console.log(response.status);
                console.log(response.statusText);
                console.log(response.headers);
                console.log(response.config);
        }).catch(function (error) {
            console.log(error);
        });
    }

</script>
</html>
