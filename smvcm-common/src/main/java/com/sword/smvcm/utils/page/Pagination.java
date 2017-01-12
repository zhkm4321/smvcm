package com.sword.smvcm.utils.page;

import java.util.List;

/**
 * 列表分页。包含list属性。
 */
@SuppressWarnings("serial")
public class Pagination extends Page implements java.io.Serializable {

  public Pagination() {
  }

  /**
   * 构造器
   * 
   * @param pageNo 页码
   * @param pageSize 每页几条数据
   * @param totalCount 总共几条数据
   */
  public Pagination(int pageNo, int pageSize, long totalCount) {
    super((pageNo - 1) * pageSize, pageSize, totalCount);
  }

  /**
   * 构造器
   * 
   * @param pageNo 页码
   * @param pageSize 每页几条数据
   * @param totalCount 总共几条数据
   * @param list 分页内容
   */
  public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
    super((pageNo - 1) * pageSize, pageSize, totalCount);
    this.list = list;
  }

  /**
   * 第一条数据位置
   * 
   * @return
   */
  public int getFirstResult() {
    return (getPageNo() - 1) * getPageCount();
  }

  /**
   * 当前页的数据
   */
  private List<?> list;

  /**
   * 获得分页内容
   * 
   * @return
   */
  public List<?> getList() {
    return list;
  }

  /**
   * 设置分页内容
   * 
   * @param list
   */
  @SuppressWarnings("unchecked")
  public void setList(List list) {
    this.list = list;
  }
}
