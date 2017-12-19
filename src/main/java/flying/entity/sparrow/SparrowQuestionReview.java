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
 * 问题反馈
 * </p>
 *
 * @author Fallen
 * @since 2017-09-10
 */
@TableName("sparrow_question_review")
public class SparrowQuestionReview extends Model<SparrowQuestionReview> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户ID
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 问题类型
     */
	@TableField("question_type")
	private Integer questionType;
    /**
     * 反馈问题内容
     */
	private String content;
    /**
     * 问题ID
     */
	@TableField("reason_id")
	private Integer reasonId;
    /**
     * 其他问题
     */
	@TableField("reason_other")
	private String reasonOther;
    /**
     * 员工ID
     */
	@TableField("operator_id")
	private Integer operatorId;
    /**
     * 反馈方式
     */
	@TableField("operate_method")
	private Integer operateMethod;
    /**
     * 状态 0-未处理 1-已反馈
     */
	private Integer status;
    /**
     * 处理时间
     */
	@TableField("operate_at")
	private Date operateAt;
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

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReasonId() {
		return reasonId;
	}

	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}

	public String getReasonOther() {
		return reasonOther;
	}

	public void setReasonOther(String reasonOther) {
		this.reasonOther = reasonOther;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getOperateMethod() {
		return operateMethod;
	}

	public void setOperateMethod(Integer operateMethod) {
		this.operateMethod = operateMethod;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getOperateAt() {
		return operateAt;
	}

	public void setOperateAt(Date operateAt) {
		this.operateAt = operateAt;
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
		return "SparrowQuestionReview{" +
			"id=" + id +
			", userId=" + userId +
			", questionType=" + questionType +
			", content=" + content +
			", reasonId=" + reasonId +
			", reasonOther=" + reasonOther +
			", operatorId=" + operatorId +
			", operateMethod=" + operateMethod +
			", status=" + status +
			", operateAt=" + operateAt +
			", createdAt=" + createdAt +
			", updateAt=" + updateAt +
			", deleteFlag=" + deleteFlag +
			", deleteAt=" + deleteAt +
			"}";
	}
}
