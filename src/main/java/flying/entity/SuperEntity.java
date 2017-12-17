package flying.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;

@SuppressWarnings("serial")
public class SuperEntity<T extends Model<?>> extends Model<T> {

	@Override
	protected Serializable pkVal() {
		return null;
	}

}
