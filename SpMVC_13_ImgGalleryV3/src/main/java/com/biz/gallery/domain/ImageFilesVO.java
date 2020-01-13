package com.biz.gallery.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("fileVO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ImageFilesVO {
	
	private long img_file_seq;//
	private long img_file_p_code;//
	private String img_file_origin_name;//
	private String img_file_upload_name;//
}
