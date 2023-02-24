<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
p {
	text-align: center;
}
</style>
<script>
	window.onload = function() {
		document.querySelector('form').onsubmit = function() {
			var su1 = document.querySelector('input[name="su1"]');
			var su2 = document.querySelector('input[name="su2"]');
			if (!su1.value) {
				alert('첫번째 수를 입력하세요');
				su1.focus();
				return false;
			} else if (!su2.value) {
				alert('두번째 수를 입력하세요');
				su1.focus();
				return false;
			}
			var s1 = parseInt(su1.value);
			var s2 = Number(su2.value);
			if (s1 > s2) {
				alert('첫번째 수는 두번째 수보다 작거나 같아야 합니다.');
				su1.focus();
				return false;
			}
		};
	};
</script>
</head>
<body>
	<form action="06_su2timesTableOut.jsp" method="get">
		<p>
			단수: <input type="number" name="su1"> 단 ~ <input type="number"
				name="su2"> 단까지
		</p>
		<p>
			<input type="submit" value="구구단 출력">
		</p>
	</form>
</body>
</html>