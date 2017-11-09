package dangdang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String nickname;
	private String password;
	private Integer isEmailVerify;
	private String emailVerifyCode;
	private Long lastLoginTime;
	private String lastLoginIp;
	private Set comments = new HashSet(0);
	private Set addresses = new HashSet(0);
	private Set commentReplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	/** full constructor */
	public User(String email, String nickname, String password,
			Integer isEmailVerify, String emailVerifyCode, Long lastLoginTime,
			String lastLoginIp, Set comments, Set addresses, Set commentReplies) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.comments = comments;
		this.addresses = addresses;
		this.commentReplies = commentReplies;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsEmailVerify() {
		return this.isEmailVerify;
	}

	public void setIsEmailVerify(Integer isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	public String getEmailVerifyCode() {
		return this.emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public Long getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}

	public Set getCommentReplies() {
		return this.commentReplies;
	}

	public void setCommentReplies(Set commentReplies) {
		this.commentReplies = commentReplies;
	}

}