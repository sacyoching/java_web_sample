<html>
<head>
  <title>Home</title>
  <%@ taglib prefix="hello" uri="../hello.tld"  %>
</head>
<body>
  <h1>ようこそHomeページへ !</h1>
  <p>現在時刻は「 ${date}」です。</p>
  <p><hello:sayHello /></p>
  <spring:url value="/sample/point" var="action" />
  <form:form modelAttribute="homeForm" action="${action}">
    <select id="users" name="users">
  <c:forEach var="user" items="${userList}">
      <option value="${user.id}" >${user.name}<option/>
   </c:forEach>
   </select>
    <form:label path="point">付与するポイントは？</form:label>
    <form:input path="point" />
    <form:errors path="point" cssStyle="color:red" />
    <input type="submit" value="送信" />
  </form:form>
</body>
</html>