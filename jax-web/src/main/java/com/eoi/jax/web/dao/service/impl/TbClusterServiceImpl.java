/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.eoi.jax.web.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eoi.jax.web.dao.entity.TbCluster;
import com.eoi.jax.web.dao.mapper.TbClusterMapper;
import com.eoi.jax.web.dao.service.TbClusterService;
import org.springframework.stereotype.Service;

@Service
public class TbClusterServiceImpl extends ServiceImpl<TbClusterMapper, TbCluster> implements TbClusterService {

    @Override
    public TbCluster getDefaultFlinkCluster() {
        return list(
                new LambdaQueryWrapper<TbCluster>()
                        .eq(TbCluster::getDefaultFlinkCluster, true)
                        .orderByDesc(TbCluster::getUpdateTime)
        ).stream().findFirst().orElse(null);
    }

    @Override
    public TbCluster getDefaultSparkCluster() {
        return list(
                new LambdaQueryWrapper<TbCluster>()
                        .eq(TbCluster::getDefaultSparkCluster, true)
                        .orderByDesc(TbCluster::getUpdateTime)
        ).stream().findFirst().orElse(null);
    }
}