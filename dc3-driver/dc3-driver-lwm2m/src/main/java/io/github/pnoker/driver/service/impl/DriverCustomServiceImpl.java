/*
 * Copyright 2016-present the IoT DC3 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.pnoker.driver.service.impl;

import com.mchange.v2.lang.StringUtils;
import io.github.pnoker.common.driver.entity.bean.RValue;
import io.github.pnoker.common.driver.entity.bean.WValue;
import io.github.pnoker.common.driver.entity.bo.AttributeBO;
import io.github.pnoker.common.driver.entity.bo.DeviceBO;
import io.github.pnoker.common.driver.entity.bo.MetadataEventBO;
import io.github.pnoker.common.driver.entity.bo.PointBO;
import io.github.pnoker.common.driver.metadata.DriverMetadata;
import io.github.pnoker.common.driver.service.DriverCustomService;
import io.github.pnoker.common.driver.service.DriverSenderService;
import io.github.pnoker.common.entity.base.BaseBO;
import io.github.pnoker.common.enums.DeviceStatusEnum;
import io.github.pnoker.common.enums.MetadataTypeEnum;
import io.github.pnoker.driver.server.Lwm2mServer;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author xwh1998
 */
@Slf4j
@Service
public class DriverCustomServiceImpl implements DriverCustomService {

    @Resource
    DriverMetadata driverMetadata;

    @Resource
    private Lwm2mServer lwm2mServer;
    @Resource
    private DriverSenderService driverSenderService;

    @Override
    public void initial() {
        /*
        !!! 提示: 此处逻辑仅供参考, 请务必结合实际应用场景。!!!
        你可以在此处执行一些特定的初始化逻辑, 驱动在启动的时候会自动执行该方法。
        */
        lwm2mServer.startServer();
    }

    @Override
    public void schedule() {
        /*
        !!! 提示: 此处逻辑仅供参考, 请务必结合实际应用场景。!!!
        上传设备状态, 可自行灵活拓展, 不一定非要在schedule()接口中实现, 你可以: 
        - 在read中实现设备状态的判断；
        - 在自定义定时任务中实现设备状态的判断；
        - 根据某种判断机制实现设备状态的判断。

        最后根据 driverSenderService.deviceStatusSender(deviceId,deviceStatus) 接口将设备状态交给SDK管理, 其中设备状态(StatusEnum):
        - ONLINE:在线
        - OFFLINE:离线
        - MAINTAIN:维护
        - FAULT:故障
         */
        driverMetadata.getDeviceIds().forEach(id -> driverSenderService.deviceStatusSender(id, DeviceStatusEnum.ONLINE, 25, TimeUnit.SECONDS));
    }

    @Override
    public void event(MetadataEventBO<? extends BaseBO> metadataEvent) {
        /*
        !!! 提示: 此处逻辑仅供参考, 请务必结合实际应用场景。!!!
        接收驱动, 设备, 位号元数据新增, 更新, 删除都会触发改事件
        提供元数据类型: MetadataTypeEnum(DRIVER, DEVICE, POINT)
        提供元数据操作类型: MetadataOperateTypeEnum(ADD, DELETE, UPDATE)
         */
        MetadataTypeEnum metadataType = metadataEvent.getMetadataType();
        switch (metadataType) {
            case DRIVER -> {
                // to do something for driver event
            }
            case DEVICE -> {
                // to do something for device event
            }
            case POINT -> {
                // to do something for point event
            }
            default -> log.warn("There is no event of this metadata: {}", metadataEvent);
        }
    }

    @Override
    public RValue read(Map<String, AttributeBO> driverConfig, Map<String, AttributeBO> pointConfig, DeviceBO device, PointBO point) {
        /*
        !!! 提示: 此处逻辑仅供参考, 请务必结合实际应用场景。!!!

        可以主动读取,也可以订阅资源
         */
        String value = lwm2mServer.readValueByPath(String.valueOf(device.getId()), pointConfig.get("messageUp").getValue(String.class));
        return new RValue(device, point, value);
    }

    @Override
    public Boolean write(Map<String, AttributeBO> driverConfig, Map<String, AttributeBO> pointConfig, DeviceBO device, PointBO point, WValue wValue) {
        /*
        !!! 提示: 此处逻辑仅供参考, 请务必结合实际应用场景。!!!
         */
        String execDownValue = pointConfig.get("execDown").getValue(String.class);
        if (StringUtils.nonEmptyString(execDownValue)) {
            //执行函数
            return lwm2mServer.execute(String.valueOf(device.getId()), execDownValue, wValue.getValue());
        }
        String messageDownValue = pointConfig.get("messageDown").getValue(String.class);
        return lwm2mServer.writeValueByPath(String.valueOf(device.getId()), messageDownValue, wValue.getValue(), false);
    }
}
