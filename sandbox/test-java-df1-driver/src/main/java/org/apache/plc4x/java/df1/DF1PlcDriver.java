/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.plc4x.java.df1;

import org.apache.plc4x.java.spi.configuration.PlcConnectionConfiguration;
import org.apache.plc4x.java.df1.configuration.Df1Configuration;
import org.apache.plc4x.java.df1.field.Df1TagHandler;
import org.apache.plc4x.java.df1.protocol.Df1ProtocolLogic;
import org.apache.plc4x.java.df1.readwrite.DF1Command;
import org.apache.plc4x.java.spi.connection.GeneratedDriverBase;
import org.apache.plc4x.java.spi.connection.ProtocolStackConfigurer;
import org.apache.plc4x.java.spi.connection.SingleProtocolStackConfigurer;
import org.apache.plc4x.java.spi.values.PlcValueHandler;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DF1PlcDriver extends GeneratedDriverBase<DF1Command> {

    @Override
    public String getProtocolCode() {
        return "df1";
    }

    @Override
    public String getProtocolName() {
        return "Allen-Bradley DF1";
    }

    @Override
    protected Class<? extends PlcConnectionConfiguration> getConfigurationClass() {
        return Df1Configuration.class;
    }

    @Override
    protected Optional<String> getDefaultTransportCode() {
        return Optional.of("serial");
    }

    @Override
    protected List<String> getSupportedTransportCodes() {
        return Collections.singletonList("serial");
    }

    @Override
    protected Df1TagHandler getTagHandler() {
        return new Df1TagHandler();
    }

    @Override
    protected org.apache.plc4x.java.api.value.PlcValueHandler getValueHandler() {
        return new PlcValueHandler();
    }

    @Override
    protected ProtocolStackConfigurer<DF1Command> getStackConfigurer() {
        return SingleProtocolStackConfigurer.builder(DF1Command.class, DF1Command::staticParse)
            .withProtocol(Df1ProtocolLogic.class)
            .build();
    }

}
