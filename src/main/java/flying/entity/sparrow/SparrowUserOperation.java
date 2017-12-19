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
 * 用户操作记录
 * </p>
 *
 * @author Fallen
 * @since 2017-09-10
 */
@TableName("sparrow_user_operation")
public class SparrowUserOperation extends Model<SparrowUserOperation> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户ID
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 操作定位ID
     */
	@TableField("location_id")
	private Integer locationId;
    /**
     * 操作类型ID
     */
	@TableField("operate_type")
	private Integer operateType;
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

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
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
		return "SparrowUserOperation{" +
			"id=" + id +
			", userId=" + userId +
			", locationId=" + locationId +
			", operateType=" + operateType +
			", createdAt=" + createdAt +
			", updateAt=" + updateAt +
			", deleteFlag=" + deleteFlag +
			", deleteAt=" + deleteAt +
			"}";
	}
}
