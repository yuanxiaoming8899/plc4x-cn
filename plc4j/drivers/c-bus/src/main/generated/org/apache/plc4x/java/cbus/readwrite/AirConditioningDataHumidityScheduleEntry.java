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
package org.apache.plc4x.java.cbus.readwrite;

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

public class AirConditioningDataHumidityScheduleEntry extends AirConditioningData
    implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final byte zoneGroup;
  protected final HVACZoneList zoneList;
  protected final short entry;
  protected final byte format;
  protected final HVACHumidityModeAndFlags humidityModeAndFlags;
  protected final HVACStartTime startTime;
  protected final HVACHumidity level;
  protected final HVACRawLevels rawLevel;

  public AirConditioningDataHumidityScheduleEntry(
      AirConditioningCommandTypeContainer commandTypeContainer,
      byte zoneGroup,
      HVACZoneList zoneList,
      short entry,
      byte format,
      HVACHumidityModeAndFlags humidityModeAndFlags,
      HVACStartTime startTime,
      HVACHumidity level,
      HVACRawLevels rawLevel) {
    super(commandTypeContainer);
    this.zoneGroup = zoneGroup;
    this.zoneList = zoneList;
    this.entry = entry;
    this.format = format;
    this.humidityModeAndFlags = humidityModeAndFlags;
    this.startTime = startTime;
    this.level = level;
    this.rawLevel = rawLevel;
  }

  public byte getZoneGroup() {
    return zoneGroup;
  }

  public HVACZoneList getZoneList() {
    return zoneList;
  }

  public short getEntry() {
    return entry;
  }

  public byte getFormat() {
    return format;
  }

  public HVACHumidityModeAndFlags getHumidityModeAndFlags() {
    return humidityModeAndFlags;
  }

  public HVACStartTime getStartTime() {
    return startTime;
  }

  public HVACHumidity getLevel() {
    return level;
  }

  public HVACRawLevels getRawLevel() {
    return rawLevel;
  }

  @Override
  protected void serializeAirConditioningDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("AirConditioningDataHumidityScheduleEntry");

    // Simple Field (zoneGroup)
    writeSimpleField("zoneGroup", zoneGroup, writeByte(writeBuffer, 8));

    // Simple Field (zoneList)
    writeSimpleField("zoneList", zoneList, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (entry)
    writeSimpleField("entry", entry, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (format)
    writeSimpleField("format", format, writeByte(writeBuffer, 8));

    // Simple Field (humidityModeAndFlags)
    writeSimpleField(
        "humidityModeAndFlags", humidityModeAndFlags, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (startTime)
    writeSimpleField("startTime", startTime, new DataWriterComplexDefault<>(writeBuffer));

    // Optional Field (level) (Can be skipped, if the value is null)
    writeOptionalField(
        "level",
        level,
        new DataWriterComplexDefault<>(writeBuffer),
        getHumidityModeAndFlags().getIsLevelHumidity());

    // Optional Field (rawLevel) (Can be skipped, if the value is null)
    writeOptionalField(
        "rawLevel",
        rawLevel,
        new DataWriterComplexDefault<>(writeBuffer),
        getHumidityModeAndFlags().getIsLevelRaw());

    writeBuffer.popContext("AirConditioningDataHumidityScheduleEntry");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    AirConditioningDataHumidityScheduleEntry _value = this;

    // Simple field (zoneGroup)
    lengthInBits += 8;

    // Simple field (zoneList)
    lengthInBits += zoneList.getLengthInBits();

    // Simple field (entry)
    lengthInBits += 8;

    // Simple field (format)
    lengthInBits += 8;

    // Simple field (humidityModeAndFlags)
    lengthInBits += humidityModeAndFlags.getLengthInBits();

    // Simple field (startTime)
    lengthInBits += startTime.getLengthInBits();

    // Optional Field (level)
    if (level != null) {
      lengthInBits += level.getLengthInBits();
    }

    // Optional Field (rawLevel)
    if (rawLevel != null) {
      lengthInBits += rawLevel.getLengthInBits();
    }

    return lengthInBits;
  }

  public static AirConditioningDataBuilder staticParseAirConditioningDataBuilder(
      ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("AirConditioningDataHumidityScheduleEntry");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte zoneGroup = readSimpleField("zoneGroup", readByte(readBuffer, 8));

    HVACZoneList zoneList =
        readSimpleField(
            "zoneList",
            new DataReaderComplexDefault<>(() -> HVACZoneList.staticParse(readBuffer), readBuffer));

    short entry = readSimpleField("entry", readUnsignedShort(readBuffer, 8));

    byte format = readSimpleField("format", readByte(readBuffer, 8));

    HVACHumidityModeAndFlags humidityModeAndFlags =
        readSimpleField(
            "humidityModeAndFlags",
            new DataReaderComplexDefault<>(
                () -> HVACHumidityModeAndFlags.staticParse(readBuffer), readBuffer));

    HVACStartTime startTime =
        readSimpleField(
            "startTime",
            new DataReaderComplexDefault<>(
                () -> HVACStartTime.staticParse(readBuffer), readBuffer));

    HVACHumidity level =
        readOptionalField(
            "level",
            new DataReaderComplexDefault<>(() -> HVACHumidity.staticParse(readBuffer), readBuffer),
            humidityModeAndFlags.getIsLevelHumidity());

    HVACRawLevels rawLevel =
        readOptionalField(
            "rawLevel",
            new DataReaderComplexDefault<>(() -> HVACRawLevels.staticParse(readBuffer), readBuffer),
            humidityModeAndFlags.getIsLevelRaw());

    readBuffer.closeContext("AirConditioningDataHumidityScheduleEntry");
    // Create the instance
    return new AirConditioningDataHumidityScheduleEntryBuilderImpl(
        zoneGroup, zoneList, entry, format, humidityModeAndFlags, startTime, level, rawLevel);
  }

  public static class AirConditioningDataHumidityScheduleEntryBuilderImpl
      implements AirConditioningData.AirConditioningDataBuilder {
    private final byte zoneGroup;
    private final HVACZoneList zoneList;
    private final short entry;
    private final byte format;
    private final HVACHumidityModeAndFlags humidityModeAndFlags;
    private final HVACStartTime startTime;
    private final HVACHumidity level;
    private final HVACRawLevels rawLevel;

    public AirConditioningDataHumidityScheduleEntryBuilderImpl(
        byte zoneGroup,
        HVACZoneList zoneList,
        short entry,
        byte format,
        HVACHumidityModeAndFlags humidityModeAndFlags,
        HVACStartTime startTime,
        HVACHumidity level,
        HVACRawLevels rawLevel) {
      this.zoneGroup = zoneGroup;
      this.zoneList = zoneList;
      this.entry = entry;
      this.format = format;
      this.humidityModeAndFlags = humidityModeAndFlags;
      this.startTime = startTime;
      this.level = level;
      this.rawLevel = rawLevel;
    }

    public AirConditioningDataHumidityScheduleEntry build(
        AirConditioningCommandTypeContainer commandTypeContainer) {
      AirConditioningDataHumidityScheduleEntry airConditioningDataHumidityScheduleEntry =
          new AirConditioningDataHumidityScheduleEntry(
              commandTypeContainer,
              zoneGroup,
              zoneList,
              entry,
              format,
              humidityModeAndFlags,
              startTime,
              level,
              rawLevel);
      return airConditioningDataHumidityScheduleEntry;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AirConditioningDataHumidityScheduleEntry)) {
      return false;
    }
    AirConditioningDataHumidityScheduleEntry that = (AirConditioningDataHumidityScheduleEntry) o;
    return (getZoneGroup() == that.getZoneGroup())
        && (getZoneList() == that.getZoneList())
        && (getEntry() == that.getEntry())
        && (getFormat() == that.getFormat())
        && (getHumidityModeAndFlags() == that.getHumidityModeAndFlags())
        && (getStartTime() == that.getStartTime())
        && (getLevel() == that.getLevel())
        && (getRawLevel() == that.getRawLevel())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getZoneGroup(),
        getZoneList(),
        getEntry(),
        getFormat(),
        getHumidityModeAndFlags(),
        getStartTime(),
        getLevel(),
        getRawLevel());
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
