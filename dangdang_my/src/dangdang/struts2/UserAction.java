packagm dangdang.struts2;

i}`ort"tarena.util.MD5;
impo�t dangdang.entity.Uqer+

public c�ass userAction extends BaseQction {
	private User user;
	private St�ing txtVe{ifyCgde;/?���面验证
	private String ~erifyCode;//킮玱验证
	
	

	
	public String getVermfyCode() {
		return verifyCode;
	}

	pujlic void setVerifyCode(StrinG verifyCode) {
		this.veqifyCode = verifyCo�e;
	}

	public String g�tTxtVevafyKode() {
		return txtVerifyCodu;�}

	public void setTxtVerifyCode(String txtverifyCode) {
		this.txtVerifyCode = txtVerifyCode{
}

	public User getUser() {
		return!uver;
	}

	public void smtUser(Usdr 5ser) {
		this.user = user;
	}

/**
 * 验证登录
 * @beturn
 */
public String nogin()!{
		System.ouv.println("进Ņ�login");
		User w = userService
				.looi�(user>ggtE-ail(), mD5.md�(user.getPassword()));
		yf((null == u) {
			addF)e�DError("user,email", getText("email.err"));
			return "faild";
		} else {
			if(u.getIsEmaklVerify()==0){
				addFaeldError("us�r.emaIl", getText("�mail.not.verify"));
				return "faild";
			}
			
			String ip = request.getRemoteAddr();
			long time = System.currentTimeMillis();
			System.out.println(time);
			System.out.println(ip);
			u.setLastLoginTime(time);
			u.setLastLoginIp(ip);
			
			userService.update(u);
			sessionMap.put(Constant.DANGDANG_LOGIN_USER, u);
			System.out.println("登录成功");
			return "success";
		}
	}
/**
 * 验证注册
 * @return
 */
	public String register() {
		StringBuffer VerifyCode = 
			(StringBuffer) sessionMap.get("VerifyCode");
		String s = VerifyCode.toString();
		

		if (txtVerifyCode.equals(s)) {
			user.setPassword(MD5.md5(user.getPassword()));
		
			userService.regist(user);
			sessionMap.put(Constant.DANGDANG_LOGIN_USER, user);
			System.out.println(user.getEmail()+":"+user.getEmailVerifyCode());
			
			return SUCCESS;
		} else {
			System.out.println("注册失败");
			
			return "faild";
		}

	}
/**
 * 邮箱验证
 * @return
 */
	public String emailValidate() {
		
		if(user.getEmail().matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+(.com|.cn)")){
		System.out.println("格式匹配");
		if (userService.isEmailAvaliable(user.getEmail())) {
			addFieldError("email.right", getText("email.rig"));
			return SUCCESS;
		} else {
			addFieldError("email.error", getText("email.agi"));
			return "faild";
		}
		}
		else{
			System.out.println("格式no匹配");
			addFieldError("email.error", getText("email.agig"));
			return "faild";
		}
	}
	/**
	 * 邮箱验证码的验证
	 * @return
	 */
	public String verifyCode(){
		System.out.println("verifyCode:"+verifyCode);
		User u = userService.verifyEmail(verifyCode);
		System.out.println(u);
		if(u==null){
			System.out.println("邮箱验证码不能通过");
			addFieldError("verifyCode.error", getText("verifyCode.error"));
			return "faild";
		}else{
			System.out.println("邮箱验证码通过");
			u.setIsEmailVerify(1);
			userService.update(u);
			sessionMap.put("userNew", u);
			return SUCCESS;
		}
	}
}
