package com.biz.gallery.repository;

import org.apache.ibatis.jdbc.SQL;

public class ImageFileSQL {

	public final static String bulk_insert_sql =
			"<script>"
				+"INSERT INTO	tbl_images ("
				+"IMG_FILE_SEQ,"
				+"IMG_FILE_P_CODE,"
				+"IMG_FILE_ORIGIN_NAME,"
				+"IMG_FILE_UPLOAD_NAME"
				+") SELECT SEQ_IMAGES.NEXTVAL, SUB.* FROM ("
				+"<foreach collection='files' item='file' separator='UNION ALL'>"
				+"SELECT"
				+"#{img_p_code,jdbcType=VARCHAR},"
				+"#{file.img_file_origin_name,jdbcType=VARCHAR},"
				+"#{file.img_file_upload_name,jdbcType=VARCHAR}"
				+"FROM DUAL"
				+"</foreach>"
				+") SUB"
				+"</script>";

	public String insert_sql() {
		return new SQL() {
			{
				INSERT_INTO("tbl_images");

				INTO_COLUMNS("IMG_FILE_SEQ");
				INTO_COLUMNS("IMG_FILE_P_CODE");
				INTO_COLUMNS("IMG_FILE_ORIGIN_NAME");
				INTO_COLUMNS("IMG_FILE_UPLOAD_NAME");

				INTO_VALUES("SEQ_IMAGES.NEXTVAL");
				INTO_VALUES("#{img_file_p_code,jdbcType=VARCHAR}");
				INTO_VALUES("#{img_file_origin_name,jdbcType=VARCHAR}");
				INTO_VALUES("#{img_file_upload_name,jdbcType=VARCHAR}");

			}
		}.toString();
	}
}
