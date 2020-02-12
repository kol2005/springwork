package com.biz.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * spring security에서 DB를 연동하여 login을 수행할때
 * 사용자정보를 저장할 table
 * 이 테이블의 enabled 칼럼이 false이면
 *  해당 계정이 사용정지된 것으로 인식을 한다
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="users",schema="emsDB")
public class Users {

	@Id
	private String username;
	private String password;
	private boolean enabled;
	
}
