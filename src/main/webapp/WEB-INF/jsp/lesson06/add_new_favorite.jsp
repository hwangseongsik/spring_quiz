<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<div>
			<label for="name" class="col-6"><b>제목</b><br>
			<input type="text" id="name" placeholder="제목을 입력하세요"></label>
		</div>
		<div>
			<label for="url" class="col-6"><b>주소</b><br>
			<input type="text" id="url" placeholder="주소를 입력하세요"></label>
		</div>
		<input type="button" id="addBtn" class="col-6 btn btn-success" value="추가">
	</div>
	
<script>
$(document).ready(function() {
	// AJAX 통신
	$('#addBtn').on('click', function(e) {
		
		// validation
		let name = $('input[name=name]').val().trim();
		if (name == '') {
			alert("이름을 입력하세요");
			return;
		}
		
		let url = $('#url').val().trim();
		if (url.length < 1) {
			alert("주소를 입력해주세요.");
			return;
		}

		// 서버에 전송 AJAX
		$.ajax({
			type:"post"
			, url:"/lesson06/quiz01/add_favorite"
			, data: {"name":name, "url":url}
		
			// response
			, success: function(data) {
				alert(data);
				location.href = "/lesson06/quiz01/get_user_view";
			}
			, error: function(e) {
				alert("에러, " + e);
			}
		});
	});
});
</script>
</body>
</html>