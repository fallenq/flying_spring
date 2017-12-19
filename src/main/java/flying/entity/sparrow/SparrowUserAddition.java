package flying.entity.sparrow;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户附属信息
 * </p>
 *
 * @author Fallen
 * @since 2017-09-10
 */
@TableName("sparrow_user_addition")
public class SparrowUserAddition extends Model<SparrowUserAddition> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户ID
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 家庭住址
     */
	@TableField("home_address")
	private String homeAddress;
    /**
     * 工作地址
     */
	@TableField("work_address")
	private String workAddress;
    /**
     * 注册地址
     */
	@TableField("register_address")
	private String registerAddress;
    /**
     * ip地址
     */
	private String ip;
    /**
     * 注册定位ID
     */
	@TableField("location_id")
	private Integer locationId;
    /**
     * 最后登录IP
     */
	@TableField("last_login_ip")
	private String lastLoginIp;
    /**
     * 最后登录定位ID
     */
	@TableField("last_location_id")
	private BigDecimal lastLocationId;
    /**
     * 封号备注
     */
	@TableField("lock_remark")
	private String lockRemark;
	@TableField("created_at")
	private Date createdAt;
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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public BigDecimal getLastLocationId() {
		return lastLocationId;
	}

	public void setLastLocationId(BigDecimal lastLocationId) {
		this.lastLocationId = lastLocationId;
	}

	public String getLockRemark() {
		return lockRemark;
	}

	public void setLockRemark(String lockRemark) {
		this.lockRemark = lockRemark;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SparrowUserAddition{" +
			"id=" + id +
			", userId=" + userId +
			", homeAddress=" + homeAddress +
			", workAddress=" + workAddress +
			", registerAddress=" + registerAddress +
			", ip=" + ip +
			", locationId=" + locationId +
			", lastLoginIp=" + lastLoginIp +
			", lastLocationId=" + lastLocationId +
			", lockRemark=" + lockRemark +
			", createdAt=" + createdAt +
			", updateAt=" + updateAt +
			", deleteFlag=" + deleteFlag +
			", deleteAt=" + deleteAt +
			", lastLoginAt=" + lastLoginAt +
			"}";
	}
}
