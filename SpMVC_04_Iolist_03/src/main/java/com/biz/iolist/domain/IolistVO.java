package com.biz.iolist.domain;

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
public class IolistVO {

	private long io_seq;//	number
	private String io_data;//	varchar2(10)
	private String io_inout;//	nvarchar2(2)
	private String io_dcode;//	varchar2(5)
	private String io_dname;//	nvarchar2(50)
	private String io_dceo;//	nvarchar2(50)
	private String io_pcode;//	varchar2(5)
	private String io_pname;//	nvarchar2(50)
	private int io_iprice;//	number
	private int io_oprice;//	number
	private String io_vat;//	varchar2(1)
	private int io_qty;//	number
	private int io_price;//	number
	private int io_total;//	number
	
}
