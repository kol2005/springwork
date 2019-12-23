$(function(){
	
	$("#pro-img-delete").click(function(){
		if(confirm("대표이미지를 삭제할까요")){
			let p_code = $("#p_code").val()
			document.location.href=rootPath + "/proImgDelete?p_code=" + p_code 
		}
	})	
	


	
	// jquery 2.x 미만에서 사용한 코드
	// $("img.sub-img").live(function())
	
	// jquery 1.7 에성에서 사용하던 코드
	// $("img.sub-img").on("click",function())
	
	// 현재 버전에서 사용하는 코드
	// jqeury에서 동적으로 생성한 tag에 이벤트를 주는 방법
	// 동적 tag : 스크립트로 임의로 추가(append)한 tag
	// html 문서에 click 이벤트를 설정하고
	// 혹시 클릭된 요소가 img.sub-img 이냐?
	$(document).on("click","span.img-delete",function(){
		let file_name = $(this).attr("data-name")
		if(confirm(file_name + " 이미지를 삭제합니다")){
		let file_seq = $(this).attr("data-id")
		
		$.ajax({
			
			url:rootPath + "/rest/subImgDelete",
			data : {file_seq : file_seq},
			success : function(p_code){
				getProInfo(p_code)
			}
		})
		//document.location.href="${rootPath}/subImgDelete?file_seq=" + file_seq
	}
	})
	$(document).on("click","img-view",function(){
		let file_name = $(this).attr("data-upload")
		window.open(rootPath + "/files/" + file_name,"_new",
		"toolbar=no,scrollbars=no")
	})
	
	// 코딩으로 만든 tag에 이벤트를 주는 방법
	$("tr.p-row").click(function(){
		let p_code = $(this).attr("data-id")
		getProInfo(p_code)
	})
	
	var getProInfo = function(p_code){
		$.ajax({
			
			// "getProduct?"p_code=" + p_code"
			url : rootPath + "/rest/getProduct",
			data : {p_code : p_code},//p_code
			dataType : 'json',
			success : function(result){
				$("#p_code").val(result.p_code)
				$("#p_name").val(result.p_name)
				$("#p_iprice").val(result.p_iprice)
				$("#p_oprice").val(result.p_oprice)
				$("#p_file").val(result.p_file)
				let profileImage = rootPath + "/files/noimage.png"
				if(result.p_file != null){
					profileImage = rootPath + "/files/" + result.p_file
				}
				$("#p_image").attr("src",profileImage)
				$("#pro-img-search").attr("data-upload",result.p_file)
				
				if(result.p_vat == "1"){
					$("#p_vat").attr("checked","checked")
				} else {
					$("#p_vat").attr("checked","")
				}
				
				//let image = "${rootPath}/files/noimage.png"
					$("#p_sub_list").html("")
				if(result.p_files.length > 0){

					result.p_files.forEach(function(file){
						
						var imgTag = 
							$("<img/>",{
								width:"500px",
								height:"500px",
								margin: "10px",
								"class" : "sub-img",
								"data-id" : file.file_seq,
								"data-name" : file.file_orign_name,
								"alt" : file.file_orign_name,
								src : rootPath + "/files/" + file.file_upload_name
							})
							
							var delTag = 
							$("<span/>",{
									"class":"img-delete",
									"data-id" : file.file_seq,
									"data-name" : file.file_origin_name,
								}).append($("<i/>",{"class":"fa fa-trash"} ))
								
								var viewTag = 
									$("<span/>",{
										"class":"img-view",
										"data-id" : file.file_seq,
										"data-name" : file.file_origin_name,
										"data-upload" : file.file_upload_name,
									}).append($("<i/>",{"class":"fa fa-search"} ))
									
						$("#p_sub_list").append(
								$("<div/>",{"class" : "sub-img-box"}).append(
										imgTag,
										$("<div>",{"class":"img-menu"}).append(
											delTag,viewTag
								)
							)
						)
					})
				}
			},
			error : function(){
				alert("서버통신 오류")
			}
		})
		
	}
	
	if(bStart == 0){
		
		// input box에 상품코드
		var p_code = $("#p_code").val()
		
		// 없으면 리스트의 첫번째 항목에서 추출한 상품코드
		if(p_code == ""){
			// list table의 첫번째 tr을 가져와라
			let tr = $("tr.p-row:eq(0)")
			p_code = tr.attr("data-id")
		}	
		
		// 상품코드를 getProInfo() 함수에 전달하여
		// input box에 값을 초기화 시켜라
		getProInfo(p_code)
		bStart ++
	}
	
	
	
	
})