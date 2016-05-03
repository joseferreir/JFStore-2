<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="errorModal" role="dialog">
  <div class="modal-dialog">
      <link rel="stylesheet" href="/dist/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="/dist/css/bootstrap-theme.min.css" type="text/css">

        <!-- Datepicker -->
        <link rel="stylesheet" href="/dist/css/datepicker/bootstrap-datepicker.min.css">

<%
      pageContext.setAttribute("erro", request.getSession().getAttribute("erros"));
%>
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header align-center">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title text-danger">${erro}</h4>
      </div>
      <div class="modal-body align-center">
        <p id="error-body"></p>
      </div>
      <div class="modal-footer">
          <a href="cadastro.html" class="align-center btn-lg">
      </div>
    </div>

  </div>
</div>