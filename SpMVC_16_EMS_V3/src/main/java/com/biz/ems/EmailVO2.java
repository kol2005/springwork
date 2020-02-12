package com.biz.ems;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Builder
@ToString
/*
 * @Entity
 * import javax.persistence.Entity를 해야 한다
 * - JPA interface에 정의된 속성을 지정해야 한다
 * - 지금부터 이 클래스는 entity이니
 * 물리적 table과 연동되도록 준비하라
 * 속성중에 다음 항목이 지정되어 있으면
 * <prop key="hibernate.hbm2ddl.auto">create</prop>
 * Entity에 지정된 속성에 따라 table을 생성하라
 * create value : drop and create
 * 지정하지 않으면 기본값이 create
 * update 로 지정을 하면 table이 없으면 생성을 하고
 * 만약 물리적 table과 구조가 다르면 오류가 발생한다
 * 주의
 * 	- 만약 hib.hbm2ddl.auto 속성을 지정하지 않으면
 * 		기본값으로 create가 지정되어 기존의 테이블을 
 * 		drop한 후 재작성해 버린다
 * none : 기본값, 아무일도 하지 않는다
 * create-only : 테이블을 새로 생성
 * drop : 삭제
 * create : drop and create
 * create-drop : 시작할때 drop and create를 수행하고
 * 		session이 끝나면 다시 drop을 한다
 * validate : 검증만 하고
 * update : 스키마를 갱신, 없으면 만들고 있으면 validate 수행
 */
@Entity
@Table(name="tbl_ems",schema = "emsDB")
public class EmailVO2 {

	// 보내는 Email
	// 받는 Email
	// 보내는 사람 이름
	// 받는 사람 이름
	// 제목
	// 내용
	// 작성일자
	// 작성시각
	/*
	 * 필드변수에 @Id, @Column 속성지정
	 * - 테이블의 칼럼으로 생성
	 * @Id : PRIMARY KEY 칼럼으로 생성
	 * @GeneratedValue() 속성을 AUTO로 지정하면
	 * auto_increment를 수행하여 insert할떄
	 * 자동 값 채우기가 된다
	 * 
	 * table의 칼럼명은 ems_seq로 지정하고
	 * vo 클래스의 필드변수는
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ems_seq")
	private long emsSeq;
	
	/*
	 * @Column() 지정하는 속성
	 * nullable : not null과 연관
	 * nullable = false : not null 설정
	 * nullable = true : default null 설정
	 * length : 칼럼의 길이 지정하지 않으면 DB기본값으로 255 설정
	 * 칼럼을 생성할떄는 필드변수의 이름과 같이 생성
	 */
	@Column(name="from_email", nullable = false,length = 20)
	private String fromEmail;
	
	/*
	 * @Column(name="to_email")
	 * 필드변수와 칼럼의 이름을 달리 설정하고자 할때
	 */
	@Column(name="to_email", nullable = false)
	private String to_email;
	
	/*
	 * @Column(columnDefinition = "")
	 * 칼럼의 type을 DB의 고유한 type으로 강제 적용
	 */
	@Column(name="from_name", nullable = true,columnDefinition = "nVARCHAR(20)")
	private String fromName;
	@Column(nullable = true, columnDefinition = "nVARCHAR(20)")
	private String to_name;
	
	@Column(nullable = false, columnDefinition = "nVARCHAR(100)")
	private String subject;
	
	@Column(nullable = true, columnDefinition = "nVARCHAR(1000)")
	private String content;
	@Column(name="send_date",nullable = true)
	private String sendDate;
	@Column(name="send_time",nullable = true)
	private String sendTime;
	
}
