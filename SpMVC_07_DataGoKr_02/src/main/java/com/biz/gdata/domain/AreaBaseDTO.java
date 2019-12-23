package com.biz.gdata.domain;

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
public class AreaBaseDTO {
	private String addr1;			//	<addr1>대구광역시 동구 동화사1길 1</addr1>
	private String addr2;			//	<addr2>(도학동)</addr2>
	private String areacode;		//	<areacode>4</areacode>
	private String cat1;			//	<cat1>A02</cat1>
	private String cat2;			//	<cat2>A0207</cat2>
	private String cat3;			//	<cat3>A02070200</cat3>
	private String contentid;		//	<contentid>2034152</contentid>
	private String contenttypeid;	//	<contenttypeid>15</contenttypeid>
	private String createdtime;		//	<createdtime>20151019152356</createdtime>
	private String firstimage;		//	<firstimage>
									//	http://tong.visitkorea.or.kr/cms/resource/80/1574180_image2_1.jpg
									//	</firstimage>
	private String firstimage2;		//	<firstimage2>
									//	http://tong.visitkorea.or.kr/cms/resource/80/1574180_image3_1.jpg
									//	</firstimage2>
	private String mapx;			//	<mapx>128.7044413599</mapx>
	private String mapy;			//	<mapy>35.9906472258</mapy>
	private String mlevel;			//	<mlevel>6</mlevel>
	private String modifiedtime;	//	<modifiedtime>20191022112900</modifiedtime>
	private String readcount;		//	<readcount>5448</readcount>
	private String sigungucode;		//	<sigungucode>4</sigungucode>
	private String tel;				//	<tel>053-980-7900</tel>
	private String title;			//	<title>동화사 승시 국화축제 2019</title>
	private String zipcode;			//	<zipcode>41007</zipcode>
}
