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
package org.apache.plc4x.java.opcua.readwrite;

import static org.apache.plc4x.java.spi.codegen.fields.FieldReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.fields.FieldWriterFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataWriterFactory.*;
import static org.apache.plc4x.java.spi.generation.StaticHelper.*;

import java.time.*;
import java.util.*;
import org.apache.plc4x.java.api.exceptions.*;
import org.apache.plc4x.java.api.value.*;
import org.apache.plc4x.java.spi.codegen.*;
import org.apache.plc4x.java.spi.codegen.fields.*;
import org.apache.plc4x.java.spi.codegen.io.*;
import org.apache.plc4x.java.spi.generation.*;

// Code generated by code-generation. DO NOT EDIT.

public class MonitoredItemCreateRequest extends ExtensionObjectDefinition implements Message {

  // Accessors for discriminator values.
  public String getIdentifier() {
    return (String) "745";
  }

  // Properties.
  protected final ExtensionObjectDefinition itemToMonitor;
  protected final MonitoringMode monitoringMode;
  protected final ExtensionObjectDefinition requestedParameters;

  public MonitoredItemCreateRequest(
      ExtensionObjectDefinition itemToMonitor,
      MonitoringMode monitoringMode,
      ExtensionObjectDefinition requestedParameters) {
    super();
    this.itemToMonitor = itemToMonitor;
    this.monitoringMode = monitoringMode;
    this.requestedParameters = requestedParameters;
  }

  public ExtensionObjectDefinition getItemToMonitor() {
    return itemToMonitor;
  }

  public MonitoringMode getMonitoringMode() {
    return monitoringMode;
  }

  public ExtensionObjectDefinition getRequestedParameters() {
    return requestedParameters;
  }

  @Override
  protected void serializeExtensionObjectDefinitionChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("MonitoredItemCreateRequest");

    // Simple Field (itemToMonitor)
    writeSimpleField("itemToMonitor", itemToMonitor, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (monitoringMode)
    writeSimpleEnumField(
        "monitoringMode",
        "MonitoringMode",
        monitoringMode,
        new DataWriterEnumDefault<>(
            MonitoringMode::getValue, MonitoringMode::name, writeUnsignedLong(writeBuffer, 32)));

    // Simple Field (requestedParameters)
    writeSimpleField(
        "requestedParameters", requestedParameters, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("MonitoredItemCreateRequest");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    MonitoredItemCreateRequest _value = this;

    // Simple field (itemToMonitor)
    lengthInBits += itemToMonitor.getLengthInBits();

    // Simple field (monitoringMode)
    lengthInBits += 32;

    // Simple field (requestedParameters)
    lengthInBits += requestedParameters.getLengthInBits();

    return lengthInBits;
  }

  public static ExtensionObjectDefinitionBuilder staticParseExtensionObjectDefinitionBuilder(
      ReadBuffer readBuffer, String identifier) throws ParseException {
    readBuffer.pullContext("MonitoredItemCreateRequest");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    ExtensionObjectDefinition itemToMonitor =
        readSimpleField(
            "itemToMonitor",
            new DataReaderComplexDefault<>(
                () -> ExtensionObjectDefinition.staticParse(readBuffer, (String) ("628")),
                readBuffer));

    MonitoringMode monitoringMode =
        readEnumField(
            "monitoringMode",
            "MonitoringMode",
            new DataReaderEnumDefault<>(
                MonitoringMode::enumForValue, readUnsignedLong(readBuffer, 32)));

    ExtensionObjectDefinition requestedParameters =
        readSimpleField(
            "requestedParameters",
            new DataReaderComplexDefault<>(
                () -> ExtensionObjectDefinition.staticParse(readBuffer, (String) ("742")),
                readBuffer));

    readBuffer.closeContext("MonitoredItemCreateRequest");
    // Create the instance
    return new MonitoredItemCreateRequestBuilderImpl(
        itemToMonitor, monitoringMode, requestedParameters);
  }

  public static class MonitoredItemCreateRequestBuilderImpl
      implements ExtensionObjectDefinition.ExtensionObjectDefinitionBuilder {
    private final ExtensionObjectDefinition itemToMonitor;
    private final MonitoringMode monitoringMode;
    private final ExtensionObjectDefinition requestedParameters;

    public MonitoredItemCreateRequestBuilderImpl(
        ExtensionObjectDefinition itemToMonitor,
        MonitoringMode monitoringMode,
        ExtensionObjectDefinition requestedParameters) {
      this.itemToMonitor = itemToMonitor;
      this.monitoringMode = monitoringMode;
      this.requestedParameters = requestedParameters;
    }

    public MonitoredItemCreateRequest build() {
      MonitoredItemCreateRequest monitoredItemCreateRequest =
          new MonitoredItemCreateRequest(itemToMonitor, monitoringMode, requestedParameters);
      return monitoredItemCreateRequest;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MonitoredItemCreateRequest)) {
      return false;
    }
    MonitoredItemCreateRequest that = (MonitoredItemCreateRequest) o;
    return (getItemToMonitor() == that.getItemToMonitor())
        && (getMonitoringMode() == that.getMonitoringMode())
        && (getRequestedParameters() == that.getRequestedParameters())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(), getItemToMonitor(), getMonitoringMode(), getRequestedParameters());
  }

  @Override
  public String toString() {
    WriteBufferBoxBased writeBufferBoxBased = new WriteBufferBoxBased(true, true);
    try {
      writeBufferBoxBased.writeSerializable(this);
    } catch (SerializationException e) {
      throw new RuntimeException(e);
    }
    return "\n" + writeBufferBoxBased.getBox().toString() + "\n";
  }
}
