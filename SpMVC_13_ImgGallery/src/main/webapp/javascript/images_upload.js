var files_up = function(formData) {

	$.ajax({
		url : rootPath + "/image/files_up",
		method : 'POST',
		data : formData,
		
		processData : false, /* 파일업로드 필수 옵션 */
		contentType : false, /* 파일업로드 필수 옵션 */
		
		success : function(result) {
			if (result == 'FAIL') {
				alert("파일 업로드 오류")
			} else {
				$("#d_d_box").html(result)
			}
		},
		error : function() {
			alert("서버통신 오류")
		}

	})

}