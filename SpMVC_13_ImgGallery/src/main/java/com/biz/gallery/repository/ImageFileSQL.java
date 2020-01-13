package com.biz.gallery.repository;

import org.apache.ibatis.jdbc.SQL;

public class ImageFileSQL {

	public String insert_sql() {
		return new SQL() {{
			INSERT_INTO("tbl_images");
		
			INTO_COLUMNS("IMG_FILE_SEQ");
			INTO_COLUMNS("IMG_FILE_P_CODE");
			INTO_COLUMNS("IMG_FILE_ORIGIN_NAME");
			INTO_COLUMNS("IMG_FILE_UPLOAD_NAME");
			
			INTO_VALUES("SEQ_IMAGES.NEXTVAL");
			INTO_VALUES("#{img_file_p_code,jdbcType=VARCHAR}");
			INTO_VALUES("#{img_file_origin_name,jdbcType=VARCHAR}");
			INTO_VALUES("#{img_file_upload_name,jdbcType=VARCHAR}");
			
			
		}}.toString();
	}
}
