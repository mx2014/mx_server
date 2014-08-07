/**
 * 
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserInfo")
public class UserInfo {
	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "iphone_type")
	private Integer iphone_type;
	
	@Column(name = "login_ip")
	private String login_ip;
	
	@Column(name = "mc_adress")
	private String mc_adress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getIphone_type() {
		return iphone_type;
	}

	public void setIphone_type(Integer iphone_type) {
		this.iphone_type = iphone_type;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public String getMc_adress() {
		return mc_adress;
	}

	public void setMc_adress(String mc_adress) {
		this.mc_adress = mc_adress;
	}
	
	
}