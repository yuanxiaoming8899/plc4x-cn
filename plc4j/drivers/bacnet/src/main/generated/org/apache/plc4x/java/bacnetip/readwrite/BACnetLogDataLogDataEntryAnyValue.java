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
package org.apache.plc4x.java.bacnetip.readwrite;

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

public class BACnetLogDataLogDataEntryAnyValue extends BACnetLogDataLogDataEntry
    implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BACnetConstructedData anyValue;

  public BACnetLogDataLogDataEntryAnyValue(
      BACnetTagHeader peekedTagHeader, BACnetConstructedData anyValue) {
    super(peekedTagHeader);
    this.anyValue = anyValue;
  }

  public BACnetConstructedData getAnyValue() {
    return anyValue;
  }

  @Override
  protected void serializeBACnetLogDataLogDataEntryChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetLogDataLogDataEntryAnyValue");

    // Optional Field (anyValue) (Can be skipped, if the value is null)
    writeOptionalField("anyValue", anyValue, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetLogDataLogDataEntryAnyValue");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetLogDataLogDataEntryAnyValue _value = this;

    // Optional Field (anyValue)
    if (anyValue != null) {
      lengthInBits += anyValue.getLengthInBits();
    }

    return lengthInBits;
  }

  public static BACnetLogDataLogDataEntryBuilder staticParseBACnetLogDataLogDataEntryBuilder(
      ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("BACnetLogDataLogDataEntryAnyValue");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetConstructedData anyValue =
        readOptionalField(
            "anyValue",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetConstructedData.staticParse(
                        readBuffer,
                        (short) (8),
                        (BACnetObjectType) (BACnetObjectType.VENDOR_PROPRIETARY_VALUE),
                        (BACnetPropertyIdentifier)
                            (BACnetPropertyIdentifier.VENDOR_PROPRIETARY_VALUE),
                        (BACnetTagPayloadUnsignedInteger) (null)),
                readBuffer));

    readBuffer.closeContext("BACnetLogDataLogDataEntryAnyValue");
    // Create the instance
    return new BACnetLogDataLogDataEntryAnyValueBuilderImpl(anyValue);
  }

  public static class BACnetLogDataLogDataEntryAnyValueBuilderImpl
      implements BACnetLogDataLogDataEntry.BACnetLogDataLogDataEntryBuilder {
    private final BACnetConstructedData anyValue;

    public BACnetLogDataLogDataEntryAnyValueBuilderImpl(BACnetConstructedData anyValue) {
      this.anyValue = anyValue;
    }

    public BACnetLogDataLogDataEntryAnyValue build(BACnetTagHeader peekedTagHeader) {
      BACnetLogDataLogDataEntryAnyValue bACnetLogDataLogDataEntryAnyValue =
          new BACnetLogDataLogDataEntryAnyValue(peekedTagHeader, anyValue);
      return bACnetLogDataLogDataEntryAnyValue;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetLogDataLogDataEntryAnyValue)) {
      return false;
    }
    BACnetLogDataLogDataEntryAnyValue that = (BACnetLogDataLogDataEntryAnyValue) o;
    return (getAnyValue() == that.getAnyValue()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getAnyValue());
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
