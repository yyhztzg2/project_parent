package com.xx.test.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * page实体类
 * @author 
 *
 */
@Table(name="test_page")
public class Page implements Serializable{

	@Id
	private String pageId;//pageId


	
	private String bookname;//bookname
	private String bookbuyer;//bookbuyer
	private String bookborrower;//bookborrower
	private String bookStatus;//bookStatus
	private String locationType;//locationType
	private String selectValue;//selectValue
	private String cmspageId;//cmspageId
	private Integer bookvolume;//bookvolume

	
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookbuyer() {
		return bookbuyer;
	}
	public void setBookbuyer(String bookbuyer) {
		this.bookbuyer = bookbuyer;
	}

	public String getBookborrower() {
		return bookborrower;
	}
	public void setBookborrower(String bookborrower) {
		this.bookborrower = bookborrower;
	}

	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getSelectValue() {
		return selectValue;
	}
	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
	}

	public String getCmspageId() {
		return cmspageId;
	}
	public void setCmspageId(String cmspageId) {
		this.cmspageId = cmspageId;
	}

	public Integer getBookvolume() {
		return bookvolume;
	}
	public void setBookvolume(Integer bookvolume) {
		this.bookvolume = bookvolume;
	}


	
}
