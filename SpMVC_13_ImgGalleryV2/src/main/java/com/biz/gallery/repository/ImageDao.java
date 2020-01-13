package com.biz.gallery.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;

public interface ImageDao {

	@Select("SELECT * FROM tbl_gallery")
	public List<ImageVO> selectAll();
	
	@Select("SELECT * FROM tbl_gallery WHERE img_seq = #{img_seq} AND img_file = #{img_file}")
	public ImageVO findBySeqAndFile(@Param("img_seq")long img_seq,@Param("img_file") String img_file);
	
	/*
	 @SelectKey(keyProperty = "img_seq",
				keyColumn = "img_seq",
				resultType = Long.class,
				statement = "SELECT * FROM tbl_gallery WHERE img_seq = #{img_seq}",
		 		before = false)
	*/
	
	 @SelectKey(keyProperty = "img_seq",
			keyColumn = "img_seq",
			resultType = Long.class,
			statement = "SELECT SEQ_GALLERY.NEXTVAL FROM DUAL",
	 		before = true)
	@InsertProvider(type=ImageSQL.class,method="insert_sql")
	public int insert(ImageVO imageVO);

	@Select("SELECT * FROM tbl_gallery WHERE img_seq = #{img_seq}")
	@Results(
			value= {
					@Result(property = "img_seq",column = "img_seq"),
					@Result(property = "img_files",column = "img_seq",
					javaType = List.class,many = @Many(select = "getFiles"))
			}
			)
	public ImageVO findBySeq(String img_seq);
	
	@Select("SELECT * FROM tbl_images WHERE img_file_p_code = #{img_file_p_code}")
	public ImageFilesVO getFiles(long img_file_p_code);

	@UpdateProvider(type=ImageSQL.class,method="update_sql")
	public int update(ImageVO imageVO);

	@Delete("DELETE FROM tbl_gallery WHERE img_seq = #{img_seq}")
	public int delete(String img_seq);
	
}
