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

public class OpenProtocolMessageApplicationGenericSubscriptionRev1
    extends OpenProtocolMessageApplicationGenericSubscription implements Message {

  // Accessors for discriminator values.
  public Long getRevision() {
    return (long) 1;
  }

  // Properties.
  protected final Mid subscriptionMid;
  protected final long wantedRevision;
  protected final byte[] extraData;

  public OpenProtocolMessageApplicationGenericSubscriptionRev1(
      Long midRevision,
      Short noAckFlag,
      Integer targetStationId,
      Integer targetSpindleId,
      Integer sequenceNumber,
      Short numberOfMessageParts,
      Short messagePartNumber,
      Mid subscriptionMid,
      long wantedRevision,
      byte[] extraData) {
    super(
        midRevision,
        noAckFlag,
        targetStationId,
        targetSpindleId,
        sequenceNumber,
        numberOfMessageParts,
        messagePartNumber);
    this.subscriptionMid = subscriptionMid;
    this.wantedRevision = wantedRevision;
    this.extraData = extraData;
  }

  public Mid getSubscriptionMid() {
    return subscriptionMid;
  }

  public long getWantedRevision() {
    return wantedRevision;
  }

  public byte[] getExtraData() {
    return extraData;
  }

  @Override
  protected void serializeOpenProtocolMessageApplicationGenericSubscriptionChild(
      WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("OpenProtocolMessageApplicationGenericSubscriptionRev1");

    // Simple Field (subscriptionMid)
    writeSimpleEnumField(
        "subscriptionMid",
        "Mid",
        subscriptionMid,
        new DataWriterEnumDefault<>(Mid::getValue, Mid::name, writeUnsignedLong(writeBuffer, 32)),
        WithOption.WithEncoding("ASCII"));

    // Simple Field (wantedRevision)
    writeSimpleField(
        "wantedRevision",
        wantedRevision,
        writeUnsignedLong(writeBuffer, 24),
        WithOption.WithEncoding("ASCII"));

    // Implicit Field (extraDataLength) (Used for parsing, but its value is not stored as it's
    // implicitly given by the objects content)
    int extraDataLength = (int) (COUNT(getExtraData()));
    writeImplicitField(
        "extraDataLength",
        extraDataLength,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithEncoding("ASCII"));

    // Array Field (extraData)
    writeByteArrayField("extraData", extraData, writeByteArray(writeBuffer, 8));

    writeBuffer.popContext("OpenProtocolMessageApplicationGenericSubscriptionRev1");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    OpenProtocolMessageApplicationGenericSubscriptionRev1 _value = this;

    // Simple field (subscriptionMid)
    lengthInBits += 32;

    // Simple field (wantedRevision)
    lengthInBits += 24;

    // Implicit Field (extraDataLength)
    lengthInBits += 16;

    // Array field
    if (extraData != null) {
      lengthInBits += 8 * extraData.length;
    }

    return lengthInBits;
  }

  public static OpenProtocolMessageApplicationGenericSubscriptionBuilder
      staticParseOpenProtocolMessageApplicationGenericSubscriptionBuilder(
          ReadBuffer readBuffer, Long revision) throws ParseException {
    readBuffer.pullContext("OpenProtocolMessageApplicationGenericSubscriptionRev1");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    Mid subscriptionMid =
        readEnumField(
            "subscriptionMid",
            "Mid",
            new DataReaderEnumDefault<>(Mid::enumForValue, readUnsignedLong(readBuffer, 32)),
            WithOption.WithEncoding("ASCII"));

    long wantedRevision =
        readSimpleField(
            "wantedRevision", readUnsignedLong(readBuffer, 24), WithOption.WithEncoding("ASCII"));

    int extraDataLength =
        readImplicitField(
            "extraDataLength", readUnsignedInt(readBuffer, 16), WithOption.WithEncoding("ASCII"));

    byte[] extraData = readBuffer.readByteArray("extraData", Math.toIntExact(extraDataLength));

    readBuffer.closeContext("OpenProtocolMessageApplicationGenericSubscriptionRev1");
    // Create the instance
    return new OpenProtocolMessageApplicationGenericSubscriptionRev1BuilderImpl(
        subscriptionMid, wantedRevision, extraData);
  }

  public static class OpenProtocolMessageApplicationGenericSubscriptionRev1BuilderImpl
      implements OpenProtocolMessageApplicationGenericSubscription
          .OpenProtocolMessageApplicationGenericSubscriptionBuilder {
    private final Mid subscriptionMid;
    private final long wantedRevision;
    private final byte[] extraData;

    public OpenProtocolMessageApplicationGenericSubscriptionRev1BuilderImpl(
        Mid subscriptionMid, long wantedRevision, byte[] extraData) {
      this.subscriptionMid = subscriptionMid;
      this.wantedRevision = wantedRevision;
      this.extraData = extraData;
    }

    public OpenProtocolMessageApplicationGenericSubscriptionRev1 build(
        Long midRevision,
        Short noAckFlag,
        Integer targetStationId,
        Integer targetSpindleId,
        Integer sequenceNumber,
        Short numberOfMessageParts,
        Short messagePartNumber) {
      OpenProtocolMessageApplicationGenericSubscriptionRev1
          openProtocolMessageApplicationGenericSubscriptionRev1 =
              new OpenProtocolMessageApplicationGenericSubscriptionRev1(
                  midRevision,
                  noAckFlag,
                  targetStationId,
                  targetSpindleId,
                  sequenceNumber,
                  numberOfMessageParts,
                  messagePartNumber,
                  subscriptionMid,
                  wantedRevision,
                  extraData);
      return openProtocolMessageApplicationGenericSubscriptionRev1;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OpenProtocolMessageApplicationGenericSubscriptionRev1)) {
      return false;
    }
    OpenProtocolMessageApplicationGenericSubscriptionRev1 that =
        (OpenProtocolMessageApplicationGenericSubscriptionRev1) o;
    return (getSubscriptionMid() == that.getSubscriptionMid())
        && (getWantedRevision() == that.getWantedRevision())
        && (getExtraData() == that.getExtraData())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(), getSubscriptionMid(), getWantedRevision(), getExtraData());
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
