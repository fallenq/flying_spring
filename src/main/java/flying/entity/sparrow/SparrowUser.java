package flying.entity.sparrow;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户基本信息
 * </p>
 *
 * @author Fallen
 * @since 2017-09-10
 */
@TableName("sparrow_user")
public class SparrowUser extends Model<SparrowUser> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	/**
	 * 用户类型 1-手机 2-第三方登录
	 */
	@TableField("user_type")
	private Integer userType;
	/**
	 * 用户昵称
	 */
	private String nickname;
	/**
	 * 用户头像
	 */
	private String face;
	/**
	 * 用户手机ID
	 */
	@TableField("user_mobile_id")
	private Integer userMobileId;
	/**
	 * 用户密码code
	 */
	private String salt;
	/**
	 * 登录密码
	 */
	@TableField("login_pwd")
	private String loginPwd;
	/**
	 * 用户设备ID
	 */
	@TableField("user_device_id")
	private Integer userDeviceId;
	/**
	 * 状态
	 */
	private Integer status;
//	@TableField(value = "created_at", fill = FieldFill.INSERT)
	@TableField("created_at")
	private Date createdAt;
//	@TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
	@TableField("update_at")
	private Date updateAt;
	@TableField("delete_flag")
	@TableLogic
	private Integer deleteFlag;
	@TableField("delete_at")
	private Date deleteAt;
	/**
	 * 最后登录时间
	 */
	@TableField("last_login_at")
	private Date lastLoginAt;
	/**
	 * 关联用户电话对象
	 */
	@TableField(exist = false)
	private SparrowUserMobile userMobile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public Integer getUserMobileId() {
		return userMobileId;
	}

	public void setUserMobileId(Integer userMobileId) {
		this.userMobileId = userMobileId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public Integer getUserDeviceId() {
		return userDeviceId;
	}

	public void setUserDeviceId(Integer userDeviceId) {
		this.userDeviceId = userDeviceId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getDeleteAt() {
		return deleteAt;
	}

	public void setDeleteAt(Date deleteAt) {
		this.deleteAt = deleteAt;
	}

	public Date getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public SparrowUserMobile getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(SparrowUserMobile userMobile) {
		this.userMobile = userMobile;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SparrowUser{" + "id=" + id + ", userType=" + userType + ", nickname=" + nickname + ", userMobileId="
				+ userMobileId + ", salt=" + salt + ", loginPwd=" + loginPwd + ", userDeviceId=" + userDeviceId
				+ ", status=" + status + ", createdAt=" + createdAt + ", updateAt=" + updateAt + ", deleteFlag="
				+ deleteFlag + ", deleteAt=" + deleteAt + ", lastLoginAt=" + lastLoginAt + "}";
	}
}
