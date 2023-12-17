package io.github.pnoker.center.manager.entity.model;

import com.baomidou.mybatisplus.annotation.*;
import io.github.pnoker.common.constant.enums.EntityTypeFlagEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 标签关联表
 * </p>
 *
 * @author pnoker
 * @since 2022.1.0
 */
@Getter
@Setter
@TableName("dc3_label_bind")
public class LabelBindDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 实体类型标识
     */
    @TableField("entity_type_flag")
    private EntityTypeFlagEnum entityTypeFlag;

    /**
     * 标签ID
     */
    @TableField("label_id")
    private Long labelId;

    /**
     * 实体ID
     */
    @TableField("entity_id")
    private Long entityId;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private Long tenantId;

    /**
     * 描述
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建者ID
     */
    @TableField("creator_id")
    private Long creatorId;

    /**
     * 创建者名称
     */
    @TableField("creator_name")
    private String creatorName;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 操作者ID
     */
    @TableField("operator_id")
    private Long operatorId;

    /**
     * 操作者名称
     */
    @TableField("operator_name")
    private String operatorName;

    /**
     * 操作时间
     */
    @TableField("operate_time")
    private LocalDateTime operateTime;

    /**
     * 逻辑删除标识,0:未删除,1:已删除
     */
    @TableLogic
    @TableField(value = "deleted")
    private Byte deleted;
}
