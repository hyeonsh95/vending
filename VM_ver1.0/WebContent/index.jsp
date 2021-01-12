<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피 자판기</title>
<style>
	*{

		magin : 0px;
		padding: 0px;
	}
	body{
		border: none;
	}
	form {
		width : 650px;
		margin : 10px auto;

	}
	table {
		width : 650px;
		padding : 5px;		
		border-collapse: collapse;
		border: 1px solid #aaa;
		
		
	}
	td{
		border: 1px solid #aaa;
		text-align : center;
		padding: 10px;
	}
	#coins{
		text-align : left;
	}
	#coins input{
		width : 80px;
		margin : 2px;
	}
	#balance{
		width: 100px;
		background: #600;
		text-align: right;
		padding-right: 5px;
		color : white;
		font-weight : bold;
	}
	#return input {
		width : 50px;
		background: #ccc;
		text-align: right;
		padding-right: 5px;
	}
	.line {
		background: #ddd;
		
	}
	
</style>
</head>
<body>
	<form action="vm" method="post">
		<table>
			<tr>
				<td class="line" colspan ="3"></td>
			</tr>
			<tr>
				<td colspan="3">
					<h1>커피 & 음료 자동 판매기</h1>
				</td>
			</tr>
			
			<tr>
				<td>밀크커피(300원)</td>
				<td>프림커피(300원)</td>
				<td>블랙커피(200원)</td>
			</tr>
			<tr>
				<td><input type="submit" value="밀크커피"></td>
				<td><input type="submit" value="프림커피"></td>
				<td><input type="submit" value="블랙커피"></td>
			</tr>
			<tr>
				<td class="line" colspan ="3"></td>
			</tr>
			<tr>
				<td id="coins" colspan="2">
					동전투입 : <input type="submit" value="500"><input type="submit" value="100"><input type="submit" value="50"><input type="submit" value="10"><br>
					직접입력 : <input type="number" min="10" max="1000" step="10" value = "0">원 <input type="submit" value="직접입력"><br>
					지폐 : 
					<select>
						<option value="10000">10,000</option>
						<option value="5000">5,000</option>
						<option value="1000">1,000</option>
					</select>
					<input type="submit" value="지폐입력">
				</td>
				<td >
					잔액 : <input id="balance" type="text" value="0">원
				</td>
			</tr>
			<tr>
				<td class="line" colspan ="3"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="동전반환"/>
				</td>
				<td id="return" colspan="2">
					반환된 금액 : <input type="text" readonly="readonly" value="1"/><br>
					500원 : <input type="text" readonly="readonly" value="1"/>개
					100원 : <input type="text" readonly="readonly" value="1"/>개<br>
					50원 : <input type="text" readonly="readonly" value="1"/>개
					10원 : <input type="text" readonly="readonly" value="1"/>개<br>
				</td>
			</tr>
			<tr>
				<td class="line" colspan ="3"></td>
			</tr>
			<tr>
				<td colspan="3">제품출구<br>
				<textarea rows="5">
					제품은 여기에서 출력됩니다.
					제품은 여기에서 출력됩니다.
					제품은 여기에서 출력됩니다.
					제품은 여기에서 출력됩니다.
					제품은 여기에서 출력됩니다.
					제품은 여기에서 출력됩니다.
				</textarea>
				</td>
			</tr>
			<tr>
				<td class="line" colspan ="3"></td>
			</tr>
		</table>
	</form>
</body>
</html>