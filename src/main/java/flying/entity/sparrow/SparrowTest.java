package flying.entity.sparrow;

import com.baomidou.mybatisplus.enums.IdType;

import flying.entity.SuperEntity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fallen
 * @since 2017-09-10
 */
@TableName("sparrow_test")
public class SparrowTest extends SuperEntity<SparrowTest> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String name;
	private Integer type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
		return "SparrowTest{" +
			"id=" + id +
			", name=" + name +
			", type=" + type +
			", createdAt=" + createdAt +
			", updateAt=" + updateAt +
			", deleteFlag=" + deleteFlag +
			", deleteAt=" + deleteAt +
			"}";
	}
}
