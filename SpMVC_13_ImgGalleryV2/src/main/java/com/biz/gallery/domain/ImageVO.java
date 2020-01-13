package com.biz.gallery.domain;

import java.util.List;

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
public class ImageVO {

	private long img_seq;
	private String img_title;
	private String img_text;
	private String img_file;
	
	// 같은 이름으로 생성된 input box에 담긴 값을 수신하기
	// form에서 보낸 파일이름을 담을 변수
	private List<String> img_file_upload_name;
	
	// DB table에서 파일정보를 select했을때 담을 변수
	private List<ImageFilesVO> img_files;
}
