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
package org.apache.plc4x.java.firmata.readwrite;

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

public class SysexCommandReportFirmwareResponse extends SysexCommand implements Message {

  // Accessors for discriminator values.
  public Short getCommandType() {
    return (short) 0x79;
  }

  public Boolean getResponse() {
    return (boolean) true;
  }

  // Properties.
  protected final short majorVersion;
  protected final short minorVersion;
  protected final byte[] fileName;

  public SysexCommandReportFirmwareResponse(
      short majorVersion, short minorVersion, byte[] fileName) {
    super();
    this.majorVersion = majorVersion;
    this.minorVersion = minorVersion;
    this.fileName = fileName;
  }

  public short getMajorVersion() {
    return majorVersion;
  }

  public short getMinorVersion() {
    return minorVersion;
  }

  public byte[] getFileName() {
    return fileName;
  }

  @Override
  protected void serializeSysexCommandChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("SysexCommandReportFirmwareResponse");

    // Simple Field (majorVersion)
    writeSimpleField("majorVersion", majorVersion, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (minorVersion)
    writeSimpleField("minorVersion", minorVersion, writeUnsignedShort(writeBuffer, 8));

    // Manual Array Field (fileName)
    writeManualArrayField(
        "fileName",
        fileName,
        (Byte _value) ->
            org.apache.plc4x.java.firmata.readwrite.utils.StaticHelper.serializeSysexString(
                writeBuffer, _value),
        writeBuffer);

    writeBuffer.popContext("SysexCommandReportFirmwareResponse");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    SysexCommandReportFirmwareResponse _value = this;

    // Simple field (majorVersion)
    lengthInBits += 8;

    // Simple field (minorVersion)
    lengthInBits += 8;

    // Manual Array Field (fileName)
    lengthInBits +=
        org.apache.plc4x.java.firmata.readwrite.utils.StaticHelper.lengthSysexString(fileName) * 8;

    return lengthInBits;
  }

  public static SysexCommandBuilder staticParseSysexCommandBuilder(
      ReadBuffer readBuffer, Boolean response) throws ParseException {
    readBuffer.pullContext("SysexCommandReportFirmwareResponse");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short majorVersion = readSimpleField("majorVersion", readUnsignedShort(readBuffer, 8));

    short minorVersion = readSimpleField("minorVersion", readUnsignedShort(readBuffer, 8));

    byte[] fileName =
        readManualByteArrayField(
            "fileName",
            readBuffer,
            (byte[] _values) ->
                (boolean)
                    (org.apache.plc4x.java.firmata.readwrite.utils.StaticHelper.isSysexEnd(
                        readBuffer)),
            () ->
                (byte)
                    (org.apache.plc4x.java.firmata.readwrite.utils.StaticHelper.parseSysexString(
                        readBuffer)));

    readBuffer.closeContext("SysexCommandReportFirmwareResponse");
    // Create the instance
    return new SysexCommandReportFirmwareResponseBuilderImpl(majorVersion, minorVersion, fileName);
  }

  public static class SysexCommandReportFirmwareResponseBuilderImpl
      implements SysexCommand.SysexCommandBuilder {
    private final short majorVersion;
    private final short minorVersion;
    private final byte[] fileName;

    public SysexCommandReportFirmwareResponseBuilderImpl(
        short majorVersion, short minorVersion, byte[] fileName) {
      this.majorVersion = majorVersion;
      this.minorVersion = minorVersion;
      this.fileName = fileName;
    }

    public SysexCommandReportFirmwareResponse build() {
      SysexCommandReportFirmwareResponse sysexCommandReportFirmwareResponse =
          new SysexCommandReportFirmwareResponse(majorVersion, minorVersion, fileName);
      return sysexCommandReportFirmwareResponse;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SysexCommandReportFirmwareResponse)) {
      return false;
    }
    SysexCommandReportFirmwareResponse that = (SysexCommandReportFirmwareResponse) o;
    return (getMajorVersion() == that.getMajorVersion())
        && (getMinorVersion() == that.getMinorVersion())
        && (getFileName() == that.getFileName())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMajorVersion(), getMinorVersion(), getFileName());
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
