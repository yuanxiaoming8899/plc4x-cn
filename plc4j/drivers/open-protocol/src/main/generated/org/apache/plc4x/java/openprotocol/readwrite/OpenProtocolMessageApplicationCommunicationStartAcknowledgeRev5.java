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
package org.apache.plc4x.java.openprotocol.readwrite;

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

public class OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5
    extends OpenProtocolMessageApplicationCommunicationStartAcknowledge implements Message {

  // Accessors for discriminator values.
  public Long getRevision() {
    return (long) 5;
  }

  // Constant values.
  public static final Integer BLOCKIDCELLID = 1;
  public static final Integer BLOCKIDCHANNELID = 2;
  public static final Integer BLOCKIDCONTROLLERNAME = 3;
  public static final Integer BLOCKIDSUPPLIERCODE = 4;
  public static final Integer BLOCKIDOPENPROTOCOLVERSION = 5;
  public static final Integer BLOCKIDCONTROLLERSOFTWAREVERSION = 6;
  public static final Integer BLOCKIDTOOLSOFTWAREVERSION = 7;
  public static final Integer BLOCKIDRBUTYPE = 8;
  public static final Integer BLOCKIDCONTROLLERSERIALNUMBER = 9;
  public static final Integer BLOCKIDSYSTEMTYPE = 10;
  public static final Integer BLOCKIDSYSTEMSUBTYPE = 11;

  // Properties.
  protected final long cellId;
  protected final int channelId;
  protected final String controllerName;
  protected final long supplierCode;
  protected final String openProtocolVersion;
  protected final String controllerSoftwareVersion;
  protected final String toolSoftwareVersion;
  protected final String rbuType;
  protected final String controllerSerialNumber;
  protected final String systemType;
  protected final String systemSubtype;

  public OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5(
      Long midRevision,
      Short noAckFlag,
      Integer targetStationId,
      Integer targetSpindleId,
      Integer sequenceNumber,
      Short numberOfMessageParts,
      Short messagePartNumber,
      long cellId,
      int channelId,
      String controllerName,
      long supplierCode,
      String openProtocolVersion,
      String controllerSoftwareVersion,
      String toolSoftwareVersion,
      String rbuType,
      String controllerSerialNumber,
      String systemType,
      String systemSubtype) {
    super(
        midRevision,
        noAckFlag,
        targetStationId,
        targetSpindleId,
        sequenceNumber,
        numberOfMessageParts,
        messagePartNumber);
    this.cellId = cellId;
    this.channelId = channelId;
    this.controllerName = controllerName;
    this.supplierCode = supplierCode;
    this.openProtocolVersion = openProtocolVersion;
    this.controllerSoftwareVersion = controllerSoftwareVersion;
    this.toolSoftwareVersion = toolSoftwareVersion;
    this.rbuType = rbuType;
    this.controllerSerialNumber = controllerSerialNumber;
    this.systemType = systemType;
    this.systemSubtype = systemSubtype;
  }

  public long getCellId() {
    return cellId;
  }

  public int getChannelId() {
    return channelId;
  }

  public String getControllerName() {
    return controllerName;
  }

  public long getSupplierCode() {
    return supplierCode;
  }

  public String getOpenProtocolVersion() {
    return openProtocolVersion;
  }

  public String getControllerSoftwareVersion() {
    return controllerSoftwareVersion;
  }

  public String getToolSoftwareVersion() {
    return toolSoftwareVersion;
  }

  public String getRbuType() {
    return rbuType;
  }

  public String getControllerSerialNumber() {
    return controllerSerialNumber;
  }

  public String getSystemType() {
    return systemType;
  }

  public String getSystemSubtype() {
    return systemSubtype;
  }

  public int getBlockIdCellId() {
    return BLOCKIDCELLID;
  }

  public int getBlockIdChannelId() {
    return BLOCKIDCHANNELID;
  }

  public int getBlockIdControllerName() {
    return BLOCKIDCONTROLLERNAME;
  }

  public int getBlockIdSupplierCode() {
    return BLOCKIDSUPPLIERCODE;
  }

  public int getBlockIdOpenProtocolVersion() {
    return BLOCKIDOPENPROTOCOLVERSION;
  }

  public int getBlockIdControllerSoftwareVersion() {
    return BLOCKIDCONTROLLERSOFTWAREVERSION;
  }

  public int getBlockIdToolSoftwareVersion() {
    return BLOCKIDTOOLSOFTWAREVERSION;
  }

  public int getBlockIdRbuType() {
    return BLOCKIDRBUTYPE;
  }

  public int getBlockIdControllerSerialNumber() {
    return BLOCKIDCONTROLLERSERIALNUMBER;
  }

  public int getBlockIdSystemType() {
    return BLOCKIDSYSTEMTYPE;
  }

  public int getBlockIdSystemSubtype() {
    return BLOCKIDSYSTEMSUBTYPE;
  }

  @Override
  protected void serializeOpenProtocolMessageApplicationCommunicationStartAcknowledgeChild(
      WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5");

    // Const Field (blockIdCellId)
    writeConstField(
        "blockIdCellId",
        BLOCKIDCELLID,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (cellId)
    writeSimpleField(
        "cellId", cellId, writeUnsignedLong(writeBuffer, 32), WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdChannelId)
    writeConstField(
        "blockIdChannelId",
        BLOCKIDCHANNELID,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (channelId)
    writeSimpleField(
        "channelId",
        channelId,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdControllerName)
    writeConstField(
        "blockIdControllerName",
        BLOCKIDCONTROLLERNAME,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (controllerName)
    writeSimpleField(
        "controllerName",
        controllerName,
        writeString(writeBuffer, 200),
        WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdSupplierCode)
    writeConstField(
        "blockIdSupplierCode",
        BLOCKIDSUPPLIERCODE,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (supplierCode)
    writeSimpleField(
        "supplierCode",
        supplierCode,
        writeUnsignedLong(writeBuffer, 24),
        WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdOpenProtocolVersion)
    writeConstField(
        "blockIdOpenProtocolVersion",
        BLOCKIDOPENPROTOCOLVERSION,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (openProtocolVersion)
    writeSimpleField(
        "openProtocolVersion",
        openProtocolVersion,
        writeString(writeBuffer, 152),
        WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdControllerSoftwareVersion)
    writeConstField(
        "blockIdControllerSoftwareVersion",
        BLOCKIDCONTROLLERSOFTWAREVERSION,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (controllerSoftwareVersion)
    writeSimpleField(
        "controllerSoftwareVersion",
        controllerSoftwareVersion,
        writeString(writeBuffer, 152),
        WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdToolSoftwareVersion)
    writeConstField(
        "blockIdToolSoftwareVersion",
        BLOCKIDTOOLSOFTWAREVERSION,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (toolSoftwareVersion)
    writeSimpleField(
        "toolSoftwareVersion",
        toolSoftwareVersion,
        writeString(writeBuffer, 152),
        WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdRbuType)
    writeConstField(
        "blockIdRbuType",
        BLOCKIDRBUTYPE,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (rbuType)
    writeSimpleField(
        "rbuType", rbuType, writeString(writeBuffer, 192), WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdControllerSerialNumber)
    writeConstField(
        "blockIdControllerSerialNumber",
        BLOCKIDCONTROLLERSERIALNUMBER,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (controllerSerialNumber)
    writeSimpleField(
        "controllerSerialNumber",
        controllerSerialNumber,
        writeString(writeBuffer, 80),
        WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdSystemType)
    writeConstField(
        "blockIdSystemType",
        BLOCKIDSYSTEMTYPE,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (systemType)
    writeSimpleField(
        "systemType", systemType, writeString(writeBuffer, 24), WithOption.WithEncoding("ASCII"));

    // Const Field (blockIdSystemSubtype)
    writeConstField(
        "blockIdSystemSubtype",
        BLOCKIDSYSTEMSUBTYPE,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (systemSubtype)
    writeSimpleField(
        "systemSubtype",
        systemSubtype,
        writeString(writeBuffer, 24),
        WithOption.WithEncoding("ASCII"));

    writeBuffer.popContext("OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5 _value = this;

    // Const Field (blockIdCellId)
    lengthInBits += 16;

    // Simple field (cellId)
    lengthInBits += 32;

    // Const Field (blockIdChannelId)
    lengthInBits += 16;

    // Simple field (channelId)
    lengthInBits += 16;

    // Const Field (blockIdControllerName)
    lengthInBits += 16;

    // Simple field (controllerName)
    lengthInBits += 200;

    // Const Field (blockIdSupplierCode)
    lengthInBits += 16;

    // Simple field (supplierCode)
    lengthInBits += 24;

    // Const Field (blockIdOpenProtocolVersion)
    lengthInBits += 16;

    // Simple field (openProtocolVersion)
    lengthInBits += 152;

    // Const Field (blockIdControllerSoftwareVersion)
    lengthInBits += 16;

    // Simple field (controllerSoftwareVersion)
    lengthInBits += 152;

    // Const Field (blockIdToolSoftwareVersion)
    lengthInBits += 16;

    // Simple field (toolSoftwareVersion)
    lengthInBits += 152;

    // Const Field (blockIdRbuType)
    lengthInBits += 16;

    // Simple field (rbuType)
    lengthInBits += 192;

    // Const Field (blockIdControllerSerialNumber)
    lengthInBits += 16;

    // Simple field (controllerSerialNumber)
    lengthInBits += 80;

    // Const Field (blockIdSystemType)
    lengthInBits += 16;

    // Simple field (systemType)
    lengthInBits += 24;

    // Const Field (blockIdSystemSubtype)
    lengthInBits += 16;

    // Simple field (systemSubtype)
    lengthInBits += 24;

    return lengthInBits;
  }

  public static OpenProtocolMessageApplicationCommunicationStartAcknowledgeBuilder
      staticParseOpenProtocolMessageApplicationCommunicationStartAcknowledgeBuilder(
          ReadBuffer readBuffer, Long revision) throws ParseException {
    readBuffer.pullContext("OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    int blockIdCellId =
        readConstField(
            "blockIdCellId",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5.BLOCKIDCELLID,
            WithOption.WithEncoding("ASCII"));

    long cellId =
        readSimpleField(
            "cellId", readUnsignedLong(readBuffer, 32), WithOption.WithEncoding("ASCII"));

    int blockIdChannelId =
        readConstField(
            "blockIdChannelId",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5.BLOCKIDCHANNELID,
            WithOption.WithEncoding("ASCII"));

    int channelId =
        readSimpleField(
            "channelId", readUnsignedInt(readBuffer, 16), WithOption.WithEncoding("ASCII"));

    int blockIdControllerName =
        readConstField(
            "blockIdControllerName",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5.BLOCKIDCONTROLLERNAME,
            WithOption.WithEncoding("ASCII"));

    String controllerName =
        readSimpleField(
            "controllerName", readString(readBuffer, 200), WithOption.WithEncoding("ASCII"));

    int blockIdSupplierCode =
        readConstField(
            "blockIdSupplierCode",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5.BLOCKIDSUPPLIERCODE,
            WithOption.WithEncoding("ASCII"));

    long supplierCode =
        readSimpleField(
            "supplierCode", readUnsignedLong(readBuffer, 24), WithOption.WithEncoding("ASCII"));

    int blockIdOpenProtocolVersion =
        readConstField(
            "blockIdOpenProtocolVersion",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5
                .BLOCKIDOPENPROTOCOLVERSION,
            WithOption.WithEncoding("ASCII"));

    String openProtocolVersion =
        readSimpleField(
            "openProtocolVersion", readString(readBuffer, 152), WithOption.WithEncoding("ASCII"));

    int blockIdControllerSoftwareVersion =
        readConstField(
            "blockIdControllerSoftwareVersion",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5
                .BLOCKIDCONTROLLERSOFTWAREVERSION,
            WithOption.WithEncoding("ASCII"));

    String controllerSoftwareVersion =
        readSimpleField(
            "controllerSoftwareVersion",
            readString(readBuffer, 152),
            WithOption.WithEncoding("ASCII"));

    int blockIdToolSoftwareVersion =
        readConstField(
            "blockIdToolSoftwareVersion",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5
                .BLOCKIDTOOLSOFTWAREVERSION,
            WithOption.WithEncoding("ASCII"));

    String toolSoftwareVersion =
        readSimpleField(
            "toolSoftwareVersion", readString(readBuffer, 152), WithOption.WithEncoding("ASCII"));

    int blockIdRbuType =
        readConstField(
            "blockIdRbuType",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5.BLOCKIDRBUTYPE,
            WithOption.WithEncoding("ASCII"));

    String rbuType =
        readSimpleField("rbuType", readString(readBuffer, 192), WithOption.WithEncoding("ASCII"));

    int blockIdControllerSerialNumber =
        readConstField(
            "blockIdControllerSerialNumber",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5
                .BLOCKIDCONTROLLERSERIALNUMBER,
            WithOption.WithEncoding("ASCII"));

    String controllerSerialNumber =
        readSimpleField(
            "controllerSerialNumber", readString(readBuffer, 80), WithOption.WithEncoding("ASCII"));

    int blockIdSystemType =
        readConstField(
            "blockIdSystemType",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5.BLOCKIDSYSTEMTYPE,
            WithOption.WithEncoding("ASCII"));

    String systemType =
        readSimpleField("systemType", readString(readBuffer, 24), WithOption.WithEncoding("ASCII"));

    int blockIdSystemSubtype =
        readConstField(
            "blockIdSystemSubtype",
            readUnsignedInt(readBuffer, 16),
            OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5.BLOCKIDSYSTEMSUBTYPE,
            WithOption.WithEncoding("ASCII"));

    String systemSubtype =
        readSimpleField(
            "systemSubtype", readString(readBuffer, 24), WithOption.WithEncoding("ASCII"));

    readBuffer.closeContext("OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5");
    // Create the instance
    return new OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5BuilderImpl(
        cellId,
        channelId,
        controllerName,
        supplierCode,
        openProtocolVersion,
        controllerSoftwareVersion,
        toolSoftwareVersion,
        rbuType,
        controllerSerialNumber,
        systemType,
        systemSubtype);
  }

  public static class OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5BuilderImpl
      implements OpenProtocolMessageApplicationCommunicationStartAcknowledge
          .OpenProtocolMessageApplicationCommunicationStartAcknowledgeBuilder {
    private final long cellId;
    private final int channelId;
    private final String controllerName;
    private final long supplierCode;
    private final String openProtocolVersion;
    private final String controllerSoftwareVersion;
    private final String toolSoftwareVersion;
    private final String rbuType;
    private final String controllerSerialNumber;
    private final String systemType;
    private final String systemSubtype;

    public OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5BuilderImpl(
        long cellId,
        int channelId,
        String controllerName,
        long supplierCode,
        String openProtocolVersion,
        String controllerSoftwareVersion,
        String toolSoftwareVersion,
        String rbuType,
        String controllerSerialNumber,
        String systemType,
        String systemSubtype) {
      this.cellId = cellId;
      this.channelId = channelId;
      this.controllerName = controllerName;
      this.supplierCode = supplierCode;
      this.openProtocolVersion = openProtocolVersion;
      this.controllerSoftwareVersion = controllerSoftwareVersion;
      this.toolSoftwareVersion = toolSoftwareVersion;
      this.rbuType = rbuType;
      this.controllerSerialNumber = controllerSerialNumber;
      this.systemType = systemType;
      this.systemSubtype = systemSubtype;
    }

    public OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5 build(
        Long midRevision,
        Short noAckFlag,
        Integer targetStationId,
        Integer targetSpindleId,
        Integer sequenceNumber,
        Short numberOfMessageParts,
        Short messagePartNumber) {
      OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5
          openProtocolMessageApplicationCommunicationStartAcknowledgeRev5 =
              new OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5(
                  midRevision,
                  noAckFlag,
                  targetStationId,
                  targetSpindleId,
                  sequenceNumber,
                  numberOfMessageParts,
                  messagePartNumber,
                  cellId,
                  channelId,
                  controllerName,
                  supplierCode,
                  openProtocolVersion,
                  controllerSoftwareVersion,
                  toolSoftwareVersion,
                  rbuType,
                  controllerSerialNumber,
                  systemType,
                  systemSubtype);
      return openProtocolMessageApplicationCommunicationStartAcknowledgeRev5;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5)) {
      return false;
    }
    OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5 that =
        (OpenProtocolMessageApplicationCommunicationStartAcknowledgeRev5) o;
    return (getCellId() == that.getCellId())
        && (getChannelId() == that.getChannelId())
        && (getControllerName() == that.getControllerName())
        && (getSupplierCode() == that.getSupplierCode())
        && (getOpenProtocolVersion() == that.getOpenProtocolVersion())
        && (getControllerSoftwareVersion() == that.getControllerSoftwareVersion())
        && (getToolSoftwareVersion() == that.getToolSoftwareVersion())
        && (getRbuType() == that.getRbuType())
        && (getControllerSerialNumber() == that.getControllerSerialNumber())
        && (getSystemType() == that.getSystemType())
        && (getSystemSubtype() == that.getSystemSubtype())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getCellId(),
        getChannelId(),
        getControllerName(),
        getSupplierCode(),
        getOpenProtocolVersion(),
        getControllerSoftwareVersion(),
        getToolSoftwareVersion(),
        getRbuType(),
        getControllerSerialNumber(),
        getSystemType(),
        getSystemSubtype());
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
