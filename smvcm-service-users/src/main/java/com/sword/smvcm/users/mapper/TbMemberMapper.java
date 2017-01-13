package com.sword.smvcm.users.mapper;

import com.sword.smvcm.users.pojo.TbMember;
import com.sword.smvcm.users.pojo.TbMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMemberMapper {

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */
  int deleteByExample(TbMemberExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */
  int insert(TbMember record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */
  int insertSelective(TbMember record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */List<TbMember> selectByExampleWithBLOBs(TbMemberExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */List<TbMember> selectByExample(TbMemberExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */
  TbMember selectByPrimaryKey(Integer id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */int updateByExampleSelective(@Param("record") TbMember record,@Param("example") TbMemberExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */int updateByExampleWithBLOBs(@Param("record") TbMember record,@Param("example") TbMemberExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */int updateByExample(@Param("record") TbMember record,@Param("example") TbMemberExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */
  int updateByPrimaryKeySelective(TbMember record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */
  int updateByPrimaryKeyWithBLOBs(TbMember record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user_member
   * @mbg.generated
   */
  int updateByPrimaryKey(TbMember record);
}