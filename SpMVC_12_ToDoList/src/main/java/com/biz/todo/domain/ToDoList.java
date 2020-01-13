package com.biz.todo.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * mybatis-context.xml에서 typeAliasesPackage 속성을 사용할 경우
 * alias 이름이 자동으로 클래스 첫글자를 소문자로 변경한 형식으로 생성이 되는데
 * 클레스 이름이 너무 길거나, 이해하기 어려울 경우
 * 별도로 별명을 붙일수 있다
 * 이때 사용하는 Annotation이 @Alias 이다
 */
@Alias("todoDTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ToDoList {

	/*
	 * domain class의 필드변수를 camelcase로 변경
	 * aa_bbb : snake Case
	 * aaBbb : camel Case
	 */
	private long tdSeq;		//	number
	private String tdDate;		//	varchar2(10 byte)
	private String tdTime;		//	varchar2(8 byte)
	private String tdSubject;	//	nvarchar2(125 char)
	private String tdText;		//	nvarchar2(1000 char)
	private String tdFlag;		//	varchar2(1 byte)
	private String tdComplete;	//	varchar2(1 byte)
	private String tdAlam;		//	varchar2(1 byte)
	
}
