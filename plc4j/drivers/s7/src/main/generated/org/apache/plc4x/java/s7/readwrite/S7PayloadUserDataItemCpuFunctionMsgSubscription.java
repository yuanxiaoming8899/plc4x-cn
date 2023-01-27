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
package org.apache.plc4x.java.s7.readwrite;

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

public class S7PayloadUserDataItemCpuFunctionMsgSubscription extends S7PayloadUserDataItem
    implements Message {

  // Accessors for discriminator values.
  public Byte getCpuFunctionType() {
    return (byte) 0x04;
  }

  public Short getCpuSubfunction() {
    return (short) 0x02;
  }

  public Integer getDataLength() {
    return 0;
  }

  // Properties.
  protected final short Subscription;
  protected final String magicKey;
  protected final AlarmStateType Alarmtype;
  protected final Short Reserve;

  public S7PayloadUserDataItemCpuFunctionMsgSubscription(
      DataTransportErrorCode returnCode,
      DataTransportSize transportSize,
      short Subscription,
      String magicKey,
      AlarmStateType Alarmtype,
      Short Reserve) {
    super(returnCode, transportSize);
    this.Subscription = Subscription;
    this.magicKey = magicKey;
    this.Alarmtype = Alarmtype;
    this.Reserve = Reserve;
  }

  public short getSubscription() {
    return Subscription;
  }

  public String getMagicKey() {
    return magicKey;
  }

  public AlarmStateType getAlarmtype() {
    return Alarmtype;
  }

  public Short getReserve() {
    return Reserve;
  }

  @Override
  protected void serializeS7PayloadUserDataItemChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("S7PayloadUserDataItemCpuFunctionMsgSubscription");

    // Simple Field (Subscription)
    writeSimpleField("Subscription", Subscription, writeUnsignedShort(writeBuffer, 8));

    // Reserved Field (reserved)
    writeReservedField("reserved", (short) 0x00, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (magicKey)
    writeSimpleField("magicKey", magicKey, writeString(writeBuffer, 64));

    // Optional Field (Alarmtype) (Can be skipped, if the value is null)
    writeOptionalEnumField(
        "Alarmtype",
        "AlarmStateType",
        Alarmtype,
        new DataWriterEnumDefault<>(
            AlarmStateType::getValue, AlarmStateType::name, writeUnsignedShort(writeBuffer, 8)),
        (getSubscription()) >= (128));

    // Optional Field (Reserve) (Can be skipped, if the value is null)
    writeOptionalField("Reserve", Reserve, writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("S7PayloadUserDataItemCpuFunctionMsgSubscription");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    S7PayloadUserDataItemCpuFunctionMsgSubscription _value = this;

    // Simple field (Subscription)
    lengthInBits += 8;

    // Reserved Field (reserved)
    lengthInBits += 8;

    // Simple field (magicKey)
    lengthInBits += 64;

    // Optional Field (Alarmtype)
    if (Alarmtype != null) {
      lengthInBits += 8;
    }

    // Optional Field (Reserve)
    if (Reserve != null) {
      lengthInBits += 8;
    }

    return lengthInBits;
  }

  public static S7PayloadUserDataItemBuilder staticParseS7PayloadUserDataItemBuilder(
      ReadBuffer readBuffer, Byte cpuFunctionType, Short cpuSubfunction) throws ParseException {
    readBuffer.pullContext("S7PayloadUserDataItemCpuFunctionMsgSubscription");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short Subscription = readSimpleField("Subscription", readUnsignedShort(readBuffer, 8));

    Short reservedField0 =
        readReservedField("reserved", readUnsignedShort(readBuffer, 8), (short) 0x00);

    String magicKey = readSimpleField("magicKey", readString(readBuffer, 64));

    AlarmStateType Alarmtype =
        readOptionalField(
            "Alarmtype",
            new DataReaderEnumDefault<>(
                AlarmStateType::enumForValue, readUnsignedShort(readBuffer, 8)),
            (Subscription) >= (128));

    Short Reserve =
        readOptionalField("Reserve", readUnsignedShort(readBuffer, 8), (Subscription) >= (128));

    readBuffer.closeContext("S7PayloadUserDataItemCpuFunctionMsgSubscription");
    // Create the instance
    return new S7PayloadUserDataItemCpuFunctionMsgSubscriptionBuilderImpl(
        Subscription, magicKey, Alarmtype, Reserve);
  }

  public static class S7PayloadUserDataItemCpuFunctionMsgSubscriptionBuilderImpl
      implements S7PayloadUserDataItem.S7PayloadUserDataItemBuilder {
    private final short Subscription;
    private final String magicKey;
    private final AlarmStateType Alarmtype;
    private final Short Reserve;

    public S7PayloadUserDataItemCpuFunctionMsgSubscriptionBuilderImpl(
        short Subscription, String magicKey, AlarmStateType Alarmtype, Short Reserve) {
      this.Subscription = Subscription;
      this.magicKey = magicKey;
      this.Alarmtype = Alarmtype;
      this.Reserve = Reserve;
    }

    public S7PayloadUserDataItemCpuFunctionMsgSubscription build(
        DataTransportErrorCode returnCode, DataTransportSize transportSize) {
      S7PayloadUserDataItemCpuFunctionMsgSubscription
          s7PayloadUserDataItemCpuFunctionMsgSubscription =
              new S7PayloadUserDataItemCpuFunctionMsgSubscription(
                  returnCode, transportSize, Subscription, magicKey, Alarmtype, Reserve);
      return s7PayloadUserDataItemCpuFunctionMsgSubscription;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof S7PayloadUserDataItemCpuFunctionMsgSubscription)) {
      return false;
    }
    S7PayloadUserDataItemCpuFunctionMsgSubscription that =
        (S7PayloadUserDataItemCpuFunctionMsgSubscription) o;
    return (getSubscription() == that.getSubscription())
        && (getMagicKey() == that.getMagicKey())
        && (getAlarmtype() == that.getAlarmtype())
        && (getReserve() == that.getReserve())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(), getSubscription(), getMagicKey(), getAlarmtype(), getReserve());
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
