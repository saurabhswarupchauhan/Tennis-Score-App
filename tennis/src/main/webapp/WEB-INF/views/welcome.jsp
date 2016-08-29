<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>Tennis Application</title>
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>

<body>
	<div>
		<div>
			<input type="button" value="player1" name="button1"
				onclick="location.href='/tennis/wonPoint?player=PLAYER1&player1Score=${player1Score}&player2Score=${player2Score}'">||
			<input type="button" value="player2" name="button2"
				onclick="location.href='/tennis/wonPoint?player=PLAYER2&player1Score=${player1Score}&player2Score=${player2Score}'">
		</div>
	</div>
	<b>Score Board</b>

	<div>
	<table>
	<tr>
	<td>Player 1 Score</td>
	<td>${player1Score}</td>
	<td>${score}</td>
	<td>${player1Advantage}</td>
	</tr>
	<tr>
    	<td>Player 2 Score</td>
    	<td>${player2Score}</td>
    	<td>${player1Advantage}</td>

    	</tr>
	</table>

	</div>
</body>
</html>