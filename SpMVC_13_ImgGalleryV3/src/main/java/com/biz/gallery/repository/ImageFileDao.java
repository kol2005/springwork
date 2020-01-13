package com.biz.gallery.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.gallery.domain.ImageFilesVO;

public interface ImageFileDao {

	@Select("SELECT * FROM tbl_images")
	public List<ImageFilesVO> selectAll();
	
	@Select("SELECT * FROM tbl_images WHERE img_file_seq = #{img_seq}")
	public ImageFilesVO findBySeq(long img_seq);
	
	public List<ImageFilesVO> findByPCode(long img_p_code);
	
	@Delete("DELETE FROM tbl_images WHERE img_file_seq = #{img_seq}")
	public int delete(long img_seq);

	@InsertProvider(type=ImageFileSQL.class,method="insert_sql")
	public int insert(ImageFilesVO file);
	
	@Insert(ImageFileSQL.bulk_insert_sql)
	public int bulk_insert(@Param("files") List<ImageFilesVO> files,@Param("img_p_code") long p_code);
}
