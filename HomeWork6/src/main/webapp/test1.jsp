<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <title>test</title>
</head>

<body>

<p>Какую страницу желаете открыть?</p>
<form>
  <input id="btn1" type="button" value="Страница message">
  <input id="btn2" type="button" value="Страница chat">
</form>
<div id="content"></div>

<script>
  $(document).ready(function(){

    $('#btn1').click(function(){
      $.ajax({
        url: "${pageContext.request.contextPath}/message",
        cache: false,
        success: function(html){
          $("#content").html(html);
        }
      });
    });

    $('#btn2').click(function(){
      $.ajax({
        url: "${pageContext.request.contextPath}/chat",
        cache: false,
        success: function(html){
          $("#content").html(html);
        }
      });
    });

  });
</script>

</body>
</html>