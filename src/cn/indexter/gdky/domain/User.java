package cn.indexter.gdky.domain;

import java.util.Date;
import java.util.Set;

/**
 * User
 */
public class User extends BaseEntity {
	private static final long serialVersionUID = -8203567911331304856L;
	
/*	private Set<String> uuids;
	
	
	
	public Set<String> getUuids() {
		return uuids;
	}

	public void setUuids(Set<String> uuids) {
		this.uuids = uuids;
	}*/

	private Integer id;
	private String phone;
	private String email;
	private String password;
	private String nickName;
	private Date regDate = new Date();
	//�Ƿ��ǳ�������Ա
	private boolean superAdmin ;
	
	private Set<Menuitem> menuitems;
	
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Menuitem> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(Set<Menuitem> menuitems) {
		this.menuitems = menuitems;
	}

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	//��ɫ����
	
	//�û�Ȩ���ܺ�
	private long[] rightSum ;

	public long[] getRightSum() {
		return rightSum;
	}

	public void setRightSum(long[] rightSum) {
		this.rightSum = rightSum;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


}
