<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*,web.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>Web</title>
	<link href="/css/bootstrap.css" rel="stylesheet" />
	<link href="/css/main.css" rel="stylesheet" />
	<style>
		form > * {
			margin-top: 10px;
		}
	</style>
</head>
<body>

<div class="container">
	<form>
		<input type="text" class="form-control" name="data" 
			autofocus="autofocus" placeholder="Search" />
		<input type="submit" class="btn btn-primary" value="Search" />
	</form>

	<ul>
	<%
	List<Station> stations = (List<Station>)request.getAttribute("result");
	for (int i = 0; i < stations.size(); i++) {
		Station s = stations.get(i);
	%>
		<li>
		<%= s.suburb %>
		</li>
	<%
	}
	%>
	</ul>
</div>

<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
