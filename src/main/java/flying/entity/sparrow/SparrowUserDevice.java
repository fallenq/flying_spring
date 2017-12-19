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
 * 用户设备
 * </p>
 *
 * @author Fallen
 * @since 2017-09-10
 */
@TableName("sparrow_user_device")
public class SparrowUserDevice extends Model<SparrowUserDevice> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户ID
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 设备类型
     */
	@TableField("device_type")
	private Integer deviceType;
    /**
     * 设备号
     */
	private String imei;
	@TableField("android_api")
	private String androidApi;
	@TableField("created_at")
	private Date createdAt;
	@TableField("update_at")
	private Date updateAt;
	@TableField("delete_flag")
	@TableLogic
	private Integer deleteFlag;
	@TableField("delete_at")
	private Date deleteAt;


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

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getAndroidApi() {
		return androidApi;
	}

	public void setAndroidApi(String androidApi) {
		this.androidApi = androidApi;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SparrowUserDevice{" +
			"id=" + id +
			", userId=" + userId +
			", deviceType=" + deviceType +
			", imei=" + imei +
			", androidApi=" + androidApi +
			", createdAt=" + createdAt +
			", updateAt=" + updateAt +
			", deleteFlag=" + deleteFlag +
			", deleteAt=" + deleteAt +
			"}";
	}
}
