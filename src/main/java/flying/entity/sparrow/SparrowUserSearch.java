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
 * 搜索记录
 * </p>
 *
 * @author Fallen
 * @since 2017-09-10
 */
@TableName("sparrow_user_search")
public class SparrowUserSearch extends Model<SparrowUserSearch> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户ID
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 搜索引擎类型
     */
	private Integer type;
    /**
     * 内容类型ID
     */
	@TableField("content_class_id")
	private Integer contentClassId;
    /**
     * 搜索内容
     */
	private String content;
    /**
     * 搜索定位ID
     */
	@TableField("location_id")
	private Integer locationId;
	private String ip;
    /**
     * 分享ID
     */
	@TableField("share_id")
	private Integer shareId;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getContentClassId() {
		return contentClassId;
	}

	public void setContentClassId(Integer contentClassId) {
		this.contentClassId = contentClassId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getShareId() {
		return shareId;
	}

	public void setShareId(Integer shareId) {
		this.shareId = shareId;
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
		return "SparrowUserSearch{" +
			"id=" + id +
			", userId=" + userId +
			", type=" + type +
			", contentClassId=" + contentClassId +
			", content=" + content +
			", locationId=" + locationId +
			", ip=" + ip +
			", shareId=" + shareId +
			", createdAt=" + createdAt +
			", updateAt=" + updateAt +
			", deleteFlag=" + deleteFlag +
			", deleteAt=" + deleteAt +
			"}";
	}
}
