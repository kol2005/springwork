<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<style>

.email-view{
display: flex;
flex-flow: column;
width: 95%;
margin: 10px auto;
}

.email-view div{
display: flex;
flex-wrap: nowrap;
width: 95%;

margin: 1px auto;
border: 1px solid #ddd;
padding: 5px;
}

.email-view div div:nth-child(odd){
width: 3%;
background-color: #ddd;
padding: 5px;
text-align: right;
margin-right: 5px;
font-weight: bold;
color: blue;
}

.email-view div div:nth-child(even){
width:65%;
background-color: #fff;
padding: 5px;
}

.email-view div:last-child(4),.email-view div:last-child(5) div {
width: 100%;
padding: 10px 16px;
background-color: #fff;
color: black;
text-align: left;	
}

.email-view div:last-child {
display: flex;
border: 0;
}

.email-view div:last-child button {
padding: 10px 16px;
margin: 5px;
color: white;
cursor: pointer;
border: 0;
outline: 0;
border-radius: 5px;
}

.email-view div:last-child button:hover {
box-shadow: 2px 2px 2px rgba(123,123,123,0.3);
font-weight: bold;
}

.email-view div:last-child button:first-child {
margin-left:auto;
}

.email-view div:last-child button:nth-child(1){background-color: :blue;}
.email-view div:last-child button:nth-child(2){background-color: :red;}
.email-view div:last-child button:nth-child(3){background-color: :orange; color:black;} 
	

</style>

<script>
$(function(){
	
	var buttonText = Array{"수정","삭제","리스트"}
	
	let buttons = $(".email-view div:last-child").children()
	for(let i = 0 ; i < 3 ; i++){
		buttons.eq(i+1).text(buttonText[i])
	}
	//buttons.eq(2).text(buttonText[1])
	//buttons.eq(3).text(buttonText[2])
	
	$(".email-view div:last-child button").click(function(){
		
		let text = $(this).text()
		let url = "${rootPath}/ems/"
		if(text == buttonText[0]){
			url += "update/" + ${emailVO.emsSeq}
		}else if(text == buttonText[1]){
			url += "delete/" + ${emailVO.emsSeq}
		}else if(text == buttonText[2]){
			url += "/list"
		}
		document.location.href = url
	})
})
</script>

<article class="email-view">
	<div>
		<div>받은 email</div>
		<div>${emailVO.to_email}</div>
		<div>받은 사람</div>
		<div>${emailVO.to_name}</div>
	</div>
	
	<div>
		<div>보낸 Email</div>
		<div>${emailVO.fromEmail}</div>
		<div>보낸 사람</div>
		<div>${emailVO.fromName}</div>
	</div>
		
	<div>
		<div>작성일자</div>
		<div>${emailVO.sendDate}</div>
		<div>작성시각</div>
		<div>${emailVO.sendTime}</div>
	</div>
	
	<div>
		<div>${emailVO.subject}</div>
	</div>
	<div>
		<div>${emailVO.content}</div>
	</div>

<div>
<button>수정</button>
<button>삭제</button>
<button>리스트</button>
</div>

</article>
</html>