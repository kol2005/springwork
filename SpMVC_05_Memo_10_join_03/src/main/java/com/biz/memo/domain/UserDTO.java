package com.biz.memo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@ScriptAssert(lang="javascript",script="(_this.u_password == _this.re_password)",reportOn="re_password",message="비밀번호를 확인해주세요")
public class UserDTO {
	
//	U_ID	VARCHAR2(125 BYTE)
//	U_NICK	NVARCHAR2(125 CHAR)
//	U_NAME	NVARCHAR2(125 CHAR)
//	U_PASSWORD	VARCHAR2(125 BYTE)
//	U_TEL	VARCHAR2(20 BYTE)
//	U_GRADE	VARCHAR2(5 BYTE)

	/*
	 * @Email : email 형식 검사
	 * @NotBlank : 공백검사
	 * @NotNull : null 이 아닐 경우만 정상
	 * @Null : null 일 경우만 정상
	 * @Max(x), @Min(x) : 숫자의 최대값 최소값 제한
	 * @Size(min=x,max=x) : 문자열일 경우
	 * @DecimalMax(x) : x값 이하의 십진수
	 * @DecimalMin(x) : x값 이상의 십진수
	 * @Digits(integer=x) : x 자릿수 이하의 정수
	 * @Digits(integer=x, fraction=y) : x자릿수 이하의 정수이면서 y자릿수 이하 소수점 자릿수
	 */

	@NotNull
	@NotBlank(message = "공뷁이 잇쓰믄 않댸")
	@Email(message = "e몌읠루먄 쑤워야댸")
	@Size(min = 5 , max = 100)
	private String u_id;
	private String u_password;
	
	private String re_password;
	private String u_name;
	
	@NotBlank(message = "닋냬읾은 비어있으면 않뎨")
	private String u_nick;
	private String u_grade;
	
	@Pattern(regexp = "\\d{1,15}",message = "1~15자리 정수만")
	private String u_tel;
	
}
