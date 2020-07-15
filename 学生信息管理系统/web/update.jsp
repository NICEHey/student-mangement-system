<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>

        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改学生信息</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <script>
            function update(id) {
                if (confirm("确定更新用户信息？")){
                    location.href = "${pageContext.request.contextPath}/updateUserServlet?id="+id;
                }
            }
        </script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改学生信息</h3>
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">

            <%--隐藏域 提交id--%>
            <input type="hidden" name="id" value="${user.id}">

          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" value="${user.name}" id="name" name="name"  <%--readonly="readonly"--%> placeholder="请输入姓名" />
          </div>

          <div class="form-group">
            <label>性别：</label>

              <c:if test="${user.gender == null}">
                  <input type="radio" name="gender" value="男"  checked />男
                  <input type="radio" name="gender" value="女"  />女
              </c:if>

              <c:if test="${user.gender == '男'}">
                <input type="radio" name="gender" value="男"  checked />男
                <input type="radio" name="gender" value="女"  />女
              </c:if>

              <c:if test="${user.gender == '女'}">
                  <input type="radio" name="gender" value="男"  />男
                  <input type="radio" name="gender" value="女"  checked />女
              </c:if>
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${user.age}" id="age"  name="age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
             <select name="address" class="form-control" >

                 <c:if test="${user.address =='北京'}">
                    <option value="北京" selected>北京</option>
                    <option value="上海">上海</option>
                    <option value="山西">山西</option>
                 </c:if>

                 <c:if test="${user.address == '上海'}">
                     <option value="北京">北京</option>
                     <option value="上海" selected>上海</option>
                     <option value="山西">山西</option>
                 </c:if>

                 <c:if test="${user.address == '山西'}">
                     <option value="北京">北京</option>
                     <option value="上海">上海</option>
                     <option value="山西" selected>山西</option>
                 </c:if>
            </select>
          </div>

          <div class="form-group">
            <label for="cls">班级</label>
            <input type="text" class="form-control" value="${user.cls}"  name="cls" placeholder="请输入班级"/>
          </div>

          <div class="form-group">
            <label for="tel">联系电话</label>
            <input type="text" class="form-control"  value="${user.tel}" name="tel" placeholder="请输入联系电话"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
<%--
                 <a class="btn btn-default btn-sm" href="javaScript:update(${user.id})">提交</a>
--%>
                 <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>